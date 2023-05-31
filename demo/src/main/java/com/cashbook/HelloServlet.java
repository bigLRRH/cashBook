package com.cashbook;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charaset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>");
        writer.print("Hello CSDN, I'm byr from VScode.");
        writer.print("<br>");
        writer.print("你好CSDN,我是用VScode的北邮人。");
        writer.print("</h1>");
        req.setAttribute("HelloServlet", writer);
    }
}