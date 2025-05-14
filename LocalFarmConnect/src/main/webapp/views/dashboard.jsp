<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:include page="partials/header.jsp" />

<%
    model.User user = (model.User) request.getAttribute("user");
    String role = (String) request.getAttribute("role");
%>

<div class="container">
    <h2>Welcome, <%= user != null ? user.getName() : "User" %>!</h2>
    <p>You are logged in as a <strong><%= role != null ? role : "unknown" %></strong>.</p>

    <% if ("farmer".equalsIgnoreCase(role)) { %>
        <h3>Farmer Dashboard</h3>
        <ul>
            <li><a href="#">Add New Product</a></li>
            <li><a href="#">Manage Listings</a></li>
            <li><a href="#">View Orders</a></li>
        </ul>
    <% } else if ("consumer".equalsIgnoreCase(role)) { %>
        <h3>Consumer Dashboard</h3>
        <ul>
            <li><a href="<%= request.getContextPath() %>/listings">Browse Products</a></li>
            <li><a href="#">My Orders</a></li>
        </ul>
    <% } else { %>
        <p>Unknown role.</p>
    <% } %>

    <form action="<%= request.getContextPath() %>/logout" method="post" style="margin-top: 20px;">
        <button type="submit">Logout</button>
    </form>
</div>

<jsp:include page="partials/footer.jsp" />
