<?php

$hostname = getenv('MYSQL_DB_HOST');
$database = getenv('MYSQL_DB_NAME');
$username = getenv('MYSQL_DB_USER');
$password = getenv('MYSQL_DB_PASSWORD');

try {
    $pdo = new PDO("mysql:host=$hostname;dbname=$database", $username, $password, array(
        PDO::ATTR_PERSISTENT => true
    ));

    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    echo "Connected successfully";

    $query = "SELECT * FROM products";

    $statement = $pdo->prepare($query);
    $statement->execute();

    $results = $statement->fetchAll(PDO::FETCH_ASSOC);

	echo "<br>";
	echo "<br> ------------------- <br>";

    foreach ($results as $row) {
        echo "<br>";
		echo "ID: " . $row['id'] . "<br>";
		echo "Name: " . $row['name'] . "<br>";
		echo "Price: " . $row['price'] . "<br>";
		echo "Description: " . $row['description'] . "<br>";
		echo "<br> ------------------- <br>";
    }
} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
}
