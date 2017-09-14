<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Date: 2017/9/12
  Time: 上午10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息公开-民办学校终止</title>
</head>
<body>

    <jsp:include page="../util/navigation.jsp"></jsp:include>

    <link rel="stylesheet" href="/css/info.css">


    <div class="row">
        <div class="col-md-1 col-sm-1 col-xs-1"></div>
        <div class="col-md-2 col-sm-2 col-xs-2">
            <div class="dbg">
                <h3><a class="la" href="/isp/info/establish">民办学校设立</a></h3><hr />
                <h3><a class="la" href="/isp/info/modify">民办学校变更</a></h3><hr />
                <h3><a class="la" href="/isp/info/end" style="color: #63A8EE;">民办学校终止</a></h3><hr />
                <h3 style="height:65px;"><a class="la" href="/isp/info/guide">办事指南</a></h3>
            </div>
        </div>
        <div class="col-md-6 col-sm-6 col-xs-6">
            <div class="dbg">
                <div class="content">
                    <h3>行政许可批复</h3>
                </div>
                <c:forEach var="license" items="${endingList}">
                    <hr style="width: 95%;" />
                    <div class="content">
                        <h5><a class="la" href="/isp/info/toLicense?id=${license.licenseId}">关于终止${license.schoolName}的行政许可批复</a></h5>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="col-md-2 col-sm-2 col-xs-2">
            <div class="dbg" style="padding-top: 20px;padding-bottom: 20px;">
                <input /><button>搜索</button>
            </div>
        </div>
        <div class="col-md-1 col-sm-1 col-xs-1"></div>
    </div>
</body>
</html>
