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
        <form:label path="registrationNumber">Registration number: </form:label>
        <form:input path="registrationNumber"/>
        <form:errors path="registrationNumber"/>
    </div>
    <div>
        Owner:

        <c:choose>
            <c:when test="${customers.size() > 0}">
                <select name="owner_id">
                    <c:forEach var="customer" items="${customers}">
                        <option value="${customer.id}"
                                <c:choose>
                                    <c:when test="${vehicle.getOwner() != null && customer.id == vehicle.getOwner().getId()}">
                                        SELECTED
                                    </c:when>
                                </c:choose>
                        >
                                ${customer.getFirstName()} ${customer.getSurName()}
                        </option>
                    </c:forEach>

                </select>
            </c:when>
            <c:otherwise>
                You have not added any customers yet. Please <a href="/customer/create">add some</a> first.
            </c:otherwise>
        </c:choose>
    </div>
    <div>
        <input type="submit"
                <c:choose>
                    <c:when test="${customers.size() == 0}">
                        disabled="disabled"
                    </c:when>
                </c:choose>
        />
    </div>
</form:form>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>