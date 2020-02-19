package hw;

public interface IProductMgr {
	void Input(Product b);
	void search();
	void search_bunho(int bunho);
	void search_name(String name);
	void search_TV();
	void search_Refrigerator();
	void search_up400();
	void search_up50();
	void search_price(int bun,int price);
	void delete_p(int bun);
	void print_sum();
}
