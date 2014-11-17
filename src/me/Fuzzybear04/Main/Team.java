package me.Fuzzybear04.Main;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Team extends RPGClasses{
	
	
	static ArrayList<String> redTeam = new ArrayList<String>();
	static ArrayList<String> blueTeam = new ArrayList<String>();
	static ArrayList<String> yellowTeam = new ArrayList<String>();
	static ArrayList<String> greenTeam = new ArrayList<String>();
	
	
	public static void addBlue(Player p){
		blueTeam.add(p.getName());
		System.out.println("Saved Player " + p.getName() + " To Blue Team");
	}
	
	public static void addRed(Player p){
		redTeam.add(p.getName());		
		System.out.println("Saved Player " + p.getName() + " To Red Team");
	}
	
	public static void addGreen(Player p){
		greenTeam.add(p.getName());
		System.out.println("Saved Player " + p.getName() + " To Green Team");
	}
	
	public static void addYellow(Player p){
		yellowTeam.add(p.getName());
		System.out.println("Saved Player " + p.getName() + " To Yellow Team");
	}
	
	public static Teams getTeam(Player p){
		if(blueTeam.contains(p.getName())){
			return Teams.BLUE;
		}else if(redTeam.contains(p.getName())){
			return Teams.RED;
		}else if(yellowTeam.contains(p.getName())){
			return Teams.YELLOW;
		}else if(greenTeam.contains(p.getName())){
			return Teams.GREEN;
		}
		return null;
	}
	
	
	
	public static void removeFromTeam(Player p){
		if(blueTeam.contains(p.getName())){
			blueTeam.remove(p.getName());
		}else if(redTeam.contains(p.getName())){
			redTeam.remove(p.getName());
		}else if(greenTeam.contains(p.getName())){
			greenTeam.remove(p.getName());
		}else if(yellowTeam.contains(p.getName())){
			yellowTeam.remove(p.getName());
		}
	}
	
	public static boolean isInTeam(Player p){
		if(redTeam.contains(p.getName())){
			return true;
		}
		else if(blueTeam.contains(p.getName())){
			return true;
		}else if(greenTeam.contains(p.getName())){
			return true;
		}else if(yellowTeam.contains(p.getName())){
			return true;
		}
		return false;
	}
	
	public void saveTeams(){
		getConfig().getStringList("Members.Red").clear();
		getConfig().addDefault("Members.Red", redTeam);;
		saveConfig();
		
		getConfig().getStringList("Members.Blue").clear();
		getConfig().addDefault("Members.Blue", blueTeam);
		saveConfig();
		
		getConfig().getStringList("Members.Yellow").clear();
		getConfig().addDefault("Members.Yellow", yellowTeam);
		saveConfig();
		
		getConfig().getStringList("Members.Green").clear();
		getConfig().addDefault("Members.Green", greenTeam);
		saveConfig();
		
		System.out.println("Saved Teams");
	}
	
	
	

}
