package utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Util
        implements Listener {
    @EventHandler
    public void PlayerSpawnMob(PlayerInteractEvent a) {
        Player p = a.getPlayer();
        if (a.getAction() == Action.RIGHT_CLICK_BLOCK && a.getMaterial() == Material.MONSTER_EGG) {
            if (p.getWorld().getName().equalsIgnoreCase("world")) {
                a.getPlayer().performCommand("korumadeneme");
            } else {
                a.setCancelled(true);
                p.sendMessage(ChatColor.GOLD + "Korumanı sadece orman dünyasında kullanabilirsin");
            }
        }
    }
}
