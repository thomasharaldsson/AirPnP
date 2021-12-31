<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>AirPnP Incorporated International 2021</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<c:choose>
    <c:when test="${edit != null && edit == true}">
        <h1>Edit parking Space</h1>
    </c:when>
    <c:otherwise>
        <h1>Create new parking Space</h1>
    </c:otherwise>
</c:choose>

<form:form modelAttribute="parkingspace" action="${action}">


    <form:errors path="" element="div"/>
    ID: ${parkingspace.id}
    <form:hidden path="id" value="${id}"/>
    <div>
        <form:label path="price">Price</form:label>
        <form:input path="price"/>
        <form:errors path="price"/>
    </div>
    <div>
        <form:label path="startDate">Start date</form:label>
        <form:input path="startDate"/>
        <form:errors path="startDate"/>
    </div>
    <div>
        <form:label path="endDate">End date</form:label>
        <form:input path="endDate"/>
        <form:errors path="endDate"/>
    </div>
    <div>
        <form:label path="streetAddress">Street address</form:label>
        <form:input path="streetAddress"/>
        <form:errors path="streetAddress"/>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form:form>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>