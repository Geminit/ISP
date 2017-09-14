<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Date: 2017/9/12
  Time: 下午3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>民校之窗</title>
</head>
<body>

    <jsp:include page="util/navigation.jsp"></jsp:include>

    <link rel="stylesheet" href="/css/info.css">

    <div class="row">
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
        <div class="col-md-8 col-sm-8 col-xs-8">
            <div class="dbg">
                <div class="content">
                    <h3>民校之窗
                        <span class="glyphicon glyphicon-chevron-down" aria-hidden="true" style="font-size: 15px;"></span></h3>
                </div>
                <c:forEach var="school" items="${goodSchools}">
                    <hr style="width: 95%;" />
                    <div class="content">
                        <h5><a class="la" href="/isp/info/toSchool?id=${school.schoolId}">${school.schoolName}</a></h5>
                    </div>
                </c:forEach>
                <ul class="pagination" style="margin-bottom: 5px;">
                    <li><a style="height:35px; font-size: 15px;" href="#">&laquo;</a></li>
                    <li><a style="height: 35px;" href="#">&lt;</a></li>
                    <li><a style="height: 35px;" href="#">第 <input style="width: 30px;color: #000000;text-align: center;" /> 页／共10页</a></li>
                    <li><a style="height: 35px;" href="#">&gt;</a></li>
                    <li><a style="height: 35px; font-size: 15px;" href="#">&raquo;</a></li>
                    <li class="disabled"><a style="height: 35px;" href="#">检索到***条记录，显示第 1 - 5 条记录</a></li>
                </ul>
            </div>
        </div>
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
    </div>
</body>
</html>
