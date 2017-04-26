<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="servlets.Login_1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML class="main_html">
	<HEAD>
		<title>正方教务管理系统</title>
<?xml version="1.0" encoding="utf-8" ?>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Content-Language" content="utf-8">
		<meta content="all" name="robots">
		<meta name="author" content="作者信息">
		<meta name="Copyright" content="版权信息">
		<meta name="description" content="站点介绍">
		<meta name="keywords" content="站点关键词">
		<link rel="icon" href="style/base/favicon.ico" type="image/x-icon">
			<link rel="shortcut icon" href="style/base/favicon.ico" type="image/x-icon">
				<link rel="stylesheet" href="style/base/jw.css" type="text/css" media="all">
					<link rel="stylesheet" href="style/standard/jw.css" type="text/css" media="all">
						
							<script language="javascript" src="style/js/iframeautoheight.js"></script>
							<!--[if IE 6]> 
<script src="style/js/ie6comm.js"></script> 
<script> 
DD_belatedPNG.fix('img'); 
</script> 
<![endif]-->
							<script src="js/xtwh.js" language="javascript"></script>
							<script type="text/javascript">
// initialise plugins
			var a=b=c='';
			function GetMc(text)
			{
			document.getElementById('dqwz').innerText=text;
			var url=window.frames["zhuti"].location.href;
			var p=url.substring(url.lastIndexOf('/')+1,url.lastIndexOf('aspx')+4);
			a=c;
			c=p;
			if(b!=text)
			{
				if(a!=p)
				{
				document.getElementById('lj').innerText=b;
				}
				b=text;
			}
			}
							</script>

	</HEAD>
	<BODY class="mainbody">
		<div id="bodyDiv">
			<div id="headDiv">
				<!--顶部-->
				<div class="head">
					<!--学校图标及皮肤说明图标-->
					<div class="logo">
						<h2><img src="logo/logo_school.png"></h2>
						<h3><img src="logo/logo_jw.png"></h3>
					</div>
					<!--学校图标及皮肤说明图标-->
					<!--登录信息及工具-->
					<form name="Form1" method="post" action="Xs_main.jsp" id="Form1">
<input type="hidden" name="__EVENTTARGET" value="" />
<input type="hidden" name="__EVENTARGUMENT" value="" />
<input type="hidden" name="__VIEWSTATE" value="dDwxMjg4MjkxNjE4Ozs+uPg7yesh5cqrjY63SEmOwJp4rrk=" />

<input type="hidden" name="__VIEWSTATEGENERATOR" value="9D5B7189" />

<script language="javascript" type="text/javascript">
<!--
	function __doPostBack(eventTarget, eventArgument) {
		var theform;
		if (window.navigator.appName.toLowerCase().indexOf("microsoft") > -1) {
			theform = document.Form1;
		}
		else {
			theform = document.forms["Form1"];
		}
		theform.__EVENTTARGET.value = eventTarget.split("$").join(":");
		theform.__EVENTARGUMENT.value = eventArgument;
		theform.submit();
	}
// -->
</script>

					 
                           
						<div class="info">
							<ul>
								<li>
									<span id="Label3">欢迎您：</span>
									<em>
										<span id="xhxm"><%  
												response.setCharacterEncoding("utf-8"); 
										
										String name=request.getAttribute("name").toString();
										out.println(name); %>同学</span></em>
									
								<li>
									<a id="likTc" href="javascript:__doPostBack('likTc','')">退出</a>
								</li>
							</ul>
					 
						</div>
						
					<script language='javascript' defer>var rt=window.showModalDialog('mmxg_yxsjtx.aspx?js=学生',window,'dialogWidth=500px;dialogHeight=150px;scrollbars=no;resizable=no');</script>

</form>
					<!--登录信息及工具-->
				</div>
				<!--顶部-->
				<!--导航-->
				 <ul class='nav'>
				 <li class='top'>
				   <a class='top_link' href="fill.jsp"><span class=''>返回首页</span></a>
				 </li>
				 <li class='top'>
				 <a href='#' class='top_link'><span class='down'> 活动报名</span>
				 <!--[if gte IE 7]><!-->
				 </a><!--<![endif]--><!--[if lte IE 6]><table><tr><td><![endif]--><ul class='sub'><!--[if lte IE 6]><iframe class='navbug'></iframe><![endif]-->
				 <li><a href="" target='zhuti' onclick="GetMc('实习选课报名');">实习选课报名</a>
				 </li>
				 <li><a href="" target='zhuti' onclick="GetMc('SRTP');">SRTP</a></li>
				 <li><a href="" target='zhuti' onclick="GetMc('学科竞赛');">学科竞赛</a></li>
				 <li><a href="" target='zhuti' onclick="GetMc('网上报名');">网上报名</a>
				 </li><li><a href="" target='zhuti' onclick="GetMc('网上投票');">网上投票</a>
				 </li></ul><!--[if lte IE 6]></td></tr></table></a><![endif]--></li> 
				  <li class='top'><a href='#a' class='top_link'><span class='down'> 教学质量评价</span>
				  <!--[if gte IE 7]><!--></a><!--<![endif]--><!--[if lte IE 6]><table><tr><td><![endif]-->
				  <ul class='sub'><!--[if lte IE 6]><iframe class='navbug'></iframe><![endif]--></ul>
				  <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>  
				  <li class='top'><a href='#a' class='top_link'><span class='down'> 信息维护</span>
				  <!--[if gte IE 7]><!--></a><!--<![endif]--><!--[if lte IE 6]><table><tr><td><![endif]-->
				  <ul class='sub'><!--[if lte IE 6]><iframe class='navbug'></iframe><![endif]--><li>
				  <a href="" target='zhuti' onclick="GetMc('个人信息');">个人信息</a></li>
				  <li><a href="" target='zhuti' onclick="GetMc('密码修改');">密码修改</a><li>
				  <a href="" target='zhuti' onclick="GetMc('转专业申请');">转专业申请</a></li>
				  <li><a href="" target='zhuti' onclick="GetMc('教室借用');">教室借用</a></li>
				  </ul><!--[if lte IE 6]></td></tr></table></a><![endif]--></li>  <li class='top'>
				  <a href='#a' class='top_link'><span class='down'> 信息查询</span><!--[if gte IE 7]><!--></a>
				  <!--<![endif]--><!--[if lte IE 6]><table><tr><td><![endif]--><ul class='sub'>
				  <!--[if lte IE 6]><iframe class='navbug'></iframe><![endif]--><li>
				  <a href="kb.jsp" target='zhuti' onclick="GetMc('学生个人课表');">学生个人课表</a></li><li>
				  <a href="" target='zhuti' onclick="GetMc('学生考试查询');">学生考试查询</a></li>
				  <li><a href="cj.jsp" target='zhuti' onclick="GetMc('成绩查询');">成绩查询</a></li>
				  <li><a href="" target='zhuti' onclick="GetMc('等级考试查询');">等级考试查询</a></li>
				  <li><a href="" target='zhuti' onclick="GetMc('培养计划');">培养计划</a></li><li>
				  <a href="" target='zhuti' onclick="GetMc('教室查询');">教室查询</a></li><li>
				  <a href="" target='zhuti' onclick="GetMc('课程介绍查询');">课程介绍查询</a></li>
				  <li><a href="" target='zhuti' onclick="GetMc('学生选课情况查询');">学生选课情况查询</a></li>
				  <li><a href="" target='zhuti' onclick="GetMc('学生选课费查询');">学生选课费查询</a></li><
				  /ul><!--[if lte IE 6]></td></tr></table></a><![endif]--></li>  <li class='top'>
				  <a href='#a' class='top_link'><span class='down'> 公用信息</span><!--[if gte IE 7]>
				  <!--></a><!--<![endif]--><!--[if lte IE 6]><table><tr><td><![endif]--><ul class='sub'>
				  <!--[if lte IE 6]><iframe class='navbug'></iframe><![endif]--></ul><!--[if lte IE 6]></td></tr></table></a><![endif]--></li></ul>
				<!--选项卡-->
				<div class="tab">
					<ul style="DISPLAY:none">
						<li>
						</li>
					</ul>
					<p class="location">
						<em>当前位置 --
							<span id="dqwz">通知公告</span><span id="lj" style="DISPLAY:none"></span>
						</em>
						<span id="xsrs"><font color="Red"></font></span>
					</p>
				</div>
				<!--选项卡-->
				<!--导航-->
			</div>
			<div id="mainDiv">
				<div id="leftDiv">
				</div>
				<div id="rightDiv">
					<div>
						<iframe id="iframeautoheight" class="rightcontiframe" name="zhuti" allowtransparency src="content.jsp"
							scrolling="no" frameborder="0" marginwidth="0" marginheight="0" onload="javascript:dyniframesize('iframeautoheight');"></iframe>
					</div>
				</div>
			</div>
			<div id="footerDiv">
			<input name="hidNJ" id="hidNJ" type="hidden" /><input name="hidXY" id="hidXY" type="hidden" />
			<input name="hidZYDM" id="hidZYDM" type="hidden" />
				<!--底部-->
				<div class="footer">
					<span>&copy;1999-2012 <a href="http://www.zfsoft.com" target="_blank">正方软件股份有限公司</a>
                    <span>版权所有</span>&nbsp;&nbsp;联系电话：0571-89902828</span>
				</div>
				<input id="txtTimeStamp" style="DISPLAY:none">
				
				<!--底部-->
			</div>
		</div>
			

		
		
	
	</BODY>
</HTML>
