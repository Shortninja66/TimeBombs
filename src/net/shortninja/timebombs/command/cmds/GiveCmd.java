package net.shortninja.timebombs.command.cmds;

import net.shortninja.timebombs.TimeBombs;
import net.shortninja.timebombs.command.Executor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GiveCmd implements Executor
{
	@Override
    public void execute(CommandSender sender, String cmd, String[] args)
    {
	    String offlinePlayer = args[1];
	    Player onlinePlayer = Bukkit.getPlayer(offlinePlayer);
	    
	    if(!sender.hasPermission(TimeBombs.get().options.bombPermission))
	    {
	    	TimeBombs.get().message.sendMessage(sender, TimeBombs.get().options.messageNoPermission, true);
	    	return;
	    }
	    
	    if(onlinePlayer != null)
	    {
	    	giveBomb(sender, onlinePlayer);
	    	TimeBombs.get().message.sendMessage(sender, TimeBombs.get().options.messageGaveBomb.replace("%player%", onlinePlayer.getName()), true);
	    	TimeBombs.get().message.sendMessage(onlinePlayer, TimeBombs.get().options.messageReceivedBomb, true);
	    }else TimeBombs.get().message.sendMessage(sender, TimeBombs.get().options.messagePlayerIsOffline, true);
    }
	
	private void giveBomb(CommandSender sender, Player player)
	{
		Inventory inventory = player.getInventory();
		
		if(!(inventory.firstEmpty() == -1))
		{
			inventory.addItem(TimeBombs.get().bomb.normalMineBomb);
		}else TimeBombs.get().message.sendMessage(sender, TimeBombs.get().options.messageNotEnoughRoom, true);
	}
}