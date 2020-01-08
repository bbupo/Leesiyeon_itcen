<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 모바일 화면 -->
<title>Insert title here</title>
</head>
<body>
	
	<div class="container">
	<jsp:include page="header.jsp"></jsp:include>
		<h1>도서등록</h1>
		<div>
		<form action="update" method="post">
		
		<div class="form-group">
		<label>도서 번호:</label>
		<input type="number" name="bookid" value="${item.bookid }" readonly  class="form-control form-control-sm">
		</div>
		
		<div class="form-group">
		<label>도서명:</label>
		<input type="text" name="bookname" value="${item.bookname }"  class="form-control form-control-sm">
		</div>
		
		<div class="form-group">
		<label>출판사:</label>
		<input type="text" name="publisher" value="${item.publisher }"  class="form-control form-control-sm">
		</div>
		
		<div class="form-group">
		<label>가격:</label>
		<input type="number" name="price" value="${item.price }"  class="form-control form-control-sm">
		</div>
		
		<input type="submit" value="변경" class="btn btn-sm btn-outline-primary">
		</form>
		</div>
	</div>

</body>
</html>