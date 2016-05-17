
<?php
require "conn.php";
$sql = "SELECT * FROM `punktacja` ";

$result = mysqli_query($conn ,$sql);

$response = array();
while($row = mysqli_fetch_array($result));
{
array_push($response,array("punkty"=>$row["punkty"],"username"=>$row["username"]));
	
}

echo json_encode(array("server_response"=>$response));

mysqli_close($conn);
?>