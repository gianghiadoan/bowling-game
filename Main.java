package bowling;

public class Main {

	public static void main(String[] args) {
		//create a refer to bowling score
		BowlingScore bs = new BowlingScore(11);
		/* fake data*/ 
		bs.roll(1, 0);bs.roll(4, 0);
		bs.roll(4, 1);bs.roll(5, 1);
		bs.roll(6, 2);bs.roll(4, 2);
		bs.roll(5, 3);bs.roll(5, 3);
		bs.roll(10, 4);bs.roll(0, 4);
		bs.roll(0, 5);bs.roll(1, 5);
		bs.roll(7, 6);bs.roll(3, 6);
		bs.roll(6, 7);bs.roll(4, 7);
		bs.roll(10,8);bs.roll(0, 8);
		bs.roll(2, 9);bs.roll(8, 9);
		bs.roll(6, 10); 
		 
		System.out.println(bs.score()+"");
		
	}

}
