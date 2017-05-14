<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

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


    <title>H+ 后台主题UI框架 - 基础表格</title>
    <link href="resource/admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="resource/admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="resource/admin/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="resource/admin/css/animate.css" rel="stylesheet">
    <link href="resource/admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>组信息列表</h5>
                        <div class="ibox-tools">
                             <a href="javascript:;" class="btn btn-success btn-outline btn-xs addbtn" id="addBtn">新建角色</a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th class="col-sm-1">序号</th>
                                    <th class="col-sm-2">角色名称</th>
                                    <th class="col-sm-2">角色标识</th>
                                    <th class="col-sm-2">角色状态</th>
                                    <th class="col-sm-3">角色描述</th>
                                    <th class="col-sm-2">操作</th>
                                </tr>
                            </thead>
                            <tbody>
                              <c:forEach  items="${roleList }"  var="role" varStatus="vs">
                                    <tr>
                                        <td>${vs.count }</td>
                                        <td>
                                            <c:out value="${role.role_name }"/>
                                        </td>
                                        <td>
                                            <c:out value="${role.role_key }"/>
                                        </td>
                                        <td>
                                            <c:if test="${role.role_status eq 1 }">
                                                <span style="color:green;">可用</span>
                                            </c:if>
                                            <c:if test="${role.role_status eq 2 }">
                                                <span style="color:red;">禁用</span>
                                            </c:if>
                                            <c:if test="${role.role_status eq 3 }">
                                                <span style="color:#ccc;text-decoration: line-height: ; ">注销</span>
                                            </c:if>
                                         </td>
                                         <td>
                                             <c:out value="${role.market }"/>
                                         </td>   
                                        <td>
                                            <a href="javascript:;" class="btn btn-outline btn-primary btn-xs updateBtn" role-id="${role.role_id }">更新</a>
                                            <a href="javascript:;" class="btn btn-outline btn-danger btn-xs deleteBtn" role-id="${role.role_id }">删除</a>
                                            <a href="javascript:;" class="btn btn-outline btn-danger btn-xs resourceBtn" role-id='${role.role_id }'>分配资源</a>
                                        </td>
                                    </tr>
                                </c:forEach> 
                                
                               
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="resource/admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="resource/admin/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="resource/admin/js/plugins/layer/layer.min.js"></script>
    <!-- 自己的js  -->
    <script type="text/javascript" src="resource/admin/js/role/role.js"></script>
    <script type="text/javascript">role_js.add();</script>
    <script type="text/javascript">role_js.resource();</script>
    <script type="text/javascript">role_js.updateBtn();</script>
    <script type="text/javascript">role_js.del();</script>
</body>

</html>