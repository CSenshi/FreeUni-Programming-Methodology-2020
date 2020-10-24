package s05;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import stanford.karel.*;

/*
 * გრაფიკული პროგრამის გამოყენებით დახატეთ სახლი
 */
public class Ex12 extends GraphicsProgram {

	/* House Parameters */
	private final int HOUSE_WIDTH = 600;
	private final int HOUSE_HEIGHT = 400;

	/* Roof Parameters */
	private final int ROOF_HEIGHT = 140;

	/* Door Parameters */
	private final int DOOR_WIDTH = 60;
	private final int DOOR_HEIGHT = 150;

	/* Window Parameters */
	private final int WINDOW_WIDTH = 100;
	private final int WINDOW_HEIGHT = 100;
	private final int WINDOW_OFFSET_X_FROM_CENTER = 150;

	/* Welcome Banner Parameters */
	private final int WELCOME_OFFSET_FROM_DOOR = 20;
	private final String WELCOME_TEXT = " Welcome! ";

	/* Canvas Parameters */
	private int HEIGHT = 800;
	private int WIDTH = 1200;

	@Override
	public void run() {
		// Set Canvas Size
		this.setSize(WIDTH, HEIGHT);

		drawHouse();
	}

	private void drawHouse() {
		drawMainBuilding();
		drawRoof();
		drawDoor();
		drawWelcomeBanner();
		drawWindows();
	}

	/*
	 * Draw main building in the center
	 * 
	 * Using: GRect
	 */
	private void drawMainBuilding() {
		int houseX = (WIDTH - HOUSE_WIDTH) / 2;
		int houseY = (HEIGHT - HOUSE_HEIGHT) / 2;

		GRect houseRect = new GRect(houseX, houseY, HOUSE_WIDTH, HOUSE_HEIGHT);
		add(houseRect);
	}

	/*
	 * Draw roof on the top of the building
	 * 
	 * Using: 2 GLines with same (roofX, roofY) Coordinates
	 */
	private void drawRoof() {
		int lineY = (HEIGHT - HOUSE_HEIGHT) / 2;
		int line1X = (WIDTH - HOUSE_WIDTH) / 2;
		int line2X = (WIDTH + HOUSE_WIDTH) / 2;

		int roofX = WIDTH / 2;
		int roofY = lineY - ROOF_HEIGHT;

		GLine line1 = new GLine(line1X, lineY, roofX, roofY);
		add(line1);
		GLine line2 = new GLine(line2X, lineY, roofX, roofY);
		add(line2);
	}

	private void drawDoor() {
		int doorX = (WIDTH - DOOR_WIDTH) / 2;
		int doorY = (HEIGHT + HOUSE_HEIGHT) / 2 - DOOR_HEIGHT;

		GRect doorRect = new GRect(doorX, doorY, DOOR_WIDTH, DOOR_HEIGHT);
		add(doorRect);
	}

	private void drawWindows() {
		int windowY = (HEIGHT - HOUSE_HEIGHT) / 2 + WINDOW_HEIGHT;
		int window1X = (WIDTH - WINDOW_WIDTH) / 2 - WINDOW_OFFSET_X_FROM_CENTER;
		int window2X = (WIDTH - WINDOW_WIDTH) / 2 + WINDOW_OFFSET_X_FROM_CENTER;

		int verticalLineX = window1X + WINDOW_WIDTH / 2;
		int horizontalLineY = windowY + WINDOW_WIDTH / 2;
		GRect win1Rect = new GRect(window1X, windowY, WINDOW_WIDTH, WINDOW_HEIGHT);
		GLine l11 = new GLine(verticalLineX, windowY, verticalLineX, windowY + WINDOW_HEIGHT);
		GLine l12 = new GLine(window1X, horizontalLineY, window1X + WINDOW_WIDTH, horizontalLineY);
		add(win1Rect);
		add(l11);
		add(l12);

		verticalLineX = window2X + WINDOW_WIDTH / 2;
		GRect win2Rect = new GRect(window2X, windowY, WINDOW_WIDTH, WINDOW_HEIGHT);
		GLine l21 = new GLine(verticalLineX, windowY, verticalLineX, windowY + WINDOW_HEIGHT);
		GLine l22 = new GLine(window2X, horizontalLineY, window2X + WINDOW_WIDTH, horizontalLineY);
		add(win2Rect);
		add(l21);
		add(l22);
	}

	private void drawWelcomeBanner() {
		// Label
		GLabel bannerLabel = new GLabel(WELCOME_TEXT);
		int bannerY = (HEIGHT + HOUSE_HEIGHT) / 2 - DOOR_HEIGHT - WELCOME_OFFSET_FROM_DOOR;
		int bannerX = (int) ((WIDTH - bannerLabel.getWidth()) / 2);
		add(bannerLabel, bannerX, bannerY);

		// Label Rect
		GRect bannerRect = new GRect(bannerX, bannerY - bannerLabel.getAscent(), bannerLabel.getWidth(),
				bannerLabel.getHeight());
		add(bannerRect);
	}
}
