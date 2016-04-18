import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import javax.imageio.ImageIO;

public class MemoryGameModel extends GameModel{

<<<<<<< HEAD
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
=======
   
   private final int matchTotal = 8;
   private List<ImageIcon> images = new ArrayList<ImageIcon>(matchTotal *2);
   private int numOpenDoors = 0;
   private int numAttempts = 0;
   private int matchCount = 0;
   private int attemptsRemaining = 16;
>>>>>>> origin/master
   
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
        
<<<<<<< HEAD
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
=======
        Collections.shuffle(images);
   }
        
>>>>>>> origin/master
   
   public int getMatchCount(){
      return matchCount;
   } 
   
   public boolean isGameOver(){
      return numAttempts == 10 || matchCount == 8;
   }
   
   public ImageIcon getImageIcon(int i){
      return images.get(i);
   }
   
   public void incrementMatch(){
       matchCount++;
   }

   
}
