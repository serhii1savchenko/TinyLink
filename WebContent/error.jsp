<%@include file="header.jsp" %>
	
<div class="container-fluid">
	<div class="row">
		<div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-10 col-sm-offset-1 col-xs-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="wrapper">
					
						<p>Ooops! Something went wrong... Try one more time.</p>
						<a href="" id="ref">Return to Home Page</a>
						<br/><br/><br/>
						${message}

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

	<script type="text/javascript">
		document.getElementById("ref").href = domainURL;
	</script>

<%@include file="footer.jsp" %>
