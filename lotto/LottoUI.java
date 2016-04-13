package lotto;

import java.text.DecimalFormat;
import java.util.*;

public class LottoUI {
	
	LottoManager mgr = new LottoManager();
	Scanner sc = new Scanner(System.in);
	
	ArrayList<HashSet<Integer>> myLotto = new ArrayList<>();
	
	public LottoUI(){												//UI 생성자
		while(true){
			
		String a = showMainMenu();
		switch (a){
		case "1" :
			buyLotto();
			break;
		case "2" :
			checkMyLotto();
			break;
		case "3" :
			checkLotto();
			break;
		case "99" :
			System.out.println("이용해 주셔서 감사합니다.");
			System.exit(0);
			break;
		default :
			System.out.println("정해진 번호만 입력하세요.");
			System.out.print("계속하려면 엔터를 입력하세요.");
			String z = sc.nextLine();
			break;
		}//switch
		}//while무한루프
		
	}//LottoUI생성자
	
	public String showMainMenu(){									//메인메뉴 표시
		System.out.println("======================");
		System.out.println("로또 당첨에 도전하세요");
		System.out.println("======================");
		System.out.println("1.로또 구매");
		System.out.println("2.이번 회차 구매한 번호 확인");
		System.out.println("3.이번 회차 당첨 확인");
		System.out.println("    단, 확인이후 기존 구매로또는 사라지고 다음 회차로 넘어가게 됩니다.");
		System.out.println("99.나가기");
		System.out.println();
		System.out.print("번호를 입력하세요 : ");
		String a = sc.nextLine();
		return a;
	}
	
	public void buyLotto(){											//로또 구매 buyLotto()
		
		while (true){
		System.out.println("======================");
		System.out.println("환영합니다 로또의 세계");
		System.out.println("======================");
		System.out.println("1. 자동 번호 선택");
		System.out.println("2. 수동 번호 선택");
		System.out.println("3. 이전 메뉴로");
		System.out.print("번호를 입력하세요 : ");
		String a = sc.nextLine();
		
		switch (a){
			case "1" :
				HashSet<Integer> makeL = mgr.makeLottoNumbers();
				myLotto.add(makeL);
					System.out.println();
					System.out.println(myLotto.size()+"번째 구매");
					System.out.print("자동생성된 번호 : ");
					System.out.println(makeL);
					System.out.print("계속하려면 엔터를 입력하세요.");
					String z = sc.nextLine();
				break;
			case "2" :
				HashSet<Integer> inputL = mgr.inputLottoNumbers();
				myLotto.add(inputL);
					System.out.println();
					System.out.println(myLotto.size()+"번째 구매");
					System.out.print("입력한 번호 : ");
					System.out.println(inputL);
					System.out.print("계속하려면 엔터를 입력하세요.");
					 z = sc.nextLine();
				break;
			case "3" :
				System.out.println("이전 메뉴로 돌아갑니다.");
				System.out.print("계속하려면 엔터를 입력하세요.");
				 z = sc.nextLine();
				return;
			default :
				System.out.println("정해진 번호만 입력하세요.");
				System.out.print("계속하려면 엔터를 입력하세요.");
				z = sc.nextLine();
				break;
		}//switch
		}//while무한루프
		
	}//buyLotto()
	
	public void checkMyLotto(){										//구매한 번호 확인 checkMyLotto()
		int i = 1;
		if (myLotto.size() != 0){
			for (HashSet<Integer> check : myLotto) {
				System.out.println(i++ + "번째 번호 : " + check);
			}
			System.out.print("계속하려면 엔터를 입력하세요.");
			String z = sc.nextLine();
		}else {
			System.out.println("*****구매한 로또가 없습니다.*****");
			System.out.print("계속하려면 엔터를 입력하세요.");
			String z = sc.nextLine();
		}
		
	}
	
	public void checkLotto(){										//당첨확인 및 회차 초기화 checkLotto()
		HashSet<Integer> dang = mgr.makeLottoNumbers();				//이번 회차 당첨번호 생성
		
		if (myLotto.size() != 0){							//myLotto에 뭔가 들어 있을 경우에만 작동 하도록.
			
		System.out.println("========================================================");
		System.out.println("이번 회차의 당첨번호는 : " + dang + "입니다.");
		System.out.println("========================================================");
		System.out.println();
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		
		
		for (int index = 0; index < myLotto.size(); index++){
			int chk = mgr.checkLottoNumbers(dang, myLotto.get(index));
			
			System.out.println("당신의 " + (index+1) + "번째 번호 : " + myLotto.get(index));
			System.out.print((index+1) + "번째 추첨결과 :");
			
			
			switch (chk) {
			case 6:
				System.out.println("1등!!!! 운수대통이시네요 당장 로또 사러 가세요!!");
				System.out.println();
				System.out.println(" ⊂_ㄱ");
				System.out.println("    ＼＼ Λ＿Λ");
				System.out.println("      ＼( 'ㅅ' ) 두둠칫");
				System.out.println("        > ⌒<");
				System.out.println("       /   へ＼");
				System.out.println("      /    /  ＼＼ ");
				System.out.println("     ㅣ   ノ     L_つ");
				System.out.println("     /  /");
				System.out.println("    /  /|");
				System.out.println("   (  (ㄱ 두둠칫");
				System.out.println("   |  |、＼");
				System.out.println("   | | ＼ ⌒)");
				System.out.println("   | |    ) /");
				System.out.println(" `ノ )    LJ");
				count1++;
				break;
			case 5:
				System.out.println("3등");
				System.out.println();
				count3++;
				break;
			case 4:
				System.out.println("4등");
				System.out.println();
				count4++;
				break;
			case 3:
				System.out.println("5등");
				System.out.println();
				count5++;
				break;
			default:
				System.out.println("축하합니다!!! 꽝입니다!");
				System.out.println();
				break;
			}
		}
		
		if (count1 > 0) System.out.println("1등 당첨 횟수 : " + count1);
		if (count2 > 0) System.out.println("2등 당첨 횟수 : " + count2);
		if (count3 > 0) System.out.println("3등 당첨 횟수 : " + count3);
		if (count4 > 0) System.out.println("4등 당첨 횟수 : " + count4);
		if (count5 > 0) System.out.println("5등 당첨 횟수 : " + count5);
		System.out.println("꽝 횟수 : " + (myLotto.size() - count1 - count2 - count3 - count4 - count5));
		
		double x = (  ((double)(count1 + count2 + count3 + count4 + count5) / (double) myLotto.size())  * 100.0 );
		
		DecimalFormat df = new DecimalFormat("0.00");				//소수점 자리수 끊어서 표현하는 
		double s = Double.parseDouble(df.format(x));				//DecimalFormat 사용하면 parse로 형변환을 해줘야 하나봄. 잘 모르겠지만
		
		System.out.println("이번 회차의 당첨 확률 : " + s + "%");
		
		System.out.println();
		System.out.println("다음 회차로 넘어갑니다 ^^ 행운을 빌어요.");
		System.out.println();
		System.out.print("계속하려면 엔터를 입력하세요.");
		String z = sc.nextLine();
		
		myLotto.removeAll(myLotto);
		
		}else {
			System.out.println("로또를 먼저 구매하시죵?");
			System.out.print("계속하려면 엔터를 입력하세요.");
			String z = sc.nextLine();
		}
		
	}//checkLotto

}//main
