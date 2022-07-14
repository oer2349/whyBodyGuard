package listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Event
        implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)((Object)sender);
            Location loc = p.getLocation();
            Entity ent = p.getWorld().spawnEntity(loc, EntityType.IRON_GOLEM);
            ItemStack item = new ItemStack(Material.MONSTER_EGG);
            ((IronGolem)((Object)ent)).setMaxHealth(1024.0);
            ((IronGolem)((Object)ent)).setHealth(1023.0);
            ((IronGolem)((Object)ent)).setCustomName(ChatColor.GOLD + p.getName() + " Koruması");
            p.sendMessage(ChatColor.LIGHT_PURPLE + "Koruman getirildi ve sağlık durumun fullendi");
            p.getInventory().removeItem(new ItemStack[]{item});
            p.setHealth(20.0);
            p.setFoodLevel(20);
        }
        return true;
    }
}