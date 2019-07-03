<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{margin: 0px; background-color: #f4f5fd; padding: 20px 0;
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
    font-size: 1.3rem;
    font-weight: 400;
    line-height: 1.5;
    color: #212529;
    text-align: center;
    position: relative;
    z-index: 1;
}

.container{width: 60%; margin: 8% auto 0px; background-color: #ffffff; padding: 40px 0; border-bottom: 2px solid #0c489e; }

h1{
color: #0c489e;
text-align:center;
margin: 0 0 30px 0;
line-height: 30px;
}

input{border: 0px; padding: 7px 15px; cursor: pointer; background-color: #469809; color: #fff; width: 180px; border-radius: 30px;}
input:hover{background-color: #0c489e;}

button{border: 0px; padding: 10px 20px; cursor: pointer; background-color: #469809; color: #fff; margin-left: 20px; border-radius: 30px;}
button:hover{background-color: #0c489e;}

.msg{color: green;}
.sdnf{
margin-top: 30px;
}
.sdnm{
color: red;
fint-size:20px;
}
.sdnm span{color: green;}


.loader1{position: absolute;
top: 0px;
left: 0px;
width: 100%;
background:#5a5a5a;
    height: 100vh;
z-index: 999;
  /* IE 5-7 */
  filter: alpha(opacity=80);

  /* Netscape */
  -moz-opacity: 0.8;

  /* Safari 1.x */
  -khtml-opacity: 0.8;

  /* Good browsers */
  opacity: 0.8;
opacity: 0.8;}

.loaderImg{position: absolute;
top: 36%;
left: 41%;
text-align:center;
height: 1100px; display:inline-block;
z-index: 9999;}
.nocolumns {
    background: none !important;
}#container {
    background: none !important;
}

</style>
</head>
<body>

<div class="container">


<h1>Search Email</h1>


<c:if test = "${not empty message}">
<div class="sdnm">
	${message}
</div>
</c:if>


<c:if test = "${not empty downloadUrl}">
<div class="msg">
  <a href="<%=request.getContextPath()%>/${downloadUrl}" download>Download File</a>
  </div> 
</c:if>


<div class="sdnf">
<form name="searchDomain" action="uploadEmail" method="POST" enctype="multipart/form-data" onsubmit="loaderFunction()">
	Upload File : <input type="file" id="file" name="file">
	<button type="submit">Submit</button>
</form>

</div>

<div class="loaderImg" id="loading" style="display: none;"><img src="https://globalcompliancepanel.com/images/payment-process-loading-img.gif" alt="Loading..." />  <br /><br /> 
	<h3 style="color:#fff">Please Don't Refresh Page</h3>
</div>

<div class="loader1" id="loader2" style="display: none;"></div>

</div>
<script>
function loaderFunction(){
	
	var lax = document.getElementById("file").value;
	
	if(lax=="" || lax==null){
	}else{
		document.getElementById("loading").style.display="block";
		document.getElementById("loader2").style.display="block";
	}
}
</script>
</body>
</html>