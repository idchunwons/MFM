<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<style>
	#qwerty{padding-right:0px;}
	#searchBtn{width:82px;}
</style>
<!-- head -->
<%@include file="../../include/head.jsp"%>


<body class="hold-transition skin-blue sidebar-mini layout-boxed">
<div class="wrapper">

  <!-- Main Header -->
  <%@include file="../../include/main_header.jsp"%>
  <!-- Left side column. contains the logo and sidebar -->
  <%@include file="../../include/left_column.jsp"%>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       	 자유게시판
        <small>총 게시물수 : ${total}개</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

    <div class="col-lg-12">
    <div class="box box-primary">
        <div class="box-header with-border">
            <h3 class="box-title">게시글 목록</h3>
        </div>
        <div class="box-body">
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <th style="width: 115px">게시글 번호</th>
                    <th>제목</th>
                    <th style="width: 100px">작성자</th>
                    <th style="width: 150px">작성시간</th>
                    <th style="width: 60px">조회</th>
                </tr>
                <c:forEach items="${list}" var="freeboard">
                <tr>
                    <td>${freeboard.bno}</td>
                    <td><a href="${contextPath}/board/freeboard/get?bno=${freeboard.bno}">${freeboard.title}</a>
                     <span class="badge bg-teal"><i class="fa fa-comment-o"></i>${freeboard.replyCnt}"</span>
                    </td>
                    <td>${freeboard.writer}</td>
                    <td><fmt:formatDate value="${freeboard.regDate}" pattern="yyyy-MM-dd a HH:mm:ss"/></td>
                    <td><span class="badge bg-red">${freeboard.viewCnt}</span></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="box-footer">
        <!-- Start Pagination -->
				<div class="text-center">
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="paginate_button previous"><a
								href="${pageMaker.startPage-1}">Previous</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}">
							<li class="paginate_button"><a href="${num}">${num}</a></li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li class="paginate_button next"><a
								href="${pageMaker.endPage+1}">Next</a></li>
						</c:if>
					</ul>
				</div>
				<!-- End Pagination -->
				</div>
 <div class="box-footer">
				<form id="actionForm" action="${contextPath}/board/freeboard/listCriteria"
					method="get">
					<input type="hidden" name="pageNum" value="${pageMaker.pa.pageNum}">
					<input type="hidden" name="amount" value="${pageMaker.pa.amount}">
					<input type='hidden' name='type'
						value='<c:out value="${pageMaker.pa.type}"/>'> <input
						type='hidden' name='keyword'
						value='<c:out value="${pageMaker.pa.keyword}"/>'>
				</form>

				
				<!-- 페이지 번호 출력 -->
				
			<form id='searchForm' action="${contextPath}/board/freeboard/listCriteria" method='get'>
							<div class="form-group col-sm-2">
								<select class="form-control" name='type' id="searchType">
									<option value=""
										<c:out value = "${pageMaker.pa.type == null?'selected':''}"/>>--</option>
									<option value="T"
										<c:out value = "${pageMaker.pa.type eq 'T'?'selected':''}"/>>제목</option>
									<option value="C"
										<c:out value = "${pageMaker.pa.type eq 'C'?'selected':''}"/>>내용</option>
									<option value="W"
										<c:out value = "${pageMaker.pa.type eq 'W'?'selected':''}"/>>작성자</option>
									<option value="TC"
										<c:out value = "${pageMaker.pa.type eq 'TC'?'selected':''}"/>>제목
										or 내용</option>
									<option value="TW"
										<c:out value = "${pageMaker.pa.type eq 'TW'?'selected':''}"/>>제목
										or 작성자</option>
									<option value="TWC"
										<c:out value = "${pageMaker.pa.type eq 'TWC'?'selected':''}"/>>제목
										or 내용 or 작성자</option>
								</select>
							</div>	
							 <div class="form-group col-sm-10" id="qwerty">
								 <div class="input-group">
								 	<input type='text' class="form-control" name='keyword' />
								 	<input type='hidden' name='pageNum' value='${pageMaker.pa.pageNum}' />
								 	<input type='hidden' name='amount' value='${pageMaker.pa.amount}' />
									<span class="input-group-btn">
                						<button type="button" class="btn btn-primary" id="searchBtn">
                    						<i class="fa fa-search"></i> 검색
                						</button>
            						</span>
								</div>
							</div>
			</form>
					
			
            <div class="pull-right">
                <button type="button" class="btn btn-success btn-flat" id="writeBtn">
                    <i class="fa fa-pencil"></i> 글쓰기
                </button>
            </div>
		</div>
		
		
        </div>
    </div>

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <%@include file="../../include/main_footer.jsp"%>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->
<%@include file="../../include/plugin_js.jsp"%>

</body>
<script type="text/javascript">
$(document).ready(function () {

	var formObj = $("form[role='form']");
    console.log(formObj);
	
    $(".btn-flat").on("click", function () {
        self.location = "${contextPath}/board/freeboard/register"
    
});
});
	var result = "${msg}";
	if (result == "regSuccess") {
		alert("게시글 등록이 완료되었습니다.");
	} else if (result == "modSuccess") {
		alert("게시글 수정이 완료되었습니다.");
	} else if (result == "delSuccess") {
		alert("게시글 삭제가 완료되었습니다.");
	}
</script>
<script type="text/javascript">
$(document).ready(
		function() {			
			var actionForm = $("#actionForm");
			$(".paginate_button a").on(
					"click",
					function(e) {
						e.preventDefault();
						console.log('click');
						actionForm.find("input[name='pageNum']")
								.val($(this).attr("href"));
						actionForm.submit();
					});

			var searchForm = $("#searchForm");

			$("#searchForm button").on("click",function(e) {
						if (!searchForm.find("option:selected")
								.val()) {
							alert("검색종류를 선택하세요");
							return false;
						}
						if (!searchForm.find(
								"input[name='keyword']").val()) {
							alert("키워드를 입력하세요");
							return false;
						}
						searchForm.find("input[name='pageNum']")
								.val("1");
						e.preventDefault();
						searchForm.submit();
					});
		});

</script>





</html>