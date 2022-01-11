<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>AirPnP Incorporated International 2021</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div>
    <br>
    <h2>Welcome to AirPnP</h2>
    <br>
    <img alt="image" src='https://images.unsplash.com/photo-1506521781263-d8422e82f27a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1740&q=80' width="100%" height="100%"/>
    <br>
    <br>
    <pre>
        Want to become rich? Look no further. We offer a cutting edge, modern and user friendly
        app for users to publish their unused parking space's for others to rent.
        Dont miss out on the opportunity to earn some extra cash. Sign up today.
    </pre>

    <%-- Show "Available parkingspaces" button except when on that page: --%>
    <div class="addbuttdiv">
        <c:choose>
            <c:when test="${!requestPath.equals('/parkingspace/showall')}">
                <a href="/parkingspace/showall" class="btn btn-danger mx-1" id="availblebutt">
                    Available parkingspaces
                </a>
            </c:when>
        </c:choose>
    </div>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>

<style>
    h2{
        text-align: center;
    }
    pre{
        text-align: center;
        font-family: sans-serif;
    }
</style>