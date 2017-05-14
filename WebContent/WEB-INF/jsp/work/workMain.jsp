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
                            <form action="answer/work/main" method="get" id="searchForm">
                                                                     学生姓名
                                <input name="query['student_name']" value="${pager.query.student_name }">
                                                                      答辩题目
                                <input name="query['answer_question']" value="${pager.query.answer_question }">
                                </select>
                                <button class="btn btn-success btn-outline btn-xs">查询</button>
                                <div class="ibox-tools">
                                     <a href="javascript:;" class="btn btn-success btn-outline btn-xs add" >添加优秀作品</a>
                                </div>
                            </form>
                         </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th class="col-sm-1">序号</th>
                                    <th class="col-sm-1">答辩题目</th>
                                    <th class="col-sm-1">学生姓名</th>
                                    <th class="col-sm-1">源码</th>
                                    <th class="col-sm-1">数据库文件</th>
                                    <th class="col-sm-1">视频文件</th>
                                    <th class="col-sm-1">状态</th>
                                    <th class="col-sm-2">操作</th>
                                </tr>
                            </thead>
                            <tbody>
                              <c:forEach  items="${pager.datas }"  var="list" varStatus="vs">
                              <c:if test="${list.works_states eq '1' }">
                                    <tr>
                                        <td>${vs.count }</td>
                                      
                                        <td>
                                            <c:out value="${list.student_name }"/>
                                        </td>
                                        <td>
                                            <c:out value="${list.answer_question }"/>
                                        </td>
                                        <td>
                                            <a href="attr/code/${list.works_code_update }"  class="codeBtn">源码文件</a>
                                        </td>
                                        <td>
                                           <a href="attr/sql/${list.works_js_data }" class="jsBtn">脚本文件</a>
                                        </td>
                                        <td>
                                            <c:if test="${ !empty list.works_video }"><a href="attr/video/${list.works_video }" class="jsBtn">视频文件</a></c:if>
                                            <c:if test="${ empty list.works_video }"><a href="javascript:;" class="jsBtn">无文件</a></c:if>
                                        </td>
                                        <td>
                                            <span style="color:green;">可用</span>
                                        
                                        </td>
                                        <td>
                                            <a href="javascript:;" class="btn btn-outline btn-primary btn-xs updateBtn" work-id="${list.works_id }">更新</a>
                                            <a href="javascript:;" class="btn btn-outline btn-danger btn-xs delBtn"  work-id="${list.works_id }" >删除</a>
                                        </td>
                                    </tr>
                                  </c:if>
                                  <c:if test="${list.works_states eq '-1' }">
                                    <tr>
                                        <td>${vs.count }</td>
                                      
                                        <td>
                                            <c:out value="${list.student_name }"/>
                                        </td>
                                        <td>
                                            <c:out value="${list.answer_question }"/>
                                        </td>
                                        <td>
                                            <a href="javascript:;"  class="offStage">源码文件</a>
                                        </td>
                                        <td>
                                           <a href="javascript:;" class="offStage">脚本文件</a>
                                        </td>
                                        <td>
                                            <c:if test="${ !empty list.works_video }"><a  href="javascript:;" class="offStage">视频文件</a></c:if>
                                            <c:if test="${ empty list.works_video }"><a href="javascript:;" class="jsBtn">无文件</a></c:if>
                                        </td>
                                        <td>
                                            <span style="color:red;">禁用</span>
                                        
                                        </td>
                                        <td>
                                            <a href="javascript:;" class="btn btn-outline btn-primary btn-xs updateBtn" work-id="${list.works_id }">更新</a>
                                            <a href="javascript:;" class="btn btn-outline btn-danger btn-xs delBtn"  work-id="${list.works_id }" >删除</a>
                                        </td>
                                    </tr>
                                  </c:if>
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
    <script type="text/javascript" src="resource/answer/work.js"></script>
    <script type="text/javascript">
    work.add();
    work.upda();
    work.offStage();
    work.del();
    </script>
</body>
</html>