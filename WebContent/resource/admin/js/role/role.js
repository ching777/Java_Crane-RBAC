var role_js={
    add:function(){
        $(".addbtn").on("click",function(){
            top.layer.open({
                title:"新建角色",
                 type: 2,
                 area: ['400px', '530px'],
                 fixed: false, //不固定
//              maxmin: true,
                content: 'sys/role/add'
        });
        });
    },
    
    resource:function(){
        $(".resourceBtn").on("click",function(){
            var temp = $(this).attr("role-id");    
            top.layer.open({
                title:"角色 | 资源分配",
                 type: 2,
                 area: ['400px', '530px'],
                 fixed: false, //不固定
//              maxmin: true,
                content: 'sys/role/'+temp+'/resource'
        });
            
                
        });
    },
    insert:function(){
        
        $("#addbtn").on("click",function(){
            
        var role_name=$("#role_name").val().trim();
        var role_key = $("#role_key").val().trim();
        if(role_name==""){
            $("#role_name_error").html("请输入角色名称");
             $("#role_name").focus();
            return false;
        }else{
           $("#role_name_error").empty();
        }
        
        if(role_key==""){
            $("#role_key_error").html("请输入主键");
             $("#role_key").focus();
            return false;
        }else{
           $("#role_key_error").empty();
        }
        
        $.post("sys/role/valid",{"role_key":role_key},function(data){
             if(data.flag==="error"){
                $("#role_key_error").html(data.message);
                return false;
             } else{
                $("#roleForm").submit();
             }
        });
        });
    },
    
    updateBtn:function(){
     $(".updateBtn").on("click",function(){
            top.layer.open({
                title:"新建角色",
                 type: 2,
                 area: ['750px', '530px'],
                 fixed: false, //不固定
//              maxmin: true,
                content: 'sys/role/update/'+$(this).attr("role-id")
        });
        });
    },
    edit:function(){
       $("#updateBtn").on("click",function(){
        var old_role_key = $("#old_role_key").val();
        var role_name=$("#role_name").val().trim();
        var role_key = $("#role_key").val().trim();
        if(role_name==""){
            $("#role_name_error").html("请输入角色名称");
             $("#role_name").focus();
            return false;
        }else{
           $("#role_name_error").empty();
        }
        if(role_key==""){
            $("#role_key_error").html("请输入角色名称");
             $("#role_key").focus();
            return false;
        }else{
           $("#role_key_error").empty();
        }
        if(old_role_key===role_key){
            $("#roleForm").submit();
        }else{
         $.post("sys/role/valid",{"role_key":role_key},function(data){
             if(data.flag==="error"){
                return false;
             } else{
                 $("#roleForm").submit();
             }
        });
        }
        });
    },
    del:function(){
        $(".deleteBtn").on("click",function(){
        var role_id=$(this).attr("role-id");
        
        if(role_id<0){
            layer.alert('该角色是系统角色,无法删除!!', {icon: 2});
        }else{
         layer.confirm('您确定要<span style="color:red;">彻底删除</span>该角色吗?', {icon: 3, title:'彻底删除'}, function(index){
        $.post("sys/role/delete",{role_id:role_id,_method:"delete"},function(data){
            if(data.flag==="error"){
                alert(data.message);
                return false;
            }else{
                setTimeout(function(){location.reload()},1000);
                layer.alert('删除成功', {icon: 1});
            }
        layer.close(index);
        });
        });
        }
        });
    }
}