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

<br/>
<h2>All parking spaces</h2>

<c:choose>
    <c:when test="${parkingSpaces.size() > 0}">
        <ul class="list">
            <c:forEach items="${parkingSpaces}" var="parkingspace">
                <div class="card">
                <ul>
                    <li>ID: ${parkingspace.id}</li>
                    <li>street address: ${parkingspace.streetAddress}</li>
                    <li>start date: ${parkingspace.startDate}</li>
                    <li>end date: ${parkingspace.endDate}</li>
                    <li>price: ${parkingspace.price}</li>
                    <li><a href="show/${parkingspace.id}" class="btn btn-danger mx-1">open</a></li>
                </ul>
                </div>
            </c:forEach>
        </ul>

    </c:when>
    <c:otherwise>
        You have not added any parkingspaces yet. Please <a href="/parkingspace/create">add some</a> first.
    </c:otherwise>
</c:choose>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>