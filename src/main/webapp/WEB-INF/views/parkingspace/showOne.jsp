<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>Here is the parking space:</h1>

<ul>
    <li>ID: ${parkingspace.id}</li>
    <li>street address: ${parkingspace.streetAddress}</li>
    <li>start date: ${parkingspace.startDate}</li>
    <li>end date: ${parkingspace.endDate}</li>
    <li>price: ${parkingspace.price}</li>
    <li>(<a href="/parkingspace/edit/${parkingspace.id}">edit</a>) (<a href="/parkingspace/delete/${parkingspace.id}">delete</a>)
    </li>
</ul>
<jsp:include page="/WEB-INF/views/footer.jsp"/>