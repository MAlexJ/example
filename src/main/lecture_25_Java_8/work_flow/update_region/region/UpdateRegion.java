package work_flow.update_region.region;

import work_flow.update_region.region.tile.Tile;

import java.util.List;

public class UpdateRegion {

	private String region = "ER_LC";
	private List<Tile> tiles;

	public List<Tile> getTiles() {
		return tiles;
	}

	public void setTiles(List<Tile> tiles) {
		this.tiles = tiles;
	}

	public String getRegion() {
		return region;
	}

}
