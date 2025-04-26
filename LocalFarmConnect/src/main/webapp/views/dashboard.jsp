<%@ page contentType="text/html;charset=UTF-8" %>
<%
    if (session == null || session.getAttribute("userEmail") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<jsp:include page="partials/header.jsp" />
<div class="container">
    <h2>Welcome to Your Dashboard!</h2>
    <p>Logged in as: <strong><%= session.getAttribute("userEmail") %></strong></p>

    <form action="logout" method="post">
        <button type="submit">Logout</button>
    </form>
</div>
<jsp:include page="partials/footer.jsp" />