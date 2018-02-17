package data.objects.map;

import org.lwjgl.util.vector.Vector2f;

import data.helpers.Maths;
import data.main.Boot;
import data.objects.blocks.Block;
import data.objects.blocks.BlockIronOre;
import data.objects.blocks.Blocks;
import data.textures.Artist;

public class WorldGenerator {
	
	/**
	 * This function will gen the amount of blocks randomly.
	 * It spawns randomly throughout the world but will generate the exact amount of blocks specified.
	 * <<<<<<BROKEN>>>>>>
	 */
	static int te = 0;
	public static void generate(Block block, int amount, int minY, int maxY) {
		for (int i =0;i<Boot.WIDTH/Artist.BlockSize;i++){
			for (int j=minY;j<maxY;j++) {
				if (te < amount) {
					Map.setBlock(i,j,new BlockIronOre(new Vector2f(i*Artist.BlockSize,j*Artist.BlockSize)));
					te++;
				}
			}
		}
	}
	
	/**Congrats first real docs
	 * This will use an random function to determine the spawn place.
	 * Unlike the regular generate function  there is no guarantee that anything will spawn.
	 */
	public static void generateRandom(Block block, int ranMin, int ranMax, int minY, int maxY) {
		for (int i =0;i<Boot.WIDTH/Artist.BlockSize;i++){
			for (int j=minY;j<maxY;j++) {
				if (Maths.randInt(ranMin, ranMax) == 1) {
					if (Map.getBlock(i, j) == Blocks.stone || Map.getBlock(i, j).getTexture() == Blocks.stone.getTexture()) {
						Map.setBlock(i,j,new BlockIronOre(new Vector2f(i*Artist.BlockSize,j*Artist.BlockSize)));
					}
				}
			}
		}
	}
	
}
