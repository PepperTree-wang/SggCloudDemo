package com.study.springcloud.controller;

import com.study.springcloud.entities.CommonResult;
import com.study.springcloud.entities.Payment;
import com.study.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("insert result "+ result);
        if (result > 0){
            return new CommonResult(200,"success",result);
        }else {
            return new CommonResult(444,"fail",null);

        }

    }

    @RequestMapping(value = "/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id ){
        Payment p = paymentService.getPaymentById(id);
        log.info("select result "+ p);
        if (p != null){
            return new CommonResult(200,"success",p);
        }else {
            return new CommonResult(444,"fail",null);

        }

    }
}
