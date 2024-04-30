<?php

namespace App\Model;

use App\Database\MySQLDatabase;

class Donation {
	private MySQLDatabase $database;

	public function __construct() {
		$this->database = MySQLDatabase::getInstance();
	}

	public function all() {
		return $this->database->query("SELECT * FROM donations");
	}

	public function find(int $id) {
		return $this->database->query("SELECT * FROM donations WHERE id = $id");
	}

	public function create(array $data) {
		$email = $data['email'];
		$amount = $data['amount'];
		$document = $data['document'];
		$method = $data['method'];

		$this->database->query("INSERT INTO donations (email, amount, document, method) VALUES ('$email', '$amount', '$document', '$method')");
	}

	public function update(int $id, array $data) {
		$email = $data['email'];
		$amount = $data['amount'];
		$document = $data['document'];
		$method = $data['method'];

		$this->database->query("UPDATE donations SET email = '$email', amount = '$amount', document = '$document', method = '$method' WHERE id = $id");
	}

	public function delete(int $id) {
		$this->database->query("DELETE FROM donations WHERE id = $id");
	}
}
