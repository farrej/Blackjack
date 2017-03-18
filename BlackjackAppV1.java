import java.util.Random;
import java.util.Scanner;
class BlackjackAppV1{
	public static void main(String[]args){
		//creates player   (with array holding all cards + card totals)
		String [] Pcards = new String[10];
		int PcardTotal = 0;
		PlayingCard player = new PlayingCard(Pcards , PcardTotal);

		//creates computer (with array holding all cards + card totals)
		String [] Dcards = new String[10];
		int DcardTotal = 0;
		PlayingCard dealer = new PlayingCard(Dcards , DcardTotal);

		int PcardCount = 0;
		int DcardCount = 0;
		//Deal player and computer first 2 cards
		for(PcardCount =0; PcardCount < 2; PcardCount++){
			Pcards[PcardCount] = PlayingCard.getRandomCard();
			Dcards[DcardCount] = PlayingCard.getRandomCard();
			PcardTotal += player.getCardValue(Pcards[PcardCount]);
			DcardTotal += player.getCardValue(Dcards[DcardCount]);
			DcardCount++;
		}

		System.out.println("\nFirst Deal");
		System.out.println("Player:"+PlayingCard.printCards(Pcards)+"\t"+"Dealer:"+PlayingCard.printCards(Dcards));
		System.out.println("Player:"+PcardTotal+"\t"+"Dealer:"+DcardTotal);

		//exits if player or dealer are dealt 21
		if(PcardTotal == 21){
			System.out.println("Player wins!");
			System.exit(0);
		}else if(DcardTotal == 21){
			System.out.println("Dealer wins!");
			System.exit(0);
		}
		
		//Asks player whether to twist or stick..
		System.out.println(" \nPlayer: Twist(T) or Stick(S) ?");
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();

		//while loop will loop until it finds a system.exit which will be an end condition
		while(in != "S" || in != "s"){
			//deal player another card 
			if(in.equals("T") || in.equals("t")){
				System.out.println("Next Deal");
				Pcards[PcardCount] = PlayingCard.getRandomCard();
				PcardTotal += player.getCardValue(Pcards[PcardCount]);
				System.out.println("Player:"+PlayingCard.printCards(Pcards));
				System.out.println("Player:"+PcardTotal+"\t"+"Dealer:"+DcardTotal);
				System.out.println();
				PcardCount++;
			} 
			if(PcardTotal == 21){
				System.out.println("Player wins!");
				System.exit(0);
			}
			//deals dealer if the player is winning..
			else if(in.equals("S") || in.equals("s")){
				if(PcardTotal < 15 || PcardTotal < DcardTotal){
					System.out.println("Player cannot stick!");			
				}
				else{//dealer will keep taking cards until they have a score > than player and <= 21
					System.out.println("Dealers turn:");
					if(PcardTotal == DcardTotal){
						System.out.println("Dealer Sticks");
						System.out.println("Dealer wins!");
						System.exit(0);
					}
					while(PcardTotal > DcardTotal && DcardTotal <= 21){
						Dcards[DcardCount] = PlayingCard.getRandomCard();
						DcardTotal += player.getCardValue(Dcards[DcardCount]);
						System.out.println("\t\t"+"Dealer:"+PlayingCard.printCards(Dcards));
						System.out.println("Player:"+PcardTotal+"\t"+"Dealer:"+DcardTotal);
						DcardCount++;

						//Dealer keeps playing until this statement is true
						if(DcardTotal <= 21 && DcardTotal > PcardTotal || DcardTotal == PcardTotal){
							System.out.println("Dealer Sticks");
							System.out.println("Dealer wins!");
							System.exit(0);
						}
					}
				}
			} 
			if(PcardTotal > 21){
				System.out.println("You're bust! Dealer wins :(");
				System.exit(0);//player bust dealer wins
			}
			else if(DcardTotal > 21){
				System.out.println("Dealers Bust! You win :)");
				System.exit(0);//dealer bust player wins
			}
			System.out.println("Next Round: Twist(T) or Stick(S)");
			in = sc.nextLine();
		}
	}
}
