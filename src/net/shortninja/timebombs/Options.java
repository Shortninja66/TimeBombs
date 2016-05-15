package net.shortninja.timebombs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

public class Options
{
	private static FileConfiguration config = TimeBombs.get().getConfig();
	
	public String bombPermission = config.getString("bomb-permission");
	public Material bombItem = toMaterial(config.getString("bomb-item"));
	public String bombName = TimeBombs.get().message.colorize(config.getString("bomb-name"));
	public String[] bombLore = toArray(TimeBombs.get().message.colorize(config.getString("bomb-lore")));
	public long bombTime = (long) config.getDouble("bomb-time") * 20;
	public float bombStrength = (float) config.getDouble("bomb-strength");
	public String messagePrefix = config.getString("prefix");
	public String messageGaveBomb = config.getString("gave-bomb");
	public String messageReceivedBomb = config.getString("received-bomb");
	public String messageNoPermission = config.getString("no-permission");
	public String messageUnknownCommand = config.getString("unknown-command");
	public String messageNotEnoughArguments = config.getString("not-enough-arguments");
	public String messagePlayerIsOffline = config.getString("player-is-offline");
	public String messageNotEnoughRoom = config.getString("not-enough-room");
	
	private Material toMaterial(String name)
	{
		Material material = Material.SULPHUR;
		
		try
		{
			material = Material.valueOf(name);
		}catch(IllegalArgumentException exception)
		{
			TimeBombs.get().sendConsoleMessage("Invalid material type &7'" + name + "'&c!", true);
		}
		
		return material;
	}
	
	private String[] toArray(String string)
	{
		List<String> list = new ArrayList<String>();
		ListIterator<String> iterator = Arrays.asList(string.split("\\s*,\\s*")).listIterator();
		
		while(iterator.hasNext())
		{
			list.add(iterator.next().toUpperCase());
		}
		
		return list.toArray(new String[list.size()]);
	}
}