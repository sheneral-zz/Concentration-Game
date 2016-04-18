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
   boolean matchStatus = true;
   private int choice1;
   private int choice2;
   
   MemoryGameModel(){
   
      ImageIcon candle = new ImageIcon("candle.png");
      ImageIcon balloons = new ImageIcon("balloons.png");
      ImageIcon birthdayGirl = new ImageIcon("birthday-girl.png");
      ImageIcon candy = new ImageIcon("candy.png");
      ImageIcon hamburger = new ImageIcon("hamburger.png");
      ImageIcon musicalNote = new ImageIcon("musical-note.png");
      ImageIcon piano = new ImageIcon("piano.png");
      ImageIcon present1 = new ImageIcon("present-1.png");
    
      images.add(balloons);
      images.add(birthdayGirl);
      images.add(candle);
      images.add(candy);
      images.add(hamburger);
      images.add(musicalNote);
      images.add(piano);
      images.add(present1);
      images.add(balloons);
      images.add(birthdayGirl);
      images.add(candle);
      images.add(candy);
      images.add(hamburger);
      images.add(musicalNote);
      images.add(piano);
      images.add(present1); 
        
   //Collections.shuffle(images);
   }//constructor
   
   public void takeTurn(int i){
      if(!turnOver){
         choice1=i;
      }
      else{
         choice2=i;
         if(checkMatch(choice1, choice2)){
            numMatches++;
            matchStatus=true;
         }
         else{
            matchStatus=false;
         }
      }
      turnOver = !turnOver;
   }//take turn     
   
   public int getNumMatches(){
      return(numMatches);
   }//get num matches   
   
   public boolean getMatchStatus(){
      return(matchStatus);
   }//
   
   boolean gameOverStatus(){
      if (numAttempts == 16 || numMatches == 8){
         return(true);}
      else{
         return(false);}
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

}//class