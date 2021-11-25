<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>All parking spaces</h1>

<ul>
    <c:forEach items="${parkingSpaces}" var="parkingspace">
        <ul>
            <li>street address: ${parkingspace.streetAddress} (<a href="show/${parkingspace.id}">open</a>)</li>
            <li>start date: ${parkingspace.startDate}</li>
            <li>end date: ${parkingspace.endDate}</li>
            <li>price: ${parkingspace.price}</li>
        </ul>

        <br/>
        <br/>
    </c:forEach>
</ul>