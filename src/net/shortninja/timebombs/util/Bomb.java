package net.shortninja.timebombs.util;

import java.util.List;

import net.shortninja.timebombs.TimeBombs;
import net.shortninja.timebombs.util.hex.Items;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class Bomb
{
	public ItemStack normalMineBomb;
	private ItemStack explodingMineBomb;
	
	public Bomb()
	{
		normalMineBomb = normalBombItem();
		explodingMineBomb = explodingBombItem();
	}
	
	public boolean isMineBomb(ItemStack item, boolean exploding)
	{
		boolean isMineBomb = false;
		
		if(item.hasItemMeta())
		{
			ItemMeta itemMeta = item.getItemMeta();
			
			if(itemMeta.hasLore())
			{
				List<String> itemLore = itemMeta.getLore();
				
				if(itemLore.get(0).equals(normalMineBomb.getItemMeta().getLore().get(0)) && !exploding)
				{
					isMineBomb = true;
				}
			}
			
			if(itemMeta.hasDisplayName() && !isMineBomb)
			{
				String displayName = itemMeta.getDisplayName();
				
				if(displayName.equals(explodingMineBomb.getItemMeta().getDisplayName()) && exploding)
				{
					isMineBomb = true;
				}
			}
		}
		
		return isMineBomb;
	}
	
	public void useBomb(Player player)
	{
		ItemStack itemStack = player.getItemInHand();
		int itemAmount = itemStack.getAmount();
		final Location location = player.getLocation();
		final Item item = location.getWorld().dropItemNaturally(location, explodingMineBomb);
		
		if(player.getGameMode() != GameMode.CREATIVE)
		{
			if(itemAmount > 1)
			{
				itemStack.setAmount(itemAmount - 1);
			}else player.getInventory().remove(itemStack);
		}
		
		new BukkitRunnable()
		{
			public void run()
			{
				location.getWorld().createExplosion(item.getLocation(), TimeBombs.get().options.bombStrength);
				item.remove();
			}
		}.runTaskLater(TimeBombs.get(), TimeBombs.get().options.bombTime);
	}
	
	private ItemStack normalBombItem()
	{
		return Items.builder().setMaterial(TimeBombs.get().options.bombItem).setAmount(1).setName(TimeBombs.get().options.bombName).addLore(TimeBombs.get().options.bombLore).build();
	}
	
	private ItemStack explodingBombItem()
	{
		return Items.builder().setMaterial(TimeBombs.get().options.bombItem).setAmount(1).setName("&4EXPLODING").build();
	}
}