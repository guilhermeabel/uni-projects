<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Doação</title>
		<link rel="stylesheet" href="assets/CSS/main.css">

		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
		<script src="assets/JS/main.js" defer></script>
	</head>

	<body class="donate-body">
		<section class="form-container">
			<a href="/"><img src="assets/Images/web-house.png" alt="Home"></a>
			<h2>4Patas - Doação</h2>
			<div class='mb-3'>
				<p id="fill-text">Preencha seu email e CPF e escolha um método de pagamento</p>
			</div>
			<form action="/donate" method="post" name="donate-form">
				<div class='mb-3'>
					<label class="form-label" for="email">E-mail:</label>
					<input class="form-control" type="email" name="email" placeholder="Seu e-mail" required>
					<div class="invalid-feedback">
						<?= ($errors && isset($errors['email'])) ? $errors['email'] : '' ?>
					</div>
				</div>
				<div class='mb-3'>
					<label class="form-label" for="cpf">CPF:</label>
					<input oninput="this.value = parseCpf(this.value)" class="form-control" type="text" name="document" placeholder="Seu CPF" minlength="14" maxlength="14" required>
					<div class="invalid-feedback">
						<?= ($errors && isset($errors['document'])) ? $errors['document'] : '' ?>
					</div>
				</div>
				<div class='mb-3'>
					<label class="form-label" for="value">Valor:</label>
					<input class="form-control" type="number" name="amount" placeholder="Valor da doação" required>
					<div class="invalid-feedback">
						<?= ($errors && isset($errors['amount'])) ? $errors['amount'] : '' ?>
					</div>
				</div>
				<div class='mb-3'>
					<label class="form-label" for="donation-method">Escolha a forma de doação:</label>
					<div class="form-check">
						<input class="form-check-input" id="pix" type="radio" name="donation-method" value="pix" checked>
						<label class="form-check-label" for="pix">Pix</label>
					</div>
					<div class="form-check">
						<input class="form-check-input" id="credit-card" type="radio" name="donation-method" value="credit-card">
						<label class="form-check-label" for="credit-card">Cartão de Crédito</label>
					</div>
					<div class="form-check">
						<input class="form-check-input" id="paypal" type="radio" name="donation-method" value="paypal">
						<label class="form-check-label" for="paypal">Paypal</label>
					</div>
					<div class="form-check">
						<input class="form-check-input" id="bank-slip" type="radio" name="donation-method" value="bank-slip">
						<label class="form-check-label" for="bank-slip">Boleto</label>
					</div>
					<div class="invalid-feedback">
						<?= ($errors && isset($errors['donation-method'])) ? $errors['donation-method'] : '' ?>
						<?= ($errors && isset($errors['database'])) ? $errors['database'] : '' ?>
					</div>
				</div>
				<input type="submit" value="Confirmar">
			</form>
		</section>
		</main>
		<footer id="donation-footer">
			<p>2023 Instituição 4Patas. Todos os direitos reservados.</p>
		</footer>
	</body>

</html>
