<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br/>Menu: <a href="create">add new vehicle</a>
<h1>All vehicles (this content is fake): </h1>

<c:choose>
    <c:when test="${vehicles.size() > 0}">
        <ul>
            <c:forEach items="${vehicles}" var="vehicle">
                <ul>
                    <li>ID: ${vehicle.getId()}</li>
                    <li>Registration number: ${vehicle.getRegistrationNumber()}</li>
                    <li>Owner: ${vehicle.owner.getFirstName()} ${vehicle.owner.getSurName()}</li>
                    <li>(open)</li>
                </ul>

                <br/>
                <br/>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        You have not added any vehicles yet.
    </c:otherwise>
</c:choose>