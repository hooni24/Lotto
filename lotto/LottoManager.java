package lotto;

import java.util.HashSet;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class LottoManager {
	
	public HashSet<Integer> makeLottoNumbers(){			//자동로또생성
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
	
	
	public HashSet<Integer> inputLottoNumbers(){		//직접입력생성
		
		HashSet<Integer> inNums = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i < 7; i++){
			System.out.printf("%d번째 값 : ", i);
			int num = sc.nextInt();
			if (num > 0 && num < 46){
				if (inNums.contains(num)){
					System.out.println("이미 입력한 숫자입니다.");
					i--;
				}else{
					inNums.add(num);
				}
			}else{
				System.out.println("1~45를 입력하세요");
				i--;
			}
			
		}
		return inNums;
	}
	
	public int checkLottoNumbers(HashSet<Integer> com , HashSet<Integer> user){		//직접입력한거랑 자동생성된거 비교해서 갯수를 result반환
		int result = 0;
		
		for (int num : user) {
			if (com.contains(num)){
				result++;
			}
		}		
		return result;
	}

}
