package com.example.rabbitmqconsumer.controller;

import com.example.rabbitmqconsumer.entity.TProduct;
import com.example.rabbitmqconsumer.entity.TProductRecord;
import com.example.rabbitmqconsumer.service.TProductRecordService;
import com.example.rabbitmqconsumer.service.TProductService;
import com.example.rabbitmqconsumer.service.impl.TProductRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RabbitController {


    @Autowired
    TProductService tProductService  ;

    TProductRecordService tProductRecordService  =new TProductRecordServiceImpl();

    public void robbingProduct(Integer userId){
        TProduct tProduct = tProductService.queryById(1);
        TProductRecord tProductRecord = new TProductRecord() ;
        if (tProduct != null && tProduct.getTotal() > 0) {
            //更新库存表，库存量减少1。返回1说明更新成功。返回0说明库存已经为0
            TProduct update = tProductService.update(tProduct);
            Integer total = update.getTotal();
            if(total>0){
                //插入记录
                tProductRecord.setProductno("No123321");
                tProductRecord.setUserid(userId);
                tProductRecordService.insert(tProductRecord);
                //发送短信
                System.out.println("用户{}抢单成功"+userId);
            }else {
                System.out.println("用户{}抢单失败"+userId);

            }
        } else {
            System.out.println("用户{}抢单失败"+userId);
        }

    }
}
