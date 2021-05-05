package tsetabc;
import java.util.Scanner;

public class example {
	 public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int ticket = 5;
		int ticketPriceTotal = 0;
		int ticketPrice = 3200;
		int[] money = {50000, 10000, 5000, 1000, 500, 100};
		int[] moneyCount = {1,1,1,1,5,10};
		while (true) {
			
			System.out.println("1.관리자 2.사용자"); 
			int number = scanner.nextInt();
			if (number == 2) {
			int num2 = 1;
			while (num2 == 1) {
				System.out.println("현재 저장된 식권 매수 = " + ticket);
				System.out.println("식권 한장당 가격 = " + ticketPrice);
				for (int i = 0; i < 6; i++) {
					System.out.println(money[i] + "권 , " + moneyCount[i] + "매");
				}
				
				System.out.println("1.구입");
				int num = scanner.nextInt();
				if (num == 1) {
					System.out.println("입금할 금액을 투입하세요");
					int inputMoneyCount[] = new int[6];
					int inputMoney = 0;
					while (true) {
						System.out.println("0.오만원 1.만원 2.오천원 3.천원 4.오백원 5.백원 6.종료");
						int inputNum = scanner.nextInt();
						
						if (inputNum == 6) {
							break;
						} else {
							inputMoneyCount[inputNum] += 1;
						}
						
						inputMoney = 0;
						for (int i = 0; i < inputMoneyCount.length; i++) {
							inputMoney = (inputMoney + (inputMoneyCount[i] * money[i]));
						}
						
						System.out.println("현재까지 입금된 총금액 = " + inputMoney);	
					}
					
					if (inputMoney < ticketPrice) 
						break;
					
					System.out.println("구입하려는 식권매수를 입력하세요");
						int ticketNumber = scanner.nextInt();
						if (ticket < ticketNumber) {
							break;	
						} else {
							ticketPriceTotal = ticketPrice * ticketNumber;
						}
						int exchange = inputMoney - ticketPriceTotal;
						if (exchange < 0) {//?
							System.out.println("입금한 금액이 적다");
						} else {
							int[] checkCharge = new int[6];
							for (int i = 0; i < 6; i++) {
								 checkCharge[i]  = moneyCount[i];
								 
							}
							int exchangeCheck = exchange;
							for (int i = 0; i < 6; i++) {
								int checkRun = 1;
								while (checkRun == 1) {
									if (exchangeCheck >= money[i] && checkCharge[i] > 0) {
										exchangeCheck = exchangeCheck  - money[i];
										checkCharge[i] -= 1;
									} else {
										checkRun = 0;
										break;
									}
								}
							}
							
							if (exchangeCheck == 0) {//?
								for (int i = 0; i < 6; i++) {
									moneyCount[i]  = checkCharge[i];
									moneyCount[i] += inputMoneyCount[i];
									
								}
								ticket -= ticketNumber;
								System.out.println("===영수증===");
								System.out.println("입금금액 = " + inputMoney);
								System.out.println("총금액 = " + ticketPriceTotal);
								System.out.println("거스름돈 = " + exchange);
							} else {
								System.out.println("거스름돈이 부족합니다");
							}
							
						}
						
					}
					
				}
				
			}
			
		}	
	 
	}
}