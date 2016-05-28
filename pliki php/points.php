<?php 
require "conn.php";
$username = $_POST["username"];
$points = $_POST["points"];
$mysql_qry = "UPDATE punkty SET points = GREATEST(points, '$points') WHERE username = '$username'";


if($conn->query($mysql_qry) === TRUE) {
echo "Save";
}
else {
echo "Error";
}
$conn->close();
?>
