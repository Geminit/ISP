<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2017/9/12
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <%--引入css文件--%>
    <jsp:include page="background_css.jsp"></jsp:include>
    <link rel="stylesheet" href="/css/background_public.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <jsp:include page="background_header.jsp"></jsp:include>
    <jsp:include page="background_leftside.jsp"></jsp:include>
    <div class="content-wrapper">
        <div class="col-md-12" id="search-box">
            <form class="form-inline">
                <div class="form-group">
                    <label for="useraccount">用户账号: </label>
                    <input type="text" class="form-control" id="useraccount">
                </div>
                <button type="submit" class="btn btn-primary">搜索</button>
            </form>
            <div>
                <div class="col-md-4" id="button-ned">
                    <div class="col-md-2">
                        <button class="btn btn-success">新增</button>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-warning">编辑</button>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-danger">删除</button>
                    </div>
                </div>
            </div>
            <div class="col-md-11" id="table-box">
                <table class="table table-bordered" border="1">
                    <tr class="table-bordered">
                        <td class="success"><label>编号</label></td>
                        <td class="success"><label>账号</label></td>
                        <td class="success"><label>用户名</label></td>
                        <td class="success"><label>角色</label></td>
                        <td class="success"><label>状态</label></td>
                        <td class="success"><label>邮箱</label></td>
                    </tr>
                    <c:forEach items="${user}" var="key">
                        <tr class="table-bordered">
                            <td>${key.id}</td>
                            <td>${key.account}</td>
                            <td>${key.username}</td>
                            <td>${key.rolee.name}</td>
                            <c:choose>
                                <c:when test="${key.status==1}">
                                    <td>启用</td>
                                </c:when>
                                <c:otherwise>
                                    <td>停用</td>
                                </c:otherwise>
                            </c:choose>
                            <td>${key.email}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <jsp:include page="background_footer.jsp"></jsp:include>
    <%--引入js文件--%>
    <jsp:include page="background_js.jsp"></jsp:include>
</body>
</html>
