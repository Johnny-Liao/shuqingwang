<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>书磬图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script src="../js/jquery-1.4.3.js"></script>
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="../images/pic_myshopping.gif" />

		</div>
			  <s:if test="!items.isEmpty()">
			     <div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
					   <!-- 购物列表开始 -->
					   <table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">书磬价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">
							&nbsp;
						</td>
				
					</tr>
					  <s:iterator value="items">
					   <s:if test="buy==true">
					      <tr class='td_no_bord'>
							<td style='display: none'>
								9317290
							</td>
							<td class="buy_td_6">
								<span class="objhide"><img /> </span>
							</td>
							<td>
								<a href="#">${product.productName}</a>
							</td>
							<td class="buy_td_5">
								<span class="c_gray">￥${product.fixedPrice}</span>
							</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span>￥${product.dangPrice}</span>
							</td>
							<td class="buy_td_1">
								&nbsp;&nbsp;${qty}
							</td>

							<td >
								<input class="del_num" id="${product.id}" name="modify_number" type="text" size="3" maxlength="4"/>
								<a onclick="changeQuantity(${product.id});" >变更</a>		<!-- class="${product.id}" -->		
								<script>
								function changeQuantity(id){
							  		//var id = ${product.id};		//内部获取的数据已经为循环的最后一位数了。
								    var qty = document.getElementById(id).value;
								    //alert(id);
								   // alert(qty);
								    var b = window.confirm("确认更改数量为" + qty);
								    if (b) {
							    		window.location="${pageContext.request.contextPath }/cart/modify?pid="+id+"&qty="+qty;
								    }
							  	}
								</script>
								
								<script>
								   $(function(){
								    $('.${product.id}').click(function(){
								       var id = ${product.id};
								       var qty = $('#${product.id}').val();
								       $.post(
								         'modfiy',
								         {'pid':id,'qty':qty},
								         function(date){
								           if(date.error==null){
								             location='cart_list';
								           }else{
								             alert(date.error);
								           }  
								         }
								       );
								    });
								   });
								</script>
							</td>
							<td>
								<a href="cart_delete?pid=${product.id}">删除</a>
							</td>
						</tr>
					   </s:if>
					    
					</s:iterator>
					<!-- 购物列表结束 -->
					</table>
				<div class="choice_balance">
					<div class="select_merch">
						<a href='../main/main.jsp'> 继续挑选商品>></a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy">${save}</span>
							</span>
							<span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>
								) </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'>${total}</span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='#' > 
								<img src="../images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 用户删除恢复区 -->


		<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			<table class=tabl_del id=del_table>
				<tbody>
                 <s:iterator value="items">
                 <s:if test="buy==false">
					<tr>
						<td width="58" class=buy_td_6>
							&nbsp;
						</td>
						<td width="365" class=t2>
							<a href="#">${product.productName}</a>
						</td>
						<td width="106" class=buy_td_5>
							￥${product.fixedPrice}
						</td>
						<td width="134" class=buy_td_4>
							<span>￥${product.dangPrice}</span>
						</td>
						<td width="56" class=buy_td_1>
							<a href="recovery?id=${product.id}">恢复</a>
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>
					</s:if>
				</s:iterator>
					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
		</div>
			  </s:if>
			  <s:else>
			  <script>
			     setTimeout('window.location="../main/main.jsp"',3000)    
			  </script>
			    <p>
			      您还没有选购商品，请
						<a href='../main/main.jsp'> 挑选商品>></a>
			    </p>
			  </s:else>
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



