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