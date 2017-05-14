<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
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
        <title>新建备忘录</title>
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
                        <form class="form-horizontal m-t" action="answer/evaluate/evaluateAdd" id="dataForm" method="post">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">班级名称：</label>
                                <div class="col-sm-8">
                                    <select class="form-control m-b"  id="class_name" required>
                                        <option value="">请选择</option>
                                        <c:forEach items="${clazz }" var="datas">
                                            <option value="${ datas.class_name }"><c:out value="${datas.class_name }"></c:out></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">姓名：</label>
                                <div class="col-sm-8">
                                    <select class="form-control m-b" name="evaluate_student_id" id="student_name" required>
                                        <option value="">请选择</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">答辩题目：</label>
                                <div class="col-sm-8">
                                    <input id="answer_question" readonly="readonly" name="answer_question"  type="text" class="form-control" minlength="2" required>
                                    <span style="color:red;" id="error_class_people"></span>
                                </div>
                            </div>
                            <div class="form-group" >
                                <label class="col-sm-3 control-label">备忘录：</label>
                                <div class="col-sm-8" >
                                    <textarea  id="evaluate_info"  name="evaluate_info" minlength="4" class="form-control" required></textarea>
                                </div>
                            </div>      
                           
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary addBtn" type="button">提交</button>
                                </div>
                            </div>
                            <input type="hidden" id="answer_id" name="evaluate_answer_id" value="">
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
    <script src="resource/admin/js/content.js?v=1.0.0"></script>

    <!-- jQuery Validation plugin javascript-->

   <script src="resource/admin/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="resource/admin/js/plugins/validate/messages_zh.min.js"></script>
    <script src="resource/admin/js/demo/form-validate-demo.js"></script>
         <script type="text/javascript" src="resource/answer/evaluate.js"></script>
    <script type="text/javascript">
    evaluate.addStudentName();
    evaluate.insert();
                </script> 
    


</body>

</html>