package com.example.rabbitmqconsumer;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiver {


    @RabbitHandler
    public void process(Map testMessage)
    {
        try {
            //Thread.sleep(1);
            System.out.println("DirectReceiver消费者收到消息 第一个: " + testMessage.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
