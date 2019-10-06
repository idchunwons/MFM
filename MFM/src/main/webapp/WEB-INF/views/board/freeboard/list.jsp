<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>

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
        <small>총 게시물수 : ${total}</small>
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
                    <td><a href="${contextPath}/board/freeboard/get?bno=${freeboard.bno}">${freeboard.title}</a></td>
                    <td>${freeboard.writer}</td>
                    <td><fmt:formatDate value="${freeboard.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><span class="badge bg-red">${freeboard.viewCnt}</span></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="box-footer">
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
</html>