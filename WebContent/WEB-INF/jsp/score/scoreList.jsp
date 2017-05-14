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
                        <h5>成绩列表</h5>
                          <div class="ibox-tools">
                            <form action="answer/score/scoreList" method="get" id="searchForm">
                                                                      班级名称
                                <select id="class_name"  name="query['class_name']">
                                    <option value="">请选择班级</option>
                                    <c:forEach items="${class_name }" var="class_name_datas">
                                        <option <c:if test="${ class_name_datas.class_name eq student.query.class_name}">selected='selected'</c:if> value="${ class_name_datas.class_name }"><c:out value="${ class_name_datas.class_name }"></c:out></option>
                                        <%-- <c:if test="${class_name_datas.class_name eq student.datas.class_name } ">selected='selected'</c:if> --%>
                                    </c:forEach>
                                </select>
                                                                       答辩题目
                                <select  id="answer_question" name="query['answer_question']">
                                    <option value="">请选择题目</option>
                                </select>
                                <button class="btn btn-success btn-outline btn-xs">查询</button>
                                <div class="ibox-tools">
                                     <a href="javascript:;" class="btn btn-success btn-outline btn-xs add" >添加成绩</a>
                                </div>
                            </form>
                         </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th class="col-sm-1">姓名</th>
                                    <th class="col-sm-1">答辩名称</th>
                                    <th class="col-sm-1">PPT成绩</th>
                                    <th class="col-sm-1">表达能力</th>
                                    <th class="col-sm-1">代码掌握</th>
                                    <th class="col-sm-1">功能评分</th>
                                    <th class="col-sm-1">知识掌握</th>
                                    <th class="col-sm-1">健壮性</th>
                                    <th class="col-sm-1">安全性</th>
                                    <th class="col-sm-1">其他</th>
                                    <th class="col-sm-1">加分项</th>
                                    <th class="col-sm-1">任课老师评分</th>
                                    <th class="col-sm-1">笔试成绩</th>
                                    <th class="col-sm-1">总成绩</th>
                                    <th class="col-sm-1">操作</th>
                                </tr>
                            </thead>
                            <tbody>
                              <c:forEach  items="${student.datas }"  var="list" varStatus="vs">
                                    <tr>
                                        <td>${list.student_name }</td>
                                        
                                        <td>${list.answer_question }</td>
                                        <td>
                                            <c:out value="${list.score_ppt }"/>
                                        </td>
                                        <td>
                                            <c:out value="${list.score_express }"/>
                                        </td>
                                        <td>
                                            <c:out value="${list.score_code }"/>
                                        </td>
                                        <td>
                                            <c:out value="${list.score_function }"/>
                                        </td>
                                        <td>
                                            <c:out value="${list.score_basal }"/>
                                        </td>
                                        <td>
                                            <c:out value="${list.score_robust }"/>
                                        </td>
                                        <td>
                                            <c:out value="${list.score_safe }"/>
                                        </td>
                                        <td>
                                            <c:out value="${list.score_other }"/>
                                        </td>
                                        <td>
                                            <c:out value="${list.score_add }"/>
                                        </td>
                                        <td>
                                            <c:out value="${list.score_student_teacher }"/>
                                        </td>
                                        <td>
                                            <c:out value="${list.score_oral }"/>
                                        </td>
                                        <td>
                                            <c:out value="${list.score_total }"/>
                                        </td>
                                        <td>
                                            <a href="javascript:;" class="btn btn-outline btn-primary btn-xs updateBtn" score-id="${list.score_id }">更新</a>
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
    <script type="text/javascript" src="resource/answer/score.js"></script>
    <script type="text/javascript">
    score.classNameChange();
    score.add();
    score.upda();
    </script>
</body>
</html>