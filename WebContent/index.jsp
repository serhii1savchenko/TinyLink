<%@include file="header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-10 col-sm-offset-1 col-xs-10 col-xs-offset-1">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="wrapper">

						<h2>Hello!</h2>
						<p>TinyLink is a fast and simple URL shortener</p>
						<p>It allows to turn awful large links into pretty short ones</p>
						<form action="short" method="post">
    						Enter your link (starting from http(s)://...) <br/>
    						<input type="text" class="form-control" name="link" placeholder="https://google.com/...">
    						<div style="padding-top: 5px;"><div class="checkbox"><label><input type="checkbox" value="" name="isPrivate" checked>Don't display my link in the list below</label></div></div>
    						<div style="padding-top: 5px;"><input type="submit" class="btn btn-default" value="Shorten!" onclick="loading();"/></div>
						</form>
						<center>
							<img src = "${pageContext.request.contextPath}/resources/images/loading.gif" id="img" style="display:none"/>
						</center>
						
					</div>
				</div>
			</div>
			
			<center>
			<p>Here are last generated short links</p>
				<c:forEach var="link" items="${lastLinks}">
					<a href="${link.shortLink}" class="ref"> <div class="area">${link.shortLink}</div></a>
				</c:forEach>
			</center>
		</div>
	</div>
</div>
	
    <script type="text/javascript">
    	function loading(){
    		document.getElementById("img").style.display = '';
    	}
    	
    	
    	var areas = document.getElementsByClassName("area");
    	for(var i=0; i<areas.length; i++) {
    		areas[i].innerHTML = domainURL + "at/" + areas[i].innerHTML;
    	}
    	
    	var refs = document.getElementsByClassName("ref");
    	for(var i=0; i<refs.length; i++) {
    		refs[i].href = areas[i].innerHTML;
    	}
    	
    </script>

<%@include file="footer.jsp" %>