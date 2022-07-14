package wus;

import gui.Gui;
import gui.GuiEvent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import utils.Util;
import listener.Event;
import utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private static Economy econ = null;
    private static final Logger log = Logger.getLogger("Minecraft");


    public void onEnable() {
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        Bukkit.getLogger().info("whyUtils aktif");
        this.getServer().getPluginManager().registerEvents(new Util(), this);
        this.getServer().getPluginManager().registerEvents(new GuiEvent(), this);
        this.getCommand("koruma").setExecutor(new Gui());
        this.getCommand("korumadeneme").setExecutor(new Event());
        this.getCommand("korumaitem").setExecutor(new Item());
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;


    }

    public static Economy getEconomy() {
        return econ;
    }

}
