<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--最新上架图书A开始-->
	<s:iterator value="products">
	<div class="second_d_wai">
	
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
			<s:property value="dangprice"/>
		</div>
	
	</div>
	</s:iterator>
	
	<div class="book_c_xy_long"></div>
	<!--最新上架图书A结束-->

</div>
<div class="clear"></div>