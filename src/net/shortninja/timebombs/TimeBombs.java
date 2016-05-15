package net.shortninja.timebombs;

import net.shortninja.timebombs.command.Hub;
import net.shortninja.timebombs.listeners.PlayerInteract;
import net.shortninja.timebombs.listeners.PlayerPickupItem;
import net.shortninja.timebombs.util.Bomb;
import net.shortninja.timebombs.util.Message;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class TimeBombs extends JavaPlugin
{
	private static TimeBombs plugin;
	public Message message;
	public Options options;
	public Bomb bomb;
	
	@Override
	public void onEnable()
	{
		plugin = this;
		
		saveDefaultConfig();
		message = new Message();
		options = new Options();
		bomb = new Bomb();
		new PlayerInteract();
		new PlayerPickupItem();
		
		sendConsoleMessage("TimeBombs has been enabled!", false);
		sendConsoleMessage("Plugin created by Shortninja.", false);
	}
	
	public static TimeBombs get()
	{
		return plugin;
	}
	
	@Override
	public void onDisable()
	{
		sendConsoleMessage("TimeBombs has been disabled!", true);
		plugin = null;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		if(label.equalsIgnoreCase("timebomb"))
		{
			new Hub(sender, cmd, label, args);
		}
		
		return true;
	}
	
	public void sendConsoleMessage(String message, boolean isError)
	{
		ConsoleCommandSender console = getServer().getConsoleSender();
		String prefix = isError ? "&4[TimeBombs] &c" : "&2[TimeBombs] &a";
		
		console.sendMessage(this.message.colorize(prefix + message));
	}
}