var evaluate = {
    add:function(){
        $(".add").on("click",function(){
            var student_id = $(this).attr("mark-id");
            top.layer.open({
                  title:"新增备忘录",
                  type: 2,
                  area: ['700px', '630px'],
                  fixed: false, //不固定
                  content: 'answer/evaluate/evaluateAdd'
                  });
        })    
    },
    addStudentName:function(){
        $("#class_name").on("change",function(){
            var class_name = $(this).val();
            $.post("answer/evaluate/getStudentName",{class_name:class_name},function(data){
                $("#student_name").find("option:not(option:first)").remove();
                $.each(data.clazz,function(){
                    $("#answer_id").val(this.answer_id);
                    $("#answer_question").val(this.answer_question);
                    $("#student_name").append("<option value="+this.student_id+">"+this.student_name+"</option>");
                })
            })
        })
    },
    insert:function(){
     $(".addBtn").on("click",function(){
     $("#dataForm").validate();
     $("#dataForm").submit();
     })
    },
    upda:function(){
        $(".updateBtn").on("click",function(){
            var evaluate_id = $(this).attr("mark-id");
            top.layer.open({
                  title:"修改备忘录",
                  type: 2,
                  area: ['700px', '400px'],
                  fixed: false, //不固定
                  content: 'answer/evaluate/evaluateUpdate/'+evaluate_id
                  });   
        })
    },
    del:function(){
        $(".deleteBtn").on("click",function(){
            var evaluate_id = $(this).attr("mark-id");
            var student_name = $(this).attr("student-name");
            
           layer.confirm('确定<span style="color:red;">删除'+student_name+'</span>备忘录?', {icon: 3, title:'删除备忘录'}, function(index){
             layer.close(index);
            top.layer.open({
                  title:"删除备忘录",
                  type: 2,
                  area: ['700px', '400px'],
                  fixed: false, //不固定
                  content: 'answer/evaluate/evaluateDel/'+evaluate_id
                  });   
                 });
            
            
        })
    },
    edit:function(){
        $(".editBtn").on("click",function(){
            $("#dataForm").validate();
            $("#dataForm").submit();
        })
    }
}