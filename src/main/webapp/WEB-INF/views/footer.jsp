<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="requestPath" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<hr>

<p>
<!-- Print login and logout links: -->

<c:choose>
    <c:when test="${requestPath.equals('/customer/create')}">
        <!-- Login and logout link are not shown on registration page(s). -->
    </c:when>
    <c:otherwise>

        <!-- Print login link -->
        <security:authorize access="isAnonymous()">
            <p>
                <a href="/login">Login</a> with username and password.
            </p>

            <p>
                Don't have an account yet? Register as a <a href="/customer/create">new customer</a> or a new lender.
            </p>
        </security:authorize>

        <!-- Print logout link -->
        <security:authorize access="isAuthenticated()">
            <p>
                <a href="/logout">Logout</a>
            </p>
        </security:authorize>

    </c:otherwise>

</c:choose>

<!-- Show a link to index page if we are not there already. -->
<c:choose>
    <c:when test="${!requestPath.equals('/')}">
        <p>
            Return to <a href="/">main menu.</a>
        </p>
    </c:when>
</c:choose>

<!-- Print out user role of current user: -->
(
<security:authorize access="isAuthenticated()">
    username: <security:authentication property="principal.username"/>,
</security:authorize>
current role:
<security:authorize access="hasRole('ADMIN')">admin</security:authorize>
<security:authorize access="hasRole('CUSTOMER')">customer</security:authorize>
<security:authorize access="isAnonymous()">anonymous</security:authorize>
)

</p>
</div>