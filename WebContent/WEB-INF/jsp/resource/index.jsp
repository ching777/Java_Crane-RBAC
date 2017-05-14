<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
	String path = request.getContextPath();
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
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    
        <title>资源管理界面</title>
        <link href="resource/admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
        <link href="resource/admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
        <link href="resource/admin/css/plugins/jsTree/style.min.css" rel="stylesheet">
        <link href="resource/admin/css/animate.css" rel="stylesheet">
        <link href="resource/admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">

        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                <button class="btn btn-primary" type="button" id="deleteBtn" onclick="getAddParentJsp()">添加父节点</button>
                <button class="btn btn-primary" type="button" id="deleteBtn" onclick="getAddChildJsp()">添加子节点</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>基本示例 <small></h5>
                    </div>
                    <div class="ibox-content">

                        <div id="jstree1">
                            <ul>
                                <li class="jstree-open">资源节点管理
                                    <c:forEach items="${parentNode }" var="parent">
                                    <ul>
                                        <li>
                                        <a href="javascript:;" onclick="editResource('${parent.parent_id}','${parent.resource_id }')">
                                            <c:out value="${parent.resource_name}"/>
                                        </a>
                                            <ul>
                                                <c:forEach items="${childNode }" var="child">
                                                    <c:if test="${child.parent_id==parent.resource_id }">
                                                      <li data-jstree='{"type":"img"}'>
                                                      <a href="javascript:;" onclick="editResource('${child.parent_id}','${child.resource_id }')">
                                                      <c:out value="${child.resource_name }"></c:out>
                                                      </a>
                                                      </li>
                                                    </c:if>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                    </ul>
                                    </c:forEach>
                                </li>
                            </ul>
                        </div>

                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>资源详细信息</h5>
                        <!-- 使用IFRAME进行显示 -->
                        <iframe id="resourceIframe" class="J_iframe" width="100%" height="300"  frameborder="0" seamless></iframe>
                    </div>
                    <div class="ibox-content">

                        <div id="using_json"></div>

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


    <!-- jsTree plugin javascript -->
    <script src="resource/admin/js/plugins/jsTree/jstree.min.js"></script>

    <style>
        .jstree-open > .jstree-anchor > .fa-folder:before {
            content: "\f07c";
        }

        .jstree-default .jstree-icon.none {
            width: 0;
        }
    </style>

    <script>
        $(document).ready(function () {

            $('#jstree1').jstree({
                'core': {
                    'check_callback': true
                },
                'plugins': ['types', 'dnd'],
                'types': {
                    'default': {
                        'icon': 'fa fa-folder'
                    },
                    'html': {
                        'icon': 'fa fa-file-code-o'
                    },
                    'svg': {
                        'icon': 'fa fa-file-picture-o'
                    },
                    'css': {
                        'icon': 'fa fa-file-code-o'
                    },
                    'img': {
                        'icon': 'fa fa-file-image-o'
                    },
                    'js': {
                        'icon': 'fa fa-file-text-o'
                    }

                }
            });


        });
    </script>
<script type="text/javascript">
 function editResource( parent, child){
	 var url="sys/resource/"+parent+"/"+child;
	 $("#resourceIframe").attr("src",url);
 }

</script>
<script type="text/javascript" src="resource/admin/resource/resource.js"></script>

</body>

</html>