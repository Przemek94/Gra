<?php 
require "conn.php";
$od  = "From: serwer1643032@serwer1643032.home.pl  \r\n";
$od .= 'MIME-Version: 1.0'."\r\n";
$od .= 'Content-type: text/html; charset=iso-8859-2'."\r\n";
$adres = $_POST["email"];
$tytul = "Jakie_to_rapsy???";
$wiadomosc = "<html>
<head>
</head>
<body>
<p><strong>Elo Ziomek!!!</strong></p>
<p>Dzieki za rejestracje w mojej grze pt. 'Jakie to Rapsy???'</p>
<p>Mam nadzieje, ze gra bedzie Ci sie podobac.</p>
<p>Pozdro Przemek</p>
</body>
</html>";
$username = $_POST["username"];
$password = $_POST["password"];
$email = $_POST["email"];
$mysql_qry = "insert into users (username, password, email) values ('$username', '$password', '$email')";
$mysql_qry2 = "insert into punkty (username, points) values ('$username', '0')";


if($conn->query($mysql_qry) === TRUE) {
mail($adres, $tytul, $wiadomosc, $od);
if($conn->query($mysql_qry2) === TRUE) {
echo "OK";
}
}
else {
echo "Error";
}




$conn->close();
?>