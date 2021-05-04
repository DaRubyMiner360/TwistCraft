package ml.darubyminer360.twistcraft.listeners;

import ml.darubyminer360.twistcraft.TwistCraft;
import ml.darubyminer360.twistcraft.commands.CustomEnchantsCommand;
import ml.darubyminer360.twistcraft.util.CustomEnchants;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Random;

public class CustomEnchantsListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (CustomEnchantsCommand.enabled) {
            Player player = event.getPlayer();
            Block block = event.getBlock();

            Collection<ItemStack> drops = block.getDrops(player.getInventory().getItemInMainHand());

            if (player.getInventory().getItemInMainHand().getType() == Material.AIR)
                return;
            if (!player.getInventory().getItemInMainHand().hasItemMeta())
                return;

            if (player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.OPLOOT)) {
                boolean valid = true;
                if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR)
                    valid = false;
                if (block.getState() instanceof Container)
                    valid = false;

                if (drops.isEmpty())
                    valid = false;

                if (valid) {
                    Random rand = new Random();
                    for (ItemStack item : drops) {
                        drops.remove(item);
                        drops.add(TwistCraft.instance.opLootTable[rand.nextInt(TwistCraft.instance.opLootTable.length)]);
                    }
                }
            }
            if (player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.TELEPATHY)) {
                boolean valid = true;
                if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR)
                    valid = false;
                if (player.getInventory().firstEmpty() == -1)
                    valid = false;
                if (block.getState() instanceof Container)
                    valid = false;

                if (drops.isEmpty())
                    valid = false;

                if (valid) {
                    event.setDropItems(false);

                    player.getInventory().addItem(drops.iterator().next());
                }
            }
        }
    }
}
