package me.Fuzzybear04.Main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RPGClasses extends JavaPlugin{

	
	public void onEnable(){
		
		getConfig().options().header("RPG Config");
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
	//	Bukkit.getServer().getPluginManager().registerEvents(new JobEvents(), this);
		
		getLogger().info("Successfully Started");
		
		Team.blueTeam.clear();
		Team.redTeam.clear();
		Team.greenTeam.clear();
		Team.yellowTeam.clear();
		

		
		loadTeams();
		
		reloadConfig();
		
		
	}
	
	
	public void onDisable(){
		getLogger().info("Succesfully Stopped");
		saveTeams();
		
	}
	
	
	
	String setMessage = ChatColor.GREEN + "You have set the city spawn for " + ChatColor.GRAY;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

		
		if(cmd.getName().equalsIgnoreCase("rpg")){
			Player p = (Player) sender;
			if(args.length < 1){
				p.sendMessage(ChatColor.GRAY + "Not the correct syntax");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("leave")){
				p.sendMessage(ChatColor.GRAY + "You have left a province.");
				Team.removeFromTeam(p);
				
			}
			
			
			if(args[0].equalsIgnoreCase("set")){
			
				if(p.isOp()){
					if(args[1].equalsIgnoreCase("red")){
						p.sendMessage(setMessage + "Mitzgaard");
						
						reloadConfig();
						getConfig().set("Red.World", p.getWorld().getName());
						getConfig().set("Red.x", p.getLocation().getX());
						getConfig().set("Red.y", p.getLocation().getY());
						getConfig().set("Red.z", p.getLocation().getZ());
						getConfig().set("Red.yaw", p.getLocation().getYaw());
						getConfig().set("Red.pitch", p.getLocation().getPitch());
						saveConfig();
						
						return true;
					}
				
						
					if(args[1].equalsIgnoreCase("blue")){
						p.sendMessage(setMessage + "Kviisholt");
						
						reloadConfig();
						getConfig().set("Blue.World", p.getLocation().getWorld().getName());
						getConfig().set("Blue.x", p.getLocation().getX());
						getConfig().set("Blue.y", p.getLocation().getY());
						getConfig().set("Blue.z", p.getLocation().getZ());
						getConfig().set("Blue.yaw", p.getLocation().getYaw());
						getConfig().set("Blue.pitch", p.getLocation().getPitch());
						saveConfig();
						
						return true;
					}
						
					if(args[1].equalsIgnoreCase("green")){
						p.sendMessage(setMessage + "Al Shohn");
						
						reloadConfig();
						getConfig().set("Green.World", p.getLocation().getWorld().getName());
						getConfig().set("Green.x", p.getLocation().getX());
						getConfig().set("Green.y", p.getLocation().getY());
						getConfig().set("Green.z", p.getLocation().getZ());
						getConfig().set("Green.yaw", p.getLocation().getYaw());
						getConfig().set("Green.pitch", p.getLocation().getPitch());
						saveConfig();
						return true;
					}
					
					if(args[1].equalsIgnoreCase("yellow")){
						p.sendMessage(setMessage + "Koskohl");
						
						reloadConfig();
						getConfig().set("Yellow.World", p.getLocation().getWorld().getName());
						getConfig().set("Yellow.x", p.getLocation().getX());
						getConfig().set("Yellow.y", p.getLocation().getY());
						getConfig().set("Yellow.z", p.getLocation().getZ());
						getConfig().set("Yellow.yaw", p.getLocation().getYaw());
						getConfig().set("Yellow.pitch", p.getLocation().getPitch());
						saveConfig();
						return true;
					}
				
					if(args[1].equalsIgnoreCase("lobby")){
						p.sendMessage(setMessage + "The Citadel");
						
						reloadConfig();
						getConfig().set("Lobby.World", p.getLocation().getWorld().getName());
						getConfig().set("Lobby.x", p.getLocation().getX());
						getConfig().set("Lobby.y", p.getLocation().getY());
						getConfig().set("Lobby.z", p.getLocation().getZ());
						getConfig().set("Lobby.yaw", p.getLocation().getYaw());
						getConfig().set("Lobby.pitch", p.getLocation().getPitch());
						saveConfig();
						return true;
					}
				}
					
			}
			
			//String goneMessage = ChatColor.GREEN + "You have gone to the city of " + ChatColor.GRAY;
			
			if(args[0].equalsIgnoreCase("go")){
				
				if(args.length < 1){
					p.sendMessage(ChatColor.GRAY + "Improper syntax");
				}
					if(args[1].equalsIgnoreCase("red")){
						
						int x = getConfig().getInt("Red.x");
						int y = getConfig().getInt("Red.y");
						int z = getConfig().getInt("Red.z");
						int yaw = getConfig().getInt("Red.yaw");
						int pitch = getConfig().getInt("Red.pitch");
						
						p.teleport(new Location(p.getWorld(), x, y, z, yaw, pitch));
						return true;
					}
				
						
					if(args[1].equalsIgnoreCase("blue")){
						
						int x = getConfig().getInt("Blue.x");
						int y = getConfig().getInt("Blue.y");
						int z = getConfig().getInt("Blue.z");
						int yaw = getConfig().getInt("Blue.yaw");
						int pitch = getConfig().getInt("Blue.pitch");
						
						p.teleport(new Location(p.getWorld(), x, y, z, yaw, pitch));
						return true;
					}
						
					if(args[1].equalsIgnoreCase("green")){
						
						int x = getConfig().getInt("Green.x");
						int y = getConfig().getInt("Green.y");
						int z = getConfig().getInt("Green.z");
						int yaw = getConfig().getInt("Green.yaw");
						int pitch = getConfig().getInt("Green.pitch");
						
						p.teleport(new Location(p.getWorld(), x, y, z, yaw, pitch));
						return true;
					}
					
					if(args[1].equalsIgnoreCase("yellow")){
						
						int x = getConfig().getInt("Yellow.x");
						int y = getConfig().getInt("Yellow.y");
						int z = getConfig().getInt("Yellow.z");
						int yaw = getConfig().getInt("Yellow.yaw");
						int pitch = getConfig().getInt("Yellow.pitch");
						
						p.teleport(new Location(p.getWorld(), x, y, z, yaw, pitch));
						return true;
					}
				
					if(args[1].equalsIgnoreCase("lobby")){
						
						int x = getConfig().getInt("Lobby.x");
						int y = getConfig().getInt("Lobby.y");
						int z = getConfig().getInt("Lobby.z");
						int yaw = getConfig().getInt("Lobby.yaw");
						int pitch = getConfig().getInt("Lobby.pitch");
						
						p.teleport(new Location(p.getWorld(), x, y, z, yaw, pitch));
						return true;
					}
				}
			
				return true;
				
				
		}
	
		return true;
	}
	
	
	
	
	
	public void saveTeams(){
		getConfig().set("Members.Blue", Team.blueTeam);
		getConfig().set("Members.Red", Team.redTeam);
		getConfig().set("Members.Yellow", Team.yellowTeam);
		getConfig().set("Members.Green", Team.greenTeam);
		saveConfig();
		
		System.out.println("Saved Teams");
		
		saveConfig();
	}
	@SuppressWarnings("unchecked")
	public void loadTeams(){
		Team.blueTeam = (ArrayList<String>) getConfig().get("Members.Blue");
		Team.redTeam = (ArrayList<String>) getConfig().get("Members.Red");
		Team.yellowTeam = (ArrayList<String>) getConfig().get("Members.Yellow");
		Team.greenTeam = (ArrayList<String>) getConfig().get("Members.Green");
	}

}
