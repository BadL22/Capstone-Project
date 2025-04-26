<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="partials/header.jsp" />
<div class="container">
    <h2>Create a New Listing</h2>
    <form action="listings" method="post">
        <label>Name of Produce:</label>
        <input type="text" name="name" required>

        <label>Category:</label>
        <input type="text" name="category" required>

        <label>Description:</label>
        <textarea name="description" required></textarea>

        <label>Price ($):</label>
        <input type="number" step="0.01" name="price" required>

        <label>Available:</label>
        <input type="checkbox" name="available" value="true" checked>

        <button type="submit">Post Listing</button>
    </form>
</div>
<jsp:include page="partials/footer.jsp" />
