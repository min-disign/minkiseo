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
			
			System.out.println("1.������ 2.�����"); 
			int number = scanner.nextInt();
			if (number == 2) {
			int num2 = 1;
			while (num2 == 1) {
				System.out.println("���� ����� �ı� �ż� = " + ticket);
				System.out.println("�ı� ����� ���� = " + ticketPrice);
				for (int i = 0; i < 6; i++) {
					System.out.println(money[i] + "�� , " + moneyCount[i] + "��");
				}
				
				System.out.println("1.����");
				int num = scanner.nextInt();
				if (num == 1) {
					System.out.println("�Ա��� �ݾ��� �����ϼ���");
					int inputMoneyCount[] = new int[6];
					int inputMoney = 0;
					while (true) {
						System.out.println("0.������ 1.���� 2.��õ�� 3.õ�� 4.����� 5.��� 6.����");
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
						
						System.out.println("������� �Աݵ� �ѱݾ� = " + inputMoney);	
					}
					
					if (inputMoney < ticketPrice) 
						break;
					
					System.out.println("�����Ϸ��� �ıǸż��� �Է��ϼ���");
						int ticketNumber = scanner.nextInt();
						if (ticket < ticketNumber) {
							break;	
						} else {
							ticketPriceTotal = ticketPrice * ticketNumber;
						}
						int exchange = inputMoney - ticketPriceTotal;
						if (exchange < 0) {//?
							System.out.println("�Ա��� �ݾ��� ����");
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
								System.out.println("===������===");
								System.out.println("�Աݱݾ� = " + inputMoney);
								System.out.println("�ѱݾ� = " + ticketPriceTotal);
								System.out.println("�Ž����� = " + exchange);
							} else {
								System.out.println("�Ž������� �����մϴ�");
							}
							
						}
						
					}
					
				}
				
			}
			
		}	
	 
	}
}