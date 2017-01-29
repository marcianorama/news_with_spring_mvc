<#include "header.jsp"/>
<div class="wrapper">
	<div class="featured container">
		<div class="content">
			<h1>${category.title!}</h1>
			<p>${category.description!}</p>

			<div class="content">
				<?php if($total_rows == 0): ?>
				<#if newsList.pageList?size=0> There is no news in this category
				<#else>
				<ul style="list-style-type: none;">

					<#list newsList.pageList as lnbc>
					<li>
						<div class="item">
							<img width="600px" height="200px"
								src="assets/uploads/${lnbc.image!}">
							<p>
								<h1><strong>${lnbc.title} </strong></h1>
							<p>${lnbc.content?substring(0,300)}</p>

							</p>
							<p class="readmore">
								<a href="<@spring.url '/news?title=${lnbc.title!}&newsId=${lnbc.newsId!}'/>">Continue
									Reading » </a>
							</p>
						</div>
					</li>
					<hr />
					</#list>

				</ul>
				<div id="pagination" style="float: right;">
					<ul class="tsc_pagination">
						<!-- Show pagination links -->


						<#if newsList.pageCount=1> Prev 1 Next <#else> <#if
						newsList.firstPage=true> Prev <#else>
						<a
							href="<@spring.url '/category?type=prev&catId=${categoryId!}'/>">Prev</a>
						</#if> <#list 0..newsList.pageCount-1 as pa> <#if
						pa=newsList.page> ${pa+1} <#else>
						<a
							href="<@spring.url '/category?type=${pa}&catId=${categoryId!}'/>">${pa+1}</a>
						</#if> </#list> <#if newsList.lastPage=true> Next <#else>
						<a
							href="<@spring.url '/category?type=next&catId=${categoryId!}'/>">Next</a>
						</#if> </#if>

					</ul>
				</div>
				</#if>
				<hr />
				<style type="text/css">
				.navigation  a {
					padding: 10px;
				}
				</style>
				
			</div>


		</div>
	</div>




	<br class="clear" /> <#include "footer.jsp"/>
	<!-- ####################################################################################################### -->