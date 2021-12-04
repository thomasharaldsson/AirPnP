<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br/>Menu: <a href="create">add new parkingspace</a>
<h1>All parking spaces</h1>

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