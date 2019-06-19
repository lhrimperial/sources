package com.github.sources.distributed.pessimism;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
public class PessimismLock {

    public static void main(String[] args){
        final int THREAD_COUNT = 10;
        final int RUN_TIME = 100;

        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i=0;i<RUN_TIME;i++) {
            service.submit(new PessimismTask());
        }

        service.shutdown();
        System.out.println("finish all task");
    }

    public static class PessimismTask implements Runnable {

        @Override
        public void run() {
            Connection conn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=UTF-8","root", "root");
                System.out.println("connection finish");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

            try {
                conn.setAutoCommit(false);
                //读的时候一并读出version
                PreparedStatement ps =conn.prepareStatement("select * from LostUpdate where id =1 for update");
                ResultSet rs=ps.executeQuery();
                int count = 0;
                int version = 0;
                while(rs.next()){
                    count= rs.getInt("count");
                    version= rs.getInt("version");
                }

                count++;

                ps =conn.prepareStatement("update LostUpdate set count=? where id =1");
                ps.setInt(1, count);
                int result = ps.executeUpdate();

                //检查有无因冲突导致执行失败
                //成功，则commit，完成任务
                if(result>0) {
                    conn.commit();
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
    }

}
