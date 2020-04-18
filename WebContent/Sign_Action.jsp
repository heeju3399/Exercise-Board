<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<jsp:useBean id="use" class="bean.user"></jsp:useBean>>
<jsp:useBean id="con" class="DAO.Con2"></jsp:useBean>>
<jsp:setProperty property="*" name="use" />
<%
	request.setCharacterEncoding("EUC-KR");
	boolean ok = con.signin(use);
	
%>
<%if (ok) {%>
		<script>
		alert("<%="OK"%>");
		location.href = "login.jsp";
		</script>
<%} else {%>
		<script>
			alert("<%="존재하는아이디"%>");
			location.href = "signin.jsp";
		</script>
<%	}%>