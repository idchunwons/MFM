<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp" %>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="${contextPath}/board/freeboard/list">
            <b>MFM 회원가입</b>
        </a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">회원가입 페이지</p>

        <form action="${contextPath}/signup/signup" method="post">
            <div class="form-group has-feedback">
                <input type="text" name="memberid" class="form-control" placeholder="아이디">
                <span class="glyphicon glyphicon-exclamation-sign form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" name="memberpw" class="form-control" placeholder="비밀번호">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="membername" class="form-control" placeholder="이름">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="email" name="memberemail" class="form-control" placeholder="이메일">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            
            <div class="form-group">
			<input class="form-control" style="width: 40%; display: inline;"
				placeholder="우편번호" name="memberzipcode" id="memberzipcode"
				type="text" readonly="readonly">
			<button type="button" class="btn btn-default"
				onclick="execPostCode();">
				<i class="fa fa-search"></i> 우편번호 찾기
			</button>
		</div>
		<div class="form-group">
			<input class="form-control" style="top: 5px;" placeholder="도로명 주소"
				name="memberaddress" id="memberaddress" type="text"
				readonly="readonly" />
		</div>
		<div class="form-group">
			<input class="form-control" placeholder="상세주소" name="memberaddress2"
				id="memberaddress2" type="text" />
		</div>
            <div class="form-group has-feedback">
                <input type="text" name="memberdateofbirth" class="form-control" placeholder="생일">
                <span class="glyphicon glyphicon-exclamation-sign form-control-feedback"></span>
            </div>
           
            <div class="form-group has-feedback">
                <input type="text" name="memberweight" class="form-control" placeholder="키">
                <span class="form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="memberheight" class="form-control" placeholder="몸무게">
                <span class="form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="memberintroduce" class="form-control" placeholder="멤버소개">
                <span class="form-control-feedback"></span>
            </div>
           <div class="form-group has-feedback">
                <input type="radio" name="membergender" value="남" checked>남
                <input type="radio" name="membergender" value="녀">녀
                <span class="form-control-feedback"></span>
            </div>
           <div class="form-group has-feedback">
                <input type="radio" name="membergrade" value="회원" checked>회원
                <input type="radio" name="membergrade" value="강사">강사
                <span class="form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat text-center">가입</button>
                </div>
            </div>
        </form>
        
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<%@ include file="../include/plugin_js.jsp" %>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
<script type="text/javascript">		
function execPostCode() {
    new daum.Postcode({
        oncomplete: function(data) {
           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

           // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
           // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
           var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
           var extraRoadAddr = ''; // 도로명 조합형 주소 변수

           // 법정동명이 있을 경우 추가한다. (법정리는 제외)
           // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
           if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
               extraRoadAddr += data.bname;
           }
           // 건물명이 있고, 공동주택일 경우 추가한다.
           if(data.buildingName !== '' && data.apartment === 'Y'){
              extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
           }
           // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
           if(extraRoadAddr !== ''){
               extraRoadAddr = ' (' + extraRoadAddr + ')';
           }
           // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
           if(fullRoadAddr !== ''){
               fullRoadAddr += extraRoadAddr;
           }

           // 우편번호와 주소 정보를 해당 필드에 넣는다.
           console.log(data.zonecode);
           console.log(fullRoadAddr);
           
           
           $("[name=memberzipcode]").val(data.zonecode);
           $("[name=memberaddress]").val(fullRoadAddr);
           
           /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
           document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
           document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
       }
    }).open();
}
</script>
</body>
</html>