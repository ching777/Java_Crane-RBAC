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
        <title>添加优秀作品</title>
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
                        <form class="form-horizontal m-t" action="answer/work/workAdd" enctype="multipart/form-data" id="datasForm" method="post">
                            <div class="form-group">
                            <label class="col-sm-3 control-label">答辩班级</label>
                                <div class="col-sm-8">
                                    <select class="form-control m-b "    name="class_name" id="class_name" required>
                                        <option value="">请选择</option>
                                        <c:forEach items="${ clazz }" var="clazz">
                                             <option  value="${clazz.class_name }"><c:out value="${clazz.class_name }"></c:out></option>
                                        </c:forEach>
                                    </select>
                                <span style="color:red;" id="error_student_manage"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">答辩题目：</label>
                                <div class="col-sm-8">
                                    <input value="" id="answer_question" readonly="readonly" type="text" class="form-control" minlength="2" required>
                                </div>
                            </div>
                            <div class="form-group">
                            <label class="col-sm-3 control-label">学生姓名</label>
                                <div class="col-sm-8">
                                    <select class="form-control m-b "    name="works_student_id" id="student_name" required>
                                        <option value="">请选择</option>
                                    </select>
                                <span style="color:red;" id="error_student_manage"></span>
                                </div>
                            </div>
                            <br>
                            
                            <div class="form-group">
                            <label class="col-sm-3 control-label">请选择zip格式的压缩包</label>
                                  <div class="ibox-content">
                                    <input type="file" name="works_code" id="works_code" accept="application/x-zip-compressed" required >
                                 </div>
                            </div>
                            <div class="form-group">
                            <label class="col-sm-3 control-label">请选择数据库脚本文件</label>
                                  <div class="ibox-content">
                                    <input type="file" name="works_js" id="works_js"   required>
                                 </div>
                            </div>
                            <div class="form-group">
                            <label class="col-sm-3 control-label">请选择演示视频</label>
                                  <div class="ibox-content">
                                    <input type="file" name="video" id="video"   >
                                 </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary addBtn" id="addBtn" type="button">提交</button>
                                </div>
                            </div>
                            <input type="hidden"  value="" name="works_answer_id" id="works_answer_id">
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <script src="resource/admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="resource/admin/js/bootstrap.min.js?v=3.3.6"></script>
       <script src="resource/admin/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="resource/admin/js/plugins/validate/messages_zh.min.js"></script>
    <!-- 自定义js -->
    <script src="resource/admin/js/content.js?v=1.0.0"></script>
        <script type="text/javascript" src="resource/answer/work.js"></script>
    <script type="text/javascript">
    work.studentChange();
    work.insert();
    </script>
    </body>

</html>