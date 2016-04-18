import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import javax.imageio.ImageIO;

public class MemoryGameModel extends GameModel{

   
   private final int matchTotal = 8;
   private List<ImageIcon> images = new ArrayList<ImageIcon>(matchTotal *2);
   private int numOpenDoors = 0;
   private int numAttempts = 0;
   private int matchCount = 0;
   private int attemptsRemaining = 16;
   
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
        
        Collections.shuffle(images);
   }
        
   
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
