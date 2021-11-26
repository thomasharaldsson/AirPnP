<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

<c:choose>
    <c:when test="${edit != null && edit == true}">
        <h1>Edit parking customer</h1>
    </c:when>
    <c:otherwise>
        <h1>Create new parking customer</h1>
    </c:otherwise>
</c:choose>

<form:form modelAttribute="customer" action="${action}">


    <form:errors path="" element="div"/>
    ID: ${customer.id}
    <form:hidden path="id" value="${id}"/>
    <div>
        <form:label path="firstName">Firstname</form:label>
        <form:input path="firstName"/>
        <form:errors path="firstName"/>
    </div>
    <div>
        <form:label path="surName">Surname</form:label>
        <form:input path="surName"/>
        <form:errors path="surName"/>
    </div>
    <div>
        <form:label path="email">E-mail</form:label>
        <form:input path="email"/>
        <form:errors path="email"/>
    </div>
    <div>
        <form:label path="phoneNumber">E-mail</form:label>
        <form:input path="phoneNumber"/>
        <form:errors path="phoneNumber"/>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form:form>

</body>
</html>