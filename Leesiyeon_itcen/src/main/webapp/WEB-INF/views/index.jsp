<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<!-- 모바일 화면 -->
<title>Insert title here</title>
</head>
<body class="container">
	<jsp:include page="header.jsp"></jsp:include>
	<table class="table">
		<thead class="table-dark">
			<tr>
				<th><a href="book/list" class="btn btn-outline-light">도서 등록 정보</a></th>
			</tr>
		</thead>
	</table>
</body>
</html>