<?php

namespace App\Controllers;

use App\Database\MySQLDatabase;

class DonationController extends BaseController {
	private MySQLDatabase $database;

	public function __construct() {
		$this->database = MySQLDatabase::getInstance();
	}

	public function index() {
		return require_once __DIR__ . '/../Views/donation.php';
	}

	public function store() {
		if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
			return;
		}

		$errors = [];

		if (!isset($_POST['email'])) {
		
			$errors['email'] = 'E-mail obrigatório';
		}

		if (!isset($_POST['amount'])) {
			$errors['amount'] = 'Valor obrigatório';
		}

		if (!isset($_POST['document'])) {
			$errors['document'] = 'CPF obrigatório';
		}

		if (!empty($errors)) {
			return $this->redirect("donation", ['errors' => $errors]);
		}

		$email = $_POST['email'];
		$amount = $_POST['amount'];
		$document = $_POST['document'];
		$method = $_POST['donation-method'];

		try {

			$this->database->beginTransaction();
			$this->database->query("INSERT INTO donations (name, email, amount, method) VALUES ('$email', '$email', $amount, $method)");
			
			$user = $this->database->query("SELECT * FROM users WHERE email = '$email'");
			if (empty($user)) {
				$this->database->query("INSERT INTO users (document, name, email) VALUES ('$document', '$email', '$email')");
			}

			$this->database->commit();
		} catch (\Exception $e) {
			$this->database->rollBack();

			$errors['database'] = 'Erro ao efetuar a doação. Tente novamente mais tarde.';
			return;
		}

		$info = [
			'email' => $email,
			'amount' => $amount,
			'document' => $document,
			'date' => date('Y-m-d H:i:s')
		];

		return $this->redirect("thank-you", ['info' => $info]);
	}

}
