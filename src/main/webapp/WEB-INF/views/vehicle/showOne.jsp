<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>Here is the vehicle:</h1>

<ul>
    <li>ID: ${vehicle.getId()}</li>
    <li>Registration number: ${vehicle.getRegistrationNumber()}</li>
    <li>Owner: ${vehicle.getOwner().getFirstName()} ${vehicle.getOwner().getSurName()}</li>
    <li>E-mail: ${vehicle.getOwner().getEmail()}</li>
    <li>Phonenumber: ${vehicle.getOwner().getPhoneNumber()}</li>
    <li>(<a href="/vehicle/edit/${vehicle.getId()}">edit</a>) (<a href="/vehicle/delete/${vehicle.getId()}">delete</a>)</li>
</ul>

<jsp:include page="/WEB-INF/views/footer.jsp"/>