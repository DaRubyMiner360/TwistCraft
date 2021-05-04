package ml.darubyminer360.twistcraft.listeners;

import ml.darubyminer360.twistcraft.TwistCraft;
import ml.darubyminer360.twistcraft.commands.CustomEnchantsCommand;
import ml.darubyminer360.twistcraft.util.CustomEnchants;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;

import java.util.*;

public class CustomEnchantsListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (CustomEnchantsCommand.enabled) {
            Player player = event.getPlayer();
            Block block = event.getBlock();

            Collection<ItemStack> drops = block.getDrops(player.getInventory().getItemInMainHand());

            if (player.getInventory().getItemInMainHand() == null)
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
                if (block.getState() instanceof Container)
                    valid = false;

                if (drops.isEmpty())
                    valid = false;

                if (valid) {
                    event.setDropItems(false);
                    
                    for (ItemStack item : drops) {
                        if (player.getInventory().firstEmpty() != -1) {
                            player.getInventory().addItem(item);
                        }
                        else {
                            player.getWorld().dropItem(player.getLocation(), item);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity victim = event.getEntity();
        Player player = victim.getKiller();

        List<ItemStack> drops = event.getDrops();

        if (player.getInventory().getItemInMainHand() == null)
            return;
        if (!player.getInventory().getItemInMainHand().hasItemMeta())
            return;

        if (player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.OPLOOT)) {
            boolean valid = true;
            if (victim instanceof Player)
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
            if (player.getInventory().firstEmpty() == -1)
                valid = false;

            if (drops.isEmpty())
                valid = false;

            if (valid) {
                event.getDrops().clear();
                
                for (ItemStack item : drops) {
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(item);
                    }
                    else {
                        player.getWorld().dropItem(player.getLocation(), item);
                    }
                }
            }
        }
    }
    
    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (CustomEnchantsCommand.enabled) {
            if (event.getDamager() instanceof Player) {
                Player player = (Player) event.getDamager();
                LivingEntity victim = (LivingEntity) event.getEntity();

                if (player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.WITHERING)) {
                    boolean valid = true;

                    if (valid) {
                        // Give victim wither effect with level of withering
                        victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 1800, player.getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(CustomEnchants.WITHERING)));
                    }
                }
                if (player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.HEAVINESS)) {
                    boolean valid = true;

                    if (valid) {
                        // Give victim poison effect with level of infection
                        victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1800, player.getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(CustomEnchants.HEAVINESS)));
                    }
                }
                if (player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.INFECTION)) {
                    boolean valid = true;

                    if (valid) {
                        // Give victim poison effect with level of infection
                        victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 1800, player.getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(CustomEnchants.INFECTION)));
                    }
                }
                if (player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.LIFESTEAL)) {
                    boolean valid = true;

                    if (valid) {
                        // Give attacker (1/5 * level of lifesteal) of victims health
                        player.setHealth((player.getHealth() + event.getFinalDamage()) / (5 * player.getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(CustomEnchants.LIFESTEAL)));
                    }
                }
            }
        }
    }
}
