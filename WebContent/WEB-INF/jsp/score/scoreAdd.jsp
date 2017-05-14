<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
        <title>添加成绩</title>
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
                        <form class="form-horizontal m-t" action="answer/score/scoreAdd" id="datasForm" method="post">
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">班级名称</label>
                                <div class="col-sm-8">
                                    <select class="form-control m-b" id="class_name" name="class_name"  required>
                                        <option value="">请选择</option>
                                        <c:forEach items="${class_name }" var="datas">
                                        <option value="${ datas.class_name}"><c:out value="${datas.class_name }"></c:out></option>
                                        
                                        </c:forEach>
                                    </select>
                                <span style="color:red;" id="error_class_property"></span>
                                </div>
                            </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学生名称</label>
                                <div class="col-sm-8">
                                    <select class="form-control m-b" id="student_name" name="score_student_id" required>
                                        <option value="">请选择</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">PPT成绩：</label>
                                <div class="col-sm-8">
                                    <input id="score_ppt" name="score_ppt"  type="text" class="form-control"   required>
                                    <span style="color:red;" id="error_class_people"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">表达能力：</label>
                                <div class="col-sm-8">
                                    <input id="score_express" name="score_express"  type="text" class="form-control"   required>
                                    <span style="color:red;" id="error_class_people"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">代码掌握：</label>
                                <div class="col-sm-8">
                                    <input id="score_code" name="score_code"  type="text" class="form-control"   required>
                                    <span style="color:red;" id="error_class_people"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">功能评分：</label>
                                <div class="col-sm-8">
                                    <input id="score_function" name="score_function"  type="text" class="form-control"   required>
                                    <span style="color:red;" id="error_class_people"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">知识掌握：</label>
                                <div class="col-sm-8">
                                    <input id="score_basal" name="score_basal"  type="text" class="form-control"   required>
                                    <span style="color:red;" id="error_class_people"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">健壮性：</label>
                                <div class="col-sm-8">
                                    <input id="score_robust" name="score_robust"  type="text" class="form-control"   required>
                                    <span style="color:red;" id="error_class_people"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">安全性：</label>
                                <div class="col-sm-8">
                                    <input id="score_safe" name="score_safe"  type="text" class="form-control"   required>
                                    <span style="color:red;" id="error_class_people"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">其他：</label>
                                <div class="col-sm-8">
                                    <input id="score_other" name="score_other"  type="text" class="form-control"   required>
                                    <span style="color:red;" id="error_class_people"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">加分项：</label>
                                <div class="col-sm-8">
                                    <input id="score_add" name="score_add"  type="text" class="form-control"   required>
                                    <span style="color:red;" id="error_class_people"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">任课老师评分：</label>
                                <div class="col-sm-8">
                                    <input id="score_student_teacher" name="score_student_teacher"  type="text" class="form-control"   required>
                                    <span style="color:red;" id="error_class_people"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">笔试成绩：</label>
                                <div class="col-sm-8">
                                    <input id="score_oral" name="score_oral" required="true" class="form-control"   required>
                                    <span style="color:red;" id="error_class_teacher"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">总成绩：</label>
                                <div class="col-sm-8">
                                    <input id="score_total" name="score_total" required="true" class="form-control"   required>
                                    <span style="color:red;" id="error_class_teacher"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary addBtn" type="button">提交</button>
                                </div>
                            </div>
                            <input type="hidden" id="score_answer_id" name="score_answer_id" value="">
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
            elem: '#date_input', //id选择器
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });
    </script>
    <script src="resource/admin/js/content.js?v=1.0.0"></script>

    <!-- jQuery Validation plugin javascript-->

   <script src="resource/admin/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="resource/admin/js/plugins/validate/messages_zh.min.js"></script>
    <script src="resource/admin/js/demo/form-validate-demo.js"></script>
    <script type="text/javascript" src="resource/answer/score.js"></script>
    <script type="text/javascript">
    score.insert();
    score.classNameChange2();
    </script>


</body>

</html>