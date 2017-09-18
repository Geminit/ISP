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
                    <label>学校: </label>
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
                        <td class="success"><label>学校</label></td>
                        <td class="success"><label>年级</label></td>
                        <td class="success"><label>班号</label></td>
                        <td class="success"><label>班级人数</label></td>
                        <td class="success"><label>班主任</label></td>
                        <td class="success"><label>毕业人数</label></td>
                        <td class="success"><label>毕业年份</label></td>
                    </tr>
                    <c:forEach items="${user}" var="key" varStatus="status">
                        <tr class="table-bordered">
                            <td>${(currentpage-1) * 10 + status.index + 1}</td>
                            <td><input type="checkbox" name="checkbox" value="${key.id}"></td>
                            <td>${key.schoole.name}</td>
                            <td>${key.gradee.name}</td>
                            <td>${key.classnumber}</td>
                            <td>${key.number}</td>
                            <td>${key.teachere.name}</td>
                            <c:choose>
                                <c:when test="${key.graduate_number==-1}">
                                    <td></td>
                                </c:when>
                                <c:otherwise>
                                    <td>${key.graduate_number}</td>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${key.graduate_year==-1}">
                                    <td></td>
                                </c:when>
                                <c:otherwise>
                                    <td>${key.graduate_year}</td>
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
                                    <li><a href="/class/index?page=${previous}">上一页</a></li>
                                </c:if>
                                <c:if test="${last > page}">
                                    <li class="disabled" id="last"><a href="#">下一页</a></li>
                                </c:if>
                                <c:if test="${last <= page}">
                                    <li><a href="/class/index?page=${last}">下一页</a></li>
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
                            <h4 class="modal-title" id="myModalLabel">新增班级</h4>
                        </div>
                        <div class="modal-body">
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
                                    <label>年&#8195;&#8195;级:  </label>
                                    <select id="newgrade">
                                        <c:forEach items="${grage}" var="key">
                                            <option value="${key.id}">${key.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>班&#8195;&#8195;号:  </label>
                                    <input type="text" id="newclassnumber">
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>班级人数:  </label>
                                    <input type="text" id="newnumber">
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>班主任:&#8195;</label>
                                    <select id="newhometeacher">
                                        <c:forEach items="${teacher}" var="key">
                                            <option value="${key.id}">${key.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>毕业人数:  </label>
                                    <input type="text" id="newgraduate_number">
                                </div>
                            </div>
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>毕业年份:  </label>
                                    <input type="text" id="newgraduate_year">
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
                                        <input type="hidden" id="editid">
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
                                        <label>年&#8195;&#8195;级:  </label>
                                        <select id="editgrade">
                                            <c:forEach items="${grage}" var="key">
                                                <option value="${key.id}">${key.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-inline">
                                    <div class="form-group">
                                        <label>班&#8195;&#8195;号:  </label>
                                        <input type="text" id="editclassnumber">
                                    </div>
                                </div>
                                <div class="form-inline">
                                    <div class="form-group">
                                        <label>班级人数:  </label>
                                        <input type="text" id="editnumber">
                                    </div>
                                </div>
                                <div class="form-inline">
                                    <div class="form-group">
                                        <label>班主任:&#8195;</label>
                                        <select id="edithometeacher">
                                            <c:forEach items="${teacher}" var="key">
                                                <option value="${key.id}">${key.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-inline">
                                    <div class="form-group">
                                        <label>毕业人数:  </label>
                                        <input type="text" id="editgraduate_number">
                                    </div>
                                </div>
                                <div class="form-inline">
                                    <div class="form-group">
                                        <label>毕业年份:  </label>
                                        <input type="text" id="editgraduate_year">
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
                        url: "/school/searchByName",
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
                            var html = '<td class="success"><label>编号</label></td>' +
                                '<td class="success"><label></label></td>' +
                                '<td class="success"><label>学校</label></td>' +
                                '<td class="success"><label>层次</label></td>' +
                                '<td class="success"><label>地区</label></td>' +
                                '<td class="success"><label>地址</label></td>' +
                                '<td class="success"><label>名校</label></td>';
                            html += '<tr class="table-bordered"><td>1</td><td><input type="checkbox"></td>' +
                                '<td>'+dataArray[0]['name']+'</td><td>'+dataArray[0]['schoolLevel']['name']+'</td>' +
                                '<td>'+dataArray[0]['region']['name']+'</td><td>'+dataArray[0]['address']+'</td>' +
                                '<td>'+isGood+'</td>';
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
                var graduate_number = document.getElementById("newgraduate_number").value;
                var graduate_year = document.getElementById("newgraduate_year").value;
                if(graduate_number == ''){
                    graduate_number = -1;
                }
                if(graduate_year == ''){
                    graduate_year = -1;
                }
                htmlobj = $.ajax({
                    url: "/class/insertClass",
                    type: "post",
                    scriptCharset: 'utf-8',
                    dataType: 'json',
                    data: {
                        school: document.getElementById("newschool").value,
                        grade: document.getElementById("newgrade").value,
                        classnumber: document.getElementById("newclassnumber").value,
                        number: document.getElementById("newnumber").value,
                        hometeacher: document.getElementById("newhometeacher").value,
                        graduate_number: graduate_number,
                        graduate_year: graduate_year,
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
                var graduate_number = document.getElementById("editgraduate_number").value;
                var graduate_year = document.getElementById("editgraduate_year").value;
                if(graduate_number == ''){
                    graduate_number = -1;
                }
                if(graduate_year == ''){
                    graduate_year = -1;
                }
                htmlobj = $.ajax({
                    url: "/class/updateClass",
                    type: "post",
                    scriptCharset: 'utf-8',
                    dataType: 'json',
                    data: {
                        id: document.getElementById("editid").value,
                        school: document.getElementById("editschool").value,
                        grade: document.getElementById("editgrade").value,
                        classnumber: document.getElementById("editclassnumber").value,
                        number: document.getElementById("editnumber").value,
                        hometeacher: document.getElementById("edithometeacher").value,
                        graduate_number: graduate_number,
                        graduate_year: graduate_year,
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
                    url: "/class/searchById",
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
                        document.getElementById("editschool").value = dataArray[0]['school'];
                        document.getElementById("editgrade").value = dataArray[0]['grade'];
                        document.getElementById("editclassnumber").value = dataArray[0]['classnumber'];
                        document.getElementById("editnumber").value = dataArray[0]['number'];
                        document.getElementById("edithometeacher").value = dataArray[0]['hometeacher'];
                        var editgraduate_number = dataArray[0]['graduate_number'];
                        if(editgraduate_number == -1){
                            editgraduate_number = "";
                        }
                        var editgraduate_year = dataArray[0]['graduate_year'];
                        if(editgraduate_year == -1){
                            editgraduate_year = "";
                        }
                        document.getElementById("editgraduate_number").value = editgraduate_number;
                        document.getElementById("editgraduate_year").value = editgraduate_year;
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
                    url: "/class/deleteClass",
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
