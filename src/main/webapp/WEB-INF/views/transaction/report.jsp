<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Navigation -->
<%@include file="../tableHeader.jsp" %>

<div id="page-wrapper" style="min-height: 474px;">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Transactions</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-edit fa-fw"></i> Transactions form
                </div>
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
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <label>Before</label>
                                    <input name="before" type="date" class="form-control"/>
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
                    <i class="fa fa-table fa-fw"></i> Transactions Table
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <table width="100%" class="table table-hover" id="dataTables-example">
                        <thead>
                        <tr>
                            <td>Id</td>
                            <td>User</td>
                            <td>Type</td>
                            <td>Value</td>
                            <td>Name</td>
                            <td>Budget</td>
                            <td>Category</td>
                            <td>Subcategory</td>
                            <td>Time Added</td>
                            <td>Time Transaction</td>
                            <td>Delete/Edit</td>
                        </tr>
                        </thead>
                        <c:forEach items="${reports}" var="report">
                            <tr>
                                <td>${report.id}</td>
                                <td>${report.user.name}</td>
                                <td>${report.type.name}</td>
                                <td>${report.value}</td>
                                <td>${report.name}</td>
                                <td>${report.budget.name}</td>
                                <td>${report.category.name}</td>
                                <td>${report.subcategory.name}</td>
                                <td>${report.timeAdded}</td>
                                <td>${report.timeTransaction}</td>
                                <td>
                                    <a href="/transaction/delete/${report.id}">Delete</a>
                                    <span> / </span>
                                    <a href="/transaction/edit/${report.id}">Edit</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
</div>
<!-- /#page-wrapper -->

<%@include file="../tableFooter.jsp" %>


