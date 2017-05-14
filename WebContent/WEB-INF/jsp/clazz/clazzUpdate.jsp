<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
                        <form class="form-horizontal m-t" action="answer/clazz/update" id="clazzUpdateForm" method="post">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">班级名称：</label>
                                <div class="col-sm-8">
                                    <input id="class_name" name="class_name"  type="text" value="${clazz.class_name }" class="form-control" minlength="2" required>
                                    <span style="color:red;" id="error_class_name"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3  control-label">开班日期：</label>
                                <div class="col-sm-8">
                                    <input  type="text" readonly="readonly" value="<fmt:formatDate value='${clazz.class_open_time }' pattern='yyyy-MM-dd' />"  class="laydate-icon form-control " required>
                                </div>
                            </div>
                           <div class="form-group">
                            <label class="col-sm-3 control-label">班级性质</label>
                                <div class="col-sm-8">
                                    <select class="form-control m-b" name="class_property" id="class_property" >
                                        <option value="普通班"
                                             <c:if test="${clazz.class_property eq '普通班'}" >selected="selected"</c:if>
                                             >普通班</option>
                                        <option value="VIP"
                                             <c:if test="${clazz.class_property eq 'VIP'}" >selected="selected"</c:if>
                                             >VIP</option>
                                    </select>
                                <span style="color:red;" id="error_class_property"></span>
                                </div>
                            </div>
                           
                            <div class="form-group">
                                <label class="col-sm-3 control-label">主讲老师：</label>
                                <div class="col-sm-8">
                                    <input id="class_teacher" name="class_teacher" required="true" value="${clazz.class_teacher }" class="form-control" minlength="2" required>
                                    <span style="color:red;" id="error_class_teacher"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary editBtn" type="button">提交</button>
                                </div>
                            </div>
                             <input name="class_id"   type="hidden" value="${clazz.class_id }"  >
                             <input id="old_class_name"   type="hidden" value="${clazz.class_name }"  >
                             <input type="hidden" name="_method" value="put">
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
    <script type="text/javascript" src="resource/answer/clazz/clazz.js"></script>
    <script type="text/javascript">
    clazz.edit();
    </script>


</body>

</html>