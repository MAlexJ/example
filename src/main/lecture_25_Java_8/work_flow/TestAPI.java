package work_flow;

import org.junit.Before;
import org.junit.Test;
import work_flow.update_region.region.UpdateRegion;
import work_flow.update_region.region.tile.Tile;
import work_flow.update_region.region.tile.parameters.Attribute;
import work_flow.update_region.region.tile.parameters.Link;

import java.util.*;

import static junit.framework.TestCase.assertTrue;

public class TestAPI {

	private UpdateRegion region;
	private static final String SPEED_LIMIT = "SPEED_LIMIT";

	/**
	 * Map for all link
	 */
	private Map<Integer, List<Integer>> failedList = new TreeMap<>(); //TODO >>>> HashMap
	private Map<Integer, List<Integer>> failedListGeo = new TreeMap<>(); //TODO >>>> HashMap

	private List<String> sout = new ArrayList<>();

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

				link.setAttributes(attributes);
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


	@Test
	public void test() {

		int spedLimitForTest = 30;

		System.out.println(region.getRegion());

		List<Tile> tiles = region.getTiles();

		tiles.forEach(t -> {

			List<Integer> failedLink = new ArrayList<>();
			List<Integer> failedLinkGeo = new ArrayList<>();

			t.getMap()
					  .forEach(
								 (k, v) -> {

//									 v.getAttributes().forEach(attribute -> {
//									 	if(attribute.getType().equals(SPEED_LIMIT))
//										 sout.add(" >>>> " + t.getTileId() + " LINK_ID: " + k + " testID: "+ v.getTestID()+  " : " + attribute);
//									 });

									 boolean hasSpeedLimit = v.getAttributes()
												.stream()
												.filter(attribute -> attribute.getType().equals(SPEED_LIMIT))
												.anyMatch(attribute -> attribute.getSpeedLimit() >= spedLimitForTest);

									 if (hasSpeedLimit) {
										 System.out.println("TILE: " + t.getTileId() + " LINK_ID: " + k + " :check id: " + v.getTestID());
										 failedLink.add(k);
									 }

									 if (hasSpeedLimit && !v.isBaseLink()) {
										 System.out.println(" > GEO: " + v.getRoadGeoLines());
									 }
								 }
					  );

			int[] collect = t.getMap().entrySet()
					  .stream()
					  .flatMapToInt(m -> m.getValue().getAttributes()
								 .stream()
								 .filter(attribute -> attribute.getType().equals(SPEED_LIMIT))
								 .filter(attribute -> attribute.getSpeedLimit() >= spedLimitForTest)
								 .mapToInt(attribute -> m.getKey())).toArray();

			if (collect.length > 0)
				System.out.println("<<< List: " + Arrays.toString(collect));


			if (!failedLink.isEmpty()) {
				failedList.put(t.getTileId(), failedLink);
			}

		});

		System.out.println("\n Result test_queue:");
		failedList.forEach((k, v) -> System.out.println(k + " " + v));

		System.out.println();
		System.out.println("Verify: \n");
		sout.forEach(System.out::println);

	}

}