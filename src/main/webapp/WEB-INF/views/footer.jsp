<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<s:eval expression="T(com.airpnp.authorization.SecurityConfig).getCurrentlyLoggedInUser().getUsername()" var="loggedInUsername" />
<hr>
<p>
    Return to <a href="/">main menu.</a>
</p>
<p>
    <a href="/logout">[Logout: ${loggedInUsername}]</a>
</p>