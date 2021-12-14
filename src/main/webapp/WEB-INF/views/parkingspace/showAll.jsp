<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br/>Menu: <a href="create">add new parkingspace</a>
<h1>All parking spaces</h1>

<c:choose>
    <c:when test="${parkingSpaces.size() > 0}">
        <ul>
            <c:forEach items="${parkingSpaces}" var="parkingspace">
                <ul>
                    <li>ID: ${parkingspace.id}</li>
                    <li>street address: ${parkingspace.streetAddress}</li>
                    <li>start date: ${parkingspace.startDate}</li>
                    <li>end date: ${parkingspace.endDate}</li>
                    <li>price: ${parkingspace.price}</li>
                    <li>(<a href="show/${parkingspace.id}">open</a>)</li>
                </ul>

                <br/>
                <br/>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        You have not added any parkingspaces yet. Please <a href="/parkingspace/create">add some</a> first.
    </c:otherwise>
</c:choose>
<jsp:include page="/WEB-INF/views/footer.jsp"/>