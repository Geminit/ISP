<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Date: 2017/9/7
  Time: 下午10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GB2312" language="java" %>
<html>
    <head>
        <title>成都市教育局民办教育ISP</title>
    </head>
    <body>

        <jsp:include page="util/navigation.jsp"></jsp:include>

        <style type="text/css">
            hr {
                height:2px;
                border:none;
                border-top:2px
                solid
                #63A8EE;
            }
        </style>

        <div style="height: 15%"></div>

        <div id="mycarousel" class="carousel slide" style="height: 30%">
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner" style="color: #63A8EE;">
                <c:forEach var="list" items="${list}">
                    <div class="item <c:if test = "${list.id == 0}">active</c:if>">
                        <center><h1>${list.title}</h1><hr style="width: ${list.lenth*4}%" /><h5 style="width: ${list.lenth*4-10}%" >${list.content}</h5></center>
                    </div>
                </c:forEach>
                <!-- Controls -->
                <a class="left carousel-control" href="#mycarousel" role="button" data-slide="prev" style="background: none;">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true" style="color: #98F5FF;"></span>
                </a>
                <a class="right carousel-control" href="#mycarousel" role="button" data-slide="next" style="background: none;">
                                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true" style="color: #98F5FF;"></span>
                </a>
            </div>
        </div> <!--  body-div 完成  -->


        <div id="button" style="width: 100%;">
            <center><button class="btn btn-primary" style="width: 120px;height: 50px;background-color: #607B8B;border: none;"
                            onmouseover="this.style.backgroundColor='#6495ED';"
                            onmouseout="this.style.backgroundColor='#607B8B';">登录</button></center>
        </div>

        <script type="text/javascript">
            function jumpTo(url){
                window.location.href = url;
            }
        </script>

    </body>
</html>
