<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        You have not added any vehicles yet. Please <a href="/vehicle/create">add some</a> first.
    </c:otherwise>
</c:choose>

<jsp:include page="/WEB-INF/views/footer.jsp"/>