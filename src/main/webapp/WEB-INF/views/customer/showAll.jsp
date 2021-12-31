<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

        <style>
            .card {
                box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
                transition: 0.3s;
                padding: 2px 16px;
                display: grid;
                grid-template-columns: auto auto auto;
                background-color: #2196F3;
                padding: 10px;
            }

            .card:hover {
                box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
            }
        </style>
    </c:when>
    <c:otherwise>
        You have not added any customers yet. Please <a href="/customer/create">add some</a> first.
    </c:otherwise>
</c:choose>
<jsp:include page="/WEB-INF/views/footer.jsp"/>