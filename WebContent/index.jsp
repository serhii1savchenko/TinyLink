<%@include file="header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="wrapper">

						<h2>Hello!</h2>
						<form action="short" method="post">
    						Enter your link (starting from http(s)://...) <br/>
    						<input type="text" class="form-control" name="link" placeholder="https://google.com/...">
    						<div style="padding-top: 5px;"><input type="submit" class="btn btn-default" value="Shorten!" onclick="loading();"/></div>
						</form>
						<center>
							<img src = "${pageContext.request.contextPath}/resources/images/loading.gif" id="img" style="display:none"/>
						</center>
	
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	
    <script type="text/javascript">
    	function loading(){
    		document.getElementById("img").style.display = '';
    	}
    </script>

<%@include file="footer.jsp" %>