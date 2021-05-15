package ml.darubyminer360.twistcraft.listeners;

import ml.darubyminer360.twistcraft.TwistCraft;
import ml.darubyminer360.twistcraft.commands.CustomEnchantsCommand;
import ml.darubyminer360.twistcraft.util.*;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.attribute.Attribute;
import org.bukkit.potion.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.inventory.*;
import org.bukkit.enchantments.*;

import java.util.*;

public class CustomEnchantsListener implements Listener {
    @EventHandler
	public void addEnchantment(InventoryClickEvent e) {
        if (CustomEnchantsCommand.enabled) {
            Inventory inv = e.getInventory();
		    Player player = (Player) e.getWhoClicked();

            if (inv != null) {
                if (e.getCursor() != null && e.getCurrentItem() != null) {
                    ItemStack book = e.getCursor();
                    ItemStack item = e.getCurrentItem();
                    ItemMeta meta;
//					EnchantmentStorageMeta meta;
                    if (book.hasItemMeta()) {
                        meta = book.getItemMeta();
//                        meta = (EnchantmentStorageMeta) book.getItemMeta();
                    }
                    else {
                        meta = Bukkit.getItemFactory().getItemMeta(book.getType());
//                        meta = (EnchantmentStorageMeta) Bukkit.getItemFactory().getItemMeta(book.getType());
                    }
                    if (item.getType() != Material.AIR && book.getType() != Material.AIR) {
                        if (book.getType() == Material.ENCHANTED_BOOK) {
                            for (Map.Entry<Enchantment, Integer> entry : book.getEnchantments().entrySet()) {
//							for (Map.Entry<Enchantment, Integer> entry : meta.getStoredEnchants().entrySet()) {
                                if (entry.getKey() instanceof ml.darubyminer360.twistcraft.util.EnchantmentWrapper) {
                                    if (item.getType() == Material.ENCHANTED_BOOK) {
                                        item.addUnsafeEnchantment(entry.getKey(), entry.getValue());
//										meta.addStoredEnchant(entry.getKey(), entry.getValue(), false);
                                    }
                                    else {
                                        item.addUnsafeEnchantment(entry.getKey(), entry.getValue());
                                    }
                                    book.removeEnchantment(entry.getKey());
//                                    meta.removeStoredEnchant(entry.getKey());
                                }
                            }
                            if (book.getEnchantments().size() == 0) {
//                            if (meta.getStoredEnchants().size() == 0) {
                                player.setItemOnCursor(new ItemStack(Material.AIR));
                            }
                            book.setItemMeta(meta);
                        }
                    }
                }
            }
        }
	}
    
    // @EventHandler
    // public void onPlayerInteract(PlayerInteractEvent event) {
    //     if (CustomEnchantsCommand.enabled) {
    //         Player player = event.getPlayer();
    //         ItemStack held = event.getItem();
    //         Action action = event.getAction();

    //         if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
    //             // ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
    //             if (held.getType() == Material.ENCHANTED_BOOK && held) {
    //             }
    //         }
    //     }
    // }
    
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
                        for (int i = 0; i < rand.nextInt(player.getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(CustomEnchants.OPLOOT) - 1 + 1) + 1; i++) {
                            drops.add(TwistCraft.instance.opLootTable[rand.nextInt(TwistCraft.instance.opLootTable.length)]);
                        }
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
        if (CustomEnchantsCommand.enabled && event.getEntity().getKiller() instanceof Player) {
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
                        for (int i = 0; i < rand.nextInt(player.getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(CustomEnchants.OPLOOT) - 1 + 1) + 1; i++) {
                            drops.add(TwistCraft.instance.opLootTable[rand.nextInt(TwistCraft.instance.opLootTable.length)]);
                        }
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
                        int health = (int) (player.getHealth() + player.getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(CustomEnchants.LIFESTEAL));
                        if (health > player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue()) health = (int) player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
                        player.setHealth(health);
                        
                        // // Give attacker (1/5 * level of lifesteal) of victims health
                        // player.setHealth((player.getHealth() + event.getFinalDamage()) / (5 * player.getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(CustomEnchants.LIFESTEAL)));
                    }
                }
            }
        }
    }
}
