<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: geminit
  Date: 2017/9/15
  Time: 上午12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通知公告</title>
</head>
<body>

    <jsp:include page="util/navigation.jsp"></jsp:include>

    <link rel="stylesheet" href="/css/info.css">

    <div class="row">
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
        <div class="col-md-8 col-sm-8 col-xs-8">
            <div class="dbg">
                <div class="content">
                    <h3>通知公告
                        <span class="glyphicon glyphicon-chevron-down" aria-hidden="true" style="font-size: 15px;"></span>
                    </h3>
                </div>
                <c:forEach var="notice" items="${noticesList}">
                    <hr style="width: 95%;" />
                    <div class="content">
                        <h5><a class="la" href="/isp/toNotice?id=${notice.noticeId}">${notice.noticeTitle}</a></h5>
                    </div>
                </c:forEach>
                <c:if test="${noticesList == [] }">
                    <hr style="width: 95%;" />
                    <div class="content">
                        <h5>暂无数据</h5>
                    </div>
                </c:if>
                <ul class="pagination" style="margin-bottom: 5px;">
                    <c:if test="${page != 1}">
                        <li><a style="height:35px; font-size: 15px;" href="/isp/toNotices?page=1">&laquo;</a></li>
                        <li><a style="height: 35px;" href="/isp/toNotices?page=${page-1}">&lt;</a></li>
                    </c:if>
                    <c:if test="${page == 1}">
                        <li><a style="height:35px; font-size: 15px;">&laquo;</a></li>
                        <li><a style="height: 35px;">&lt;</a></li>
                    </c:if>
                    <li>
                        <a style="height: 35px;">
                            第
                            <input id="pageInput" value="1" onchange="toPage()" style="width: 30px;color: #000000;text-align: center;" />
                            页／共${pages}页
                        </a>
                    </li>
                    <c:if test="${page != pages}">
                        <li><a style="height:35px; font-size: 15px;" href="isp/toNotices?page=${page+1}">&gt;</a></li>
                        <li><a style="height: 35px;" href="/isp/toNotices?page=${pages}">&raquo;</a></li>
                    </c:if>
                    <c:if test="${page == pages}">
                        <li><a style="height:35px; font-size: 15px;">&gt;</a></li>
                        <li><a style="height: 35px;">&raquo;</a></li>
                    </c:if>
                    <li class="disabled">
                        <a style="height: 35px;" href="#">
                            检索到${totle}条记录，显示
                            <c:if test="${noticesList.size() == 0}">
                                0
                            </c:if>
                            <c:if test="${pages == 1}">
                                第 1 - ${noticesList.size()}
                            </c:if>
                            <c:if test="${pages > 1}">
                                第 ${(page-1)*10+1} - ${(page-1)*10+noticesList.size()}
                            </c:if>
                            条记录
                        </a>
                    </li>
                </ul>
                <div style="height: 10px;"></div>
            </div>
        </div>
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
    </div>

    <script type="text/javascript">
        function toPage() {
            var pageinput = document.getElementById("pageInput").value;
            if(pageinput < 1 || pageinput > ${pages}){
                alert("没有此页！");
            }else{
                var str = {};
                str["page"] = ${page};
                $.ajax({
                    type : 'POST',
                    async : false,
                    url : '/isp/toNotices',
                    data : str,
                })
            }
        };
    </script>

</body>
</html>
