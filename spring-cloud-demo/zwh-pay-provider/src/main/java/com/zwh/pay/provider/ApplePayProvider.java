package com.zwh.pay.provider;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zwh.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApplePayProvider {

    private static final Logger log = LoggerFactory.getLogger(ApplePayProvider.class);


    @HystrixCommand(fallbackMethod = "rechargeFallBack", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    @PostMapping(value = "apple/recharge")
    public BaseResult<Boolean> rechare(Long userId, Double amount) throws Exception {

        log.info("apple recharge {}", amount);

        return new BaseResult<Boolean>(true);
    }

    private BaseResult<Boolean> rechargeFallBack(Long userId, Double amount, Throwable e) {
        log.error("user:{},apple recharge amount:{}, fail :{}", userId, amount, e.getMessage(), e);
        return new BaseResult<Boolean>(false, e.getMessage());
    }
}
