package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 显示 HttpServletRequest Header信息
 * 
 * @author itwanha
 *
 */
public class DisplayHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		String title = "HTTP Header 请求实例 ";
		String docType = "<!DOCTYPE html> \n";
		out.println(docType + "<html>\n" + "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n"
				+ "<table width=\"100%\" border=\"1\" align=\"center\">\n" + "<tr bgcolor=\"#949494\">\n"
				+ "<th>Header 名称</th><th>Header 值</th>\n" + "</tr>\n");

		Enumeration<String> headerNames = request.getHeaderNames();

		// server Port
		out.print("<tr><td>" + "serverPort" + "</td>\n");
		out.println("<td> " + request.getServerPort() + "</td></tr>\n");

		// Header Names Values
		while (headerNames.hasMoreElements()) {
			String paramName = (String) headerNames.nextElement();
			out.print("<tr><td>" + paramName + "</td>\n");
			String paramValue = request.getHeader(paramName);
			out.println("<td> " + paramValue + "</td></tr>\n");
		}
		out.println("</table>\n</body></html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
