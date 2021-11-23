<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>All parking spaces</h1>

<ul>
    <c:forEach items="${parkingSpaces}" var="parkingSpace">
        <li>${parkingSpace}</li>
    </c:forEach>
</ul>