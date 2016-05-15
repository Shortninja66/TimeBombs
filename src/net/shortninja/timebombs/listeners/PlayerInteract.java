package net.shortninja.timebombs.listeners;

import net.shortninja.timebombs.TimeBombs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener
{
	public PlayerInteract()
	{
		Bukkit.getPluginManager().registerEvents(this, TimeBombs.get());
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInteract(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		
		if(TimeBombs.get().bomb.isMineBomb(player.getItemInHand(), false) && isRightClicking(event.getAction()))
		{
			TimeBombs.get().bomb.useBomb(player);
		}
	}
	
	private boolean isRightClicking(Action action)
	{
		return action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK;
	}
}