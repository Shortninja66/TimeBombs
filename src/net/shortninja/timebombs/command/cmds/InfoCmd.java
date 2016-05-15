package net.shortninja.timebombs.command.cmds;

import net.shortninja.timebombs.TimeBombs;
import net.shortninja.timebombs.command.Executor;

import org.bukkit.command.CommandSender;

public class InfoCmd implements Executor
{
	@Override
    public void execute(CommandSender sender, String cmd, String[] args)
    {
		TimeBombs.get().message.sendMessage(sender, TimeBombs.get().message.longLine(), false);
		TimeBombs.get().message.sendMessage(sender, "&bCreated by &7Shortninja&b.", true);
		TimeBombs.get().message.sendMessage(sender, "&bRunning version &71.0&b.", true);
		TimeBombs.get().message.sendMessage(sender, TimeBombs.get().message.longLine(), false);
    }
}