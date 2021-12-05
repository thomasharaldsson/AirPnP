<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

<c:choose>
    <c:when test="${edit != null && edit == true}">
        <h1>Edit vehicle</h1>
    </c:when>
    <c:otherwise>
        <h1>Create new vehicle</h1>
    </c:otherwise>
</c:choose>

<form:form modelAttribute="vehicle" action="${action}">


    <form:errors path="" element="div"/>
    ID: ${vehicle.id}
    <form:hidden path="id" value="${id}"/>
    <div>
        <form:label path="registrationNumber">Registration number</form:label>
        <form:input path="registrationNumber"/>
        <form:errors path="registrationNumber"/>
    </div>
    <div>
        Owner: ${vehicle.owner.getFirstName()} ${vehicle.owner.getSurName()}
    </div>
    <div>
        <input type="submit"/> (does not work yet)
    </div>
</form:form>

</body>
</html>