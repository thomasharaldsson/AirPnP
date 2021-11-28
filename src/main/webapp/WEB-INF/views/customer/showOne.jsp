<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>Here is the customer:</h1>

<ul>
    <li>ID: ${customer.id}</li>
    <li>Firstname: ${customer.firstName}</li>
    <li>Lastname: ${customer.surName}</li>
    <li>E-mail: ${customer.email}</li>
    <li>Phonenumber: ${customer.phoneNumber}</li>
    <li>(<a href="/customer/edit/${customer.id}">edit</a>) (<a href="/customer/delete/${customer.id}">delete</a>)</li>
</ul>