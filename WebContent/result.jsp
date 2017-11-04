<%@include file="header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="wrapper">
						
						<h3>Here is your link: </h3>
						<a href="" id="ref"> <textarea id="area" class="js-copytextarea form-control" rows="1" readonly></textarea></a>
						<div style="padding-top: 5px; padding-down: 5px;"><button class="js-textareacopybtn btn btn-default">Copy</button></div>
						<br/>
						<p>Click the button to copy it to clipboard.</p>
						---------------------------------
						
						<!-- <script type="text/javascript">document.write(domainURL)</script>  -->
						
						<br/>
						${info}
						
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	
	<script type="text/javascript">
	var copyTextareaBtn = document.querySelector('.js-textareacopybtn');
	copyTextareaBtn.addEventListener('click', function(event) {
	  var copyTextarea = document.querySelector('.js-copytextarea');
	  copyTextarea.select();
	  try {
	    var successful = document.execCommand('copy');
	    var msg = successful ? 'successful' : 'unsuccessful';
	    console.log('Copying text command was ' + msg);
	  } catch (err) {
	    console.log('Oops, unable to copy');
	  }
	});
	
	document.getElementById("ref").href = domainURL + "at/" + '${shortedLink}';
	
	document.getElementById('area').innerHTML = domainURL + "at/" + '${shortedLink}';
	</script>
	
<%@include file="footer.jsp" %>
