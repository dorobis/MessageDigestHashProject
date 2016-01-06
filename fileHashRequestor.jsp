<%@page import="java.io.InputStream,javax.servlet.ServletContext" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!-- jsp:useBean id="fileField" class="proto.app.FileFieldBean" / -->
<html:html>
<base href="http://localhost:8080/myApps" >
	<head>
		<title>My File Hash Requestor JSP</title>
	</head>
	<body>
		<html:form action="/computeHash" focus="fileName">
			Enter filename: <html:text property="fileName"/>;
		</html:form>
	</body>
</html:html>