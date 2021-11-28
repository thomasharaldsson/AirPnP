<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>All customers</h1>

<ul>
    <c:forEach items="${customers}" var="customer">
        <ul>
            <li>ID: ${customer.id}</li>
            <li>Firstname: ${customer.firstName}</li>
            <li>Lastname: ${customer.surName}</li>
            <li>E-mail: ${customer.email}</li>
            <li>Phone: ${customer.phoneNumber}</li>
            <li>(<a href="show/${customer.id}">open</a>) (<a href="edit/${customer.id}">edit</a>) (delete)</li>
        </ul>

        <br/>
        <br/>
    </c:forEach>
</ul>