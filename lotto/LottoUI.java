package lotto;

import java.text.DecimalFormat;
import java.util.*;

public class LottoUI {
	
	LottoManager mgr = new LottoManager();
	Scanner sc = new Scanner(System.in);
	
	ArrayList<HashSet<Integer>> myLotto = new ArrayList<>();
	
	public LottoUI(){												//UI ������
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
			System.out.println("�̿��� �ּż� �����մϴ�.");
			System.exit(0);
			break;
		default :
			System.out.println("������ ��ȣ�� �Է��ϼ���.");
			System.out.print("����Ϸ��� ���͸� �Է��ϼ���.");
			String z = sc.nextLine();
			break;
		}//switch
		}//while���ѷ���
		
	}//LottoUI������
	
	public String showMainMenu(){									//���θ޴� ǥ��
		System.out.println("======================");
		System.out.println("�ζ� ��÷�� �����ϼ���");
		System.out.println("======================");
		System.out.println("1.�ζ� ����");
		System.out.println("2.�̹� ȸ�� ������ ��ȣ Ȯ��");
		System.out.println("3.�̹� ȸ�� ��÷ Ȯ��");
		System.out.println("    ��, Ȯ������ ���� ���ŷζǴ� ������� ���� ȸ���� �Ѿ�� �˴ϴ�.");
		System.out.println("99.������");
		System.out.println();
		System.out.print("��ȣ�� �Է��ϼ��� : ");
		String a = sc.nextLine();
		return a;
	}
	
	public void buyLotto(){											//�ζ� ���� buyLotto()
		
		while (true){
		System.out.println("======================");
		System.out.println("ȯ���մϴ� �ζ��� ����");
		System.out.println("======================");
		System.out.println("1. �ڵ� ��ȣ ����");
		System.out.println("2. ���� ��ȣ ����");
		System.out.println("3. ���� �޴���");
		System.out.print("��ȣ�� �Է��ϼ��� : ");
		String a = sc.nextLine();
		
		switch (a){
			case "1" :
				HashSet<Integer> makeL = mgr.makeLottoNumbers();
				myLotto.add(makeL);
					System.out.println();
					System.out.println(myLotto.size()+"��° ����");
					System.out.print("�ڵ������� ��ȣ : ");
					System.out.println(makeL);
					System.out.print("����Ϸ��� ���͸� �Է��ϼ���.");
					String z = sc.nextLine();
				break;
			case "2" :
				HashSet<Integer> inputL = mgr.inputLottoNumbers();
				myLotto.add(inputL);
					System.out.println();
					System.out.println(myLotto.size()+"��° ����");
					System.out.print("�Է��� ��ȣ : ");
					System.out.println(inputL);
					System.out.print("����Ϸ��� ���͸� �Է��ϼ���.");
					 z = sc.nextLine();
				break;
			case "3" :
				System.out.println("���� �޴��� ���ư��ϴ�.");
				System.out.print("����Ϸ��� ���͸� �Է��ϼ���.");
				 z = sc.nextLine();
				return;
			default :
				System.out.println("������ ��ȣ�� �Է��ϼ���.");
				System.out.print("����Ϸ��� ���͸� �Է��ϼ���.");
				z = sc.nextLine();
				break;
		}//switch
		}//while���ѷ���
		
	}//buyLotto()
	
	public void checkMyLotto(){										//������ ��ȣ Ȯ�� checkMyLotto()
		int i = 1;
		if (myLotto.size() != 0){
			for (HashSet<Integer> check : myLotto) {
				System.out.println(i++ + "��° ��ȣ : " + check);
			}
			System.out.print("����Ϸ��� ���͸� �Է��ϼ���.");
			String z = sc.nextLine();
		}else {
			System.out.println("*****������ �ζǰ� �����ϴ�.*****");
			System.out.print("����Ϸ��� ���͸� �Է��ϼ���.");
			String z = sc.nextLine();
		}
		
	}
	
	public void checkLotto(){										//��÷Ȯ�� �� ȸ�� �ʱ�ȭ checkLotto()
		HashSet<Integer> dang = mgr.makeLottoNumbers();				//�̹� ȸ�� ��÷��ȣ ����
		
		if (myLotto.size() != 0){							//myLotto�� ���� ��� ���� ��쿡�� �۵� �ϵ���.
			
		System.out.println("========================================================");
		System.out.println("�̹� ȸ���� ��÷��ȣ�� : " + dang + "�Դϴ�.");
		System.out.println("========================================================");
		System.out.println();
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		
		
		for (int index = 0; index < myLotto.size(); index++){
			int chk = mgr.checkLottoNumbers(dang, myLotto.get(index));
			
			System.out.println("����� " + (index+1) + "��° ��ȣ : " + myLotto.get(index));
			System.out.print((index+1) + "��° ��÷��� :");
			
			
			switch (chk) {
			case 6:
				System.out.println("1��!!!! ��������̽ó׿� ���� �ζ� �緯 ������!!");
				System.out.println();
				System.out.println(" ��_��");
				System.out.println("    ���� �ˣߥ�");
				System.out.println("      ��( '��' ) �ε�ĩ");
				System.out.println("        > ��<");
				System.out.println("       /   �ء�");
				System.out.println("      /    /  ���� ");
				System.out.println("     ��   ��     L_��");
				System.out.println("     /  /");
				System.out.println("    /  /|");
				System.out.println("   (  (�� �ε�ĩ");
				System.out.println("   |  |����");
				System.out.println("   | | �� ��)");
				System.out.println("   | |    ) /");
				System.out.println(" `�� )    LJ");
				count1++;
				break;
			case 5:
				System.out.println("3��");
				System.out.println();
				count3++;
				break;
			case 4:
				System.out.println("4��");
				System.out.println();
				count4++;
				break;
			case 3:
				System.out.println("5��");
				System.out.println();
				count5++;
				break;
			default:
				System.out.println("�����մϴ�!!! ���Դϴ�!");
				System.out.println();
				break;
			}
		}
		
		if (count1 > 0) System.out.println("1�� ��÷ Ƚ�� : " + count1);
		if (count2 > 0) System.out.println("2�� ��÷ Ƚ�� : " + count2);
		if (count3 > 0) System.out.println("3�� ��÷ Ƚ�� : " + count3);
		if (count4 > 0) System.out.println("4�� ��÷ Ƚ�� : " + count4);
		if (count5 > 0) System.out.println("5�� ��÷ Ƚ�� : " + count5);
		System.out.println("�� Ƚ�� : " + (myLotto.size() - count1 - count2 - count3 - count4 - count5));
		
		double x = (  ((double)(count1 + count2 + count3 + count4 + count5) / (double) myLotto.size())  * 100.0 );
		
		DecimalFormat df = new DecimalFormat("0.00");				//�Ҽ��� �ڸ��� ��� ǥ���ϴ� 
		double s = Double.parseDouble(df.format(x));				//DecimalFormat ����ϸ� parse�� ����ȯ�� ����� �ϳ���. �� �𸣰�����
		
		System.out.println("�̹� ȸ���� ��÷ Ȯ�� : " + s + "%");
		
		System.out.println();
		System.out.println("���� ȸ���� �Ѿ�ϴ� ^^ ����� �����.");
		System.out.println();
		System.out.print("����Ϸ��� ���͸� �Է��ϼ���.");
		String z = sc.nextLine();
		
		myLotto.removeAll(myLotto);
		
		}else {
			System.out.println("�ζǸ� ���� �����Ͻ���?");
			System.out.print("����Ϸ��� ���͸� �Է��ϼ���.");
			String z = sc.nextLine();
		}
		
	}//checkLotto

}//main
