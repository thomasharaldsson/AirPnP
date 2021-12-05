<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br/>Menu: <a href="create">add new customer</a>
<h1>All customers: </h1>

<c:choose>
    <c:when test="${customers.size() > 0}">
        <ul>
            <c:forEach items="${customers}" var="customer">
                <ul>
                    <li>ID: ${customer.id}</li>
                    <li>Firstname: ${customer.firstName}</li>
                    <li>Lastname: ${customer.surName}</li>
                    <li>E-mail: ${customer.email}</li>
                    <li>Phone: ${customer.phoneNumber}</li>
                    <li>(<a href="show/${customer.id}">open</a>)</li>
                </ul>

                <br/>
                <br/>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        You have not added any customers yet.
    </c:otherwise>
</c:choose>
<jsp:include page="/WEB-INF/views/footer.jsp"/>