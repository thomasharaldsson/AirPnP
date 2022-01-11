<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>AirPnP Incorporated International 2021</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>


<h2>All my rental tickets</h2>
<br>
<br>
<c:choose>
    <c:when test="${rentalTickets.size() > 0}">
        <ul class="list">
            <c:forEach items="${rentalTickets}" var="rentalticket">
                <div class="card">
                    <ul class="itemlist">
                        <li>ID: ${rentalticket.getId()}</li>
                        <li>Vehicle (registration number): ${rentalticket.getVehicle().getRegistrationNumber()}</li>
                        <li>Customer: ${rentalticket.getCustomer().getFirstName()} ${rentalticket.getCustomer().getSurName()}</li>
                        <li>Parking Space (street address): ${rentalticket.getParkingSpace().getStreetAddress()}</li>
                    </ul>
                </div>
            </c:forEach>
        </ul>

        <div class="addbuttdiv">
            <a href="create" class="btn btn-danger mx-1" id="addbutt">add new rental tickets</a>
        </div>

    </c:when>
    <c:otherwise>
        You have not added any tickets yet.
    </c:otherwise>
</c:choose>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>