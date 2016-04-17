import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MemoryGameGUI extends JFrame implements ActionListener{
     
   private final int WINDOW_WIDTH = 600;  // Window width
   private final int WINDOW_HEIGHT = 600; // Window height
   private TextArea messageArea, attempts, attemptsLeft, matches;
   private int rows=0;
   private int cols = 0; 
   private JButton [] doors  = new JButton[16];
   private MemoryGameModel dealGame; 
   private String filler = " "; 
   private JLabel result; 
   private ImageIcon icon = new ImageIcon ("front.png");
   private ImageIcon[] imagePair = new ImageIcon[2];
   private int turnCount=0;
   private boolean checkMatch;
   private int numMatches;

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

      
      bottomPanel.add(new JLabel(filler));
      
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
      
      bottomPanel.add(new JLabel("Matches Made"));
      matches = new TextArea("0",1,2,TextArea.SCROLLBARS_NONE); 
      bottomPanel.add(matches);
      matches.setEditable(false);
      
      bottomPanel.add(new JLabel(filler));
      
      add(bottomPanel,BorderLayout.SOUTH);

      
      result = new JLabel(filler); 
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
         
   public int updateAttempts(int numAttempts){
     //incrementing attempts is ActionPerformed's job, not this function's job SG
      String s = numAttempts+"";
      attempts.setText(s);
      return numAttempts;
   }
   
      
   public void updateMatchesCount(boolean checkMatch){
      if(checkMatch){
         numMatches++;
      }
      String s = numMatches+"";
      matches.setText(s);
      
   }//update match count
   
   public void messageMatches(boolean checkMatch){
      if(checkMatch){
         result.setText("Match found!");
      }
      else{
         result.setText("Not a match!");
      }
   }//msg matches
   
   //I rewrote updateFoundMatches into two different functions: one updating message, one updating match count (shown above)
   /*
   public int updateFoundMatches(int numMatches, boolean checkMatch){
      if (checkMatch == true){
         result.setText("match found");
         numMatches++;
         String s = numMatches+"";
         matches.setText(s);
      }
      else{
         result.setText("not a match");
      }
      return numMatches;
   } */


   public int updateAttemptsLeft(int attempts){
      int numAttemptsLeft = 16-attempts;
      //changed code above bc originally it was just subtracting 1 attempt, which is not how it works SG
      String s = numAttemptsLeft+"";
      attemptsLeft.setText(s);
      return numAttemptsLeft;
   }

   public void actionPerformed(ActionEvent click){
      JButton buttonClicked = (JButton)click.getSource();
      int attempts=dealGame.addAttempts(turnCount);
      updateAttempts(attempts);
      updateAttemptsLeft(attempts);
      turnCount++;
      int i=0;
      while(buttonClicked != doors[i]){
         i++; 
      }//while finding source
      doors[i].setIcon(dealGame.get(i));            
      dealGame.takeTurn(turnCount);
      
      updateMatchesCount(checkMatch);
      messageMatches(checkMatch);

   }//action performed
}