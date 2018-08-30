<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../tableHeader.jsp" %>

<div id="page-wrapper" style="min-height: 474px;">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Users</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Table users
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <table width="100%" class="table table-hover" id="dataTables-example">
                        <thead>
                        <tr>
                            <td>Id</td>
                            <td>Name</td>
                            <td>Description</td>
                            <td>Users</td>
                            <td>Akcja</td>
                        </tr>
                        </thead>
                        <c:forEach items="${budgets}" var="budget">
                            <tr>
                                <td>${budget.id}</td>
                                <td>${budget.name}</td>
                                <td>${budget.description}</td>
                                <td>
                                    <c:forEach items="${budget.users}" var="user">
                                        <span>${user.name}, </span>
                                    </c:forEach>
                                </td>
                                <td>
                                    <a href="/budget/delete/${budget.id}">Delete</a>
                                    <span> / </span>
                                    <a href="/budget/edit/${budget.id}">Edit</a>
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


