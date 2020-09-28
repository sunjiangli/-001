package com.example.rabbitmqconsumer.controller;

import com.example.rabbitmqconsumer.entity.TProductRecord;
import com.example.rabbitmqconsumer.service.TProductRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (TProductRecord)表控制层
 *
 * @author makejava
 * @since 2020-09-27 10:46:52
 */
@RestController
@RequestMapping("tProductRecord")
public class TProductRecordController {
    /**
     * 服务对象
     */
    @Resource
    private TProductRecordService tProductRecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TProductRecord selectOne(Integer id) {
        return this.tProductRecordService.queryById(id);
    }

}