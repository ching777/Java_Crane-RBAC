var clazz = {
    
    add:function(){
        $(".add").on("click",function(){
            top.layer.open({
              title:"新建班级",
              type: 2,
              area: ['700px', '530px'],
              fixed: false, //不固定
              content: 'answer/clazz/add'
        });
        })
    },
    seeBtn:function(){
        $(".seeBtn").on("click",function(){
            var class_name = $(this).attr("mark-id");
            window.location.href='answer/student/list/'+class_name;
        })
    },
    insert:function(){
        $("#clazzAddForm").validate();
        $(".addBtn").on("click",function(){
            var clazzFlag = true;
            var class_name = $("#class_name").val().trim();            
            $.ajax({
                cache: false,
                type: "POST",
                url:"answer/clazz/checkClazzName",
                data:{class_name:class_name},
                async: false,
                success: function(data) {
                    if(data.flag=='error'){
                        $("#error_class_name").html(data.message);
                        clazzFlag = false;
                    }else{
                        $("#error_class_name").empty();
                    }
                    }
                 });
            if(clazzFlag){
                $("#clazzAddForm").submit();
            }
        })
    },
    update:function(){
         $(".updateBtn").on("click",function(){
            var clazz_id = $(this).attr("clazz-id");
            top.layer.open({
              title:"维护班级",
              type: 2,
              area: ['700px', '530px'],
              fixed: false, //不固定
              content: 'answer/clazz/update/'+clazz_id
        });
        })
    },
    edit:function(){
        $("#clazzUpdateForm").validate();
        $(".editBtn").on("click",function(){
            var clazzFlag = true;
            var class_name = $("#class_name").val().trim();            
            var old_class_name = $("#old_class_name").val().trim();  
            if(class_name!=old_class_name){
                 $.ajax({
                    cache: false,
                    type: "POST",
                    url:"answer/clazz/checkClazzName",
                    data:{class_name:class_name},
                    async: false,
                    success: function(data) {
                        if(data.flag=='error'){
                            $("#error_class_name").html(data.message);
                            clazzFlag = false;
                        }else{
                            $("#error_class_name").empty();
                        }
                        }
                     });
            }
            if(clazzFlag){
                $("#clazzUpdateForm").submit();
            }
        })
    
    
    },
   stage:function(){
      $(".stageBtn").on("click",function(){
         var clazz_id = $(this).attr("clazz-id");
         var old_clazz_stage = $(this).attr("clazz-stage");
         console.log(old_clazz_stage)
         var clazz_name = $(this).attr("clazz-name");
         if(old_clazz_stage<3){
            clazz_stage = parseInt( old_clazz_stage )+1;
            layer.confirm('<span style="color:red;">第'+old_clazz_stage+'阶段</span>完结,进入下一阶段?', {icon: 3, title:'完结'}, function(index){
              $.post("answer/clazz/stage",{clazz_id:clazz_id,clazz_stage:clazz_stage,_method:"put"},function(data){
                if(data.flag!="error"){
                    layer.alert('该班级进入第'+clazz_stage+'阶段', {icon: 1});
                    setTimeout(function(){location.reload()},1500);
                    }else{
                        layer.alert(data.message, {icon: 2});
                    }
             layer.close(index);
        });
                 });
         }else{
            layer.confirm('<span style="color:red;">'+clazz_name+'</span>班级全部课程完结?', {icon: 3, title:'完结'}, function(index){
                $.post("answer/clazz/stage",{clazz_id:clazz_id,clazz_stage:-1,_method:"put"},function(data){
                if(data.flag!="error"){
                    layer.alert('该班级所有课程已完结', {icon: 1});
                    setTimeout(function(){location.reload()},1500);
                    }else{
                        layer.alert(data.message, {icon: 2});
                    }
             layer.close(index);
        });
                 });
         }
        })
   }
}