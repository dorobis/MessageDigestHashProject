<%@page import="java.io.InputStream,javax.servlet.ServletContext" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<jsp:useBean id="mdbean" class="proto.mdhash.MessageDigestBean" />
<html>
<base href="http://localhost:8080/myApps" >
<head>
<title>My File Hash App</title>
</head>
<body>
<%
ServletContext ctx = config.getServletContext(); 
InputStream fin = ctx.getResourceAsStream("foo.txt"); 
%>
File hash for foo.txt is <%= mdbean.getHashValue(fin) %>.
<h3>Select a file for message digest calculation<h3>
    <html:form action="computeHash" enctype="multipart/form-data">
        <html:file property="theFile" />
        <html:submit />
    </html:form>
</body>
</html>