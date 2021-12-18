<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

<c:choose>
    <c:when test="${edit != null && edit == true}">
        <h1>Edit rental ticket</h1>
    </c:when>
    <c:otherwise>
        <h1>Create new rental ticket</h1>
    </c:otherwise>
</c:choose>

<form:form modelAttribute="rentalticket" action="${action}">


    <form:errors path="" element="div"/>
    ID: ${rentalticket.id}
    <form:hidden path="id" value="${id}"/>
    <select name="customer">
        <c:forEach items="${listCustomer}" var="customer">
            <option value="${customer}">${customer.firstName}</option>
        </c:forEach>
    </select>
    <br/><br/>
    <select name="parkingSpace">
        <c:forEach items="${listParkingSpace}" var="parkingspace">
            <option value="${parkingspace}">${parkingspace.streetAddress}</option>
        </c:forEach>
    </select>
    <br/><br/>
    <select name="vehicle">
        <c:forEach items="${listVehicle}" var="vehicle">
            <option value="${vehicle}">${vehicle.registrationNumber}</option>
        </c:forEach>
    </select>
    <br/><br/>
    <div>
        <input type="submit"/>
    </div>
</form:form>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>