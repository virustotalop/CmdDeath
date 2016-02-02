package me.virustotal.cmddeath;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

	private CmdDeath plugin;
	public DeathListener(CmdDeath plugin)
	{
		this.plugin = plugin;
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e)
	{
		if(!e.getEntity().hasPermission("death.bypass"))
		{
			for(String str : this.plugin.commands)
			{
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), str.replace("%player%", e.getEntity().getName()));
			}
		}
	}
}
