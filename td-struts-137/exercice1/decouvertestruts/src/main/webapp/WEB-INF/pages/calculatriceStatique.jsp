<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: elzod
  Date: 02/02/2021
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>calculatrice statique</h1>
<s:form action="Calculatrice-Statique" method="GET">
    <s:textfield name="operande1" key="operation1" />
    <s:textfield name="operande2" key="operation2" />
    <s:select name="typeOperation" list="%{listDeMesOperations}"  key="operationsigne" ></s:select>
    <s:fielderror name="errordivision"/>
    <s:submit key="form.calculer" />
</s:form>


</body>
</html>
