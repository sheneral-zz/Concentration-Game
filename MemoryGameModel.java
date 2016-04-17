import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import javax.imageio.ImageIO;

public class MemoryGameModel extends GameModel{

   public List<ImageIcon> images = new ArrayList<ImageIcon>(16);
   final int SIZE = 4;
   int numOpenDoors = 0;
   public int numAttempts = 0;
   public int numMatches = 0;
   public int turnCount = 0;
   public boolean checkMatch = false;
   boolean winner = false;
   boolean turnOver = false;
   boolean gameOver = false;
   private int choice1;
   private int choice2;
   
   MemoryGameModel(){
    
      images.add(new ImageIcon("balloons.png"));
      images.add(new ImageIcon("birthday-girl.png"));
      images.add(new ImageIcon("candle.png"));
      images.add(new ImageIcon("candy.png"));
      images.add(new ImageIcon("hamburger.png"));
      images.add(new ImageIcon("musical-note.png"));
      images.add(new ImageIcon("piano.png"));
      images.add(new ImageIcon("present-1.png"));
      images.add(new ImageIcon("balloons.png"));
      images.add(new ImageIcon("birthday-girl.png"));
      images.add(new ImageIcon("candle.png"));
      images.add(new ImageIcon("candy.png"));
      images.add(new ImageIcon("hamburger.png"));
      images.add(new ImageIcon("musical-note.png"));
      images.add(new ImageIcon("piano.png"));
      images.add(new ImageIcon("present-1.png"));
   
   //Collections.shuffle(images);
   }//constructor
   
   public void takeTurn(int turn){
      
      if(turn%2!=0){
         choice1=turn;
      }
      else{
         choice2=turn;
         checkMatch(choice1, choice2);
         if(checkMatch(choice1, choice2)){
            numMatches++;
         }
      }

      
   }//take turn        
      
   boolean turnOverStatus(){
      if (numOpenDoors == 2) //need new condition that accounts for opened doors that match
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
      if (turnCount%2==0){
         return(numAttempts++);
      }
      else{
         return(numAttempts);
      }
   }//number of attempts
   
   boolean checkMatch(int c1, int c2){
      if (images.get(c1).equals(images.get(c2))){
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