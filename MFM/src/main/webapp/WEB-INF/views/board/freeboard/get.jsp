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
        상세보기
        <small>상세보기작기</small>
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
            <h3 class="box-title">글제목 : ${get.title}</h3>
        </div>
        <div class="box-body" style="height: 700px">
            ${get.content}
        </div>
        <div class="box-footer">
            <div class="user-block">
                <img class="img-circle img-bordered-sm" src="/dist/img/user1-128x128.jpg" alt="user image">
                <span class="username">
                    <a href="#">${get.writer}</a>
                </span>
                <span class="description"><fmt:formatDate pattern="yyyy-MM-dd a HH:mm" value="${get.regDate}"/></span>
            </div>
        </div>
        <div class="box-footer">
            <form role="form" method="post">
                <input type="hidden" name="bno" value="${get.bno}">
            </form>
            <button type="submit" class="btn btn-primary listBtn"><i class="fa fa-list"></i> 목록</button>
            <div class="pull-right">
            <button type="submit" class="btn btn-warning modBtn"><i class="fa fa-edit"></i> 수정</button>
            <button type="submit" class="btn btn-danger delBtn"><i class="fa fa-trash"></i> 삭제</button>
            </div>
        </div>
    </div>
    
    <div class="box box-warning">
    <div class="box-header with-border">
        <a class="link-black text-lg"><i class="fa fa-pencil"></i>댓글</a>
        <button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>댓글달기</button>
    </div>
    <div class="box-body">
        <div class="panel-body">
				<ul class="chat">
				
				</ul>
				<!-- ./ end ul -->
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

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>댓글 내용</label> <input class="form-control" name='reply'
						value='New Reply!!!!'>
				</div>
				<div class="form-group">
					<label>댓글 작성자</label> <input class="form-control" name='replyer'
						value='replyer'>
				</div>
				<div class="form-group">
					<label>Reply Date</label> <input class="form-control"
						name='replyDate' value='sysdate'>
				</div>

			</div>
			<div class="modal-footer">
				<button id='modalModBtn' type="button" class="btn btn-warning">댓글수정</button>
				<button id='modalRemoveBtn' type="button" class="btn btn-danger">댓글삭제</button>
				<button id='modalRegisterBtn' type="button" class="btn btn-primary">댓글등록</button>
				<button id='modalCloseBtn' type="button" class="btn btn-default">댓글취소</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<script type="text/javascript" src="${contextPath}/resources/reply.js?1"></script>
<script type="text/javascript">
$(document).ready(function () {

    var formObj = $("form[role='form']");
    console.log(formObj);

    $(".modBtn").on("click", function () {
        formObj.attr("action", "${contextPath}/board/freeboard/modify");
        formObj.attr("method", "get");
        formObj.submit();
    });

    $(".delBtn").on("click", function () {
       formObj.attr("action", "${contextPath}/board/freeboard/remove");
       formObj.submit();
    });

    $(".listBtn").on("click", function () {
       self.location = "${contextPath}/board/freeboard/listCriteria"
    });
    
    var bnoValue = '<c:out value = "${get.bno}"/>';
	var replyUL = $(".chat");
	
	showList(1);
	
	function showList(page){
			replyService.getList({bno:bnoValue, page:page||1}, function(replyCnt, list){
				console.log("replyCnt: "+ replyCnt);
				console.log("list: " + list);
				console.log(list);

				if (page == -1) {
					pageNum = Math.ceil(replyCnt / 5.0);
					showList(pageNum);
					return;
				}
				var str="";
				if(list == null || list.length ==0){
					replyUL.html("");
					return;
				}
				for(var i=0, len = list.length || 0; i < len ; i++){
					str += "<li class ='left clearfix' data-rno='"+list[i].rno+"'>";
					str += "<div><div class = 'header'><strong class = 'primary-font'>["+list[i].rno+"]"+list[i].replyer+"</strong>";
					str += "<small class = 'pull-right text-muted'>"+replyService.displayTime(list[i].replyDate) +"</small></div>";
					str += "<p>"+list[i].reply+"</p></div></li>";
				}
				replyUL.html(str);
				showReplyPage(replyCnt);
			}//end function
		
		);//replyService.getList
	}//function showList
	
	var pageNum =1;
	var replyPageFooter = $(".panel-footer");
	/* 페이지 숫자표시 */	
	function showReplyPage(replyCnt){
		var endNum = Math.ceil(pageNum/5.0)*5;
		var startNum = endNum-4;
		var prev = startNum != 1;
		var next = false;
		
		if(endNum * 5 >= replyCnt){
			endNum = Math.ceil(replyCnt/5.0);
		}
		if(endNum * 5 < replyCnt){
			next=true;
		}
		var str = "<ul class = 'pagination pull-right'>";
		if(prev){
			str+="<li class = 'page-item'><a class = 'page-link' href = '"+(startNum -1)+"'>Prev</a></li>";
		}
		for(var i =startNum; i<=endNum; i++){
			var active = pageNum ==i?"active":"";
			str+="<li class = 'page-item "+active+" '><a class='page-link' href='"+i+"'>"+i+"</a></li>";
		}
		if(next){
			str+="<li class = 'page-item'><a class = 'page-link' href = '"+(endNum +1)+"'>Next</a></li>";
		}
		str+="</ul>"

		console.log(str);
		replyPageFooter.html(str);
	} //showReplyPage
	
	/* 페이지 넘어가기 */
	replyPageFooter.on("click", "li a", function(e){
		e.preventDefault();
		console.log("page click");
		var targetPageNum = $(this).attr("href");
		console.log("targetPageNum : "+targetPageNum);
		pageNum = targetPageNum;
		showList(pageNum);
	});//replyPageFooter
	
	replyService.get(10, function(data){
		console.log(data);
	});//get(조회하기)
			
	var modal = $(".modal");
	var modalInputReply = modal.find("input[name='reply']");
	var modalInputReplyer = modal.find("input[name='replyer']");
	var modalInputReplyDate = modal.find("input[name='replyDate']");

	var modalModBtn = $("#modalModBtn");
	var modalRemoveBtn = $("#modalRemoveBtn");
	var modalRegisterBtn = $("#modalRegisterBtn");
	
	$(".chat").on("click", "li", function(e){
		var rno = $(this).data("rno");
		replyService.get(rno, function(reply){
			modalInputReply.val(reply.reply);
			if(modal.data!=null){
				modalInputReplyer.val(reply.replyer);	
			} else {
				modalInputReplyer.val(reply.replyer).attr("readonly","readonly");
			}
			modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly","readonly");
			modal.data("rno",reply.rno);
			
			modal.find("button[id !='modalCloseBtn']").hide();
			modalModBtn.show();
			modalRemoveBtn.show();
			$(".modal").modal("show");
		});//조회하기
	});//조회하기
	
	/* var bnoValue = $("#bno").val(); */

	$("#modalCloseBtn").on("click", function(e) {
		modal.modal('hide');
	});
	$("#addReplyBtn").on("click", function(e) {
		modal.find("input").val("");
		modalInputReplyDate.closest("div").hide();
		modal.find("button[id !='modalCloseBtn']").hide();
		modalRegisterBtn.show();
		$(".modal").modal("show");
	});
	modalRegisterBtn.on("click", function(e) {
		var reply = {
			reply : modalInputReply.val(),
			replyer : modalInputReplyer.val(),
			bno : bnoValue
		};
		replyService.add(reply, function(result) {
			alert(result);
			modal.find("input").val("");
			modal.modal("hide");
		});
		showList(1);
	});
	modalModBtn.on("click",function(e){
		var reply={rno:modal.data("rno"),reply:modalInputReply.val()};
		replyService.update(reply,function(result){
			modal.modal("hide");
			showList(1);
		});
	});
	modalRemoveBtn.on("click",function(e){
		var rno=modal.data("rno");
		replyService.remove(rno,function(result){
			modal.modal("hide");
			showList(1);
		});
	});
    
    
    
});
</script>

</html>