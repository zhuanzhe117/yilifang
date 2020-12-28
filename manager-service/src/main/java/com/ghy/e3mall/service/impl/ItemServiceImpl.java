package com.ghy.e3mall.service.impl;
import com.ghy.e3mall.common.EasyUIDataGridResult;
import com.ghy.e3mall.entity.Item;
import com.ghy.e3mall.dao.ItemDao;

import com.ghy.e3mall.iservice.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (TbItem)表服务实现类
 *
 * @author makejava
 * @since 2020-12-07 11:46:03
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Item queryById(Integer id) {
        return this.itemDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Item> queryAllByLimit(int offset, int limit) {
        return this.itemDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param item 实例对象
     * @return 实例对象
     */
    @Override
    public Item insert(Item item) {
        this.itemDao.insert(item);
        return item;
    }

    /**
     * 修改数据
     *
     * @param item 实例对象
     * @return 实例对象
     */
    @Override
    public Item update(Item item) {
        this.itemDao.update(item);
        return this.queryById(item.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.itemDao.deleteById(id) > 0;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Item> itemList = itemDao.queryAll(new Item());
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(itemList);

        PageInfo<Item> pageInfo = new PageInfo<>(itemList);
        long total = pageInfo.getTotal();
        result.setTotal(total);

        logger.info("查询item列表数据：" + itemList.toString());
        return result;
    }
}