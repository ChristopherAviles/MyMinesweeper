import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
//	private Random generator = new Random();
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3:		//Right mouse button
			Component d = e.getComponent();
			while (!(d instanceof JFrame)) {
				d = d.getParent();
				if (d == null) {
					return;
				}
			}
			JFrame mySecondFrame = (JFrame) d;
			MyPanel mySecondPanel = (MyPanel) mySecondFrame.getContentPane().getComponent(0);
			Insets mySecondInsets = mySecondFrame.getInsets();
			int xS1 = mySecondInsets.left;
			int yS1 = mySecondInsets.top;
			e.translatePoint(-xS1, -yS1);
			int xS = e.getX();
			int yS = e.getY();
			mySecondPanel.x = xS;
			mySecondPanel.y = yS;
			mySecondPanel.mouseDownGridX = mySecondPanel.getGridX(xS, yS);
			mySecondPanel.mouseDownGridY = mySecondPanel.getGridY(xS, yS);
			mySecondPanel.repaint();
			
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
//			int gridX = myPanel.getGridX(x, y);
//			int gridY = myPanel.getGridY(x, y);
//			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
//				//Had pressed outside
//				//Do nothing
//
//			} else {
//				if ((gridX == -1) || (gridY == -1)) {
//					//Is releasing outside
//					//Do nothing
//
//				} else {
//					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
//						//Released the mouse button on a different cell where it was pressed
//						//Do nothing
//
//					} else {
//						if ((myPanel.mouseDownGridY == 0) && (myPanel.mouseDownGridX == 0)) {
//							//Clicking on the top left gray square, paint all of the squares in a diagonal line from the gray square, but do not paint the gray square
//							int diagonalX = 0;
//							for (int diagonalY = 1; diagonalY < 10; diagonalY++) {
//								diagonalX++;
//								Color currentColor = myPanel.colorArray[diagonalY][diagonalX];
//								Color newColor = null;
//
//								switch (generator.nextInt(5)) {
//
//								case 0:
//									if (!currentColor.equals(Color.YELLOW)) {
//										newColor = Color.YELLOW;
//										break;
//									}
//
//								case 1:
//									if (!currentColor.equals(Color.MAGENTA)) {
//										newColor = Color.MAGENTA;
//										break;
//									}
//
//								case 2:
//									if (!currentColor.equals(Color.BLACK)) {
//										newColor = Color.BLACK;
//										break;
//									}
//
//								case 3:
//									Color brown = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
//									if (!currentColor.equals(brown)) {
//										newColor = brown;
//										break;
//									}
//
//								case 4:
//									Color lavender = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
//									if (!currentColor.equals(lavender)) {
//										newColor = lavender;
//										break;
//									}
//									else {										//Paints the square a random color that is not the current one, so that the switch does not give error if it ends.
//										int randomColor = generator.nextInt(4);
//										if (randomColor == 0){
//											newColor = Color.YELLOW;
//											break;
//										}
//										else if (randomColor == 1) {
//											newColor = Color.MAGENTA;
//											break;
//										}
//										else if (randomColor == 2) {
//											newColor = Color.BLACK;
//											break;
//										}
//										else {
//											newColor = new Color(0x964B00);
//											break;
//										}
//									}
//								}
//								myPanel.colorArray[diagonalY][diagonalX] = newColor;
//								myPanel.repaint();
//							}

//						} else {
//							if ((myPanel.mouseDownGridY == 10) && (myPanel.mouseDownGridX == 0)) {
//								int diagonalX = 4;
//								int diagonalY = 4;
//								for (diagonalY = 4; diagonalY < 7 && diagonalX < 7; diagonalY++) {
//
//									Color currentColor = myPanel.colorArray[diagonalY][diagonalX];
//									Color newColor = null;
//
//									switch (generator.nextInt(5)) {
//
//									case 0:
//										if (!currentColor.equals(Color.YELLOW)) {
//											newColor = Color.YELLOW;
//											break;
//										}
//
//									case 1:
//										if (!currentColor.equals(Color.MAGENTA)) {
//											newColor = Color.MAGENTA;
//											break;
//										}
//
//									case 2:
//										if (!currentColor.equals(Color.BLACK)) {
//											newColor = Color.BLACK;
//											break;
//										}
//
//									case 3:
//										Color brown = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
//										if (!currentColor.equals(brown)) {
//											newColor = brown;
//											break;
//										}
//
//									case 4:
//										Color lavender = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
//										if (!currentColor.equals(lavender)) {
//											newColor = lavender;
//											break;
//										}
//										else {										//Paints the square a random color that is not the current one, so that the switch does not give error if it ends.
//											int randomColor = generator.nextInt(4);
//											if (randomColor == 0){
//												newColor = Color.YELLOW;
//												break;
//											}
//											else if (randomColor == 1) {
//												newColor = Color.MAGENTA;
//												break;
//											}
//											else if (randomColor == 2) {
//												newColor = Color.BLACK;
//												break;
//											}
//											else {
//												newColor = new Color(0x964B00);
//												break;
//											}
//										}
//									}
//									myPanel.colorArray[diagonalY][diagonalX] = newColor;
//									myPanel.repaint();
//
//									if (diagonalY == 6) {			//Goes down one row after 3 horizontal squares are painted in the middle.
//										diagonalY = 3;
//										diagonalX++;
//									}	
//								}

//							} else {
//								//Released the mouse button on the same cell where it was pressed
//
//								if (myPanel.mouseDownGridX == 0 || myPanel.mouseDownGridY == 0) {
//									//On the left gray column paint the complete row of the pressed square, but not the gray column
//									for (int row = 1; row < 10; row++) {
//
//										int rowNumber = myPanel.mouseDownGridY;
//										Color currentColor = myPanel.colorArray[row][rowNumber];
//										Color newColor = null;
//
//										switch (generator.nextInt(5)) {
//
//										case 0:
//											if (!currentColor.equals(Color.YELLOW)) {
//												newColor = Color.YELLOW;
//												break;
//											}
//
//										case 1:
//											if (!currentColor.equals(Color.MAGENTA)) {
//												newColor = Color.MAGENTA;
//												break;
//											}
//
//										case 2:
//											if (!currentColor.equals(Color.BLACK)) {
//												newColor = Color.BLACK;
//												break;
//											}
//
//										case 3:
//											Color brown = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
//											if (!currentColor.equals(brown)) {
//												newColor = brown;
//												break;
//											}
//
//										case 4:
//											Color lavender = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
//											if (!currentColor.equals(lavender)) {
//												newColor = lavender;
//												break;
//											}
//											else {										//Paints the square a random color that is not the current one, so that the switch does not give error if it ends.
//												int randomColor = generator.nextInt(4);
//												if (randomColor == 0){
//													newColor = Color.YELLOW;
//													break;
//												}
//												else if (randomColor == 1) {
//													newColor = Color.MAGENTA;
//													break;
//												}
//												else if (randomColor == 2) {
//													newColor = Color.BLACK;
//													break;
//												}
//												else {
//													newColor = new Color(0x964B00);
//													break;
//												}
//											}
//										}
//										myPanel.colorArray[row][rowNumber] = newColor;
//										myPanel.repaint();
//									}

//								}	else (myPanel.mouseDownGridY == 0) {
									//On the top gray row paint the complete column of the pressed square, but not the gray row
//									for (int column = 1; column < 10; column++) {
//
//										int columnNumber = myPanel.mouseDownGridX;
//										Color currentColor = myPanel.colorArray[columnNumber][column];
//										Color newColor = null;
//
//										switch (generator.nextInt(5)) {
//
//										case 0:
//											if (!currentColor.equals(Color.YELLOW)) {
//												newColor = Color.YELLOW;
//												break;
//											}
//
//										case 1:
//											if (!currentColor.equals(Color.MAGENTA)) {
//												newColor = Color.MAGENTA;
//												break;
//											}
//
//										case 2:
//											if (!currentColor.equals(Color.BLACK)) {
//												newColor = Color.BLACK;
//												break;
//											}	
//
//										case 3:
//											Color brown = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
//											if (!currentColor.equals(brown)) {
//												newColor = brown;
//												break;
//											}
//
//										case 4:
//											Color lavender = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
//											if (!currentColor.equals(lavender)) {
//												newColor = lavender;
//												break;
//											}
//											else {										//Paints the square a random color that is not the current one, so that the switch does not give error if it ends.
//												int randomColor = generator.nextInt(4);
//												if (randomColor == 0){
//													newColor = Color.YELLOW;
//													break;
//												}
//												else if (randomColor == 1) {
//													newColor = Color.MAGENTA;
//													break;
//												}
//												else if (randomColor == 2) {
//													newColor = Color.BLACK;
//													break;
//												}
//												else {
//													newColor = new Color(0x964B00);
//													break;
//												}
//											}
//										}
//										myPanel.colorArray[columnNumber][column] = newColor;
//										myPanel.repaint();
//									}

								if ((myPanel.mouseDownGridX > 0) && (myPanel.mouseDownGridY > 0)) {
									//On the grid other than on the left column and on the top row:
									
									Color newColor = null;
									Color currentColor = myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY];

//									switch (1) {

//									case 0:
										if (!currentColor.equals(Color.YELLOW)) {
											newColor = Color.YELLOW;
//											break;
										}

//									case 1:
										else {
											newColor = Color.MAGENTA;
//											break;
										}

//									case 2:
//										if (!currentColor.equals(Color.BLACK)) {
//											newColor = Color.BLACK;
//											break;
//										}
//
//									case 3:
//										Color brown = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
//										if (!currentColor.equals(brown)) {
//											newColor = brown;
//											break;
//										}
//
//									case 4:
//										Color lavender = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
//										if (!currentColor.equals(lavender)) {
//											newColor = lavender;
//											break;
//										}
//										else {										//Paints the square a random color that is not the current one, so that the switch does not give error if it ends.
//											int randomColor = generator.nextInt(4);
//											if (randomColor == 0){
//												newColor = Color.YELLOW;
//												break;
//											}
//											else if (randomColor == 1) {
//												newColor = Color.MAGENTA;
//												break;
//											}
//											else if (randomColor == 2) {
//												newColor = Color.BLACK;
//												break;
//											}
//											else {
//												newColor = new Color(0x964B00);
//												break;
//											}
//										}
//									}
									myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
									myPanel.repaint();
								}
//							}
//						}
//					}
//				}
//			}

			myPanel.repaint();
			break;
		case 3:		//Right mouse button
			Component d = e.getComponent();
			while (!(d instanceof JFrame)) {
				d = d.getParent();
				if (d == null) {
					return;
				}
			}
			JFrame mySecondFrame = (JFrame)d;
			MyPanel mySecondPanel = (MyPanel) mySecondFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets mySecondInsets = mySecondFrame.getInsets();
			int xS1 = mySecondInsets.left;
			int yS1 = mySecondInsets.top;
			e.translatePoint(-xS1, -yS1);
			int xS = e.getX();
			int yS = e.getY();
			mySecondPanel.x = xS;
			mySecondPanel.y = yS;
			if ((mySecondPanel.mouseDownGridX > 0) && (mySecondPanel.mouseDownGridY > 0)) {
				//Pressing right mouse button on the grid, excluding the top row and left column

				Color newColor = null;
				Color currentColor = mySecondPanel.colorArray[mySecondPanel.mouseDownGridX][mySecondPanel.mouseDownGridY];

				//If square is white, paint it red
				if (!currentColor.equals(Color.RED)) {
					newColor = Color.RED;
				//If square is red, paint it white
				} else {
					newColor = Color.WHITE;
				}	
				mySecondPanel.colorArray[mySecondPanel.mouseDownGridX][mySecondPanel.mouseDownGridY] = newColor;
				mySecondPanel.repaint();
			}		
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
}

