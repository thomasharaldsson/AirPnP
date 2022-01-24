<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>AirPnP Incorporated International 2021</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp"/>
<h2>Here is the parking space:</h2>
<br>
<br>

<ul class="itemlist">
    <li>ID: ${parkingspace.id}</li>
    <li>street address: ${parkingspace.streetAddress}</li>
    <li>start date: <fmt:formatDate pattern="yyyy-MM-dd" value="${parkingspace.startDate}" /></li>
    <li>end date: <fmt:formatDate pattern="yyyy-MM-dd" value="${parkingspace.endDate}" /></li>
    <li>price: ${parkingspace.price}</li>
    <li>Username: ${parkingspace.owner.username}</li><br>
    <li><a href="/parkingspace/edit/${parkingspace.id}" class="btn btn-danger mx-1" id="addbutt">edit</a> <a href="/parkingspace/delete/${parkingspace.id}" class="btn btn-danger mx-1" id="addbutt">delete</a>
    </li>
</ul>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>

<style>
    h2, ul{
        text-align: center;
    }
</style>