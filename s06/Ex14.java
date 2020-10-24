package s06;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import stanford.karel.*;

/*
 * დახატეთ რობოტის სახე ფანჯრის ცენტრში.
 */
public class Ex14 extends GraphicsProgram {

	/* Face Parameters */
	private int FACE_HEIGHT = 400;
	private int FACE_WIDTH = 450;

	/* Mouth Parameters */
	private int MOUTH_HEIGHT = 50;
	private int MOUTH_WIDTH = 250;
	private int MOUTH_OFFSET_FROM_BOTTOM = 30;
	private int MOUTH_TEETH_COUNT = 10;

	/* Nose Parameters */
	private int NOSE_HEIGHT = 150;
	private int NOSE_WIDTH = 125;
	private int NOSE_OFFSET_FROM_BOTTOM = 125;

	/* Ear Parameters */
	private int EAR_HEIGHT = 150;
	private int EAR_WIDTH = 50;

	/* Anteana Parameters */
	private int ANTENA_HEIGHT = 100;
	private int ANTENA_CIRCLE_R = 25;

	/* Eye Parameters */
	private int EYE_HEIGHT = 120;
	private int EYE_WIDTH = 120;
	private int EYE_OFFSET_FROM_CENTER = 70;
	private int EYE_OFFSET_FROM_TOP = 50;

	/* Canvas Parameters */
	private int HEIGHT = 800;
	private int WIDTH = 1000;

	@Override
	public void run() {
		// Set Canvas Size
		this.setSize(WIDTH, HEIGHT);

		drawRobot();
	}

	private void drawRobot() {
		drawFaceOutline();
		drawMouth();
		drawEyes();
		drawEars();
		drawNose();
		drawAntena();
	}

	private void drawFaceOutline() {
		int faceX = (WIDTH - FACE_WIDTH) / 2;
		int faceY = (HEIGHT - FACE_HEIGHT) / 2;

		GRect faceRect = new GRect(FACE_WIDTH, FACE_HEIGHT);
		add(faceRect, faceX, faceY);
	}

	private void drawEyes() {
		int eye1X = (WIDTH) / 2 - EYE_WIDTH - EYE_OFFSET_FROM_CENTER;
		int eye1Y = (HEIGHT - FACE_HEIGHT) / 2 + EYE_OFFSET_FROM_TOP;

		GOval eye1 = new GOval(EYE_WIDTH, EYE_HEIGHT);
		add(eye1, eye1X, eye1Y);

		int eye2X = WIDTH / 2 + EYE_OFFSET_FROM_CENTER;
//		int eye1Y = (HEIGHT - FACE_HEIGHT) / 2 + EYE_OFFSET_FROM_TOP;

		GOval eye2 = new GOval(EYE_WIDTH, EYE_HEIGHT);
		add(eye2, eye2X, eye1Y);
	}

	private void drawMouth() {
		int mouthX = (WIDTH - MOUTH_WIDTH) / 2;
		int mouthY = (HEIGHT + FACE_HEIGHT) / 2 - MOUTH_OFFSET_FROM_BOTTOM - MOUTH_HEIGHT;

		GRect mouthRect = new GRect(MOUTH_WIDTH, MOUTH_HEIGHT);
		add(mouthRect, mouthX, mouthY);

		// Draw Teeth
		// 1. Horizontal Line
		int lineY = mouthY + MOUTH_HEIGHT / 2;
		GLine teethHorLine = new GLine(mouthX, lineY, mouthX + MOUTH_WIDTH, lineY);
		add(teethHorLine);

		// 2. Vertical Line
		int startY = mouthY;
		int endY = mouthY + MOUTH_HEIGHT;
		for (int i = 0; i < MOUTH_TEETH_COUNT; i++) {
			int curX = mouthX + i * MOUTH_WIDTH / MOUTH_TEETH_COUNT;
			GLine teethVertLine = new GLine(curX, startY, curX, endY);
			add(teethVertLine);
		}
	}

	private void drawNose() {
		int bottomLineY = (HEIGHT + FACE_HEIGHT) / 2 - NOSE_OFFSET_FROM_BOTTOM;
		int bottomLineX1 = (WIDTH - NOSE_WIDTH) / 2;
		int bottomLineX2 = (WIDTH + NOSE_WIDTH) / 2;

		GLine bottomLine = new GLine(bottomLineX1, bottomLineY, bottomLineX2, bottomLineY);
		add(bottomLine);

		int upperLineY = bottomLineY - NOSE_HEIGHT;
		int upperLineX = WIDTH / 2;
		GLine upperLine1 = new GLine(bottomLineX1, bottomLineY, upperLineX, upperLineY);
		add(upperLine1);
		GLine upperLine2 = new GLine(bottomLineX2, bottomLineY, upperLineX, upperLineY);
		add(upperLine2);
	}

	private void drawAntena() {
		int antenaX = WIDTH / 2;
		int antenaY1 = (HEIGHT - FACE_HEIGHT) / 2;
		int antenaY2 = (HEIGHT - FACE_HEIGHT) / 2 - ANTENA_HEIGHT;

		GLine antenaLine = new GLine(antenaX, antenaY1, antenaX, antenaY2);
		add(antenaLine);

		int circleX = antenaX - ANTENA_CIRCLE_R;
		int circleY = antenaY2 - ANTENA_CIRCLE_R * 2;
		GOval antenaOval = new GOval(ANTENA_CIRCLE_R * 2, ANTENA_CIRCLE_R * 2);
		add(antenaOval, circleX, circleY);
	}

	private void drawEars() {
		int earY = (HEIGHT - EAR_HEIGHT) / 2;
		int ear1X = (WIDTH - FACE_WIDTH) / 2 - EAR_WIDTH;
		int ear2X = (WIDTH + FACE_WIDTH) / 2;

		GRect ear1Rect = new GRect(EAR_WIDTH, EAR_HEIGHT);
		add(ear1Rect, ear1X, earY);
		GRect ear2Rect = new GRect(EAR_WIDTH, EAR_HEIGHT);
		add(ear2Rect, ear2X, earY);
	}

}
