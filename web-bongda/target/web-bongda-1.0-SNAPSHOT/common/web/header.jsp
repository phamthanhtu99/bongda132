<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.common.SecurityUtils" %>
<header class="container-f  header_css sticky-top ">
    <nav class="navbar navbar-example navbar-expand-lg navbar-light bg-warning">
        <a class="navbar-brand" href="#">Trang Chủ</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Thông báo</a>
                </li>
                <li class="nav-item dropdown active">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Thông Cá nhân
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Thông tin thành viên nhóm</a>
                        <a class="dropdown-item" href="#">lịch sử đội bóng</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Cập nhật Thông tin nhóm</a>
                        <a class="dropdown-item" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">Đội Bóng</a>

                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="<c:url value="/trang-chu/danh-sach-team?page=1&limit=3"/>" >
                        Tạo đội,danh sách đội
                    </a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link active " >
                        Hi: <%=SecurityUtils.getprincipal().getFullname()%>

                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active "  href="<c:url value="/thoat"/>">
                       Thoát
                    </a>
                </li>

            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
    <button class="btn  position-fixed navbar-toggler " role="button"  aria-haspopup="true" aria-expanded="false" type="button" data-toggle="collapse" data-target="#multiCollapseExample2" aria-expanded="false" aria-controls="multiCollapseExample2"> <span class="navbar-toggler-icon"></span></button>
    <div class="collapse container" id="collapseExample">
        <c:if test="${ empty List_Team }" >
        <div class="card container mr-1 " >
            <img class=" fakeim1"  />
            <div class="opacity bg-warning">
                <div class="card-body ">
                    <a  class="fa-behance text-center" href="<c:url value="/trang-chu/danh-sach-team?page=1&limit=3"/>">Xin Vào đội </a>
                </div>
            </div>
        </c:if>
            <c:if test="${not empty List_Team}">
            <c:forEach var="item" items="${List_Team}">
            <div class="card container mr-1 " >
                <img class=" fakeim1" src="<c:url value="/repository/${item.key.teamDTO.imge}"/> " />
                <div class="opacity bg-warning">

                    <div class="card-body ">
                        <h5 class="card-title">Tên đội : ${item.key.teamDTO.name}</h5>
                        <p class="card-text">Khẩu hiệu : ${item.key.teamDTO.slogan}</p>
                    </div>
                    <ul class="list-group list-group-flush">

                        <li class="list-group-item"> Ngày Tạo: ${item.key.teamDTO.createdDate}</li>
                        <li class="list-group-item">Số thành viên: ${item.key.teamDTO.membermin}/12</li>
                    </ul>
                    <c:set var="stt" value="1"/>
                    <c:forEach items="${item.value}" var="user">
                    <c:if test="${user.team_role.id ==1}" >
                        <a  class="card-link">NGười Tạo ${stt} : ${user.userDTO.fullName}</a>
                        <c:set value="${stt+1}" var="stt"/>
                    </c:if>


                </div>
                </c:forEach>

            </div>


    </div>
    </c:forEach>
            </c:if>
    </div>

</header>