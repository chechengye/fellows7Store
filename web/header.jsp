<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<script src="js/jquery-1.11.3.min.js"></script>

<script>
	function searchProductByWord(obj) {
	    var word = $(obj).val();
	    var contentStr = "";
		if(word != null && word != ''){
		    $.ajax({
				url: "${pageContext.request.contextPath}/searchProduct",
				data: {"word":word},
				success:function (data) {
				    for(var i = 0 ; i < data.length ; i++){
                        contentStr += "<a href='${pageContext.request.contextPath}/productDetail?pid="+data[i].pid+"'><div  style='font-size: 11px ; padding: 5px;' onmouseover='checked(this)' onmouseout='noChecked(this)'>"+data[i].pname+"</div></a>"
                    }

                    $("#content").html(contentStr);
                    $("#content").css("display","block");
                } ,
				dataType: "json",
				type: "POST"
			});
		}else{
            $("#content").css("display","none");
        }
    }
    /*$(document).ready(function () {
        $("#cate_ul li").removeClass("active");
        $("#cate_ul li").click(function () {
            alert(111)
			$("#cate_ul li").addClass("active");
        });
    });*/
    function checked(obj) {
		$(obj).css("background","#2aabd2");
    }

    function noChecked(obj) {
        $(obj).css("background","#ffffff");
    }
</script>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<c:if test="${user != null}">
				欢迎,${user.name}
				<li><a href="${pageContext.request.contextPath}/cartList?uid=${user.uid}">购物车</a></li>
				<li><a href="order_list.jsp">我的订单</a></li>
			</c:if>
			<c:if test="${user == null}">
				<li><a href="login.jsp">登录</a></li>
				<li><a href="register.jsp">注册</a></li>
				<li><a href="cart.jsp">购物车</a></li>
				<li><a href="order_list.jsp">我的订单</a></li>
			</c:if>

		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="
				.jsp">首页</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" id="cate_ul">
					<c:forEach items="${categoryList}" var="cate">
						<li><a href="<%=request.getContextPath()%>/productList?cid=${cate.cid}">${cate.cname}<span class="sr-only">(current)</span></a></li>
					</c:forEach>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group" style="position: relative">
						<input type="text" class="form-control" placeholder="Search" onkeyup="searchProductByWord(this)">
						<div id="content" style="display: none ; z-index: 1000;width: 170px ; height: 210px; background: white ; margin-top: 2px;position: absolute"></div>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</nav>
</div>

