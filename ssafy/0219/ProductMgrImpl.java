package hw;

import java.util.ArrayList;


public class ProductMgrImpl implements IProductMgr{
	static ArrayList<Product> al = new ArrayList<>();
	@Override
	public void Input(Product b) {
		// TODO Auto-generated method stub
		al.add(b);
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
	}

	@Override
	public void search_bunho(int bunho) {
		// TODO Auto-generated method stub
		for(int i=0; i<al.size(); i++) {
			if(al.get(i).getBunho()== bunho) {
				System.out.println(al.get(i));
			}
		}
	}

	@Override
	public void search_name(String name) {
		// TODO Auto-generated method stub
		for(int i=0; i<al.size(); i++) {
			if(al.get(i).getName().contains(name)) {
				System.out.println(al.get(i));
			}
			
		}
	}

	@Override
	public void search_TV() {
		// TODO Auto-generated method stub
		for(int i=0; i<al.size(); i++) {
			if(al.get(i) instanceof TV) {
				System.out.println(al.get(i));
			}
		}
	}

	@Override
	public void search_Refrigerator() {
		// TODO Auto-generated method stub
		for(int i=0; i<al.size(); i++) {
			if(al.get(i) instanceof Refrigerator) {
				System.out.println(al.get(i));
			}
		}
	}

	@Override
	public void search_up400() {
		// TODO Auto-generated method stub
		for(int i=0; i<al.size(); i++) {
			if(al.get(i) instanceof TV) {
				TV t = (TV)al.get(i);
				if(t.getInch() >= 400) {
					System.out.println(t);
				}
			}
		}
	}

	@Override
	public void search_up50() {
		// TODO Auto-generated method stub
		for(int i=0; i<al.size(); i++) {
			if(al.get(i) instanceof Refrigerator) {
				Refrigerator t = (Refrigerator)al.get(i);
				if(t.getL() >= 50) {
					System.out.println(t);
				}
			}
		}
	}

	@Override
	public void search_price(int bun, int price) {
		// TODO Auto-generated method stub
		for(int i=0; i<al.size(); i++) {
			if(al.get(i).getBunho() == bun) {
				al.get(i).setPrice(price);
			}
		}
	}

	@Override
	public void delete_p(int bun) {
		// TODO Auto-generated method stub
		for(int i=0; i<al.size(); i++) {
			if(al.get(i).getBunho() == bun) {
				al.remove(i);
			}
		}
		
	}

	@Override
	public void print_sum() {
		// TODO Auto-generated method stub
		int sum = 0;
		// TODO Auto-generated method stub
		for(int i=0; i<al.size(); i++) {
			sum += al.get(i).getPrice();	
		}
		System.out.println("저장된 모든 재고의 금액 합계는 " +sum);
	}

}
