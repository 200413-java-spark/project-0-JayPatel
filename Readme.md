# Readme File


## This is a Hangman game. 

To compile and run the game, enter this in terminal:

```
$ mvn clean compile exec:java
```




## Design
### Architecture
- Hangman starts the game, calls Word to handle the logic of the gameflow
- Word creates the word, by getting it from FileParser
- FileParser reads listofwords.txt and randomly chooses any one of the words in the file
- MyDatabase handles all the writing and reading to a SQL server


