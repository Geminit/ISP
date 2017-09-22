<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: geminit
  Date: 2017/9/18
  Time: 下午9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>民校人物</title>
</head>
<body>

    <jsp:include page="util/navigation.jsp"></jsp:include>

    <link rel="stylesheet" href="/css/info.css">

    <style type="text/css">
        ul{
            list-style:none;
        }
        .choosed li{
            float:left; /* 往左浮动 */
            color: red;
            font-size: 15px;
            border-color: red;
            border-width: 1px;
            border-style: dotted;
            margin-top: 8px;
            margin-right: 10px;
        }
        .choosed li:hover{
            border-style: double;
            color: red;
        }
        .choice li{
            float:left; /* 往左浮动 */
            font-size: 15px;
            text-align: left;
            padding-top: 8px;
            padding-bottom: 10px;
            margin-right: 20px;
        }
        li:hover {
            color: #63A8EE;
        }
        .img {
            filter:alpha(Opacity=100);
            -moz-opacity:1;
            opacity: 1;
        }
        .more div:hover{
            border-color: red;
        }
    </style>

    <div class="row">
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
        <div class="col-md-8 col-sm-8 col-xs-8 dbg">
            <div style="padding-left: 5px;padding-right: 5px;margin-top: 10px;background-color: lightgray;text-align: left;">
                <div class="row" style="padding-left: 5px;">
                    <div class="col-md-2 col-sm-2 col-xs-2" style="margin-right: 0;"><h4 style="color: black;">教师筛选</h4></div>
                    <div class="col-md-2 col-sm-2 col-xs-2 row" style="padding-left: 0;"><h5>共${totle}名教师</h5></div>
                    <div class="col-md-8 col-sm-8 col-xs-8" style="padding-left: 0;">
                        <ul id="choosed" class="choosed"></ul>
                    </div>
                </div>
            </div>
            <c:if test="${regions.size() != 0}">
                <div id="region" class="row" value="所属区县" style="text-align: left;padding-left: 10px;">
                    <div class="col-md-2 col-sm-2 col-xs-2" style="margin-right: 0;">
                        <h5 style="color: black;">所属区县：</h5>
                    </div>
                    <div class="col-md-9 col-sm-9 col-xs-9 row" style="padding-left: 0;">
                        <ul class="choice">
                            <c:forEach var="region" items="${regions}">
                                <li value="region">${region}</li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </c:if>
            <c:if test="${levels.size() != 0}">
                <div id="level" class="row" value="教育对象" style="text-align: left;padding-left: 10px;">
                    <div class="col-md-2 col-sm-2 col-xs-2" style="margin-right: 0;">
                        <h5 style="color: black;">教育对象：</h5>
                    </div>
                    <div class="col-md-9 col-sm-9 col-xs-9 row" style="padding-left: 0;">
                        <ul class="choice">
                            <c:forEach var="level" items="${levels}">
                                <li value="level">${level}</li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </c:if>
            <c:if test="${subjects.size() != 0}">
                <div id="subject" class="row" value="教学科目" style="text-align: left;padding-left: 10px;">
                    <div class="col-md-2 col-sm-2 col-xs-2" style="margin-right: 0;">
                        <h5 style="color: black;">教学科目：</h5>
                    </div>
                    <div class="col-md-9 col-sm-9 col-xs-9 row" style="padding-left: 0;">
                        <ul class="choice">
                            <c:forEach var="subject" items="${subjects}">
                                <li value="subject">${subject}</li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </c:if>
            <div id="hide">
                <c:if test="${ages.size() != 0}">
                    <div id="age" class="row" value="年龄" style="text-align: left;padding-left: 10px;">
                        <div class="col-md-2 col-sm-2 col-xs-2" style="margin-right: 0;">
                            <h5 style="color: black;">年龄：</h5>
                        </div>
                        <div class="col-md-9 col-sm-9 col-xs-9 row" style="padding-left: 0;">
                            <ul class="choice">
                                <c:forEach var="age" items="${ages}">
                                    <li value="age">${age}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </c:if>
                <c:if test="${diplomas.size() != 0}">
                    <div id="diploma" class="row" value="学历" style="text-align: left;padding-left: 10px;">
                        <div class="col-md-2 col-sm-2 col-xs-2" style="margin-right: 0;">
                            <h5 style="color: black;">学历：</h5>
                        </div>
                        <div class="col-md-9 col-sm-9 col-xs-9 row" style="padding-left: 0;">
                            <ul class="choice">
                                <c:forEach var="diploma" items="${diplomas}">
                                    <li value="diploma">${diploma}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </c:if>
                <c:if test="${titles.size() != 0}">
                    <div id="title" class="row" value="资格证" style="text-align: left;padding-left: 10px;">
                        <div class="col-md-2 col-sm-2 col-xs-2" style="margin-right: 0;">
                            <h5 style="color: black;">资格证：</h5>
                        </div>
                        <div class="col-md-9 col-sm-9 col-xs-9 row" style="padding-left: 0;">
                            <ul class="choice">
                                <c:forEach var="title" items="${titles}">
                                    <li value="title">${title}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </c:if>
            </div>
            <div id="more" class="row more">
                <div class="col-md-5 col-sm-5 col-xs-5" style="border-top: groove;border-width: 1px;"></div>
                <div class="col-md-2 col-sm-2 col-xs-2" style="border-bottom: groove;border-left: groove;border-right: groove;border-width: 1px;">
                    <ul>
                        <li id="showBtn">更多选项</li>
                    </ul>
                </div>
                <div class="col-md-5 col-sm-5 col-xs-5" style="border-top: groove;border-width: 1px;"></div>
            </div>
            <div style="height: 10px;"></div>
        </div>
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
    </div>
    <div class="row">
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
        <div class="col-md-8 col-sm-8 col-xs-8 dbg">
            <h3 style="text-align: left;margin-left: 20px;">名师风采</h3>
            <hr style="width: 100%;" />
            <div class="row" id="images" style="margin-left: 5px;margin-right: 5px;margin-top: 20px;text-align: center;">
                <ul>
                    <c:forEach var="teacher" items="${teacherList}">
                        <li onclick="toTeacher('/isp/toTeacher?id=${teacher.id}')">
                            <div class="col-md-3 col-sm-3 col-xs-3 img">
                                <img style="width: 100%;height: 120px;" src="${teacher.image}" />
                                <h4>${teacher.name}</h4>
                            </div>
                        </li>
                    </c:forEach>
                    <c:if test="${teacherList.size() == 0}">
                        <li><h3>没有数据</h3></li>
                    </c:if>
                </ul>
            </div>
            <div style="height: 10px;"></div>
        </div>
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
    </div>
    <script type="text/javascript">
        var url = "/isp/teachers?";

        <c:forEach var="choosed" items="${choosed}">
            <c:if test="${choosed.value != null}">
                if(url != "/isp/teachers?") {
                    url += "&";
                }
                li = "<li value=\"${choosed.name}\">" + $("#${choosed.name}").attr("value") + "：" + ${choosed.value}
                    + " <span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\" style=\"font-size: 10px;color: red;\"></span></li>";
                $("#choosed").append(li);
                $("#${choosed.name}").css("display","none");
                url += "${choosed.name}=${choosed.value}";
            </c:if>
        </c:forEach>

        $("#hide").css("display","none");

        if($("#region").css("display") == "none" && $("#level").css("display") == "none" && $("#subject").css("display") == "none" ){
            $("#hide").css("display","block");
            $("#showBtn").html("收起");
            $("#more").css("display","none");
        }
        if($("#age").css("display") == "none" && $("#diploma").css("display") == "none" && $("#title").css("display") == "none" ) {
            $("#more").css("display", "none");
        }
        if($("#region").css("display") == "block" || $("#level").css("display") == "block" || $("#subject").css("display") == "block" ) {
            $("#more").css("display", "block");
        }

        $("#showBtn").click(function(){
            if($("#showBtn").text() == "更多选项"){
                $("#hide").css("display","block");
                $("#showBtn").html("收起");
            }else{
                $("#hide").css("display","none");
                $("#showBtn").html("更多选项");
            }
        });
        $(".choice").on("click","li",function(){
            if(url != "/isp/teachers?") {
                url += "&";
            }
            url += $(this).attr("value") + "='" + $(this).text() + "'";
            window.location.href = url;
        });
        $(".choosed").on("click","li",function(){
            var id = $(this).attr("value");
            var urls = url.split("?");
            urls = urls[1].split("&");
            var index = -1;
            for(var i=0; i<urls.length; i++){
                if(urls[i].search(id) != -1){
                    index = i;
                    break;
                }
            }
            urls.splice(index, 1);
            url = "/isp/teachers?" + urls.join("&");
            window.location.href = url;
        });

        function toTeacher(link) {
            window.location.href = link;
        }

    </script>

</body>
</html>
