<html>
    <body>
        <h2>Hello World of JSPs!</h2>
        <form
            action="http://localhost:8080/IntroToJavaEE-1.0-SNAPSHOT/myServlet"
            method="post"
            enctype="application/x-www-form-urlencoded"
        >
            <!-- form fields -->
            <input type="text" name="username">
            <input type="password" name="password">

            <!-- submit button -->
            <input type="submit" value="Submit">
        </form>

        <form
            id="JSON_FORM"
        >
            <!-- form fields -->
            <input type="text" name="username">
            <input type="password" name="password">

            <!-- submit button -->
            <input type="submit" value="Submit">
        </form>

        <script>
            document.getElementById("JSON_FORM")
                .addEventListener("submit", function(event) {
                    event.preventDefault(); // Prevent default form submission behavior

                    // Serialize form data into JSON
                    const formData = new FormData(event.target);
                    const jsonObject = {};
                    formData.forEach((value, key) => {
                        jsonObject[key] = value;
                    });

                    // Send the JSON data to the server using fetch API or XMLHttpRequest
                    // Here, we'll use the fetch API for simplicity
                    fetch("http://localhost:8080/IntroToJavaEE-1.0-SNAPSHOT/myJsonServlet", {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        body: JSON.stringify(jsonObject)
                    })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error("Network response was not ok");
                        }
                        return response.json();
                    })
                    .then(data => {
                        // Handle the response from the server
                        console.log(data);
                    })
                    .catch(error => {
                        // Handle any errors that occurred during the fetch request
                        console.error("Error:", error);
                    });
                });
        </script>
    </body>
</html>
