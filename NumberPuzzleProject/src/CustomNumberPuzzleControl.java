import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here
		//System.out.println(emptyCellId);
		//System.out.println(buttonClicked);
		int clicked_btn_id = -1;
		for(int i=0;i<buttons.length;i++) {
			if(buttons[i] == buttonClicked) {
				clicked_btn_id = i;
			}
		}
		//System.out.println(clicked_btn_id);
		if((clicked_btn_id<=15)&&(clicked_btn_id == emptyCellId-1 || clicked_btn_id == emptyCellId+1 || clicked_btn_id == emptyCellId-4 || clicked_btn_id == emptyCellId+4)){
			swapButton(buttons[emptyCellId], buttonClicked);
			emptyCellId = clicked_btn_id;
		}
		
		//if(buttons[])
		/*for(int i=0;i<buttons.length;i++) {
			if(buttons[i] == buttonClicked) {
				System.out.println(buttons[i]);
				System.out.println(buttonClicked);
				emptyCellId = i;
				break;
			}
		} */
		
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		int index = 0;
		while(index<15) {
			int a = getRandomNumber();
			a=a%16;
			if(a==0)
				continue;
			int i=0, flag=1;
			while(i<index) {
				if(arr[i] == a) {
					flag=0;
					break;
				}
				i++;
			}
			if(flag==1) {
				arr[index] = a; 
				index++;
			}
		}
		
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int arr [] = getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<15;i++) {
			//System.out.println(arr[i]);
			if(arr[i]!=(i+1)) {
				
				//System.out.println("index = " + i);
				return false;
			}
		}

		return winner;
	}
}