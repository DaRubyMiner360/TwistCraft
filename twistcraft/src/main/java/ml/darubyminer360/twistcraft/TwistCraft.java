package ml.darubyminer360.twistcraft;

import ml.darubyminer360.twistcraft.commands.*;

import ml.darubyminer360.twistcraft.listeners.*;
import ml.darubyminer360.twistcraft.util.Config;
import ml.darubyminer360.twistcraft.util.CustomEnchants;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.attribute.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class TwistCraft extends JavaPlugin {
    public static TwistCraft instance;

    public ItemStack[] opLootTable;

    @Override
    public void onEnable() {
        instance = this;

        // Setup OP Loot Table
        setupOPLootTable();

        // Setup commands
        getCommand("twist").setExecutor(new TwistCommand());
        getCommand("craftablecommandblocks").setExecutor(new CraftableCommandBlocksCommand());
        getCommand("opmobs").setExecutor(new OPMobsCommand());
        getCommand("halfhearteating").setExecutor(new HalfHeartEatingCommand());
        getCommand("manhunt").setExecutor(new ManhuntCommand());
        getCommand("everywherelooked").setExecutor(new EverywhereLookedCommand());
        getCommand("deathswap").setExecutor(new DeathSwapCommand());
        getCommand("tntrunner").setExecutor(new TNTRunnerCommand());
        getCommand("fallingblocks").setExecutor(new FallingBlocksCommand());
        getCommand("fallingblocks").setExecutor(new FallingBlocksCommand());
        getCommand("sneakinvisibility").setExecutor(new SneakInvisibilityCommand());
        getCommand("allowedflight").setExecutor(new AllowedFlightCommand());

        // Setup Listeners
        getServer().getPluginManager().registerEvents(new CraftableCommandBlocksListener(), this);
        getServer().getPluginManager().registerEvents(new OPMobsListener(), this);
        getServer().getPluginManager().registerEvents(new HalfHeartEatingListener(), this);
        getServer().getPluginManager().registerEvents(new ManhuntListener(), this);
        getServer().getPluginManager().registerEvents(new EverywhereLookedListener(), this);
        getServer().getPluginManager().registerEvents(new SneakInvisibilityListener(), this);

        // Setup enchantments
        CustomEnchants.register();
        getCommand("addcustomenchant").setExecutor(new AddCustomEnchantCommand());
        getCommand("customenchants").setExecutor(new CustomEnchantsCommand());
        getServer().getPluginManager().registerEvents(new CustomEnchantsListener(), this);

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

    public void messageServer(String message, Player p) {
        if (Config.get().getBoolean("BroadcastMessages")) {
            p.getServer().broadcastMessage(message);
        }
        else {
            p.sendMessage(message);
        }
    }

    public void setupOPLootTable() {
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
        AttributeModifier speedsterBootsSpeedModifier = new AttributeModifier("player_speed", 32767, AttributeModifier.Operation.ADD_NUMBER);
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
        
        opLootTable = new ItemStack[] { new ItemStack(Material.DIAMOND, 6), new ItemStack(Material.DIAMOND_BLOCK, 3), new ItemStack(Material.IRON_INGOT, 6), new ItemStack(Material.IRON_BLOCK, 3), new ItemStack(Material.NETHERITE_INGOT, 1), netheriteHoe, netheriteSword, netheriteAxe, ironChestplate, ironBoots, unbreakableHelmet, unbreakableChestplate, unbreakableLeggings, unbreakableBoots, frozenBoots, speedsterBoots, diamondHelmet, diamondLeggings, netheriteHelmet, netheriteChestplate, netheriteLeggings, netheriteBoots };
    }
}
