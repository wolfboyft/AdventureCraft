package de.ryuum3gum1n.adventurecraft.server;

import net.minecraft.server.MinecraftServer;
import de.ryuum3gum1n.adventurecraft.AdventureCraft;
import de.ryuum3gum1n.adventurecraft.invoke.IInvoke;
import de.ryuum3gum1n.adventurecraft.invoke.IInvokeSource;

public class ServerMirror {
	private MinecraftServer server;
	private PlayerList players;
	private ServerClipboard clipboard;
	private ServerFileSystem fileSystem;
	private boolean trackInvokes;

	public MinecraftServer getServer() {
		return server;
	}

	public void create(MinecraftServer server) {
		AdventureCraft.logger.info("Creating Server Mirror: " + server);

		this.server = server;
		this.players = new PlayerList();
		this.clipboard = new ServerClipboard();
		this.fileSystem = new ServerFileSystem();
		this.trackInvokes = true;
	}

	public void destroy() {
		AdventureCraft.logger.info("Destroying Server Mirror: " + server);
		this.players.destroy();
	}

	public PlayerList playerList() {
		return players;
	}

	public ServerClipboard getClipboard() {
		return clipboard;
	}

	public ServerFileSystem getFileSystem() {
		return fileSystem;
	}

	public static ServerMirror instance() {
		return ServerHandler.getServerMirror(null);
	}

	public void trackInvoke(IInvokeSource source, IInvoke invoke) {
		if (!trackInvokes)
			return;

		for (PlayerMirror playerMirror : players.getBackingList()) {
			playerMirror.trackInvoke(source, invoke);
		}
	}

}