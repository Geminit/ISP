<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: geminit
  Date: 2017/9/20
  Time: 下午11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师信息</title>
</head>
<body>

    <jsp:include page="util/navigation.jsp"></jsp:include>

    <link rel="stylesheet" href="/css/info.css">

    <div class="row">
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
        <div class="col-md-8 col-sm-8 col-xs-8">
            <div class="row dbg">
                <div class="col-md-8 col-sm-8 col-xs-8 content">
                    <div class="row" style="margin-left: 15px; color: black;">
                        <div class="col-md-12 col-sm-12 col-xs-12"><h3 style="margin-bottom: 10px;">教师信息</h3></div>
                        <hr style="width: 95%;margin-bottom: 10px;" />
                    </div>
                    <div class="row" style="margin-left: 15px;">
                        <div class="col-md-2 col-sm-2 col-xs-2" style="padding-right: 0;">
                            <h5 style="color: black;">教师姓名:</h5>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-4" style="padding-left: 0;">
                            <h5 style="">${teacher.name}</h5>
                        </div>
                        <div class="col-md-2 col-sm-2 col-xs-2" style="padding-right: 0;">
                            <h5 style="color: black;">教师年龄：</h5>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-4" style="padding-left: 0;">
                            <h5 style="">${teacher.age}</h5>
                        </div>
                    </div>
                    <div class="row" style="margin-left: 15px;">
                        <div class="col-md-2 col-sm-2 col-xs-2" style="padding-right: 0;">
                            <h5 style="color: black;">所属学校:</h5>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-4" style="padding-left: 0;">
                            <h5 style="">${teacher.schoole.name}</h5>
                        </div>
                        <div class="col-md-2 col-sm-2 col-xs-2" style="padding-right: 0;">
                            <h5 style="color: black;">教师学历：</h5>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-4" style="padding-left: 0;">
                            <h5 style="">${teacher.schoolLevel.name}</h5>
                        </div>
                    </div>
                    <div class="row" style="margin-left: 15px;">
                        <div class="col-md-2 col-sm-2 col-xs-2" style="padding-right: 0;">
                            <h5 style="color: black;">教学科目:</h5>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-4" style="padding-left: 0;">
                            <h5 style="">${teacher.subjecte.name}</h5>
                        </div>
                        <div class="col-md-2 col-sm-2 col-xs-2" style="padding-right: 0;">
                            <h5 style="color: black;">教师证书：</h5>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-4" style="padding-left: 0;">
                            <h5 style="">${teacher.titlee.name}</h5>
                        </div>
                    </div>
                    <c:if test="${teacher.isGood == 1}">
                        <div class="row" style="margin-left: 15px;">
                            <div class="col-md-2 col-sm-2 col-xs-2" style="padding-right: 0;">
                                <h5 style="color: black;">所获荣誉：</h5>
                            </div>
                            <div class="col-md-10 col-sm-10 col-xs-10" style="padding-left: 0;">
                                <h5 style="">优秀教师</h5>
                            </div>
                        </div>
                    </c:if>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-4 content">
                    <img style="margin-top: 30px;margin-bottom: 20px; height: 90%;width: 90%;height: 150px" src="${teacher.image}" />
                </div>
            </div>
        </div>
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
    </div>

</body>
</html>
