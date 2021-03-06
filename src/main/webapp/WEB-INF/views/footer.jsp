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
            <a href="/customer/create" class="btn btn-danger mx-1">
                Register new account
            </a>
        </security:authorize>

        <%-- Show logout button when user is logged in: --%>
        <security:authorize access="isAuthenticated()">
            <a href="/logout" class="btn btn-danger">
                Sign out
            </a>
        </security:authorize>

    </c:otherwise>

</c:choose>

<!-- Show a link to index page if we are not there already. -->
<%--
<c:choose>
    <c:when test="${!requestPath.equals('/')}">
        <p>
            Return to <a href="/">main menu.</a>
        </p>
    </c:when>
</c:choose>
--%>

<!-- Print out user role of current user: -->
<security:authorize access="isAuthenticated()">
    Signed in as: <security:authentication property="principal.username"/>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">(admin)</security:authorize>
<security:authorize access="hasRole('CUSTOMER')">(customer)</security:authorize>

</p>
</div>