<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JSONArray array = new JSONArray();

	JSONObject json = new JSONObject();
	json.put("TEST", 1111);
	json.put("A", "2021-08-26");
	json.put("DD", "안녕하세여");
	json.put("C", "456666");

	array.put(json);
	
	array.put("값");
	array.put(12345);
	out.write(array.toString());
%>