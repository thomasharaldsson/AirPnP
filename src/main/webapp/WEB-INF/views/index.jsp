<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>AirPnP Incorporated International 2021</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div>
    <br>
    <h2>Welcome to AirPnP</h2>
    <br>
    <br>
    <pre>
        Want to become rich? Look no further. We offer a cutting edge, modern and user friendly
        app for users to publish their unused parking space's for others to rent.
        Dont miss out on the opportunity to earn some extra cash. Sign up today.
    </pre>

    <ul>

        <li><a href="customer/showall">Manage customers</a> (for all users)</li>

        <security:authorize access="isAnonymous()">
            <li>Please login to gain access to other functionality.</li>
        </security:authorize>

        <security:authorize access="hasRole('CUSTOMER')">
            <li><a href="vehicle/showall">Manage vehicles</a> (only for customers)</li>
        </security:authorize>


        <security:authorize access="hasRole('ADMIN')">
            <li>Show all my parkingspaces</li>
            <li><a href="http://localhost:8080/parkingspace/create">create</a> a new parkingpsace</li>
        </security:authorize>

        <security:authorize access="hasRole('CUSTOMER')">
            <li>Show all my rental tickets</li>
            <li><a href="http://localhost:8080/rentalticket/showall">Manage Rental Tickets</a></li>
        </security:authorize>

    </ul>
    <%-- Show "Available parkingspaces" button except when on that page: --%>
    <div>
        <c:choose>
            <c:when test="${!requestPath.equals('/parkingspace/showall')}">
                <a href="/parkingspace/showall" class="btn btn-danger mx-1">
                    Available parkingspaces
                </a>
            </c:when>
        </c:choose>
    </div>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>

<style>
    h2{
        text-align: center;
    }
    pre{
        text-align: center;
        font-family: sans-serif;
    }
</style>