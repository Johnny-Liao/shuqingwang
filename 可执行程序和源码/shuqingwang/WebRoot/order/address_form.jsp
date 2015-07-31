<%@page contentType="text/html;charset=utf-8" isELIgnored="false"
pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 书磬网</title>
		<meta content="0" http-equiv="Expires" />
		<meta content="no-cache" http-equiv="Cache-Control" />
		<meta content="no-cache" http-equiv="Pragma" />
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script src="../js/jquery-1.4.3.js"></script>
		<script >
		   
		    var receiveName_flag=false;
		    var fullAddress_flag=false;
		    var postalCode_flag=false;
		    var phone_flag=false;
		    var mobile_flag=false;
		    var flag=false;
		    //(1)检测收件人姓名
		$(function(){
		  $('#receiveName').blur(function(){
		    $('#name\\.info').html("");
		    var receiveName = $('#receiveName').val();
		    //0:判断字符長度
		      var len = 0;
		      for(var i=0;i<receiveName.length;i++){
		        var length = receiveName.charCodeAt(i);
		        if(length>=0&&length<=128){
		           $('#name\\.info').html('收件人姓名不合法');
		           return;
		        }else{
		          len+=2;
		        }
		      }
		    //1:判断用户名是否为空
		    if(receiveName==""){
		     $('#name\\.info').html('收件人姓名不能为空');
		     return;
		    }
		    //2:检测有户名是否合法
		    if(len>=4){
		       receiveName_flag=true;
		  }else{
		       $('#name\\.info').html('收件人姓名不合法');
		  }
		     
		  });
		});
		 //(2)检测收件人地址
		$(function(){
		  $('#fullAddress').blur(function(){
		    $('#address\\.info').html("");
		    var fullAddress = $('#fullAddress').val();
		    //0:判断字符長度
		      var len = 0;
		      for(var i=0;i<fullAddress.length;i++){
		        var length = fullAddress.charCodeAt(i);
		        if(length>=0&&length<=128){
		           $('#address\\.info').html('地址不合法');
		           return;
		        }else{
		          len+=2;
		        }
		      }
		    //1:判断地址是否为空
		    if(fullAddress==""){
		     $('#address\\.info').html('地址不能为空');
		     return;
		    }
		    //2:检测地址是否合法
		    if(len>=24){
		       fullAddress_flag=true;
		  }else{
		       $('#address\\.info').html('地址不合法');
		  }
		     
		  });
		});
		 //(3)检测邮政编码
		$(function(){
		  $('#postalCode').blur(function(){
		    $('#code\\.info').html("");
		    var postalCode = $('#postalCode').val();
		    //1:判断邮政编号是否为空
		    if(postalCode==""){
		     $('#code\\.info').html('邮政编码不能为空');
		     return;
		    }
		    //2:检测邮政编码是否合法
		    var postalCode_reg =/^[0-9]{6}$/;
		    if(postalCode_reg.test(postalCode)){
		       postalCode_flag=true;
		  }else{
		       $('#code\\.info').html('邮政编码不合法');
		  }		     
		  });
		});
		 //(4)检测电话号码
		$(function(){
		  $('#phone').blur(function(){
		    $('#phone\\.info').html("");
		    var phone = $('#phone').val();
		    //1:判断电话号码是否为空
		    if(phone==""){
		     $('#phone\\.info').html('电话号码不能为空');
		     return;
		    }
		    //2:检测电话号码是否合法
		    var phone_reg =/^(0[0-9]{2,3}-?)?([2-9][0-9]{6,7})+(-[0-9]{1,4})?$/;
		    if(phone_reg.test(phone)){
		       phone_flag=true;
		  }else{
		       $('#phone\\.info').html('电话号码不合法');
		  }		     
		  });
		});
		 //(5)检测手机号码
		$(function(){
		  $('#mobile').blur(function(){
		    $('#mobile\\.info').html("");
		    var mobile = $('#mobile').val();
		    //1:判断手机号码是否为空
		    if(mobile==""){
		     $('#mobile\\.info').html('手机号码不能为空');
		     return;
		    }
		    //2:检测手机号码是否合法
		    var mobile_reg =/^(\+86|0086)?\s?13[0-9]\d{8}|15[0-9]\d{8}|18[0-9]\d{8}$/;
		    if(mobile_reg.test(mobile)){
		       mobile_flag=true;
		  }else{
		       $('#mobile\\.info').html('手机号码不合法');
		  }		     
		  });
		});
		//(5)表单验证
        $(function(){
           $('#order_form').submit(function(){
           if(flag){
             $('#btnClientRegister').attr('disabled','disabled');
              return flag;
           }
            flag =  receiveName_flag&&fullAddress_flag&&postalCode_flag&&phone_flag&&mobile_flag; 
             if(!flag){
            	 check();
            	 alert('请完成送货信息');   	 
             }
             return flag;
           });
        
        });
        //检查表单
        function check(){
        	 var receiveName = $('#receiveName').val();
        	 var fullAddress = $('#fullAddress').val();
        	 var postalCode = $('#postalCode').val();
        	 var mobile = $('#mobile').val();
        	 var phone = $('#phone').val();
        	if(receiveName==""){
		     $('#name\\.info').html('收件人姓名不能为空');
		    }
        	 if(fullAddress==""){
		     $('#address\\.info').html('地址不能为空');
		    }
        	if(postalCode==""){
		     $('#code\\.info').html('邮政编码不能为空');
		    }
        	if(phone==""){
		     $('#phone\\.info').html('电话号码不能为空');
		    }
		    if(mobile==""){
		     $('#mobile\\.info').html('手机号码不能为空');
		    }
        }
        //清空提示信息
        function reset(){
          $('#name\\.info').html('');
          $('#address\\.info').html('');
          $('#code\\.info').html('');
           $('#phone\\.info').html('');
           $('#mobile\\.info').html('');
          
        }
        //切换地址
		$(function(){
		   $('#sa').change(function(){
		    
		     var id = $(this).attr('value');
		     if(id==-1){
		        $('#receiveName').attr('value','')
		          $('#fullAddress').attr('value','')
		          $('#postalCode').attr('value','')
		          $('#phone').attr('value','')
		          $('#mobile').attr('value','')
		          
		          $('#receiveName').attr('disabled','');
		          $('#fullAddress').attr('disabled','');
		          $('#postalCode').attr('disabled','');
		          $('#phone').attr('disabled','');
		          $('#mobile').attr('disabled','');
		          
		          flag=false;
		          return;
		     }
		       reset();
		       $.post(
		       'selectAddress',
		       {'id':id},
		       function(date){
		          $('#id').attr('value',date.id);
		          
		          $('#receiveName').attr('value',date.receive_name);
		          
		          $('#fullAddress').attr('value',date.full_address);
		          
		          $('#postalCode').attr('value',date.postal_code);
		          
		          $('#phone').attr('value',date.phone);
		         
		          $('#mobile').attr('value',date.mobile);
		          
		          $('#receiveName').attr('disabled','disabled');
		          $('#fullAddress').attr('disabled','disabled');
		          $('#postalCode').attr('disabled','disabled');
		          $('#phone').attr('disabled','disabled');
		          $('#mobile').attr('disabled','disabled');
		          }
		     );
		     flag=true;
		   });
		});
		</script>

	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：
				<s:select list="allAddress" listKey="id" id="sa"
				    listValue="receive_name" name="address" 
				    headerKey="-1" headerValue="请填写新地址"></s:select>
			</p>
			<form name="ctl00" method="post" action="order_ok" id="order_form">
				<input type="hidden" name="order.id" id="id" />

				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" class="text_input" name="order.receive_name"
								id="receiveName" />
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
								<span id="name.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" name="order.full_address"  class="text_input"
								id="fullAddress" />
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
								<span id="address.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<input type="text" class="text_input" name="order.postal_code"
								id="postalCode" />
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
								<span id="code.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" class="text_input" name="order.phone"
								id="phone" />
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
								<span id="phone.info" style="color: red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							手机
						</td>
						<td>
							<input type="text"  class="text_input" name="order.mobile"
								id="mobile" />
							<div class="text_left" id="mobileValidMsg">
								<p>
									请填写有效的收件人的手机
								</p>
								<span id="mobile.info" style="color: red"></span>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister1" class="button_1" name="submit"
					type="reset" value="取消" />
			
				<input id="btnClientRegister" class="button_1"
					type="submit" value="下一步" onclick="return confirm('确认要购买吗？')"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

