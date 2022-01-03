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

<br/>Menu: <a href="create">add new customer</a>
<h1>All customers: </h1>

<c:choose>
    <c:when test="${customers.size() > 0}">
        <ul>
            <c:forEach items="${customers}" var="customer">
                <div class="card">
                    <ul>
                        <li>ID: ${customer.id}</li>
                        <li>Username: ${customer.username}</li>
                        <li>Password: ${customer.password}</li>
                        <li>Firstname: ${customer.firstName}</li>
                        <li>Lastname: ${customer.surName}</li>
                        <li>E-mail: ${customer.email}</li>
                        <li>Phone: ${customer.phoneNumber}</li>
                        <li>(<a href="show/${customer.id}">open</a>)</li>
                    </ul>
                </div>
                <br/>
                <br/>
            </c:forEach>
        </ul>


    </c:when>
    <c:otherwise>
        You have not added any customers yet. Please <a href="/customer/create">add some</a> first.
    </c:otherwise>
</c:choose>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>