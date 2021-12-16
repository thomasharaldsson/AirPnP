<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<hr>
<p>
    Return to <a href="/">main menu.</a>
</p>
<p>
    <security:authorize access="isAuthenticated()">
        <a href="/logout">Logout: <security:authentication property="principal.username"/></a>
Add information about which  a        <br/>
    </security:authorize>

    <security:authorize access="hasRole('LENDER')">
        You are a Lender.
    </security:authorize>

    <security:authorize access="hasRole('CUSTOMER')">
        You are a Customer.
    </security:authorize>

    <security:authorize access="isAnonymous()">
        You are an anonymous user.
    </security:authorize>
</p>