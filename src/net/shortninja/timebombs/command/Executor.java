package net.shortninja.timebombs.command;

import org.bukkit.command.CommandSender;

public abstract interface Executor
{
	void execute(CommandSender sender, String cmd, String[] args);
}