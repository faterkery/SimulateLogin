<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<HTML>
	<HEAD>
		<title>欢迎使用正方教务管理系统！请登录</title>
		<meta http-equiv="X-UA-Compatible" content="IE=7">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<meta http-equiv="Content-Language" content="gb2312">
		<meta content="all" name="robots">
		<meta name="author" content="作者信息">
		<meta name="Copyright" content="版权信息">
		<meta name="description" content="站点介绍">
		<meta name="keywords" content="站点关键词">
		<link rel="icon" href="style/base/favicon.ico" type="image/x-icon">
			<link rel="shortcut icon" href="style/base/favicon.ico" type="image/x-icon">
				<link rel="stylesheet" href="style/base/jw.css" type="text/css" media="all">
					<link rel="stylesheet" href="style/standard/jw.css" type="text/css" media="all">
						<script language="javascript">
				var count=0;
			window.onload = function (){
				var url = window.location.href;
				var parent = window.parent;
				var length = parent.frames.length;
				var win = parent.frames["zhuti"];
				
				if(length > 0 && win != undefined){
					parent.location.href = url;
				}

				document.getElementById("txtUserName").focus();
			}
			function show(me)
			{
				if (count==0)
				{
					me.value="";
				}
			}
			function reloadcode()
			{
				var verify=document.getElementById('icode');
				verify.src=verify.src+'?';
			}
			function keydown(me)
			{
				if (count==0)
				{
					me.value="";
					count=1;
					me.style.color="black";
				}
			}
			function yzblur(me)
			{
				if(me.value=="")
				{
					//me.value="请输入验证码";
					//me.style.color="#92a4bf";
					count=0;
				}
			}

						</script>
						<style>
			.fangshua { COLOR: red; FONT-SIZE: 14px; FONT-WEIGHT: bold }
			.login_right DL { MARGIN: 0px 0px 0px 105px; MIN-HEIGHT: 20px; WIDTH: 285px; _height: 20px }
			</style>
	</HEAD>
	<body class="login_bg">
		<form name="form1" method="post" action="Login_1" id="form1">
<input type="hidden" name="__VIEWSTATE" value="dDwyODE2NTM0OTg7Oz5EGhgau+S2lNRQd/4S/EtGEOfVKw==" />

<input type="hidden" name="__VIEWSTATEGENERATOR" value="92719903" />

			
			<div class="login_main">
				<div class="login_logo"><h2><img src="logo/logo_school.png"></h2>
					<h3><img src="logo/logo_jw.png"></h3>
				</div>
				<div class="login_left"><img class="login_pic" src="logo/login_pic.png"></div>
				<div class="login_right">
					<dl style="MARGIN-TOP:92px">
						<dt class="uesr">
							<label id="lbYhm">用户名：</label>
						</dt>
						<dd>
							<input name="txtUserName" type="text" id="txtUserName" tabindex="1" class="text_nor" />
						</dd>
					</dl>
					<div style="CLEAR:both"></div>
					<dl>
						<dt class="passw">
							<label id="lbMm">密　码：</label>
						</dt>
						<dd>
							<input name="TextBox2" type="password" id="TextBox2" tabindex="2" class="text_nor" />
						</dd>
					</dl>
					<div style="CLEAR:both"></div>
					<dl style="POSITION:relative">
						<dt class="yzm">
							<label id="lbYzm">验证码：</label>
						</dt>
						<dd>
							<!--position:absolute;top:0px;left:68px;Width:64px;height:18px;line-height:18px;padding:1px 2px;-->
							<input name="txtSecretCode" type="text" id="txtSecretCode" tabindex="3" class="text_nor" alt="看不清，换一张" title="看不清，换一张" onfocus="show(this);" onkeydown="keydown(this);" onblur="yzblur(this);" style="PADDING-BOTTOM:1px;LINE-HEIGHT:18px;PADDING-LEFT:2px;PADDING-RIGHT:2px;COLOR:#92a4bf;FONT-SIZE:1px;PADDING-TOP:1px" />
							<img id="icode" src="ShowImg?ASP.NET_SessionId=${loginData.cookie}" onclick="reloadcode();" alt="看不清，换一张" title="看不清，换一张" alt="" border="0" style="POSITION:absolute;TOP:5px;LEFT:128px" />
							<a id="icodems" onclick="reloadcode();" style="POSITION:absolute;LINE-HEIGHT:14px;WORD-WRAP:break-word;COLOR:blue;WORD-BREAK:break-all;TOP:5px;CURSOR:pointer;LEFT:210px">看不清换一张</a>
						</dd>
						<dt></dt>
					</dl>
					<div style="CLEAR:both"></div>
					<dl>
						<dd>
							<table id="RadioButtonList1" border="0">
	<tr>
		<td><input id="RadioButtonList1_0" type="radio" name="RadioButtonList1" value="部门" tabindex="4" /><label for="RadioButtonList1_0">部门</label></td><td><input id="RadioButtonList1_1" type="radio" name="RadioButtonList1" value="教师" tabindex="4" /><label for="RadioButtonList1_1">教师</label></td><td><input id="RadioButtonList1_2" type="radio" name="RadioButtonList1" value="学生" checked="checked" tabindex="4" /><label for="RadioButtonList1_2">学生</label></td><td><input id="RadioButtonList1_3" type="radio" name="RadioButtonList1" value="访客" tabindex="4" /><label for="RadioButtonList1_3">访客</label></td>
	</tr>
</table></dd>
						<dt></dt>
					</dl>
					<div style="CLEAR:both"></div>
					<dl>
						<dd>
							<input type="submit" name="Button1" value="" id="Button1" class="btn_dl" />
							<input type="submit" name="Button2" value="" id="Button2" class="btn_cz" />
							<input name="lbLanguage" type="text" id="lbLanguage" style="DISPLAY: none" />
							<p><br>
								<A style="DISPLAY: none" href="xsxjxtdl.aspx" target="_blank">
									<span id="lbSelect">学生学籍信息查询系统</span></A></p>
						</dd>
					</dl>
				</div>
				<div class="login_copyright">
					<span>&copy;1999-2012  <a href="http://www.zfsoft.com" target="_blank">正方软件股份有限公司</a> <span>版权所有</span>&nbsp;&nbsp;联系电话：0571-89902828</span>
					<input name="hidPdrs" id="hidPdrs" type="hidden" size="5" /><input name="hidsc" id="hidsc" type="hidden" size="5" />
				</div>
			</div>
		</form>
	</body>
</HTML>
