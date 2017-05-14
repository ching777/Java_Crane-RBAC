<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("path", path);
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML>
<html>
	<head>

		<base href="${basePath}">
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>新建组</title>
        <link href="resource/admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
        <link href="resource/admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
        <link href="resource/admin/css/animate.css" rel="stylesheet">
        <link href="resource/admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="userForm" action="sys/user/add"  method="post">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">帐号：</label>
                                <div class="col-sm-8">
                                    <input id="account" name="account"  type="text" class="form-control"  aria-required="true" aria-invalid="true">
                                    <span id="account_error" style="color: red;"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">密码：</label>
                                <div class="col-sm-8">
                                    <input id="password" name="password" class="form-control" type="password">
                                    <span id="password_error" style="color: red;"></span>
                                </div>
                            </div>
                             <div class="form-group">
                                <label class="col-sm-3 control-label">确认密码：</label>
                                <div class="col-sm-8">
                                    <input id="confirm_password"  class="form-control" type="password">
                              <span id="confirm_password_error" style="color: red;"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary addBtn" type="button">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>


    <!-- 全局js -->
    <script src="resource/admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="resource/admin/js/bootstrap.min.js?v=3.3.6"></script>
    

    <!-- 自定义js -->
    <script src="resource/admin/js/content.js?v=1.0.0"></script>

    <!-- jQuery Validation plugin javascript-->
    <script src="resource/admin/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="resource/admin/js/plugins/validate/messages_zh.min.js"></script>
    <script src="resource/admin/js/demo/form-validate-demo.js"></script>
  <script type="text/javascript" src="resource/page/user.js"></script>
    <script type="text/javascript">
                    user_js.insert();
                </script> 

</body>

</html>