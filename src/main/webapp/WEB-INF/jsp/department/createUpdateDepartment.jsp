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
    <label style="text-align: center">Department İşlemleri</label>
    <form:form action="/department/createUpdate" commandName="${department}">
        <input type="hidden" name="departmentId" value="${department.departmentId}"/>
        <label style="width: 100px">Adı</label>
        <input id="name" name="name" value="${department.name}"/>
        <br/>
        <label style="width: 100px">Açıklama</label>
        <input id="description" name="description" value="${department.description}"/>
        <br/>
        <button type="submit">${empty department.departmentId ? 'Kaydet' : 'Güncelle'}</button>
    </form:form>
</div>

</body>
</html>