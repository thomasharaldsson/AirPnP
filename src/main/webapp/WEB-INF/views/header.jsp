<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="requestPath" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<!DOCTYPE HTML>
<div class="container">

    <div class="d-flex justify-content-between">

        <%-- This div element is left justified --%>
        <div class="p-2 h1 text-danger">AirPnP</div>

        <div class="p-2">
            <%-- This div element is right justified --%>
            <div class="d-flex justify-content-end">

                <%-- Show "Available parkingspaces" button except when on that page: --%>
                <c:choose>
                    <c:when test="${!requestPath.equals('/parkingspace/showall')}">
                        <a href="/parkingspace/showall" class="btn btn-danger mx-1">
                            Available parkingspaces
                        </a>
                    </c:when>
                </c:choose>

                <%-- Show login button when not logged in: --%>
                <security:authorize access="isAnonymous()">
                    <a href="/login" class="btn btn-danger mx-1">
                        Login
                    </a>
                </security:authorize>

            </div>
        </div>
    </div>

