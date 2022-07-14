package gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Gui implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Inventory gui = Bukkit.createInventory(player, 9, ChatColor.AQUA + "BodyGuard Market");

            ItemStack barrier = new ItemStack(Material.BARRIER);
            ItemStack yumurta = new ItemStack(Material.MONSTER_EGG);

            ItemMeta yumurta_meta = yumurta.getItemMeta();
            yumurta_meta.setDisplayName(ChatColor.RED + "BodyGuard Yumurtası");
            ArrayList<String> yumurta_lore = new ArrayList<>();
            yumurta_lore.add(ChatColor.GOLD + "Orman'da sana yardım edecek bir dost. (Tıkla Satın Al)");
            yumurta_meta.setLore(yumurta_lore);
            yumurta.setItemMeta(yumurta_meta);

            gui.setItem(0, barrier);
            gui.setItem(8, barrier);
            gui.setItem(4, yumurta);
            player.openInventory(gui);

        }
        return true;
    }
}
