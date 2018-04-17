package com.kaishengit.tms.shiro;

import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


public class MyShiroRealm extends AuthorizingRealm{
    @Autowired
    private AccountService accountService;

    @Value("${salt}")
    private String salt;

    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String accountMobile = usernamePasswordToken.getUsername();
        String requestIp = usernamePasswordToken.getHost();
        System.out.println(salt);
        if(accountMobile != null){
            Account account = accountService.findAccountByMobile(accountMobile);
            if(account == null){
                throw new UnknownAccountException("找不到该帐号" + accountMobile);
            }else {
                if(Account.STATE_NORMAL.equals(account.getAccountStatus())){
                    logger.info("登录成功,{}",account);
                    accountService.addLoginLog(account,requestIp);
                    return new SimpleAuthenticationInfo(account, account.getAccountPassword(),getName());
                }else {
                    throw new LockedAccountException("帐号被锁定或禁用"+ account);
                }
            }
        }
        return null;

    }
}
