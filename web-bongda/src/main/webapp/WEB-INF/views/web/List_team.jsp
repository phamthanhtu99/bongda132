<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-01-13
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.common.SecurityUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><dec:title default="doanh sách đội"/> </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
</head>
<body>
<c:url value="/trang-chu/danh-sach-team" var="phantrang"/>
<c:url value="/trang-chu/danh-sach-team/tao-doi" var="linkaddteam"/>
<c:url value="/trang-chu/danh-sach-team?page=1&limit=3" var="listeam"/>
<c:url value="/api/TeamUserAPI" var="api"/>
<div class="container">
    <h2 class="fa-align-center">DOANH SÁCH ĐỘI : <button  type="button" class="btn btn-outline-warning"><a href="${linkaddteam}">Tạo Đội</a></button></h2>
    <div class=""></div>
    <form action="${phantrang}" id="formSubmit" method="get">
    <div class="row">
        <c:forEach var="item" items="${List}">
            <c:forEach var="team" items="${item.key}">
            <div class="card text-muted bg-light m-1 col-sm" style="max-width: 33.3rem;height: 20rem; ">
                <c:set var="use" value="<%= SecurityUtils.getprincipal().getId()%>"/>
                <div class="card-header">Name Team: ${team.name}
                    <c:set var="ketqua" value="ko"/>
                    <c:set var="co" value="co"/>
                    <c:set var="ko" value="ko"/>
                    <c:forEach items="${item.value}" var="checkuser">

                        <c:if test="${checkuser.id ==use}">
                            <c:set var="ketqua" value="${co}"/>

                        </c:if>

                    </c:forEach>
                    <c:if test="${ketqua == co}">
                        <button  type="button" class=" bg-light disabled"><span class="txt">
                                Bạn đã có đội
                            </span></button></h5>
                    </c:if>
                    <c:if test="${ketqua == ko}">
                        <button sc-url="${xinvao}" type="button" onclick="requestgroud(${team.id},${use})"
                                id="requestgroud_${team.id}" class=" bg-light"><span class="txt">
                                xin vào
                            </span></button></h5>
                    </c:if>

                </div>
                <c:url var="xinvao" value="/api/TeamUserAPI">
                    <c:param name="team" value="${team.id}"/>
                    <c:param name="user" value="${use}"/>
                </c:url>
                <div class="card-body">
                    <h5 class="card-title ">Khẩu hiệu :${team.slogan}


                        <img class="card-img-top " src="<c:url value="/repository/${team.imge}"/> " alt="Card image cap">


                </div>
            </div>
            </c:forEach>
        </c:forEach>
    </div>
        <div class="row justify-content-center mt-5">
            <ul class="pagination text-center" id="pagination"></ul>
        </div>

    <input type="hidden" name="page" id="page"/>
    <input type="hidden" name="limit" id="limit"/>
    </form>

</div>


<script>
    $(function () {
        var totalPages = ${page.totalPage};
        var currentPage = ${page.page};
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,  /*tong so trang*/
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {  /* trang ở đây là giá trị bấm chuyển trang vd 2 -> page 2*/
                if (currentPage!=page){
                    $('#limit').val(3);
                    $('#page').val(page);
                    $('#formSubmit').submit();
                }
            }
        });
    });
    function UrlConvertToJson(url) {
        var  url =new URL("http://localhost:8080/"+url);
        var team =url.searchParams.get("team");
        var user = url.searchParams.get("user");
        var myObj = {teamDTO: team, userDTO: user};
        return myObj;
    }
 /*   function requestgroud(team,user) {
        var data={};
        var url1 = $(i).attr('sc-url');
        var form = new FormData();
         data =UrlConvertToJson(url1);
        form.append("TeamDTO",JSON.stringify(data));
        $.ajax({
            type: "Post",
            url: '${api}',
            data: form, // Note it is important
            contentType:false,
            processData:false,
            dataType : 'json',
            success :function(result) {
                // do what ever you want with data
            }
        });
    }*/
    function requestgroud(team,user) {
        var data={teamDTO:{id:team} , userDTO:{id: user}};
        $.ajax({
            type: "Post",
            url: '${api}',
            data: JSON.stringify(data), // Note it is important
            contentType:'application/json',
            dataType : 'json',
            success :function(result) {
                alert("bạn đã vào đội "+result.teamDTO.name+"")
                window.location.href="${listeam}";
            }
        });
    }
</script>
</body>
</html>

