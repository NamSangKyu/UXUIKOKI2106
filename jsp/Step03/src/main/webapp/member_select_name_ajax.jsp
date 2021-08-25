<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="config.DBManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection conn = DBManager.getInstance().getConnection();
	String name = request.getParameter("name");
	String sql = "select * from member where name like '%' || ? || '%'";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, name);
	ResultSet rs = pstmt.executeQuery();
	String result = "";
	while(rs.next()){
		result += rs.getString(1) +","+rs.getString(2) + ","+rs.getString(3) +
				","+rs.getInt(4)+","+rs.getInt(5)+","+rs.getInt(6)+","+rs.getString(7)+"\n";
	}
	out.write(result);
	rs.close();
	pstmt.close();
%>