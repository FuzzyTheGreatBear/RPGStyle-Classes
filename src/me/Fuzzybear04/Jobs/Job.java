package me.Fuzzybear04.Jobs;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Job {

	
	static ArrayList<String> hunter = new ArrayList<String>();
	static ArrayList<String> farmer = new ArrayList<String>();
	static ArrayList<String> miner = new ArrayList<String>();
	static ArrayList<String> cutter = new ArrayList<String>();
	
	public void addHunter(Player p){
		hunter.add(p.getName());
	}
	
	public void addFarmer(Player p){
		farmer.add(p.getName());
	}
	
	public void addMiner(Player p){
		miner.add(p.getName());
	}
	
	public void addWCutter(Player p){
		cutter.add(p.getName());
	}
	
	public static Jobs getJob(Player p){
		if(hunter.contains(p.getName())){
			return Jobs.HUNTER;
		} else if(farmer.contains(p.getName())){
			return Jobs.FARMER;
		} else if(miner.contains(p.getName())){
			return Jobs.MINER;
		} else if(cutter.contains(p.getName())){
			return Jobs.WOODCUTTER;
		} 
		
		return null;
	}
	
	public static boolean hasJob(Player p){
		if(hunter.contains(p.getName())){
			return true;
		} else if(farmer.contains(p.getName())){
			return true;
		} else if(miner.contains(p.getName())){
			return true;
		} else if(cutter.contains(p.getName())){
			return true;
		}
		
		return false;
	}
}
