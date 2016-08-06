# GuessWords
Look through sowpods.txt  
run through each word.  
eliminate all words that don't have 'n' characters in common.  
if (n == 0) eliminate all words that have any of the characters.  
goto 2.  
  
computer thinks of "SYRIA"  
you think of "SAURON"  
n = 3.  
  
functions we need:  
1. Find out if a word is legal.  
2. Find out how many characters word A has in common with word B.  
3. Find out how mnay characters word A has.  
4. Find out if all characters in words A are unique.  
Data: Keep 2 lists - the dictionary and the list of possible words that could match.  
5. Filter all the words that don't contain exactly 'n' characters in common with a word.  
  
We have four classes: Word, WordUtils, Game, Player.  
Word has a word and does 1, 2, 3, 4.  
WordUtils helps word do 1.  
Game does 5.  
Player deals with Data in the following way:  
each Player class contains the  
-wordToFind  
-guessedWord  
