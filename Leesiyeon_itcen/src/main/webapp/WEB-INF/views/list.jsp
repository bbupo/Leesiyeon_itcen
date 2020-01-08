<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- c로시작하는 태그 것들은 태그라이브러리에서 실행 -->
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 모바일 화면 -->

<title>Insert title here</title>
</head>
<body class="container">
<jsp:include page="header.jsp"></jsp:include>
<div>
	<h1>도서목록</h1>

	<table class="table table-hover table-sm">
	<thead class="table-dark">
	<tr> 
	 <th> 도서번호 </th>
	 <th> 도서명 </th>
	 <th> 출판사 </th>
	 <th> 가격 </th> 
	 <th> 관리 </th>
	</tr>
	</thead>
	<tbody>
	
		<c:choose>
			<c:when test="${list.size()>0 }">
				<!-- switch 문  case, default-->
				<c:forEach var="item" items="${list}">
					<!-- for문 -->
					<tr>
					   <td> ${item.bookid}</td> 
					   <td> ${item.bookname}</td>
					   <td> ${item.publisher}</td> 
					   <td> ${item.price}</td>
					   <td> 
					        <a href="update?bookid=${item.bookid}" class="btn btn-sm btn-outline-primary">변경 </a>
					        <a href="delete?bookid=${item.bookid}" class="btn btn-sm btn-outline-danger">삭제 </a>
					   </td>
					   
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr><td colspan="6">등록 된 도서가 없습니다</td></tr>
			</c:otherwise>
		</c:choose>
</tbody>
	</table>
	
	<div>
	${pager.pagination}
	</div>
	
	<div style="text-align:right">
	<a href="insert" class="btn btn-sm btn-outline-primary">등록</a>
	
	<a href="dummy" class="btn btn-sm btn-outline-warning">대량등록</a>

	<a href="init" class="btn btn-sm btn-outline-danger">초기화</a>
	
	</div>
	
  </div>
</body>
</html>


