package bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingScore implements BowlingGame {
	/**
	 * List frame obj.
	 */
	private final List<Frame> frames;
	/**
	 * Mark of all trick.
	 */
	private static final int ALL_STRIKE_SCORE = 300;
	/**
	 * Strick counter obj
	 */
	public static int strikeCounter = 0;

	public BowlingScore(int noOfFrame) {

		frames = new ArrayList<Frame>(noOfFrame);

		for (int i = 0; i < noOfFrame; i++) {
			frames.add(new Frame());
		}
	}

	@Override
	public void roll(int noOfPins, int index) {
		Frame frame = getCurrentFrame(index);
		if (noOfPins > frame.MAX_PINS) {
			throw new BowlingException("illegal argument " + noOfPins);
		}

		if (frame == null) {
			throw new BowlingException("all attempts exhausted - start new game");
		}

		// set score for frame
		frame.setScore(noOfPins);

	}

	@Override
	public int score() {

		int score = 0;
		int index = 0;
		// retrun 300 markd
		if (isAllStrikes()) {
			return ALL_STRIKE_SCORE;
		}
		for (int i = 0; i < frames.size(); i++) {

			if (getCurrentFrame(i).isStrike()) {
				if (getCurrentFrame(i + 1).isStrike() && getCurrentFrame(i + 2).isStrike())
					score += 30;
				else if (getCurrentFrame(i + 1).isStrike() && !getCurrentFrame(i + 2).isStrike())
					score += 20 + getCurrentFrame(i + 2).score();
				else {
					score += 10 + getCurrentFrame(i + 1).score();
				}
			}

			else if (getCurrentFrame(i).isSpare()) {
				score += 10 + getCurrentFrame(i + 1).getFirstScore();
			}

			else {
				if (i <= 9)
					score += getCurrentFrame(i).score();
			}

		}

		return score;
	}

	/**
	 * Return current frame
	 * 
	 * @param index
	 * @return
	 */
	private Frame getCurrentFrame(int index) {
		return frames.get(index);
	}

	/**
	 * Return all is tricked?
	 * 
	 * @return
	 */
	private boolean isAllStrikes() {
		return strikeCounter == 12;

	}

	/*
	 * Msg for excetion
	 */
	public class BowlingException extends RuntimeException {

		BowlingException(String message) {
			super(message);
		}

	}

}
