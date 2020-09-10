# M223: Punchclock
Dies ist eine Beispielapplikation für das Modul M223.

## Loslegen
Folgende Schritte befolgen um loszulegen:
1. Sicherstellen, dass JDK 12 installiert und in der Umgebungsvariable `path` definiert ist.
1. Ins Verzeichnis der Applikation wechseln und über die Kommandozeile mit `./gradlew bootRun` oder `./gradlew.bat bootRun` starten
1. Unittest mit `./gradlew test` oder `./gradlew.bat test` ausführen.
1. Ein ausführbares JAR kann mit `./gradlew bootJar` oder `./gradlew.bat bootJar` erstellt werden.

Folgende Dienste stehen während der Ausführung zur Verfügung:
- REST-Schnittstelle der Applikation: http://localhost:8081
- Dashboard der H2 Datenbank: http://localhost:8081/h2-console

Die H2 Datenbank läuft in Memory (:mem:punchclock)

## Anwendung verwenden

Leider gibt es noch kein vollständig funktionierendes UI. 
Benutzer Registrierung und Login möglich.
Hinzufügen von Stunden ohne Kategorie und Projekt möglicht.

Über die REST Schnittstelle kann jedoch schon mal die vollständige Funktionalität geprüft werden.

Die App erlaubt das verwalten von Kategorien, Projekte, Zeiteinträgen inklusive Projekt und Kategorie beim erstellen, sowie die Benutzerverwaltung.

Alle Funktionen sind in den jeweiligen Controllern für die Pfade kommmentiert

/entries

/category

/project

/users



