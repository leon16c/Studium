
# MaXx Gruppenarbeit IProg

Das Spiel "MaXx" ist ein Brettspiel für zwei Spieler, bei dem die Spieler abwechselnd ihre Spielfigur auf einem 8x8-Spielbrett bewegen. Das Spielbrett ist in Felder unterteilt, von denen jedes einen Bruch mit einem bestimmten Wert enthält. Wenn ein Spieler auf ein Feld zieht, auf dem ein Bruch liegt, kann er diesen Bruch aufnehmen und zu seinem Score hinzufügen. Der Score eines Spielers ist der gesamte Bruch, den er während des Spiels aufgenommen hat. Das Spiel endet, wenn einer der Spieler 55 Punkte oder mehr erreicht hat, und der Spieler mit den meisten Punkten gewinnt. Die Spieler können ihre Spielfigur in den vier Hauptrichtungen bewegen oder - falls sie bestimmte Bedingungen erfüllen - auch diagonal bewegen. Die Bewegungen und das Sammeln von Bruchteilen werden von der Klasse GameLogic gesteuert, während die Klasse GameUI für die grafische Darstellung des Spiels und die Eingabe der Spieler verantwortlich ist.


## Aufgabenstellung

![screenshotAufgabe](https://i.imgur.com/h3ZqP0Q.png)


## Dokumentation

### OOP-Ansatz:
verschiedene Packages:
- domain
- logic
- ui

**domain.board**  
Die Klasse Board repräsentiert das Spielbrett für das Spiel "MaXx", das aus 8x8 Feldern besteht. Die Klasse hat ein 2D-Array von Field-Objekten, das als fields bezeichnet wird, und enthält einen Konstruktor, der die randomizeAllFields()-Methode aufruft, um die Felder mit zufällig gewählten Brüchen zu belegen. Die getField()-Methode gibt das Field-Objekt an den übergebenen Koordinaten zurück. Die randomizeAllFields()-Methode initialisiert das fields-Array und setzt für jedes Feld im Array ein neues Field-Objekt mit einem zufällig generierten Bruch, der von der randomFraction()-Methode zurückgegeben wird. Die randomFraction()-Methode gibt einen zufällig generierten Bruch mit einem Zähler und Nenner zurück, deren ggT 1 ist.

**domain.coordinates**  
Die Klasse Coordinates repräsentiert die x- und y-Koordinaten eines Feldes auf dem Spielbrett. Die Klasse enthält zwei endgültige int-Felder, x und y, die die Koordinaten speichern. Der Konstruktor initialisiert die Felder x und y mit den übergebenen Werten. Die getX()- und getY()-Methoden geben die Werte der Felder x und y zurück. Die toString()-Methode gibt eine lesbare Zeichenfolge-Repräsentation der Koordinaten zurück. Die equals()-Methode vergleicht die Koordinaten mit einem anderen Coordinates-Objekt und gibt true zurück, wenn sie gleich sind, andernfalls false.

**domain.field**  
Die Klasse Field repräsentiert ein einzelnes Feld auf dem Spielbrett. Die Klasse enthält ein Fraction-Feld namens value, das den Wert des Feldes speichert, und ein boolean-Feld namens hasValue, das angibt, ob das Feld einen Wert hat. Der Konstruktor initialisiert das hasValue-Feld auf true. Die getValueString()-Methode gibt eine Zeichenfolge-Repräsentation des Bruchs im value-Feld zurück. Die setFraction()-Methode setzt das value-Feld auf den übergebenen Bruch, sofern es noch keinen Wert hat. Die getValue()-Methode gibt den Bruch im value-Feld zurück. Die hasValue()-Methode gibt das hasValue-Feld zurück. Die use()-Methode setzt das hasValue-Feld auf false.

**domain.game**  
Die Klasse Game repräsentiert das Spiel "MaXx". Die Klasse enthält ein Board-Objekt namens board, ein PlayerWhite-Objekt namens playerWhite und ein PlayerBlack-Objekt namens playerBlack, die die beiden Spieler des Spiels repräsentieren, und ein Player-Objekt namens currentPlayer, das den aktuellen Spieler repräsentiert. Der Konstruktor initialisiert das board-Feld mit einem neuen Board-Objekt, erstellt die Spieler mit der createPlayers()-Methode und setzt currentPlayer auf playerWhite. Die createPlayers()-Methode initialisiert playerWhite und playerBlack mit neuen PlayerWhite- und PlayerBlack-Objekten und setzt für jeden Spieler zufällige Startkoordinaten auf dem Brett, die nicht gleich sind. Die getBoard()-, getCurrentPlayer()-, getPlayerWhite()- und getPlayerBlack()-Methoden geben das entsprechende Feld zurück. Die isWhitesTurn()-Methode gibt true zurück, wenn currentPlayer playerWhite entspricht, andernfalls false. Die switchCurrentPlayer()-Methode wechselt den aktuellen Spieler von playerWhite zu playerBlack oder umgekehrt.

**domain.move**  
Die Klasse Move repräsentiert einen Zug eines Spielers. Die Klasse enthält ein Player-Objekt namens player, das den Spieler repräsentiert, der den Zug macht, und zwei Coordinates-Objekte namens startCoords und endCoords, die die Start- und Endkoordinaten des Zugs repräsentieren. Der Konstruktor initialisiert die Felder player, startCoords und endCoords mit den übergebenen Werten. Die getPlayer(), getStartCoords() und getEndCoords()-Methoden geben die entsprechenden Felder zurück.

**domain.player**  
Die Klasse Player repräsentiert einen Spieler in dem 2-Personen-Spiel "MaXx". Sie enthält eine Liste von Bruch-Werten, die das aktuelle Punkteverhältnis des Spielers darstellen, sowie die aktuellen Koordinaten des Spielers auf dem Spielbrett. Die Methoden getScore() und absorbFraction() dienen dazu, das aktuelle Punkteverhältnis des Spielers zu verwalten. Die Methoden getCurrentCoords() und setCurrentCoords() dienen dazu, die aktuellen Koordinaten des Spielers zu setzen oder zu erhalten. Die equals()-Methode vergleicht den Spieler mit einem anderen Player-Objekt und gibt true zurück, wenn sie gleich sind, andernfalls false. Die toString()-Methode gibt eine lesbare Zeichenfolge-Repräsentation des Spielers zurück. Die abgeleiteten Klassen PlayerWhite und PlayerBlack überschreiben alle Methoden der Basisklasse, um die spezifische Farbe des Spielers zu setzen und um sicher zu stellen, dass die Methoden der Basisklasse korrekt aufgerufen werden.

**domain.playerwhite und domain.playerblack**  
Die Klassen PlayerBlack und PlayerWhite sind abgeleitete Klassen von Player. PlayerBlack setzt die Eigenschaft color auf "B", während PlayerWhite sie auf "W" setzt. Ansonsten überschreiben diese Klassen alle Methoden ihrer Basisklasse, ohne sie zu ändern, indem sie die Implementierung der Basisklasse aufrufen. Diese Klassen sind wahrscheinlich in den späteren Erweiterungen des Spiels nützlich, um spezifische Funktionalitäten für bestimmte Spielertypen bereitzustellen.

**logic.gamelogic**  
Die Klasse GameLogic enthält Methoden, die für das Spiel "MaXx" benötigt werden. Die processMove()-Methode verarbeitet eine Eingabe, die angibt, in welche Richtung sich der Spieler bewegen möchte, und ruft dann die makeMove()-Methode auf, um den Zug auszuführen. Die makeMove()-Methode überprüft, ob der Zug gültig ist und führt ihn dann durch, indem sie das aktuelle Feld des Spielers auf das Zielfeld verschiebt und gegebenenfalls einen Bruch vom Zielfeld aufnimmt. Die endGameIfWinner()-Methode überprüft, ob einer der beiden Spieler genügend Punkte gesammelt hat, um das Spiel zu gewinnen, und gibt dann eine Nachricht aus, wer gewonnen hat.

**ui.gameui**  
Die Klasse GameUI dient dazu, das Spiel und dessen Elemente auf der Benutzeroberfläche darzustellen. Sie enthält Methoden zum Ausgeben möglicher Züge, des Spielbretts und der Punktestände der beiden Spieler. Die printBoard()-Methode gibt das aktuelle Spielbrett aus, indem sie das 2D-Array von Field-Objekten durchläuft und die Darstellung von Feldern ohne Bruch, mit Bruch und mit den Spielern unterscheidet. Die printScores()-Methode gibt die Punktestände der beiden Spieler aus. Die printPossibleMoves()-Methode gibt an, wer am Zug ist und welche Züge möglich sind.

**ui.inputprocessor**  
Die Klasse InputProcessor ist für die Verarbeitung von Eingaben während des Spiels verantwortlich. Sie enthält eine Endlosschleife, in der sie die Eingabe des Benutzers entgegennimmt, an gameLogic.processMove() übergibt und danach überprüft, ob das Spiel beendet werden muss. Wenn das der Fall ist, wird die Schleife beendet und das Spiel beendet. Sie nutzt auch die GameUI-Klasse, um das Spielbrett, die Punktestände und mögliche Züge auszugeben.

**main**  
Das Hauptprogramm für das Spiel "MaXx". Es erstellt ein Game-Objekt, welches das Spiel repräsentiert, ein GameLogic-Objekt, welches für das Verarbeiten von Zügen und das Ermitteln von Gewinnern zuständig ist, ein GameUI-Objekt, welches für die Ausgabe von Informationen an den Benutzer zuständig ist, und schließlich ein InputProcessor-Objekt, welches für das Verarbeiten von Benutzereingaben zuständig ist. Dann wird die Methode processInput() von InputProcessor aufgerufen und das Programm läuft.
