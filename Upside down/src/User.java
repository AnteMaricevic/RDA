public class User {
	private int id;
	private String username;
	private int health;
	private int sanity;
	private int hunger;
	private int energy;
	private String type;
	
	public User(int id, String username, int health, int sanity, int hunger, int energy,String type) {
		this.id = id;
		this.username=username;
		this.health=health;
		this.sanity=sanity;
		this.hunger=hunger;
		this.energy=energy;
		this.type=type;
		
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
		
	}
	public int getHealth() {
		return health;
	}
	public int getSanity() {
		return sanity;
	}
	public int getHunger() {
		return hunger;
	}
	public int getEnergy() {
		return energy;
		
	}
	public String getType() {
		return type;
	}
	public boolean isAdmin() {
		if (type.equals("admin")) return true;
		else return false;
	}
}