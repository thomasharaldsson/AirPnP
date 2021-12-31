<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
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