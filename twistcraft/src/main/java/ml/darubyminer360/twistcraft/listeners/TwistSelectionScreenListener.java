package ml.darubyminer360.twistcraft.listeners;

import ml.darubyminer360.twistcraft.inventories.TwistSelectionScreen;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.*;

public class TwistSelectionScreenListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        if (event.getClickedInventory() == null) { return; }
        if (event.getClickedInventory().getHolder() instanceof TwistSelectionScreen) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) { return; }
            if (event.getCurrentItem().getType() == Material.COMMAND_BLOCK) {
                // Craftable Command Blocks
                p.performCommand("craftablecommandblocks");
            }
            else if (event.getCurrentItem().getType() == Material.BARRIER) {
                // Craftable Barrier Blocks
                p.performCommand("craftablebarrierblocks");
            }
            else if (event.getCurrentItem().getType() == Material.ENCHANTED_GOLDEN_APPLE) {
                // Craftable Enchanted Golden Apples
                p.performCommand("craftableenchantedgoldenapples");
            }
            else if (event.getCurrentItem().getType() == Material.ZOMBIE_HEAD) {
                // OP Mobs
                p.performCommand("opmobs");
            }
            else if (event.getCurrentItem().getType() == Material.COOKED_BEEF) {
                // Half Heart Eating
                p.performCommand("halfhearteating");
            }
            else if (event.getCurrentItem().getType() == Material.BEDROCK) {
                // Everywhere Looked
                // Open GUI to select mode
                p.performCommand("everywherelookedselector");
            }
            else if (event.getCurrentItem().getType() == Material.TNT) {
                // TNT Runner
                p.performCommand("tntrunner");
            }
            else if (event.getCurrentItem().getType() == Material.COBBLESTONE) {
                // Falling Blocks
                p.performCommand("fallingblocks");
            }
            else if (event.getCurrentItem().getType() == Material.APPLE) {
                // Raining Items
                p.performCommand("rainingitems");
            }
            else if (event.getCurrentItem().getType() == Material.SPLASH_POTION) {
                // Sneak Invisibility
                p.performCommand("sneakinvisibility");
            }
            else if (event.getCurrentItem().getType() == Material.ELYTRA) {
                // Allowed Flight
                p.performCommand("allowedflight");
            }
            else if (event.getCurrentItem().getType() == Material.ENCHANTED_BOOK) {
                // Custom Enchants
                p.performCommand("customenchants");
            }
            else if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                // Manhunt
                // Open GUI to select speedrunner
                new AnvilGUI.Builder()
                    .onComplete((player, text) -> {
                        player.performCommand("manhunt " + text);
                        return AnvilGUI.Response.close();
                    })
                    .text("Speedrunner's Username")
                    .itemLeft(new ItemStack(Material.PAPER))
                    .title("Speedrunner's Username")
                    .plugin(TwistCraft.instance)
                    .open(p);
            }
            else if (event.getCurrentItem().getType() == Material.NETHERITE_SWORD) {
                // Death Swap
                // Open GUI to select opponent
                new AnvilGUI.Builder()
                    .onComplete((player, text) -> {
                        player.performCommand("deathswapselector " + text);
                        return AnvilGUI.Response.close();
                    })
                    .text("Opponent's Username")
                    .itemLeft(new ItemStack(Material.PAPER))
                    .title("Opponent's Username")
                    .plugin(TwistCraft.instance)
                    .open(p);
            }
            else {
                return;
            }
            p.closeInventory();
        }
    }
}
