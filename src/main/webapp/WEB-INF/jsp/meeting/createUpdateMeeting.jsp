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
    <label style="text-align: center">Toplantı İşlemleri</label>
    <form:form action="/meeting/createUpdate" commandName="${meeting}">
        <input type="hidden" name="meetingId" value="${meeting.meetingId}"/>
        <label style="width: 100px">Adı</label>
        <input id="name" name="name" value="${meeting.name}"/>
        <br/>
        <label style="width: 100px">Açıklama</label>
        <input id="description" name="description" value="${meeting.description}"/>
        <br/>
        <label style="width: 100px">Departman</label>
        <input id="description" name="salary" value="${meeting.department.name}"/>
        <br/>
        <button type="submit">${empty meeting.meetingId ? 'Kaydet' : 'Güncelle'}</button>
    </form:form>
</div>

</body>
</html>