package com.kaishengit.tms.service;

import com.kaishengit.tms.entity.TicketOfficeInfermation;

import java.util.List;

/**
 *@Description:关于售票点的service接口
 *@Author: 邱志辉
 *@Date 2016/4/19 0019下午 4:39
 */
public interface TicketOfficeService {

    /**
     *@描述: 查询出所有的售票点对象返回
     *@参数:[]
     *@返回值java.util.List<com.kaishengit.tms.entity.TicketOfficeInfermation> 售票点的List集合
     */
    List<TicketOfficeInfermation> findAllTicketOffices();
}
