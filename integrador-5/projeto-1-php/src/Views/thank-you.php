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
				<p><b>Obrigado por sua doação. Você faz toda a diferença!<b></p>
			</div>

			<div class='mb-3'>
				<p>Aqui está o seu comprovante:</p>
			</div>

			<div class='mb-3'>
				<p>E-mail: <?= $info['email'] ?></p>
			</div>

			<div class='mb-3'>
				<p>Valor: <?= $info['amount'] ?></p>
			</div>

			<div class='mb-3'>
				<p>Data: <?= $info['date'] ?></p>
			</div>
			<a href="/"><button type="button" class="btn btn-primary">Voltar para a Home</button></a>
		
		</section>
		</main>
		<footer id="donation-footer">
			<p>2023 Instituição 4Patas. Todos os direitos reservados.</p>
		</footer>
	</body>

</html>
