<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

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