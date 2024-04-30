<?php

namespace App\Controllers;

class HomeController extends BaseController {

	public function index() {
		$pets = (new \App\Model\Pet())->latest();

		return $this->view("home", ['pets' => $pets]);
	}
}
