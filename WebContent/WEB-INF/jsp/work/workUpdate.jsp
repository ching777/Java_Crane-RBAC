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
        <title>修改作品</title>
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
                        <form class="form-horizontal m-t" action="answer/work/workUpdate" enctype="multipart/form-data" id="datasForm" method="post">
                          <div class="form-group">
                                <label class="col-sm-3 control-label">学生姓名：</label>
                                <div class="col-sm-8">
                                    <input  value="${works.student_name }" readonly="readonly"  class="form-control" required>
                                </div>
                            </div>
                            
                            <div class="form-group">
                            <label class="col-sm-3 control-label">作品状态</label>
                                <div class="col-sm-8">
                                <select class="form-control m-b" name="works_states" id="fk_role_id">
                                     <option <c:if test="${ works.works_states eq '1' }">selected="selected"</c:if> value="1"> 可用</option>
                                     <option <c:if test="${ works.works_states eq '-1' }">selected="selected"</c:if> value="-1"> 禁用</option>
                                    </select>
                                 </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="col-sm-3 control-label">请选择zip格式的文件</label>
                                  <c:if test="${ !empty works.works_code_update }">
                                      <span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
                                      <span class="glyphicon-class">已存在</span>
                                  </c:if>
                                  <div class="ibox-content">
                                    <input type="file" name="works_code"　 id="works_code" accept="application/x-zip-compressed"  >
                                 </div>
                            </div>
                            
                            
                           <div class="form-group">
                            <label class="col-sm-3 control-label">请选择数据库脚本文件</label>
                                <c:if test="${ !empty works.works_js_data }">
                                      <span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
                                      <span class="glyphicon-class">已存在</span>
                                  </c:if>
                                  <div class="ibox-content">
                                    <input type="file"  name="works_js" id="works_js"   >
                                 </div>
                            </div>
                            
                            <div class="form-group">
                            <label class="col-sm-3 control-label">请选择演示视频</label>
                                    <c:if test="${ !empty works.works_video }">
                                      <span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
                                      <span class="glyphicon-class">已存在</span>
                                  </c:if>
                                  <div class="ibox-content">
                                    <input type="file" name="video" id="video"   >
                                 </div>
                            </div>
                           
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary" id="updateBtn" type="submit">提交</button>
                                </div>
                            </div>
                            <input type="hidden"  value="${works.works_id }" name="works_id" >
                            <input type="hidden"  value="${works.works_code_update }" name="old_code" >
                            <input type="hidden"  value="${works.works_js_data }" name="old_js" >
                            <input type="hidden"  value="${works.works_video }" name="old_video" >
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
    </body>

</html>