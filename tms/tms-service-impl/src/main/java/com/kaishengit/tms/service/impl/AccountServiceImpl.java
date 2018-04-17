package com.kaishengit.tms.service.impl;

import com.kaishengit.tms.entity.*;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.AccountLoginLogMapper;
import com.kaishengit.tms.mapper.AccountMapper;
import com.kaishengit.tms.mapper.AccountRolesMapper;
import com.kaishengit.tms.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 *@Description: AccountService接口的实现类
 *@Author: 邱志辉
 *@Date 2016/4/13 0013下午 2:52
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountLoginLogMapper accountLoginLogMapper;

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Value("${salt}")
    private String salt;

    @Autowired
    private AccountRolesMapper accountRolesMapper;


    /**
     * 描述:查找所有account
     *
     * @参数:[]
     * @返回值java.util.List<com.kaishengit.tms.entity.Account>
     */
    @Override
    public List<Account> findAllAccounts() {
        AccountExample accountExample = new AccountExample();
        return accountMapper.selectByExample(accountExample);
    }

    /**
     * 描述:查询所有account以及他们的角色
     *
     * @参数:[]
     * @返回值java.util.List<com.kaishengit.tms.entity.Account>
     */
    @Override
    public List<Account> findAllAccountsWithRoles() {
        System.out.println(salt);
        return accountMapper.findAllAccountWithRoles();

    }

    /**
     * 描述:保存account以及帐号角色关联关系
     *
     * @param account
     * @param rolesIds
     * @参数:[account, rolesId]
     * @返回值void
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveAccount(Account account, Integer[] rolesIds) {
        System.out.println(account);
        //电话后六位设为密码
        String accountMobile = account.getAccountMobile();
        System.out.println((accountMobile.length()-Account.MOBILE_LAST_SIX_NUMBER) + "...........");
        String password = accountMobile.substring(accountMobile.length()-Account.MOBILE_LAST_SIX_NUMBER);

        account.setAccountPassword(DigestUtils.md5Hex(password + salt));

        //初始状态为正常
        account.setAccountStatus(Account.STATE_NORMAL);
        //设置更新时间
        account.setUpdateTime(new Date());

        //有选择的插入account如果有属性为null则不插入
        accountMapper.insertSelective(account);

        //添加帐号和角色对应的关系
        AccountRolesExample accountRolesExample = new AccountRolesExample();
        if(rolesIds != null) {
            for (Integer roleId : rolesIds) {
                AccountRolesKey accountRolesKey = new AccountRolesKey();
                accountRolesKey.setAccountId(account.getId());
                accountRolesKey.setRolesId(roleId);
                accountRolesMapper.insert(accountRolesKey);
            }
        }

        logger.info("新增帐号,{}",account);
    }

    /**
     * @param id
     * @描述:查找account并封装rolesList集合在相应属性上
     * @参数:[id(account的id)]
     * @返回值com.kaishengit.tms.entity.Account
     */
    @Override
    public Account findAccountWithRoles(Integer id) {
        return accountMapper.findAccountWithRoles(id);
    }

    /**
     * @param accountMobile
     * @描述:根据mobile查找account对象
     * @参数:[accountMobile] mobile
     * @返回值com.kaishengit.tms.entity.Account account对象
     */
    @Override
    public Account findAccountByMobile(String accountMobile) {
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andAccountMobileEqualTo(accountMobile);

        return accountMapper.selectByExample(accountExample).get(0);

    }

    /**
     * @param account
     * @param requestIp
     * @描述: 根据登录的account以及ip记录登录日志
     * @参数:[account] 登录的account 以及登录的ip
     * @返回值void
     */
    @Override
    public void addLoginLog(Account account, String requestIp) {
        AccountLoginLog accountLoginLog = new AccountLoginLog();
        accountLoginLog.setLoginTime(new Date());
        accountLoginLog.setAccountId(account.getId());
        accountLoginLog.setLoginIp(requestIp);
        accountLoginLogMapper.insertSelective(accountLoginLog);
    }
}


