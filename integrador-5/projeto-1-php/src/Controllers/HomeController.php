<?php

namespace App\Controllers;

use App\Database\MySQLDatabase;

class HomeController extends BaseController {
	private MySQLDatabase $database;

	public function __construct() {
		$this->database = MySQLDatabase::getInstance();
	}

	public function index() {
		$pets =	$this->database->query("SELECT * FROM pets LIMIT 3");

		return $this->redirect("home", ['pets' => $pets]);
	}
}
