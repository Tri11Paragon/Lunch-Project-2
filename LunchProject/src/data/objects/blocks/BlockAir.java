package data.objects.blocks;

import org.lwjgl.util.vector.Vector2f;

import data.helpers.enums.Material;
import data.main.GameRegistry;
import data.textures.TextureData;

public class BlockAir extends Block{

	public BlockAir(Vector2f position) {
		super(Material.AIR,new TextureData(GameRegistry.air, "air"), position);
	}
	public BlockAir() {
		super(Material.AIR,new TextureData(GameRegistry.air, "air"), null);
	}
	@Override
	public Block getBlockDropped() {
		return null;
	}
	
	
}
