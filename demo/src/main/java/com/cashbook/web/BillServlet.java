package com.cashbook.web;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.cashbook.entity.Bill;
import com.cashbook.service.BillService;
import com.cashbook.utils.WebUtils;

public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;// 不知道是什么
	private BillService billService = new BillService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
			case "add":
				add(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			case "list":
				list(request, response);
				break;
			case "getBillById":
				getBillById(request, response);
				break;
			case "query":
				query(request, response);
				break;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		BigDecimal amount = WebUtils.bigdecimal(request.getParameter("amount"), new BigDecimal(0.00));
		Bill bill = new Bill(name, amount);
		if (billService.add(bill) == 1) {
			response.sendRedirect(request.getContextPath() + "/manager/homeCostServlet?action=list");
		} else {
			request.setAttribute("msg", "add failed,please contact administrator");
			request.setAttribute("bill", bill);
			request.getRequestDispatcher("/cost_edit.jsp").forward(request, response);
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = WebUtils.parseInt(request.getParameter("id"), 0);
		if (billService.delete(id) == 1) {
			response.sendRedirect(request.getContextPath() + "/manager/homeCostServlet?action=list");
		} else {
			request.setAttribute("msg", "delete failed,please contact administrator");
			request.getRequestDispatcher("/manager/homeCostServlet?action=list").forward(request, response);
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = WebUtils.parseInt(request.getParameter("id"), 0);
		String name = request.getParameter("name");
		BigDecimal money = WebUtils.bigdecimal(request.getParameter("amount"), new BigDecimal(0.00));
		String date = request.getParameter("date");
		Bill bill = new Bill(id, name, money, date);
		if (billService.update(bill) == 1) {
			response.sendRedirect(request.getContextPath() + "/manager/homeCostServlet?action=list");
		} else {
			request.setAttribute("msg", "update failed, please contact administrator");
			request.setAttribute("bill", bill);
			request.getRequestDispatcher("/cost_edit.jsp").forward(request, response);
		}
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bill> bills = billService.list();
		request.setAttribute("bill", bills);
		request.getRequestDispatcher("/manager.jsp").forward(request, response);

	}

	private void getBillById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = WebUtils.parseInt(request.getParameter("id"), 0);
		Bill bill = billService.getHomeCostById(id);
		request.setAttribute("bill", bill);
		request.getRequestDispatcher("/cost_edit.jsp").forward(request, response);
	}

	protected void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		List<Bill> bill = billService.query(keyword);
		request.setAttribute("bill", bill);
		request.getRequestDispatcher("/query.jsp").forward(request, response);
	}
}
