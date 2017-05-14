var time = {
    add:function(){
        $(".add").on("click",function(){
             top.layer.open({
                      title:"申请答辩",
                      type: 2,
                      area: ['700px', '730px'],
                      fixed: false, //不固定
                      content: 'answer/time/timeAdd'
                });
        })
    },
    people_number:function(){
        $("#fk_class_id").on("change",function(){
          var answer_people_number = $(this).find("option:selected").attr("count-id");
          $("#answer_people_number").val(answer_people_number);
        })
    },
    insert:function(){
        $("#datasForm").validate();
        $(".addBtn").on("click",function(){
            $("#datasForm").submit();
        })
    },
    upda:function(){
        $(".updateBtn").on("click",function(){
            var answer_stage = $(this).attr("stage-id")
            if(answer_stage=='完毕'){
                layer.alert("该次答辩已经完毕,禁止修改");            
            }else{
            var answer_id = $(this).attr("mark-id");
                top.layer.open({
                          title:"申请答辩",
                          type: 2,
                          area: ['700px', '730px'],
                          fixed: false, //不固定
                          content: 'answer/time/timeUpdate/'+answer_id
                    });
            }
         })
    },
    edit:function(){
         $("#datasForm").validate();
         $(".edit").on("click",function(){
            $("#datasForm").submit();
         })
    },
    stage:function(){
        $(".stageBtn").on("click",function(){
            var answer_id = $(this).attr("mark-id");
                top.layer.open({
                          title:"状态修改",
                          type: 2,
                          area: ['700px', '730px'],
                          fixed: false, //不固定
                          content: 'answer/time/answerStageUpdate/'+answer_id
                    });
         })
        
    },
    stageEdit:function(){
        $(".stag").on("change",function(){
            var stag = $(this).val();
            if(stag=='延期'){
                $("#answer_delay_reason").removeAttr("readonly")
            }else{
                $("#answer_delay_reason").attr("readonly","readonly")
            }
         $(".edit").on("click",function(){
            $("#datasForm").submit();
         })
        })
    }
    
}
