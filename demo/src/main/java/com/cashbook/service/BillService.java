package com.cashbook.service;

import java.util.List;

import com.cashbook.entity.Bill;
import com.cashbook.dao.BillDao;

public class BillService {
    BillDao billDao = new BillDao();

	public int add(Bill bill) {
		return billDao.add(bill);
	}
	
	public int delete(int id) {
		return billDao.delete(id);
	}
	
	public int update(Bill bill) {
		return billDao.update(bill);
	}
	
	public List<Bill> query(String keyword) {
		return billDao.query(keyword);
	}
	
	public List<Bill> list() {
		return billDao.list();
	}
	
	public Bill getHomeCostById(int id) {
		return billDao.getBillById(id);
	}
}
