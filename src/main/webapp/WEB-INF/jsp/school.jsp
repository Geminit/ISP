<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: geminit
  Date: 2017/9/15
  Time: 下午4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${school.name}</title>
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
                        <div class="col-md-12 col-sm-12 col-xs-12"><h3 style="margin-bottom: 0;">${school.name}</h3></div>
                    </div>
                    <div class="row" style="margin-left: 15px; margin-bottom: 5px;color: black;">
                        <div class="col-md-12 col-sm-12 col-xs-12"><h4 style="margin-top: 0;">${school.englishName}</h4></div>
                    </div>
                    <div class="row" style="margin-left: 15px;">
                        <div class="col-md-2 col-sm-2 col-xs-2" style="padding-right: 0;">
                            <h5 style="color: black;">学校名称:</h5>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-4" style="padding-left: 0;">
                            <h5 style="">${school.name}</h5>
                        </div>
                        <div class="col-md-2 col-sm-2 col-xs-2" style="padding-right: 0;">
                            <h5 style="color: black;">学校类型：</h5>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-4" style="padding-left: 0;">
                            <h5 style="">${school.schoolLevel.name}</h5>
                        </div>
                    </div>
                    <div class="row" style="margin-left: 15px;">
                        <div class="col-md-2 col-sm-2 col-xs-2" style="padding-right: 0;">
                            <h5 style="color: black;">所属地区:</h5>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-4" style="padding-left: 0;">
                            <h5 style="">${school.region.name}</h5>
                        </div>
                        <div class="col-md-2 col-sm-2 col-xs-2" style="padding-right: 0;">
                            <h5 style="color: black;">创办时间：</h5>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-4" style="padding-left: 0;">
                            <h5 style="">${school.establishDate}</h5>
                        </div>
                    </div>
                    <div class="row" style="margin-left: 15px;">
                        <div class="col-md-2 col-sm-2 col-xs-2" style="padding-right: 0;">
                            <h5 style="color: black;">学校地址：</h5>
                        </div>
                        <div class="col-md-10 col-sm-10 col-xs-10" style="padding-left: 0;">
                            <h5 style="">${school.address}</h5>
                        </div>
                    </div>
                    <c:if test="${school.isGood == 1}">
                        <div class="row" style="margin-left: 15px;">
                            <div class="col-md-2 col-sm-2 col-xs-2" style="padding-right: 0;">
                                <h5 style="color: black;">所获荣誉：</h5>
                            </div>
                            <div class="col-md-10 col-sm-10 col-xs-10" style="padding-left: 0;">
                                <h5 style="">优秀学校</h5>
                            </div>
                        </div>
                    </c:if>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-4 content">
                    <img style="margin-top: 30px;margin-bottom: 20px; height: 90%;width: 90%;height: 150px" src="${school.image}" />
                </div>
                <h5 style="margin-left: 50px;margin-right: 50px;text-align: left;line-height: 1.5;">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${school.info}
                </h5>
            </div>
        </div>
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
    </div>

</body>
</html>
