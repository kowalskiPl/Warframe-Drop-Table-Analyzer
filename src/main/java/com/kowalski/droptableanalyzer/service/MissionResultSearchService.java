package com.kowalski.droptableanalyzer.service;

import com.kowalski.droptableanalyzer.model.MissionRewards;
import com.kowalski.droptableanalyzer.model.RewardSearchResult;
import com.kowalski.droptableanalyzer.utils.HTMLParser;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MissionResultSearchService {
    private static final String dataURL = "https://n8k6e2y6.ssl.hwcdn.net/repos/hnfvc0o3jnfvc873njb03enrf56.html";
    public Set<RewardSearchResult> searchByDropName(String dropName) throws IOException {
        Set<RewardSearchResult> resultSet = new LinkedHashSet<>();
        Set<MissionRewards> missionRewards = queryAllRewards();

        missionRewards.forEach(reward -> {
            Optional<RewardSearchResult> searchResult = reward.searchReward(dropName);
            searchResult.ifPresent(resultSet::add);
        });
        return resultSet;
    }

    private Set<MissionRewards> queryAllRewards() throws IOException {
        HTMLParser parser = new HTMLParser(dataURL);
        return parser.parseMissionRewards();
    }
}
