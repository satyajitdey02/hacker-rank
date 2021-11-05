package com.skill.test.discovery.task3;

public enum PartnerLevel {
    ANT(1, 5),
    BEE(10, 7),
    CAT(50, 9),
    DOG(200, 12),
    ELEPHANT(1000, 19);

    private final int startingFrom;
    private final int annualRewardPerContract;

    private PartnerLevel(int startingFrom, int annualRewardPerContract) {
        this.startingFrom = startingFrom;
        this.annualRewardPerContract = annualRewardPerContract;
    }

    public int getStartingFrom() {
        return startingFrom;
    }

    public int getAnnualRewardPerContract() {
        return annualRewardPerContract;
    }
}
