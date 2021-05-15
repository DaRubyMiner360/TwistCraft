package ml.darubyminer360.twistcraft.listeners;

import ml.darubyminer360.twistcraft.inventories.EverywhereLookedScreen;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.*;

public class EverywhereLookedScreenListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        if (event.getClickedInventory() == null) { return; }
        if (event.getClickedInventory().getHolder() instanceof EverywhereLookedScreen) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) { return; }
            if (event.getCurrentItem().getType() == Material.COBBLESTONE) {
                // Everywhere Looked Turns to Random Blocks
                p.performCommand("everywherelooked random");
            }
            else if (event.getCurrentItem().getType() == Material.BEDROCK) {
                // Everywhere Looked Turns to Bedrock
                p.performCommand("everywherelooked bedrock");
            }
            else if (event.getCurrentItem().getType() == Material.TNT) {
                // Everywhere Looked Explodes
                p.performCommand("everywherelooked explodes");
            }
            else {
                return;
            }
            p.closeInventory();
        }
    }
}
