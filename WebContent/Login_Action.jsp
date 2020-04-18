<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<jsp:useBean id="con" class="DAO.Con2"/>
<jsp:useBean id="use" class="bean.user"/>
<jsp:setProperty property="*" name="use" />
<%
	request.setCharacterEncoding("EUC-KR");
	boolean zz = con.login(use);
	
	if(!zz){%>
		<script>alert("<%="다시로그인"%>");
				location.href = "login.jsp";
		</script>		
		
<%}else{%>
	
		<script>alert("<%="OK"%>");
				location.href = "main.jsp";
		</script>		


<%} %>


