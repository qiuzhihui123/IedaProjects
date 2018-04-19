package com.kaishengit.tms.service.impl;


import com.kaishengit.tms.entity.TicketOfficeAccount;
import com.kaishengit.tms.entity.TicketOfficeInfermation;
import com.kaishengit.tms.entity.TicketOfficeInfermationExample;
import com.kaishengit.tms.mapper.TicketOfficeAccountMapper;
import com.kaishengit.tms.mapper.TicketOfficeInfermationMapper;
import com.kaishengit.tms.service.TicketOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Description:处理售票点先关service的实现类
 *@Author: 邱志辉
 *@Date 2016/4/19 0019下午 4:42
 */
@Service
public class TicketOfficeServiceImpl implements TicketOfficeService {

    @Autowired
    TicketOfficeInfermationMapper ticketOfficeInfermationMapper;
    @Autowired
    TicketOfficeAccountMapper ticketOfficeAccountMapper;



    /**
     * @描述: 查询出所有的售票点对象返回
     * @参数:[]
     * @返回值java.util.List<com.kaishengit.tms.entity.TicketOfficeInfermation> 售票点的List集合
     */
    @Override
    public List<TicketOfficeInfermation> findAllTicketOffices() {
        TicketOfficeInfermationExample ticketOfficeInfermationExample = new TicketOfficeInfermationExample();
        return ticketOfficeInfermationMapper.selectByExample(ticketOfficeInfermationExample);
    }
}
