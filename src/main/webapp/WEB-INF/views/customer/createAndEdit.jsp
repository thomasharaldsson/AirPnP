<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

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

        <c:choose>

            <c:when test="${edit != null && edit == true}">
                <!-- Editing customer: you can't edit username after it's been created. -->
                Username: ${customer.username}
                <form:hidden path="username" value="${username}"/>
            </c:when>

            <c:otherwise>
                <!-- Creating customer: here you are allowed to enter username. -->
                <form:label path="username">Username</form:label>
                <form:input path="username"/>
                <form:errors path="username"/>
            </c:otherwise>

        </c:choose>

    </div>
    <div>
        <form:label path="password">Password</form:label>
        <form:password path="password"/>
        <form:errors path="password"/>
    </div>
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
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>