<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Address Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h2>Address Form</h2>
            <form action="/electra/addressController" method="POST">

            <div class="form-group">
                <label for="id">Id:</label>
                 <input type="text" class="form-control" id="id" name="id" required>
             </div>

                <div class="form-group">
                    <label for="street">Street:</label>
                    <input type="text" class="form-control" id="street" name="street" required>
                </div>
                <div class="form-group">
                    <label for="city">City:</label>
                    <input type="text" class="form-control" id="city" name="city" required>
                </div>
                <div class="form-group">
                    <label for="state">State:</label>
                    <input type="text" class="form-control" id="state" name="state">
                </div>
                <div class="form-group">
                    <label for="country">Country:</label>
                    <input type="text" class="form-control" id="country" name="country" required>
                </div>
                <div class="form-group">
                    <label for="postal_code">Postal Code:</label>
                    <input type="text" class="form-control" id="postal_code" name="postal_code" required>
                </div>
                <input type="submit" class="btn btn-primary" value="Submit">
            </form>
        </div>
    </div>
</body>
</html>
