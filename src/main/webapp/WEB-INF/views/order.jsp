<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<!-- CDN -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<!-- 외부 JS -->
<script type="text/javascript" src="/resources/js/order.js"></script>

<meta charset="UTF-8">
<title>수주</title>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="include/header.jsp"></jsp:include>

	<div class="row mb-3 text-center">

		<div class="col-md-8 themed-grid-col">

			<div class="row">
				<div class="col-md-6 themed-grid-col" id="div1_box">
					<table class="table table-striped table-hover table-bordered">
						<thead>
							<tr>
								<th scope="col" colspan="2" class="table-dark">입고기간</th>
								<th scope="col" class="table-dark">거래처명</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>시작날짜</td>
								<td>종료날짜</td>
								<td>거래처명</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-md-6 themed-grid-col"></div>

				<div class="col-md-6 themed-grid-col" id="div2_box">
					<button type="button" class="btn btn-outline-secondary btn-sm">검색</button>
				</div>
				<div class="col-md-6 themed-grid-col" id="div3_box"></div>


				<div class="col-md-6 themed-grid-col"></div>

				<div class="col-md-6 themed-grid-col">
					<button type="button" class="btn btn-outline-secondary btn-sm">오름차순 정렬</button>
					<button type="button" class="btn btn-outline-secondary btn-sm">내림차순 정렬</button>
					<button type="button" class="btn btn-outline-secondary btn-sm">모두보기</button>
					<button type="button" id="check_button" class="btn btn-outline-secondary btn-sm">일괄체크</button>
					<button type="button" class="btn btn-outline-secondary btn-sm">일괄수주</button>
				</div>



				<div class="pb-3">
					<table class="table table-striped table-hover table-bordered">
						<thead>
							<tr>
								<td><input type="checkbox" id="check_all" ></td>
								<th scope="col" class="table-dark">주문번호</th>
								<!-- 발주 데이터 -->
								<th scope="col" class="table-dark">발주 일자</th>								
								<th scope="col" class="table-dark">수주 일자</th>								
								<th scope="col" class="table-dark">사업자번호</th>
								<th scope="col" class="table-dark">거래처</th>
								<th scope="col" class="table-dark">제품명</th>
								<th scope="col" class="table-dark">단가</th>
								<th scope="col" class="table-dark">수량</th>
								<!-- 수주 데이터 -->
								<th scope="col" class="table-dark">합계액</th>
								<th scope="col" class="table-dark">결제상태</th>
								<th scope="col" class="table-dark">배송상태</th>
								<th scope="col" class="table-dark">수주서 발행</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${baljulist}" var="balju" varStatus="a"> 
							<tr>
								<td><input type="checkbox" id="check_all" id="check_box${a.index}"></td>
								<td scope="row">${balju.bno}</td>
								<td>${balju.baljuday}</td>
								<td></td>
								<td>${balju.bnumber}</td>
								<td>${balju.bname}</td>
								<td>${balju.bproduct}</td>
								<td><fmt:formatNumber value="${balju.pprice}" pattern="#,###" ></fmt:formatNumber></td>
								<td><fmt:formatNumber value="${balju.bcount}" pattern="#,###" ></fmt:formatNumber></td>
								<td><fmt:formatNumber value="${balju.bsum}" pattern="#,###" ></fmt:formatNumber></td>
								<td>결제 완료</td>
								<td>주문 접수</td>
								<td id="sujuletter" onclick="sujuletter('${balju.baljuday}', '${balju.bno}', '${balju.bname}', '${balju.bcount}','${balju.bsum}','${balju.bproduct}', '${balju.pprice}','${balju.bnumber}')">미발행</td>
							</tr>
							</c:forEach>
							<!-- 반복문으로 데이터 가져오기 -->
						</tbody>
					</table>
				</div>
			</div>

		</div>
		<div class="col-md-4 themed-grid-col">.col-md-4</div>



	</div>


</body>
</html>