<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="partials/header.jsp" />

<div class="container">
    <h2>Login Failed</h2>
    <p style="color: red;">Invalid email or password. Please try again.</p>

    <a href="<%= request.getContextPath() %>/views/login.jsp">
        <button>Return to Login</button>
    </a>
</div>

<jsp:include page="partials/footer.jsp" />