<!-- ####################################################################################################### -->
<!-- <div class="wrapper">
  <div id="breadcrumb">
    <ul>
      <li class="first">You Are Here</li>
      <li>&#187;</li>
      <li><a href="<?php echo base_url(); ?>">Home</a></li>
      <li>&#187;</li>
      <li><a href="<?php echo base_url(); ?>index.php/welcome/page/<?php echo $pagecontent->id; ?>"><?php echo $pagecontent->pagetitle; ?></a></li>
      
    </ul>
  </div>
</div> -->
<!-- ####################################################################################################### -->
<#include "header.jsp"/>
<div class="wrapper">
	<div class="featured container">
		<div class="content">
			<h1>${pageContent.pagetitle!}</h1>


			<div class="content">${pageContent.pagecontent!}</div>


		</div>
		<div class="column">
			<div class="tweets">
				<!--here tweets -->
				<#list listDetails as ld> ${ld.twitterbox!} </#list>
				<!--here tweets -->
			</div>

			<br class="clear" />
		</div>
	</div>
	<br class="clear" /> <#include "footer.jsp"/>
	<!-- ####################################################################################################### -->