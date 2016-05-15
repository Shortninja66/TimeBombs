package net.shortninja.timebombs.command.cmds;

import net.shortninja.timebombs.TimeBombs;
import net.shortninja.timebombs.command.Executor;

import org.bukkit.command.CommandSender;

public class MineBombCmd implements Executor
{
    @Override
	public void execute(CommandSender sender, String cmd, String[] args)
    {
    	TimeBombs.get().message.sendMessage(sender, TimeBombs.get().message.longLine(), false);
    	
    	if(sender.hasPermission(TimeBombs.get().options.bombPermission))
    	{
    		TimeBombs.get().message.sendMessage(sender, "&b/timebomb give &7[player]", true);
    	}
    	
    	TimeBombs.get().message.sendMessage(sender, "&b/timebomb info", true);
    	TimeBombs.get().message.sendMessage(sender, TimeBombs.get().message.longLine(), false);
    }
}