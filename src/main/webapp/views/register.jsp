<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="partials/header.jsp" />
<div class="container">
    <h2>Create an Account</h2>

    <form action="<%= request.getContextPath() %>/register" method="post">
        <input type="hidden" name="action" value="register" />

        <label>Full Name:</label>
        <input type="text" name="name" required>

        <label>Email:</label>
        <input type="email" name="email" required>

        <label>Password:</label>
        <input type="password" name="password" required>

        <label>Select Role:</label>
        <select name="role" required>
            <option value="">-- Choose a Role --</option>
            <option value="farmer">Farmer</option>
            <option value="consumer">Consumer</option>
        </select>

        <label>Location:</label>
        <input type="text" name="location" placeholder="e.g., Ottawa, ON" required>

        <button type="submit">Register</button>
    </form>

    <p>Already have an account? <a href="login.jsp">Login here</a></p>
</div>
<jsp:include page="partials/footer.jsp" />
