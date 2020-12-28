package com.ghy.e3mall.dao;

import com.ghy.e3mall.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * (TbItem)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-07 11:46:02
 */
public interface ItemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Item queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Item> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param item 实例对象
     * @return 对象列表
     */
    List<Item> queryAll(Item item);

    /**
     * 新增数据
     *
     * @param item 实例对象
     * @return 影响行数
     */
    int insert(Item item);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbItem> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Item> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbItem> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Item> entities);

    /**
     * 修改数据
     *
     * @param item 实例对象
     * @return 影响行数
     */
    int update(Item item);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}