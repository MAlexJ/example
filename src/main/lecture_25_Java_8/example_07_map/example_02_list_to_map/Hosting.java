package example_07_map.example_02_list_to_map;

public class Hosting {

	private int Id;
	private String name;
	private long websites;

	public Hosting(int id, String name, long websites) {
		Id = id;
		this.name = name;
		this.websites = websites;
	}

	@Override
	public String toString() {
		return "Hosting{" +
				  "Id=" + Id +
				  ", name='" + name + '\'' +
				  ", websites=" + websites +
				  '}';
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getWebsites() {
		return websites;
	}

	public void setWebsites(long websites) {
		this.websites = websites;
	}

}