<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br/>Menu: <a href="create">add new parkingspace</a>
<h1>All parking spaces</h1>

<c:choose>
    <c:when test="${parkingSpaces.size() > 0}">
        <ul>
            <c:forEach items="${parkingSpaces}" var="parkingspace">
                <div class="card">
                <ul>
                    <li>ID: ${parkingspace.id}</li>
                    <li>street address: ${parkingspace.streetAddress}</li>
                    <li>start date: ${parkingspace.startDate}</li>
                    <li>end date: ${parkingspace.endDate}</li>
                    <li>price: ${parkingspace.price}</li>
                    <li>(<a href="show/${parkingspace.id}">open</a>)</li>
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
            }

            .card:hover {
                box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
            }
        </style>
    </c:when>
    <c:otherwise>
        You have not added any parkingspaces yet. Please <a href="/parkingspace/create">add some</a> first.
    </c:otherwise>
</c:choose>
<jsp:include page="/WEB-INF/views/footer.jsp"/>