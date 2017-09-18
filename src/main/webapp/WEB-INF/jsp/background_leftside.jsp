<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2017/9/12
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">导航栏</li>
            <li class="active treeview menu-open">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>数据总览</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/manage/index"><i class="fa fa-circle-o"></i>学校数据</a></li>
                    <li><a href="/manage/dataview"><i class="fa fa-circle-o"></i>校外数据</a></li>
                </ul>
            </li>
            <li class="active treeview menu-open">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span>校园管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/class/index?page=1"><i class="fa fa-circle-o"></i>班级管理</a></li>
                    <li><a href="/grade/index?page=1"><i class="fa fa-circle-o"></i>年级管理</a></li>
                    <li><a href="/infotype/index?page=1"><i class="fa fa-circle-o"></i>变更类型管理</a></li>
                    <li><a href="/license/index?page=1"><i class="fa fa-circle-o"></i>资质管理</a></li>
                    <li><a href="/notice/index?page=1"><i class="fa fa-circle-o"></i>通知管理</a></li>
                    <li><a href="/parent/index?page=1"><i class="fa fa-circle-o"></i>父母关注点管理</a></li>
                    <li><a href="/region/index?page=1"><i class="fa fa-circle-o"></i>区域管理</a></li>
                    <li><a href="/school/index?page=1"><i class="fa fa-circle-o"></i>学校管理</a></li>
                    <li><a href="/schoolInfoRecord/index?page=1"><i class="fa fa-circle-o"></i>学校信息管理</a></li>
                    <li><a href="/schoollevel/index?page=1"><i class="fa fa-circle-o"></i>学校层次管理</a></li>
                    <li><a href="/story/index?page=1"><i class="fa fa-circle-o"></i>教师事迹管理</a></li>
                    <li><a href="/subject/index?page=1"><i class="fa fa-circle-o"></i>科目管理</a></li>
                    <li><a href="/teacher/index?page=1"><i class="fa fa-circle-o"></i>教师管理</a></li>
                    <li><a href="/title/index?page=1"><i class="fa fa-circle-o"></i>职称管理</a></li>
                </ul>
            </li>
            <li class="active treeview menu-open">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>系统管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/user/index?page=1"><i class="fa fa-circle-o"></i>用户管理</a></li>
                </ul>
            </li>
        </ul>
    </section>
</aside>
