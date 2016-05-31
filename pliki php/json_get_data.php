

<?php

$host = "serwer1643032.home.pl";
$user = "20332353_rapsy";
$password = "Przemek01$";
$db = "20332353_rapsy";

$sql = "select * from punkty order by points desc";

$con = mysqli_connect($host, $user, $password, $db);

$result = mysqli_query($con,$sql);

$response = array();

while($row = mysqli_fetch_array($result))
{
	
	array_push($response, array("username"=>$row[1], "points"=>$row[2]));
	
}

echo json_encode(array("serwer_response"=>$response));

mysqli_close($con);

?>