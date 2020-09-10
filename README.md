# M223: Punchclock
Dies ist eine Beispielapplikation für das Modul M223.

## Loslegen
Folgende Schritte befolgen um loszulegen:
1. Sicherstellen, dass JDK 12 installiert und in der Umgebungsvariable `path` definiert ist.
1. Ins Verzeichnis der Applikation wechseln und über die Kommandozeile mit `./gradlew bootRun` oder `./gradlew.bat bootRun` starten
1. Unittest mit `./gradlew test` oder `./gradlew.bat test` ausführen.
1. Ein ausführbares JAR kann mit `./gradlew bootJar` oder `./gradlew.bat bootJar` erstellt werden.

Folgende Dienste stehen während der Ausführung im Profil `dev` zur Verfügung:
- REST-Schnittstelle der Applikation: http://localhost:8081
- Dashboard der H2 Datenbank: http://localhost:8081/h2-console


## Anwendung verwenden

Leider gibt es noch kein UI. Über die REST Schnittstelle kann jedoch schon mal die Funktionalität geprüft werden.
Dazu kann Postman verwendet werden.

Beschreibung der URI

/sign-up 		Hier kann ein Benutzerkonto erzeugt werden mit Angabe von "username" : "meinname", "password" : "meinpasswort"
/login			Hier wird mit einem gültigen Konto die Anmeldung
