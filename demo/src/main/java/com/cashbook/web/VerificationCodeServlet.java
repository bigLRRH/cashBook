package com.cashbook.web;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.cashbook.utils.VerificationCodeGenerator;

public class VerificationCodeServlet extends HttpServlet {
    private VerificationCodeGenerator verificationCodeGenerator;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String VerificationCode = verificationCodeGenerator.getVerificationCode();
        request.getSession().setAttribute("VerificationCode", VerificationCode);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
