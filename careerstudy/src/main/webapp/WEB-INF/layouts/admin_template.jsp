<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<tiles:insertAttribute name="header" />
		<!-- jQuery -->
		<script src="/vendor/jquery/jquery.min.js"></script>
	</head>
	<body>
		<div id="wrapper">
			 <tiles:insertAttribute name="menu" />
			 <tiles:insertAttribute name="body" />
		</div>
		<!-- /#wrapper -->
		
		
		
		<!-- Bootstrap Core JavaScript -->
		<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
		
		<!-- Metis Menu Plugin JavaScript -->
		<script src="/vendor/metisMenu/metisMenu.min.js"></script>
		
		<!-- Custom Theme JavaScript -->
		<script src="/dist/js/sb-admin-2.js"></script>
	    
		<!-- DataTables JavaScript -->
	   <script src="/vendor/datatables/js/jquery.dataTables.min.js"></script>
	   <script src="/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	   <script src="/vendor/datatables-responsive/dataTables.responsive.js"></script>
 	   <script>
		 $(document).ready(function() {
		     $('#dataTables-example').DataTable({
		         responsive: true
		     });
		 });
	   </script>
	</body>
</html>
