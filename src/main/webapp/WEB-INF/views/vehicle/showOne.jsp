<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>AirPnP Incorporated International 2021</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp"/>

<h2>Here is the vehicle:</h2>
<br>
<br>

<ul class="itemlist">
    <li>ID: ${vehicle.getId()}</li>
    <li>Registration number: ${vehicle.getRegistrationNumber()}</li>
    <li>Owner: ${vehicle.getOwner().getFirstName()} ${vehicle.getOwner().getSurName()}</li>
    <li>E-mail: ${vehicle.getOwner().getEmail()}</li>
    <li>Phonenumber: ${vehicle.getOwner().getPhoneNumber()}</li><br>
    <li><a href="/vehicle/edit/${vehicle.getId()}" class="btn btn-danger mx-1" id="addbutt">edit</a> <a href="/vehicle/delete/${vehicle.getId()}" class="btn btn-danger mx-1" id="addbutt">delete</a>
    </li>
</ul>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>

<style>
    h2, ul{
        text-align: center;
    }
</style>