public class Item {

	private String name;
	private float price;
	private int quantity;

	private Item() { }

	public Item(String name, float price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() { return name; }

	public int getQuantity() { return quantity; }

	public float getPrice() { return price; }

	public void decreaseInventory(int quantity) {
		this.quantity -= quantity;
	}
}
