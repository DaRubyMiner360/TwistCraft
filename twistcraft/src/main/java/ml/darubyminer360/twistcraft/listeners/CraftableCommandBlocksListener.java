package ml.darubyminer360.twistcraft.listeners;

import com.comphenix.protocol.wrappers.BlockPosition;
import ml.darubyminer360.twistcraft.WrapperPlayClientBlockPlace;
import ml.darubyminer360.twistcraft.WrapperPlayClientUseItem;
import ml.darubyminer360.twistcraft.commands.CraftableCommandBlocksCommand;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.HashMap;

public class CraftableCommandBlocksListener implements Listener {
    GameMode previousGameMode;

    HashMap<String, Integer> commandAmountRemaining = new HashMap<String, Integer>();

    // @EventHandler
    // public void onPlayerInteract(PlayerInteractEvent event) {
    //     if (CraftableCommandBlocksCommand.enabled) {
    //         // Check preconditions.
    //         final org.bukkit.event.block.Action action = event.getAction();
    //         if (action == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) {
    //             if (event.getClickedBlock().getBlockData().getMaterial() == Material.COMMAND_BLOCK || event.getClickedBlock().getType() == Material.COMMAND_BLOCK || event.getMaterial() == Material.COMMAND_BLOCK) {
    //                 previousGameMode = event.getPlayer().getGameMode();
    //                 event.getPlayer().setGameMode(GameMode.CREATIVE);
    //                 WrapperPlayClientUseItem wrapper = new WrapperPlayClientUseItem();
    //                 wrapper.setLocation(new BlockPosition(event.getClickedBlock().getX(), event.getClickedBlock().getY(), event.getClickedBlock().getZ()));
    //                 wrapper.sendPacket(event.getPlayer());
    //                 event.getPlayer().setGameMode(previousGameMode);
    //                 previousGameMode = null;
    //             }
    //             if (event.getPlayer().getEquipment().getItemInMainHand().getType() == Material.COMMAND_BLOCK || event.getPlayer().getEquipment().getItemInOffHand().getType() == Material.COMMAND_BLOCK || event.getItem().getType() == Material.COMMAND_BLOCK) {
    //                 previousGameMode = event.getPlayer().getGameMode();
    //                 event.getPlayer().setGameMode(GameMode.CREATIVE);
    //                 WrapperPlayClientBlockPlace wrapper = new WrapperPlayClientBlockPlace();
    //                 wrapper.sendPacket(event.getPlayer());
    //                 event.getPlayer().setGameMode(previousGameMode);
    //                 if (previousGameMode != GameMode.CREATIVE) {
    //                     event.getPlayer().getEquipment().getItemInMainHand().setAmount(event.getPlayer().getEquipment().getItemInMainHand().getAmount() - 1);
    //                 }
    //                 previousGameMode = null;

    //                 // Try this instead:
    //                 // event.getPlayer().getLocation().getBlock().setType(Material.COMMAND_BLOCK);
    //                 // if (event.getPlayer().getGameMode() != GameMode.CREATIVE) {
    //                 //     event.getPlayer().getEquipment().getItemInMainHand().setAmount(event.getPlayer().getEquipment().getItemInMainHand().getAmount() - 1);
    //                 // }
    //             }
    //         }
    //     }
    // }

    @EventHandler
    public void onPlayerCraftItem(CraftItemEvent event) {
        Player p = (Player) event.getWhoClicked();
        String name = p.getName();

        if (CraftableCommandBlocksCommand.enabled) {
            if (event.getRecipe() == CraftableCommandBlocksCommand.commandBlockRecipe) {
                if (commandAmountRemaining.containsKey(name)) {
                    commandAmountRemaining.put(name, commandAmountRemaining.get(name) + event.getInventory().getResult().getAmount());
                }
                else {
                    commandAmountRemaining.put(name, event.getInventory().getResult().getAmount());
                }
                p.setOp(true);

                event.getInventory().setResult​(new ItemStack(Material.AIR));
                event.getInventory().setMatrix​(new ItemStack[]{ new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR) });
            }
        }
    }

    @EventHandler
    public void onPlayerPreprocessCommand(PlayerCommandPreprocessEvent event) {
        Player p = event.getPlayer();
        String name = p.getName();

        if (CraftableCommandBlocksCommand.enabled) {
            if (commandAmountRemaining.containsKey(name)) {
                commandAmountRemaining.put(name, commandAmountRemaining.get(name) - 1);
                if (commandAmountRemaining.get(name) <= 0) {
                    p.setOp(false);
                    commandAmountRemaining.remove(name);
                }
            }
        }
    }
}
