package utils;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import wus.Main;

import java.util.ArrayList;

public class Item implements CommandExecutor {
    private static final Economy econ = null;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = null;
        if (sender instanceof Player) {
            p = (Player) ((Object) sender);
            Economy eco = Main.getEconomy();
            eco.withdrawPlayer(p.getPlayer(), 100000000.0);
            ItemStack item = new ItemStack(Material.MONSTER_EGG);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.YELLOW + "KORUMA");
            item.setItemMeta(meta);
            p.getInventory().addItem(new ItemStack[]{item});
            p.sendMessage(ChatColor.BLUE + "Koruma yumurtan envanterine eklendi");
        }
        return true;
    }
}