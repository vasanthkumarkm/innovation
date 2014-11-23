<!DOCTYPE html>
<!-- saved from url=(0077)file:///C:/Users/IBM_AD~1/AppData/Local/Temp/notes32C5CD/register_detail.html -->
<html class="ui-mobile">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--<base href="file:///C:/Users/IBM_AD~1/AppData/Local/Temp/notes32C5CD/register_detail.html">-->
<base href=".">
<title>Register Detail Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.css">
<script type="text/javascript" src="./jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="./jquery.mobile-1.0.min.js"></script>


<script type="text/javascript">
	var deviceId;
	$(document)
			.ready(
					function() {


												$.ajax({
															url : "webservices/listlocations",
															type : "GET",
															Accept : "application/json",
															async : false,
															success : function(
																	str,
																	textStatus,
																	jqXHR) {
																alert('Could not connect to backend.  Thank you.');

															},
															error : function(
																	jqXHR,
																	textStatus,
																	errorThrown) {
																alert('Could not connect to backend, contact app administrator');
															}
														});
											});



</script>
</head>
<body class="ui-mobile-viewport">


	<div data-role="page" id="mpospage" data-url="mpospage" tabindex="0"
		class="ui-page ui-body-c ui-page-active" style="min-height: 653px;">

		<div data-role="header" data-position="fixed" data-theme="b"
			class="ui-header ui-bar-b" role="banner">
			<table>
				<tr>
					<td width="10%"><img src="walmart.jpg" height="30" width="30"
						class="align-right" /></td>
					<td width="90%" align="center">
						<h1 align="center" class="ui-title" tabindex="0" role="heading"
							aria-level="1">
							<b><center>
									PARKING AREA SIMULATOR &nbsp;&nbsp;&nbsp;&nbsp;
									<center></b>
						</h1>
					</td>
					<td width="0%">&nbsp;</td>
				</tr>
			</table>
		</div>
		<!-- /header -->

		<div data-role="content" class="ui-content" role="main">
			<font face="verdana" size="1"><p></p> <b>PARKING LOCATION</b>

				<ul data-role="listview" data-inset="true" data-theme="d"
					class="ui-listview ui-listview-inset ui-corner-all ui-shadow">
					<li
						class="ui-li ui-li-static ui-body-d ui-corner-top ui-corner-bottom">
						<select id="location">
						  <option value="IBM_EGL">IBM EGL</option>
						  <option value="IBM_MANYATA">IBM Manyata</option>
						  <option value="IBM_SA">IBM SA</option>
						  <option value="IBM_DAKSH">IBM Daksh</option>
						</select>					
					</li>
				</ul>
				<ul id="parkingDetails" data-role="listview" data-inset="true"
					data-theme="d"
					class="ui-listview ui-listview-inset ui-corner-all ui-shadow">

				</ul>

				

				</ul> </font>
		</div>
		<!-- /content -->


		<div data-role="footer" data-position="fixed" data-theme="b"
			class="ui-footer ui-bar-b" role="contentinfo">
			<center>
				<button id="pay">Update</button>
			</center>

		</div>
		<!-- /footer -->


	</div>
	<!-- /page -->


</body>
</html>

