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
    <title>咨询服务</title>
</head>
<body>

    <jsp:include page="util/navigation.jsp"></jsp:include>

    <link rel="stylesheet" href="/css/info.css">

    <div class="row">
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
        <div class="col-md-8 col-sm-8 col-xs-8">
            <div class="row dbg" style="text-align: left;">
                <h3 style="margin-left: 30px;text-align: left;">咨询服务</h3>
                <hr style="width: 95%;" />
                <div class="row" style="margin-left: 15px;">
                    <div class="col-md-2 col-sm-2 col-xs-2">
                        <h5 style="color: black;">教育局值班电话:</h5>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-4">
                        <h5 style="">14472839274</h5>
                    </div>
                    <div class="col-md-2 col-sm-2 col-xs-2">
                        <h5 style="color: black;">业务科室电话:</h5>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-4">
                        <h5 style="">27482948264</h5>
                    </div>
                </div>
                <c:forEach var="schoolPhoneLine" items="${schoolPhoneList}">
                    <div class="row" style="margin-left: 15px;">
                        <div class="col-md-2 col-sm-2 col-xs-2">
                            <h5 style="color: black;">${schoolPhoneLine.previousSchool.name}电话:</h5>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-4">
                            <h5 style="">${schoolPhoneLine.previousSchool.phone}</h5>
                        </div>
                        <div class="col-md-2 col-sm-2 col-xs-2">
                            <h5 style="color: black;">${schoolPhoneLine.subsequentSchool.name}电话:</h5>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-4">
                            <h5 style="">${schoolPhoneLine.subsequentSchool.phone}</h5>
                        </div>
                    </div>
                </c:forEach>
                <c:if test="${theLastSchool != null}">
                    <div class="row" style="margin-left: 15px;">
                        <div class="col-md-2 col-sm-2 col-xs-2">
                            <h5 style="color: black;">${theLastSchool.name}电话:</h5>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-4">
                            <h5 style="">${theLastSchool.phone}</h5>
                        </div>
                    </div>
                </c:if>
                <div style="height: 10px;"></div>
            </div>
        </div>
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
    </div>

</body>
</html>
