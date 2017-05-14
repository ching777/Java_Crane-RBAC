var student={
    add:function(){
        $("#studnetAdd").on("click",function(){
            top.layer.open({
                  title:"新增学生",
                  type: 2,
                  area: ['700px', '730px'],
                  fixed: false, //不固定
                  content: 'answer/student/studentAdd'
            });
        })
    },
    insert:function(){
        $("#studentAddFrom").validate();
        $(".addBtn").on("click",function(){
            var student_flag = true;
            var student_number = $("#student_number").val().trim();
            if(student_flag){
                $.ajax({
                    cache: false,
                    type: "POST",
                    url:"answer/student/checkStudentNumber",
                    data:{student_number:student_number},
                    async: false,
                    success: function(data) {
                        if(data.flag=='error'){
                            $("#error_student_number").html(data.message);
                            student_flag = false;
                        }else{
                            $("#error_student_number").empty();
                        }
                        }
                     });
            }
             if(student_flag){
                $("#studentAddFrom").submit();
             }
        })
    },
    upda:function(){
        $(".updateBtn").on("click",function(){
            var student_id = $(this).attr("mark-id");
            top.layer.open({
                  title:"修改学生",
                  type: 2,
                  area: ['700px', '630px'],
                  fixed: false, //不固定
                  content: 'answer/student/studentUpdate/'+student_id
            });
        })
        
    },
    edit:function(){
        $("#studentFrom").validate();
        $(".updateBtn").on("click",function(){
            $("#studentFrom").submit();
        })
    }
}