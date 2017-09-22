<%--
  Created by IntelliJ IDEA.
  Date: 2017/9/12
  Time: 下午2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>navigation</title>
    <script src="/js/jquery-2.1.4.js"></script>
    <script src="/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/dropdown.css">
    <style type="text/css">
        body {
            background:url(/image/login-bg.jpg);
            background-size: 100%;
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
                            <img class="site-logo" src="/image/logo.png" height="120" width="120"/>
                        </div>
                    </div>
                </nav>
            </div> <!-- logo -->
            <div class="col-md-1 col-sm-1 col-xs-1"></div>
            <div id="navigation" class="col-md-8 col-sm-8 col-xs-8"><br />
                <nav class="navbar" role="navigation">
                    <div class="container-fluid">
                        <ul class="nav navbar-nav" style="width: 100%;">
                            <li class="drop" style="width: 12.5%;"><a href="/isp/index"><h4>首页</h4></a></li>
                            <li style="width: 12.5%;">
                                <a href="/isp/info/establish"><h4>信息公开</h4></a>
                                <div class="dropdownContain">
                                    <div class="dropOut">
                                        <div class="triangle"></div>
                                        <ul>
                                            <li onclick="jumpTo('/isp/info/establish')">民办学校设立</li>
                                            <li onclick="jumpTo('/isp/info/modify')">民办学校变更</li>
                                            <li onclick="jumpTo('/isp/info/end')">民办学校终止</li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li style="width: 12.5%;"><a href="/isp/notices"><h4>通知公告</h4></a></li>
                            <li style="width: 12.5%;"><a href="/isp/schools"><h4>民校之窗</h4></a></li>
                            <li style="width: 12.5%;"><a href="/isp/teachers"><h4>民校人物</h4></a></li>
                            <li style="width: 12.5%;">
                                <a href="#"><h4>服务发展</h4></a>
                                <div class="dropdownContain">
                                    <div class="dropOut">
                                        <div class="triangle"></div>
                                        <ul>
                                            <li onclick="jumpTo('/isp/service')">咨询服务</li>
                                            <li onclick="jumpTo('/isp/investigation')">民意调查</li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li class="drop"><a href="/isp/data"><h4>民教布局</h4></a></li>
                            <li style="width: 12.5%;"><a href="#" style="color: deepskyblue"><h4>登录</h4></a></li>
                        </ul>
                    </div>
                </nav>
            </div> <!-- navigation -->
            <div class="col-md-1 col-sm-1 col-xs-1"></div>
        </div> <!-- outer-row -->
    </div> <!-- head -->
    <%--<!--  button-div 完成  -->--%>
        <script type="text/javascript">
            function jumpTo(url) {
                window.location.href = url;
            }
        </script>
</body>
</html>
