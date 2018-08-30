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
                    Table transactions
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
                        <c:forEach items="${transactions}" var="transaction">
                            <tr>
                                <td>${transaction.id}</td>
                                <td>${transaction.user.name}</td>
                                <td>${transaction.type.name}</td>
                                <td>${transaction.value}</td>
                                <td>${transaction.name}</td>
                                <td>${transaction.budget.name}</td>
                                <td>${transaction.category.name}</td>
                                <td>${transaction.subcategory.name}</td>
                                <td>${transaction.timeAdded}</td>
                                <td>${transaction.timeTransaction}</td>
                                <td>
                                    <a href="/transaction/delete/${transaction.id}">Delete</a>
                                    <span> / </span>
                                    <a href="/transaction/edit/${transaction.id}">Edit</a>
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


