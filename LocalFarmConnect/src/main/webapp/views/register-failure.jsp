<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="partials/header.jsp" />
<!DOCTYPE html>
<html>
<head>
    <title>Registration Failed</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/static/css/style.css">
    <style>
        .container {
            text-align: center;
            padding: 50px;
            background-color: #fff0f0;
            border: 1px solid #ffcccc;
            margin: 100px auto;
            width: 60%;
            border-radius: 10px;
            color: #c0392b;
            font-family: 'Poppins', sans-serif;
        }
        a {
            color: #4C7031;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Registration Failed</h1>
        <p>Something went wrong while creating your account.</p>
        <p>Please make sure your details are correct and try again.</p>
        <p><a href="register.jsp">Go back to registration</a></p>
    </div>
</body>
</html>
<jsp:include page="partials/footer.jsp" />