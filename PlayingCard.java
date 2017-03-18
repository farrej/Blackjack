import java.util.Random;
import java.util.Arrays;
class PlayingCard{
	private String [] cards; 
	private int total;

	public PlayingCard(String[]cardList, int cardVal){
		cards = cardList;
		total = cardVal;
	}
	public static String getRandomCard(){
		//arrays to hold values of cards and array to hold suits
		String [] clubs   = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String [] hearts  = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String [] spades  = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String [] diamonds ={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String [][] suit =  {clubs,hearts,spades,diamonds};
		
		//selects a random suit
		Random genSuit = new Random();
		int ranSuit = genSuit.nextInt(suit.length);

		//selects a random card from previous random suit
		Random genCard = new Random();
		int ranCard = genCard.nextInt(suit[ranSuit].length);

		return suit[ranSuit][ranCard];
	}
	//converts the string value into an int and returns int
	public static int getCardValue(String card){
		int x = 0;
		switch(card){
			case "A": x= 11; break;
			case "2": x= 2;  break;
			case "3": x= 3;  break;
			case "4": x= 4;  break;
			case "5": x= 5;  break;
			case "6": x= 6;  break;
			case "7": x= 7;  break;
			case "8": x= 8;  break;
			case "9": x= 9;  break;
			case"10": x= 10; break;
			case "J": x= 10; break;
			case "Q": x= 10; break;
			case "K": x= 10; break;
		}
		return x;
	}
	//returns a string of all the values in array of cards without null
	public static String printCards(String [] x){
		String str = "";
		for(int i = 0; i < x.length; i++){
			if(x[i] != null){
				str += x[i] + ",";
			}
		}
		return str;
	}
}
