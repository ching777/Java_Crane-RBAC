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
<title>用户信息</title>
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
                            <form action="nav/user/find" method="get" id="searchForm">
                                <input type="hidden" name="pageNow" id="pageNow" value="${pager.pageNow }" readonly="readonly">
                                <input type="hidden" id="totalPages" value="${pager.totalPages }" readonly="readonly">
                                                                       帐号
                                <input name="query['account']" value="${pager.query.account }">
                                                                        性别 <select name="query['sex']">
                                    <option value="">请选择性别</option>
                                    <option value="男" <c:if test="${pager.query.sex eq '男' }">selected='selected'</c:if>>男</option>
                                    <option value="女" <c:if test="${pager.query.sex eq '女' }">selected='selected'</c:if>>女</option>
                                </select>
                                <button class="btn btn-success btn-outline btn-xs">查询</button>
                            </form>
                        </div>
                    </div>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th class="col-sm-1">序号</th>
                                    <th class="col-sm-2">姓名</th>
                                    <th class="col-sm-2">账号</th>
                                    <th class="col-sm-2">角色</th>
                                    <th class="col-sm-2">操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${pager.datas }" var="user" varStatus="vs">
                                    <tr>
                                        <td>${vs.count }</td>
                                        <td>
                                            <c:out value="${user.userDetail.user_name }" escapeXml="false">
                                                <span style="color: red">无名氏</span>
                                            </c:out>
                                        </td>
                                        <td>
                                            <c:out value="${user.account }" />
                                        </td>
                                        <td>
                                            <c:if test="${!empty user.role }">
                                                <c:out value="${user.role.role_name }"></c:out>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <td colspan="5">
                                                                                           当前 ${pager.pageNow } / ${pager.totalPages } 页, 共有 ${pager.totalCount } 条记录
                                         <a href="javascript:;" onclick="toPage('1')">首页</a> 
                                         <a href="javascript:;" onclick="toPage('2')">上页</a> 
                                         <a href="javascript:;" onclick="toPage('3')">下页</a>
                                         <a href="javascript:;" onclick="toPage('4')">尾页</a>
                                    </td>
                                </tr>
                            </tfoot>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 全局js -->
    <script src="resource/admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="resource/admin/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="resource/admin/js/plugins/layer/layer.min.js"></script>
    <script src="resource/admin/js/jquery.min.js?v=2.1.4"></script>
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
								alert( "没有上一页了" );
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
						case "5":
							$( "#pageNow" ).val( 1 );
							break;
						default:
							$( "#pageNow" ).val( 1 );
							break;
						}
						$( "#searchForm" ).submit();
					}
				</script>
</body>
</html>