<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: elzod
  Date: 02/02/2021
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Connexion</h1>
<s:form action="Connexion" method="POST"> <!--plus securisé affiche pas les données sur l'url-->
    <s:textfield name="identifiant" key="form.identifiant" />
    <s:password name="password" key="form.password" />
    <s:fielderror name="error" />
    <s:submit key="form.submit" />
</s:form>

</body>
</html>
