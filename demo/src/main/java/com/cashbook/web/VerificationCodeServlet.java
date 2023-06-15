package com.cashbook.web;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.cashbook.utils.VerificationCodeGenerator;

public class VerificationCodeServlet extends HttpServlet {
    private VerificationCodeGenerator verificationCodeGenerator;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "reset":
                VerificationCode_reset(request, response);
                break;
            case "verify":
                VerificationCode_verify(request, response);
                break;
            default:
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    private void VerificationCode_reset(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        verificationCodeGenerator = new VerificationCodeGenerator();
        String VerificationCode = verificationCodeGenerator.getVerificationCode();
        request.getSession().setAttribute("VerificationCode", VerificationCode);
        //返回响应
        response.setStatus(200);
        response.setHeader("VerificationCode",VerificationCode);
        response.getWriter().write(VerificationCode);
    }

    private void VerificationCode_verify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String answer = request.getParameter("answer");
        String VerificationCode = (String) request.getSession().getAttribute("VerificationCode");
        if (answer.equals(VerificationCode))
        {
            response.setHeader("verify","true");
            request.getRequestDispatcher("/ls").forward(request, response);
            response.getWriter().write("true");
        }
        else
        {
            response.setHeader("verify","false");
            response.getWriter().write("false");
        }
    }
}
