import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import javax.imageio.ImageIO;

public class MemoryGameModel extends GameModel{

   public List<ImageIcon> images = new ArrayList<ImageIcon>();
   final int SIZE = 4;
   int numOpenDoors = 0;
   int numAttempts = 0;
   int numMatches = 0;
   int turnCount = 0;
   boolean checkMatch = false;
   boolean winner = false;
   boolean turnOver = false;
   boolean gameOver = false;
   
   MemoryGameModel(){
    
      images.add(new ImageIcon("balloons.png"));
      images.add(new ImageIcon("birthday-girl.png"));
      images.add(new ImageIcon("candles.png"));
      images.add(new ImageIcon("candy.png"));
      images.add(new ImageIcon("hamburger.png"));
      images.add(new ImageIcon("musical-note.png"));
      images.add(new ImageIcon("piano.png"));
      images.add(new ImageIcon("present-1.png"));
      images.add(new ImageIcon("balloons.png"));
      images.add(new ImageIcon("birthday-girl.png"));
      images.add(new ImageIcon("candles.png"));
      images.add(new ImageIcon("candy.png"));
      images.add(new ImageIcon("hamburger.png"));
      images.add(new ImageIcon("musical-note.png"));
      images.add(new ImageIcon("piano.png"));
      images.add(new ImageIcon("present-1.png"));
   
   Collections.shuffle(images);
   }
   
   public void takeTurn(int buttonChoice){
      //button choice lets this function know that a button (index of it) has been pressed
      //passed in from ActionPerformed
      numOpenDoors++;
      //if matching images, match+1; need to getPatt 
      
   }//take turn        
      
   boolean turnOverStatus(){
      if (numOpenDoors == 2)
         return(true);
      else
         return(false); 
   }//1 turn over
   
   boolean gameOverStatus(){
      if (numAttempts == 10 || numMatches == 8){
         return(true);}
      else{
         return(false); }
   }//game over
   
   public ImageIcon get(int i){
      return(images.get(i));
   }//get image
   

   int getRows(){
      return(4);
   }
      
   int getCols(){
      return(SIZE);
   }

    
   void display(){
   
   }
         
   String reportWinner(){
      if (numMatches==8){
         return("You win! ");
      }
      else{
         return("Sorry! You lost!");
      }
   }
   
   int addAttempts(int turnCount){
      //if turn%2 isn't 0, attempt isn't over
      return(numAttempts++);
   }//number of attempts
   
   boolean checkMatch(int c1, int c2){
      //if the paths of choice1 and choice2 are the same, they match, numMatches+1
      //if paths don't match, they don't match
      if (images.get(c2).equals(images.get(c2))){
         return(true);
      }
      else{
         return(false);
      }
   }//number of matches
   
   //function: get number of attempts to keep track
   //function: keep track of number of matches
   //talk to GUI for above

}//class