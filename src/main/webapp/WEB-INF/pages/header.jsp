<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="Free Bootstrap Themes by 365Bootstrap dot com - Free Responsive Html5 Templates">
    <meta name="author" content="http://www.365bootstrap.com">
	
    <title>Newspaper | Free Bootstrap Themes by 365Bootstrap.com</title>
	
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="assets/resource/css/bootstrap.min.css"  type="text/css">
	
	<!-- Owl Carousel Assets -->
    <link href="assets/resource/owl-carousel/owl.carousel.css" rel="stylesheet">
    <link href="assets/resource/owl-carousel/owl.theme.css" rel="stylesheet">
	
	<!-- Custom CSS -->
    <link rel="stylesheet" href="assets/resource/css/style.css">
    <link rel="stylesheet" href="assets/resource/css/custom.css">
	 <link href="assets/resource/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
	
	<!-- Custom Fonts -->
    <link rel="stylesheet" href="assets/resource/font-awesome-4.4.0/css/font-awesome.min.css"  type="text/css">
	
	<!-- jQuery and Modernizr-->
	<script src="assets/resource/js/jquery-2.1.1.js"></script>
	
	<!-- Core JavaScript Files -->  	 
    <script src="assets/resource/js/bootstrap.min.js"></script>
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<header>
	<!--Top-->
	<nav id="top">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<strong>Welcome to Us!</strong>
				</div>
				<div class="col-md-6">
					<ul class="list-inline top-link link">
						<li><a href="<?php echo base_url(); ?>index.php/welcome"><i class="fa fa-home"></i> Home</a></li>
						<li><a href="<?php echo base_url(); ?>index.php/welcome"><i class="fa fa-comments"></i> Contact</a></li>
						<li><a href="<?php echo base_url(); ?>index.php/welcome"><i class="fa fa-question-circle"></i> FAQ</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	
	<!--Navigation-->
    <nav id="menu" class="navbar container">
		<div class="navbar-header">
			<button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>
			<a class="navbar-brand" href="#">
				<div class="logo"><span>Newspaper</span></div>
			</a>
		</div>
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li><a href="<?php echo base_url(); ?>index.php/welcome">Home</a></li>
				<!-- <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Account <i class="fa fa-arrow-circle-o-down"></i></a>
					<div class="dropdown-menu">
						<div class="dropdown-inner">
							<ul class="list-unstyled">
								<li><a href="archive.html">Login</a></li>
								<li><a href="archive.html">Register</a></li>
							</ul>
						</div>
					</div>
				</li> -->
				<!-- <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Video <i class="fa fa-arrow-circle-o-down"></i></a>
					<div class="dropdown-menu">
						<div class="dropdown-inner">
							<ul class="list-unstyled">
								<li><a href="archive.html">Text 201</a></li>
								<li><a href="archive.html">Text 202</a></li>
								<li><a href="archive.html">Text 203</a></li>
								<li><a href="archive.html">Text 204</a></li>
								<li><a href="archive.html">Text 205</a></li>
							</ul>
						</div> 
					</div>
				</li> -->
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Category <i class="fa fa-arrow-circle-o-down"></i></a>
					<div class="dropdown-menu">
						<div class="dropdown-inner">
							<ul class="list-unstyled">
								<?php $cats = $this->adminModel->getcat(); ?>
					            <?php foreach($cats as $cat): ?>
					            <li><a href="<?php echo base_url().'index.php/welcome/category/'.$cat->cat_id; ?>"><?php echo $cat->title; ?></a></li>
					            <?php endforeach; ?>
					            <?php $pages = $this->adminModel->getpages(); ?>
							</ul>
						</div> 
					</div>
				</li>
				<?php $pages = $this->adminModel->getpages(); ?>
		        <?php foreach($pages as $page): ?>
		        <?php if($page->id==3){ ?>
		        <li><a href="<?php echo base_url().'index.php/welcome/page/'.$page->id; ?>"><?php echo $page->pagetitle; ?></a></li>
		        <?php } ?>
		      <?php endforeach; ?>
				<!-- <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Category <i class="fa fa-arrow-circle-o-down"></i></a>
					<div class="dropdown-menu" style="margin-left: -203.625px;">
						<div class="dropdown-inner">
							<ul class="list-unstyled">
								<li><a href="archive.html">Text 301</a></li>
								<li><a href="archive.html">Text 302</a></li>
								<li><a href="archive.html">Text 303</a></li>
								<li><a href="archive.html">Text 304</a></li>
								<li><a href="archive.html">Text 305</a></li>
							</ul>
							<ul class="list-unstyled">
								<li><a href="archive.html">Text 306</a></li>
								<li><a href="archive.html">Text 307</a></li>
								<li><a href="archive.html">Text 308</a></li>
								<li><a href="archive.html">Text 309</a></li>
								<li><a href="archive.html">Text 310</a></li>
							</ul>
							<ul class="list-unstyled">
								<li><a href="archive.html">Text 311</a></li>
								<li><a href="archive.html">Text 312</a></li>
								<li><a href="archive.html#">Text 313</a></li>
								<li><a href="archive.html#">Text 314</a></li>
								<li><a href="archive.html">Text 315</a></li>
							</ul>
						</div>
					</div>
				</li> -->
				<!-- <li><a href="archive.html"><i class="fa fa-cubes"></i> Blocks</a></li>
				<li><a href="contact.html"><i class="fa fa-envelope"></i> Contact</a></li> -->
			</ul>
			<ul class="list-inline navbar-right top-social">
				<li><a href="#"><i class="fa fa-facebook"></i></a></li>
				<li><a href="#"><i class="fa fa-twitter"></i></a></li>
				<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
				<li><a href="#"><i class="fa fa-google-plus-square"></i></a></li>
				<li><a href="#"><i class="fa fa-youtube"></i></a></li>
			</ul>
		</div>
	</nav>
</header>