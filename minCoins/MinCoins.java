import java.util.Collections;
import java.util.Vector;

public class MinCoins {

	
	public static void main(String[] args){
		Vector<Integer> coins = new Vector<Integer>();
		coins.add(1);
		coins.add(2);
		coins.add(5);
		int ans = minCoins(coins, 16);
		System.out.println(ans);
		
	}
	public static int minCoins(Vector<Integer> coins, int sum){
		int numCoins=0;
		Collections.sort(coins);
		int size = coins.size()-1;
		for(int i =size;i>=0;i--){
			int currentCoin = coins.elementAt(i);
			numCoins += sum/currentCoin;
			sum = sum%currentCoin;
		}		
		return numCoins;
	}
}
