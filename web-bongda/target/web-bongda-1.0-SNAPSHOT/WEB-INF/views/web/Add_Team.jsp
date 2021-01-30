<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020-12-20
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><dec:title default="Tạo Team"/> </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href=" <c:url value="/template/admin/css/stleslg.css" />"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<style>
    .hidet{
        display: none;
    }
</style>
<div class="container  ">
    <div class="row">
        <div class="col-sm-12  mt-1 tt">
            <h2 class="">Tạo Team</h2>
            <form:form modelAttribute="team" id="formteam" enctype="multipart/form-data">
            <div class="row">
                <div class="col-sm-8 bg-light">

                        <div class="input-group mb-3">
                            <div class="input-group m-2">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" >Tên Đội</span>
                                </div>
                                <form:input type="text"  class="form-control" path="name"/>
                            </div>
                            <div class="input-group m-1">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Tiêu Đề</span>
                                </div>
                                <form:input type="text" class="form-control" path="slogan"/>
                            </div>
                            <button type="button"  class="buttonload btn btn-white btn-warning btn-bold " value="Tạo Team"id="btnupdate">
                                <i class= "loading-ion fa fa-spinner fa-spin hidet" ></i>
                                <span class="txt">Tạo Đội</span>
                            </button>

                        </div>

                </div>
                <div class="col-sm-4">

                    <div class="file-upload ">
                        <div class="image-upload-wrap">
                            <input class="file-upload-input" id="file" type='file' onchange="readURL(this);" accept="image/*" />
                            <div class="drag-text">
                                <h3>Drag and drop a file or select add Image</h3>
                            </div>
                        </div>
                        <div class="file-upload-content">
                            <img class="file-upload-image" src="#" alt="your image" />
                            <div class="image-title-wrap">
                                <button type="button" onclick="removeUpload()" class="remove-image ">Remove </button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            </form:form>
        </div>
    </div>
</div>
<c:url value="/api/team" var="api"/>
<c:url value="/trang-chu/danh-sach-team" var="team"/>
<script>
  $('#btnupdate').click(function (e) {
      e.preventDefault();
      var formdata ={};
      var teamdata=$('#formteam').serializeArray();
      $.each(teamdata,function (i,v) {
          formdata[""+v.name+""] = v.value;
      })
      var data = new FormData();
      var file =$('#file')[0].files[0];
      data.append('file',file);
      data.append('datateam',JSON.stringify(formdata));
      $('.loading-ion').removeClass('hidet');
      $('.txt').text("Đang thêm vào hệ thống");
      $('#formteam').submit(
          $.ajax({
              url:'${api}',
              type:'Post',
              data:data,
              contentType:false,
              processData:false,
              dataType: 'json',
              success: function (response) {
                  if(response.name!=null){
                      alert("tạo Đội thành công! Đội bạn là "+response.name);
                      $('.loading-ion').addClass('hidet');
                      $('.txt').text("Tạo Đội")
                  }else {
                      alert("tạo thất bại ");
                        window.location.href="${team}";
                  }

              }
          })
      )
  });


</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>;
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="<c:url value="/template/admin/js/xulianh.js"/> "/>

</body>
</html>
