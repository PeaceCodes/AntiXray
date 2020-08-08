package me.peacetuba.antixray.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.peacetuba.antixray.AntiXray;

public class BlockBreak implements Listener{

	private AntiXray main;
	
	public BlockBreak(AntiXray main) {
		this.main = main;
	}
	
	@EventHandler
	public void on(PlayerInteractEvent e) {
		Action a = e.getAction();
		if(a.equals(Action.LEFT_CLICK_BLOCK)) {
			Block block = e.getClickedBlock();
			for(int i = 0; i < main.diamondsLocated.size(); i++) {
				Location diamondLocated = main.diamondsLocated.get(i);
				if(block.getRelative(BlockFace.UP).getLocation().equals(diamondLocated)) {
					block.getRelative(BlockFace.UP).setType(Material.DIAMOND_ORE);
					main.diamondsLocated.remove(i);
				}
				if(block.getRelative(BlockFace.DOWN).getLocation().equals(diamondLocated)) {
					 block.getRelative(BlockFace.DOWN).setType(Material.DIAMOND_ORE);
					 main.diamondsLocated.remove(i);
				}
				if(block.getRelative(BlockFace.NORTH).getLocation().equals(diamondLocated)) {
					block.getRelative(BlockFace.NORTH).setType(Material.DIAMOND_ORE);
					main.diamondsLocated.remove(i);
				}
				if(block.getRelative(BlockFace.SOUTH).getLocation().equals(diamondLocated)) {
					block.getRelative(BlockFace.SOUTH).setType(Material.DIAMOND_ORE);
					main.diamondsLocated.remove(i);
				}
				if(block.getRelative(BlockFace.EAST).getLocation().equals(diamondLocated)) {
					block.getRelative(BlockFace.EAST).setType(Material.DIAMOND_ORE);
					main.diamondsLocated.remove(i);
				}
				if(block.getRelative(BlockFace.WEST).getLocation().equals(diamondLocated)) {
					block.getRelative(BlockFace.WEST).setType(Material.DIAMOND_ORE);
					main.diamondsLocated.remove(i);
				} 
			}
		}
	}
	
}
