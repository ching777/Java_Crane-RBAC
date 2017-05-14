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
                            <form action="answer/student/list" method="get" id="searchForm">
                                <input type="hidden" name="pageNow" id="pageNow" value="${pager.pageNow }" readonly="readonly">
                                <input type="hidden" id="totalPages" value="${pager.totalPages }" readonly="readonly">
                                姓名
                                <input name="query['student_name']" value="${pager.query.student_name }">
                                班级
                                <input name="query['class_name']" value="${pager.query.class_name }">
                                性别 <select name="query['student_sex']">
                                    <option value="">请选择性别</option>
                                    <option value="男" <c:if test="${pager.query.student_sex eq '男' }">selected='selected'</c:if>>男</option>
                                    <option value="女" <c:if test="${pager.query.student_sex eq '女' }">selected='selected'</c:if>>女</option>
                                </select>
                                <button class="btn btn-success btn-outline btn-xs">查询</button>
                                <a href="javascript:;" class="btn btn-success btn-outline btn-xs" id="studnetAdd">新建用户</a>
                            </form>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th class="col-sm-1">序号</th>
                                    <th class="col-sm-1">姓名</th>
                                    <th class="col-sm-1">学生编号</th>
                                    <th class="col-sm-1">学生状态</th>
                                    <th class="col-sm-1">性别</th>
                                    <th class="col-sm-1">所处大学</th>
                                    <th class="col-sm-1">年级</th>
                                    <th class="col-sm-1">专业</th>
                                    <th class="col-sm-1">所学产品</th>
                                    <th class="col-sm-1">规划师姓名</th>
                                    <th class="col-sm-1">所在班级</th>
                                    <th class="col-sm-2">操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${pager.datas }" var="datas" varStatus="vs">
                                    <tr>
                                        <td>${vs.count }</td>
                                        <td>
                                            <c:out value="${datas.student_name }" />
                                        </td>
                                        <td>
                                            <c:out value="${datas.student_number }" />
                                        </td>
                                        <td>
                                            <c:if test="${datas.student_stage eq '1' }"><c:out value="第一阶段"/></c:if>
                                            <c:if test="${datas.student_stage eq '2' }"><c:out value="第二阶段"/></c:if>
                                            <c:if test="${datas.student_stage eq '3' }"><c:out value="第三阶段"/></c:if>
                                            <c:if test="${datas.student_stage eq '-1'}"><c:out value="已结课"/></c:if>
                                        </td>
                                        <td>
                                            <c:out value="${datas.student_sex }" />
                                        </td>
                                        <td>
                                            <c:out value="${datas.student_school }" />
                                        </td>
                                        <td>
                                            <c:out value="${datas.student_grade }" />
                                        </td>
                                        <td>
                                            <c:out value="${datas.student_major }" />
                                        </td>
                                        <td>
                                            <c:out value="${datas.student_product }" />
                                        </td>
                                        <td>
                                            <c:out value="${datas.student_teacher_name }" />
                                        </td>
                                        <td>
                                            <c:out value="${datas.clazz.class_name }" />
                                        </td>
                                        <td>
                                            <a href="javascript:;" class="btn btn-outline btn-primary btn-xs updateBtn" mark-id="${datas.student_id  }">修改</a> 
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <td colspan="5">
                                        <ul class="pagination">
                                            <li class="active">
                                                <a href="javascript:;">当前${pager.pageNow }/${pager.totalPages }页，共有${pager.totalCount }条记录</a>
                                            </li>
                                            <li>
                                                <a href="javascript:;" onclick="toPage('1')">首页</a>
                                            </li>
                                            <li>
                                                <a href="javascript:;" onclick="toPage('2')">上一页</a>
                                            </li>
                                            <li>
                                                <a href="javascript:;" onclick="toPage('3')">下一页</a>
                                            </li>
                                            <li>
                                                <a href="javascript:;" onclick="toPage('4')">尾页</a>
                                            </li>
                                        </ul>
                                    </td>
                                </tr>
                            </tfoot>
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
     <script type="text/javascript" src="resource/answer/student.js"></script>
    <script type="text/javascript">
					student.add();
					student.upda();
				</script> 
    <script type="text/javascript">
					function toPage( type ) {
						var pageNow = $( "#pageNow" ).val();
						var totalPages = $( "#totalPages" ).val();
						switch ( type ) {
						case "1":
							$( "#pageNow" ).val( 1 );
							break;
						case "2":
							if ( pageNow == 1 ) {
								alert( "没有上一页" );
								return false;
							}
							$( "#pageNow" ).val( pageNow - 1 );
							break;
						case "3":
							pageNow = parseInt( pageNow );
							totalPages = parseInt( totalPages )
							if ( pageNow == totalPages ) {
								return false;
							}
							$( "#pageNow" ).val( pageNow + 1 );
							break;
						case "4":
							$( "#pageNow" ).val( totalPages );
							break;
						default:
							$( "#pageNow" ).val( pageNow );
							break;
						}
						//提交表单
						$( "#searchForm" ).submit();
					}
				</script>
</body>
</html>