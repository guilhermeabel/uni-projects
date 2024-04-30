<?php

require_once __DIR__ . '/../vendor/autoload.php';

use App\Database\MySQLDatabase;
use App\Web\Router;

$hostname = getenv('MYSQL_DB_HOST');
$database = getenv('MYSQL_DB_NAME');
$username = getenv('MYSQL_DB_USER');
$password = getenv('MYSQL_DB_PASSWORD');

try {
	$databaseConnection = MySQLDatabase::getInstance();
	$databaseConnection->setPersistent(true);
	$databaseConnection->connect($hostname, $database, $username, $password);
} catch (Exception $e) {
	echo 'Error connecting to the database.';
}

$homeController = new \App\Controllers\HomeController();
$donationController = new \App\Controllers\DonationController();
$userController = new \App\Controllers\UserController();

$router = new Router();
$router->get('/', fn () => $homeController->index());
$router->get('/signup', fn () => $userController->create());
$router->post('/signup', fn () => $userController->store());
$router->post('/donate', fn () => $donationController->store());
$router->get('/donation', fn () => $donationController->index());

$router->handleRequest();



