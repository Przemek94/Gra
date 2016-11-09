<?php 
require "conn.php";
$username = $_POST["username"];
$password = $_POST["password"];
$mysql_qry = "insert into users (username, password) values ('$username', '$password')";

if($conn->query($mysql_qry) === TRUE) {
echo "OK";
}
else {
echo "Error";
}
$conn->close();
?>