var login_js = {
    login:function(){
        $("#loginButton").click(function(){
        if($(":text:eq(0)").val().trim()===''){
            $("#PCss").css("color","red").html("账号不能为空");
            return false;
        }
        
        if($(":password:eq(0)").val().trim()===''){
            $("#PCss").css("color","red").html("密码不能为空");
            return false;
        }
         $("#loginForm").submit();
        });
    },
    loginOut:function(){

    $("[name='loginOut']").on("click",function(){
        layer.confirm('您确定要<span style="color:red;">退出</span>该系统吗?', {icon: 3, title:'提示'}, function(index){
            window.top.location.href="sys/loginOut";
        layer.close(index);
        });
    })
    }
}
