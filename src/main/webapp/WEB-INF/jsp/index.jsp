<%--
  Created by IntelliJ IDEA.
  User: geminit
  Date: 2017/9/7
  Time: 下午10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GB2312" language="java" %>
<html>
    <head>
        <title>成都市龙泉驿区教育局民办教育ISP</title>
        <script src="/js/jquery-2.1.4.js"></script>
        <script src="/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <h1>${content}</h1>
                <p id="chg">这是一个超大屏幕（Jumbotron）的实例。</p>
                <p><input id="input"></p>
                <p><a class="btn btn-primary btn-lg" role="button" id="btn">
                    学习更多</a>
                </p>
            </div>
        </div>

        <script type="text/javascript">

            var name = "This page is made by ${name}!";
            $("#chg").html(name);

            $("#btn").click(
                function(){
                    var str = {};
                    str["input"] = document.getElementById("input").value;
                    $.ajax({
                        type : 'POST',
                        async : false,
                        url : '/isp/index/demo',
                        data : str,
                        success : function(result){
                            alert(result);
                        },
                        error : function(result){
                            alert("fail");
                        }
                    });
                }
            );
        </script>
    </body>
</html>
