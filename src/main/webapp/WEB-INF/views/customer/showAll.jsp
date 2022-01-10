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


<h1>All customers: </h1>

<c:choose>
    <c:when test="${customers.size() > 0}">
        <ul class="list">
            <c:forEach items="${customers}" var="customer">
                <div class="card">
                    <ul class="itemlist">
                        <li>ID: ${customer.id}</li>
                        <li>Username: ${customer.username}</li>
                        <li>Firstname: ${customer.firstName}</li>
                        <li>Lastname: ${customer.surName}</li>
                        <li>E-mail: ${customer.email}</li>
                        <li>Phone: ${customer.phoneNumber}</li>
                        <li><a href="show/${customer.id}" class="btn btn-danger mx-1">open</a></li>
                    </ul>
                </div>
            </c:forEach>
        </ul>

        <div class="addbuttdiv">
            <a href="create" class="btn btn-danger mx-1" id="addbutt">add new customer</a>
        </div>


    </c:when>
    <c:otherwise>
        You have not added any customers yet. Please <a href="/customer/create">add some</a> first.
    </c:otherwise>
</c:choose>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>