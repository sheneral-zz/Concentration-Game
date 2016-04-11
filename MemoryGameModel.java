import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MemoryGameModel extends GameModel{
   ///private ImageIcon[] images = new ImageIcon[15];
   private ArrayList images = new ArrayList(int 15);
   final int SIZE = 4;
   int numOpenDoors = 0;
   int numAttempts = 0;
   //int numMatches = 0;
   int turnCount = 0;
   boolean checkMatch = false;
   boolean winner = false;
   boolean turnOver = false;
   boolean gameOver = false;
   
   MemoryGameModel(){
   /* // save 16 images (8 unique images)
      images[0] = new ImageIcon("balloons.png");
      images[1] = new ImageIcon("birthday-girl.png");
      images[2] = new ImageIcon("candles.png");
      images[3] = new ImageIcon("candy.png");
      images[4] = new ImageIcon("hamburger.png");
      images[5] = new ImageIcon("musical-note.png");
      images[6] = new ImageIcon("piano.png");
      images[7] = new ImageIcon("present-1.png");
      images[8] = new ImageIcon("balloons.png");
      images[9] = new ImageIcon("birthday-girl.png");
      images[10]= new ImageIcon("candles.png");
      images[11] = new ImageIcon("candy.png");
      images[12] = new ImageIcon("hamburger.png");
      images[13] = new ImageIcon("musical-note.png.");
      images[14] = new ImageIcon("piano.png");
      images[15] = new ImageIcon("present-1.png");
      */
      images.add("balloons.png");
      images.add("birthday-girl.png");
      images.add("candles.png");
      images.add("candy.png");
      images.add("hamburger.png");
      images.add("musical-note.png");
      images.add("piano.png");
      images.add("present-1.png");
      images.add("balloons.png");
      images.add("birthday-girl.png");
      images.add("candles.png");
      images.add("candy.png");
      images.add("hamburger.png");
      images.add("musical-note.png");
      images.add("piano.png");
      images.add("present-1.png");

   //Collections.shuffle(images);

   void takeTurn(int buttonChoice){
      //button choice lets this function know that a button (index of it) has been pressed
      //passed in from ActionPerformed
      numOpenDoors++;
      //if matching images, match+1; need to getPath
      
      
   }//take turn        
      
   boolean turnOverStatus(){
      if (numOpenDoors == 2)
         return(true);
      else
         return(false); 
   }//1 turn over
   
   boolean gameOverStatus(){
      if (numAttempts == 10 || numMatches == 8)
         return(true);
      else
         return(false); 
   }//game over
   
   public ImageIcon get(int i){
      return(images[i]);
   }//get image
   

   int getRows(){
      return(4);}
      
   int getCols(){
      return(SIZE);}

    
   void display(){
   
   }
         
   String reportWinner(int matches){
      if (numMatches==8)
         return("You win! ");
      else
         return("Sorry! You lost!");
   }
   
   int addAttempts(int turnCount){
         numAttempts++;
   }//number of attempts
   
   boolean checkMatch(int c1, int c2){
      //if the paths of choice1 and choice2 are the same, they match, numMatches+1
      //if paths don't match, they don't match
      String imageName1 = images[c1].getDescription();
      String imageName2 = images[c2].getDescription();
      if imageName1 == imageName2{
         return(true);}
      else{
         return(false);}
   }//number of matches
   
   //function: get number of attempts to keep track
   //function: keep track of number of matches
   //talk to GUI for above
   
   }//model

}//class