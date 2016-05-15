package net.shortninja.timebombs.command;

import net.shortninja.timebombs.TimeBombs;
import net.shortninja.timebombs.command.cmds.GiveCmd;
import net.shortninja.timebombs.command.cmds.InfoCmd;
import net.shortninja.timebombs.command.cmds.MineBombCmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Hub
{
	public Hub(CommandSender sender, Command cmd, String string, String[] args)
	{
		Executor executor = null;
		
		if(args.length == 0)
		{
			executor = new MineBombCmd();
		}else if(args.length == 1)
		{
			String arg = args[0];
			
			if(arg.equalsIgnoreCase("info"))
			{
				executor = new InfoCmd();
			}else if(arg.equalsIgnoreCase("give"))
			{
				TimeBombs.get().message.sendMessage(sender, TimeBombs.get().options.messageNotEnoughArguments, true);
				return;
			}
		}else if(args.length == 2)
		{
			if(args[0].equalsIgnoreCase("give"))
			{
				executor = new GiveCmd();
			}
		}
		
		if(executor != null)
		{
			executor.execute(sender, string, args);
		}else TimeBombs.get().message.sendMessage(sender, TimeBombs.get().options.messageUnknownCommand, true);
	}
}