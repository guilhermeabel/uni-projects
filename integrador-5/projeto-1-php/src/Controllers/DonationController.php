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
			return $this->view("donation", ['errors' => $errors]);
		}

		$email = $_POST['email'];
		$amount = $_POST['amount'];
		$document = $_POST['document'];
		$method = $_POST['donation-method'];

		try {
			# Isso deveria ser feito em uma camada de serviço, mas para o escopo do trabalho, não tem necessidade
			$this->database->beginTransaction();

			$userModel = new \App\Model\User();
			$user = $userModel->findByEmail($email);

			if (empty($user)) {
				$userModel->create([
					'email' => $email,
					'name' => $email,
					'document' => $document
				]);

				$user = $userModel->findByEmail($email);
			}

			$donationModel = new \App\Model\Donation();
			$donationModel->create([
				'email' => $email,
				'amount' => $amount,
				'document' => $document,
				'method' => $method
			]);
			
			
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

		$_POST = [];

		return $this->view("thank-you", ['info' => $info]);
	}

}
