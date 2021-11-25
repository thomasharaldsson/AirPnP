<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>Here is the parking space:</h1>

<ul>
    <li>street address: ${parkingspace.streetAddress}</li>
    <li>start date: ${parkingspace.startDate}</li>
    <li>end date: ${parkingspace.endDate}</li>
    <li>price: ${parkingspace.price}</li>
</ul>