<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 新增角色</title>
    <%@include file="../../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/treeGrid/css/jquery.treegrid.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/static/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="/static/plugins/uploader/webuploader.css">
    <style>
        .icheckbox_square-aero, .iradio_square-aero {
            margin: 0;
            padding: 0;
            width: 18px;
            height: 18px;
            border: none;
            cursor: pointer;
        }

    </style>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/header.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="manage_roles"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                售票点管理
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">新增售票点</h3>
                    <div class="box-tools">
                        <a href="/base/office" class="btn btn-success btn-sm">返回</a>
                    </div>
                </div>
                <div class="box-body">
                    <form method="post" id="saveForm">
                        <div class="form-group">
                            <label>售票点名称</label>
                            <input type="text" name="officeName" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>售票点地址</label>
                            <input type="text" name="officeAddress" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>法人名称</label>
                            <input type="text" name="legalPersonName" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>法人电话</label>
                            <input type="text" name="legalPersonMobile" class="form-control">
                        </div>
                        <div id="uploader" class="wu-example">
                            <!--用来存放文件信息-->
                            <div id="thelist" class="uploader-list"></div>
                            <div class="btns">
                                <div id="picker">选择文件</div>
                                <button id="ctlBtn" class="btn btn-default">开始上传</button>
                            </div>
                        </div>

                    </form>




                </div>
                <div class="box-footer">
                    <button class="btn pull-right btn-primary" id="saveBtn">保存</button>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../../include/js.jsp"%>
<script src="/static/plugins/treeGrid/js/jquery.treegrid.min.js"></script>
<script src="/static/plugins/treeGrid/js/jquery.treegrid.bootstrap3.js"></script>
<script src="/static/plugins/uploader/webuploader.js"/>
<!-- iCheck -->
<script src="/static/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        var uploader = WebUploader.create({

            auto:true,
            // 文件接收服务端。
            server: 'https://qiuhui-tms-1256188839.cosbj.myqcloud.com',
            formData:{
                "op":"upload",
                "Authorization":
            },
            // 选择文件的按钮。可选。
            pick: '#picker',

            // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
            resize: false
        });



        $("#saveBtn").click(function () {
            $("#saveForm").submit();
        });


    })
</script>
</body>
</html>