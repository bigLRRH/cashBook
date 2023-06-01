package com.cashbook.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cashbook.entity.Bill;
import com.cashbook.utils.DBUtils;

public class BillDao {
    /**
     * execute sql statements
     * @param sql
     * @return
     */
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

    /**
     * add a bill
     * @param bill
     * @return
     */
    public int add(Bill bill) {
        // insert into statement
        String sql = "insert into home(name,amount) values('" + bill.getName()
                + "','" + bill.getAmount() + "')";
        return updatesql(sql);
    }

    /**
     * delete a bill
     * @param id
     * @return
     */
    public int delete(int id) {
        // delete statement
        String sql = "delete from home where id='" + id + "'";
        return updatesql(sql);
    }

    /**
     * update a bill
     * @param bill
     * @return
     */
    public int update(Bill bill) {
        // update statement
        String sql = "update home set name='" + bill.getName() + "', amount='"
                + bill.getAmount() + "' where id='" + bill.getId() + "'";
        return updatesql(sql);
    }

    /**
     * get bills by keyword
     * @param keyword
     * @return List<Bill> list
     */
    public List<Bill> query(String keyword) {
        String sql = "select * from home WHERE name LIKE '%" + keyword + "%' OR amount LIKE '%" + keyword
                + "%'OR date LIKE '%" + keyword + "%'";
        List<Bill> list = new ArrayList<>();
        Connection conn = DBUtils.getConn();
        Statement state = null;
        ResultSet rs = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");// id of result
                String name = rs.getString("name");// name of result
                BigDecimal amount = rs.getBigDecimal("amount");// amount of result
                String date = rs.getString("date");// date of result
                Bill bill = new Bill(id, name, amount, date);// construct
                list.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs, state, conn);
        }
        return list;
    }

    /**
     * get bill by id
     * @param id
     * @return Bill bill
     */
    public Bill getBillById(int id) {
        String sql = "select * from home where id ='" + id + "'";
        Connection conn = DBUtils.getConn();
        Statement state = null;
        ResultSet rs = null;
        Bill bill = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                BigDecimal money = rs.getBigDecimal("amount");
                String date = rs.getString("date");
                bill = new Bill(id, name, money, date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs, state, conn);
        }
        return bill;
    }

    /**
     * calculate sum of ammount by id
     * @param id
     * @return BigDecimal sum_of_ammount
     */
    public BigDecimal queryAmountSum(int id) {
        String sql = "select money from home where id <=" + id;
        BigDecimal sum = new BigDecimal("0.00");
        Connection conn = DBUtils.getConn();
        Statement state = null;
        ResultSet rs = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                BigDecimal amount = rs.getBigDecimal("amount");
                // sum = accumulate of amount
                sum = sum.add(amount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs, state, conn);
        }
        return sum;
    }

    /**
     * get all data
     * @return List<Bill> all_bills
     */
    public List<Bill> list() {
        String sql = "select * from home";
        List<Bill> list = new ArrayList<>();
        Connection conn = DBUtils.getConn();
        Statement state = null;
        ResultSet rs = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            Bill bill = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                BigDecimal sum = queryAmountSum(id);
                String name = rs.getString("name");
                BigDecimal amount = rs.getBigDecimal("amount");
                String date = rs.getString("date");
                bill = new Bill(id, name, amount, date, sum);
                list.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs, state, conn);
        }
        return list;
    }
}
