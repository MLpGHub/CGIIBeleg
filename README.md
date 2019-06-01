# CGIIBeleg
Hier wird die Fertigstellung unseres Beleges für das Modul Computergrafik II realisiert.

## Notizen für die Umsetzung des Beleges
* Wichtiger Punkt: Sobald zwei Objekte/Vögel übereinander sind (exakt, dist=0), ergibt der berechnete Seperations-Vektor (0, 0, 0), womit auch keine Seperation mehr stattfinden kann.
* UPDATE: Problem scheinbar gefixt. Lösung im nächsten Absatz

## Lösung für DAS PROBLEM ;-)

Ich habe mal die Partikelsimulation 10 von Marco (vollständiges Schwarmverhalten mit Maus) auf unser Projekt geportet, um zu sehen, ob irgendetwas in unseren Berechungsklassen komisch ist. Es hat grundlegend funktioniert und sieht auch dem aus dem ursprünglichen Projekt sehr ähnlich. [1] Die Lösung für unseren Beleg war nun, die Parameter einfach zu ändern. Die Distanz zwischen Punkten (der Abstand, in dem gesucht wird) darf nicht so groß sein, sonst entsteht ein Gittermuster. Außerdem darf die maximale Geschwindigkeit nicht zu niedrig sein. Die Geschwindigkeit wird bei der Berechnung (Schwarmverhalten::update()) auch nicht ins Intervall eingepasst, sondern immer auf die maximale Geschwindigkeit gesetzt. So fliegt ein Vogel eben auch mal über seine Zielgeschwindigkeit hinaus. :-)

Je niedriger man die Geschwindigkeit dann wählt, desto mehr ordnen sich die Objekte als Raster (eben unser Fehler). Das hat auch den Nachteil, dass die Vögel immer ganz schön umherschwirren und sich nicht mal ruhig mit dem Wind treiben lassen. :-) Vielleicht finden wir dafür noch eine Lösung.

Uns bleibt also letztendlich nur noch, die Parameter etwas anzupassen, das Modell richtig zu laden (bzw. die Rotation der Dreiecke hinzubekommen) und am Ende alles mal in den Shader zu packen. Klingt doch machbar, oder? ;-)

[1] Marco berechnet in den drei Funktionen zum Schwarmverhalten die normierten Vektoren über LineareAlgebra.normalize. Die Funktionssignatur ist aber `public Vektor3D normalize(Vektor3D v)`, d.h. es wird der normierte Vektor zurückgegeben, den er jedoch nicht abfängt und speichert. Streng genommen wird also gar ncht normiert, was nur zu Verwirrung führen kann. ;-)

## Aufgabenstellung

Die Aufgabenstellung findet sich in der Datei "Belegaufgaben.pdf".

## Anmerkungen

Das Projekt ShaderPractice lässt sich momentan noch nicht ausführen, was mit der installierten bzw. eingestellten JRE-Version zusammenhängt. Unter Workspace -> Preferences -> Java lassen sich die installierten JREs einrichten. An dieser Stelle muss systemspezifisch eine JRE-Version 1.8 oder 8 eingestellt werden, damit das Projekt fehlerfrei kompiliert werden kann.
