<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
        <title>资源节点信息</title>
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
                        <form class="form-horizontal m-t" id="addChildForm" action="sys/resource/addChild" method="post">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">资源名称：</label>
                                <div class="col-sm-8">
                                    <input id="resource_name" name="resource_name" minlength="2" type="text" class="form-control" value="${resource.resource_name }">
                                    <span id="resource_name_error" style="color: red;"></span>
                                </div>
                            </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">设置访问资源:URL</label>
                                    <div class="col-sm-8">
                                        <input id="url" name="url" minlength="2" type="text" class="form-control" value="${resource.url }">
                                            <span id="url_error" style="color: red;"></span>
                                    </div>
                                </div>
                            <div class="form-group">
                            <label class="col-sm-3 control-label">父节点列表</label>
                                <div class="col-sm-8">
                                    <select class="form-control m-b" name="parent_id" id="parent_id">
                                                <option value="-1">请选择父节点</option>
                                        <c:forEach items="${parentNodeList }" var="parent">
                                            <option value="${parent.resource_id }"
                                            >
                                                <c:out value="${parent.resource_name }"></c:out>
                                            </option>
                                        </c:forEach>
                                    </select>
                                    <span id="parent_name_error" style="color: red;"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary" type="button" onclick="addChild()">新增子节点</button>
                                    <!-- [如果你删除的是父节点,那么如果存在子节点不允许删除] -->
                                </div>
                            </div>
                            
                            <%-- 隐藏 --%>
                            <input type="hidden" name="resource_id" id="resource_id" value="${resource.resource_id }">
                            <input type="hidden" id="old_parent_id" value="${resource.parent_id }">
                            <input type="hidden" name="_method" id="_method">
                            
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

    <!-- jQuery Validation plugin javascript-->
    <script src="resource/admin/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="resource/admin/js/plugins/validate/messages_zh.min.js"></script>

    <script src="resource/admin/js/demo/form-validate-demo.js"></script>
    <script type="text/javascript" src="resource/admin/resource/resource.js"></script>

</body>

</html>