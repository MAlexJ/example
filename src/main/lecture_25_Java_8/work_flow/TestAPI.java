package work_flow;

import org.junit.Before;
import org.junit.Test;
import work_flow.update_region.region.UpdateRegion;
import work_flow.update_region.region.tile.Tile;
import work_flow.update_region.region.tile.parameters.Attribute;
import work_flow.update_region.region.tile.parameters.Link;

import java.util.*;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;

public class TestAPI {

	private UpdateRegion region;
	private static final String SPEED_LIMIT = "SPEED_LIMIT";

	@Before
	public void before() {
		region = new UpdateRegion();
		List<Tile> tiles = new ArrayList<>();

		for (int i = 0; i < 20; i++) {
			Tile tile = new Tile();
			tile.setTileId(i + 986);
			tiles.add(tile);
			Map<Integer, Link> linkMap = new HashMap<>();
			tile.setMap(linkMap);

			int r = new Random().nextInt(12) + 1;
			for (int x = 0; x < r; x++) {
				Link link = new Link();
				linkMap.put(x, link);

				link.setTestID(x);

				List<Attribute> attributes = new ArrayList<>();
				link.setAttributes(attributes);

				if (x % 2 == 0) {
					link.setBaseLink(true);
				} else {
					link.setBaseLink(false);
				}

				boolean flag = true;
				for (int y = 0; y < new Random().nextInt(5) + 1; y++) {

					Attribute attribute = new Attribute();

					if (flag && y == 2) {
						flag = false;
						attribute.setType(SPEED_LIMIT);
						attribute.setSpeedLimit(new Random().nextInt(70) + 1);
					} else {
						attribute.setType("ATTRIBUTE_" + UUID.randomUUID());
					}

					attributes.add(attribute);

				}


			}

		}
		region.setTiles(tiles);
	}

	@Test
	public void testCountSpeedLimit() {
		region.getTiles()
				  .forEach(t -> t.getMap().forEach(
							 (k, v) -> {
								 long count = v.getAttributes()
											.stream()
											.filter(attribute -> attribute.getType().equals(SPEED_LIMIT))
											.count();
								 assertTrue("Error message : tileID: " + t.getTileId(), count <= 1);

								 boolean isHasSpeed = v.getAttributes()
											.stream()
											.filter(attribute -> attribute.getType().equals(SPEED_LIMIT))
											.allMatch(attribute -> attribute.getSpeedLimit() != null);

								 assertTrue("Error message : tileID: " + t.getTileId(), isHasSpeed);

							 }
				  ));
	}

	private Map<Integer, List<Integer>> failedList = new TreeMap<>(); //TODO >>>> HashMap

	@Test
	public void test() {

		int spedLimitForTest = 50;

		System.out.println(region.getRegion());
		List<Tile> tiles = region.getTiles();

		tiles.forEach(t -> {
			List<Integer> failedLink = new ArrayList<>();

			t.getMap()
					  .forEach(
					  (k, v) -> {
						  boolean hasSpeedLimit = v.getAttributes()
									 .stream()
									 .filter(attribute -> attribute.getType().equals(SPEED_LIMIT))
									 .anyMatch(attribute -> attribute.getSpeedLimit() >= spedLimitForTest);

						  if (hasSpeedLimit) {
							  System.out.println("TILE: " + t.getTileId() + " LINK_ID: " + k + " :check id: " + v.getTestID());
							  failedLink.add(k);
						  }
					  }
			);

//			List<Integer> collect = t.getMap().entrySet()
//					  .stream()
//					  .flatMap(m -> {
//						  m.getValue().getAttributes()
//									 .stream()
//									 .filter(attribute -> attribute.getType().equals(SPEED_LIMIT))
//									 .filter(attribute -> attribute.getSpeedLimit() >= spedLimitForTest)
//						  .
//					  }).collect(Collectors.toList());


			if(!failedLink.isEmpty()){
				failedList.put(t.getTileId(), failedLink);
			}

		});

		System.out.println("\n Result test:");
		System.out.println(failedList);

	}

}
