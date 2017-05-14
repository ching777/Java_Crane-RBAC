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
<title>H+ 后台主题UI框架 - 登录</title>
<link href="resource/admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="resource/admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="resource/admin/css/animate.css" rel="stylesheet">
<link href="resource/admin/css/style.css?v=4.1.0" rel="stylesheet">
<script>
    if ( window.top !== window.self ) {
        window.top.location = window.location;
    }
</script>
</head>
<body class="gray-bg">
    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>
                <h1 class="logo-name">H+</h1>
            </div>
            <h3>欢迎使用 H+</h3>
            <form class="m-t" role="form" method="post" id="loginForm" action="sys/login">
                <div class="form-group">
                    <input type="text" id="loginAccount" name="account" class="form-control" placeholder="用户名" required="" autofocus="autofocus">
                </div>
                <div class="form-group">
                    <input type="password" id="loginPassword" name="password" class="form-control" placeholder="密码" required="">
                </div>
                <button type="button" id="loginButton" class="btn btn-primary block full-width m-b">登 录</button>
                <p class="text-muted text-center" id="PCss"> 
                ${message }
                
                </p>

 
            </form>
        </div>
    </div>
    <!-- 全局js -->
    <script src="resource/admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="resource/admin/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="resource/page/login.js"> </script>
    <script type="text/javascript">login_js.login();</script>

    
    
</body>
</html>