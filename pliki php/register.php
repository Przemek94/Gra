<?php 
require "conn.php";
$username = $_POST["username"];
$email = $_POST["email"];
$password = $_POST["password"];
$mysql_qry = "insert into players_data (username, email, password) values ('$username', '$email', '$password')";

if($conn->query($mysql_qry) === TRUE) {
echo "OK";
}
else {
echo "Error";
}
$conn->close();
?>