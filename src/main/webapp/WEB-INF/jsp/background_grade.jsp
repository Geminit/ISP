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
                    <input type="text" class="form-control" id="name">
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
                        <button class="btn btn-warning" onclick="getCheckBoxEdit()">编辑</button>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-danger" onclick="getCheckBoxDelete()">删除</button>
                    </div>
                </div>
            </div>
            <%--表格--%>
            <div class="col-md-11" id="table-box">
                <table class="table table-bordered" border="1" id="table-user">
                    <tr>
                        <td class="success"><label>编号</label></td>
                        <td class="success"></td>
                        <td class="success"><label>年级</label></td>
                    </tr>
                    <c:forEach items="${user}" var="key" varStatus="status">
                        <tr class="table-bordered">
                            <td>${(currentpage-1) * 10 + status.index + 1}</td>
                            <td><input type="checkbox" name="checkbox" value="${key.id}"></td>
                            <td>${key.name}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <%--页数文本--%>
            <div id="page-text">
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
                                    <li><a href="/schoollevel/index?page=${previous}">上一页</a></li>
                                </c:if>
                                <c:if test="${last > page}">
                                    <li class="disabled" id="last"><a href="#">下一页</a></li>
                                </c:if>
                                <c:if test="${last <= page}">
                                    <li><a href="/schoollevel/index?page=${last}">下一页</a></li>
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
                            <h4 class="modal-title" id="myModalLabel">新增年级</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>年级:  </label>
                                    <input type="text" id="newname">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" id="newbutton">新建</button>
                        </div>
                    </div>
                </div>
            </div>

            <%--编辑用户模态框--%>
            <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog modal-sm" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="myModalLabelEdit">年级编辑</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-inline">
                                    <div class="form-group">
                                        <label>学校层次:  </label>
                                        <input type="hidden" id="editid">
                                        <input type="text" id="editname">
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary" id="editlbutton">更新</button>
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
                var text_value = document.getElementById("name").value
                if(text_value == ""){
                    window.location.reload();
                }else{
                    htmlobj = $.ajax({
                        url: "/grade/searchByName",
                        type: "post",
                        scriptCharset: 'utf-8',
                        dataType: 'json',
                        data: {
                            name: text_value
                        },
                        success: function (data) {
                            console.log(data);
                            dataArray = eval(data);
                            var html = '<table class="table table-bordered" border="1" id="table-user">' +
                                '<tr class="table-bordered"><td class="success"><label>编号</label></td>' +
                                '<td class="success"></td><td class="success"><label>年级</label></td>';
                            html += '<tr class="table-bordered"><td>1</td><td><input type="checkbox"></td>' +
                                '<td>'+dataArray[0]['name']+'</td>';
                            document.getElementById('table-user').innerHTML = html;
                            document.getElementById("page-text").innerHTML = "";
                        },
                    })
                }
            })
        })

        //新建用户ajax请求
        $(document).ready(function () {
            $("#newbutton").click(function () {
                htmlobj = $.ajax({
                    url: "/grade/insertGrade",
                    type: "post",
                    scriptCharset: 'utf-8',
                    dataType: 'json',
                    data: {
                        name: document.getElementById("newname").value,
                    },
                    success: function (data) {
                        var result = eval(data);
                        if(result['result']=='success'){
                            alert("数据插入成功");
                            window.location.reload();
                        }else{
                            alert("数据插入失败");
                            window.location.reload()
                        }
                    },
                })
            })
        })

        //更新用户ajax请求
        $(document).ready(function () {
            $("#editlbutton").click(function () {
                htmlobj = $.ajax({
                    url: "/grade/updateGrade",
                    type: "post",
                    scriptCharset: 'utf-8',
                    dataType: 'json',
                    data: {
                        id: document.getElementById("editid").value,
                        name: document.getElementById("editname").value,
                    },
                    success: function (data) {
                        var result = eval(data);
                        if(result['result']=='success'){
                            alert("数据修改成功");
                            window.location.reload();
                        }else{
                            alert("数据修改失败");
                            window.location.reload()
                        }
                    },
                })
            })
        })

        //点击编辑操作
        function getCheckBoxEdit() {
            obj = document.getElementsByName("checkbox");
            check_val = [];
            var id;
            for(k in obj){
                if(obj[k].checked)
                    check_val.push(obj[k].value);
            }
            if(check_val.length == 1){
                //弹出模态框
                htmlobj = $.ajax({
                    url: "/grade/searchById",
                    type: "post",
                    scriptCharset: 'utf-8',
                    dataType: 'json',
                    data: {
                        id: check_val.pop(),
                    },
                    success: function (data) {
                        $('#editModal').modal('show');
                        dataArray = eval(data);
                        document.getElementById("editid").value = dataArray[0]['id'];
                        document.getElementById("editname").value = dataArray[0]['name'];
                    },
                })
            }else {
                alert("请选择仅选择一个");
                return 0;
            }
        }

        //点击删除操作
        function getCheckBoxDelete() {
            obj = document.getElementsByName("checkbox");
            check_val = [];
            var id;
            for(k in obj){
                if(obj[k].checked)
                    check_val.push(obj[k].value);
            }
            if(check_val.length == 1){
                htmlobj = $.ajax({
                    url: "/grade/deleteGrade",
                    type: "post",
                    scriptCharset: 'utf-8',
                    dataType: 'json',
                    data: {
                        id: check_val.pop(),
                    },
                    success: function (data) {
                        var result = eval(data);
                        if(result['result']=='success'){
                            alert("数据删除成功");
                            window.location.reload();
                        }else{
                            alert("数据删除失败");
                            window.location.reload()
                        }
                    },
                })
            }else {
                alert("请选择仅选择一个");
                return 0;
            }
        }
    </script>
</body>
</html>
