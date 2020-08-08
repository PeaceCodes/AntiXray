package me.peacetuba.antixray.commands;

import java.util.ArrayList;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.peacetuba.antixray.AntiXray;
import me.peacetuba.antixray.cc;

public class FindDiamonds implements CommandExecutor{

	private AntiXray main;
	
	public FindDiamonds(AntiXray main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(cc.chat("&cOnly players are allowed to perform this command!"));
			return false;
		}
		
		Player p = (Player) sender;
		
		if(!main.isEnabled) {
			p.sendMessage(cc.chat("&cAntiXray is not enabled!"));
			return false;
		}
		
		Chunk playerchunk = p.getWorld().getChunkAt(p.getLocation());
		
		ArrayList<Location> diamondsInChunk = new ArrayList<>();
		
		for(int i = 0; i < main.diamondsLocated.size(); i++) {
			Location loc = main.diamondsLocated.get(i);
			Chunk diamondLocatedInChunk = loc.getChunk();
			if(diamondLocatedInChunk.equals(playerchunk)) {
				diamondsInChunk.add(loc);
			}
		}
		
		if(diamondsInChunk.isEmpty()) {
			p.sendMessage(cc.chat("&cThere are no hidden diamonds in your chunk!"));
			return false;
		}
		
		for(int i = 0; i < diamondsInChunk.size(); i++) {
			Location loc = diamondsInChunk.get(i);
			p.sendMessage(cc.chat("&aHidden diamond located: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ()));
		}
		
		return false;
	}

}
