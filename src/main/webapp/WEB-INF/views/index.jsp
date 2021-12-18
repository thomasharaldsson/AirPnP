<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>AirPnP Incorporated International 2021</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div>
    <h1>Welcome to AirPnP!</h1>

    <h2>Main menu:</h2>


    <ul>
        <security:authorize access="hasRole('CUSTOMER')">
            <li><a href="vehicle/showall">Manage vehicles</a> (only for customers)</li>
        </security:authorize>


        <li><a href="parkingspace/showall">Manage parkingspaces</a> (for all users)</li>
        <li><a href="customer/showall">Manage customers</a> (only for customers)</li>

        <li>Buy rental ticket</li>
    </ul>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>