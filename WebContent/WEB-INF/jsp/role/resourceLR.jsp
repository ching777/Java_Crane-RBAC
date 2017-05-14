<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
    //项目的发布路径，例如:  /rabc
			String path = request.getContextPath();
			/*
			全路径，形式如下: http://127.0.0.1:8001/rbac/
			request.getScheme()      ——> http 获取协议
			request.getServerName()  --> 127.0.0.1 获取服务名
			request.getServerPort()  --> 8001 获取端口号
			path                     --> /rbac 获取访问的路径 路
			*/
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<%-- 
	<base/>标签解决路径问题
	参考文章:http://www.cnblogs.com/muqianying/archive/2012/03/16/2400280.html
--%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>jQuery实现列表框双向选择操作-Helloweba演示平台</title>
<style type="text/css">
#main {
    width: 500px;
}

.demo {
    width: 450px;
    margin: 20px auto
}

.select_side {
    float: left;
    width: 200px
}

select {
    width: 200px;
    height: 200px;
    border: 1px solid #404040;
    font-weight: bold
}

.select_opt {
    float: left;
    width: 40px;
    height: 15%;
    padding-top: 80px;
    padding-left: 10px;
}

.select_opt p {
    width: 26px;
    height: 26px;
    margin-top: 6px;
    background: url(resource/admin/img/arr.gif) no-repeat;
    cursor: pointer;
    text-indent: -999em
}

.select_opt p#toright {
    background-position: 2px 0
}

.select_opt p#toleft {
    background-position: 2px -22px
}

.sub_btn {
    clear: both;
    height: 42px;
    line-height: 42px;
    padding-top: 10px;
    text-align: center
}
</style>
<!-- 全局js -->
<script src="resource/admin/js/jquery.min.js?v=2.1.4"></script>
<script type="text/javascript">
	$( function() {
		var leftSel = $( "#selectL" );
		var rightSel = $( "#selectR" );
		$( "#toright" ).bind( "click", function() {
			leftSel.find( "option:selected" ).each( function() {
				$( this ).remove().appendTo( rightSel );
			} );
		} );
		$( "#toleft" ).bind( "click", function() {
			rightSel.find( "option:selected" ).each( function() {
				$( this ).remove().appendTo( leftSel );
			} );
		} );
		leftSel.dblclick( function() {
			$( this ).find( "option:selected" ).each( function() {
				$( this ).remove().appendTo( rightSel );
			} );
		} );
		rightSel.dblclick( function() {
			$( this ).find( "option:selected" ).each( function() {
				$( this ).remove().appendTo( leftSel );
			} );
		} );

	} );
</script>
</head>
<body>
    <form action="sys/role/updata/resource" method="post" id="resourceForm">
        <div id="main">
            <h2 align="center">[<c:out value="${role.role_name }" />]角色资源分配表
            </h2>
            <div class="demo">
                <div class="select_side">
                    <p align="center">待选区</p>
                    <select id="selectL" name="selectL" multiple="multiple">
                        <c:forEach items="${ unSelectResourceList}" var="left">
                            <option value="${left.resource_id }">
                                <c:out value="${left.resource_name }" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="select_opt">
                    <p id="toright" title="添加">&gt;</p>
                    <p id="toleft" title="移除">&lt;</p>
                </div>
                <div class="select_side">
                    <p align="center">已选区</p>
                    <select id="selectR" name="resources" multiple="multiple">
                        <c:forEach items="${selectResourceList}" var="right">
                            <option value="${right.resource_id }">
                                <c:out value="${right.resource_name }" /></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="sub_btn">
                    <input type="button" id="sub" value="确认分配" />
                </div>
            </div>
        </div>
        <!-- 隐藏域 -->
        <input type="hidden" value="${role.role_id }" name="role_id">
        <input type="hidden" value="put" name="_method">
    </form>
    <script type="text/javascript">
					$( "#sub" ).on( "click", function() {
						$( "#selectR option" ).prop( "selected", true );
						$( "#resourceForm" ).submit();
					} )
				</script>
</body>
</html>
