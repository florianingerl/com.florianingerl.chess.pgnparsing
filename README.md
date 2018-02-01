# com.florianingerl.chess.pgnparsing

## Purpose of this project
The purpose of this project is to test the ["CaptureTree"](https://github.com/florianingerl/com.florianingerl.util.regex#capture-trees)-feature of the `com.florianingerl.util.regex`-library and its usefulness in parsing recursive constructs such as chess pgn files.

## What this program does?
Several pgn files are parsed using the regex in [pgn.regex](src/main/resources/pgn.regex). After parsing, the so-called "CaptureTree" is printed to the console.


## How to run the program?
Download this repository and build the project with `mvn package`. Then run the program with `java -jar pgnparsing-0.0.1-SNAPSHOT-jar-with-dependencies.jar`.