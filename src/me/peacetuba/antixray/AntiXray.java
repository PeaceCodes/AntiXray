package me.peacetuba.antixray;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.peacetuba.antixray.commands.FindDiamonds;
import me.peacetuba.antixray.commands.ToggleAntiXray;
import me.peacetuba.antixray.events.BlockBreak;
import me.peacetuba.antixray.events.ChunkLoad;

public class AntiXray extends JavaPlugin{ //You can tweak code to hide any other ores such as gold, lapis, iron, etc.

	public boolean isEnabled = false;
	public ArrayList<Location> diamondsLocated = new ArrayList<>();
	
	public void onEnable() {
		registerCommands();
		registerEvents();
	}
	
	private void registerEvents() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new BlockBreak(this), this);
		pm.registerEvents(new ChunkLoad(this), this);
	}
	
	private void registerCommands() {
		getCommand("ToggleAntiXray").setExecutor(new ToggleAntiXray(this));
		getCommand("FindHiddenDiamonds").setExecutor(new FindDiamonds(this));
	}
	
}
