<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="requestPath" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<!DOCTYPE HTML>
<div class="container">

    <div class="d-flex justify-content-between">

        <%-- This div element is left justified --%>
        <div class="p-2 h1 text-danger">
            <c:choose>
                <c:when test="${requestPath.equals('/')}">
                    AirPnP
                </c:when>
                <c:otherwise>
                    <%-- Link to homepage if not on it already: --%>
                    <a class="deco-none" href="/" data-toggle="tooltip" data-placement="bottom" title="Return to start page">AirPnP</a>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="p-2">
            <%-- This div element is right justified --%>
            <div class="d-flex justify-content-end">


                <%-- Show login button when not logged in: --%>
                <security:authorize access="isAnonymous()">
                    <a href="/login" class="btn btn-danger mx-1">
                        Login
                    </a>
                </security:authorize>

                <%-- Show "Available parkingspaces" button except when on that page or on the home page: --%>
                <div>
                    <c:choose>
                        <c:when test="${!requestPath.equals('/parkingspace/showall') && !requestPath.equals('/')}">
                            <a href="/parkingspace/showall" class="btn btn-danger mx-1">
                                Available parkingspaces
                            </a>
                        </c:when>
                    </c:choose>
                </div>

                <%-- Show dropdown menu if user is logged in: --%>
                <security:authorize access="isAuthenticated()">
                    <div class="dropdown">
                        <button class="btn btn-danger dropdown-toggle" type="button" id="dropdownMenuButton1"
                                data-bs-toggle="dropdown" aria-expanded="false">
                            Menu
                        </button>

                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                            <li><a class="dropdown-item " href="/customer/showall">Manage customers</a></li>
                            <security:authorize access="hasRole('CUSTOMER')">
                                <li><a class="dropdown-item" href="/vehicle/showall">Manage vehicles</a></li>
                            </security:authorize>

                            <security:authorize access="hasRole('ADMIN')">
                                <li><a class="dropdown-item" href="#">Show all my parkingspaces</a></li>
                                <li><a class="dropdown-item" href="/parkingspace/create">create</a> a new parkingpsace
                                </li>
                            </security:authorize>

                            <security:authorize access="hasRole('CUSTOMER')">
                                <li><a class="dropdown-item" href="/rentalticket/showall">Manage Rental Tickets</a></li>
                                <li><a class="dropdown-item" href="/customer/edit/<security:authentication property="principal.customer.id"/>">My user profile</a></li>
                            </security:authorize>
                        </ul>
                    </div>
                </security:authorize>
            </div>

        </div>

    </div>

