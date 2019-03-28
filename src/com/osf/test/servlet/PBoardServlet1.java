package com.osf.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osf.test.service.PBoardService;
import com.osf.test.service.impl.PBoardServiceImpl;

/**
 * Servlet implementation class PBoardServlet1
 */
@WebServlet("/PBoardServlet1")
public class PBoardServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PBoardService pbs = new PBoardServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
	      uri = uri.replace("/photo/", "");
	      if("list".equals(uri)) {
	         request.setAttribute("pBoardList", pbs.selectPBoardList());
	         RequestDispatcher rd = request.getRequestDispatcher("/views/photo-board/list.jsp");
	         rd.forward(request, response);
	         return;
	      }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
