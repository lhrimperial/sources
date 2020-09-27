package com.github.sources.lottery.valobj;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author hairen.long
 * @date 2019-03-28
 */
public class AwardPool {

    /** 奖池支持的城市 */
    private String cityIds;
    /** 奖池支持的得分*/
    private String scores;
    /** 奖池匹配的用户类型*/
    private int userGroupType;
    /** 奖池中包含的奖品*/
    private List<Awrad> awards;

    /** 当前奖池是否与城市匹配*/
    public boolean matchedCity(int cityId) {
        return true;
    }

    /** 当前奖池是否与用户得分匹配*/
    public boolean matchedScore(int score) {
        return true;
    }

    /** 根据概率选择奖池*/
    public Awrad randomGetAward() {
        int sumOfProbablity = 0;
        for (Awrad award : awards) {
            sumOfProbablity += award.getAwardProbablity();
        }
        int randomNumber = ThreadLocalRandom.current().nextInt(sumOfProbablity);
        int range = 0;
        for (Awrad award : awards) {
            range += award.getProbablity();
            if (randomNumber < range) {
                return award;
            }
        }
        return null;
    }
}
