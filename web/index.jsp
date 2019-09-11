<%--
  Created by IntelliJ IDEA.
  User: adria
  Date: 09.09.2019
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Metric Calculator</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<style>
    div {
        margin: 5px;
    }

    input {
        margin: 5px;
    }
</style>
<body>
<h2>Przelicznik metryczny</h2>
<form method="get" action="/metriccalc">
    <input type="text" placeholder="metry" name="meters"> <br/>
    <input type="text" placeholder="centymetry" name="centimeters"> <br/>
    <input type="text" placeholder="milimetry" name="millimeters"><br/>
    <input type="submit" value="Przelicz"><br/>
</form>
<h2>Przelicznik wag</h2>
<form method="get" action="/weightcalc">
    <input type="text" placeholder="kilogramy" name="kilograms"> <br/>
    <input type="text" placeholder="gramy" name="grams"> <br/>
    <input type="text" placeholder="miligramy" name="milligrams"><br/>
    <input type="submit" value="Przelicz"><br/>
</form>
</body>
</html>
