<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Selma Hakyemez</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>

<div class='container'>
    <label style="text-align: center">Personel İşlemleri</label>
    <form:form action="/employee/createUpdate" commandName="${employee}">
        <input type="hidden" name="employeeId" value="${employee.employeeId}"/>
        <label style="width: 100px">Adı</label>
        <input id="name" name="name" value="${employee.name}"/>
        <br/>
        <label style="width: 100px">Soyadı</label>
        <input id="description" name="surname" value="${employee.surname}"/>
        <br/>
        <label style="width: 100px">Maaşı</label>
        <input type="number" id="description" name="salary" value="${employee.salary}"/>
        <br/>
        <button type="submit">${empty employee.employeeId ? 'Kaydet' : 'Güncelle'}</button>
    </form:form>
</div>

</body>
</html>