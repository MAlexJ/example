package work_flow.update_region.region.tile.parameters;

import java.util.List;

public class Link {

	private int testID;
	private boolean isBaseLink;
	private List<Attribute> attributes;
	private List<RoadGeoLine> roadGeoLines;

	public boolean isBaseLink() {
		return isBaseLink;
	}

	public void setBaseLink(boolean baseLink) {
		isBaseLink = baseLink;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<RoadGeoLine> getRoadGeoLines() {
		return roadGeoLines;
	}

	public int getTestID() {
		return testID;
	}

	public void setTestID(int testID) {
		this.testID = testID;
	}

	public void setRoadGeoLines(List<RoadGeoLine> roadGeoLines) {
		this.roadGeoLines = roadGeoLines;
	}


	@Override
	public String toString() {
		return "Link{" +
				  "testID=" + testID +
				  ", isBaseLink=" + isBaseLink +
				  ", attributes=" + attributes +
				  ", roadGeoLines=" + roadGeoLines +
				  '}';
	}
}
