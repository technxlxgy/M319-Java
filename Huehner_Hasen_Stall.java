public class Main {
	public static void main(String[] args){
		int köpfe = 2;
		int beine = 10;

		int hühner = (beine - 2 * köpfe) / 2;
		int hasen = (köpfe - hühner);

		System.out.println("Es hat " + hasen + " Hasen und " + hühner + " Hühner im Stall.");
	}
}