<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: elzod
  Date: 02/02/2021
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Bienvenue sur notre page</h1> <br>
<ul>
    <li> <s:a action="Connexion" >Connexion </s:a> </li>
    <li><s:a action="newformulaireDynamique" >Calculatrice Dynamique </s:a></li>
    <li><s:a action="calc-stat" >Calculatrice Statique</s:a></li>
</ul>
</body>
</html>
