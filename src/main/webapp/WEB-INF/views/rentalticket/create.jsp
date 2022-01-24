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

<h1>Create new rental ticket</h1>


<form:form modelAttribute="rentalticket" action="${action}">


    <form:errors path="" element="div"/>
    <%--ID: ${rentalticket.id}--%>
    <form:hidden path="id" value="${id}"/>

    <%--
        Select customer for which rental ticket will be created:
        - display a dropdown menu (if user is admin)
            OR
        - add a hidden field that contains value of customerID (if user is not an admin).
    --%>
    <security:authorize access="hasRole('ADMIN')" var="isAdmin"/>
    <security:authorize access="hasRole('CUSTOMER')" var="isCustomer"/>
    <c:choose>
        <%-- Display dropdown menu --%>
        <c:when test="${isAdmin}">
            <br/><br/>
            <h5> Select Customer: </h5>
            <select name="customer">
                <c:forEach items="${listCustomer}" var="customer">
                    <option value="${customer.id}">${customer.firstName}</option>
                </c:forEach>
            </select>
        </c:when>
        <%-- Add hidden field --%>
        <c:when test="${isCustomer}">
            Customer: ${selectedCustomer.firstName} ${selectedCustomer.surName}<br>
            <form:hidden path="customer" value="${selectedCustomer.id}"/>
        </c:when>
        <c:otherwise>
            Error: You need to be logged in to use this page.
        </c:otherwise>
    </c:choose>

    <%--
        Select parkingspace for which rental ticket will be created:
        - display a dropdown menu (if one has not yet been provided by controller)
            OR
        - add a hidden field that contains value of parkinspace ID (if parkingspace has not yet been provided by controller)
           OR
        - show error message that no available parkingspaces could be found

    --%>
    <c:choose>
        <%-- Parkingspace has already been provided by controller. --%>
        <c:when test="${selectedParkingSpace != null}">
            Parkingspace: ${selectedParkingSpace.streetAddress}<br>
            <form:hidden path="parkingSpace" value="${selectedParkingSpace.id}"/>
        </c:when>
        <%-- Display dropdown menu --%>
        <c:when test="${listParkingSpace.size() > 0}">

            <br/><br/>
            <h5> Select Parking Space (street address): </h5>
            <select name="parkingSpace" id="parkingSpaceId">
                <c:forEach items="${listParkingSpace}" var="parkingspace">
                    <option value="${parkingspace.id}">${parkingspace.streetAddress}</option>
                </c:forEach>
            </select>


        </c:when>
        <%-- No free parkingspaces could be found in database. --%>
        <c:otherwise>
            <br/><br/>
            <h5> Select Parking Space (street address): </h5>
            Sorry, no parkingspaces are available at the moment.
        </c:otherwise>
    </c:choose>
    <br/>

    <%-- Select vehicle: display dropdown menu --%>
    <h5> Select Vehicle (registration number): </h5>
    <select name="vehicle">
        <c:forEach items="${listVehicle}" var="vehicle">
            <option value="${vehicle.id}">${vehicle.registrationNumber}</option>
        </c:forEach>
    </select>
    <br/><br/>

    <h5> Start Date: </h5>

    <select name="startDate" id="startDateId">
        <c:forEach items="${listDates}" var="startDate">
            <option value="${startDate}">${startDate.toString()}</option>
        </c:forEach>
    </select>
    <br/><br/>

    <h5> End Date: </h5>

    <select name="endDate" id="endDateId">
        <c:forEach items="${listDates}" var="endDate">
            <option value="${endDate}">${endDate.toString()}</option>
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