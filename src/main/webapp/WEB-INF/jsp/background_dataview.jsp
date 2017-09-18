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
    <link rel="stylesheet" href="/css/background_index.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <jsp:include page="background_header.jsp"></jsp:include>
    <jsp:include page="background_leftside.jsp"></jsp:include>
    <div class="content-wrapper">
        <div class="row">
            <div class="col-md-12">
                <div class="col-md-4" id="colum1">
                    <%--学校总数--%>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-md-4" style="text-align: center">
                                <span class="glyphicon glyphicon-search" aria-hidden="true" style="position:relative;top: 10px;"></span>
                            </div>
                            <div class="col-md-8">
                                <div class="col-md-12" style="text-align: center">
                                    <label style="font-size: 30px; color: gray">${school}</label>
                                </div>
                                <div class="col-md-12" style="text-align: center">
                                    <span style="font-size: 13px">学校总数</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%-->学生总数--%>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-md-4" style="text-align: center">
                                <span class="glyphicon glyphicon-user" aria-hidden="true" style="position:relative;top: 10px;"></span>
                            </div>
                            <div class="col-md-8">
                                <div class="col-md-12" style="text-align: center">
                                    <label style="font-size: 30px; color: gray">${studentNumber}</label>
                                </div>
                                <div class="col-md-12" style="text-align: center">
                                    <span style="font-size: 13px">学生总数</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--班级总数--%>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-md-4" style="text-align: center">
                                <span class="glyphicon glyphicon-blackboard" aria-hidden="true" style="position:relative;top: 10px;"></span>
                            </div>
                            <div class="col-md-8">
                                <div class="col-md-12" style="text-align: center">
                                    <label style="font-size: 30px; color: gray">${classNumber}</label>
                                </div>
                                <div class="col-md-12" style="text-align: center">
                                    <span style="font-size: 13px">班级总数</span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-md-4" style="text-align: center">
                                <span class="glyphicon glyphicon-blackboard" aria-hidden="true" style="position:relative;top: 10px;"></span>
                            </div>
                            <div class="col-md-8">
                                <div class="col-md-12" style="text-align: center">
                                    <label style="font-size: 30px; color: gray">${parent}</label>
                                </div>
                                <div class="col-md-12" style="text-align: center">
                                    <span style="font-size: 13px">家长参与总数</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-8" id="colum2">
                    <div class="panel panel-default">
                        <div class="panel-body" style="height: 330px" id="parent-focus"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-body" style="height: 260px" id="notice"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="background_footer.jsp"></jsp:include>
    <%--引入js文件--%>
    <jsp:include page="background_js.jsp"></jsp:include>
    <%--引入echart--%>
    <script src="/js/echarts.min.js"></script>
    <script>

        //教师变化人数echart
        var myChart = echarts.init(document.getElementById('parent-focus'));
        var option = {
            title : {
                text: '父母关注点',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                x : 'center',
                y : 'bottom',
                data:eval(${titledata})
            },
            calculable : true,
            series : [
                {
                    name:'父母关注点',
                    type:'pie',
                    radius : [30, 110],
                    center : ['50%', '50%'],
                    roseType : 'area',
                    data:eval(${data})
                }
            ]
        };
        myChart.setOption(option);

        //教师变化人数echart
        var myChart = echarts.init(document.getElementById('notice'));
        var option = {
            title: {
                text: '班级通知比较',
                x: 'center',
            },
            legend: {
                data:['2017年班级通知','2016年班级通知'],
                x: 'left',
            },
            tooltip : {
                formatter: "{a} <br/>{b} : {c}条"
            },
            xAxis:  {
                boundaryGap: false,
                data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
            },
            yAxis: {
                type: 'value',
                axisLabel: {
                    formatter: '{value} 条'
                }
            },
            series: [
                {
                    name:'2017年班级通知',
                    type:'line',
                    data:eval(${string2017}),
                },
                {
                    name:'2016年班级通知',
                    type:'line',
                    data:eval(${string2016}),
                }
            ],

        };
        myChart.setOption(option);
    </script>
</body>
</html>
