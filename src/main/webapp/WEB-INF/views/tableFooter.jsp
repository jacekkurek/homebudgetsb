<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="<c:out value='/vendor/jquery/jquery.min.js'/>"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:out value='/vendor/bootstrap/js/bootstrap.min.js'/>"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<c:out value='/vendor/metisMenu/metisMenu.min.js'/>"></script>

<!-- DataTables JavaScript -->
<script src="<c:out value='/vendor/datatables/js/jquery.dataTables.min.js'/>"></script>
<script src="<c:out value='/vendor/datatables-plugins/dataTables.bootstrap.min.js'/>"></script>
<script src="<c:out value='/vendor/datatables-responsive/dataTables.responsive.js'/>"></script>

<!-- Custom Theme JavaScript -->
<script src="<c:out value='/dist/js/sb-admin-2.js'/>"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
</script>

</body>

</html>