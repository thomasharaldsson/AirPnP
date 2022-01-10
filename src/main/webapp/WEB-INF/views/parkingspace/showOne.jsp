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
<h1>Here is the parking space:</h1>

<ul>
    <li>ID: ${parkingspace.id}</li>
    <li>street address: ${parkingspace.streetAddress}</li>
    <li>start date: ${parkingspace.startDate}</li>
    <li>end date: ${parkingspace.endDate}</li>
    <li>price: ${parkingspace.price}</li>
    <li>(<a href="/parkingspace/edit/${parkingspace.id}">edit</a>) (<a href="/parkingspace/delete/${parkingspace.id}">delete</a>)
    </li>
</ul>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>