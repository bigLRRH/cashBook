package com.cashbook.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.cashbook.entity.User;
import com.cashbook.utils.DBUtils;

public class UserDao {
    public int updatesql(String sql) {
        Connection conn = DBUtils.getConn();// get connection
        Statement state = null;
        try {
            state = conn.createStatement();
            return state.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(state, conn);
        }
        return -1;
    }

    public int add(User user) {
        String sql = "insert into users(username,password,mobileNumber) values'" + user.getMobileNumber() + "','"
                + user.getUsername() + "','" + user.getPassword() + "')";
        return updatesql(sql);
    }

    public int delete(User user) {
        // delete statement
        String sql = "delete from users where username='" + user.getUsername() + "'";
        return updatesql(sql);
    }

    public User getUserByUsername(String _username){
        String sql = "select * from users where username ='" + _username + "'";
        Connection conn = DBUtils.getConn();
        Statement state = null;
        ResultSet rs = null;
        User user = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String mobileNumber = rs.getString("mobileNumber");
                user = new User(username,password,mobileNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs, state, conn);
        }
        return user;
    }
}
