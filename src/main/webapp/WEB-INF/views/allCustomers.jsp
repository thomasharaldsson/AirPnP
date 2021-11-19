<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>Customers page</h1>

<ul>
<c:forEach items="${customers}" var="customer">
   <li>${customer}</li>
</c:forEach>
</ul>