<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="/views/partials/header.jsp" />
<div class="container">
    <h2>Login</h2>
    <form action="<%= request.getContextPath() %>/login" method="post">
        <input type="hidden" name="action" value="login" />
        <label>Email:</label>
        <input type="email" name="email" required>

        <label>Password:</label>
        <input type="password" name="password" required>

        <button type="submit">Login</button>
    </form>

    <p>Don't have an account? <a href="<%= request.getContextPath() %>/views/register.jsp">Register here</a></p>
</div>
<jsp:include page="/views/partials/footer.jsp" />
