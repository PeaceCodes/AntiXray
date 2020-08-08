package me.peacetuba.antixray.events;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

import me.peacetuba.antixray.AntiXray;

public class ChunkLoad implements Listener{

	private AntiXray main;
	
	public ChunkLoad(AntiXray main) {
		this.main = main;
	}
	
	@EventHandler // https://bukkit.org/threads/getting-all-the-blocks-in-a-chunk.6650/ (Thanks to Raphfrk for the help <3)
	public void disguiseDiamonds(ChunkLoadEvent e) {
		if(!main.isEnabled) {
			return;
		}
		Chunk c = e.getChunk();
		int bx = c.getX() << 4;
		int bz = c.getZ() << 4;
		
		World w = e.getWorld();
		
		for(int xx = bx; xx < bx + 16; xx++) {
			for(int zz = bz; zz < bz + 16; zz++) {
				for(int yy = 0; yy < 17; yy++) {
					Block b = w.getBlockAt(xx, yy, zz);
					if(b.getType() == Material.DIAMOND_ORE) {
						main.diamondsLocated.add(b.getLocation());
						b.setType(Material.STONE);
						b.getState().update(true);
					}
				}
			}
		}
	}
	
}
