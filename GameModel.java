import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  


abstract class GameModel{

   abstract void takeTurn(int t);        
      
   abstract boolean gameOverStatus();
   abstract ImageIcon get(int i); 
   abstract int getRows();
   abstract int getCols(); 
   abstract void display();      
   abstract String reportWinner();   
   
}// class