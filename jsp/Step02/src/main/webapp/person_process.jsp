<%@page import="obj.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Exception 발생시 이동할 페이지 설정 -->
<%@ page errorPage="error.jsp"%>
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	
	request.setAttribute("obj", new Person(name,age));
	
	request.getRequestDispatcher("person_result.jsp").forward(request, response);
%>