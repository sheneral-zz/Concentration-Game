import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JOptionPane;

public class MemoryGameGUI extends JFrame implements ActionListener{
     
   private final int WINDOW_WIDTH = 900;  
   // Window width wide enough to not need to manually expand view to read all labels 
   private final int WINDOW_HEIGHT = 600; // Window height
   private int rows=0;
   private int cols = 0;
   private TextArea messageArea, attempts, attemptsLeft, matches, result;
   private JButton [] doors  = new JButton[16];
   private JButton reset = new JButton();
   private MemoryGameModel dealGame; 
   private String filler = " ";  
   private ImageIcon icon = new ImageIcon ("front.png");
   private int turnCount=0;
   private int numMatches;
   private int attemptsInt=0;
   private int attemptsLeftInt=16;

   public MemoryGameGUI(){
      setTitle("4x4 Memory Game");
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // set layout and borders 
      setLayout(new BorderLayout(15,15));
      add(new JLabel(filler),BorderLayout.WEST);
      add(new JLabel(filler),BorderLayout.EAST);
      add(new JLabel(filler),BorderLayout.NORTH);
      add(new JLabel(filler),BorderLayout.SOUTH);
      add(new JLabel(filler),BorderLayout.CENTER);
      
      Panel doorsPanel = new Panel ();
      doorsPanel.setLayout(new GridLayout(4,4,5,5));
      doorsPanel.setBackground(new Color(150,200,150));
      
      for(int i=0;i<16;i++){
         doors[i] = new JButton (icon);
         doorsPanel.add(doors[i]); 
         doors[i].addActionListener(this); 
      } 
      add(doorsPanel,BorderLayout.CENTER);
      
      dealGame = new MemoryGameModel(); 
      rows = dealGame.getRows(); 
      cols = dealGame.getCols();
      
      Panel bottomPanel = new Panel ();
      bottomPanel.setLayout(new GridLayout(1,10,0,0));
      bottomPanel.setBackground(new Color(150,230,150));
      
      bottomPanel.add(new JLabel("Attempts"));
      attempts = new TextArea("0",1,2,TextArea.SCROLLBARS_NONE);
      bottomPanel.add(attempts);
      attempts.setEditable(false);
      
      bottomPanel.add(new JLabel(filler));
      
      bottomPanel.add(new JLabel("Attempts Left"));
      attemptsLeft = new TextArea("16",1,2,TextArea.SCROLLBARS_NONE);
      bottomPanel.add(attemptsLeft);
      attemptsLeft.setEditable(false);
      
      bottomPanel.add(new JLabel(filler));
      
      bottomPanel.add(new JLabel("Matches"));
      matches = new TextArea("0",1,2,TextArea.SCROLLBARS_NONE); 
      bottomPanel.add(matches);
      matches.setEditable(false);
      
      result = new TextArea("Results", 1,10,TextArea.SCROLLBARS_NONE);
      bottomPanel.add(new JLabel(filler));
      bottomPanel.add(new JButton("Reset"));
      bottomPanel.add(result);
      
      add(bottomPanel,BorderLayout.SOUTH);
    
      Panel topPanel = new Panel ();
      topPanel.setLayout(new GridLayout(1,1,3,3));
      topPanel.setBackground(new Color(150,130,150));
      messageArea = new TextArea("Welcome!", 1,10,TextArea.SCROLLBARS_NONE);
      messageArea.setEditable(false);
      topPanel.add(messageArea);
      add(topPanel,BorderLayout.NORTH);
      
      
      setVisible(true);
   } 
   
   public void BoarderLayout(int hgap, int vgap){}
   
   public void GridLayout(int row, int columns, int hgap, int vgap){}
   
   public void updateAttempts(int numAttempts){
     //incrementing attempts is ActionPerformed's job, not this function's job - SG
      String s = numAttempts+"";
      attempts.setText(s);
   }//update attempts
      
   public void updateMatchesCount(int numMatches){
      //this function only converts number of matches to display it as string - SG
      String m = numMatches+"";
      matches.setText(m);
   }//update match count
   
   public void messageMatches(boolean checkMatch){
      if(checkMatch){
         result.setText("Match found!");
      }
      else{
         result.setText("Not a match!");
      }
   }//msg matches

   public void updateAttemptsLeft(int attempts){
      int numAttemptsLeft = 16-attempts;
      String s = numAttemptsLeft+"";
      attemptsLeft.setText(s);
   }
   
   public void resetGame(){
      for (int i=0;i<15;i++){
         //doors[i].addActionListener(this);
         doors[i].setIcon(icon);
      }
      attemptsInt=0;
      numMatches=0;
      updateAttempts(0);
      updateAttemptsLeft(16); 
   }
   
   /* the functions below are kind of repetitive, since they're mostly just converting to string
   which updateAttempts and updateAttemptsLeft already do
   public int resetAttempts(int numAttempts){
      numAttempts = 0;
      String s = numAttempts+"";
      attempts.setText(s);
      return numAttempts;
   }

   public int resetAttemptsLeft(int numAttemptsLeft){
      numAttemptsLeft = 0;
      String s = numAttemptsLeft+"";
      attemptsLeft.setText(s);
      return numAttemptsLeft;
   }
   
   public int resetMatches(int numMatches){
      numMatches = 0;
      String s = numMatches+"";
      matches.setText(s);
      return numMatches;
   }
   */
   
   public void actionPerformed(ActionEvent click){
      JButton buttonClicked = (JButton)click.getSource();
      attemptsInt=dealGame.addAttempts(turnCount);
      updateAttempts(attemptsInt);
      updateAttemptsLeft(attemptsInt);
      turnCount++;
      int i=0;
      while(buttonClicked != doors[i]){
         i++; 
      }
      doors[i].setIcon(dealGame.get(i));
      dealGame.takeTurn(i);
      
      if(turnCount%2==0){
         updateMatchesCount(dealGame.getNumMatches());
         messageMatches(dealGame.getMatchStatus());
      }//big if
      
      if(dealGame.gameOverStatus()){
         //small bug: gameOverStatus evaluates to true at the beginning of the 16th attempt, not after
         String gameOver = ("Game over! Thanks for playing! ");
         JOptionPane.showMessageDialog(null, gameOver);
         System.exit(0); //exits the game
      }
      
      String command = click.getActionCommand();
      if(command.equals("reset")){
         resetGame();
      }
      
      
   }//action performed
   

}