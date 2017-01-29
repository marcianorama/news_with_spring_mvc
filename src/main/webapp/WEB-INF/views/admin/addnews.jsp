<#include "header.jsp"/> 
<#include "sidebar.jsp" />
<div id="main-content">
	<!-- Main Content Section with everything -->
	<#if messageAddNewsSuccess??>
	<div class="notification success png_bg">
		<a href="#" class="close"><img
			src="<@spring.url '/assets/resource/images/icons/cross_grey_small.png'/>"
			title="Close this notification" alt="close" /></a>
		<div>
			${messageAddNewsSuccess!}
		</div>
	</div>
	</#if>

	<#if messageAddNewsFailed??>
	<div class="notification error png_bg">
		<a href="#" class="close"><img
			src="<@spring.url '/assets/resource/images/icons/cross_grey_small.png'/>"
			title="Close this notification" alt="close" /></a>
		<div>${messageAddNewsFailed!}</div>
	</div>
	</#if>
	<h2>Add News</h2>
	<form method="post" enctype="multipart/form-data"
		action="<@spring.url '/admin/addnews'/>">
		<table>
			<tr>
				<td>News Title :</td>
				<td>
					<#if title??>
							<label style="color: red;">${title!}</label>
					</#if>
					<@spring.formInput 'news.title' , 'size="40"'/> *
				</td>
			</tr>
			<tr>
				<td>Category :</td>
				<td>
					<select name="cat_id">
						<#list listCategory as lc>
							<option value="${lc.catId!}">${lc.title!}</option>
						</#list>
					</select>
				</td>
			</tr>
			<#if editNews??>
			
			<#else>
			<tr>
				<td>News Image :</td>
				<td>
				<input type="file" name="file" /> *</td>
			</tr>
			</#if>
			<tr>
				<td>News Youtube video :</td>
				<td><@spring.formInput 'news.youtubeVideo', 'size="40"'/>
			</tr>
			<tr>
				<td>News Details</td>
				<td>
						<#if content??>
							<label style="color: red;">${content!}</label>
						</#if>
					<@spring.formTextarea 'news.content', 'size="622" cols="100%"
						rows="40"'/>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="add"
					value="Add News"></td>
			</tr>
		</table>
	</form>




	<div class="clear"></div>
	<!-- End .clear -->
	<#include "header.jsp"/>