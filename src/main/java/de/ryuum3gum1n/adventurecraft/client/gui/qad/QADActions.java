package de.ryuum3gum1n.adventurecraft.client.gui.qad;

import net.minecraft.client.Minecraft;

public class QADActions {

	public static Runnable newBackToGameAction() {
		return new Runnable() {
			@Override
			public void run() {
				Minecraft.getMinecraft().displayGuiScreen(null);
			}
		};
	}

}