package com.qiuhui.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class SaveTest {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql:///kaishengit","root","929813");

            String sql = "{call p_6(?,?,?)}";
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1,"ANV01");
            callableStatement.setFloat(2,5.89F);
            callableStatement.registerOutParameter(3,Types.INTEGER);

            callableStatement.executeUpdate();

            int count = callableStatement.getInt(3);
            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
