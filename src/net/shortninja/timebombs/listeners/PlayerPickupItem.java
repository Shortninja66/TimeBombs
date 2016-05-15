package net.shortninja.timebombs.listeners;

import net.shortninja.timebombs.TimeBombs;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerPickupItem implements Listener
{
	public PlayerPickupItem()
	{
		Bukkit.getPluginManager().registerEvents(this, TimeBombs.get());
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPickup(PlayerPickupItemEvent event)
	{
		if(TimeBombs.get().bomb.isMineBomb(event.getItem().getItemStack(), true))
		{
			event.setCancelled(true);
		}
	}
}