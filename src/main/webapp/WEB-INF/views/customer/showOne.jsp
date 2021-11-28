<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>Here is the customer:</h1>

<ul>
    <li>ID: ${customer.id}</li>
    <li>Firstname: ${customer.firstName}</li>
    <li>Lastname: ${customer.surName}</li>
    <li>E-mail: ${customer.email}</li>
    <li>Phonenumber: ${customer.phoneNumber}</li>
</ul>