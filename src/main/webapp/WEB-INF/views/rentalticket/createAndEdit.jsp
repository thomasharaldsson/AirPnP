<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>AirPnP Incorporated International 2021</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
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
    <%--ID: ${rentalticket.id}--%>
    <form:hidden path="id" value="${id}"/>

    <security:authorize access="hasRole('ADMIN')" var="isAdmin"/>
    <security:authorize access="hasRole('CUSTOMER')" var="isCustomer"/>
    <c:choose>
        <c:when test="${isAdmin}">
            <%-- User is admin: let user select a customer for which rental ticket will be created: --%>
            <br/><br/>
            <h5> Select Customer: </h5>
            <select name="customer">
                <c:forEach items="${listCustomer}" var="customer">
                    <option value="${customer.id}">${customer.firstName}</option>
                </c:forEach>
            </select>
        </c:when>
        <c:when test="${isCustomer}">
            <%-- User is not admin: don't show a drop-down menu. Rental ticket will automatically be created for the logged in user: --%>
            Customer: ${selectedCustomer.firstName} ${selectedCustomer.surName}<br>
            <form:hidden path="customer" value="${selectedCustomer.id}"/>
        </c:when>
        <c:otherwise>
            Error: You need to be logged in to use this page.
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${selectedParkingSpace != null}">
            <%-- User has already selected which parkingspace ID to use: don't show a drownmenu to select. --%>
            Parkingspace: ${selectedParkingSpace.streetAddress}<br>
            <form:hidden path="parkingSpace" value="${selectedParkingSpace.id}"/>
        </c:when>
        <c:when test="${listParkingSpace.size() > 0}">
            <%-- User has not yet selected which parkingspace ID to use: show a drownmenu to select. --%>
            <br/><br/>
            <h5> Select Parking Space (street address): </h5>
            <select name="parkingSpace">
                <c:forEach items="${listParkingSpace}" var="parkingspace">
                    <option value="${parkingspace.id}">${parkingspace.streetAddress}</option>
                </c:forEach>
            </select>
        </c:when>
        <c:otherwise>
            <br/><br/>
            <h5> Select Parking Space (street address): </h5>
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