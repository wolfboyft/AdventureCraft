package de.ryuum3gum1n.adventurecraft.script.wrappers.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import de.ryuum3gum1n.adventurecraft.AdventureCraft;
import de.ryuum3gum1n.adventurecraft.entity.NPC.EntityNPC;
import de.ryuum3gum1n.adventurecraft.entity.NPC.NPCData;
import de.ryuum3gum1n.adventurecraft.entity.NPC.dialogue.NPCDialogue;
import de.ryuum3gum1n.adventurecraft.network.packets.DialogueOpenPacket;
import de.ryuum3gum1n.adventurecraft.script.wrappers.nbt.CompoundTagWrapper;

public class NPCObjectWrapper extends EntityLivingObjectWrapper {
	private EntityNPC npc;
	/** Map of all dialogues currently loaded */
	public static HashMap<UUID, List<NPCDialogue>> created_dialogues_map = new HashMap<UUID, List<NPCDialogue>>();
	/** List of all dialogues created in the current instance of the script */
	private List<NPCDialogue> created_dialogues;

	public NPCObjectWrapper(EntityNPC npc) {
		super(npc);
		this.npc = npc;
		created_dialogues = new ArrayList<NPCDialogue>();
	}

	public void setName(String name) {
		npc.getNPCData().setName(name);
	}

	public void setPos(float x, float y, float z) {
		npc.setPosition(x, y, z);
	}

	@Override
	public List<String> getOwnPropertyNames() {
		return AdventureCraft.globalScriptManager.getOwnPropertyNames(this);
	}

	public float getX() {
		return (float) npc.posX;
	}

	public float getY() {
		return (float) npc.posY;
	}

	public float getZ() {
		return (float) npc.posZ;
	}

	public CompoundTagWrapper getScriptData() {
		return new CompoundTagWrapper(npc.getScriptData());
	}

	public void clearScriptData() {
		npc.setScriptData(new NBTTagCompound());
	}

	public NPCData getNPCData() {
		return npc.getNPCData();
	}

	public NPCDialogue createDialogue(String name) {
		NPCDialogue dialogue = new NPCDialogue(name);
		created_dialogues.add(dialogue);
		return dialogue;
	}

	public void sendDialogue(String dialogue_name, PlayerObjectWrapper player) {
		UUID id = UUID.randomUUID();
		created_dialogues_map.put(id, created_dialogues);
		AdventureCraft.network.sendTo(new DialogueOpenPacket(dialogue_name, id, created_dialogues, npc.getUniqueID()),
				(EntityPlayerMP) player.internal());
	}

}