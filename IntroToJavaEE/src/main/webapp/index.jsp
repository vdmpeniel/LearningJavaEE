<html>
    <body>
        <h2>Hello World of JSPs!</h2>
        <form
            action="http://localhost:8080/IntroToJavaEE-1.0-SNAPSHOT/myServlet"
            method="post"
            enctype="multipart/form-data"
        >
            <!-- form fields -->
            <input type="text" name="username">
            <input type="password" name="password">

            <!-- submit button -->
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
