package bowling;

public interface BowlingGame {

	 /**
     * Keeps track of pins knocked over/ set point of frame
     * @param  pins knocked over per frame
     *  @param  index of frame frame
     */
    public void roll(int pins ,int index);

    /**
     * Score of frame
     * @return score 
     */
    public int score();
}
