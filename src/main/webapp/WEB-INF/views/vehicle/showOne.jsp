<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>AirPnP Incorporated International 2021</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp"/>

<h1>Here is the vehicle:</h1>

<ul>
    <li>ID: ${vehicle.getId()}</li>
    <li>Registration number: ${vehicle.getRegistrationNumber()}</li>
    <li>Owner: ${vehicle.getOwner().getFirstName()} ${vehicle.getOwner().getSurName()}</li>
    <li>E-mail: ${vehicle.getOwner().getEmail()}</li>
    <li>Phonenumber: ${vehicle.getOwner().getPhoneNumber()}</li>
    <li>(<a href="/vehicle/edit/${vehicle.getId()}">edit</a>) (<a href="/vehicle/delete/${vehicle.getId()}">delete</a>)
    </li>
</ul>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>