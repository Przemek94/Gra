
<?php
require "conn.php";
$sql = "SELECT * FROM `players_data` ";

$result = mysqli_query($conn ,$sql);

$response = array();
while($row = mysqli_fetch_array($result));
{
array_push($response,array("id"=>$row[0],"username"=>$row[1]));
	
}

echo json_encode(array("server_response"=>$response));

mysqli_close($conn);
?>