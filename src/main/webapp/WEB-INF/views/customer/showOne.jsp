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

<h2>Here is the customer:</h2>
<br>
<br>
    <ul class="itemlist">
        <li>ID: ${customer.id}</li>
        <li>Username: ${customer.username}</li>
        <li>Firstname: ${customer.firstName}</li>
        <li>Lastname: ${customer.surName}</li>
        <li>E-mail: ${customer.email}</li>
        <li>Phonenumber: ${customer.phoneNumber}</li>
        <li>Rating: ${customer.rating}</li><br>
        <li><a href="/customer/edit/${customer.id}" class="btn btn-danger mx-1" id="addbutt">edit</a> <a href="/customer/delete/${customer.id}" class="btn btn-danger mx-1" id="addbutt">delete</a></li>
    </ul>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>

<style>
    h2, ul{
        text-align: center;
    }
</style>