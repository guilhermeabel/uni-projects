<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="assets/CSS/main.css">

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

	<title>4Patas</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg">
		<div class="container-xl">
			<a class="navbar-brand" href="#">
				<img src="./assets/Images/logo.png" alt="Logo" width="50" class="d-inline-block me-3">
				<b>4Patas</b></a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-control"
				aria-controls="navbar-control" aria-expanded="false" aria-label="Navegar">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse p-3 bg-white" id="navbar-control">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="#">Início</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Nossos pets</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#about">Quem somos</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Voluntários</a>
					</li>

				</ul>
				<div class="d-lg-flex col-lg-4 justify-content-lg-end">
					<a href="signup" class="btn btn-link">Criar conta</a>
					<a href="donation" class="btn donation">Faça uma doação</a>
				</div>
			</div>
		</div>
	</nav>

	<div class="content">
		<div class="main container">
			<div class="main-banner">
				<h1>4Patas</h1>
				<p>Seja bem-vindo!</p>
				<p>Na 4Patas, acreditamos no poder da compaixão e na capacidade de fazer a diferença na vida dos animais
					que precisam. Somos uma organização dedicada ao resgate, reabilitação e adoção de animais de
					estimação em situações de vulnerabilidade. Nossa missão é fornecer um lar amoroso e seguro para
					animais abandonados, abusados ou em perigo, enquanto promovemos a conscientização sobre a
					importância da adoção responsável.</p>
			</div>

			<div class="row mt-5">
				<section class="adoption-container">
					<h3>Adote um de nossos pets!</h3>
					<p>Escolha o bichinho perfeito pra você.</p>
				</section>
				<?php foreach ($pets as $pet) : ?>
				<div class="col-sm-6 col-md-6 col-lg-4 mb-4">
					<div class="card">
						<img src="./assets/Images/<?= $pet['photo'] ?>" class="card-img-top" alt="<?= $pet['name'] ?>">
						<div class="card-body">
							<h5 class="card-title"><?= $pet['name'] ?></h5>
							<p class="card-text"><?= $pet['description'] ?></p>
							<ul class="list-group list-group-flush">
								<li class="list-group-item"><b>Idade</b>: <?= $pet['age'] ?></li>
								<li class="list-group-item"><b>Porte</b>: <?= $pet['size'] ?></li>
								<li class="list-group-item"></li>
							</ul>
							<a href="#" class="btn donation">Conhecer</a>
						</div>
					</div>
				</div>
				<?php endforeach; ?>
			</div>

			</section>
			<section class="banners-container">
				<div class="banner">
					<img src="./assets/Images/banner-one.png" alt="Gato de barriga para cima" class="banner-img">
					<img src="./assets/Images/banner-two.png" alt="Cachorro com a pata para cima" class="banner-img">
					<img src="./assets/Images/banner-three.jpg" alt="Gato olhando para a direita" class="banner-img">
					<img src="./assets/Images/banner-four.jpg" alt="Gato dormindo" class="banner-img">
					<img src="./assets/Images/banner-five.jpg" alt="Gato dormindo" class="banner-img">
				</div>

				<p>
					<a href="#" class="btn donation">Veja mais</a>
				</p>

			</section>
			<section class="mission-and-values">
				<h3>Missão</h3>
				<ol>
					<li><strong>Resgate e Reabilitação:</strong> Trabalhamos incansavelmente para resgatar animais
						em
						situações de risco,
						oferecendo cuidados médicos, nutrição adequada e um ambiente seguro. Acreditamos que todos
						os
						animais merecem uma segunda chance.</li>
					<li><strong>Promoção da Adoção Responsável:</strong> Estamos comprometidos em encontrar lares
						amorosos e permanentes
						para nossos resgatados. Fornecemos a cada adotante potencial informações e orientações para
						garantir que a adoção seja uma experiência positiva tanto para o animal quanto para a
						família.
					</li>
					<li><strong>Conscientização e Educação:</strong> Acreditamos que a educação é fundamental para
						promover uma comunidade mais compassiva em relação
						aos animais. Oferecemos programas educacionais e recursos para incentivar a adoção
						responsável,
						a esterilização e a prevenção do abuso de animais.</li>
				</ol>
			</section>
			<section class="mission-and-values">
				<h3>Valores</h3>
				<ul>
					<li><strong>Amor e Respeito:</strong> Tratamos cada animal com amor, respeito e compaixão,
						independentemente de sua
						origem ou história.</li>
					<li><strong>Transparência:</strong> Valorizamos a transparência em todas as nossas ações e nos
						relacionamentos com
						nossos apoiadores, voluntários e adotantes.</li>
					<li><strong>Dedicação:</strong> Estamos comprometidos com a causa do resgate de animais e
						dedicamos
						nosso tempo e
						esforço para garantir o bem-estar dos animais sob nossa responsabilidade.</li>
					<li><strong>Comunidade:</strong> Acreditamos no poder da comunidade para criar mudanças
						positivas e
						trabalhamos em
						parceria com pessoas e organizações que compartilham nossa missão.</li>
				</ul>
			</section>
			<div id="about" class="container text-center">
				<h3>Quem Somos</h3>
				<div class="row">
					<div class="col description">
						<p> A 4Patas está comprometida em fazer a diferença na vida dos animais necessitados. Ajude-nos
							a
							construir um futuro mais brilhante para eles.<br><br>Se você estiver interessado em apoiar
							nossa
							missão,
							adotar um animal ou fazer parte de nossa equipe
							de voluntários, entre em contato conosco.<br><br>
							Juntos, podemos criar um mundo mais compassivo para todos
							os seres vivos.</p>
					</div>
					<div class="col address">
						<p>Informações de Contato:<br><br>
							Endereço da Sede:<br>
							Rua dos Animais Felizes<br>
							Bairro dos Amigos dos Animais<br>
							Cidade dos Peludos, PA<br>
							CEP: 12345-678<br>
							Telefone: (123) 456-7890<br>
							E-mail: contato@instituicaoresgateanimais.org
						</p>
					</div>
				</div>

				</section>

			</div>
		</div>
		<footer>
			2023 Instituição 4Patas. Todos os direitos reservados.
		</footer>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
			crossorigin="anonymous"></script>

</body>

</html>
