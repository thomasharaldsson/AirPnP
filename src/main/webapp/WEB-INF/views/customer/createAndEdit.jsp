<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>AirPnP Incorporated International 2021</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/css/main.css">
    <script>
        $(document).ready(function () {
            $("#agreeCheckbox").on("click", function () {
                let agreeCheckboxValue = $(this).prop('checked')
                $("#registerButton").prop('disabled', !agreeCheckboxValue);
            })
        });
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<div class="d-flex .justify-content-sm-around">

    <div class="row">
        <div class="col">
            <c:choose>
                <c:when test="${edit != null && edit == true}">
                    <h1>Edit profile</h1>
                </c:when>
                <c:otherwise>
                    <h1>Register account</h1>
                </c:otherwise>
            </c:choose>
        </div>
    </div>


    <form:form modelAttribute="customer" action="${action}" autocomplete="off">
    <form:errors path="" element="div"/>

    <form:hidden path="id" value="${id}"/>


    <div class="row">
        <c:choose>

            <c:when test="${edit != null && edit == true}">

                <div class="col">
                    <!-- Editing customer: you can't edit username after it's been created. -->
                    Username: ${customer.username}


                    <form:hidden path="username" value="${username}"/>
                </div>
            </c:when>
            <c:otherwise>

                <div class="col">
                    <form:input path="username" placeholder="Username" autocomplete="off"/>
                    <form:errors path="username"/>
                </div>

            </c:otherwise>

        </c:choose>
    </div>

    <div class="row">
        <div class="col">
            <form:password path="password" placeholder="Password" autocomplete="new-password"/>
            <form:errors path="password"/>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <form:input path="firstName" placeholder="Firstname" autocomplete="off"/>
            <form:errors path="firstName"/>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form:input path="surName" placeholder="Surname" autocomplete="off"/>
            <form:errors path="surName"/>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form:input path="email" placeholder="Email" autocomplete="off"/>
            <form:errors path="email"/>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form:input path="phoneNumber" placeholder="Phonenumber" autocomplete="off"/>
            <form:errors path="phoneNumber"/>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="agreeCheckbox">
                <label class="form-check-label" for="agreeCheckbox">
                    Agree to terms
                </label>


                <input class="btn btn-info" type="submit" value="Register" id="registerButton" disabled/>
            </div>
        </div>
    </div>

</div>
</form:form>


<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>