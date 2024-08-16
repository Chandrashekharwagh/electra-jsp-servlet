<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Orders Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h2>Orders Form</h2>
            <form action="/electra/orderController" method="POST">
                <div class="form-group">
                    <label for="id">Order ID:</label>
                    <input type="id" class="form-control" id="id" name="id" required>
                </div>
                <div class="form-group">
                    <label for="product_id">Product ID:</label>
                    <input type="number" class="form-control" id="product_id" name="product_id" required>
                </div>
                <div class="form-group">
                    <label for="customer_id">Customer ID:</label>
                    <input type="number" class="form-control" id="customer_id" name="customer_id" required>
                </div>
                <div class="form-group">
                    <label for="order_date">Order Date:</label>
                    <input type="date" class="form-control" id="order_date" name="order_date" required>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</body>
</html>
