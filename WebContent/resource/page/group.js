var group={
    group_add:function(){
    $("#add").on("click",function(){
        top.layer.open({
             title:"新建组",
          type: 2,
          area: ['700px', '530px'],
          fixed: false, //不固定
          content: 'sys/group/add'
        });
    })
    },
    groupAdd:function(){
        $(".addBtn").on("click",function(){
           var group_name =  $("#group_name").val().trim();
           var groupFlag = true;
           if(group_name==''){
            $("#error_group_name").html("请输入组名称");
            groupFlag = false;
           }else{
            $("#error_group_name").empty();
            $.ajax({
                cache: false,
                type: "POST",
                url:"sys/group/checkGroupName",
                data:{group_name:group_name},
                async: false,
                success: function(data) {
                    if(data.flag=='error'){
                        $("#error_group_name").html(data.message);
                        groupFlag = false;
                    }else{
                        $("#error_group_name").empty();
                    }
                    }
                 });
           }
           if(groupFlag){
            $("#groupAddFrom").submit();
           }
        })
    },
    groupUpdate:function(){
        $(".updateBtn").on("click",function(){
            var group_id = $(this).attr("group-id");
            top.layer.open({
                title:"修改组",
                type: 2,
                area: ['700px', '530px'],
                fixed: false, //不固定
                content: 'sys/group/groupUpdate/'+group_id
            });
        })
    },
    groupEdit:function(){
        $(".editBtn").on("click",function(){
            var editFlag=true;
            var group_name = $("#group_name").val();
            var old_group_name = $("#old_group_name").val();
            var old_market = $("#old_market").val();
            var market = $("#market").val();
            if(group_name==''){
                $("#group_name_error").html("请输入组名称");
                editFlag = false;
            }
            if(group_name!=old_group_name){
                 $.ajax({
                    cache: false,
                    type: "POST",
                    url:"sys/group/checkGroupName",
                    data:{group_name:group_name},
                    async: false,
                    success: function(data) {
                        if(data.flag=='error'){
                            $("#group_name_error").html(data.message);
                            editFlag = false;
                        }else{
                            $("#group_name_error").empty();
                        }
                        }
                     });
            }
            if(editFlag){
                if(group_name!=old_group_name||market!=old_market){
                     $("#groupUpdate").submit();
                }
            }
        })
    },
    deleteGruop:function(){
       $(".delBtn").on("click",function(){
            var group_peopleCount = $(this).attr("group-peopleCount");
            var group_id = $(this).attr("group-id");
            if(group_peopleCount>0){
                layer.alert('该分组下存在'+group_peopleCount+'个用户,禁止删除', {icon: 2});
            }else{
                 layer.confirm('您确定要从当前分组中<span style="color:red;">删除</span>该分组吗?', {icon: 3, title:'删除'}, function(index){
                    $.post("sys/group/deleteGruop",{group_id:group_id,_method:"delete"},function(data){
                        if(data.flag=="success"){
                            layer.alert('该组已删除', {icon: 1});
                            setTimeout(function(){location.reload()},1000);
                            }else{
                                layer.alert(data.message, {icon: 2});
                            }
                     layer.close(index);
        });
        });
            }
        })
    },
    groupSee:function(){
        $(".seeBtn").on("click",function(){
         var group_id = $(this).attr("group-id");
           top.layer.open({
             title:"组名单",
              type: 2,
              area: ['700px', '530px'],
              fixed: false, //不固定
              content: 'sys/group/groupInfo/'+group_id
        });
        })
    },
    removeUser:function(){
        $(".removeUser").on("click",function(){
            var user_id = $(this).attr("user-id");
            layer.confirm('您确定要从当前分组中<span style="color:red;">移除</span>该用户吗?', {icon: 3, title:'删除'}, function(index){
            $.post("sys/group/removeUser",{user_id:user_id,_method:"put"},function(data){
                if(data.flag=="success"){
                    layer.alert('该用户已移除', {icon: 1});
                    setTimeout(function(){location.reload()},1000);
                    }else{
                        layer.alert(data.message, {icon: 2});
                    }
             layer.close(index);
        });
        });
        })
    }
};