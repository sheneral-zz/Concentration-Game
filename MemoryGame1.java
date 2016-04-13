
//int numMatches
//int numAttempts
// show images
   public void actionPerformed(ActionEvent ae){
      JButton source = (JButton)ae.getSource(); 
      int i=0;
      while( source != buttons[i]){
         i++; 
      images[i].setIcon(prizes.getImage(i));
      numMatches++;
      numAttempts++;
      }
      if(array[a]!==array[b]){
      images[i].removeActionListener(this); 
      numAttempts++;
      }
   } 
//check match
	public boolean checkMatch(int a, int b)
	{
		if(array[a]==array[b])
	return
			
	}

