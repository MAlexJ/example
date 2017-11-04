package work_flow.update_region.region.tile.parameters;

public class Attribute {

	private Integer speedLimit;
	private String type;

	public Integer getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(Integer speedLimit) {
		this.speedLimit = speedLimit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Attribute{" +
				  "speedLimit=" + speedLimit +
				  ", type='" + type + '\'' +
				  '}';
	}
}