package ml.darubyminer360.twistcraft;

import ml.darubyminer360.twistcraft.commands.*;

import ml.darubyminer360.twistcraft.listeners.*;
import ml.darubyminer360.twistcraft.util.Config;
import ml.darubyminer360.twistcraft.util.CustomEnchants;
import ml.darubyminer360.twistcraft.util.SignMenuFactory;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.*;
import org.bukkit.entity.Player;
import org.bukkit.attribute.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.meta.tags.*;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.*;

import java.io.File;
import java.io.IOException;

import java.util.stream.*;
import java.util.*;

public class TwistCraft extends JavaPlugin {
    public static TwistCraft instance;

    SignMenuFactory signMenuFactory;

    public ItemStack[] opLootTableMaterials;
    public ItemStack[] opLootTableBooks;
    public ItemStack[] opLootTableTools;
    public ItemStack[] opLootTableArmor;
    public ItemStack[] opLootTableGear;
    public ItemStack[] opLootTableFood;
    public ItemStack[] opLootTableMisc;
    public ItemStack[] opLootTable;

    @Override
    public void onEnable() {
        instance = this;

        this.signMenuFactory = new SignMenuFactory(this);

        // Setup OP Loot Tables
        setupOPLootTables();

        // Setup commands
        getCommand("twist").setExecutor(new TwistCommand());
        getCommand("craftablecommandblocks").setExecutor(new CraftableCommandBlocksCommand());
        getCommand("opmobs").setExecutor(new OPMobsCommand());
        getCommand("halfhearteating").setExecutor(new HalfHeartEatingCommand());
        getCommand("manhunt").setExecutor(new ManhuntCommand());
        getCommand("everywherelooked").setExecutor(new EverywhereLookedCommand());
        getCommand("everywherelookedselector").setExecutor(new EverywhereLookedSelectorCommand());
        getCommand("deathswap").setExecutor(new DeathSwapCommand());
        getCommand("tntrunner").setExecutor(new TNTRunnerCommand());
        getCommand("fallingblocks").setExecutor(new FallingBlocksCommand());
        getCommand("fallingblocks").setExecutor(new FallingBlocksCommand());
        getCommand("sneakinvisibility").setExecutor(new SneakInvisibilityCommand());
        getCommand("allowedflight").setExecutor(new AllowedFlightCommand());
        getCommand("oploot").setExecutor(new OPLootCommand());

        // Setup Listeners
        getServer().getPluginManager().registerEvents(new TwistSelectionScreenListener(), this);
        getServer().getPluginManager().registerEvents(new CraftableCommandBlocksListener(), this);
        getServer().getPluginManager().registerEvents(new OPMobsListener(), this);
        getServer().getPluginManager().registerEvents(new HalfHeartEatingListener(), this);
        getServer().getPluginManager().registerEvents(new ManhuntListener(), this);
        getServer().getPluginManager().registerEvents(new EverywhereLookedListener(), this);
        getServer().getPluginManager().registerEvents(new EverywhereLookedScreenListener(), this);
        getServer().getPluginManager().registerEvents(new SneakInvisibilityListener(), this);
        getServer().getPluginManager().registerEvents(new OPLootListener(), this);
        getServer().getPluginManager().registerEvents(new OPLootSelectionScreenListener(), this);
        getServer().getPluginManager().registerEvents(new OPItemsListener(), this);

        // Setup enchantments
        CustomEnchants.register();
        getCommand("customenchants").setExecutor(new CustomEnchantsCommand());
        getServer().getPluginManager().registerEvents(new CustomEnchantsListener(), this);
        getCommand("addcustomenchant").setExecutor(new AddCustomEnchantCommand());
        getCommand("getcustomenchant").setExecutor(new GetCustomEnchantCommand());

        OPLootCommand.enabled.put("doors", false);
        OPLootCommand.enabled.put("trapdoors", false);
        OPLootCommand.enabled.put("shearing", false);
        OPLootCommand.enabled.put("mending", false);
//        OPLootCommand.enabled.put("oplootenchant", false);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    for (ItemStack item : player.getInventory().getContents()) {
                        if (item != null && item.getType() != null && item.getType() != Material.AIR) {
                            ItemMeta meta = item.getItemMeta();
//                            ItemMeta meta;
//                            if (item.hasItemMeta()) {
//                                meta = item.getItemMeta();
//                            }
//                            else {
//                                meta = Bukkit.getItemFactory().getItemMeta(item.getType());
//                            }
                            if (item.containsEnchantment(CustomEnchants.OPLOOT)) {
                                if (meta.hasLore()) {
                                    List<String> lore = meta.getLore();
                                    boolean hasLore = false;
                                    for (String lo : lore) {
                                        if (lo.contains("OP Loot")) {
                                            hasLore = true;
                                        }
                                    }
                                    if (!hasLore) {
                                        lore.add("OP Loot");
                                    }
                                    meta.setLore(lore);
                                }
                                else {
                                    List<String> lore = new ArrayList<String>();
                                    lore.add("OP Loot");
                                    meta.setLore(lore);
                                }
                            }
                            if (item.containsEnchantment(CustomEnchants.TELEPATHY)) {
                                if (meta.hasLore()) {
                                    List<String> lore = meta.getLore();
                                    boolean hasLore = false;
                                    for (String lo : lore) {
                                        if (lo.contains("Telepathy")) {
                                            hasLore = true;
                                        }
                                    }
                                    if (!hasLore) {
                                        lore.add("Telepathy");
                                    }
                                    meta.setLore(lore);
                                }
                                else {
                                    List<String> lore = new ArrayList<String>();
                                    lore.add("Telepathy");
                                    meta.setLore(lore);
                                }
                            }
                            if (item.containsEnchantment(CustomEnchants.CURSE_OF_GRINDING)) {
                                if (meta.hasLore()) {
                                    List<String> lore = meta.getLore();
                                    boolean hasLore = false;
                                    for (String lo : lore) {
                                        if (lo.contains("Curse of Grinding")) {
                                            hasLore = true;
                                        }
                                    }
                                    if (!hasLore) {
                                        lore.add("§cCurse of Grinding");
                                    }
                                    meta.setLore(lore);
                                }
                                else {
                                    List<String> lore = new ArrayList<String>();
                                    lore.add("§cCurse of Grinding");
                                    meta.setLore(lore);
                                }
                            }
                            if (item.containsEnchantment(CustomEnchants.LIFESTEAL)) {
                                if (meta.hasLore()) {
                                    List<String> lore = meta.getLore();

                                    boolean hasLore = false;
                                    for (String lo : lore) {
                                        if (lo.contains("Lifesteal")) {
                                            hasLore = true;
                                            String l = "Lifesteal";
                                            if (item.getEnchantmentLevel(CustomEnchants.LIFESTEAL) == 1) {
                                                l += " I";
                                            }
                                            else if (item.getEnchantmentLevel(CustomEnchants.LIFESTEAL) == 2) {
                                                l += " II";
                                            }
                                            else if (item.getEnchantmentLevel(CustomEnchants.LIFESTEAL) == 3) {
                                                l += " III";
                                            }
                                            else if (item.getEnchantmentLevel(CustomEnchants.LIFESTEAL) == 4) {
                                                l += " IV";
                                            }
                                            else if (item.getEnchantmentLevel(CustomEnchants.LIFESTEAL) == 5) {
                                                l += " V";
                                            }
                                            else {
                                                l += " " + item.getEnchantmentLevel(CustomEnchants.LIFESTEAL);
                                            }
                                            int index = lore.indexOf(lo);
                                            lore.set(index, l);
                                        }
                                    }
                                    if (!hasLore) {
                                        String l = "Lifesteal";
                                        if (item.getEnchantmentLevel(CustomEnchants.LIFESTEAL) == 1) {
                                            l += " I";
                                        }
                                        else if (item.getEnchantmentLevel(CustomEnchants.LIFESTEAL) == 2) {
                                            l += " II";
                                        }
                                        else if (item.getEnchantmentLevel(CustomEnchants.LIFESTEAL) == 3) {
                                            l += " III";
                                        }
                                        else if (item.getEnchantmentLevel(CustomEnchants.LIFESTEAL) == 4) {
                                            l += " IV";
                                        }
                                        else if (item.getEnchantmentLevel(CustomEnchants.LIFESTEAL) == 5) {
                                            l += " V";
                                        }
                                        else {
                                            l += " " + item.getEnchantmentLevel(CustomEnchants.LIFESTEAL);
                                        }
                                        lore.add(l);
                                    }
                                    meta.setLore(lore);
                                }
                                else {
                                    String l = "Lifesteal";
                                    if (item.getEnchantmentLevel(CustomEnchants.LIFESTEAL) == 1) {
                                        l += " I";
                                    }
                                    else if (item.getEnchantmentLevel(CustomEnchants.LIFESTEAL) == 2) {
                                        l += " II";
                                    }
                                    else if (item.getEnchantmentLevel(CustomEnchants.LIFESTEAL) == 3) {
                                        l += " III";
                                    }
                                    else if (item.getEnchantmentLevel(CustomEnchants.LIFESTEAL) == 4) {
                                        l += " IV";
                                    }
                                    else if (item.getEnchantmentLevel(CustomEnchants.LIFESTEAL) == 5) {
                                        l += " V";
                                    }
                                    else {
                                        l += " " + item.getEnchantmentLevel(CustomEnchants.LIFESTEAL);
                                    }

                                    List<String> lore = new ArrayList<String>();
                                    lore.add(l);
                                    meta.setLore(lore);
                                }
                            }
                            if (item.containsEnchantment(CustomEnchants.INFECTION)) {
                                if (meta.hasLore()) {
                                    List<String> lore = meta.getLore();

                                    boolean hasLore = false;
                                    for (String lo : lore) {
                                        if (lo.contains("Infection")) {
                                            hasLore = true;
                                            String l = "Infection";
                                            if (item.getEnchantmentLevel(CustomEnchants.INFECTION) == 1) {
                                                l += " I";
                                            }
                                            else if (item.getEnchantmentLevel(CustomEnchants.INFECTION) == 2) {
                                                l += " II";
                                            }
                                            else {
                                                l += " " + item.getEnchantmentLevel(CustomEnchants.INFECTION);
                                            }
                                            int index = lore.indexOf(lo);
                                            lore.set(index, l);
                                        }
                                    }
                                    if (!hasLore) {
                                        String l = "Infection";
                                        if (item.getEnchantmentLevel(CustomEnchants.INFECTION) == 1) {
                                            l += " I";
                                        }
                                        else if (item.getEnchantmentLevel(CustomEnchants.INFECTION) == 2) {
                                            l += " II";
                                        }
                                        else {
                                            l += " " + item.getEnchantmentLevel(CustomEnchants.INFECTION);
                                        }
                                        lore.add(l);
                                    }
                                    meta.setLore(lore);
                                }
                                else {
                                    String l = "Infection";
                                    if (item.getEnchantmentLevel(CustomEnchants.INFECTION) == 1) {
                                        l += " I";
                                    }
                                    else if (item.getEnchantmentLevel(CustomEnchants.INFECTION) == 2) {
                                        l += " II";
                                    }
                                    else {
                                        l += " " + item.getEnchantmentLevel(CustomEnchants.INFECTION);
                                    }

                                    List<String> lore = new ArrayList<String>();
                                    lore.add(l);
                                    meta.setLore(lore);
                                }
                            }
                            if (item.containsEnchantment(CustomEnchants.WITHERING)) {
                                if (meta.hasLore()) {
                                    List<String> lore = meta.getLore();
                                    boolean hasLore = false;
                                    for (String lo : lore) {
                                        if (lo.contains("Withering")) {
                                            hasLore = true;
                                            String l = "Withering";
                                            if (item.getEnchantmentLevel(CustomEnchants.WITHERING) == 1) {
                                                l += " I";
                                            }
                                            else if (item.getEnchantmentLevel(CustomEnchants.WITHERING) == 2) {
                                                l += " II";
                                            }
                                            else {
                                                l += " " + item.getEnchantmentLevel(CustomEnchants.WITHERING);
                                            }
                                            int index = lore.indexOf(lo);
                                            lore.set(index, l);
                                        }
                                    }
                                    if (!hasLore) {
                                        String l = "Withering";
                                        if (item.getEnchantmentLevel(CustomEnchants.WITHERING) == 1) {
                                            l += " I";
                                        }
                                        else if (item.getEnchantmentLevel(CustomEnchants.WITHERING) == 2) {
                                            l += " II";
                                        }
                                        else {
                                            l += " " + item.getEnchantmentLevel(CustomEnchants.WITHERING);
                                        }
                                        lore.add(l);
                                    }
                                    meta.setLore(lore);
                                }
                                else {
                                    String l = "Withering";
                                    if (item.getEnchantmentLevel(CustomEnchants.WITHERING) == 1) {
                                        l += " I";
                                    }
                                    else if (item.getEnchantmentLevel(CustomEnchants.WITHERING) == 2) {
                                        l += " II";
                                    }
                                    else {
                                        l += " " + item.getEnchantmentLevel(CustomEnchants.WITHERING);
                                    }

                                    List<String> lore = new ArrayList<String>();
                                    lore.add(l);
                                    meta.setLore(lore);
                                }
                            }
                            if (item.containsEnchantment(CustomEnchants.HEAVINESS)) {
                                if (meta.hasLore()) {
                                    List<String> lore = meta.getLore();

                                    boolean hasLore = false;
                                    for (String lo : lore) {
                                        if (lo.contains("Heaviness")) {
                                            hasLore = true;
                                            String l = "Heaviness";
                                            if (item.getEnchantmentLevel(CustomEnchants.HEAVINESS) == 1) {
                                                l += " I";
                                            }
                                            else if (item.getEnchantmentLevel(CustomEnchants.HEAVINESS) == 2) {
                                                l += " II";
                                            }
                                            else {
                                                l += " " + item.getEnchantmentLevel(CustomEnchants.HEAVINESS);
                                            }
                                            int index = lore.indexOf(lo);
                                            lore.set(index, l);
                                        }
                                    }
                                    if (!hasLore) {
                                        String l = "Heaviness";
                                        if (item.getEnchantmentLevel(CustomEnchants.HEAVINESS) == 1) {
                                            l += " I";
                                        }
                                        else if (item.getEnchantmentLevel(CustomEnchants.HEAVINESS) == 2) {
                                            l += " II";
                                        }
                                        else {
                                            l += " " + item.getEnchantmentLevel(CustomEnchants.HEAVINESS);
                                        }
                                        lore.add(l);
                                    }
                                    meta.setLore(lore);
                                }
                                else {
                                    String l = "Heaviness";
                                    if (item.getEnchantmentLevel(CustomEnchants.HEAVINESS) == 1) {
                                        l += " I";
                                    }
                                    else if (item.getEnchantmentLevel(CustomEnchants.HEAVINESS) == 2) {
                                        l += " II";
                                    }
                                    else {
                                        l += " " + item.getEnchantmentLevel(CustomEnchants.HEAVINESS);
                                    }

                                    List<String> lore = new ArrayList<String>();
                                    lore.add(l);
                                    meta.setLore(lore);
                                }
                            }
                            item.setItemMeta(meta);
                        }
                    }
                }
            }
        }, 20, 20);

        // Setup config
        Config.setup();
        Config.get().addDefault("BroadcastMessages", false);
        Config.get().options().copyDefaults(true);
        Config.save();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public SignMenuFactory getSignMenuFactory() {
        return this.signMenuFactory;
    }

    public void messageServer(String message, Player p) {
        if (Config.get().getBoolean("BroadcastMessages")) {
            p.getServer().broadcastMessage(message);
        }
        else {
            p.sendMessage(message);
        }
    }

    public ItemStack[] joinItemStacks(ItemStack[] first, ItemStack[] second) {
        Stream<ItemStack> firstStream = Arrays.stream(first);
        Stream<ItemStack> secondStream = Arrays.stream(second);
        return Stream.concat(firstStream, secondStream).toArray(ItemStack[]::new); 
    }

    public void setupOPLootTables() {
        ItemStack netheriteHoe = new ItemStack(Material.NETHERITE_HOE, 1);
        netheriteHoe.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        netheriteHoe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 7);
        netheriteHoe.addUnsafeEnchantment(Enchantment.MENDING, 3);

        ItemStack netheriteSword = new ItemStack(Material.NETHERITE_SWORD, 1);
        netheriteSword.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        netheriteSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 7);
        netheriteSword.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 7);
        netheriteSword.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 7);
        netheriteSword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 5);
        netheriteSword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
        netheriteSword.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 5);
        netheriteSword.addUnsafeEnchantment(Enchantment.MENDING, 3);

        ItemStack netheriteAxe = new ItemStack(Material.NETHERITE_AXE, 1);
        netheriteAxe.addUnsafeEnchantment(Enchantment.DURABILITY, 6);
        netheriteAxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
        netheriteAxe.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 8);
        netheriteAxe.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 8);
        netheriteAxe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 6);
        netheriteAxe.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
        netheriteAxe.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 6);
        netheriteAxe.addUnsafeEnchantment(Enchantment.MENDING, 3);

        ItemStack riptideTrident = new ItemStack(Material.TRIDENT, 1);
        riptideTrident.addUnsafeEnchantment(Enchantment.RIPTIDE, 1);

        ItemStack unbreakableHelmet = new ItemStack(Material.IRON_HELMET, 1);
        unbreakableHelmet.addUnsafeEnchantment(Enchantment.DURABILITY, 32767);
        unbreakableHelmet.addUnsafeEnchantment(Enchantment.MENDING, 32767);
        ItemMeta unbreakableHelmetMeta = unbreakableHelmet.getItemMeta();
        unbreakableHelmetMeta.setDisplayName("§1Unbreakable Helmet");
        unbreakableHelmet.setItemMeta(unbreakableHelmetMeta);
        
        ItemStack unbreakableChestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
        unbreakableChestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 32767);
        unbreakableChestplate.addUnsafeEnchantment(Enchantment.MENDING, 32767);
        ItemMeta unbreakableChestplateMeta = unbreakableChestplate.getItemMeta();
        unbreakableChestplateMeta.setDisplayName("§1Unbreakable Chestplate");
        unbreakableChestplate.setItemMeta(unbreakableChestplateMeta);
        
        ItemStack unbreakableLeggings = new ItemStack(Material.IRON_LEGGINGS, 1);
        unbreakableLeggings.addUnsafeEnchantment(Enchantment.DURABILITY, 32767);
        unbreakableLeggings.addUnsafeEnchantment(Enchantment.MENDING, 32767);
        ItemMeta unbreakableLeggingsMeta = unbreakableLeggings.getItemMeta();
        unbreakableLeggingsMeta.setDisplayName("§1Unbreakable Leggings");
        unbreakableLeggings.setItemMeta(unbreakableLeggingsMeta);
        
        ItemStack unbreakableBoots = new ItemStack(Material.IRON_BOOTS, 1);
        unbreakableBoots.addUnsafeEnchantment(Enchantment.DURABILITY, 32767);
        unbreakableBoots.addUnsafeEnchantment(Enchantment.MENDING, 32767);
        ItemMeta unbreakableBootsMeta = unbreakableBoots.getItemMeta();
        unbreakableBootsMeta.setDisplayName("§1Unbreakable Boots");
        unbreakableBoots.setItemMeta(unbreakableBootsMeta);
        
        ItemStack frozenBoots = new ItemStack(Material.IRON_BOOTS, 1);
        frozenBoots.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        frozenBoots.addUnsafeEnchantment(Enchantment.FROST_WALKER, 32767);
        frozenBoots.addUnsafeEnchantment(Enchantment.MENDING, 1);
        ItemMeta frozenBootsMeta = frozenBoots.getItemMeta();
        frozenBootsMeta.setDisplayName("§bFrozen Boots");
        frozenBoots.setItemMeta(frozenBootsMeta);
        
        ItemStack speedsterBoots = new ItemStack(Material.IRON_BOOTS, 1);
        speedsterBoots.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        speedsterBoots.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 32767);
        speedsterBoots.addUnsafeEnchantment(Enchantment.MENDING, 1);
        ItemMeta speedsterBootsMeta = speedsterBoots.getItemMeta();
        AttributeModifier speedsterBootsSpeedModifier = new AttributeModifier("player_speed", 1000000, AttributeModifier.Operation.ADD_NUMBER);
        speedsterBootsMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speedsterBootsSpeedModifier);
        speedsterBootsMeta.setDisplayName("§3Speedster Boots");
        speedsterBoots.setItemMeta(speedsterBootsMeta);

        ItemStack ironChestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ironChestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        ironChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
        ironChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
        ironChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
        ironChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 4);
        ironChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        ironChestplate.addUnsafeEnchantment(Enchantment.THORNS, 3);
        ironChestplate.addUnsafeEnchantment(Enchantment.MENDING, 1);
        
        ItemStack ironBoots = new ItemStack(Material.IRON_BOOTS, 1);
        ironBoots.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        ironBoots.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
        ironBoots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
        ironBoots.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
        ironBoots.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 4);
        ironBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        ironBoots.addUnsafeEnchantment(Enchantment.FROST_WALKER, 2);
        ironBoots.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 10);
        ironBoots.addUnsafeEnchantment(Enchantment.THORNS, 3);
        ironBoots.addUnsafeEnchantment(Enchantment.MENDING, 1);

        ItemStack diamondHelmet = new ItemStack(Material.DIAMOND_HELMET, 1);
        diamondHelmet.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        diamondHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
        diamondHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
        diamondHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
        diamondHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 4);
        diamondHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        diamondHelmet.addUnsafeEnchantment(Enchantment.THORNS, 3);
        diamondHelmet.addUnsafeEnchantment(Enchantment.MENDING, 1);

        ItemStack diamondLeggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        diamondLeggings.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        diamondLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
        diamondLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
        diamondLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
        diamondLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 4);
        diamondLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        diamondLeggings.addUnsafeEnchantment(Enchantment.FROST_WALKER, 2);
        diamondLeggings.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 10);
        diamondLeggings.addUnsafeEnchantment(Enchantment.THORNS, 3);
        diamondLeggings.addUnsafeEnchantment(Enchantment.MENDING, 1);

        ItemStack netheriteHelmet = new ItemStack(Material.NETHERITE_HELMET, 1);
        netheriteHelmet.addUnsafeEnchantment(Enchantment.DURABILITY, 16384);
        netheriteHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 8192);
        netheriteHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 8192);
        netheriteHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 8192);
        netheriteHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 8192);
        netheriteHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8192);
        netheriteHelmet.addUnsafeEnchantment(Enchantment.THORNS, 10000);
        netheriteHelmet.addUnsafeEnchantment(Enchantment.MENDING, 10);

        ItemStack netheriteChestplate = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
        netheriteChestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 16384);
        netheriteChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 8192);
        netheriteChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 8192);
        netheriteChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 8192);
        netheriteChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 8192);
        netheriteChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8192);
        netheriteChestplate.addUnsafeEnchantment(Enchantment.THORNS, 10000);
        netheriteChestplate.addUnsafeEnchantment(Enchantment.MENDING, 10);

        ItemStack netheriteLeggings = new ItemStack(Material.NETHERITE_LEGGINGS, 1);
        netheriteLeggings.addUnsafeEnchantment(Enchantment.DURABILITY, 16384);
        netheriteLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 8192);
        netheriteLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 8192);
        netheriteLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 8192);
        netheriteLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 8192);
        netheriteLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8192);
        netheriteLeggings.addUnsafeEnchantment(Enchantment.FROST_WALKER, 2);
        netheriteLeggings.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 10);
        netheriteLeggings.addUnsafeEnchantment(Enchantment.THORNS, 10000);
        netheriteLeggings.addUnsafeEnchantment(Enchantment.MENDING, 10);

        ItemStack netheriteBoots = new ItemStack(Material.NETHERITE_BOOTS, 1);
        netheriteBoots.addUnsafeEnchantment(Enchantment.DURABILITY, 16384);
        netheriteBoots.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 8192);
        netheriteBoots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 8192);
        netheriteBoots.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 8192);
        netheriteBoots.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 8192);
        netheriteBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8192);
        netheriteBoots.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 500);
        netheriteBoots.addUnsafeEnchantment(Enchantment.THORNS, 10000);
        netheriteBoots.addUnsafeEnchantment(Enchantment.MENDING, 10);

        ItemStack regeneratingTotem = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
        NamespacedKey regeneratingTotemKey = new NamespacedKey(this, "regenerating_totem");
        ItemMeta regeneratingTotemMeta = regeneratingTotem.getItemMeta();
        regeneratingTotemMeta.setDisplayName("Regenerating Totem");
        regeneratingTotemMeta.getPersistentDataContainer().set(regeneratingTotemKey, PersistentDataType.DOUBLE, 1.0);
        regeneratingTotem.setItemMeta(regeneratingTotemMeta);

        ItemStack opLootBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta opLootBookMeta = (EnchantmentStorageMeta) opLootBook.getItemMeta();
        // opLootBookMeta.addStoredEnchant(CustomEnchants.OPLOOT, 1, true);
        opLootBook.addUnsafeEnchantment(CustomEnchants.OPLOOT, 1);
//        opLootBook.setItemMeta(opLootBookMeta);

        ItemStack telepathyBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta telepathyBookMeta = (EnchantmentStorageMeta) telepathyBook.getItemMeta();
        // telepathyBookMeta.addStoredEnchant(CustomEnchants.TELEPATHY, 1, true);
        telepathyBook.addUnsafeEnchantment(CustomEnchants.TELEPATHY, 1);
//        telepathyBook.setItemMeta(telepathyBookMeta);

        ItemStack lifestealOneBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta lifestealOneBookMeta = (EnchantmentStorageMeta) lifestealOneBook.getItemMeta();
        // lifestealOneBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 1, true);
        lifestealOneBook.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 1);
//        lifestealOneBook.setItemMeta(lifestealOneBookMeta);

        ItemStack lifestealTwoBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta lifestealTwoBookMeta = (EnchantmentStorageMeta) lifestealTwoBook.getItemMeta();
        // lifestealTwoBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 2, true);
        lifestealTwoBook.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 2);
//        lifestealTwoBook.setItemMeta(lifestealTwoBookMeta);

        ItemStack lifestealThreeBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta lifestealThreeBookMeta = (EnchantmentStorageMeta) lifestealThreeBook.getItemMeta();
        // lifestealThreeBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 3, true);
        lifestealThreeBook.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 3);
//        lifestealThreeBook.setItemMeta(lifestealThreeBookMeta);

        ItemStack lifestealFourBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta lifestealFourBookMeta = (EnchantmentStorageMeta) lifestealFourBook.getItemMeta();
        // lifestealFourBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 4, true);
        lifestealFourBook.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 4);
//        lifestealFourBook.setItemMeta(lifestealFourBookMeta);

        ItemStack lifestealFiveBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta lifestealFiveBookMeta = (EnchantmentStorageMeta) lifestealFiveBook.getItemMeta();
        // lifestealFiveBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 5, true);
        lifestealFiveBook.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 5);
//        lifestealFiveBook.setItemMeta(lifestealFiveBookMeta);

        ItemStack infectionOneBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta infectionOneBookMeta = (EnchantmentStorageMeta) infectionOneBook.getItemMeta();
        // infectionOneBookMeta.addStoredEnchant(CustomEnchants.INFECTION, 1, true);
        infectionOneBook.addUnsafeEnchantment(CustomEnchants.INFECTION, 1);
//        infectionOneBook.setItemMeta(infectionOneBookMeta);

        ItemStack infectionTwoBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta infectionTwoBookMeta = (EnchantmentStorageMeta) infectionTwoBook.getItemMeta();
        // infectionTwoBookMeta.addStoredEnchant(CustomEnchants.INFECTION, 2, true);
        infectionTwoBook.addUnsafeEnchantment(CustomEnchants.INFECTION, 2);
//        infectionTwoBook.setItemMeta(infectionTwoBookMeta);

        ItemStack witheringOneBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta witheringOneBookMeta = (EnchantmentStorageMeta) witheringOneBook.getItemMeta();
        // witheringOneBookMeta.addStoredEnchant(CustomEnchants.WITHERING, 1, true);
        witheringOneBook.addUnsafeEnchantment(CustomEnchants.WITHERING, 1);
//        witheringOneBook.setItemMeta(witheringOneBookMeta);

        ItemStack witheringTwoBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta witheringTwoBookMeta = (EnchantmentStorageMeta) witheringTwoBook.getItemMeta();
        // witheringTwoBookMeta.addStoredEnchant(CustomEnchants.WITHERING, 2, true);
        witheringTwoBook.addUnsafeEnchantment(CustomEnchants.WITHERING, 2);
//        witheringTwoBook.setItemMeta(witheringTwoBookMeta);

        ItemStack heavinessOneBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta heavinessOneBookMeta = (EnchantmentStorageMeta) heavinessOneBook.getItemMeta();
        // heavinessOneBookMeta.addStoredEnchant(CustomEnchants.HEAVINESS, 1, true);
        heavinessOneBook.addUnsafeEnchantment(CustomEnchants.HEAVINESS, 1);
//        heavinessOneBook.setItemMeta(heavinessOneBookMeta);

        ItemStack heavinessTwoBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta heavinessTwoBookMeta = (EnchantmentStorageMeta) heavinessTwoBook.getItemMeta();
        // heavinessTwoBookMeta.addStoredEnchant(CustomEnchants.HEAVINESS, 2, true);
        heavinessTwoBook.addUnsafeEnchantment(CustomEnchants.HEAVINESS, 2);
//        heavinessTwoBook.setItemMeta(heavinessTwoBookMeta);

        ItemStack sharpnessFiveBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta sharpnessFiveBookMeta = (EnchantmentStorageMeta) sharpnessFiveBook.getItemMeta();
        sharpnessFiveBookMeta.addStoredEnchant(Enchantment.DAMAGE_ALL, 5, true);
        // sharpnessFiveBook.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
        sharpnessFiveBook.setItemMeta(sharpnessFiveBookMeta);
        
        ItemStack sharpnessTenBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta sharpnessTenBookMeta = (EnchantmentStorageMeta) sharpnessTenBook.getItemMeta();
        sharpnessTenBookMeta.addStoredEnchant(Enchantment.DAMAGE_ALL, 10, true);
        // sharpnessTenBook.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
        sharpnessTenBook.setItemMeta(sharpnessTenBookMeta);

        ItemStack sharpnessMaxBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta sharpnessMaxBookMeta = (EnchantmentStorageMeta) sharpnessMaxBook.getItemMeta();
        sharpnessMaxBookMeta.addStoredEnchant(Enchantment.DAMAGE_ALL, 32767, true);
        // sharpnessMaxBook.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 32767);
        sharpnessMaxBook.setItemMeta(sharpnessMaxBookMeta);

        ItemStack protectionFiveBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta protectionFiveBookMeta = (EnchantmentStorageMeta) protectionFiveBook.getItemMeta();
        protectionFiveBookMeta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        // protectionFiveBook.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        protectionFiveBook.setItemMeta(protectionFiveBookMeta);
        
        ItemStack protectionTenBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta protectionTenBookMeta = (EnchantmentStorageMeta) protectionTenBook.getItemMeta();
        protectionTenBookMeta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        // protectionTenBook.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        protectionTenBook.setItemMeta(protectionTenBookMeta);

        ItemStack protectionMaxBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta protectionMaxBookMeta = (EnchantmentStorageMeta) protectionMaxBook.getItemMeta();
        protectionMaxBookMeta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 32767, true);
        // protectionMaxBook.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 32767);
        protectionMaxBook.setItemMeta(protectionMaxBookMeta);

        ItemStack unbreakingThreeBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta unbreakingThreeBookMeta = (EnchantmentStorageMeta) unbreakingThreeBook.getItemMeta();
        unbreakingThreeBookMeta.addStoredEnchant(Enchantment.DURABILITY, 3, true);
        // unbreakingThreeBook.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        unbreakingThreeBook.setItemMeta(unbreakingThreeBookMeta);
        
        ItemStack unbreakingFiveBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta unbreakingFiveBookMeta = (EnchantmentStorageMeta) unbreakingFiveBook.getItemMeta();
        unbreakingFiveBookMeta.addStoredEnchant(Enchantment.DURABILITY, 5, true);
        // unbreakingFiveBook.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        unbreakingFiveBook.setItemMeta(unbreakingFiveBookMeta);
        
        ItemStack unbreakingTenBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta unbreakingTenBookMeta = (EnchantmentStorageMeta) unbreakingTenBook.getItemMeta();
        unbreakingTenBookMeta.addStoredEnchant(Enchantment.DURABILITY, 10, true);
        // unbreakingTenBook.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        unbreakingTenBook.setItemMeta(unbreakingTenBookMeta);

        ItemStack unbreakingMaxBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta unbreakingMaxBookMeta = (EnchantmentStorageMeta) unbreakingMaxBook.getItemMeta();
        unbreakingMaxBookMeta.addStoredEnchant(Enchantment.DURABILITY, 32767, true);
        // unbreakingMaxBook.addUnsafeEnchantment(Enchantment.DURABILITY, 32767);
        unbreakingMaxBook.setItemMeta(unbreakingMaxBookMeta);
        
        ItemStack mendingFiveBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta mendingFiveBookMeta = (EnchantmentStorageMeta) mendingFiveBook.getItemMeta();
        mendingFiveBookMeta.addStoredEnchant(Enchantment.MENDING, 5, true);
        // mendingFiveBook.addUnsafeEnchantment(Enchantment.MENDING, 5);
        mendingFiveBook.setItemMeta(mendingFiveBookMeta);
        
        ItemStack mendingTenBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta mendingTenBookMeta = (EnchantmentStorageMeta) mendingTenBook.getItemMeta();
        mendingTenBookMeta.addStoredEnchant(Enchantment.MENDING, 10, true);
        // mendingTenBook.addUnsafeEnchantment(Enchantment.MENDING, 10);
        mendingTenBook.setItemMeta(mendingTenBookMeta);

        ItemStack mendingMaxBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta mendingMaxBookMeta = (EnchantmentStorageMeta) mendingMaxBook.getItemMeta();
        mendingMaxBookMeta.addStoredEnchant(Enchantment.MENDING, 32767, true);
        // mendingMaxBook.addUnsafeEnchantment(Enchantment.MENDING, 32767);
        mendingMaxBook.setItemMeta(mendingMaxBookMeta);
        
        opLootTableMaterials = new ItemStack[] {
            new ItemStack(Material.DIAMOND, 3),
            new ItemStack(Material.DIAMOND, 6),
            new ItemStack(Material.DIAMOND_BLOCK, 1),
            new ItemStack(Material.DIAMOND_BLOCK, 2),

            new ItemStack(Material.IRON_INGOT, 2),
            new ItemStack(Material.IRON_INGOT, 4),
            new ItemStack(Material.IRON_INGOT, 7),
            new ItemStack(Material.IRON_BLOCK, 1),
            new ItemStack(Material.IRON_BLOCK, 2),
            new ItemStack(Material.IRON_BLOCK, 3),

            new ItemStack(Material.GOLD_INGOT, 3),
            new ItemStack(Material.GOLD_INGOT, 5),
            new ItemStack(Material.GOLD_INGOT, 8),
            new ItemStack(Material.GOLD_BLOCK, 1),
            new ItemStack(Material.GOLD_BLOCK, 2),
            new ItemStack(Material.GOLD_BLOCK, 3),

            new ItemStack(Material.EMERALD, 4),
            new ItemStack(Material.EMERALD, 6),
            new ItemStack(Material.EMERALD, 8),
            new ItemStack(Material.EMERALD_BLOCK, 2),
            new ItemStack(Material.EMERALD_BLOCK, 3),
            new ItemStack(Material.EMERALD_BLOCK, 4),

            new ItemStack(Material.ANCIENT_DEBRIS, 3),
            new ItemStack(Material.ANCIENT_DEBRIS, 4),
            new ItemStack(Material.ANCIENT_DEBRIS, 5),
            new ItemStack(Material.NETHERITE_SCRAP, 3),
            new ItemStack(Material.NETHERITE_SCRAP, 4),
            new ItemStack(Material.NETHERITE_SCRAP, 5),
            new ItemStack(Material.NETHERITE_INGOT, 1),
            new ItemStack(Material.NETHERITE_INGOT, 2),
            new ItemStack(Material.NETHERITE_INGOT, 3),
            new ItemStack(Material.NETHERITE_BLOCK, 1)
        };

        opLootTableBooks = new ItemStack[] {
            opLootBook,

            telepathyBook,

            lifestealOneBook,
            lifestealTwoBook,
            lifestealThreeBook,
            lifestealFourBook,
            lifestealFiveBook,

            infectionOneBook,
            infectionTwoBook,

            witheringOneBook,
            witheringTwoBook,

            heavinessOneBook,
            heavinessTwoBook,
            
            sharpnessFiveBook,
            sharpnessTenBook,
            sharpnessMaxBook,

            protectionFiveBook,
            protectionTenBook,
            protectionMaxBook,

            unbreakingThreeBook,
            unbreakingFiveBook,
            unbreakingTenBook,
            unbreakingMaxBook,

            mendingFiveBook,
            mendingTenBook,
            mendingMaxBook
        };

        opLootTableTools = new ItemStack[] {
            netheriteHoe,
            netheriteSword,
            netheriteAxe,

            new ItemStack(Material.TOTEM_OF_UNDYING, 1),

            riptideTrident,
            new ItemStack(Material.TRIDENT, 1),

            regeneratingTotem
        };

        opLootTableArmor = new ItemStack[] {
            ironChestplate,
            ironBoots,

            unbreakableHelmet,
            unbreakableChestplate,
            unbreakableLeggings,
            unbreakableBoots,

            frozenBoots,

            speedsterBoots,

            diamondHelmet,
            diamondLeggings,

            netheriteHelmet,
            netheriteChestplate,
            netheriteLeggings,
            netheriteBoots,

            new ItemStack(Material.ELYTRA, 1)
        };

        opLootTableFood = new ItemStack[] {
            new ItemStack(Material.COOKED_BEEF, 8),
            new ItemStack(Material.COOKED_BEEF, 16),
            new ItemStack(Material.COOKED_BEEF, 32),

            new ItemStack(Material.COOKED_CHICKEN, 8),
            new ItemStack(Material.COOKED_CHICKEN, 16),
            new ItemStack(Material.COOKED_CHICKEN, 32),

            new ItemStack(Material.COOKED_COD, 8),
            new ItemStack(Material.COOKED_COD, 16),
            new ItemStack(Material.COOKED_COD, 32),

            new ItemStack(Material.COOKED_MUTTON, 8),
            new ItemStack(Material.COOKED_MUTTON, 16),
            new ItemStack(Material.COOKED_MUTTON, 32),

            new ItemStack(Material.COOKED_PORKCHOP, 8),
            new ItemStack(Material.COOKED_PORKCHOP, 16),
            new ItemStack(Material.COOKED_PORKCHOP, 32),

            new ItemStack(Material.COOKED_RABBIT, 8),
            new ItemStack(Material.COOKED_RABBIT, 16),
            new ItemStack(Material.COOKED_RABBIT, 32),

            new ItemStack(Material.COOKED_SALMON, 8),
            new ItemStack(Material.COOKED_SALMON, 16),
            new ItemStack(Material.COOKED_SALMON, 32),

            new ItemStack(Material.COOKIE, 8),
            new ItemStack(Material.COOKIE, 16),
            new ItemStack(Material.COOKIE, 32),

            new ItemStack(Material.PUMPKIN_PIE, 8),
            new ItemStack(Material.PUMPKIN_PIE, 16),
            new ItemStack(Material.PUMPKIN_PIE, 32),

            new ItemStack(Material.CAKE, 1),
            
            new ItemStack(Material.BREAD, 8),
            new ItemStack(Material.BREAD, 16),
            new ItemStack(Material.BREAD, 32),
            new ItemStack(Material.HAY_BLOCK, 2),
            new ItemStack(Material.HAY_BLOCK, 4),
            new ItemStack(Material.HAY_BLOCK, 8),
            new ItemStack(Material.HAY_BLOCK, 16),
            new ItemStack(Material.HAY_BLOCK, 32),
            
            new ItemStack(Material.GOLDEN_APPLE, 2),
            new ItemStack(Material.GOLDEN_APPLE, 4),
            new ItemStack(Material.GOLDEN_APPLE, 8),
            new ItemStack(Material.GOLDEN_APPLE, 16),
            new ItemStack(Material.GOLDEN_APPLE, 32),
            
            new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 2),
            new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 4),
            new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 8)
        };

        opLootTableMisc = new ItemStack[] {
            new ItemStack(Material.ENCHANTING_TABLE, 1),
            new ItemStack(Material.BREWING_STAND, 1),

            new ItemStack(Material.DEBUG_STICK, 1),

            new ItemStack(Material.EXPERIENCE_BOTTLE, 16),
            new ItemStack(Material.EXPERIENCE_BOTTLE, 32),
            new ItemStack(Material.EXPERIENCE_BOTTLE, 64),

            new ItemStack(Material.TNT, 8),
            new ItemStack(Material.TNT, 16),
            new ItemStack(Material.TNT, 32),
            new ItemStack(Material.TNT, 64)
        };

        opLootTableGear = joinItemStacks(opLootTableTools, opLootTableArmor);
        
        opLootTable = joinItemStacks(joinItemStacks(opLootTableMaterials, opLootTableBooks), joinItemStacks(opLootTableGear, joinItemStacks(opLootTableFood, opLootTableMisc)));
    }
}
