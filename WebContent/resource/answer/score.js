var score = {
    classNameChange:function(){
        $("#class_name").on("change",function(){
            var class_name =  $(this).val();
            $("#answer_question").empty();
            $.post('answer/score/getAnswerQuestion',{class_name:class_name},function(data){
                $.each(data.pageSelect,function(){
                    $("#answer_question").append("<option value='"+this.answer_question+"'>"+this.answer_question+"</option>");
                })
            })
        })
        
    },
     add:function(){
        $(".add").on("click",function(){
            top.layer.open({
                  title:"添加成绩",
                  type: 2,
                  area: ['700px', '730px'],
                  fixed: false, //不固定
                  content: 'answer/score/scoreAdd'
            });
        })
     }  ,
     classNameChange2:function(){
          $("#class_name").on("change",function(){
                var class_name =  $(this).val();
                $.post('answer/score/getStudent',{class_name:class_name},function(data){
                     $("#student_name").find("option:not(option:first)").remove();
                    $.each(data.student_name,function(){
                        $("#score_answer_id").val(this.answer_id);
                        $("#student_name").append("<option value='"+this.student_id+"'>"+this.student_name+"</option>");
                    })
                })
            })
     },
     insert:function(){
        $(".addBtn").on("click",function(){
            $("#datasForm").validate();
            $("#datasForm").submit()
        })
     },
     upda:function(){
        $(".updateBtn").on("click",function(){
            var score_id = $(this).attr("score-id");
            top.layer.open({
                  title:"修改成绩",
                  type: 2,
                  area: ['700px', '730px'],
                  fixed: false, //不固定
                  content: 'answer/score/scoreUpdate/'+score_id
            });
            
        })
     },
     edit:function(){
        $(".editBtn").on('click',function(){
             $("#datasForm").validate();
            $("#datasForm").submit();
        })
     }
}