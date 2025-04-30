<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="partials/header.jsp" />
<!DOCTYPE html>
<html>
<head>
    <title>Registration Successful</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/static/css/style.css">
    <style>
        .message-container {
            max-width: 600px;
            margin: 80px auto;
            background: #e6f7e6;
            padding: 30px;
            text-align: center;
            border-radius: 10px;
            border: 1px solid #b2d8b2;
            color: #2c662d;
        }
    </style>
</head>
<body>
    <div class="message-container">
        <h2>Registration Successful!</h2>
        <p>You can now <a href="login.jsp">log in</a> to your account.</p>
    </div>
</body>
</html>
<jsp:include page="partials/footer.jsp" />