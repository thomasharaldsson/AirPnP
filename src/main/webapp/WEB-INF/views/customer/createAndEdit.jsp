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

            $('[data-bs-toggle="tooltip"]').tooltip();

        });
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>


<div class="d-flex justify-content-center registratioForm">

    <form:form modelAttribute="customer" action="${action}" autocomplete="off">
        <form:errors path="" element="div"/>

        <form:hidden path="id" value="${id}"/>


        <div class="row registrationFormRow">
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


        <div class="row registrationFormRow">
            <div class="col">
                <c:choose>
                    <c:when test="${edit != null && edit == true}">

                        <!-- Editing customer: you can't edit username after it's been created. -->
                        Username: ${customer.username}
                        <form:hidden path="username" value="${username}"/>

                    </c:when>
                    <c:otherwise>

                        <form:input class="form-control" path="username" placeholder="Username" autocomplete="off"
                                    data-bs-toggle="tooltip"
                                    data-bs-placement="right" title="Username"/>
                        <form:errors path="username"/>

                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <div class="row registrationFormRow">
            <div class="col">
                <form:password class="form-control" path="password" placeholder="Password" autocomplete="new-password"
                               data-bs-toggle="tooltip"
                               data-bs-placement="right" title="Password"/>
                <form:errors path="password"/>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <form:input class="form-control" path="firstName" placeholder="Firstname" autocomplete="off"
                            data-bs-toggle="tooltip"
                            data-bs-placement="right" title="Firstname"/>
                <form:errors path="firstName"/>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <form:input class="form-control" path="surName" placeholder="Surname" autocomplete="off"
                            data-bs-toggle="tooltip"
                            data-bs-placement="right" title="Surname"/>
                <form:errors path="surName"/>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <form:input class="form-control" path="email" placeholder="Email" autocomplete="off"
                            data-bs-toggle="tooltip"
                            data-bs-placement="right" title="Email"/>
                <form:errors path="email"/>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <form:input class="form-control" path="phoneNumber" placeholder="Phonenumber" autocomplete="off"
                            data-bs-toggle="tooltip"
                            data-bs-placement="right" title="Phone number"/>
                <form:errors path="phoneNumber"/>
            </div>
        </div>

        <div class="row">

            <div class="col">

                <div class="d-flex">

                        <%-- show agree to terms if on registration page- --%>
                    <c:if test="${!edit}">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="agreeCheckbox">
                            <label class="form-check-label" for="agreeCheckbox">
                                Agree to terms
                            </label>
                        </div>
                    </c:if>

                    <c:if test="${!edit}">
                        <div class="ms-auto">
                            <input class="btn btn-info" type="submit" value="Register" id="registerButton" disabled/>
                        </div>
                    </c:if>

                    <c:if test="${edit}">
                        <div class="ms-auto">
                            <input class="btn btn-info" type="submit" value="Save"/>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>


    </form:form>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>