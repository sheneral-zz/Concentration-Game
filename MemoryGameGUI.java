import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class MemoryGameGUI extends JFrame{
     
   private final int WINDOW_WIDTH = 480;  // Window width
   private final int WINDOW_HEIGHT = 510; // Window height
   private TextArea messageArea, attempts, attemptsLeft, matches;
   private int rows=0;
   private int cols = 0; 
   private JButton [] doors  = new JButton[16];
   private GameModel dealGame; 
   private String filler = "   "; 
   private JLabel result; 

   public MemoryGameGUI(){
      /*****************whole frame set up BorderLayout****************/
      // Set the window title, ize and close behavious
      setTitle("4x4 Memory Game");
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // set layout and borders 
      setLayout(new BorderLayout());
      add(new JLabel(filler),BorderLayout.WEST);
      add(new JLabel(filler),BorderLayout.NORTH);
      Panel doorsPanel = new Panel ();
      doorsPanel.setLayout(new GridLayout(4,4));
      for(int i=0;i<16;i++){
         String doorNum = i+1+""; 
         doors[i] = new JButton(i+1+"");  
         //doors[i].addActionListener(this);
         doorsPanel.add(doors[i]);  
      } 
      add(doorsPanel,BorderLayout.CENTER);
      
      Panel rightPanel = new Panel ();
      rightPanel.setLayout(new GridLayout(6,1));
      rightPanel.add(new JLabel("Attempts"));
      attempts = new TextArea("",1,8,TextArea.SCROLLBARS_NONE);
      rightPanel.add(new JLabel("Attempts Left"));
      attemptsLeft = new TextArea("",1,8,TextArea.SCROLLBARS_NONE);
      rightPanel.add(new JLabel("Matches Made"));
      matches = new TextArea("",1,8,TextArea.SCROLLBARS_NONE); 
      
      rightPanel.add(attempts);
      rightPanel.add(attemptsLeft);
      rightPanel.add(matches);
      


      
      add(rightPanel,BorderLayout.EAST);
      result = new JLabel(filler);  
      
      Panel bottomPanel = new Panel ();
      bottomPanel.setLayout(new GridLayout(1,1));
      messageArea = new TextArea("", 1,15,TextArea.SCROLLBARS_NONE);
      add(bottomPanel,BorderLayout.SOUTH);
      messageArea.setEditable(false);
      setVisible(true);
      } 
}