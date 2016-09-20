<%@page import="com.chungok.vo.ArtclVO"%>
<%@page import="java.util.List"%>
<%@page import="com.chungok.dao.ArtclDao"%>
<%@page import="com.chungok.dao.ArtclDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	ArtclDao dao = new ArtclDaoImpl();
	List<ArtclVO> artcles = dao.getArtcls();
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ARTCL</h1>
	<hr/>
	<table style="width: 100%; border-collapse: collapse; border: 1px solid #000000; background-color: #CCCCCC;">
	<tr style = "height: 50px;">
		<td>ARTCL_ID</td>
		<td>SBJ</td>
		<td>CONT</td>
		<td>DATE</td>
	</tr>
<%
	int artclesSize = artcles.size();
	ArtclVO artcl = null;
	for (int i = 0; i < artclesSize; i++ ) {
		artcl = artcles.get(i);
%>
	<tr>
	<td><%out.print(artcl.getArticleId()); %></td>
	<td><%= artcl.getSubject() %></td>
	<td><%= artcl.getContent() %></td>
	<td><%= artcl.getCreatDate() %></td>
	</tr>
	<%} %>



</body>
</html>