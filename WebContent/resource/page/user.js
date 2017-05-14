var user_js = {
    add:function(){
        $("#add").on("click",function(){
         top.layer.open({
             title:"添加账户",
          type: 2,
          area: ['700px', '530px'],
          fixed: false, //不固定
          content: 'sys/user/getAddJsp'
        });
        })
    },
    userDetailUpdate:function(){
        $("#userDetail").on("click",function(){
         top.layer.open({
             title:"修改个人资料",
          type: 2,
          area: ['700px', '530px'],
          fixed: false, //不固定
          content: 'sys/user/userDetailUpdate'
        });
        })
    },
    insert:function(){
    $(".addBtn").on("click",function(){
        var flag = true;
        var account = $("#account").val().trim();
        var password = $("#password").val().trim();
        var confirm_password = $("#confirm_password").val().trim();
        if(account==''){
            $("#account_error").html("请输入账号");
            flag = false;
        }else{
             $("#account_error").empty();
        }
        if(password==''){
            $("#password_error").html("请输入密码");
            flag = false;
        }else{
            $("#password_error").empty();
        }
        if(flag){
             $.ajax({
                cache: false,
                type: "POST",
                url:"sys/user/checkAccount",
                data:{account:account},
                async: false,
                success: function(data) {
                    if(data.flag=='error'){
                         $("#account_error").html(data.message);
                    flag = false; 
                    }else{
                       $("#account_error").empty();
                    }
                    }
                 });
        }
        if(confirm_password!=password){
             flag = false;
             $("#confirm_password_error").html("密码不一致,请重新输入")
        }else{
             $("#confirm_password_error").empty();
         }
        if(flag){
            $("#userForm").submit();
        }
    })
    },
    update:function(){
        $(".updateBtn").on("click",function(){
            var user_id = $(this).attr("user-id");
             top.layer.open({
                 title:"修改账户",
              type: 2,
              area: ['700px', '530px'],
              fixed: false, //不固定
              content: 'sys/user/update/'+user_id
        });     
            
        })
    },
    edit:function(){
        $("#updateBtn").on("click",function(){
             var email = $("#email").val().trim();
             var tel = $("#tel").val().trim();
             var old_tel = $("#old_tel").val();
             var old_email = $("#old_email").val();
             var checkEmail = /\w+[@]{1}\w+[.]\w+/;
             var checkTel = /^1[34578]\d{9}$/; 
             var flag = true;
             if(old_tel!=tel){
                   if(tel!=''&&!checkTel.test(tel)){
                        $("#tel_error").html("电话格式不正确,请检查");
                        flag = false;
                     }else{
                            $.ajax({
                            cache: false,
                            type: "POST",
                            url:"sys/user/checkUpdateUser",
                            data:{tel:tel},
                            async: false,
                            success: function(data) {
                              if(data.flagTel=="error"){
                                $("#tel_error").html(data.message);
                                flag = false;
                            }else{
                                $("#tel_error").empty()
                            }
                            }
                        });
                     }
             }
             if(old_email!=email){
                  if(email!=''&&!checkEmail.test(email)){
                        $("#email_error").html("邮箱格式不正确,请检查");
                        flag = false;
                     }else{
                         $.ajax({
                                cache: false,
                                type: "POST",
                                url:"sys/user/checkUpdateUser",
                                data:{email:email},
                                async: false,
                                success: function(data) {
                                   if(data.flagEmail=="error"){
                                       $("#email_error").html(data.messageEmail);
                                       flag = false;
                                    }else{
                                       $("#email_error").empty();
                                     } 
                                   }
                            });
                     }
             }
            if(flag){
                $("#userForm").submit()
            } 
        })
    },
    remove:function(){
        $(".deleteBtn").on("click",function(){
             var user_id = $(this).attr("user-id");
             var fk_user_detail_id = $(this).attr("detail-id");
            layer.confirm('您确定要<span style="color:red;">删除</span>该用户吗?', {icon: 3, title:'删除'}, function(index){
                $.post("sys/user/delete",{user_id:user_id,fk_user_detail_id:fk_user_detail_id,_method:"delete"},function(data){
                    if(data.flag=="error"){
                          layer.alert(data.message, {icon: 2});
                    }else{
                        setTimeout(function(){location.reload()},1000);
                        layer.alert('删除成功', {icon: 1});
                    }
                layer.close(index);
        });
        });
        })
    }
    
}