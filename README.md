# Geographic-Coordinates-Api
Api do zapisywania i odczytywania informacji o pozycjach geolokalizacji z urządzeń mobilnych.

![image](https://user-images.githubusercontent.com/76206945/170683398-1612a5d4-a0e4-4f29-a547-82d5ac6a8e76.png)
![image](https://user-images.githubusercontent.com/76206945/170683494-050aa62c-cbf8-4e2c-81fc-fc3957f91c93.png)
![image](https://user-images.githubusercontent.com/76206945/170683526-59ec7de4-fa90-4ee8-888c-606b52228457.png)
![image](https://user-images.githubusercontent.com/76206945/170683560-98fd1380-6e74-4a0b-974b-ddcade328c30.png)
![image](https://user-images.githubusercontent.com/76206945/170683584-789d2678-bf4f-40a4-8cd6-e5143c89200a.png)

Api przyjmuje 7 cyfrowe koordynaty o typie string. Validuje je przy pomocy annotacji @Valid oraz annotacji @Coordinates ktora validuje interface CoordinatesValidator.
W przypadku niezgodności budowy koordynatów wyrzuca exception , który przechwytuje exception advice i zwraca w responsbody wiadomość do użytkownika.
Jesli koordynaty sa poprawne, mapper zmienia ich typ na entity i zapisuje do bazy danych.
Do odczytywania koordynatow dla danego urządzenia api przyjmuje id typu int. 
Sprawdza czy w bazie danych istnieje rekord z danym id , przy użyciu annotacji @Querry w interface-sie coordinatesRepository implementującym JPARepository. Jesli odpowiedź z bazy danych jest pusta wyrzuca exception i program postępuje analogicznie jak wyżej.
Zwracanie wszystkich koordynatów po prostu zwraca całą zawartość bazy danych.
Ważniejsze momenty w działaniu programu logger SLF4J loguje do konsoli oraz do pliku logback.
Przy użyciu swaggera wyżej załączone zdjęcia prezentują nam endpointy oraz budowe coordinatesDTO.

