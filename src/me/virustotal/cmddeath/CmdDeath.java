package me.virustotal.cmddeath;

import java.io.File;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CmdDeath extends JavaPlugin {
	
	public File configFile = new File(this.getDataFolder(), "config.yml");
	public List<String> commands;
	
	@Override
	public void onEnable()
	{
		if(!this.configFile.exists())
			this.saveDefaultConfig();
		else
			this.reloadConfig();
		
		this.commands = this.getConfig().getStringList("commands");
		Bukkit.getPluginManager().registerEvents(new DeathListener(this), this);
	}
}