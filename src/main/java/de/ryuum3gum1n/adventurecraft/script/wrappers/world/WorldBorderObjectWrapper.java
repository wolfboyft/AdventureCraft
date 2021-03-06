package de.ryuum3gum1n.adventurecraft.script.wrappers.world;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.world.border.EnumBorderStatus;
import net.minecraft.world.border.WorldBorder;
import de.ryuum3gum1n.adventurecraft.AdventureCraft;
import de.ryuum3gum1n.adventurecraft.script.wrappers.IObjectWrapper;
import de.ryuum3gum1n.adventurecraft.script.wrappers.entity.EntityObjectWrapper;

public class WorldBorderObjectWrapper implements IObjectWrapper {
	private WorldBorder worldBorder;

	public WorldBorderObjectWrapper(WorldBorder worldBorder) {
		this.worldBorder = worldBorder;
	}

	@Override
	public WorldBorder internal() {
		return worldBorder;
	}

	@Override
	public List<String> getOwnPropertyNames() {
		return AdventureCraft.globalScriptManager.getOwnPropertyNames(this);
	}

	public EnumBorderStatus getStatus() {
		return worldBorder.getStatus();
	}

	public int getSize() {
		return worldBorder.getSize();
	}

	public void setSize(int newSize) {
		worldBorder.setSize(newSize);
	}

	public double getDiameter() {
		return worldBorder.getDiameter();
	}

	public double getCenterX() {
		return worldBorder.getCenterX();
	}

	public double getCenterZ() {
		return worldBorder.getCenterZ();
	}

	public void setCenter(double x, double z) {
		worldBorder.setCenter(x, z);
	}

	public void setDamageBuffer(double size) {
		worldBorder.setDamageBuffer(size);
	}

	public void setDamageAmount(double amount) {
		worldBorder.setDamageAmount(amount);
	}

	public double getDamageBuffer() {
		return worldBorder.getDamageBuffer();
	}

	public double getDamageAmount() {
		return worldBorder.getDamageAmount();
	}

	public double getClosestDistance(double x, double z) {
		return worldBorder.getClosestDistance(x, z);
	}

	public double getClosestDistance(Entity entity) {
		return worldBorder.getClosestDistance(entity);
	}

	public double getClosestDistance(EntityObjectWrapper entity) {
		return worldBorder.getClosestDistance(entity.internal());
	}

}