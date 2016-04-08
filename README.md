# Gra
Jakie to Rapsy?
Specyfikacja
Platforma: Android
Środowisko programistyczne: Android Studio
Język: Java, XML

Plan projektu:
1)	Ekran powitalny i szkic każdego z Activity(Menu Główne, Gra, Pomoc, Najlepszy Wynik)	11.03.16
2)	Stworzenie jednego pytania sprawdzającego poprawność odpowiedzi	18.03.16
3)	Rozszerzenie bazy pytań	01.04.16
4)	Zakodowanie losowości pytań bez możliwości powtarzania się ich w jednej grze	08.03.16
5)	Dodanie wskaźnika upływu czasu
6)	Dodanie pauzy
7)	Dodanie systemu punktacji
8)	 Stworzenie ostatecznego layoutu gry
9)	Testowanie poprawa błędów


Błędy i problemy powstałe podczas tworzenia aplikacji

1.	Nie właściwa zmiana kolorów przycisków odpowiedzi podczas gdy użytkownik po rozegraniu jednej gry próbował włączyć ją drugi raz. Kolory  wszystkich przycisków zmieniały się na czerwony lub zielony, zamiast pozostać niebieskie.

Rozwiązanie:
Dodanie kodu który za każdym uruchomieniem gry zamieniał kolor przycisków na niebieski.
        b5.setBackgroundColor(0xff2BBCEC);
        b2.setBackgroundColor(0xff2BBCEC);
        b3.setBackgroundColor(0xff2BBCEC);
        b4.setBackgroundColor(0xff2BBCEC);

2.	Ciągłe granie muzyki po wyjściu z aplikacji bez zamykania jej procesu.
Rozwiązanie:
Dodanie metody:

@Override
    public void onPause() {
        super.onPause();
        finish();

    }
Dzięki temu aplikacja zwalnia wszystkie zasoby po wyłączeniu się dzięki czemu muzyka przestaje grać.

3.	Po wciśnięciu przycisku odpowiedzi gra otwierała na nowo Menu zamiast się do niego cofać.
Rozwiązanie:
Należało użyć metody finish() zamiast:
Intent intent = new Intent("com.example.ziom.jtr.MainActivity");
startActivity(intent);

4.	Kilka błędów powstałych w wyniku złego nazewnictwa plików graficznych i dźwiękowych.



Użyte tuoriale/poradniki


Android Kurs części od 1 do 14.
https://www.youtube.com/user/PjakProgramowanie/videos

Zmiana koloru przycisku po ich kliknięciu:
https://www.youtube.com/watch?v=IgbGeOIPu8w

Sposób zapisu kolorów w plikach javy
http://developer.android.com/reference/android/graphics/Color.html

Losowe otwarcie się activity
http://stackoverflow.com/questions/29579158/open-random-activities-when-button-is-clicked
