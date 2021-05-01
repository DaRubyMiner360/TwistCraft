package ml.darubyminer360.twistcraft.listeners;

import ml.darubyminer360.twistcraft.commands.OPMobsCommand;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.entity.*;

public class OPMobsListener implements Listener {
    @EventHandler
    public void creatureSpawn(CreatureSpawnEvent event) {
        if (OPMobsCommand.enabled) {
            if (event.getEntityType() == EntityType.CREEPER) {
                Creeper creeper = (Creeper) event.getEntity();

                creeper.setPowered(true);

                ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET);
                helmet.addUnsafeEnchantment(Enchantment.THORNS, 5);
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5);
                helmet.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 5);
                helmet.addUnsafeEnchantment(Enchantment.WATER_WORKER, 5);
                helmet.addUnsafeEnchantment(Enchantment.OXYGEN, 5);
                helmet.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 5);

                ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
                chestplate.addUnsafeEnchantment(Enchantment.THORNS, 5);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5);
                chestplate.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 5);
                chestplate.addUnsafeEnchantment(Enchantment.WATER_WORKER, 5);
                chestplate.addUnsafeEnchantment(Enchantment.OXYGEN, 5);
                chestplate.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 5);

                ItemStack leggings = new ItemStack(Material.NETHERITE_LEGGINGS);
                leggings.addUnsafeEnchantment(Enchantment.THORNS, 5);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5);
                leggings.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 5);
                leggings.addUnsafeEnchantment(Enchantment.WATER_WORKER, 5);
                leggings.addUnsafeEnchantment(Enchantment.OXYGEN, 5);
                leggings.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 5);

                ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
                boots.addUnsafeEnchantment(Enchantment.THORNS, 5);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5);
                boots.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 5);
                boots.addUnsafeEnchantment(Enchantment.WATER_WORKER, 5);
                boots.addUnsafeEnchantment(Enchantment.OXYGEN, 5);
                boots.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 5);

                creeper.getEquipment().setHelmet(helmet);
                creeper.getEquipment().setChestplate(chestplate);
                creeper.getEquipment().setLeggings(leggings);
                creeper.getEquipment().setBoots(boots);

                ItemStack shield = new ItemStack(Material.SHIELD);
                boots.addUnsafeEnchantment(Enchantment.THORNS, 5);

                creeper.getEquipment().setItemInOffHand(shield);

                creeper.setHealth(30);
            }
            
            if (event.getEntityType() == EntityType.ZOMBIE) {
                Zombie zombie = (Zombie) event.getEntity();

                ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET);
                helmet.addUnsafeEnchantment(Enchantment.THORNS, 5);
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5);
                helmet.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 5);
                helmet.addUnsafeEnchantment(Enchantment.WATER_WORKER, 5);
                helmet.addUnsafeEnchantment(Enchantment.OXYGEN, 5);
                helmet.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 5);

                ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
                chestplate.addUnsafeEnchantment(Enchantment.THORNS, 5);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5);
                chestplate.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 5);
                chestplate.addUnsafeEnchantment(Enchantment.WATER_WORKER, 5);
                chestplate.addUnsafeEnchantment(Enchantment.OXYGEN, 5);
                chestplate.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 5);

                ItemStack leggings = new ItemStack(Material.NETHERITE_LEGGINGS);
                leggings.addUnsafeEnchantment(Enchantment.THORNS, 5);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5);
                leggings.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 5);
                leggings.addUnsafeEnchantment(Enchantment.WATER_WORKER, 5);
                leggings.addUnsafeEnchantment(Enchantment.OXYGEN, 5);
                leggings.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 5);

                ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
                boots.addUnsafeEnchantment(Enchantment.THORNS, 5);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5);
                boots.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 5);
                boots.addUnsafeEnchantment(Enchantment.WATER_WORKER, 5);
                boots.addUnsafeEnchantment(Enchantment.OXYGEN, 5);
                boots.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 5);

                zombie.getEquipment().setHelmet(helmet);
                zombie.getEquipment().setChestplate(chestplate);
                zombie.getEquipment().setLeggings(leggings);
                zombie.getEquipment().setBoots(boots);

                ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
                boots.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
                boots.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 5);
                boots.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 5);
                boots.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 5);
                boots.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
                boots.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);

                ItemStack shield = new ItemStack(Material.SHIELD);
                boots.addUnsafeEnchantment(Enchantment.THORNS, 5);

                zombie.getEquipment().setItemInMainHand(sword);
                zombie.getEquipment().setItemInOffHand(shield);

                zombie.setHealth(30);
            }
            
            if (event.getEntityType() == EntityType.SKELETON) {
                Skeleton skeleton = (Skeleton) event.getEntity();

                ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET);
                helmet.addUnsafeEnchantment(Enchantment.THORNS, 5);
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5);
                helmet.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 5);
                helmet.addUnsafeEnchantment(Enchantment.WATER_WORKER, 5);
                helmet.addUnsafeEnchantment(Enchantment.OXYGEN, 5);
                helmet.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 5);

                ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
                chestplate.addUnsafeEnchantment(Enchantment.THORNS, 5);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5);
                chestplate.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 5);
                chestplate.addUnsafeEnchantment(Enchantment.WATER_WORKER, 5);
                chestplate.addUnsafeEnchantment(Enchantment.OXYGEN, 5);
                chestplate.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 5);

                ItemStack leggings = new ItemStack(Material.NETHERITE_LEGGINGS);
                leggings.addUnsafeEnchantment(Enchantment.THORNS, 5);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5);
                leggings.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 5);
                leggings.addUnsafeEnchantment(Enchantment.WATER_WORKER, 5);
                leggings.addUnsafeEnchantment(Enchantment.OXYGEN, 5);
                leggings.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 5);

                ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
                boots.addUnsafeEnchantment(Enchantment.THORNS, 5);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5);
                boots.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 5);
                boots.addUnsafeEnchantment(Enchantment.WATER_WORKER, 5);
                boots.addUnsafeEnchantment(Enchantment.OXYGEN, 5);
                boots.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 5);

                skeleton.getEquipment().setHelmet(helmet);
                skeleton.getEquipment().setChestplate(chestplate);
                skeleton.getEquipment().setLeggings(leggings);
                skeleton.getEquipment().setBoots(boots);

                ItemStack bow = new ItemStack(Material.BOW);
                bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
                bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
                bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);

                ItemStack shield = new ItemStack(Material.SHIELD);
                boots.addUnsafeEnchantment(Enchantment.THORNS, 5);

                skeleton.getEquipment().setItemInMainHand(bow);
                skeleton.getEquipment().setItemInOffHand(shield);

                skeleton.setHealth(30);
            }
        }
    }
}
