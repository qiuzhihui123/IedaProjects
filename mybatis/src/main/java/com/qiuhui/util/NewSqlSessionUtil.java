package com.qiuhui.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class NewSqlSessionUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("batis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(boolean autoCommit){
        return sqlSessionFactory.openSession(autoCommit);
    }

}
