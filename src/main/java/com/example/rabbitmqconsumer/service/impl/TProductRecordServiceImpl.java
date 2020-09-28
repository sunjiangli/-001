package com.example.rabbitmqconsumer.service.impl;

import com.example.rabbitmqconsumer.dao.TProductRecordDao;
import com.example.rabbitmqconsumer.entity.TProductRecord;
import com.example.rabbitmqconsumer.service.TProductRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TProductRecord)表服务实现类
 *
 * @author makejava
 * @since 2020-09-27 10:46:51
 */
@Service("tProductRecordService")
public class TProductRecordServiceImpl implements TProductRecordService {
    @Resource
    private TProductRecordDao tProductRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TProductRecord queryById(Integer id) {
        return this.tProductRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TProductRecord> queryAllByLimit(int offset, int limit) {
        return this.tProductRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tProductRecord 实例对象
     * @return 实例对象
     */
    @Override
    public TProductRecord insert(TProductRecord tProductRecord) {
        this.tProductRecordDao.insert(tProductRecord);
        return tProductRecord;
    }

    /**
     * 修改数据
     *
     * @param tProductRecord 实例对象
     * @return 实例对象
     */
    @Override
    public TProductRecord update(TProductRecord tProductRecord) {
        this.tProductRecordDao.update(tProductRecord);
        return this.queryById(tProductRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tProductRecordDao.deleteById(id) > 0;
    }
}