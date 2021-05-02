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
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.entity.*;

public class CraftableCommandBlocksListener implements Listener {
    GameMode previousGameMode;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (CraftableCommandBlocksCommand.enabled) {
            // Check preconditions.
            final org.bukkit.event.block.Action action = event.getAction();
            if (action == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) {
                if (event.getClickedBlock().getBlockData().getMaterial() == Material.COMMAND_BLOCK || event.getClickedBlock().getType() == Material.COMMAND_BLOCK || event.getMaterial() == Material.COMMAND_BLOCK) {
                    event.getPlayer().sendMessage("Craftable Command Blocks 2 1");
                    previousGameMode = event.getPlayer().getGameMode();
                    event.getPlayer().setGameMode(GameMode.CREATIVE);
                    WrapperPlayClientUseItem wrapper = new WrapperPlayClientUseItem();
                    wrapper.setLocation(new BlockPosition(event.getClickedBlock().getX(), event.getClickedBlock().getY(), event.getClickedBlock().getZ()));
                    wrapper.sendPacket(event.getPlayer());
                    event.getPlayer().setGameMode(previousGameMode);
                    previousGameMode = null;
                    event.getPlayer().sendMessage("Craftable Command Blocks 2 2");
                }
                if (event.getPlayer().getEquipment().getItemInMainHand().getType() == Material.COMMAND_BLOCK || event.getPlayer().getEquipment().getItemInOffHand().getType() == Material.COMMAND_BLOCK || event.getItem().getType() == Material.COMMAND_BLOCK) {
                    event.getPlayer().sendMessage("Craftable Command Blocks 1 1");
                    previousGameMode = event.getPlayer().getGameMode();
                    event.getPlayer().setGameMode(GameMode.CREATIVE);
                    WrapperPlayClientBlockPlace wrapper = new WrapperPlayClientBlockPlace();
                    wrapper.sendPacket(event.getPlayer());
                    event.getPlayer().setGameMode(previousGameMode);
                    if (previousGameMode != GameMode.CREATIVE) {
                        event.getPlayer().getEquipment().getItemInMainHand().setAmount(event.getPlayer().getEquipment().getItemInMainHand().getAmount() - 1);
                    }
                    previousGameMode = null;
                    event.getPlayer().sendMessage("Craftable Command Blocks 1 2");
                }
            }
        }
    }
}
