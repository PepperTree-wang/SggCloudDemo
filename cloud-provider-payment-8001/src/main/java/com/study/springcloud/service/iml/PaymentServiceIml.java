package com.study.springcloud.service.iml;

import com.study.springcloud.dao.PaymentDao;
import com.study.springcloud.entities.Payment;
import com.study.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceIml implements PaymentService {
    @Resource
    private PaymentDao paymentDao;


    public  int create(Payment payment){
        return paymentDao.create(payment);
    }
    public  Payment getPaymentById(@Param("id") Long id){
        return paymentDao.getPaymentById(id);
    }
}
