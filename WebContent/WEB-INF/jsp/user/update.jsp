<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			pageContext.setAttribute("path", path);
			pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="${basePath}">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>修改帐号信息</title>
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
                        <form class="form-horizontal m-t" id="userForm" action="sys/user/update" method="post">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">帐号：</label>
                                <div class="col-sm-8">
                                    <input id="account" name="account" minlength="5" type="text" class="form-control" placeholder="请输入帐号名称" value="${user.account }" readonly="readonly">
                                    <span id="account_error" style="color: red;"></span>
                                </div>
                            </div>
                             <div class="form-group">
                                <label class="col-sm-3 control-label">电话：</label>
                                <div class="col-sm-8">
                                    <input id="tel" name="tel" minlength="11" type="text" class="form-control" placeholder="请输入电话号码" value="${user.tel }" >
                                    <span id="tel_error" style="color: red;"></span>
                                </div>
                            </div>
                             <div class="form-group">
                                <label class="col-sm-3 control-label">邮箱：</label>
                                <div class="col-sm-8">
                                    <input id="email" name="email" minlength="6" type="text" class="form-control" placeholder="请输入邮箱" value="${user.email }" >
                                    <span id="email_error" style="color: red;"></span>
                                </div>
                            </div>
                                    
                            <div class="form-group">
                                <label class="col-sm-3 control-label">组别</label>
                                <div class="col-sm-8">
                                    <select class="form-control m-b" name="fk_group_id" id="fk_group_id">
                                    <option value=""> 请选择组别</option>
                                    <c:forEach items="${groupList }" var="group">
                                        <option value="${group.group_id }" 
                                            <c:if test="${user.fk_group_id==group.group_id }">
                                                selected="selected"
                                            </c:if>> ${group.group_name }
                                        </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                              <div class="form-group">
                                <label class="col-sm-3 control-label">角色</label>
                                <div class="col-sm-8">
                                    <select class="form-control m-b" name="fk_role_id" id="fk_role_id">
                                     <option value=""> 请选择角色</option>
                                    <c:forEach items="${roleList }" var="role">
                                        <option value="${role.role_id }" <c:if test="${user.fk_role_id==role.role_id }">
                                            selected="selected"
                                        </c:if>> ${role.role_name }</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary " type="button" id="updateBtn">提交</button>
                                </div>
                            </div>
                             <!-- 隐藏域 -->
                            <input type="hidden" name="user_id" value="${user.user_id }">
                            <input type="hidden" id="old_tel" value="${user.tel }">
                            <input type="hidden" id="old_email" value="${user.email }">
                            <input type="hidden" name="_method" value="put">
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
    <!-- 自定义js -->
    <script src="resource/admin/js/content.js?v=1.0.0"></script>
   
    <!-- 自己的JS -->
       <script type="text/javascript" src="resource/page/user.js"></script>
    <script type="text/javascript">
                   user_js.edit();
                </script> 
</body>
</html>