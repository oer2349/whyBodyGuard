package gui;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GuiEvent implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e){
     if(e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.AQUA + "BodyGuard Market")){
        Player player = (Player) e.getWhoClicked();
        switch(e.getCurrentItem().getType()){
            case BARRIER:
                player.closeInventory();
                break;
            case MONSTER_EGG:
                player.closeInventory();
                player.chat("/korumaitem");
                break;
        }
        e.setCancelled(true);
    }

}

}

