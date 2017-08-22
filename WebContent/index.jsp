<%@include file="header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2">
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
