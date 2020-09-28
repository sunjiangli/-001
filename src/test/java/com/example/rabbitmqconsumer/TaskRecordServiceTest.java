package com.example.rabbitmqconsumer;

import com.example.rabbitmqconsumer.entity.TProduct;
import com.example.rabbitmqconsumer.service.TProductService;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ComponentScan(basePackages = {"com.example.rabbitmqconsumer.dao"})
public class TaskRecordServiceTest {
    @Autowired
    private TProductService tProductService;

    @Test
    public void insertTest(){
        TProduct tProduct  = new TProduct() ;
        tProduct.setTotal(100);
        tProduct.setProductno("232No121211");
        tProductService.insert(tProduct);
    }

}
