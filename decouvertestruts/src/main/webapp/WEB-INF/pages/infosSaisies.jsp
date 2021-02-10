<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: elzod
  Date: 03/02/2021
  Time: 00:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Bonjour vous etes bien connectés <br>
Votre identifiant est :
<s:property value="identifiant"/><br>
Votre mot de passe est :
<s:property value="password"/>

</body>
</html>
