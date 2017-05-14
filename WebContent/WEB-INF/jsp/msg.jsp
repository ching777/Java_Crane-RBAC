<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <title>H5模版:</title>
    </head>
    <body>
        <script src="resource/admin/js/jquery.min.js?v=2.1.4"></script>
        <script src="resource/admin/js/plugins/layer/layer.min.js"></script>
        <script type="text/javascript">
        var index = parent.layer.getFrameIndex( window.name );
        var flag = '${flag}';
        if(flag!='error'){
        	layer.msg('${message}', {icon: 6}, function(){
                    //通过Jquery操作Iframe
                    var data_id = $( window.parent.document ).find( ".J_menuTab.active" ).attr("data-id" );
                    var target = $( window.parent.document ).find('.J_iframe[data-id="' + data_id + '"]' );
                    target.attr( 'src', data_id );
                parent.layer.close( index );
            }); 
        }else{
        	layer.msg('${message}', {icon: 2}, function(){
                    //通过Jquery操作Iframe
                    var data_id = $( window.parent.document ).find( ".J_menuTab.active" ).attr("data-id" );
                    var target = $( window.parent.document ).find('.J_iframe[data-id="' + data_id + '"]' );
                    target.attr( 'src', data_id );
                parent.layer.close( index );
            }); 
        }
        
        //获取窗口索引
       /*  layer.msg('${message}', {icon: 6}, function(){
            var flag = '${flag}';
            if(flag==="success"){
                //通过Jquery操作Iframe
                var data_id = $( window.parent.document ).find( ".J_menuTab.active" ).attr("data-id" );
                var target = $( window.parent.document ).find('.J_iframe[data-id="' + data_id + '"]' );
                target.attr( 'src', data_id );
            }
            parent.layer.close( index );
        });  */
        </script>
    </body>
</html>