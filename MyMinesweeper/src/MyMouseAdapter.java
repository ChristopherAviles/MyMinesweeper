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


								if ((myPanel.mouseDownGridX > 0) && (myPanel.mouseDownGridY > 0)) {
									//On the grid other than on the left column and on the top row:
									Color newColor = null;
									Color currentColor = myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY];
									

									for (int i = 0; i < 12; i++) {
										if (myPanel.mouseDownGridX == myPanel.minesXCoordinates[i] && myPanel.mouseDownGridY == myPanel.minesYCoordinates[i]) {
											for (int j = 0; j < 12; j++) {
											newColor = Color.BLACK;
											myPanel.colorArray[myPanel.minesXCoordinates[j]][myPanel.minesYCoordinates[j]] = newColor;
											myPanel.repaint();
											}
											
											break;
										
										}	else {
											newColor = Color.LIGHT_GRAY;
											myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
											myPanel.repaint();
											
											for (int k = 0; k < (9 - myPanel.mouseDownGridX); k++) {
												if (myPanel.GetNumberMinesAdjacentToSquare(myPanel.mouseDownGridX + k, myPanel.mouseDownGridY) == 0 && !currentColor.equals(Color.LIGHT_GRAY)) {
													for (int s = 0; s < 9; s++) {
														for (int midRow = -1; midRow < 2; midRow++) {
															newColor = Color.LIGHT_GRAY;
															myPanel.colorArray[myPanel.mouseDownGridX + k + midRow][myPanel.mouseDownGridY] = newColor;
															myPanel.repaint();
														}
														for (int topRow = -1; topRow < 2; topRow++) {
															newColor = Color.LIGHT_GRAY;
															myPanel.colorArray[myPanel.mouseDownGridX + k + topRow][myPanel.mouseDownGridY - 1] = newColor;
															myPanel.repaint();
														}
														for (int bottomRow = -1; bottomRow < 2; bottomRow++) {
															newColor = Color.LIGHT_GRAY;
															myPanel.colorArray[myPanel.mouseDownGridX + k + bottomRow][myPanel.mouseDownGridY + 1] = newColor;
															myPanel.repaint();
														}
														
													}	
																								
												}
												else {
													break;
												}
											}
											
											for (int k = 0; k < (myPanel.mouseDownGridX - 1); k++) {
												if (myPanel.GetNumberMinesAdjacentToSquare(myPanel.mouseDownGridX - k, myPanel.mouseDownGridY) == 0 && !currentColor.equals(Color.LIGHT_GRAY)) {
													for (int s = 0; s < 9; s++) {
														for (int midRow = -1; midRow < 2; midRow++) {
															newColor = Color.LIGHT_GRAY;
															myPanel.colorArray[myPanel.mouseDownGridX - k + midRow][myPanel.mouseDownGridY] = newColor;
															myPanel.repaint();
														}
														for (int topRow = -1; topRow < 2; topRow++) {
															newColor = Color.LIGHT_GRAY;
															myPanel.colorArray[myPanel.mouseDownGridX - k + topRow][myPanel.mouseDownGridY - 1] = newColor;
															myPanel.repaint();
														}
														for (int bottomRow = -1; bottomRow < 2; bottomRow++) {
															newColor = Color.LIGHT_GRAY;
															myPanel.colorArray[myPanel.mouseDownGridX - k + bottomRow][myPanel.mouseDownGridY + 1] = newColor;
															myPanel.repaint();
														}
														
													}	
																								
												}
												else {
													break;
												}
											}						
											

										}
									}

									
								}

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
				if (!currentColor.equals(Color.RED) && !currentColor.equals(Color.LIGHT_GRAY)) {
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

