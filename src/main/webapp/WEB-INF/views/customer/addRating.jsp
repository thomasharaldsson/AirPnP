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

<h2>Rate customer</h2>
<br>
<br>
<h3>Rate your experince</h3>
<div class="rating">
    <input type="radio" name="rating" value="5" id="5">
        <label for="5">	&#9734;</label>
    <input type="radio" name="rating" value="4" id="4">
        <label for="4">	&#9734;</label>
    <input type="radio" name="rating" value="3" id="3">
        <label for="3">	&#9734;</label>
    <input type="radio" name="rating" value="2" id="2">
        <label for="2">	&#9734;</label>
    <input type="radio" name="rating" value="1" id="1">
        <label for="1">	&#9734;</label>
</div>

<div class="addbuttdiv">
    <a href="rate" class="btn btn-danger mx-1" id="addbutt">Submit (not working yet)</a>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>

<style>
    h3 {
        text-align: center;
        margin-top: 100px
    }

    @media only screen and (max-width: 600px) {
        h3 {
            font-size: 14px
        }

    }
</style>