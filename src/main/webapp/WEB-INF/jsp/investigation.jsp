<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: geminit
  Date: 2017/9/21
  Time: 下午4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>民意调查</title>
</head>
<body>

    <jsp:include page="util/navigation.jsp"></jsp:include>

    <link rel="stylesheet" href="/css/info.css">

    <div class="row">
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
        <div class="col-md-8 col-sm-8 col-xs-8">
            <div class="row dbg" style="text-align: left;">
                <h3 style="margin-left: 30px;text-align: left;">民意调查</h3>
                <hr style="width: 95%;" />
                <div style="height: 10px;"></div>
                <div class="row" style="margin-left: 15px;">
                    <div class="col-md-2 col-sm-2 col-xs-2" style="text-align: right;">
                        <h5 style="color: black;">姓名:</h5>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-4" style="margin-top: 5px;padding-left: 0;">
                        <input id="name" />
                    </div>
                    <div class="col-md-2 col-sm-2 col-xs-2" style="text-align: right;">
                        <h5 style="color: black;">联系方式:</h5>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-4" style="margin-top: 5px;padding-left: 0;">
                        <input id="phone" />
                    </div>
                </div>
                <div style="height: 10px;"></div>
                <div class="row" style="margin-left: 15px;">
                    <div class="col-md-2 col-sm-2 col-xs-2" style="text-align: right;">
                        <h5 style="color: black;">邮箱:</h5>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-4" style="margin-top: 5px;padding-left: 0;">
                        <input id="email" />
                    </div>
                    <div class="col-md-2 col-sm-2 col-xs-2" style="text-align: right;">
                        <h5 style="color: black;">关注点:</h5>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-4" style="margin-top: 7px;padding-left: 0;">
                        <select id="focus">
                            <c:forEach var="focus" items="${focus}">
                                <option value="${focus}">${focus}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div style="height: 30px;"></div>
                <div class="row" style="margin-left: 55px;">
                    <div class="col-md-3 col-sm-3 col-xs-3" style="text-align: right;">
                        <h5 style="color: black;">选择你认为最好的学校:</h5>
                    </div>
                    <div class="col-md-9 col-sm-9 col-xs-9" style="margin-top: 7px;padding-left: 0;">
                        <select id="bestSchool">
                            <c:forEach var="school" items="${schools}">
                                <option value="${school}">${school}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row" style="margin-left: 55px;">
                    <div class="col-md-3 col-sm-3 col-xs-3" style="text-align: right;">
                        <h5 style="color: black;">理由:</h5>
                    </div>
                    <div class="col-md-9 col-sm-9 col-xs-9" style="margin-top: 5px;padding-left: 0;">
                        <textarea id="bestReason" style="width: 77%;height: 100px;"></textarea>
                    </div>
                </div>
                <div style="height: 30px;"></div>
                <div class="row" style="margin-left: 55px;">
                    <div class="col-md-3 col-sm-3 col-xs-3" style="text-align: right;">
                        <h5 style="color: black;">选择你认为最差的学校:</h5>
                    </div>
                    <div class="col-md-9 col-sm-9 col-xs-9" style="margin-top: 7px;padding-left: 0;">
                        <select id="badestSchool">
                            <c:forEach var="school" items="${schools}">
                                <option value="${school}">${school}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row" style="margin-left: 55px;">
                    <div class="col-md-3 col-sm-3 col-xs-3" style="text-align: right;">
                        <h5 style="color: black;">理由:</h5>
                    </div>
                    <div class="col-md-9 col-sm-9 col-xs-9" style="margin-top: 5px;padding-left: 0;">
                        <textarea id="badestReason" style="width: 77%;height: 100px;"></textarea>
                    </div>
                </div>
                <div style="height: 30px;"></div>
                <div class="row" style="margin-left: 55px;">
                    <div class="col-md-3 col-sm-3 col-xs-3" style="text-align: right;">
                        <h5 style="color: black;">请写出你对本网站的意见:</h5>
                    </div>
                    <div class="col-md-9 col-sm-9 col-xs-9" style="margin-top: 5px;padding-left: 0;">
                        <textarea id="advise" style="width: 77%;height: 100px;"></textarea>
                    </div>
                </div>
                <div style="height: 30px;"></div>
                <div style="text-align: right;margin-right: 150px;">
                    <button style="width: 50px;" onclick="putUp()">提交</button>
                </div>
                <div style="height: 30px;"></div>
            </div>
        </div>
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
        <script type="text/javascript">
            function putUp(){
                var str = {};
                str["name"] = document.getElementById("name").value;
                str["phone"] = document.getElementById("phone").value;
                str["email"] = document.getElementById("email").value;
                str["focus"] = $("#focus").val();
                str["bestSchool"] = $("#bestSchool").val();
                str["bestReason"] = document.getElementById("bestReason").value;
                str["badestSchool"] = $("#badestSchool").val();
                str["badestReason"] = document.getElementById("badestReason").value;
                str["advise"] = document.getElementById("advise").value;
                $.ajax({                    //获得各个区域的值
                    type:"post",
                    async: false, //同步执行
                    url:"/isp/investigate",
                    data:str
                });
                alert("谢谢参与！");
                window.location.href = "/isp/investigation";
            }
        </script>
    </div>
</body>
</html>
