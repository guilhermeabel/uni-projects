<?php

namespace App\Controllers;

abstract class BaseController  {

	protected function redirect(string $page, array $data = []) {
		extract($data);
		return require_once __DIR__ . "/../Views/$page.php";
	}
}
