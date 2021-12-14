<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<s:eval expression="T(com.airpnp.authorization.SecurityConfig).getCurrentlyLoggedInUser()" var="loggedInUser"/>
<hr>
<p>
    Return to <a href="/">main menu.</a>
</p>
<p>
    <c:choose>
        <c:when test="${loggedInUser != null}">
            <a href="/logout">[Logout: ${loggedInUser.getUsername()}]</a>
        </c:when>
    </c:choose>
</p>