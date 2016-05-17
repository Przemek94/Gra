# Gra
###Jakie to Rapsy?

Specyfikacja

Platforma: Android

Środowisko programistyczne: Android Studio

Język: Java, XML



##Plan projektu:

1.Ekran powitalny i szkic każdego z Activity(Menu Główne, Gra, Pomoc, Najlepszy Wynik)	11.03.16

2.Stworzenie jednego pytania sprawdzającego poprawność odpowiedzi	18.03.16

3.Rozszerzenie bazy pytań	01.04.16

4.Zakodowanie losowości pytań bez możliwości powtarzania się ich w jednej grze	08.03.16

5.Dodanie wskaźnika upływu czasu 15.04.16

6.Dodanie systemu punktacji 22.04.16

7.Napisanie mechanizmu który będzie zapobiegal wyzerowaniu się najlepszego wyniku po zamkniciu gry. 29.04.16

8.Stworzenie bazy danych do której będzie możliwość zapisania swojego wyniku podając swój nick. 13.05.16

9.Stworzenie bazy danych w mySQL. 20.05.16

10.Dopracowanie bazy danych oraz przeniesienie je z localhostu na serwer ogólnodostępny. 27.05.16

11.Zamiana dotychczasowego wskaźnika upływu czasu na bardziej rozbudowany. 03.06.16

12.Stworzenie ostatecznego layoutu gry. 17.06.16

13.Dodanie bonusowego poziomu który odblokuje się po zdobyciu określonej liczby punktów 27.06.16

14.Testowanie poprawa błędów




##Użyte tuoriale/poradniki


Android Kurs części od 1 do 14.
https://www.youtube.com/user/PjakProgramowanie/videos

Zmiana koloru przycisku po ich kliknięciu:
https://www.youtube.com/watch?v=IgbGeOIPu8w

Sposób zapisu kolorów w plikach javy
http://developer.android.com/reference/android/graphics/Color.html

Losowe otwarcie się activity
http://stackoverflow.com/questions/29579158/open-random-activities-when-button-is-clicked


Dodanie upywu czasu
https://www.youtube.com/watch?v=ZqqP69rJVmg

Dodanie systemu punktacji:

http://stackoverflow.com/questions/7074097/how-to-pass-integer-from-one-activity-to-another

https://www.youtube.com/watch?v=nRIup_VvFOQ&nohtml5=False

https://www.youtube.com/watch?v=b885jtjA-YQ

Zapamiętywanie najlepszego wyniku: https://www.youtube.com/watch?v=b4qmpxaNiUQ

Tworzenie bazy danych offline: 

https://www.youtube.com/watch?v=cp2rL3sAFmI Części od 1 do 5

http://stackoverflow.com/questions/818677/android-order-by-in-query Sortowanie wyników od największych

Tworzenie bazy danych w mySQL:

https://www.youtube.com/watch?v=cp2rL3sAFmI Czści od 1 do 4

Pobieranie danych z bazy:

https://www.youtube.com/watch?v=uFbwW4ERUN0


##Uwagi

Po dodaniu czasu do gry stwierdziłem, że pauza w grze będzie nie potrzebna, za to pojawila się potrzeba napisania mechanizmu który po zamnięciu gry nie będzie usuwal zmiennej która przechowuje najlepszy wynik.

Okazało się że baza danych którą stworzyłem może być dostępna tylko na urządzeniu. Dlatego stworzyłem nową bazę danych w mySQL narazie na localhost którą będę dopracowywać oraz przeniosą ją na ogólnodostępny serwer. Być może stara baza danych zostanie dlagrachy offline. 
