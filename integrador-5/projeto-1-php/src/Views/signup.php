<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Criar conta</title>
		<link rel="stylesheet" href="assets/CSS/main.css">

		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
		<script src="assets/JS/main.js" defer></script>
	</head>

	<body class="donate-body">
		<section class="form-container">
			<a href="/"><img src="assets/Images/web-house.png" alt="Home"></a>
			<h2>4Patas - Cadastro</h2>
			<div class='mb-3'>
				<p id="fill-text">Preencha seu email, nome, telefone e CPF</p>
			</div>
			<form action="/signup" method="post" name="donate-form">
				<div class='mb-3'>
					<label class="form-label" for="email">E-mail:</label>
					<input class="form-control" type="email" name="email" placeholder="Seu e-mail" required>
					<div class="invalid-feedback">
						<?= ($errors && isset($errors['email'])) ? $errors['email'] : '' ?>
					</div>
				</div>
				<div class='mb-3'>
					<label class="form-label" for="name">Nome:</label>
					<input class="form-control" type="text" name="name" placeholder="Seu nome" required>
					<div class="invalid-feedback">
						<?= ($errors && isset($errors['name'])) ? $errors['name'] : '' ?>
					</div>
				</div>
				<div class='mb-3'>
					<label class="form-label" for="phone">Telefone:</label>
					<input class="form-control" type="text" name="phone" placeholder="Seu telefone" required>
					<div class="invalid-feedback">
						<?= ($errors && isset($errors['phone'])) ? $errors['phone'] : '' ?>
					</div>
				</div>
				<div class='mb-3'>
					<label class="form-label" for="cpf">CPF:</label>
					<input oninput="this.value = parseCpf(this.value)" class="form-control" type="text" name="document" placeholder="Seu CPF" minlength="14" maxlength="14" required>
					<div class="invalid-feedback">
						<?= ($errors && isset($errors['document'])) ? $errors['document'] : '' ?>
					</div>
				</div>
				
				</div>
				<div class="invalid-feedback">
					<?= ($errors && isset($errors['database'])) ? $errors['database'] : '' ?>
				</div>
				<input type="submit" value="Criar Conta">
			</form>
		</section>
		</main>
		<footer id="donation-footer">
			<p>2023 Instituição 4Patas. Todos os direitos reservados.</p>
		</footer>
	</body>

</html>
