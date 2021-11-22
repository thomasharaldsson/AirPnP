<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
<h1>Create new parking Space</h1>

<form:form modelAttribute="form">

<form>
        <form:errors path="" element="div"/>
    <div>
        <form:label path="price">Price</form:label>
        <form:input path="price"/>
        <form:errors path="price"/>
    </div>
    <!--
    <div>
        <form:label path="startDate">Start date</form:label>
        <form:input path="startDate"/>
        <form:errors path="startDate"/>
    </div>
    <div>
        <form:label path="endDate">End date</form:label>
        <form:input path="endDate"/>
        <form:errors path="endDate"/>
    </div>
    -->
    <div>
        <form:label path="streetAddress">Street address</form:label>
        <form:input path="streetAddress"/>
        <form:errors path="streetAddress"/>
    </div>
    <div>
        <input type="submit"/>
    </div>
    </form:form>

</body>
</html>