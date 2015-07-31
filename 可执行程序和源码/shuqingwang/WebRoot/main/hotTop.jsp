<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<div class="book_c_4">

	<!--热销图书A开始-->
	<s:iterator value="products">
	<div class="second_d_waii">
	
		<div class="img">
			<a href="#" target='_blank'><img
					src="../productImages/${productPic}" border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="#" target="_blank"><s:property value="productName"/></a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥
			<s:property value="fixedPrice"/>
		</div>
		<div class="price">
			书磬价：￥
			<s:property value="dangPrice"/>
		</div>
	
	</div>
	</s:iterator>
	
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>