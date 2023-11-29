<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title>�û���¼</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #016aa9;
	overflow:hidden;
}
.STYLE1 {
	color: #000000;
	font-size: 12px;
}
.errorMessage{
	font-size: 12px;
	color: white;
	list-style: none;
}
-->
</style>
<script type="text/javascript">
	function onSubmit(){
	document.myform.submit();
	}
</script>
</head>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td>
     <form action="manager!login.action" name="myform">
    <table width="962" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="235" background="images/login_03.gif" align="center"><s:fielderror/></td>
      </tr>
      <tr>
        <td height="53">
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        
          <tr>
            <td width="394" height="53" background="images/login_05.gif">&nbsp;</td>
            <td width="206" background="images/login_06.gif">
           
            <table width="100%" border="0" cellspacing="0" cellpadding="0" height="45px">
              <tr>
                <td width="16%" height="25"><div align="right"><span class="STYLE1">�û�</span></div></td>
                <td width="57%" height="25"><div align="center">
                  <input type="text" name="manager.account" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                </div></td>
                <td width="27%" height="25">&nbsp;</td>
              </tr>
              <tr>
                <td height="25"><div align="right"><span class="STYLE1">����</span></div></td>
                <td height="25"><div align="center">
                  <input type="password" name="manager.password" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                </div></td>
                <td height="25"><div align="left"> 
                <img src="images/dl.gif" width="49" height="18" border="0" onclick="onSubmit()"></div></td>
              </tr>
             
            </table>
           
            </td>
            <td width="362" background="images/login_07.gif"></td>
          </tr>
        </table>
        
        </td>
      </tr>
      <tr>
        <td height="213" background="images/login_08.gif">&nbsp;</td>
      </tr>
    </table>
     </form>
    </td>
  </tr>
</table>
</body>
</html>
