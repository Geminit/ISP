<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: geminit
  Date: 2017/9/21
  Time: 上午9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成都市民办教育布局结构</title>
</head>
<body>

    <jsp:include page="util/navigation.jsp"></jsp:include>

    <link rel="stylesheet" href="/css/info.css">

    <div class="row">
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
        <div class="col-md-8 col-sm-8 col-xs-8">
            <div class="row dbg" style="text-align: left;">
                <h3 style="margin-left: 30px;text-align: left;">成都市民办教育布局结构</h3>
                <hr style="width: 95%;" />
                <div id="map" class="col-md-9 col-sm-9 col-xs-9" style="height: 500px"></div>
                <div class="col-md-3 col-sm-3 col-xs-3">
                    <div class="circle" style="width: 80%;background-color: #63A8EE;">
                        <h3 id="totle" style="padding-top: 10px;padding-bottom: 10px;text-align: center">全市：${totle}所</h3>
                    </div>
                    <c:forEach var="school" items="${SchoolNumbers}">
                        <div class="circle" style="width: 80%;background-color: #63A8EE;">
                            <h3 id="${school.level}" style="padding-top: 10px;padding-bottom: 10px;text-align: center">
                                    ${school.level}：${school.number}所
                            </h3>
                        </div>
                    </c:forEach>
                </div>
                <div style="height: 30px;"></div>
            </div>
        </div>
        <div class="col-md-2 col-sm-2 col-xs-2"></div>
    </div>

    <script src="/js/echarts.min.js"></script>
    <script src="/js/chengdu.js"></script>
    <script type="text/javascript">
        var data = [];
        var max = 0;
        <c:forEach var="regionSchool" items="${regionSchoolNumbers}">
            max = ${regionSchool.number}>max?${regionSchool.number}:max;
            var map = {'name':'${regionSchool.region}', 'value':'${regionSchool.number}'};
            data.push(map);
        </c:forEach>
        var map = echarts.init(document.getElementById("map"));
        var option = {
            tooltip : {
                trigger: 'item',
                formatter : function (params,ticket,callback){
                    var name = params.name;
                    var value = params.value;
                    if(isNaN(value)){
                        value = 0;
                    }

                    setTimeout(function (){
                        callback(ticket, name + ":" + value);
                    }, 100)

                    return 'loading';
                }
            },
            visualMap: {
                show:false,
                min: 0,
                max: max,
                inRange: {
                    color: ['#313695', '#4575b4']
                }
            },
            series : [
                {
                    type: 'map',
                    mapType: 'chengdu',
                    data:data,
                    itemStyle:{
                        emphasis:{
                            label:{show:false},
                            areaColor: '#8B8B7A'
                        }
                    },
                }
            ]
        };
        map.setOption(option);
        map.on('click', function (params) {
            var region = params.name;
            var str = [];
            str["region"] = region;
            $.ajax({                    //获得各个区域的值
                type:"post",
                async: false, //同步执行
                url:"/isp/dataGet",
                data:str,
                success:function(result){
                    var str = eval(result);
                    $("#totle").html(params.name + "：" + params.value + "所");
                    for(var i = 0; i<str.length; i++){
                        $("#" + str[i].level).html(str[i].level.toString() + "：" + str[i].number.toString() + "所");
                    }
                }
            });
        });
    </script>
</body>
</html>