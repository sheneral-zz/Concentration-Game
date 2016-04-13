import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class MemoryGameGUI extends JFrame implements ActionListener{
     
   private final int WINDOW_WIDTH = 500;  // Window width
   private final int WINDOW_HEIGHT = 500; // Window height
   private TextArea messageArea, attempts, attemptsLeft, matches;
   private int rows=0;
   private int cols = 0; 
   private JButton [] doors  = new JButton[16];
   private GameModel dealGame; 
   private String filler = "   "; 
   private JLabel result; 

   public MemoryGameGUI(){
      setTitle("4x4 Memory Game");
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // set layout and borders 
      setLayout(new BorderLayout());
      add(new JLabel(filler),BorderLayout.WEST);
      add(new JLabel(filler),BorderLayout.NORTH);
      add(new JLabel(filler),BorderLayout.SOUTH);
      Panel doorsPanel = new Panel ();
      doorsPanel.setLayout(new GridLayout(4,4));
      for(int i=0;i<16;i++){
         String doorNum = i+1+""; 
         doors[i] = new JButton(i+1+"");  
         doors[i].addActionListener(this);
         doorsPanel.add(doors[i]);  
      } 
      add(doorsPanel,BorderLayout.CENTER);
      
      dealGame = new MemoryGameModel(); 
      rows = dealGame.getRows(); 
      cols = dealGame.getCols();
      
      Panel rightPanel = new Panel ();
      rightPanel.setLayout(new GridLayout(6,1));
      
      rightPanel.add(new JLabel("Attempts"));
      attempts = new TextArea("",1,5,TextArea.SCROLLBARS_NONE);
      rightPanel.add(attempts);
      //added code below S.G.
      attempts.setEditable(false);
      
      rightPanel.add(new JLabel("Attempts Left"));
      attemptsLeft = new TextArea("",1,5,TextArea.SCROLLBARS_NONE);
      rightPanel.add(attemptsLeft);
      //added code below S.G.
      attemptsLeft.setEditable(false);
      
      rightPanel.add(new JLabel("Matches Made"));
      matches = new TextArea("",1,5,TextArea.SCROLLBARS_NONE); 
      rightPanel.add(matches);
      //added code below S.G.
      matches.setEditable(false);
     
      
      add(rightPanel,BorderLayout.EAST);
      result = new JLabel(filler);  
      
      Panel bottomPanel = new Panel ();
      bottomPanel.setLayout(new GridLayout(1,1));
      messageArea = new TextArea("", 10,15,TextArea.SCROLLBARS_NONE);
      add(bottomPanel,BorderLayout.SOUTH);
      messageArea.setEditable(false);
      setVisible(true);
      } 
      
      public int updateAttempts(int numAttempts){
         numAttempts++;
         String s = numAttempts+"";
         attempts.setText(s);
         return numAttempts;
      }


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
   }


   public int updateAttemptsLeft(int numAttemptsLeft){
      numAttemptsLeft--;
      String s = numAttemptsLeft+"";
      attemptsLeft.setText(s);
      return numAttemptsLeft;
   }

      
      //temporary action performed below S.G.     
      public void actionPerformed(ActionEvent click){
   
         JButton buttonClicked = (JButton)click.getSource(); 
         int i=0;
         while(buttonClicked != doors[i]){
            i++; 
         }
         dealGame.takeTurn(i); 
         
         doors[i].setIcon(dealGame.get(i));

         doors[i].removeActionListener(this);
      }
}