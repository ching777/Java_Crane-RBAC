<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
                        <h5>班级信息列表</h5>
                          <div class="ibox-tools">
                            <form action="answer/clazz/list" method="get" id="searchForm">
                                                                      班级名称
                                <input name="query['class_name']" value="${pager.query.class_name }">
                                                                      答辩题目
                                <select name="query['class_stage']">
                                <option value="">请选择状态</option>
                                <option value="1" <c:if test="${pager.query.class_stage eq '1' }">selected='selected'</c:if>>第一阶段</option>
                                <option value="2" <c:if test="${pager.query.class_stage eq '2' }">selected='selected'</c:if>>第二阶段</option>
                                <option value="3" <c:if test="${pager.query.class_stage eq '3' }">selected='selected'</c:if>>第三阶段</option>
                                <option value="-1" <c:if test="${pager.query.class_stage eq '-1' }">selected='selected'</c:if>>已完结</option>
                                </select>
                                <button class="btn btn-success btn-outline btn-xs">查询</button>
                                <div class="ibox-tools">
                                     <a href="javascript:;" class="btn btn-success btn-outline btn-xs add" >新建班级</a>
                                </div>
                            </form>
                         </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th class="col-sm-1">序号</th>
                                    <th class="col-sm-2">班级名称</th>
                                    <th class="col-sm-2">开班时间</th>
                                    <th class="col-sm-1">所处阶段</th>
                                    <th class="col-sm-1">班级性质</th>
                                    <th class="col-sm-1">班级人数</th>
                                    <th class="col-sm-2">主讲老师</th>
                                    <th class="col-sm-2">操作</th>
                                </tr>
                            </thead>
                            <tbody>
                              <c:forEach  items="${clazzList }"  var="list" varStatus="vs">
                                    <tr>
                                        <td>${vs.count }</td>
                                        <td>
                                            <%-- <a href="answer/student/list?${list.class_name }"  class="seeBtn"><c:out value="${list.class_name }"/></a> --%>
                                            <a href="javascript:;" mark-id="${list.class_name }" class="seeBtn"><c:out value="${list.class_name }"/></a>
                                        </td>
                                        <td>
                                            <fmt:formatDate value="${ list.class_open_time }" pattern="yyyy-MM-dd" />
                                        </td>
                                        <td>
                                            <c:if test="${list.class_stage eq 1 }"><c:out value="第一阶段"/></c:if>
                                            <c:if test="${list.class_stage eq 2 }"><c:out value="第二阶段"/></c:if>
                                            <c:if test="${list.class_stage eq 3 }"><c:out value="第三阶段"/></c:if>
                                        </td>
                                        <td>
                                            <c:out value="${list.class_property }"/>
                                        </td>
                                        <td>
                                            <c:if test="${ !empty list.student_count }"><c:out value="${list.student_count }"/></c:if>
                                            <c:if test="${ empty list.student_count }"><c:out value="0"/></c:if>
                                            
                                        </td>
                                        <td>
                                            <c:out value="${list.class_teacher }"/>
                                        </td>
                                        <td>
                                            <a href="javascript:;" class="btn btn-outline btn-primary btn-xs updateBtn" clazz-id="${list.class_id }">更新</a>
                                            <a href="javascript:;" class="btn btn-outline btn-danger btn-xs stageBtn"  clazz-name="${list.class_name }" clazz-stage="${list.class_stage }" clazz-id="${list.class_id }">完结</a>
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
    <script type="text/javascript" src="resource/answer/clazz/clazz.js"></script>
    <script type="text/javascript">
    clazz.add();
    clazz.seeBtn();
    clazz.update();
    clazz.stage();
    </script>
</body>
</html>