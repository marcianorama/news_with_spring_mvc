<#include "header.jsp"/> <#include "sidebar.jsp" />
<div id="main-content">
	<!-- Main Content Section with everything -->
	<#if messageUpdateNewsSuccess??>
	<div class="notification success png_bg">
		<a href="#" class="close"><img
			src="<@spring.url '/assets/resource/images/icons/cross_grey_small.png'/>"
			title="Close this notification" alt="close" /></a>
		<div>
			${messageUpdateNewsSuccess!}
		</div>
	</div>
	</#if>
	<#if messageDeleteNews??>
	<div class="notification success png_bg">
		<a href="#" class="close"><img
			src="<@spring.url '/assets/resource/images/icons/cross_grey_small.png'/>"
			title="Close this notification" alt="close" /></a>
		<div>
			${messageDeleteNews!}
		</div>
	</div>
	</#if>
	<!-- Page Head -->
	<h2>Manage News</h2>
	<div class="content-box">
		<!-- Start Content Box -->



		<div class="content-box-content">

			<div class="tab-content default-tab" id="tab1">
				<!-- This is the target div. id must match the href of this div's tab -->
				<table>
					<thead>
						<tr>
							<th>Id</th>
							<th>News Title</th>
							<th>Edit</th>
						</tr>

					</thead>
					<tbody>
						<#list newsList.pageList as nl>
						<tr>
							<td>${nl.newsId!}</td>
							<td>${nl.title!}</td>
							<td>
								<!-- Icons --> 
								<a href="<@spring.url '/admin/addnews?newsId=${nl.newsId!}&editPage=t'/>" title="Edit">
									<img src="<@spring.url '/assets/resource/images/icons/pencil.png'/>" alt="Edit"/>
								</a> 
								<a href="<@spring.url '/admin/deletenews?newsId=${nl.newsId}'/>" 
								onclick="return confirm('Are You really want to Delete ?');"
								title="Delete">
								<img src="<@spring.url '/assets/resource/images/icons/cross.png' />" alt="Delete" />
								</a>
							</td>
						</tr>
						</#list>

					</tbody>

				</table>

				<!--here will be navigation-->
				<div id="pagination" style="float: right;">
					<ul class="tsc_pagination">
						<!-- Show pagination links -->


						<#if newsList.pageCount=1> Prev 1 Next <#else> <#if
						newsList.firstPage=true> Prev <#else>
						<a href="<@spring.url '/admin/managenews?type=prev'/>">Prev</a>
						</#if> <#list 0..newsList.pageCount-1 as pa> <#if
						pa=newsList.page> ${pa+1} <#else>
						<a href="<@spring.url '/admin/managenews?type=${pa}'/>">${pa+1}</a>
						</#if> </#list> <#if newsList.lastPage=true> Next <#else>
						<a href="<@spring.url '/admin/managenews?type=next'/>">Next</a>
						</#if> </#if>

					</ul>
				</div>
				<!-- End #tab1 -->
				<div class="clear"></div>
				<#include "footer.jsp"/>