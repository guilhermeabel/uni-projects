<?php

namespace App\Model;

use App\Database\MySQLDatabase;

class Pet {
	private MySQLDatabase $database;

	public function __construct() {
		$this->database = MySQLDatabase::getInstance();
	}

	public function all() {
		return $this->database->query("SELECT * FROM pets");
	}

	public function latest() {
		return $this->database->query("SELECT * FROM pets ORDER BY id DESC LIMIT 3");
	}

	public function find(int $id) {
		return $this->database->query("SELECT * FROM pets WHERE id = $id");
	}

	public function create(array $data) {
		$name = $data['name'];
		$age = $data['age'];
		$breed = $data['breed'];
		$description = $data['description'];
		$photo = $data['photo'];

		$this->database->query("INSERT INTO pets (name, age, breed, description, photo) VALUES ('$name', '$age', '$breed', '$description', '$photo')");
	}

	public function update(int $id, array $data) {
		$name = $data['name'];
		$age = $data['age'];
		$breed = $data['breed'];
		$description = $data['description'];
		$photo = $data['photo'];

		$this->database->query("UPDATE pets SET name = '$name', age = '$age', breed = '$breed', description = '$description', photo = '$photo' WHERE id = $id");
	}

	public function delete(int $id) {
		$this->database->query("DELETE FROM pets WHERE id = $id");
	}
}
