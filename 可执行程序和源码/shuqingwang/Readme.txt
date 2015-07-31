1、数据库安装说明：
	数据库导入：
         create database shuqing;   //创建库
         use shuqing;      			//进入shuqing库
         set names utf8;    		//设置连接和发送SQL编码
         source 路径/shuqing.sql; 	//导入sql文件
       数据库文件配置：
       jdbc.properties中修改相应项(mysql用户名、密码)
    
2、邮件文件配置：
	请在org.lsh.qing.action.mail.My163Mail.java中修改相应项,不改也可以，内部有预留邮箱。
	(用于发送邮件的163邮箱的用户名、密码。注意:必须163邮箱，接收邮件邮箱随意。)
	接收邮箱时可能被列入垃圾邮件中，请注意查收。
	
3、作为测试用例书籍只添加了前面几条记录，如要测试请使用小说列表下的相应项目测试。

4、主页请访问:项目路径+/main/main.jsp

注：如还有项目安装问题请联系项目组长(廖仕豪 手机：13247081028).

