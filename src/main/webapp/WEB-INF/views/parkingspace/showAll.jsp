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

<br/>
<h2>All parking spaces</h2>

<c:choose>
    <c:when test="${parkingSpaces.size() > 0}">
        <ul class="list">
            <c:forEach items="${parkingSpaces}" var="parkingspace">
                <div class="card">
                <ul class="itemlist">
                    <li class="hide">ID: ${parkingspace.id}</li>
                    <li>${parkingspace.streetAddress}</li>
                    <li>${parkingspace.startDate} till ${parkingspace.endDate}</li>
                    <li>${parkingspace.price} SEK/day</li>
                    <li><a href="show/${parkingspace.id}" class="btn btn-danger mx-1">open</a></li>
                </ul>
                </div>
            </c:forEach>
        </ul>

        <div class="addbuttdiv">
        <c:choose>
            <c:when test="${!requestPath.equals('/parkingspace/create')}">
                <a href="/parkingspace/create" class="btn btn-danger mx-1" id="addbutt">
                    Add new parkingspace
                </a>
            </c:when>
        </c:choose>
        </div>

    </c:when>
    <c:otherwise>
        You have not added any parkingspaces yet. Please <a href="/parkingspace/create">add some</a> first.
    </c:otherwise>
</c:choose>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>