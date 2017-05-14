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


    <title>组信息列表</title>
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
                             <a href="javascript:;" class="btn btn-success btn-outline btn-xs" id="add">新建组</a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th class="col-sm-1"> </th>
                                    <th class="col-sm-2">组名称</th>
                                    <th class="col-sm-2">描述</th>
                                    <th class="col-sm-2">人数</th>
                                    <th class="col-sm-2">操作</th>
                                </tr>
                            </thead>
                            <tbody><%-- items="${groupList }"//items="${groupList }" --%>
                              <c:forEach  items="${list1111 }"  var="group" varStatus="vs">
                                    <tr>
                                        <td>${vs.count }</td>
                                        <td>
                                            <a href="javascript:;" group-id="${group.group_id }" class="seeBtn"><c:out value="${group.group_name }"/></a>
                                        </td>
                                        <td>
                                            <c:out value="${group.market }"/>
                                        </td>
                                        <td>
                                            <c:if test="${!empty  group.peopleCount  }"><c:out value="${group.peopleCount }"/></c:if>
                                            <c:if test="${empty group.peopleCount  }"><c:out value="0"/></c:if>
                                            
                                        </td>
                                        <td>
                                            <a href="javascript:;" class="btn btn-outline btn-primary btn-xs updateBtn" group-id="${group.group_id }">更新</a>
                                            <a href="javascript:;" class="btn btn-outline btn-danger btn-xs delBtn" group-peopleCount="${group.peopleCount }" group-id="${group.group_id }">删除</a>
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
    <script type="text/javascript" src="resource/page/group.js"></script>
    <script type="text/javascript">
    group.group_add();
    group.groupSee();
    group.groupUpdate();
    group.deleteGruop();
    </script>

</body>

</html>