package data.objects.blocks;

public class Blocks {
	
	public static Block air;
	public static Block grass;
	public static Block dirt;
	public static Block stone;
	public static Block ironOre;
	
	public static void setup() {
		air = new BlockAir();
		grass = new BlockGrass();
		dirt = new BlockDirt();
		stone = new BlockStone();
		ironOre = new BlockIronOre();
	}
	
}
