<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>AirPnP Incorporated International 2021</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<br/>Menu: <a href="create">add new rental tickets</a>

<h1>All my rental tickets</h1>

<c:choose>
    <c:when test="${rentalTickets.size() > 0}">
        <ul>
            <c:forEach items="${rentalTickets}" var="rentalticket">
                <div class="card">
                    <ul>
                        <li>ID: ${rentalticket.getId()}</li>
                        <li>Vehicle (registration number): ${rentalticket.getVehicle().getRegistrationNumber()}</li>
                        <li>Customer: ${rentalticket.getCustomer().getFirstName()} ${rentalticket.getCustomer().getSurName()}</li>
                        <li>Parking Space (street address): ${rentalticket.getParkingSpace().getStreetAddress()}</li>
                    </ul>
                </div>
            </c:forEach>
        </ul>

        <style>
            .card {
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
                transition: 0.3s;
                padding: 2px 16px;
                display: grid;
                grid-template-columns: auto auto auto;
                background-color: #2196F3;
                padding: 10px;
            }

            .card:hover {
                box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
            }
        </style>
    </c:when>
    <c:otherwise>
        You have not added any tickets yet.
    </c:otherwise>
</c:choose>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>