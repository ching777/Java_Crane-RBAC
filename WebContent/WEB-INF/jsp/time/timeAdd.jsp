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
                        <form class="form-horizontal m-t" action="answer/time/timeAdd1" id="datasForm" method="post">
                            <div class="form-group">
                            <label class="col-sm-3 control-label">答辩班级</label>
                                <div class="col-sm-8">
                                    <select class="form-control m-b "   name="fk_class_id" id="fk_class_id" required>
                                        <option value="">请选择</option>
                                        <c:forEach items="${ clazz }" var="clazz">
                                             <option count-id="${clazz.student_count }" value="${clazz.class_id }"><c:out value="${clazz.class_name }"></c:out></option>
                                        </c:forEach>
                                    </select>
                                <span style="color:red;" id="error_student_manage"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">答辩人数：</label>
                                <div class="col-sm-8">
                                    <input id="answer_people_number" name="answer_people_number"  type="text" class="form-control"  required>
                                    <span style="color:red;" id="error_student_number"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3  control-label">答辩日期：</label>
                                <div class="col-sm-8">
                                    <input id="answer_apple_date" type="text"  name="answer_apple_date" class="laydate-icon form-control " required>
                                </div>
                            </div>
                             <div class="form-group">
                            <label class="col-sm-3 control-label">答辩状态</label>
                                <div class="col-sm-8">
                                    <select class="form-control m-b "   name="answer_states" id="answer_states" required>
                                        <option value="申请中">申请</option>
                                        <option value="通过">通过</option>
                                    </select>
                                <span style="color:red;" id="error_student_manage"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">答辩题目：</label>
                                <div class="col-sm-8">
                                    <input id="answer_question" name="answer_question"  type="text" class="form-control" minlength="2" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">评委老师：</label>
                                <div class="col-sm-8">
                                    <input id="answer_judge_name" name="answer_judge_name"  type="text" class="form-control" minlength="2" required>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary addBtn" type="button">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>


    <!-- 全局js -->
    <script src="resource/admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="resource/admin/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
     <script src="resource/admin/js/plugins/layer/laydate/laydate.js"></script>
    <script>
        //外部js调用
        laydate({
            elem: '#answer_apple_date', //id选择器
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });
    </script>
    <script src="resource/admin/js/content.js?v=1.0.0"></script>

    <!-- jQuery Validation plugin javascript-->

   <script src="resource/admin/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="resource/admin/js/plugins/validate/messages_zh.min.js"></script>
    <script src="resource/admin/js/demo/form-validate-demo.js"></script>
     <script type="text/javascript" src="resource/answer/time.js"></script>
    <script type="text/javascript">
                   time.people_number(); 
                    time.insert();
                </script> 

</body>

</html>