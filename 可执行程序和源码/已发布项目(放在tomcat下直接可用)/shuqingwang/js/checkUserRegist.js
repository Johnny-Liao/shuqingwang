        var email_flag=false;
		var nickname_flag = false;
		var password_flag = false;
		var verifyCode_flag = false;
		//(1)检测邮箱
		$(function(){
		    //1:判断邮箱是否为空
            $('#txtEmail').blur(function(){
            $('#email\\.info').html('');
               var email = $('#txtEmail').val();
               if(email==""){
                $('#email\\.info').html('邮箱不能为空');
                return;
               }
            //2:判断邮箱格式
            var Email_reg=/^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
            if(!Email_reg.test(email)){
              $('#email\\.info').html('邮箱格式不正确');
              return;
            }
             //3:判断邮箱唯一性
            $.post(
               'checkEmail.action',
               {'email':email},
               function(date){
                 if(date){
                  $('#email\\.info').html('邮箱可以用');
                   email_flag=true;
                 }else{
                   $('#email\\.info').html('邮箱已经被占用');
                    email_flag=false; 
                 }
               }
            );
               
            }); 
		});
		//(2)检测用户名
		$(function(){
		   
		  $('#txtNickName').blur(function(){
		    $('#name\\.info').html("");
		    var nickname = $('#txtNickName').val();
		    //0:判断字符長度
		      var len = 0;
		      for(var i=0;i<nickname.length;i++){
		        var length = nickname.charCodeAt(i);
		        if(length>=0&&length<=128){
		          len+=1;
		        }else{
		          len+=2;
		        }
		      }
		    //1:判断用户名是否为空
		    if(nickname==""){
		     $('#name\\.info').html('用户名不能为空');
		     return;
		    }
		    //2:检测有户名是否合法
		    var nickname_reg =/^[0-9a-zA-Z\S\W]{2,18}$/;
		    if(nickname_reg.test(nickname)&&len>=4){
		       nickname_flag=true;
		  }else{
		       $('#name\\.info').html('用户名不合法');
		  }
		     
		  });
		});
		//(3)检测密码
		$(function(){
		   
		  $('#txtPassword').blur(function(){
		     $('#password\\.info').html('');
		     var password = $('#txtPassword').val();
		     //1:检测密码是否为空
		     if(password==""){
		       $('#password\\.info').html('密码不能为空');
		       return;
		     }
		     //2：检测密码格式是否正确
		     var password_reg = /^[a-zA-Z\d+]{6,20}$/;
		     if(!password_reg.test(password)){
		        $('#password\\.info').html('密码不符合规则');
		        return;
		     } 
		     
		  });
		   $('#txtRepeatPass').blur(function(){
		     $('#password1\\.info').html('');
		     var password = $('#txtPassword').val();
		     var repeatPass = $('#txtRepeatPass').val();
		     //3:检测第二次输入的密码是否于第一次的相等
		     if(repeatPass!=password){
		     $('#password1\\.info').html('两次输入的密码不一样');
		      return;
		     }else{
		       password_flag = true; 
		     }
		  });
		});
		
		//(4)校验验证码
		$(function(){
		   $('#change').click(function(){
		      $('#imgVcode').attr('src','verifyCode?dt='+new Date().getTime());
		   });
		});	
		
	 //检查输入的code是否正确 
    $(function(){
	$("#txtVerifyCode").blur(function(){
		//焦点离开后，发送ajax请求
		$('#number\\.info').html('');
		var verifyCode = $('#txtVerifyCode').val();
		//判断是否为空
		if(verifyCode==""){
		  $('#number\\.info').html('验证码不能为空');
		  return;
		}
		//检测验证码是否正确
		$.post(
		  'checkCode.action',
		  {'verifyCode':verifyCode},
		  function(date){
		    if(date.ok){
		       $('#number\\.info').html('验证码正确');
		       verifyCode_flag = true;
		    }else{
		        $('#number\\.info').html('验证码错误');
		    }
		  }
		);
		
	   });
     });   
        //(5)表单验证
        $(function(){
           $('#regist_form').submit(function(){
             var flag =  email_flag&&nickname_flag&&password_flag&&verifyCode_flag;
             if(!flag){
            	 check();
            	 alert('请完成注册信息');   	 
             }
             return flag;   
           });
        
        });
        function check(){
        	var email = $('#txtEmail').val();
		    var nickname = $('#txtNickName').val();
		    var password = $('#txtPassword').val();
		    var verifyCode = $('#txtVerifyCode').val();
        	if(email==""){
                $('#email\\.info').html('邮箱不能为空');
               }
        	if(nickname==""){
		     $('#name\\.info').html('用户名不能为空');
		    }
        	if(password==""){
		       $('#password\\.info').html('密码不能为空');
		     }
        	if(verifyCode==""){
		       $('#number\\.info').html('验证码不能为空');
		      }
        }
