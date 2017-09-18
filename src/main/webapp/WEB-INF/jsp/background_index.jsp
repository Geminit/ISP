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
                <div class="col-md-3" id="colum1">
                    <%--师资力量总体--%>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-md-4" style="text-align: center">
                                <span class="glyphicon glyphicon-search" aria-hidden="true" style="position:relative;top: 10px;"></span>
                            </div>
                            <div class="col-md-8">
                                <div class="col-md-12" style="text-align: center">
                                    <label style="font-size: 30px; color: gray">${teacherRateString}%</label>
                                </div>
                                <div class="col-md-12" style="text-align: center">
                                    <span style="font-size: 13px">师资力量总体</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--教师总人数--%>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-md-4" style="text-align: center">
                                <span class="glyphicon glyphicon-user" aria-hidden="true" style="position:relative;top: 10px;"></span>
                            </div>
                            <div class="col-md-8">
                                <div class="col-md-12" style="text-align: center">
                                    <label style="font-size: 30px; color: gray">${reallyTeacherNumber}</label>
                                </div>
                                <div class="col-md-12" style="text-align: center">
                                    <span style="font-size: 13px">教师总人数</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--学校总数--%>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-md-4" style="text-align: center">
                                <span class="glyphicon glyphicon-blackboard" aria-hidden="true" style="position:relative;top: 10px;"></span>
                            </div>
                            <div class="col-md-8">
                                <div class="col-md-12" style="text-align: center">
                                    <label style="font-size: 30px; color: gray">${schoolNumber}</label>
                                </div>
                                <div class="col-md-12" style="text-align: center">
                                    <span style="font-size: 13px">学校总数</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6" id="colum2">
                    <div class="panel panel-default">
                        <div class="panel-body" style="height: 240px" id="teacher-change"></div>
                    </div>
                </div>
                <div class="col-md-3" id="colum3">
                    <%--小学升学率--%>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-md-4" style="text-align: center; height: 110px; top: 20px;">
                                <span class="glyphicon glyphicon-education" aria-hidden="true" style="position:relative;top: 10px;"></span>
                            </div>
                            <div class="col-md-8" style="top: 20px">
                                <div class="col-md-12" style="text-align: center">
                                    <label style="font-size: 30px; color: gray">${graduateRateString}%</label>
                                </div>
                                <div class="col-md-12" style="text-align: center">
                                    <span style="font-size: 13px">小升初中升学率</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--小学教师数--%>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-md-4" style="text-align: center; height: 110px; top: 20px;">
                                <span class="glyphicon glyphicon-user" aria-hidden="true" style="position:relative;top: 10px;"></span>
                            </div>
                            <div class="col-md-8" style="top: 20px">
                                <div class="col-md-12" style="text-align: center">
                                    <label style="font-size: 30px; color: gray">${primartTeacherNumber}</label>
                                </div>
                                <div class="col-md-12" style="text-align: center">
                                    <span style="font-size: 13px">小学教师数</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-body" id="student-percentage" style="height: 350px;"></div>
                    </div>
                </div>
                <div class="col-md-6" id="class-total">
                    <div class="panel panel-default">
                        <div class="panel-body" id="class-average" style="height: 350px;"></div>
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
        var myChart = echarts.init(document.getElementById('teacher-change'));
        var option = {
            title: {
                text: '教师人数变化',
                x: 'center',
            },
            tooltip : {
                formatter: "{a} <br/>{b} : {c}人"
            },
            xAxis:  {
                boundaryGap: false,
                data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
            },
            yAxis: {
                type: 'value',
                axisLabel: {
                    formatter: '{value} 人'
                }
            },
            series: [
                {
                    name:'教师人数变化',
                    type:'line',
                    data:eval(${teachMonth}),
                }
            ]
        };
        myChart.setOption(option);

        //小学人数占比echart
        var myChart = echarts.init(document.getElementById('student-percentage'));
        var option = {
            title : {
                text: '小学人数占比',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: eval(${schoolName}),
            },
            series : [
                {
                    name: '小学人数占比',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:eval(${primaryStudent}),
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        myChart.setOption(option);

        //平均班级人数echart
        var myChart = echarts.init(document.getElementById('class-average'));
        var option = {
            title : {
                text : '班级总数: ' + ${classNumber},
                x: 'left',
            },
            tooltip : {
                formatter: "{a} <br/>{b} : {c}人"
            },
            series: [
                {
                    name: '平均班级人数',
                    type: 'gauge',
                    detail: {formatter:'{value}人'},
                    data: [{value: ${averageNumberString}, name: '平均班级人数'}]
                }
            ]
        };
        myChart.setOption(option);
    </script>
</body>
</html>
