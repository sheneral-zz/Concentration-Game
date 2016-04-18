import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MemoryGameGUI extends JFrame implements ActionListener{
     
   private JTextArea messageTextArea;
   private JTextField attemptCountTextField, attemptsRemainingTextField, matchCountTextField;
   private JButton[] doors;
   private static final MemoryGameModel MODEL = new MemoryGameModel();
   private final static ImageIcon UNREVEALED_ICON= new ImageIcon ("front.png");
   
   private enum Selection {
    FIRST, SECOND
   };
   
   JButton firstMismatch = null, secondMismatch = null;
   
   private Selection currentSelection = Selection.FIRST;

   public MemoryGameGUI(){
      setTitle("Memory Game");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // set layout and borders 
      setLayout(new BorderLayout());

      Panel doorsPanel = new Panel ();
      doorsPanel.setLayout(new GridLayout(4,4));
      for(int i=0;i<MODEL.getSize();i++){
         doors[i] = new JButton (icon);
         doorsPanel.add(doors[i]); 
         doors[i].addActionListener(this); 
      } 
      add(doorsPanel,BorderLayout.CENTER);
      
      
      JPanel statisticsPanel = new JPanel ();
      statisticsPanel.setLayout(new BoxLayout());
      
      
      statisticsPanel.add(new JLabel("Attempts"));
      attempts = new TextArea("0");
      statistcsPanel.add(attempts);
      attempts.setEditable(false);
      
      statisticsPanel.add(new JLabel(filler));
      
      statisticsPanel.add(new JLabel("Attempts Left"));
      attemptsLeft = new TextArea(MODEL.getAttemptsRemaining());
      statisticsPanel.add(attemptsLeft);
      attemptsLeft.setEditable(false);
      
      statisticsPanel.add(new JLabel(filler));
      
      statisticsPanel.add(new JLabel("Matches Made"));
      matches = new TextArea("0"); 
      bottomPanel.add(matches);
      matches.setEditable(false);
      
      bottomPanel.add(new JLabel(filler));
      
      add(bottomPanel,BorderLayout.SOUTH);

      
      messageArea = new TextArea("Welcome!");
      messageArea.setEditable(false);
      topPanel.add(messageArea);
      add(topPanel,BorderLayout.NORTH);
      
      pack();
      setVisible(true);
   } 
 

   public void actionPerformed(ActionEvent click){
    
      JButton buttonClicked = (JButton)click.getSource();
      if(MODEL.getAttemptsRemaining == 0)
        return;
        
      switch(selection){
        case FIRST:
            if (firstMatch != null){
                firstMatch.setIcon(UNREVEALED_ICON);
                secondMatch.setIcon(UNREVEALED_ICON);
                firstMatch = buttonClicked;
                secondMatch = null;
            }
            
            buttonClicked.setIcon(MODEL.getImageIcon(getIndex(buttonClicked)));
            selection = Selection.SECOND;
            break; 
        case SECOND:
            buttonClicked.setIcon(MODEL.getImageIcon(getIndex(buttonClicked)));
            MODEL.incrementAttemptCount();
            attemptCountTextField.setText(MODEL.getAttemptCount());
            attemptsRemainingTextField.setText(MODEL.getAttemptsMax() - MODEL.getAttemptsCount());
            selection = FIRST;
            if (buttonClicked.getIcon().equal(firstMatch.getIcon())){
                firstMatch = null;
                MODEL.incrementMatch();
                matchCountTextField.setText(MODEL.getMatchCount());
            }
            if (MODEL.getAttemptsRemaining == 0 || MODEL.getMatchCount() == MODEL.getMatchMax()){
                messageTextArea.setText("Game over!");
                if (MODEL.getMatchCount() == MODEL.getMatchMax()){
                    JOptionPane.showMessageDialog(frame, "You win!");
                } else {
                    JOptionPane.showMessageDialog(frame, "You lose!");
                }
            }
       
            break;
      }
      

   }
}