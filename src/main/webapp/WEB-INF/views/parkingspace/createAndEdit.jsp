<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>AirPnP Incorporated International 2021</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<c:choose>
    <c:when test="${edit != null && edit == true}">
        <h1>Edit parking Space</h1>
    </c:when>
    <c:otherwise>
        <h1>Rent out your own parking space</h1>
        <br>
        <br>
    </c:otherwise>
</c:choose>

<form:form modelAttribute="parkingspace" action="${action}">


<div class="createps">

    <div class="form">
        <form:label path="price">Price</form:label><br>
        <form:input path="price"/>
        <form:errors path="price"/>
    </div>

    <div class="form">
        <form:label path="startDate">Start date</form:label><br>
        <form:input path="startDate"/>
        <form:errors path="startDate"/>
    </div>

    <div class="form">
        <form:label path="endDate">End date</form:label><br>
        <form:input path="endDate"/>
        <form:errors path="endDate"/>
    </div>

    <div class="form">
        <form:label path="streetAddress">Address</form:label><br>
        <form:input path="streetAddress"/>
        <form:errors path="streetAddress"/>
    </div>
</div>

    <br>
    <br>
    <div class="addbuttdiv">
        <input type="submit" class="btn btn-danger mx-1" id="addbutt"/>
    </div>

</form:form>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>