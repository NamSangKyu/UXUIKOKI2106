<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="service.MemberService"%>
<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String search = request.getParameter("search");
	String kind = request.getParameter("kind");
	ArrayList<MemberDTO> list = MemberService.getInstance().searchMember(kind,search);
	
	//json 조립
	JSONArray array = new JSONArray();
	
	for(int i=0;i<list.size();i++){
		JSONObject obj = new JSONObject();
		obj.put("id", list.get(i).getId());
		obj.put("name", list.get(i).getName());
		obj.put("age", list.get(i).getAge());
		obj.put("grade", list.get(i).getGrade());
		obj.put("gender", list.get(i).getGender());
		obj.put("point", list.get(i).getPoint());
		array.put(obj);
	}
	
	out.write(array.toString());

%>








