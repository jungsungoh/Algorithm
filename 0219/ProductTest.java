package hw;

import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.��ǰ����(TV�� Refrigerator)�� ����\r\n" + 
				"2.��ǰ���� ��ü�� �˻��ϴ� ���\r\n" + 
				"3.��ǰ��ȣ�� ��ǰ�� �˻��ϴ� ���\r\n" + 
				"4.��ǰ������ ��ǰ�� �˻��ϴ� ���(��ǰ�� �κ� �˻� ����)\r\n" + 
				"5.TV������ �˻�\r\n" + 
				"6.Refrigerator�� �˻�\r\n" + 
				"7.400L �̻��� Refrigerator �˻�\r\n" + 
				"8.50inch �̻��� TV�˻�\r\n" + 
				"9.��ǰ��ȣ�� ������ �Է� �޾� ��ǰ ������ ������ �� �ִ� ���\r\n" + 
				"10.��ǰ��ȣ�� ��ǰ�� �����ϴ� ���\r\n" + 
				"11.��ü ��� ��ǰ �ݾ��� ���ϴ� ���\r\n "+
				"�����Ϸ��� 0���� �Է����ּ���.");
		
		System.out.println("���ϴ� ����� ��ȣ�� �Է��� �ּ���");
		ProductMgrImpl pm = new ProductMgrImpl();
		int num = 1;
		while(num != 0) {
			System.out.println("���ϴ� ����� ��ȣ�� �Է��� �ּ���");
			num = sc.nextInt();
			switch(num) {
			case 1:
				System.out.println("TV�� �Է��Ϸ��� 1��, ����� �Է��Ϸ��� 2���� �Է����ּ���");
				int select = sc.nextInt();
				if(select == 1) {
					System.out.println("��ǰ��ȣ, ����, ��ȣ, ��ǰ�̸�, inch������ �Է����ּ���");
					TV b = new TV(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next(),sc.nextInt());
					pm.Input(b);
					System.out.println("TV ���� �Է��� �Ϸ� �Ǿ����ϴ�.");
				}
				else {
					System.out.println("��ǰ��ȣ, ����, ��ȣ, ��ǰ�̸�, ���ͼ� ���� �Է����ּ���");
					Refrigerator b = new Refrigerator(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next(),sc.nextInt());
					pm.Input(b);
					System.out.println("����� ������ �Է��� �Ϸ� �Ǿ����ϴ�.");
				}
				break;
			case 2:
				System.out.println("���� �������� ��ǰ�� �Դϴ�.");
				pm.search();
				break;
			case 3:
				System.out.println("ã���� �ϴ� ��ǰ ��ȣ�� �Է����ּ���");
				int bunho = sc.nextInt();
				pm.search_bunho(bunho);
				break;
			case 4:
				System.out.println("ã���� �ϴ� ��ǰ���� �κ��� �Է����ּ���");
				String name = sc.next();
				pm.search_name(name);
				break;
			case 5:
				System.out.println("���� �������� TV�� �Դϴ�.");
				pm.search_TV();
				break;
			case 6:
				System.out.println("���� �������� ������ �Դϴ�.");
				pm.search_Refrigerator();
				break;
			case 7:
				System.out.println("400L�̻��� ����� �˻� ��� �Դϴ�.");
				pm.search_up400();
				break;
			case 8:
				System.out.println("50inch�̻��� TV �˻� ����Դϴ�.");
				pm.search_up50();
				break;
			case 9:
				System.out.println("�����ϰ��� �ϴ� ��ǰ��ȣ�� �Է����ּ���");
				int bunho2 = sc.nextInt();
				System.out.println("�����ϰ��� �ϴ� ������ �Է����ּ���");
				int price = sc.nextInt();
				pm.search_price(bunho2,price);
				break;
			case 10:
				System.out.println("�����ϰ��� �ϴ� ��ǰ��ȣ�� �Է����ּ���");
				int bunho3 = sc.nextInt();
				pm.delete_p(bunho3);;
				break;
			case 11:
				System.out.println("����� ��� ������ǰ�� �ݾ� �հ��� ����Դϴ�.");
				pm.print_sum();
				break;
			}
		}
		
	
	
		

	}


}
