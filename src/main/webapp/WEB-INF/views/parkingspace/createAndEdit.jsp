<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

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