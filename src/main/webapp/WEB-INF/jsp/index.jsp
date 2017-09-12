<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: geminit
  Date: 2017/9/7
  Time: 下午10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GB2312" language="java" %>
<html>
    <head>
        <title>成都市龙泉驿区教育局民办教育ISP</title>
        <script src="/js/jquery-2.1.4.js"></script>
        <script src="/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="/css/bootstrap.min.css">
        <link rel="stylesheet" href="/css/dropdown.css">
        <style type="text/css">
            body {
                background:url(/image/login-bg.jpg);
                background-size: 100%;
            }
            hr {
                height:2px;
                border:none;
                border-top:2px
                solid
                #63A8EE;
            }
        </style>
    </head>
    <body>


    <div id="head">
        <div class="row" style="margin: 20px auto auto auto;">
            <div class="col-md-1 col-sm-1 col-xs-1"></div>
            <div id="logo" class="col-md-1 col-sm-1 col-xs-1">
                <nav class="navbar">
                    <div class="container-fluid">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <img class="site-logo" src="/image/logo.png" height="100" width="120"/>
                        </div>
                    </div>
                </nav>
            </div> <!-- logo -->
            <div class="col-md-1 col-sm-1 col-xs-1"></div>
            <div id="navigation" class="col-md-8 col-sm-8 col-xs-8"><br />
                <nav class="navbar" role="navigation">
                    <div class="container-fluid">
                        <ul class="nav navbar-nav" style="width: 100%;">
                            <li style="width: 12.5%;"><a href="#"><h4>首页</h4></a></li>
                            <li style="width: 12.5%;"><a href="#"><h4>信息公开</h4></a></li>
                            <li style="width: 12.5%;"><a href="#"><h4>通知公告</h4></a></li>
                            <li style="width: 12.5%;"><a href="#"><h4>行政许可</h4></a></li>
                            <li style="width: 12.5%;"><a href="#"><h4>民校之窗</h4></a></li>
                            <li style="width: 12.5%;"><a href="#"><h4>民校人物</h4></a></li>
                            <li style="width: 12.5%;"><a href="#"><h4>服务发展</h4></a></li>
                            <li class="drop">
                                <a href="#"><h4>大数据</h4></a>

                                <div class="dropdownContain">
                                    <div class="dropOut">
                                        <div class="triangle"></div>
                                        <ul>
                                            <li>Plan</li>
                                            <li>Account Settings</li>
                                            <li>Switch Account</li>
                                            <li>Sign Out</li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div> <!-- navigation -->
            <div class="col-md-1 col-sm-1 col-xs-1"></div>
        </div> <!-- outer-row -->
    </div> <!-- head -->
    <!--  head-div 完成  -->

    <div style="height: 15%"></div>

    <div id="mycarousel" class="carousel slide" style="height: 30%">
        <!--
        轮播（Carousel）指标

        <ol class="carousel-indicators">
            <li data-target="#mycarousel" data-slide-to="0" class="active"></li>
            <li data-target="#mycarousel" data-slide-to="1"></li>
            <li data-target="#mycarousel" data-slide-to="2"></li>
        </ol>
        -->
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner" style="color: #63A8EE;">
            <c:forEach var="list" items="${list}">
                <div class="item <c:if test = "${list.id == 0}">active</c:if>">
                    <center><h1>${list.title}</h1><hr style="width: ${list.lenth*4}%" /><h5 style="width: ${list.lenth*4-10}%" >${list.content}</h5></center>
                </div>
            </c:forEach>
            <!-- Controls -->
            <a class="left carousel-control" href="#mycarousel" role="button" data-slide="prev" style="background: none;">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true" style="color: #98F5FF;"></span>
            </a>
            <a class="right carousel-control" href="#mycarousel" role="button" data-slide="next" style="background: none;">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true" style="color: #98F5FF;"></span>
            </a>
        </div>
    </div> <!--  body-div 完成  -->


    <div id="button" style="width: 100%;">
        <center><button class="btn btn-primary" style="width: 120px;height: 50px;background-color: #607B8B;border: none;"
                        onmouseover="this.style.backgroundColor='#6495ED';"
                        onmouseout="this.style.backgroundColor='#607B8B';">登录</button></center>
    </div>


    <%--<!--  button-div 完成  -->--%>
    <%--<script type="application/javascript">--%>
        <%--$("#mycarousel").carousel({--%>
            <%--interval: 3000--%>
        <%--})--%>
    <%--</script>--%>

        <%--<script type="text/javascript">--%>

            <%--var name = "This page is made by ${name}!";--%>
            <%--$("#chg").html(name);--%>

            <%--$("#btn").click(--%>
                <%--function(){--%>
                    <%--var str = {};--%>
                    <%--str["input"] = document.getElementById("input").value;--%>
                    <%--$.ajax({--%>
                        <%--type : 'POST',--%>
                        <%--async : false,--%>
                        <%--url : '/isp/index/demo',--%>
                        <%--data : str,--%>
                        <%--success : function(result){--%>
                            <%--alert(result);--%>
                        <%--},--%>
                        <%--error : function(result){--%>
                            <%--alert("fail");--%>
                        <%--}--%>
                    <%--});--%>
                <%--}--%>
            <%--);--%>
        <%--</script>--%>
    </body>
</html>
