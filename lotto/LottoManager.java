package lotto;

import java.util.HashSet;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class LottoManager {
	
	public HashSet<Integer> makeLottoNumbers(){			//�ڵ��ζǻ���
		HashSet<Integer> numbers = new HashSet<>();
		
		while (true) {
			int num = (int)(Math.random() * 45 ) + 1;
			numbers.add(num);
		
			if (numbers.size() == 6){
				break;
			}
		}
		return numbers;
	}
	
	
	public HashSet<Integer> inputLottoNumbers(){		//�����Է»���
		
		HashSet<Integer> inNums = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i < 7; i++){
			System.out.printf("%d��° �� : ", i);
			int num = sc.nextInt();
			if (num > 0 && num < 46){
				if (inNums.contains(num)){
					System.out.println("�̹� �Է��� �����Դϴ�.");
					i--;
				}else{
					inNums.add(num);
				}
			}else{
				System.out.println("1~45�� �Է��ϼ���");
				i--;
			}
			
		}
		return inNums;
	}
	
	public int checkLottoNumbers(HashSet<Integer> com , HashSet<Integer> user){		//�����Է��ѰŶ� �ڵ������Ȱ� ���ؼ� ������ result��ȯ
		int result = 0;
		
		for (int num : user) {
			if (com.contains(num)){
				result++;
			}
		}		
		return result;
	}

}
