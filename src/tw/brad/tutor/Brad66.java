package tw.brad.tutor;

public class Brad66 {
	public static void main(String[] args) {
		StoreV2 store = new StoreV2();
		ProducerV2 p1 = new ProducerV2(store);
		ConsumerV2 c1 = new ConsumerV2(store, "Brad");
		ConsumerV2 c2 = new ConsumerV2(store, "Tony");
		
		p1.start();
		c1.start();
		c2.start();
	}
}
class StoreV2 {
	private int qty;
	private final int max = 10;

	synchronized void add(int add) throws InterruptedException{
		System.out.printf("進貨中... %d\n", add);
		while (qty + add  > max) {
			wait();
		}
		qty += add;
		notify();
		System.out.printf("完成進貨: %d, 目前庫存量: %d\n", add, qty);
	}
	
	synchronized void buy(int buy, String name) throws InterruptedException{
		System.out.printf("%s:想買貨... %d\n", name, buy);
		while (qty < buy) {
			wait();
		}
		qty -= buy;
		notify();
		System.out.printf("%s 完成買貨: %d, 目前庫存量: %d\n", name, buy, qty);
	}
}

class ProducerV2 extends Thread {
	private StoreV2 store;
	ProducerV2(StoreV2 store){this.store = store;}
	@Override
	public void run() {
		for (int i=0; i<7; i++) {
			try {
				store.add(5);
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}

class ConsumerV2 extends Thread {
	private StoreV2 store;
	private String name;
	ConsumerV2(StoreV2 store, String name){
		this.store = store;
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			try {
				store.buy((int)(Math.random()*3)+1, name);
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}




