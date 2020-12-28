package com.ghy.e3mall.iservice;

import com.ghy.e3mall.entity.TbOrder;

import java.util.List;


/**
 * (TbOrder)表服务接口
 *
 * @author makejava
 * @since 2020-12-07 11:46:11
 */
public interface TbOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param 主键
     * @return 实例对象
     */
    TbOrder queryById(int id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbOrder> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    TbOrder insert(TbOrder tbOrder);

    /**
     * 修改数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    TbOrder update(TbOrder tbOrder);

    /**
     * 通过主键删除数据
     *
     * @param 主键
     * @return 是否成功
     */
    boolean deleteById();

}