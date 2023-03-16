package com.kowalski.droptableanalyzer.model;

import lombok.Data;

@Data
public class RewardSearchResult {
    private String missionName;
    private String missionType;
    private String planet;
    private Reward rewardA;
    private Reward rewardB;
    private Reward rewardC;
}
