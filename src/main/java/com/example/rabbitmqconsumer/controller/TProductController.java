package com.example.rabbitmqconsumer.controller;


import com.example.rabbitmqconsumer.entity.TProduct;
import com.example.rabbitmqconsumer.service.TProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (TProduct)表控制层
 *
 * @author makejava
 * @since 2020-09-27 10:45:55
 */
@RestController
@RequestMapping("tProduct")
public class TProductController {
    /**
     * 服务对象
     */
    @Resource
    private TProductService tProductService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TProduct selectOne(Integer id) {
        return this.tProductService.queryById(id);
    }

}