function del(){
    var parent_id=$("#old_parent_id").val();
    var resource_id=$("#resource_id").val();
        if(parent_id!=-1){
        top.layer.confirm('您确定要<span style="color:red;">删除</span>该子节点吗?', {icon: 3, title:'删除'}, function(index){
            $.post("sys/resource/del",{resource_id:resource_id,_method:"delete"},function(data){
                if(data.flag=="success"){
                     setTimeout(function(){parent.location.reload()},1000);
                    top.layer.alert('删除成功', {icon: 1});
                }
            })
         });
        }else{
            top.layer.confirm('您确定要<span style="color:red;">删除</span>该父节点吗?', {icon: 3, title:'删除'}, function(index){
                $.post("sys/resource/getParentResource_id",{resource_id:resource_id},function(data){
                    if(data.flag=="error"){
                        top.layer.alert(data.message);
                    }else{
                    $.post("sys/resource/deleteParentNode",{resource_id:resource_id,_method:"delete"},function(data){
                       if(data.flag=="error"){
                         top.layer.alert(data.message);
                       }else{
                       setTimeout(function(){parent.location.reload()},1000);
                       top.layer.alert('删除成功', {icon: 1});
                       }
                    })
                    }
                })
            });
        }
}
////修改节点 
function updateNode(){
    var old_parent_id=$("#old_parent_id").val();
    var parent_id=$("#parent_id").val();
    var resource_id=$("#resource_id").val().trim();
    var resource_name=$("#resource_name").val().trim();
    var old_resource_name=$("#old_resource_name").val();
  
    var uNFlag = true;
    if(resource_name==''){
         $("#resource_name_error").html("请输入节点名称");
         return false;
    }
    if(old_parent_id==-1){
        var icon=$("#icon").val().trim();
        var old_icon=$("#old_icon").val().trim();
        $.post("sys/resource/checkParentName",{resource_id:resource_id,resource_name:resource_name},function(data){
            if(data.flag=="error"){
                 $("#resource_name_error").html(data.message);
                 return false;
            }else if(parent_id != old_parent_id || icon != old_icon ){
                 $("#resourceForm").submit();
            }
        })
    }else{
        var url = $("#url").val().trim();
        var old_url=$("#old_url").val().trim();
         if(resource_name==''){
         $("#resource_name_error").html("请输入节点名称");
         uNFlag =  true;
        }else if(resource_name != old_resource_name || parent_id!=old_parent_id){
                $.ajax({
                cache: false,
                type: "POST",
                url:"sys/resource/checkUrl",
                data:{resource_name:resource_name,parent_id:parent_id},
                async: false,
                success: function(data) {
                    if(data.flag=="error"){
                         $("#resource_name_error").html(data.message);
                        uNFlag = false;
                    }else{
                    $("#resource_name_error").empty();
                    }
                    }
                 });
        }
        if(url!=old_url){
                $.ajax({
                cache: false,
                type: "POST",
                url:"sys/resource/checkUrl",
                data:{url:url},
                async: false,
                success: function(data) {
                    if(data.urlFlag=="error"){
                         $("#url_error").html(data.urlMessage);
                        uNFlag = false;
                    }else{
                    $("#url_error").empty();
                    }
                }
            });
        }
        if(uNFlag){
           $("#resourceForm").submit();
            }
    }
}

function getAddParentJsp(){
    top.layer.open({
                 title:"新增父节点",
              type: 2,
              area: ['700px', '530px'],
              fixed: false, //不固定
              content: 'sys/resource/addParent'
            });
}

function getAddChildJsp(){
    top.layer.open({
                 title:"新增子节点",
              type: 2,
              area: ['700px', '530px'],
              fixed: false, //不固定
              content: 'sys/resource/addChlid'
            });
}


function addChild(){
    var resource_name = $("#resource_name").val().trim();
    var url = $("#url").val().trim();
    var parent_id = $("#parent_id").val().trim();
    var addflag=true;
    if(resource_name==''){
         $("#resource_name_error").html("请输入节点名称");
         addflag = false;
    }
     if(parent_id==-1){
        $("#parent_name_error").html("请选择父节点");
         addflag = false;
    }else{
     $("#parent_name_error").empty();
    }
    if(addflag){
        $.ajax({
                cache: false,
                type: "POST",
                url:"sys/resource/checkUrl",
                data:$('#addChildForm').serialize(),
                async: false,
                success: function(data) {
                    if(data.flag=="error"){
                        $("#resource_name_error").html(data.message);
                        addflag = false;
                    }else{
                    $("#resource_name_error").empty();
                    }
                    if(data.urlFlag=="error"){
                         $("#url_error").html(data.urlMessage);
                        addflag = false;
                    }else{
                    $("#url_error").empty();
                    }
                }
            });
    }
    if(addflag){
   $('#addChildForm').submit();
    }
}





function addParent(){
    var resource_name = $("#resource_name").val().trim();
    if(resource_name!=''){
         $.post("sys/resource/checkParentName",{resource_name:resource_name},function(data){
        if(data.flag=="error"){
             $("#resource_name_error").html(data.message);
            return false;
        }else{
           $("#addParentForm").submit();
        }
    })
    }else{
    $("#resource_name_error").html("请输入父节点名称");
    return false;
    }
}