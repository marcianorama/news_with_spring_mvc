<#include "header.jsp"/>
<div class="featured container">
	<div class="row">
		<div class="col-sm-8">
			<!-- Carousel -->
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<#assign i=0> <#list listNewsLimit as lnl> <#if i==0>
					<li data-target="#carousel-example-generic" data-slide-to="${i!}"
						class="active"></li> <#else>
					<li data-target="#carousel-example-generic" data-slide-to="${i!}"></li>
					</#if> <#assign i=i+1> </#list>
				</ol>
				<!-- Wrapper for slides -->
				<div class="carousel-inner">
					<#assign j=0> <#list listNewsLimit as lnl> <#if j==0>
					<div class="item active">
						<img src="assets/uploads/${lnl.image!}" alt="First slide">
						<!-- Static Header -->
						<div class="header-text hidden-xs">
							<div class="col-md-12 text-center">
								<h2>${lnl.title?substring(0,20)}</h2>
								<br>
								<h3>${lnl.content?substring(0,50)}</h3>
								<br>
							</div>
						</div>
						<!-- /header-text -->
					</div>
					<#else>
					<div class="item">
						<img src="assets/uploads/${lnl.image!}" alt="Second slide">
						<!-- Static Header -->
						<div class="header-text hidden-xs">
							<div class="col-md-12 text-center">
								<h2>${lnl.title?substring(0,20)}</h2>
								<br>
								<h3>${lnl.content?substring(0,85)}</h3>
								<br>
							</div>
						</div>
						<!-- /header-text -->
					</div>
					</#if> <#assign j=j+1> </#list>
				</div>
				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span>
				</a>
			</div>
			<!-- /carousel -->
		</div>
		<div class="col-sm-4">
			<div id="owl-demo-1" class="owl-carousel">
				<img src="assets/resource/images/slide-2.jpg" /> <img
					src="assets/resource/images/slide-1.jpg" /> <img
					src="assets/resource/images/slide-3.jpg" />
			</div>
			<img src="assets/resource/images/banner.jpg" />
		</div>
	</div>
</div>

<!-- /////////////////////////////////////////Content -->
<div id="page-content" class="index-page container">
	<div class="row" style="height: 20px;">
		<div id="main-content">
			<!-- background not working -->
			<div class="col-md-8">
				<div style="background-color: #007171;">
					<h3>Terkini</h3>
				</div>
			</div>
			<div class="col-md-4">
				<div style="background-color: #007171;">
					<h3>Sosial</h3>
				</div>
			</div>
			<div class="col-md-8">

				<div class="box wrap-vid">
					<#list newsList.pageList as nl>
					<div class="image_resize">
						<img class="zooming" src="assets/uploads/${nl.image!}">
						<h5 class="vid-name">
							<a href="#"> ${nl.title!} </a>
						</h5>
						<div class="info">
							<h6>
							By <#list listUsers as lu> 
							<#if nl.userId.id=lu.id>
								${lu.username!} 
							</#if> 
					</#list></h6>
							<span> <i class="fa fa-calendar">${nl.dateposted}</i>
							</span>

						</div>
						<p class="more">${nl.content?substring(0,180)}</p>

						<div style="margin-left: 300px;">
							<a href="<@spring.url '/news?newsId=${nl.newsId!}&title=${nl.title!}'/>">Read
								More </a>
							<ul class="share-buttons">
								<li><a
									href="http://www.facebook.com/sharer.php?u=<?php echo base_url(); ?>index.php/welcome/news/<?php echo $row->news_id;?>&t${nl.title!}"
									target="_blank" title="Publish on Facebook"><img
										alt="Publish on Facebook"
										src="assets/resource/share/Facebook.png"> </a></li>
								<li><a
									href="https://twitter.com/share?url=<?php echo base_url(); ?>index.php/welcome/news/<?php echo $row->news_id;?>&amp;text=<?php echo mb_substr(strip_tags($row->content), 0,185); ?>"
									target="_blank" title="Publish on Twitter"><img
										alt="Publish on Twitter"
										src="assets/resource/share/Twitter.png"> </a></li>
								<li><a
									href="mailto:?Subject=<?php echo $row->title;?>s&amp;Body=<?php echo mb_substr(strip_tags($row->content), 0,185); ?> <?php echo base_url(); ?>index.php/welcome/news/<?php echo $row->news_id;?>"
									title="Publish on Email" target="_blank"> <img
										src="assets/resource/share/Email.png" alt="Publish On EMail" />
								</a></li>
							</ul>

						</div>

					</div>
					<div class="clear"></div>
					</#list>
					<div class="clear"></div>


					<div id="pagination" style="float: right;">
						<ul class="tsc_pagination">
							<!-- Show pagination links -->


							<#if newsList.pageCount=1> Prev 1 Next <#else> <#if
							newsList.firstPage=true> Prev <#else>
							<a
								href="<@spring.url '?type=prev&catId=${categoryId!}'/>">Prev</a>
							</#if> <#list 0..newsList.pageCount-1 as pa> <#if
							pa=newsList.page> ${pa+1} <#else>
							<a
								href="<@spring.url '?type=${pa}&catId=${categoryId!}'/>">${pa+1}</a>
							</#if> </#list> <#if newsList.lastPage=true> Next <#else>
							<a
								href="<@spring.url '?type=next&catId=${categoryId!}'/>">Next</a>
							</#if> </#if>

						</ul>
					</div>
				</div>
			</div>

			<div class="col-md-4">

				<div class="box wrap-vid">
					<div class="col-md-4 col-footer footer-1">
						<div class="content">
							<div class="tweets">
								<!--here tweets -->
								<#list listDetails as ld> ${ld.twitterbox!} </#list>
								<!--here tweets -->
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>
<#include "footer.jsp"/>
