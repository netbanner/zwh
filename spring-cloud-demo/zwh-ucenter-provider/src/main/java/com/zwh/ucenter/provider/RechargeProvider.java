package com.zwh.ucenter.provider;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zwh.BaseResult;
import com.zwh.entity.User;
import com.zwh.pay.client.ApplePayClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RechargeProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(RechargeProvider.class);

    @Resource
    private UserManager userManager;

    @Resource
    private ApplePayClient applePayClient;

    @HystrixCommand(fallbackMethod = "rechargeFallback")
    @RequestMapping(value = "/recharge",method = RequestMethod.POST)
    public BaseResult<Boolean> recharge(@RequestParam("userId") Long userId,@RequestParam("amount") Double amount,@RequestParam("type") String type){

    //    BaseResult<Boolean> result = applePayClient.recharge(userId,amount);


        User user = userManager.getByUserId(userId);
        LOGGER.info("user {} recharge  res:{}", user.getUsername(), "");
        return null;
    }

    private BaseResult<Boolean> rechargeFallback(Long userId,Double amount,String type,Throwable throwable){
        LOGGER.error("user:{} recharge,amount:{},type:{}, fail:{}", userId, amount, type, throwable.getMessage(), throwable);
        return new BaseResult<Boolean>(false, throwable.getMessage());
    }
}
