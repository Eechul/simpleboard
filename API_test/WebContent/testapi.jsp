<!DOCTYPE html>
<html>
<head>
	<title>Facebook Login JavaScript Example</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="js/facebook_api.js"> </script>
</head>
<body>
	
	<h5> Facebook API login-logout</h3>
	<div class="fb-login-button" data-max-rows="1" data-size="large" 
		data-show-faces="false" data-auto-logout-link="true"  scope="email"></div>

	<div id="status"></div>
</body>
</html>