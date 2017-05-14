<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
<title>用户信息列表</title>
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
                        <h5>用户信息列表</h5>
                         <div class="ibox-tools">
                            <form action="answer/clazz/list" method="get" id="searchForm">
                                <div class="ibox-tools">
                                     <a href="javascript:;" class="btn btn-success btn-outline btn-xs add" >新建备忘录</a>
                                </div>
                            </form>
                         </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th class="col-sm-1">序号</th>
                                    <th class="col-sm-1">姓名</th>
                                    <th class="col-sm-1">备忘录</th>
                                    <th class="col-sm-1">班级</th>
                                    <th class="col-sm-1">班级所处阶段</th>
                                    <th class="col-sm-1">答辩题目</th>
                                    <th class="col-sm-1">操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${evaluateList }" var="datas" varStatus="vs">
                                    <tr>
                                        <td>${vs.count }</td>
                                        <td>
                                            <c:out value="${datas.student_name }" />
                                        </td>
                                        <td>
                                            <c:out value="${datas.evaluate_info }" />
                                        </td>
                                        <td>
                                            <c:out value="${datas.class_name }" />
                                        </td>
                                        <td>
                                            <c:if test="${datas.class_stage eq '1' }"><c:out value="第一阶段"/></c:if>
                                            <c:if test="${datas.class_stage eq '2' }"><c:out value="第二阶段"/></c:if>
                                            <c:if test="${datas.class_stage eq '3' }"><c:out value="第三阶段"/></c:if>
                                        </td>
                                        <td>
                                            <c:out value="${datas.answer_question }" />
                                        </td>
                                        <td>
                                            <a href="javascript:;" class="btn btn-outline btn-primary btn-xs updateBtn"  mark-id="${datas.evaluate_id  }">修改</a> 
                                            <a href="javascript:;" class="btn btn-outline btn-danger btn-xs deleteBtn"  student-name="${datas.student_name }" mark-id="${datas.evaluate_id}" >删除</a>
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
    <script src="resource/admin/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="resource/admin/js/plugins/validate/messages_zh.min.js"></script>
    <script src="resource/admin/js/demo/form-validate-demo.js"></script>
    <!-- 自己的JS -->
     <script type="text/javascript" src="resource/answer/evaluate.js"></script>
    <script type="text/javascript">
    evaluate.add();
    evaluate.upda();
    evaluate.del()
				</script> 
    
</body>
</html>