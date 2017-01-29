<!-- ####################################################################################################### -->

<!-- ####################################################################################################### -->

<#include "header.jsp"/>
<style type="text/css">
.content img {
	max-width: 630px;
}
</style>
<div class="wrapper">
	<div class="container">
		<div class="featured content">
			<h1>${news.title!}</h1>
			<div class="content">
				<img width="600px" height="200px"
					src="assets/uploads/${news.image!}" /> ${news.content!} <br />

				<#if news.youtubeVideo??> Watch this news video
				${news.youtubeVideo!} </#if> <br /> <br /> By
				:${news.userId.username!}-${news.dateposted!} <br /> <br />
			</div>

			<div class="sharebox">
				<hr />
				<span class='st_sharethis' displayText='ShareThis'></span> <span
					class='st_facebook' displayText='Facebook'></span> <span
					class='st_twitter' displayText='Tweet'></span> <span
					class='st_linkedin' displayText='LinkedIn'></span> <span
					class='st_pinterest' displayText='Pinterest'></span> <span
					class='st_blogger' displayText='Blogger'></span> <span
					class='st_flipboard' displayText='Flipboard'></span> <span
					class='st_email' displayText='Email'></span>
				<hr />
			</div>
			<br />

			<div id="comments">
				<h2>Comments</h2>

				<#if listCommentByNewsId?size!=0>
				<ul class="commentlist">
					<#list listCommentByNewsId as lcbn>
					<li class="comment_odd">
						<div class="author">
							<img class="avatar" src="assets/images/demo/avatar.gif"
								width="32" height="32" alt="" /><span class="name"><a
								href="#"> ${lcbn.posterName!} </a></span> <span class="wrote">wrote:</span>
						</div>
						<div class="submitdate">
							<a href="#"> ${lcbn.date!} </a>
						</div>
						<p>${lcbn.comment!}</p>
					</li> </#list>

				</ul>
				<#else>

				<p>There is no comments .</p>

				</#if>

			</div>



			<h2>Write A Comment</h2>
			<#if messAddComment??>
				${messAddComment!}
			</#if>
			<div id="respond">
				<form method="post" action="<@spring.url '/addcomments'/>"
					commandName="comments">
					<p>
						<label> <small>Name (required)</small>
						</label><br> <@spring.formInput 'comments.posterName', 'size="22"'/>
						<#if posterName??>
							<label class="error" style="color: red;">${posterName!}</label>
						</#if>
					</p>
					<p>
						<label> <small>Comment (required)</small>
						<#if comment??>
							<#if posterName??>
								<label class="error" style="color: red;">${comment!}</label>
							</#if>
						</#if>
						</label><br> 
						<@spring.formTextarea 'comments.comment', 'size="22" cols="100%"
						rows="10"'/>
						
					</p>
					<p>
						<input name="submit" type="submit" id="submit"
							value="Add a comment" /> &nbsp; <input name="reset" type="reset"
							id="reset" tabindex="5" value="Reset Form" />
					</p>
				</form>
			</div>
		</div>

	</div>
	<br class="clear" /> <#include "footer.jsp"/>
	<!-- ####################################################################################################### -->