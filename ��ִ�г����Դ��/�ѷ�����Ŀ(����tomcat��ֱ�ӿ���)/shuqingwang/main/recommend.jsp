<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="java.util.*" %>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<div class=second_c_02_b1>
		  <s:iterator value="books">
			<div class=second_c_02_b1_1>
				<a href='#' target='_blank'><img src="../productImages/${productPic}" width=70 border=0 /> </a>
			</div>
			
			<div class=second_c_02_b1_2>
				<h3>
					<a href='#' target='_blank' title='输赢'><s:property value="productName"/></a>
				</h3>
				<h4>
					作者：<s:property value="author"/> 著
					<br />
					出版社：<s:property value="publishing"/>&nbsp;&nbsp;&nbsp;&nbsp;出版时间：
					<s:date name="new java.util.Date(publish_time)" format="yyyy-MM-dd"/>
				</h4>
				<h5>
					<s:property value="description"/>
				</h5>
				<h6>
					定价：￥<s:property value="fixedPrice"/>&nbsp;&nbsp;书磬价：￥<s:property value="dangPrice"/>
				</h6>
				<div class=line_xx></div>
			</div>
			</s:iterator>
		</div>
	</div>
</div>
