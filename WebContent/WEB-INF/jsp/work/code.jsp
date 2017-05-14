<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
    //项目的发布路径，例如:  /rabc
    String path = request.getContextPath();
    /*
    全路径，形式如下: http://127.0.0.1:8001/rbac/
    request.getScheme()      ——> http 获取协议
    request.getServerName()  --> 127.0.0.1 获取服务名
    request.getServerPort()  --> 8001 获取端口号
    path                     --> /rbac 获取访问的路径 路
    */
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- 
    <base/>标签解决路径问题
    参考文章:http://www.cnblogs.com/muqianying/archive/2012/03/16/2400280.html
--%>
<!DOCTYPE HTML>
<html>
    <head>

        <base href="<%=basePath%>">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title></title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="resource/admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="resource/admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="resource/admin/css/animate.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="resource/admin/css/plugins/webuploader/webuploader.css">
    <link rel="stylesheet" type="text/css" href="resource/admin/css/demo/webuploader-demo.css">
    <link href="resource/admin/css/style.css?v=4.1.0" rel="stylesheet">
    

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeIn">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>源码上传</h5>  
                    </div>
                    <form action="answer/work/works_code" method="post" enctype="multipart/form-data" id="uploadForm">
                        <div class="ibox-content">
                            <input type="file" name="photo" id="photo" accept="" >
                            <button class="btn btn-success  dim" type="button" id="uploadBtn">
                                <i class="fa fa-upload"></i>
                            </button>
                            <input type="hidden" name=fk_user_detail_id value="${photoMap.fk_user_detail_id }" >
                            <input type="hidden" name="user_id" value="${photoMap.user_id}" >
                        </div>
                    </form>
                    
                </div>
            </div>
        </div>

    </div>
    <!-- 全局js -->
    <script src="resource/admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="resource/admin/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="resource/admin/js/content.js?v=1.0.0"></script>
    
    <script type="text/javascript">
    window.onload = function(){
        document.getElementById("uploadBtn").onclick=function(){
           //HTML5 
          
           var fileName = document.getElementById("photo").value;
           if(fileName===""){
               alert("请上传文件");
               return false;
           }else{
                      document.getElementById("uploadForm").submit(); 
           }
        }
    }
    
    </script>
    
</body>

</html>