# CGIIBeleg
Hier wird die Fertigstellung unseres Beleges für das Modul Computergrafik II realisiert.

## Notizen für die Umsetzung des Beleges
* Sowohl Marco als auch der Student von '17 arbeiten mit der Fenstergröße als Berechnungsgrundlage und einer Orthografischen Projektion zur Darstellung.
* min\_speed könnte zwar für die "Zufälligkeit" (keine Hex-Raster) nützlich sein, bewirkt in der Praxis derzeit abe rscheinabr eine Aufhebung des Schwarmverhaltens.
* Wichtiger Punkt: Sobald zwei Objekte/Vögel übereinander sind (exakt, dist=0), ergibt der berechnete Seperations-Vektor (0, 0, 0), womit auch keine Seperation mehr stattfinden kann.
* Lösung kann evtl. sein, alles auf Fensterbreite und -höhe umzubauen. Theoretisch sollte es aber auch mit dem OpenGL-Bereich funktionieren.

* UPDATE: Code jetzt auf Lösung mit Displaygröße angepasst. Schwarmverhalten funktioniert irgendwie noch nicht. Ansonsten passt's aber erstmal.
	* Code muss auf jeden Fall noch aufgeräumt werden! (zB überschüssige Variablen weg)
	* evtl. update() gleich in BeweglichesObjekt programmieren
	* Vorteil: größere Zahlen, leichter anpassbar (von den Zahlenwerten her)


## Aufgabenstellung

Die Aufgabenstellung findet sich in der Datei "Belegaufgaben.pdf".

## Anmerkungen

Das Projekt ShaderPractice lässt sich momentan noch nicht ausführen, was mit der installierten bzw. eingestellten JRE-Version zusammenhängt. Unter Workspace -> Preferences -> Java lassen sich die installierten JREs einrichten. An dieser Stelle muss systemspezifisch eine JRE-Version 1.8 oder 8 eingestellt werden, damit das Projekt fehlerfrei kompiliert werden kann.
