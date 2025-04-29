<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="partials/header.jsp" />
<div class="container">
    <h2>Fresh Produce Near You</h2>
    <div class="listings-grid">
        <!-- This should be dynamically generated with JSTL or a servlet loop -->
        <div class="listing-card">
            <img src="../static/images/sample.png" alt="Tomatoes">
            <div class="content">
                <h3>Organic Tomatoes</h3>
                <p>$2.99 / lb</p>
                <p>Category: Vegetable</p>
                <p>Farmer: John's Farm</p>
                <button>Order Now</button>
            </div>
        </div>
        <div class="listing-card">
            <img src="photo_soon.png" alt="Eggs">
            <div class="content">
                <h3>Free-Range Eggs</h3>
                <p>$5.00 / dozen</p>
                <p>Category: Dairy</p>
                <p>Farmer: Green Hills Farm</p>
                <button>Order Now</button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="partials/footer.jsp" />
