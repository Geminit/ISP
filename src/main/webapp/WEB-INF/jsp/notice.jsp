<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: geminit
  Date: 2017/9/20
  Time: 下午11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${notice.title}</title>
</head>
<body>

    <jsp:include page="util/navigation.jsp"></jsp:include>

    <link rel="stylesheet" href="/css/info.css">

    <div class="row">
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
        <div class="col-md-8 col-sm-8 col-xs-8">
            <div class="row dbg" style="text-align: left;">
                <h3 style="margin-left: 30px;text-align: left;">${notice.title}</h3>
                <hr style="width: 95%;" />
                <div class="row">
                    <div class="col-md-1 col-sm-1 col-xs-1"></div>
                    <div class="col-md-10 col-sm-10 col-xs-10">
                        <h5 style="">${notice.content}</h5>
                    </div>
                    <div class="col-md-1 col-sm-1 col-xs-1"></div>
                </div>
                <div class="row">
                    <div class="col-md-9 col-sm-9 col-xs-9"></div>
                    <div class="col-md-2 col-sm-2 col-xs-2">${notice.date}</div>
                    <div class="col-md-1 col-sm-1 col-xs-1"></div>
                </div>
                <div style="height: 10px;"></div>
            </div>
        </div>
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
    </div>
</body>
</html>
