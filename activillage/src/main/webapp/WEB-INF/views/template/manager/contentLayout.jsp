<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title><tiles:getAsString name="title" /></title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
    	<tiles:insertAttribute name="header" />
    </nav>

    <div class="container-fluid">
			<tiles:insertAttribute name="main" />
    </div>
    
    <nav class="navbar navbar-inverse navbar-fixed-top">
    	<tiles:insertAttribute name="footer" />
    </nav>
</body>
</html>