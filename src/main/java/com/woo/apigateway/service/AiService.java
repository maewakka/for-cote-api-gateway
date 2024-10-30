package com.woo.apigateway.service;

import com.woo.apigateway.dto.ais.OptimizeReqDto;
import com.woo.apigateway.entity.User;
import com.woo.apigateway.entity.UserAssistCount;
import com.woo.apigateway.feign.AiApiClient;
import com.woo.apigateway.repository.UserAssistCountRepository;
import com.woo.apigateway.repository.UserRepository;
import com.woo.exception.util.BizException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AiService {

    private final AiApiClient aiApiClient;
    private final UserRepository userRepository;
    private final UserAssistCountRepository userAssistCountRepository;

    @Transactional
    public String optimizeCode(User user, OptimizeReqDto reqDto) {

        UserAssistCount userAssistCount = userAssistCountRepository.findUserAssistCountByUser(user);

        if(userAssistCount.getCount() >= 1) {
            String result = aiApiClient.optimizeCode(reqDto);
            userAssistCount.useCount();
            userRepository.save(user);
            return result;
        } else {
            throw new BizException("exhaust_all_count");
        }
    }

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void initialAllCount() {
        userAssistCountRepository.findAll().forEach(UserAssistCount::initialCount);
    }
}
