package com.zwh.pay.client;

import com.zwh.BaseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "zwh-pay-provider")
public interface ApplePayClient {

    @RequestMapping(value = "apple/recharge", method = RequestMethod.POST)
    BaseResult<Boolean> recharge(@RequestParam("userId") Long userId, @RequestParam("amount") Double amount);
}
