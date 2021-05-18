package ml.darubyminer360.twistcraft.listeners;

import ml.darubyminer360.twistcraft.TwistCraft;
import ml.darubyminer360.twistcraft.commands.*;
import ml.darubyminer360.twistcraft.inventories.OPLootSelectionScreen;
import ml.darubyminer360.twistcraft.inventories.TwistSelectionScreen;
import ml.darubyminer360.twistcraft.util.SignMenuFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Arrays;

public class OPLootSelectionScreenListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        if (event.getClickedInventory() == null) { return; }
        if (event.getClickedInventory().getHolder() instanceof OPLootSelectionScreen) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) { return; }
            if (event.getCurrentItem().getType() == Material.OAK_DOOR) {
                // Doors Drop OP Loot
                p.closeInventory();

                p.performCommand("oploot doors");
            }
            else if (event.getCurrentItem().getType() == Material.OAK_TRAPDOOR) {
                // Trapdoors Drop OP Loot
                p.closeInventory();

                p.performCommand("oploot trapdoors");
            }
            else if (event.getCurrentItem().getType() == Material.SHEARS) {
                // Shearing Animals Drops OP Loot
                p.closeInventory();

                p.performCommand("oploot shearing");
            }
            else if (event.getCurrentItem().getType() == Material.ANVIL) {
                // Mending Items Drops OP Loot
                p.closeInventory();

                p.performCommand("oploot mending");
            }
        }
    }
}
