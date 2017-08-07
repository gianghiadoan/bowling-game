package bowling;

public class Frame {
	/**
	 * The Maximun of hiting bowling ball pr frame.
	 */
	public static final int MAX_HIT_BALL = 2;
	/**
	 * The Maximun of pins.
	 */
	public static final int MAX_PINS = 10;
	/**
	 * Array scores obj.
	 */
	private int[] scores = new int[MAX_HIT_BALL];
	/**
	 * The number  of pins.
	 */
	private int noOfPins = 10;
	/**
	 * The number of pins remains.
	 */
	private int noAttempts = 0;
	/**
	 * Obj trick.
	 */
	private boolean isStrike = false;
	/**
	 * The return true/false spare frame?.
	 */
	public boolean isSpare() {
		return noOfPins == 0 && noAttempts == MAX_HIT_BALL && !isStrike;
	}
	/**
	 * The return true/false trick frame?.
	 */
	public boolean isStrike() {
		return noOfPins == 0 && noAttempts == MAX_HIT_BALL && isStrike;
	}


	public void setScore(int score) {

		scores[noAttempts++] = score;
		noOfPins -= score; // keep track of remaining pins/frame

		// strike for roll
		if (score == MAX_PINS) {
			isStrike = true;
			BowlingScore.strikeCounter++;
		}
	}


	public int score() {
		return scores[0] + scores[1];
	}

	public int getFirstScore() {
		return scores[0];
	}

	public int getSecondScore() {
		return scores[1];
	}

}
