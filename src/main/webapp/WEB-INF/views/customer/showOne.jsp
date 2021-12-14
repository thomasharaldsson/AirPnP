<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>Here is the customer:</h1>

<ul>
    <li>ID: ${customer.id}</li>
    <li>Username: ${customer.username}</li>
    <li>Password: ${customer.password}</li>
    <li>Firstname: ${customer.firstName}</li>
    <li>Lastname: ${customer.surName}</li>
    <li>E-mail: ${customer.email}</li>
    <li>Phonenumber: ${customer.phoneNumber}</li>
    <li>(<a href="/customer/edit/${customer.id}">edit</a>) (<a href="/customer/delete/${customer.id}">delete</a>)</li>
</ul>
<jsp:include page="/WEB-INF/views/footer.jsp"/>