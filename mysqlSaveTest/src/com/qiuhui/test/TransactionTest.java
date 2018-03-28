package com.qiuhui.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Savepoint;

public class TransactionTest {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///kaishengit","root","929813");

            conn.setAutoCommit(false);

            String sql = "delete from t_user where id = ?";
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1,13);
            pstat.executeUpdate();

            Savepoint savePoint = conn.setSavepoint("s1");

            PreparedStatement pstat2 = conn.prepareStatement(sql);
            pstat2.setInt(1,14);

            conn.rollback(savePoint);

            conn.commit();


        } catch (Exception e){
            e.printStackTrace();
        }
    }



}
