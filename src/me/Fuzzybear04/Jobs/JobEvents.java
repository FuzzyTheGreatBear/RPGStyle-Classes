package me.Fuzzybear04.Jobs;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class JobEvents implements Listener{
	
	@EventHandler
	public void currency(BlockBreakEvent e){
		ItemStack c = new ItemStack(Material.QUARTZ);
		Random r = new Random();
		int cha = r.nextInt(100);
		if(cha < 25){
			e.getBlock().getDrops().add(c);
			return;
		} else if(cha < 85){
			e.getBlock().getDrops().add(new ItemStack(Material.QUARTZ, 3));
			return;
		}
	}
	
	@EventHandler
	public void getWood(BlockBreakEvent e){
		ItemStack log1 = new ItemStack(Material.LOG);
		ItemStack log2 = new ItemStack(Material.LOG_2);
		Block b = e.getBlock();
		Player p = e.getPlayer();
		if(Job.cutter.contains(p.getName())){
			if(b.getType() == log1.getType() || b.getType() == log2.getType() || b.getType() == Material.LEAVES || b.getType() == Material.LEAVES_2){
				e.setCancelled(false);
			}
			
			e.setCancelled(true);
		} 
	}

}
