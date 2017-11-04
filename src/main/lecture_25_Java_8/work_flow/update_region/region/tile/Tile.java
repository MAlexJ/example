package work_flow.update_region.region.tile;

import work_flow.update_region.region.tile.parameters.Link;

import java.util.Map;

public class Tile {

	private int tileId;
	private Map<Integer, Link> map;

	public int getTileId() {
		return tileId;
	}

	public void setTileId(int tileId) {
		this.tileId = tileId;
	}

	public Map<Integer, Link> getMap() {
		return map;
	}

	public void setMap(Map<Integer, Link> map) {
		this.map = map;
	}
}
