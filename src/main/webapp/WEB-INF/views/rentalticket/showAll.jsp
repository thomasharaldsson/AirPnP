<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>All parking spaces</h1>

<c:choose>
    <c:when test="${rentalTickets.size() > 0}">
        <ul>
            <c:forEach items="${rentalTickets}" var="rentalticket">
                <ul>
                    <li>ID: ${rentalticket.getId()}</li>
                    <li>Vehicle: ${rentalticket.getVehicle().getRegistrationNumber()}</li>
                    <li>Customer: ${rentalticket.getCustomer().getFirstName()}</li>
                </ul>

                <br/>
                <br/>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        You have not added any tickets yet.
    </c:otherwise>
</c:choose>
<jsp:include page="/WEB-INF/views/footer.jsp"/>