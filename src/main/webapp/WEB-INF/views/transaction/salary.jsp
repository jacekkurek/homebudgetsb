<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../tableHeader.jsp" %>

<div id="page-wrapper" style="min-height: 474px;">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Transactions Report Salary</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Form transactions
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="row">
                        <form method="post">
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <label>After</label>
                                    <input name="after" type="date" class="form-control"/>
                                </div>
                                <button type="submit" class="btn btn-default">Submit</button>
                            </div>
                            <div class="col-sm-3 form-group">
                                <div class="form-group">
                                    <label>Before</label>
                                    <input name="before" type="date" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-sm-3 form-group">
                                <div class="form-group">
                                    <label>User</label>
                                    <select name="username" class="form-control">
                                        <c:forEach items="${users}" var="user">
                                            <option value="${user.name}">${user.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Alert Styles
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <c:if test="${b==2}">
                        <div class="alert alert-success alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <h1>Wystarczy ci na wydatki.</h1>
                        </div>
                    </c:if>
                    <c:if test="${b==1}">
                        <div class="alert alert-danger alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <h1>Nie wystarczy ci pieniędzy.</h1>
                        </div>
                    </c:if>
                </div>
                <!-- .panel-body -->
            </div>
            <!-- /.panel -->
        </div>
    </div>
</div>
<!-- /#page-wrapper -->

<%@include file="../tableFooter.jsp" %>