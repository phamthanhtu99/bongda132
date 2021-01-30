<%@ include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><dec:title default="Đăng Ký"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href=" <c:url value="/template/admin/css/stleslg.css" />"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body >
<c:url value="/api/use" var="api"/>
<div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title">Thông tin</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
            <form:form  id="fromdangnhap" modelAttribute="user">
                <div class="input-group mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-fullname">Họ và tên</span>
                    <form:input  class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-fullname" path="fullName"/>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-user">Tên đăng nhập</span>
                    <form:input  class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-user" path="username"/>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-password">Mật Khẩu</span>
                    <form:input  type="password" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-password" path="password"/>
                </div>
            </form:form>
        </div>
        <div class="modal-footer">
            <button type="button" onclick="dangnhap()" id="dangnhap1"  class="btn btn-danger" >Đăng ký</button>
            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
    </div>
<c:url var="dangnhap" value="/j_spring_security_check"/>
</div>
<script>
    function dangnhap() {
        var data={};
        var form= $('#fromdangnhap').serializeArray()
        $('#dangnhap1').attr("data-dismiss","modal");
        $.each(form,function (i,v) {
            data[""+v.name+""] = v.value;
        })
        $.ajax({
            url:"${api}",
            type:'post',
            contentType:'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success:function (result) {
                if (result!=0){
                    $('#dangnhap1').attr("data-dismiss","modal");
                    alert("đăng ký thành công ! Xin chào "+result.fullName+"! Vui lòng đăng nhập !")

                }else {
                    result.log("that baị")
                }
            }

        })
    }
</script>
</body>
</html>



