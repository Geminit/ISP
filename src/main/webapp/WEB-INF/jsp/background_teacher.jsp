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
                    <label>教师: </label>
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
                        <td class="success"><label>姓名</label></td>
                        <td class="success"><label>学校</label></td>
                        <td class="success"><label>文化程度</label></td>
                        <td class="success"><label>科目</label></td>
                        <td class="success"><label>职称</label></td>
                        <td class="success"><label>年龄</label></td>
                        <td class="success"><label>名师</label></td>
                    </tr>
                    <c:forEach items="${user}" var="key" varStatus="status">
                        <tr class="table-bordered">
                            <td>${(currentpage-1) * 10 + status.index + 1}</td>
                            <td><input type="checkbox" name="checkbox" value="${key.id}"></td>
                            <td>${key.name}</td>
                            <td>${key.schoole.name}</td>
                            <td>${key.schoolLevel.name}</td>
                            <td>${key.subjecte.name}</td>
                            <td>${key.titlee.name}</td>
                            <td>${key.age}</td>
                            <c:choose>
                                <c:when test="${key.isGood==1}">
                                    <td>是</td>
                                </c:when>
                                <c:otherwise>
                                    <td>否</td>
                                </c:otherwise>
                            </c:choose>
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
                                    <li><a href="/teacher/index?page=${previous}">上一页</a></li>
                                </c:if>
                                <c:if test="${last > page}">
                                    <li class="disabled" id="last"><a href="#">下一页</a></li>
                                </c:if>
                                <c:if test="${last <= page}">
                                    <li><a href="/teacher/index?page=${last}">下一页</a></li>
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
                            <h4 class="modal-title" id="myModalLabel">新增教师</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>姓&#8195;&#8195;名:  </label>
                                    <input type="text" id="newname">
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>学&#8195;&#8195;校:  </label>
                                    <select id="newschool">
                                        <c:forEach items="${school}" var="key">
                                            <option value="${key.id}">${key.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>文化程度:  </label>
                                    <select id="newdiploma">
                                        <c:forEach items="${school_level}" var="key">
                                            <option value="${key.id}">${key.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>科&#8195;&#8195;目:  </label>
                                    <select id="newsubject">
                                        <c:forEach items="${subject}" var="key">
                                            <option value="${key.id}">${key.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>职&#8195;&#8195;称:</label>
                                    <select id="newtitle">
                                        <c:forEach items="${title}" var="key">
                                            <option value="${key.id}">${key.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>名&#8195;&#8195;师:  </label>
                                    <select id="newisGood">
                                        <option value="0">否</option>
                                        <option value="1">是</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>年&#8195;&#8195;龄:  </label>
                                    <input type="text" id="newage">
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>图&#8195;&#8195;片:  </label>
                                    <input type="text" id="newimage">
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
                                <h4 class="modal-title" id="myModalLabelEdit">学校编辑</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-inline">
                                    <div class="form-group">
                                        <label>姓&#8195;&#8195;名:  </label>
                                        <input type="hidden" id="editid">
                                        <input type="text" id="editname">
                                    </div>
                                </div>
                                <div class="form-inline">
                                    <div class="form-group">
                                        <label>学&#8195;&#8195;校:  </label>
                                        <select id="editschool">
                                            <c:forEach items="${school}" var="key">
                                                <option value="${key.id}">${key.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-inline">
                                    <div class="form-group">
                                        <label>文化程度:  </label>
                                        <select id="editdiploma">
                                            <c:forEach items="${school_level}" var="key">
                                                <option value="${key.id}">${key.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-inline">
                                    <div class="form-group">
                                        <label>科&#8195;&#8195;目:  </label>
                                        <select id="editsubject">
                                            <c:forEach items="${subject}" var="key">
                                                <option value="${key.id}">${key.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-inline">
                                    <div class="form-group">
                                        <label>职&#8195;&#8195;称:</label>
                                        <select id="edittitle">
                                            <c:forEach items="${title}" var="key">
                                                <option value="${key.id}">${key.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-inline">
                                    <div class="form-group">
                                        <label>名&#8195;&#8195;师:  </label>
                                        <select id="editisGood">
                                            <option value="0">否</option>
                                            <option value="1">是</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-inline">
                                    <div class="form-group">
                                        <label>年&#8195;&#8195;龄:  </label>
                                        <input type="text" id="editage">
                                    </div>
                                </div>
                                <div class="form-inline">
                                    <div class="form-group">
                                        <label>图&#8195;&#8195;片:  </label>
                                        <input type="text" id="editimage">
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
                        url: "/teacher/searchByName",
                        type: "post",
                        scriptCharset: 'utf-8',
                        dataType: 'json',
                        data: {
                            name: text_value
                        },
                        success: function (data) {
                            console.log(data);
                            dataArray = eval(data);
                            var isGood = dataArray[0]['isGood'];
                            if(isGood == 1){
                                isGood = "是";
                            }else {
                                isGood = "否";
                            }
                            var html = '<td class="success"><label>编号</label></td><td class="success"></td>' +
                                '<td class="success"><label>姓名</label></td>' +
                                '<td class="success"><label>学校</label></td>' +
                                '<td class="success"><label>文化程度</label></td>' +
                                '<td class="success"><label>科目</label></td>' +
                                '<td class="success"><label>职称</label></td>' +
                                '<td class="success"><label>年龄</label></td>' +
                                '<td class="success"><label>名师</label></td>';
                            html += '<tr class="table-bordered"><td>1</td><td><input type="checkbox"></td>' +
                                '<td>'+dataArray[0]['name']+'</td><td>'+dataArray[0]['schoole']['name']+'</td>' +
                                '<td>'+dataArray[0]['schoolLevel']['name']+'</td><td>'+dataArray[0]['subjecte']['name']+'</td>' +
                                '<td>'+dataArray[0]['titlee']['name']+'</td><td>'+dataArray[0]['age']+'</td><td>'+isGood+'</td>';
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
                    url: "/teacher/insertTeacher",
                    type: "post",
                    scriptCharset: 'utf-8',
                    dataType: 'json',
                    data: {
                        name: document.getElementById("newname").value,
                        school: document.getElementById("newschool").value,
                        diploma: document.getElementById("newdiploma").value,
                        subject: document.getElementById("newsubject").value,
                        title: document.getElementById("newtitle").value,
                        isGood: document.getElementById("newisGood").value,
                        age: document.getElementById("newage").value,
                        image: document.getElementById("newimage").value,
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
                    url: "/teacher/updateTeacher",
                    type: "post",
                    scriptCharset: 'utf-8',
                    dataType: 'json',
                    data: {
                        id: document.getElementById("editid").value,
                        name: document.getElementById("editname").value,
                        school: document.getElementById("editschool").value,
                        diploma: document.getElementById("editdiploma").value,
                        subject: document.getElementById("editsubject").value,
                        title: document.getElementById("edittitle").value,
                        isGood: document.getElementById("editisGood").value,
                        age: document.getElementById("editage").value,
                        image: document.getElementById("editimage").value,
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
                    url: "/teacher/searchById",
                    type: "post",
                    scriptCharset: 'utf-8',
                    dataType: 'json',
                    data: {
                        id: check_val.pop(),
                    },
                    success: function (data) {
                        $('#editModal').modal('show');
                        dataArray = eval(data);
                        console.log(dataArray);
                        document.getElementById("editid").value = dataArray[0]['id'];
                        document.getElementById("editname").value = dataArray[0]['name'];
                        document.getElementById("editschool").value = dataArray[0]['school'];
                        document.getElementById("editdiploma").value = dataArray[0]['diploma'];
                        document.getElementById("editsubject").value = dataArray[0]['subject'];
                        document.getElementById("edittitle").value = dataArray[0]['title'];
                        document.getElementById("editisGood").value = dataArray[0]['isGood'];
                        document.getElementById("editage").value = dataArray[0]['age'];
                        document.getElementById("editimage").value = dataArray[0]['image'];
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
                    url: "/teacher/deleteTeacher",
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
