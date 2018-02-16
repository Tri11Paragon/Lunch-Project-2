package data.objects.blocks;

import org.lwjgl.util.vector.Vector2f;

import data.helpers.enums.Material;
import data.objects.TypeObject;
import data.objects.physics.BoundingBox;
import data.textures.Artist;
import data.textures.TextureData;

public class Block extends TypeObject {
	
	/**
	 * Hello Logan!
	 */
	public BoundingBox box = new BoundingBox(-50, -50, Artist.BlockSize, Artist.BlockSize);
	public boolean useBuundingBox;
	Material material;
	
	public Block(Material material, TextureData texture, Vector2f position) {
		this.texture = texture;
		this.position = position;
		useBuundingBox = false;
		this.material = material;
	}
	public Block(Material material, TextureData texture, Vector2f position, boolean useBuundingBox) {
		this.texture = texture;
		this.position = position;
		this.useBuundingBox = useBuundingBox;
		this.material = material;
	}
	public Block(Material material, TextureData texture, Vector2f position, BoundingBox box) {
		this.texture = texture;
		this.position = position;
		this.box = box;
		useBuundingBox=true;
		this.material = material;
	}
	
	/**
	 * This is the update function of the object.
	 */
	public void update() {
		
	}
	
	public void drawMiningOverlay() {
		
	}
	
	public void updatePosition() {
		if (useBuundingBox) {
			this.box.updatePosition(position);
		}
	}
	
	public Block getBlockDropped() {
		return this;
	}
	
	/**
	 * This is called on the main thread and where all GPU renderering should be done
	 * as the update function might not be in the main thread.
	 */
	public void onGPU() {
		
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	
}
