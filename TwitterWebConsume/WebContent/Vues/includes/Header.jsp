<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${param.title}</title>

<!-- Font Awesome Icons -->
<link href="assets/css/font-awesome.min.css" rel="stylesheet">
<!-- Main Styling -->
<link href="assets/css/main.css" rel="stylesheet">
<!-- Bootstrap -->

<link href="assets/css/bootstrap-combined.min.css" rel="stylesheet">
<link href="assets/css/bootstrap-reboot.min.css" rel="stylesheet">
<link href="assets/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="assets/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<nav id="sidebar-wrapper">
		<ul class="sidebar">
			<form id="form-1" action="users.php" method="post">
				<div class="form-group">
					<label for="inputdefault">ID utilisateur</label> <input
						id="id-user-input" placeholder="id twitter" class="form-control" name="id">
				</div>
				<input type="checkbox" id="add-follow"> Enregister quelques
				followers avec<br>
				<div class="form-group">
					<button class="btn btn-primary" id="add-user" name="action">Enregistrer</button>
				</div>
			</form>
		</ul>
		<!-- End Sidebar -->
	</nav>
	<!-- End Sidebar-wrapper -->

	<header>
		<div class="container-fluid">
			<div class="row">

				<!--         <div class="col-md-1"> -->
				<!--           <a href="#" id="menu-toggle"> -->
				<!--             <img src="assets/img/menu.png"> -->
				<!--           </a> -->
				<!--         </div> End Logo & Menu-Toggle -->

				<!--         <div class="col-md-5"> -->
				<!--           <form><input placeholder="chercher utilisateur ..." type="text"></form> -->
				<!--         </div>End Search-Bar -->


			</div>
			<!-- End Row -->
		</div>
		<!-- End Container-Fluid -->
	</header>
	<!-- End Header -->