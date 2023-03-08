<%@ page language="java" import="java.io.*,java.lang.*" %>
<%! 
	int a=0;
	int i=0;
%>
<%
a=Integer.pasrseInt(request.getParameter("txt1"));
for(i=a;i>=1;i--)
{
	out.println("\n Numbers are: "+a);
}
%>