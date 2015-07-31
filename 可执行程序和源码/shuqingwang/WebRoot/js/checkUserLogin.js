$(function(){
		   //判断邮箱是否为空
		    $('#txtUsername').blur(function(){
		       $('#password\\.info').html('');
		       $('#email\\.info').html('');
		       var email = $('#txtUsername').val();
		       if(email==""){
		       $('#email\\.info').html('邮箱不能为空');
		       }
		    });
		  //判断密码是否为空
		     $('#txtPassword').blur(function(){
		       $('#password\\.info').html('');
		       $('#email\\.info').html('');
		       var password = $('#txtPassword').val();
		       if(password==""){
		       $('#password\\.info').html('请输入密码');
		       }
		    });
		  });
