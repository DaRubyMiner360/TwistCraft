package ml.darubyminer360.twistcraft.listeners;

import ml.darubyminer360.twistcraft.TwistCraft;
import ml.darubyminer360.twistcraft.commands.OPLootCommand;
import ml.darubyminer360.twistcraft.util.CustomEnchants;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Random;

public class OPLootListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        Collection<ItemStack> drops = block.getDrops(player.getInventory().getItemInMainHand());

        boolean valid = true;
        if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR)
            valid = false;

        if (valid) {
            Random rand = new Random();
            for (int i = 0; i < rand.nextInt(3 - 1 + 1) + 1; i++) {
                if (block.getType().name().toUpperCase().endsWith("DOOR") && !block.getType().name().toUpperCase().endsWith("TRAPDOOR")) {
                    if (OPLootCommand.enabled.get("doors")) {
                        event.setDropItems(false);
                        block.getWorld().dropItemNaturally(block.getLocation(), TwistCraft.instance.opLootTable[rand.nextInt(TwistCraft.instance.opLootTable.length)]);
                    }
                }
                if (block.getType().name().toUpperCase().endsWith("TRAPDOOR")) {
                    if (OPLootCommand.enabled.get("trapdoors")) {
                        event.setDropItems(false);
                        block.getWorld().dropItemNaturally(block.getLocation(), TwistCraft.instance.opLootTable[rand.nextInt(TwistCraft.instance.opLootTable.length)]);
                    }
                }
            }
        }
    }
}
