package hw;

import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.상품정보(TV와 Refrigerator)를 저장\r\n" + 
				"2.상품정보 전체를 검색하는 기능\r\n" + 
				"3.상품번호로 상품을 검색하는 기능\r\n" + 
				"4.상품명으로 상품을 검색하는 기능(상품명 부분 검색 가능)\r\n" + 
				"5.TV정보만 검색\r\n" + 
				"6.Refrigerator만 검색\r\n" + 
				"7.400L 이상의 Refrigerator 검색\r\n" + 
				"8.50inch 이상의 TV검색\r\n" + 
				"9.상품번호와 가격을 입력 받아 상품 가격을 변경할 수 있는 기능\r\n" + 
				"10.상품번호로 상품을 삭제하는 기능\r\n" + 
				"11.전체 재고 상품 금액을 구하는 기능\r\n "+
				"종료하려면 0번을 입력해주세요.");
		
		System.out.println("원하는 기능의 번호를 입력해 주세요");
		ProductMgrImpl pm = new ProductMgrImpl();
		int num = 1;
		while(num != 0) {
			System.out.println("원하는 기능의 번호를 입력해 주세요");
			num = sc.nextInt();
			switch(num) {
			case 1:
				System.out.println("TV를 입력하려면 1번, 냉장고를 입력하려면 2번을 입력해주세요");
				int select = sc.nextInt();
				if(select == 1) {
					System.out.println("상품번호, 가격, 번호, 상품이름, inch순으로 입력해주세요");
					TV b = new TV(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next(),sc.nextInt());
					pm.Input(b);
					System.out.println("TV 정보 입력이 완료 되었습니다.");
				}
				else {
					System.out.println("상품번호, 가격, 번호, 상품이름, 리터순 으로 입력해주세요");
					Refrigerator b = new Refrigerator(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next(),sc.nextInt());
					pm.Input(b);
					System.out.println("냉장고 정보가 입력이 완료 되었습니다.");
				}
				break;
			case 2:
				System.out.println("현재 관리중인 제품들 입니다.");
				pm.search();
				break;
			case 3:
				System.out.println("찾고자 하는 제품 번호를 입력해주세요");
				int bunho = sc.nextInt();
				pm.search_bunho(bunho);
				break;
			case 4:
				System.out.println("찾고자 하는 상품명의 부분을 입력해주세요");
				String name = sc.next();
				pm.search_name(name);
				break;
			case 5:
				System.out.println("현재 관리중인 TV들 입니다.");
				pm.search_TV();
				break;
			case 6:
				System.out.println("현재 관리중인 냉장고들 입니다.");
				pm.search_Refrigerator();
				break;
			case 7:
				System.out.println("400L이상의 냉장고 검색 결과 입니다.");
				pm.search_up400();
				break;
			case 8:
				System.out.println("50inch이상의 TV 검색 결과입니다.");
				pm.search_up50();
				break;
			case 9:
				System.out.println("변경하고자 하는 상품번호를 입력해주세요");
				int bunho2 = sc.nextInt();
				System.out.println("변경하고자 하는 가격을 입력해주세요");
				int price = sc.nextInt();
				pm.search_price(bunho2,price);
				break;
			case 10:
				System.out.println("삭제하고자 하는 상품번호를 입력해주세요");
				int bunho3 = sc.nextInt();
				pm.delete_p(bunho3);;
				break;
			case 11:
				System.out.println("저장된 모든 가전제품의 금액 합계의 평균입니다.");
				pm.print_sum();
				break;
			}
		}
		
	
	
		

	}


}
