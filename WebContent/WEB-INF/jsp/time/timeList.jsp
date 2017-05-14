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
                        <h5>答辩信息列表</h5>
                        <div class="ibox-tools">
                            <form action="answer/time" method="get" id="searchForm">
                                                                        答辩状态
                                <select name="query['answer_states']">
                                    <option value="通过" <c:if test="${pager.query.answer_states eq '通过' }">selected='selected'</c:if>>待答辩</option>
                                    <option value="申请中" <c:if test="${pager.query.answer_states eq '申请中' }">selected='selected'</c:if>>申请中</option>
                                    <option value="延期" <c:if test="${pager.query.answer_states eq '延期' }">selected='selected'</c:if>>延期</option>
                                    <option value="全部" <c:if test="${pager.query.answer_states eq '全部' }">selected='selected'</c:if>>全部</option>
                                    <option value="完毕" <c:if test="${pager.query.answer_states eq '完毕' }">selected='selected'</c:if>>完毕</option>
                                </select>
                                <button class="btn btn-success btn-outline btn-xs">查询</button>
                                <div class="ibox-tools">
                                     <a href="javascript:;" class="btn btn-success btn-outline btn-xs add" >申请答辩</a>
                                </div>
                            </form>
                         </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th class="col-sm-1">序号</th>
                                    <th class="col-sm-1">班级名称</th>
                                    <th class="col-sm-2">申请日期</th>
                                    <th class="col-sm-1">答辩人数</th>
                                    <th class="col-sm-2">答辩题目</th>
                                    <th class="col-sm-1">评委姓名</th>
                                    <th class="col-sm-1">答辩状态</th>
                                    <th class="col-sm-1">延期原因</th>
                                    <th class="col-sm-1">操作<th>
                                </tr>
                            </thead>
                            <tbody>
                              <c:forEach  items="${timeList.datas }"  var="list" varStatus="vs">
                                    <tr>
                                        <td>${vs.count }</td>
                                        <td>
                                            <c:out value="${list.clazz.class_name }"/>
                                        </td>
                                        <td>
                                            <fmt:formatDate value="${ list.answer_apple_date }" pattern="yyyy-MM-dd" />
                                        </td>
                                        <td>
                                            <c:out value="${list.answer_people_number }"/>
                                        </td>
                                        <td>
                                            <c:out value="${list.answer_question }"/>
                                        </td>
                                        <td>
                                            <c:out value="${list.answer_judge_name }"/>
                                        </td>
                                        <td>
                                            <c:if test="${list.answer_states eq '申请中' }"><c:out value="申请中"/></c:if>
                                            <c:if test="${list.answer_states eq '通过' }"><c:out value="待答辩"/></c:if>
                                            <c:if test="${list.answer_states eq '延期' }"><c:out value="延期"/></c:if>
                                            <c:if test="${list.answer_states eq '完毕' }"><c:out value="完毕"/></c:if>
                                        </td>
                                        <td>
                                            <c:if test="${ !empty list.answer_delay_reason }"><c:out value="${list.answer_delay_reason }"/></c:if>
                                            <c:if test="${ empty list.answer_delay_reason }"><c:out value="未延期"/></c:if>
                                        </td>
                                        <td>
                                            <a href="javascript:;" class="btn btn-outline btn-primary btn-xs updateBtn" stage-id = "${list.answer_states }" mark-id="${list.answer_id }">修改</a>
                                            <a href="javascript:;" class="btn btn-outline btn-danger btn-xs stageBtn " mark-id="${list.answer_id }"  >状态</a>
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
    <script type="text/javascript" src="resource/answer/time.js"></script>
    <script type="text/javascript">
    time.add();
    time.upda();
    time.stage();
    </script>
</body>
</html>