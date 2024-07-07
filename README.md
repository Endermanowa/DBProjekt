# DBProjekt
Wczytanie danych do bazy zajmuje dużo czasu na oryginalnych plikach z danymi, więc stworzyłam krótsze pliki "demo" dla obu magazynów, które zawierają tylko pierwsze 5 tysięcy linii danych
w springu są do wyboru dwa profile: dla danych okrojonych ("demo") oraz dla danych oryginalnych ("full")

szczegóły bazy danych z której korzysta program zawarte są w src/main/resources/application.properties
należy zmienić tam datasource.url (w którym zawarta jest nazwa bazy danych), datasource.username oraz datasource.password, tak by program korzystał z istniejącej bazy danych MS SQL

po uruchomieniu programu automatycznie odczytane zostaną pliki csv z danymi, a postęp można śledzić w konsoli IDE

przy pierwszym wyświetlaniu zadania 1 trzeba odczekać, ponieważ zostaje generowane zestawienie
zestawienie podzielone jest na strony, ponieważ przy oryginalnych danych jest tyle linii do wyświetlania, że występował długi czas między interakcją użytkownika a reakcją strony

po odczytaniu danych można w przeglądarce skorzystać z następujących REST endpoint:
- do wyświetlenia tabel:
	localhost:8080/dostawcy
	localhost:8080/slownik
	localhost:8080/magazynp
	localhost:8080/magazynw

- do zadania 1 (zestawienie dla magazynu P):
	localhost:8080/zadanie1?strona=X&liczbaElementow=X
	localhost:8080/zadanie1/sortByNrKarty?strona=X&liczbaElementow=X
	localhost:8080/zadanie1/sortByKod?strona=X&liczbaElementow=X
	localhost:8080/zadanie1/sortByFirma?strona=X&liczbaElementow=X
	(X zastąpić wybranymi wartościami)

- do zadania 2 (suma mas z magazynu P dla wybranego klienta i odpadu, z podziałem na firmy)
	localhost:8080/zadanie2?nrKlienta=X&kod=XXXXXX (X zastąpić wybranymi wartościami)

- do zadania 3 (suma mas z magazynu W dla wybranego klienta i odpadu, z podziałem na firmy)
	localhost:8080/zadanie3?nrKlienta=X&kod=XXXXXX (X zastąpić wybranymi wartościami)
