<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>	
	<head>
		<meta charset="UTF-8">
		<title>Inscription</title>
		<link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<style>
			select.form-control, select.form-control:required:invalid {
				padding-left: 8px;
				color: #999;
			}
			
			option[value=""][disabled] {
			  display: none;
			}
			
			option {
			  color: #999;
			}
			
			.form-horizontal .control-label{text-align: left;}
		</style>			
	</head>
	<body>