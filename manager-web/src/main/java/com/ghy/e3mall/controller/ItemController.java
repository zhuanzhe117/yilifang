package com.ghy.e3mall.controller;

import com.ghy.e3mall.common.EasyUIDataGridResult;
import com.ghy.e3mall.iservice.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * (TbItem)表控制层
 *
 * @author makejava
 * @since 2020-12-07 21:37:42
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public EasyUIDataGridResult getItemList(int page,int rows){
        EasyUIDataGridResult result = itemService.getItemList(page,rows);
        logger.info("controller结果 " + result.getRows().size());
        return result;
    }

}