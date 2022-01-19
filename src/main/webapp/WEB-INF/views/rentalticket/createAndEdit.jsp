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
    <br/><br/>
    <h5> Select Customer: </h5>
    <select name="customer">
        <c:forEach items="${listCustomer}" var="customer">
            <option value="${customer.id}">${customer.firstName}</option>
        </c:forEach>
    </select>
    <br/><br/>
    <h5> Select Parking Space (street address): </h5>
    <c:choose>
        <c:when test="${listParkingSpace.size() > 0}">
            <select name="parkingSpace">
                <c:forEach items="${listParkingSpace}" var="parkingspace">
                    <option value="${parkingspace.id}">${parkingspace.streetAddress}</option>
                </c:forEach>
            </select>
        </c:when>
        <c:otherwise>
            Sorry, no parkingspaces are available at the moment.
        </c:otherwise>
    </c:choose>
    <br/><br/>
    <h5> Select Vehicle (registration number): </h5>
    <select name="vehicle">
        <c:forEach items="${listVehicle}" var="vehicle">
            <option value="${vehicle.id}">${vehicle.registrationNumber}</option>
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