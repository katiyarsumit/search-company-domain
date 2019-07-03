<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.title{
padding:30px;
color:green;
text-align:center;
font-size:30px;
font-style:italic;
font-weight: bold;
text-decoration: underline;
}
.middle{
padding:80px;
    text-align: center;
}
.middle a{
font-size:20px;
padding:30px;
}
a{
text-decoration: none;
}
body{
background-color:#e1e7f0;
}
</style>
</head>
<body>
<div class="title">Search Domain Name From Company Name</div>
<div class="middle">
<a href="<%=request.getContextPath()%>/searchEngine" ><button>Search Domain</button></a>
<a href="<%=request.getContextPath()%>/searchEmail" ><button>Search Email</button></a>

</div>
</body>
</html>