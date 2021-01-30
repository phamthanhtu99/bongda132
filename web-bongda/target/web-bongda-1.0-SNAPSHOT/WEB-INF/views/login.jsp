<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/api/use" var="api"/>
<div class="card align-items-center h-100 mx-auto">
    <c:if test="${param.incorrectAccount != null}">
        <div class="alert alert-danger">
            Tên hoặc mật khẩu không đúng
        </div>
    </c:if>
    <c:if test="${param.accessDenied != null}">
        <div class="alert alert-danger">
            không có quyền truy cập
        </div>
    </c:if>
    <form action="j_spring_security_check" method="post">
    <div class="card-body">
        <div class="form-group">
            <label for="exampleInputEmail1">Tên đăng nhập</label>
            <input type="text" name="j_username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter tên đăng nhập">

        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" name="j_password" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary">Đăng nhập</button>
        <a  onclick="hienthifromdangnhap()"><u>Đăng ký</u></a>
    </div>

    </form>

</div>
<div class="modal fade" id="myModal" role="dialog">

</div>
<c:url value="/ajax-fromdangky" var="dangky"/>
<script>
    function hienthifromdangnhap() {
        var url='${dangky}';
        $("#myModal").load(url,'',function () {
            $('#myModal').modal();
        })

    }



</script>