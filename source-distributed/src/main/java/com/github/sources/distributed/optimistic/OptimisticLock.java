package com.github.sources.distributed.optimistic;

import java.sql.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 乐观锁
 */
public class OptimisticLock {

    public static void main(String[] args) throws Exception{
        final int THREAD_COUNT = 10;
        final int RUN_TIME = 100;

        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch count = new CountDownLatch(RUN_TIME);

        for (int i=0;i<RUN_TIME;i++) {
            service.submit(new LostUpdateOccDiscard(count));
        }

        count.await();
        service.shutdown();
        System.out.println("finish all task");
    }


    public static class LostUpdateOccDiscard implements Runnable{
        private CountDownLatch latch;
        private int spinCount = 0;

        public LostUpdateOccDiscard(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            Connection conn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=UTF-8",
                        "root", "root");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            /**
             * 自旋操作
             */
            while (true) {
                try {
                    if (spinCount++ > 10) {
                        break;
                    }
                    conn.setAutoCommit(false);
                    //读的时候一并读出version
                    PreparedStatement ps =conn.prepareStatement("select * from LostUpdate where id =1");
                    ResultSet rs=ps.executeQuery();
                    int count = 0;
                    int version = 0;
                    while(rs.next()){
                        count= rs.getInt("count");
                        version= rs.getInt("version");
                    }

                    count++;

                    //更新操作，用cas原子操作来更新
                    ps =conn.prepareStatement("update LostUpdate set count=?, version=version+1 where id =1 and version=?");
                    ps.setInt(1, count);
                    ps.setInt(2, version);
                    int result = ps.executeUpdate();

                    //检查有无因冲突导致执行失败
                    //成功，则commit，完成任务
                    if(result>0) {
                        conn.commit();
                        break;
                    } else {//失败，回滚，抛异常提醒调用者出现冲突。
                        conn.rollback();
                        throw new Exception("更新count出现冲突");
                    }
                } catch (SQLException e) {
                    try {
                        conn.rollback();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            //表示一次任务完成
            latch.countDown();
        }
    }
}
