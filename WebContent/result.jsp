<%@include file="header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="wrapper">
						
						<h3>Here is your link: </h3>
						<a href="${pageContext.request.contextPath}/at/${shortedLink}"> <textarea class="js-copytextarea form-control" rows="1" readonly>https://morning-peak-22507.herokuapp.com/${shortedLink}</textarea></a>
						<div style="padding-top: 5px; padding-down: 5px;"><button class="js-textareacopybtn btn btn-default">Copy</button></div>
						<br/>
						<p>Click the button to copy it to clipboard.</p>
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
	</script>
	
<%@include file="footer.jsp" %>