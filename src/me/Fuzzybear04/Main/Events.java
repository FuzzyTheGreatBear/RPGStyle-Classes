package me.Fuzzybear04.Main;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Events extends RPGClasses implements Listener{
	
	@EventHandler
	public void cancelFriendlyFire(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
			Player da = (Player) e.getEntity();
			if(e.getDamager() instanceof Player){
				Player dam = (Player) e.getDamager();
				if(Team.getTeam(dam) == Team.getTeam(da)){
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void setTeam(PlayerMoveEvent e){
		Player p = e.getPlayer();
		Block b = e.getPlayer().getLocation().getBlock().getRelative(0,  -1,  0);
		if(Team.isInTeam(p) == false){
			if(b.getType() == Material.REDSTONE_BLOCK){
				p.sendMessage(ChatColor.GRAY + "You have joined the province of " + ChatColor.RED + "Mitzgaard");
				Team.addRed(p);
				Bukkit.getServer().dispatchCommand(p, "rpg go red");
				
				p.setDisplayName(ChatColor.RED + p.getName());
				
				return;
			
			} else if(b.getType() == Material.LAPIS_BLOCK){
				p.sendMessage(ChatColor.GRAY + "You have joined the province of " + ChatColor.AQUA + "Kviisholt");
				Team.addBlue(p);
				Bukkit.getServer().dispatchCommand(p, "rpg go blue");
				
				p.setDisplayName(ChatColor.AQUA + p.getName());
				return;
	
			} else if(b.getType() == Material.SANDSTONE){
				p.sendMessage(ChatColor.GRAY + "You have joined the province of " + ChatColor.YELLOW + "Koskohl");
				Team.addYellow(p);
				Bukkit.getServer().dispatchCommand(p, "rpg go yellow");
				
				p.setDisplayName(ChatColor.YELLOW + p.getName());
				return;

			} else if(b.getType() == Material.EMERALD_BLOCK){
				p.sendMessage(ChatColor.GRAY + "You have joined the province of " + ChatColor.GREEN + "Al Shohn");
				Team.addGreen(p);
				Bukkit.getServer().dispatchCommand(p, "rpg go green");
				
				p.setDisplayName(ChatColor.GREEN + p.getName());
				return;
				
			}
		}
		return;
	}
	
	
	@EventHandler
	public void playerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(!p.hasPlayedBefore()){
			Bukkit.getServer().dispatchCommand(p, "rpg go lobby");
			e.setJoinMessage(null);
			
			
			ItemStack ch = new ItemStack(Material.LEATHER_CHESTPLATE);
			ItemStack le = new ItemStack(Material.LEATHER_LEGGINGS);
			ItemStack bo = new ItemStack(Material.LEATHER_BOOTS);
			ItemStack ap = new ItemStack(Material.APPLE, 2);
			ItemStack st = new ItemStack(Material.STICK, 1);
			
			ItemMeta chi = ch.getItemMeta();
			chi.setDisplayName(ChatColor.GRAY + "Worn leather jacket");
			chi.setLore(Arrays.asList(ChatColor.GRAY + "A basic, cheap coat"));
			ch.setItemMeta(chi);
			
			ItemMeta leg = le.getItemMeta();
			leg.setDisplayName(ChatColor.GRAY + "Dirty tanned jeans");
			leg.setLore(Arrays.asList(ChatColor.GRAY + "A worker's tanned, dirty jeans"));
			le.setItemMeta(leg);
			
			ItemMeta bot = bo.getItemMeta();
			bot.setDisplayName(ChatColor.GRAY + "Old leathered shoes");
			bot.setLore(Arrays.asList(ChatColor.GRAY + "Pair of large, leather shoes"));
			bo.setItemMeta(bot);
			
			ItemMeta apl = ap.getItemMeta();
			apl.setDisplayName(ChatColor.GRAY + "Green Apples");
			apl.setLore(Arrays.asList(ChatColor.GRAY + "2 Slightly off Apples"));
			ap.setItemMeta(apl);
			
			ItemMeta stk = st.getItemMeta();
			stk.setDisplayName(ChatColor.GRAY + "Walking Stick");
			stk.setLore(Arrays.asList(ChatColor.GRAY + "A strong, sturdy walking stick", "Could be used in defence"));
			st.setItemMeta(stk);
			
			p.getInventory().setChestplate(ch);
			p.getInventory().setLeggings(le);
			p.getInventory().setBoots(bo);
			p.getInventory().addItem(st);
			p.getInventory().setItem(8, ap);
			
			p.sendMessage(ChatColor.GRAY + "Welcome to the Citadel, Lone Stranger.");
			return;
		} 
		
		e.setJoinMessage(null);
		
		if(Team.getTeam(p) == Teams.BLUE){
			p.setDisplayName(ChatColor.AQUA + p.getName());
			return;
		} else if(Team.getTeam(p) == Teams.RED){
			p.setDisplayName(ChatColor.RED + p.getName());
			return;
		} else if(Team.getTeam(p) == Teams.YELLOW){
			p.setDisplayName(ChatColor.YELLOW + p.getName());
			return;
		} else if(Team.getTeam(p) == Teams.GREEN){
			p.setDisplayName(ChatColor.GREEN + p.getName());
		}
		return;
		
	}
	
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity().getPlayer();
		Player k = p.getKiller();
		for(Player pl : Bukkit.getServer().getOnlinePlayers()){
			if(Team.getTeam(pl) == Team.getTeam(p)){
				pl.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "One of your members has been slain!");
				return;
			}else 
			
			if(Team.getTeam(pl) == Team.getTeam(k)){
				pl.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "One of your members has slain an enemy!");
				return;
			} else if(Team.getTeam(pl) != Team.getTeam(k) || Team.getTeam(pl) != Team.getTeam(p)){
				pl.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "A Soldier was slain!");
				return;
				
			} else if(Team.isInTeam(p)){
				return;
			}
		}
		
	}
	
	
	@EventHandler
	public void customChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		if(Team.blueTeam.contains(p.getName())){
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.AQUA + "%s" + ChatColor.GRAY + "]" + ChatColor.WHITE + " >> " + ChatColor.GRAY + e.getMessage());
			
			return;
		} else 	if(Team.redTeam.contains(p.getName())){
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.RED + "%s" + ChatColor.GRAY + "]" + ChatColor.WHITE + " >> " + ChatColor.GRAY + e.getMessage());
			return;
		} else 	if(Team.yellowTeam.contains(p.getName())){
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.YELLOW + "%s" + ChatColor.GRAY + "]" + ChatColor.WHITE + " >> " + ChatColor.GRAY + e.getMessage());
			return;
		} else 	if(Team.greenTeam.contains(p.getName())){
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.GREEN + "%s" + ChatColor.GRAY + "]" + ChatColor.WHITE + " >> " + ChatColor.GRAY + e.getMessage());
			return;
		}else {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.GRAY + "%s" + ChatColor.GRAY + "]" + ChatColor.WHITE + " >> " + ChatColor.GRAY + e.getMessage());
			return;
		}
	}

}
