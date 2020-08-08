package me.peacetuba.antixray.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.peacetuba.antixray.AntiXray;
import me.peacetuba.antixray.cc;

public class ToggleAntiXray implements CommandExecutor{

	public AntiXray main;
	
	public ToggleAntiXray(AntiXray main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(cc.chat("&cOnly players are allowed to perform this command!"));
			return false;
		}
		
		Player p = (Player) sender;
		World w = p.getWorld();
		
		if(main.isEnabled) {
			p.sendMessage(cc.chat("&aUntoggled AntiXray and revealed all diamonds!"));
			for(int i = 0; i < main.diamondsLocated.size(); i++) {
				Location loc = main.diamondsLocated.get(i);
				Block b = w.getBlockAt(loc);
				b.setType(Material.DIAMOND_ORE);
			}
			main.diamondsLocated.clear();
			main.isEnabled = false;
			return false;
		} else {
			p.sendMessage(cc.chat("&aToggled AntiXray and is now disguising all diamonds!"));
			main.isEnabled = true;
			return false;
		}
		
	}
	
	
}
