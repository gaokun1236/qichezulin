<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>
<script type="text/javascript">
	
	
	function addSpchu(shangpinId){
		var spchuZong = document.form1.spchuZong.value;
		if(spchuZong==""){
			document.form1.spchuZong.focus();
			alert("请填写数量");
			return false;
		}
		if (!(/(^[1-9]\d*$)/.test(spchuZong))) {
			document.form1.spchuZong.focus();
			alert("请填写正确数量");
			return false;
		}
		if (yonghuId==0) {
			alert("请登录后租赁");
			return false;
		}
		$.messager.confirm("系统提示","您确认要加入租赁中心吗？",function(r){
			if(r){
				$.post("addSpchu?yonghuId="+yonghuId+"&spchuZong="+spchuZong,{shangpinId:shangpinId},function(result){
					if(result.success){
						$.messager.alert('系统提示','您已成功加入租赁中心，请在会员中心<a target="_blank" style="color:red;" href="yonghuMain.jsp">付款' + '</a>');
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示','<font color=red>'+selectedRows[result.errorIndex].spchuName+'</font>'+result.errorMsg);
					}
				},"json");
			}
		});
	}
	
</script>
<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0" style="margin:10px auto;">
  <tr>
    <td width="240" valign="top" bgcolor="#FFFFFF" style="border:1px solid #e0e0e0;">
	<%@ include file="left.jsp"%>
    </td>
    <td width="10" valign="top">&nbsp;</td>
    <td valign="top">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" class="sort"><a href="index.jsp">首页</a> &gt;&gt; 汽车详情</td>
      </tr>
      <tr>
		<%if(shangpinGetId!=null) {%>
        <td height="" valign="top" bgcolor="#FFFFFF" style="border:1px solid #e0e0e0; padding:10px; line-height:25px;">
        <table width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td valign="top" width="355">
				  <table width="100%" border="0" cellspacing="0" cellpadding="2">
                      <tr>
                        <td><table cellspacing=0 cellpadding=0 width=355 height=180 border=0>
                            <tbody>
                              <tr>
                                <td align=center>
                                <%
																	if (shangpinGetId.getShangpinImg() != null) {
																%> <img
																src="../bqichezulin/<%=shangpinGetId.getShangpinImg()%>"
																height="200" width="200" /> <%
 																} else {
																 %> <img
																src="../bqichezulin/wangzhan/images/cuowu.jpg" width="163" height="163" /> <%
															 	}
																 %>
                                </td>
                              </tr>
                            </tbody>
                        </table></td>
                      </tr>
                  </table></td>
                  <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
										<form name="form1" method="post">
                      <tr>
                        <td height="30" align="left">汽车名称：<font color="#cb1c1d" size="3"><strong><%=shangpinGetId.getShangpinName()%></strong></font></td>
                      </tr>
										<tr>
											<td align="left">&nbsp;品牌：<%=shangpinGetId.getSptypeName()%>
											</td>
										</tr>
										<tr>
											<td align="left">&nbsp;型号：<%=shangpinGetId.getShangpinMark1()%>
											</td>
										</tr>
										<tr>
											<td align="left">&nbsp;上线：<%=DateUtil.formatDate(shangpinGetId.getShangpinDate(),"yyyy-MM-dd") %>
											</td>
										</tr>
										<tr>
											<td align="left">&nbsp;价格：￥<%=shangpinGetId.getShangpinJin()%>元
											</td>
										</tr>
										<tr>
											<td align="left">&nbsp;天数：<input style="height:13px;width:50px;"placeholder="天数" required id="spchuZong" name="spchuZong"/>
											</td>
										</tr>
										<tr>
											<td height="50" align="left"><a
												href="javascript:addSpchu(<%=shangpinGetId.getShangpinId()%>)"><input
													type="button" class="tbutton" value="租赁" />
											</a>
											</td>
										</tr>
										</form>
                  </table></td>
                </tr>
                
              </table>
              <table width="100%"  border="0" cellspacing="0" cellpadding="0" style="padding-top:15px;">
                <tr>
					<td height="35" class="sort">&nbsp;&nbsp;详细介绍
         		   </td>
			  </tr>
              <tr><td style="border:1px solid #e0e0e0; border-top:0px; padding:10px; line-height:25px;">
              <%=shangpinGetId.getShangpinMark()%>
              </td></tr>
              </table>
           
        </td>
					<%}else{ %>
					<td>没有选择汽车</td>
					<%} %>
      </tr>
    </table></td>
  </tr>
</table>
<%@ include file="footer.jsp"%>