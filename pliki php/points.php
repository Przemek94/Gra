<?php 
require "conn.php";
$username = "Przemek";
$points = 1000;
$mysql_qry = "UPDATE punkty SET points = GREATEST(points, '$points') WHERE username = '$username'";


if($conn->query($mysql_qry) === TRUE) {
echo "Save";
}
else {
echo "Error";
}
$conn->close();
?>
