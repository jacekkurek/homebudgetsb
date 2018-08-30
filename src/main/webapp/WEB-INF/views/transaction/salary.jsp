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
                    <div class="row">
                        <form method="post">


                            <select name='username'>
                                <div class="form-group">

                                    <c:forEach items="${users}" var="user">
                                        <option value="${user.name}">${user.name}</option>
                                    </c:forEach>
                                </div>
                            </select>


                            <div class="col-sm-4">
                                <label>After</label>
                                <input name="after" type="date" class="form-control"/>
                            </div>
                            <div class="col-sm-4">
                                <label>Before</label>
                                <input name="before" type="date" class="form-control"/>
                            </div>
                            </br>

                        </form>

                    </div>
                    <button type="submit" class="btn btn-default">Find</button>
                    <c:if test="${b==1}">
                        <h1>MASZ ZA MAŁO PIENIĘDZY</h1>
                    </c:if>
                    <c:if test="${b==2}">
                        <h1>WYSTARCZY CI NA WYDATKI</h1>
                    </c:if>
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
