package hw;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductMgr pm = new ProductMgr();
		int num = -1;
		while(num != 0) {
			System.out.println("1. 상품정보 입력 기능\r\n" + 
					"2. 상품정보 전체 검색 기능\r\n" + 
					"3. 상품번호로 상품을 검색하는 기능\r\n" + 
					"4. 상품명으로 상품을 검색하는 기능\r\n" + 
					"5. TV정보만 검색하는 기능\r\n" + 
					"6. Refrigerator만 검색하는 기능\r\n" + 
					"7. 상품번호로 상품을 삭제하는 기능\r\n" + 
					"8. 전체 재고 상품 금액을 구하는 기능\r\n" + 
					 "\r\n" + "종료하시려면 0번을 눌러주세요!");
			num = sc.nextInt();
			switch(num)
			{
				
			case 1:
				System.out.println("1.TV를 입력할지 2.냉장고를 입력할지 번호를 선택해주세요.");
				int bun = sc.nextInt();
				if(bun == 1)
				{
					System.out.print("상품 번호, 이름, 가격, 수량, 인치, dispaly정보 순으로 입력해주세요");
					int sang_bun = sc.nextInt();
					String name = sc.next();
					int price = sc.nextInt();
					int su = sc.nextInt();
					int inch = sc.nextInt();
					String dis = sc.next();
					pm.input(sang_bun, name, price, su, inch, dis);
					System.out.println("입력이 완료 되었습니다");
				}
				else if(bun == 2) {
					System.out.print("상품 번호, 이름, 가격, 수량, 크기 순으로 입력해주세요");
					int sang_bun = sc.nextInt();
					String name = sc.next();
					int price = sc.nextInt();
					int su = sc.nextInt();
					int size = sc.nextInt();
					pm.input(sang_bun, name, price, su, size);
					System.out.println("입력이 완료 되었습니다");
				}
				break;
			case 2:
				pm.search();
				break;
			case 3:
				System.out.print("찾고싶은 상품번호를 입력해주세요");
				int bunho = sc.nextInt();
				pm.search_bun(bunho);
				break;
			case 4:
				System.out.print("찾고싶은 상품명을 입력해주세요 " );
				String name = sc.next();
				pm.search_name(name);
				break;
			case 5:
				pm.search_tv();
				break;
			case 6:
				pm.search_re();
				break;
			case 7:
				System.out.print("삭제하고 싶은 상품의 번호를 입력해주세요" );
				int del_num = sc.nextInt();
				pm.delete(del_num);
				break;
			case 8:
				System.out.println("저장된 모든 상품의 금액 합계는 " + pm.sum()+ "원입니다");
				break;
			default:
			}
		}
		System.out.println("bye bye!~");
	}

}
