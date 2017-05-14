var work={
    add:function(){
         $(".add").on("click",function(){
            top.layer.open({
                  title:"添加优秀作品",
                  type: 2,
                  area: ['700px', '730px'],
                  fixed: false, //不固定
                  content: 'answer/work/workAdd'
            });
        })
    },
    studentChange:function(){
    $("#class_name").on("change",function(){
        var class_name = $(this).val();
        $.post("answer/work/studentChange",{class_name:class_name},function(data){
            $("#student_name").find("option:not(option:first)").remove();
            $.each(data.student,function(){
                $("#works_answer_id").val(this.answer_id);
                $("#student_name").append("<option value='"+this.student_id+"'>"+this.student_name+"</option>")
                $("#answer_question").val(this.answer_question);
            })
        })
    })
    },
    insert:function(){
        $("#addBtn").on("click",function(){
               $("#datasForm").validate();
              $("#datasForm").submit()
        })
    },
    upda:function(){
        $(".updateBtn").on("click",function(){
            var works_id = $(this).attr("work-id")
             top.layer.open({
                  title:"添加优秀作品",
                  type: 2,
                  area: ['700px', '730px'],
                  fixed: false, //不固定
                  content: 'answer/work/workUpdate/'+works_id
            });
        })
    },
    edit:function(){
        $("#updateBtn").on("click",function(){
            $("#datasForm").submit();
        })
    },
    offStage:function(){
        $(".offStage").on("click",function(){
            layer.alert("该作品处于禁用状态,不提供下载");    
        })
    },
    del:function(){
        $(".delBtn").on("click",function(){
        
        var works_id = $(this).attr("work-id")
          layer.confirm('确定<span style="color:red;"> 删除 </span>该作品?', {icon: 3, title:'删除'}, function(index){
              $.post("answer/works/worksDel",{works_id:works_id,_method:"put"},function(data){
                if(data.flag=="success"){
                    layer.alert('该作品已成功删除', {icon: 1});
                    setTimeout(function(){location.reload()},1500);
                    }else{
                        layer.alert(data.message, {icon: 2});
                    }
             layer.close(index);
        });  
        })
        })
    }
}
