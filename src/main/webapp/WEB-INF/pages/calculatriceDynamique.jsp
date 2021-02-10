<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: elzod
  Date: 02/02/2021
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>calculatrice Dynamique </h1>
<s:form action="Calculatrice-Dynamique" method="GET">
    <s:textfield name="operationA" key="operationA" />
    <s:textfield name="operationB" key="operationB" />
    <s:select name="typeOperation" list="%{listeCalculDynamique}"  key="operationsigne" ></s:select>
    <s:fielderror name="errordivision"/>
    <s:submit key="form.calculer" />
</s:form>
Résultat: <s:property value="resultat"/><br>
nombre operation: <s:property value="compteur"/><br>

</body>
</html>
