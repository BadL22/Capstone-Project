<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>LocalFarm Connect</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/static/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
</head>
<body>
    <header>
        <h1>LocalFarm Connect</h1>
        <nav>
            <a href="<%= request.getContextPath() %>/views/dashboard.jsp">Dashboard</a>
            <a href="<%= request.getContextPath() %>/views/listings.jsp">Listings</a>
            <a href="<%= request.getContextPath() %>/views/listingForm.jsp">New Listing</a>
        </nav>
    </header>
