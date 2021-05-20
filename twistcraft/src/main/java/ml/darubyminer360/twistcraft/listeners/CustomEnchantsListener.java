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
	public void onAddEnchantment(InventoryClickEvent e) {
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
                                        for (Map.Entry<Enchantment, Integer> entry1 : item.getEnchantments().entrySet()) {
                                            if (entry1.getKey() == entry.getKey() && entry1.getValue() + 1 <= entry1.getKey().getMaxLevel()) {
                                                if (entry1.getValue().equals(entry.getValue())) {
                                                    item.addUnsafeEnchantment(entry.getKey(), entry.getValue() + 1);
//                                                    meta.addStoredEnchant(entry.getKey(), entry.getValue() + 1, false);
                                                }
                                                else if (entry1.getValue() < entry.getValue()) {
                                                    item.addUnsafeEnchantment(entry.getKey(), entry.getValue());
//                                                    meta.addStoredEnchant(entry.getKey(), entry.getValue() + 1, false);
                                                }
                                            }
                                            else {
                                                item.addUnsafeEnchantment(entry.getKey(), entry.getValue());
//                                                meta.addStoredEnchant(entry.getKey(), entry.getValue(), false);
                                            }
                                        }
                                    }
                                    else {
                                        item.addUnsafeEnchantment(entry.getKey(), entry.getValue());
                                    }
                                    book.removeEnchantment(entry.getKey());
//                                    meta.removeStoredEnchant(entry.getKey());

                                    if (book.getEnchantments().size() == 0) {
//                                        if (meta.getStoredEnchants().size() == 0) {
                                        player.setItemOnCursor(new ItemStack(Material.AIR));
                                    }
                                }
                            }
//                            book.setItemMeta(meta);
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
            event.setDropItems(false);

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
                    Collection<ItemStack> drops2 = new ArrayList<ItemStack>();
                    Random rand = new Random();
                    for (ItemStack item : drops) {
                        for (int i = 0; i < rand.nextInt(player.getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(CustomEnchants.OPLOOT) - 1 + 1) + 1; i++) {
                            drops2.add(TwistCraft.instance.opLootTable[rand.nextInt(TwistCraft.instance.opLootTable.length)]);
                        }
                    }
                    drops = drops2;
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
                    for (ItemStack item : drops) {
                        if (player.getInventory().firstEmpty() != -1) {
                            player.getInventory().addItem(item);
                        }
                        else {
                            block.getWorld().dropItemNaturally(block.getLocation(), item);
//                            player.getWorld().dropItem(player.getLocation(), item);
                        }
                    }
                }
            }
            else {
                if (!drops.isEmpty()) {
                    for (ItemStack item : drops) {
                        block.getWorld().dropItemNaturally(block.getLocation(), item);
//                        player.getWorld().dropItem(player.getLocation(), item);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (CustomEnchantsCommand.enabled && event.getEntity().getKiller() instanceof Player) {
            event.getDrops().clear();

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
                    List<ItemStack> drops2 = new ArrayList<ItemStack>();
                    Random rand = new Random();
                    for (ItemStack item : drops) {
                        for (int i = 0; i < rand.nextInt(player.getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(CustomEnchants.OPLOOT) - 1 + 1) + 1; i++) {
                            drops2.add(TwistCraft.instance.opLootTable[rand.nextInt(TwistCraft.instance.opLootTable.length)]);
                        }
                    }
                    drops = drops2;
                }
            }
            if (player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.TELEPATHY)) {
                boolean valid = true;
                if (player.getInventory().firstEmpty() == -1)
                    valid = false;

                if (drops.isEmpty())
                    valid = false;

                if (valid) {
                    for (ItemStack item : drops) {
                        if (player.getInventory().firstEmpty() != -1) {
                            player.getInventory().addItem(item);
                        }
                        else {
                            player.getWorld().dropItem(player.getLocation(), item);
                        }
                    }
                }
                else {
                    if (!drops.isEmpty()) {
                        for (ItemStack item : drops) {
                            player.getWorld().dropItem(player.getLocation(), item);
                        }
                    }
                }
            }
            else {
                if (!drops.isEmpty()) {
                    for (ItemStack item : drops) {
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
