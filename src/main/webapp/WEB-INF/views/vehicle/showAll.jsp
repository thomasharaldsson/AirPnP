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
<br/>Menu: <a href="create">add new vehicle</a>
<h1>All vehicles: </h1>

<c:choose>
    <c:when test="${vehicles.size() > 0}">
        <ul>
            <c:forEach items="${vehicles}" var="vehicle">
                <div class="card">
                    <ul>
                        <li>ID: ${vehicle.getId()}</li>
                        <li>Registration number: ${vehicle.getRegistrationNumber()}</li>
                        <li>Owner: ${vehicle.owner.getFirstName()} ${vehicle.owner.getSurName()}</li>
                        <li>(<a href="show/${vehicle.id}">open</a>)</li>
                    </ul>
                </div>
                <br/>
                <br/>
            </c:forEach>
        </ul>


    </c:when>
    <c:otherwise>
        You have not added any vehicles yet. Please <a href="/vehicle/create">add some</a> first.
    </c:otherwise>
</c:choose>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>