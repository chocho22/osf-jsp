package com.osf.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osf.test.service.CommonCodeService;
import com.osf.test.service.TransService;
import com.osf.test.service.impl.CommonCodeServiceImpl;
import com.osf.test.service.impl.TransServiceImpl;

public class TransServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommonCodeService ccs = new CommonCodeServiceImpl();
	private TransService ts = new TransServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher rd = request.getRequestDispatcher("/views/transfer/trans.jsp");
		request.setAttribute("ccList", ccs.selectCommonCodeList("trans"));
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String source = request.getParameter("source");
		String target = request.getParameter("target");
		String text = request.getParameter("text");
		request.setAttribute("rMap", ts.transferText(source, target, text));
		
		doGet(request, response);
	}
}
