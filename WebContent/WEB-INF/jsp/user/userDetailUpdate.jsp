<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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
                        <form class="form-horizontal m-t" id="userForm" action="sys/user/userDetailUpdate"  method="post">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">帐号：</label>
                                <div class="col-sm-8">
                                    <input id="account"  minlength="2" value="${session_user.account }" readonly="readonly" type="text" class="form-control">
                                    <span id="account_error" style="color: red;"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" >用户姓名：</label>
                                <div class="col-sm-8">
                                    <input id="user_name" name="userDetail.user_name" value="${ session_user.userDetail.user_name }"  class="form-control" type="text" minlength="2">
                                </div>
                            </div>
                             <div class="form-group">
                                <label class="col-sm-3 control-label">性别：</label>
                                <div class="col-sm-8">
                                    <select class="form-control m-b" name="userDetail.sex" >
                                        <option value="">请性别</option>
                                        <option value="男" <c:if test="${session_user.userDetail.sex eq '男'}">selected='selected'</c:if>>
                                                                                          男   
                                        </option>
                                        <option value="女" <c:if test="${session_user.userDetail.sex eq '女'}">selected='selected'</c:if>>
                                                                                          女  
                                        </option>
                                    </select>
                                </div>
                            </div>
                           <div class="form-group">
                                <label class="col-sm-3  control-label">生日：</label>
                                <div class="col-sm-8">
                                    <input id="date_input" type="text" value="<fmt:formatDate value='${session_user.userDetail.birthday }' pattern='yyyy-MM-dd' />" name="userDetail.birthday" class="laydate-icon form-control ">
                                </div>
                            </div>
                            <%-- <div class="form-group">
                                <label class="col-sm-3 control-label">生日：</label>
                                <div class="col-sm-8">
                                    <input type="text"  value="<fmt:formatDate value='${session_user.userDetail.birthday }' pattern='yyyy-MM-dd' />" class="form-control">
                                </div>
                            </div> --%>
   
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary addBtn" type="submit">保存</button>
                                </div>
                            </div>
                            <input type="hidden" name="user_id" value="${session_user.user_id}"> 
                            <input type="hidden" name="fk_user_detail_id" value="${session_user.fk_user_detail_id}"> 
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>


    <!-- 全局js -->
    <script src="resource/admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="resource/admin/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="resource/admin/js/plugins/layer/layer.min.js"></script>
     <script src="resource/admin/js/plugins/layer/laydate/laydate.js"></script>
    <script>
        //外部js调用
        laydate({
            elem: '#date_input', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });

    </script>

    <!-- 自定义js -->
    <script src="resource/admin/js/content.js?v=1.0.0"></script>

    <!-- jQuery Validation plugin javascript-->
    <script src="resource/admin/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="resource/admin/js/plugins/validate/messages_zh.min.js"></script>
    <script src="resource/admin/js/demo/form-validate-demo.js"></script>

</body>

</html>