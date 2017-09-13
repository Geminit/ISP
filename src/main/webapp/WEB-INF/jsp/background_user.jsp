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
            <%--搜索框--%>
            <div class="form-inline" id="input-box">
                <div class="form-group">
                    <label>账号: </label>
                    <input type="text" class="form-control" id="useraccount">
                </div>
                <button class="btn btn-primary" id="search-btn">搜索</button>
            </div>
            <%--按钮--%>
            <div>
                <div class="col-md-4" id="button-ned">
                    <div class="col-md-2">
                        <button type="button" class="btn btn-primary" data-toggle="modal"
                                data-target="#newModal">新增</button>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-warning">编辑</button>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-danger" onclick="getCheckBox()">删除</button>
                    </div>
                </div>
            </div>
            <%--表格--%>
            <div class="col-md-11" id="table-box">
                <table class="table table-bordered" border="1" id="table-user">
                    <tr class="table-bordered">
                        <td class="success"><label>编号</label></td>
                        <td class="success"></td>
                        <td class="success"><label>账号</label></td>
                        <td class="success"><label>用户名</label></td>
                        <td class="success"><label>角色</label></td>
                        <td class="success"><label>状态</label></td>
                        <td class="success"><label>邮箱</label></td>
                    </tr>
                    <c:forEach items="${user}" var="key" varStatus="status">
                        <tr class="table-bordered">
                            <td>${(currentpage-1) * 10 + status.index + 1}</td>
                            <td><input type="radio"></td>
                            <td>${key.account}</td>
                            <td>${key.username}</td>
                            <td>${key.rolee.name}</td>
                            <c:choose>
                                <c:when test="${key.status==1}">
                                    <td style="color: lightblue">启用</td>
                                </c:when>
                                <c:otherwise>
                                    <td style="color: lightcoral;">停用</td>
                                </c:otherwise>
                            </c:choose>
                            <td>${key.email}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <%--页数文本--%>
            <div class="row" id="page-text">
                <div class="col-md-12">
                    <div class="col-md-2" id="page-text-div">
                        <a>总${total}条&nbsp;&nbsp;&nbsp;每页10条&nbsp;&nbsp;&nbsp;共${page}页</a>
                    </div>
                    <div class="col-md-6"></div>
                    <div class="col-md-4" id="page-button">
                        <nav>
                            <ul class="pager" id="page-controller">
                                <c:if test="${previous<1}">
                                    <li class="disabled" id="previous"><a href="#">上一页</a></li>
                                </c:if>
                                <c:if test="${previous>=1}">
                                    <li><a href="/user/index?page=${previous}">上一页</a></li>
                                </c:if>
                                <c:if test="${last > page}">
                                    <li class="disabled" id="last"><a href="#">下一页</a></li>
                                </c:if>
                                <c:if test="${last <= page}">
                                    <li><a href="/user/index?page=${last}">下一页</a></li>
                                </c:if>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <%--新建用户模态框--%>
            <div class="modal fade" id="newModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="myModalLabel">新用户注册</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>账号:  </label>
                                    <input type="text" id="newuseraccount">
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>密码:  </label>
                                    <input type="password" id="newuserpassword">
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>昵称: </label>
                                    <input type="text" id="newuserusername">
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>角色: </label>
                                    <select id="newuserrole">
                                        <option value ="1">管理员</option>
                                        <option value ="2">普通用户</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>状态: </label>
                                    <select id="newuserstatus">
                                        <option value ="0">停用</option>
                                        <option value ="1">启用</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>邮箱: </label>
                                    <input type="email" id="newuseremail">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" id="newuserbutton">新建</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="background_footer.jsp"></jsp:include>
    <%--引入js文件--%>
    <jsp:include page="background_js.jsp"></jsp:include>
    <script>
        //搜索按钮ajax请求
        $(document).ready(function () {
            $("#search-btn").click(function () {
                var text_value = document.getElementById("useraccount").value
                if(text_value == ""){
                    window.location.reload();
                }else{
                    htmlobj = $.ajax({
                        url: "/user/searchByAccount",
                        type: "post",
                        scriptCharset: 'utf-8',
                        dataType: 'json',
                        data: {
                            account: document.getElementById("useraccount").value
                        },
                        success: function (data) {
                            dataArray = eval(data);
                            var status = dataArray[0]['status'];
                            if(status==1){
                                status = "启用";
                            }else {
                                status = "停用";
                            }
                            var html = '<table class="table table-bordered" border="1" id="table-user">' +
                                '<tr class="table-bordered"><td class="success"><label>编号</label></td>' +
                                '<td class="success"></td><td class="success"><label>账号</label></td><td class="success">' +
                                '<label>用户名</label></td><td class="success"><label>角色</label></td><td class="success">' +
                                '<label>状态</label></td><td class="success"><label>邮箱</label></td></tr>';
                            html += '<tr class="table-bordered"><td>1</td><td><input type="checkbox"></td>' +
                                '<td>'+dataArray[0]['account']+'</td><td>'+dataArray[0]['username']+'</td>' +
                                '<td>'+dataArray[0]['rolee']['name']+'</td><td>'+status+'</td>' +
                                '<td>'+dataArray[0]['email']+'</td>';
                            document.getElementById('table-user').innerHTML = html;
                            document.getElementById("page-text").innerHTML = "";
                        },
                    })
                }
            })
        })

        //新建用户ajax请求
        $(document).ready(function () {
            $("#newuserbutton").click(function () {
                htmlobj = $.ajax({
                    url: "/user/insertUser",
                    type: "post",
                    scriptCharset: 'utf-8',
                    dataType: 'json',
                    data: {
                        account: document.getElementById("newuseraccount").value,
                        password: document.getElementById("newuserpassword").value,
                        username: document.getElementById("newuserusername").value,
                        role: document.getElementById("newuserrole").value,
                        status: document.getElementById("newuserstatus").value,
                        email: document.getElementById("newuseremail").value,
                    },
                    success: function (data) {
                        var result = eval(data);
                        if(result['result']=='success'){
                            alert("数据插入成功");
                        }else{
                            alert("数据插入失败");
                        }
                    },
                })
            })
        })

        //获取勾选的CheckBox
        function getCheckBox() {
            $("input[name='checkbox'][checked]").each(function () {
                alert(this.value);
            })
        }
    </script>
</body>
</html>