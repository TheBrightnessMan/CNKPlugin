package me.Bright.main;

import armorsets.AetherArmor;
import items.Items;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Methods {

    private static Plugin plugin = Main.getPlugin(Main.class);
    private static Server server = plugin.getServer();

    public static Location getLocofNearestBlock(Location location, Material block, int radius) {
        World world = location.getWorld();
        HashMap<Double, Location> distancetolocation = new HashMap<>();
        ArrayList<Double> blockdistance = new ArrayList<>();
        for (int y = -radius; y <= radius; y++) {
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    Block scan = world.getBlockAt((int) location.getX() + x, (int) location.getY() + y, (int) location.getZ() + z);
                    if (scan.getType().equals(block)) {
                        distancetolocation.put(location.distance(scan.getLocation()), scan.getLocation());
                        blockdistance.add(location.distance(scan.getLocation()));
                    }
                }
            }
        }
        if (distancetolocation != null) {
            return distancetolocation.get(Collections.min(blockdistance));
        }
        return null;
    }

    public static boolean fullDiscoSet(Player player) {
        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chestplate = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();

        if (helmet != null && chestplate != null && leggings != null && boots != null) {
            String helmetName = helmet.getItemMeta().getDisplayName();
            String chestplateName = chestplate.getItemMeta().getDisplayName();
            String leggingsName = leggings.getItemMeta().getDisplayName();
            String bootsName = boots.getItemMeta().getDisplayName();
            if (helmetName.equals(ChatColor.GOLD + "Disco Helmet") && chestplateName.equals(ChatColor.GOLD + "Disco Chestplate") && leggingsName.equals(ChatColor.GOLD + "Disco Leggings") && bootsName.equals(ChatColor.GOLD + "Disco Boots")) {
                return true;
            }
        }
        return false;
    }

    public static boolean withSlimeBoots(Player player) {

        ItemStack boots = player.getInventory().getBoots();
        if (boots != null) {
            if (boots.equals(Items.slimeboots())) {
                return true;
            }
        }
        return false;
    }

    public static boolean withAetherSet(Player player) {
        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chestplate = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();

        if (helmet != null && chestplate != null && leggings != null && boots != null) {
            if (helmet.equals(AetherArmor.helemt()) && leggings.equals(AetherArmor.leggings()) && boots.equals(AetherArmor.boots())) {
                if (chestplate.equals(AetherArmor.chestplate()) || chestplate.equals(AetherArmor.elytra())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void setVelocity(Player caster, Player target, double factor) {

        double pitch = ((caster.getLocation().getPitch() + 90) * Math.PI) / 180;
        double yaw = ((caster.getLocation().getYaw() + 90) * Math.PI) / 180;
        double x = Math.sin(pitch) * Math.cos(yaw);
        double y = Math.sin(pitch) * Math.sin(yaw);
        double z = Math.cos(pitch);
        Vector vector = new Vector(x, z, y);

        target.setVelocity(vector.multiply(factor));
    }

    public static void setVelocity(Player player, double factor) {

        double pitch = ((player.getLocation().getPitch() + 90) * Math.PI) / 180;
        double yaw = ((player.getLocation().getYaw() + 90) * Math.PI) / 180;
        double x = Math.sin(pitch) * Math.cos(yaw);
        double y = Math.sin(pitch) * Math.sin(yaw);
        double z = Math.cos(pitch);
        Vector vector = new Vector(x, z, y);

        player.setVelocity(vector.multiply(factor));
    }

    public static boolean hasAvaliableSlot(Inventory inventory) {
        for (ItemStack item : inventory.getContents()) {
            if (item == null) {
                return true;
            }
        }
        return false;
    }

    public static Vector initialvelocity(int fall) {
        int y = (int) Math.sqrt(fall * 18);
        Vector velocity = new Vector(0, y * 0.05, 0);
        return velocity;
    }

    public static void checkCraft(ItemStack result, CraftingInventory inventory, HashMap<Integer, ItemStack> ingredients) {
        ItemStack[] matrix = inventory.getMatrix();
        for (int i = 0; i < 9; i++) {
            if (ingredients.containsKey(i)) {
                if (matrix[i] == null || !matrix[i].equals(ingredients.get(i))) {
                    return;
                }
            } else {
                if (matrix[i] != null) {
                    return;
                }
            }
        }
        inventory.setResult(result);
    }

    public static boolean randomChance(int chance, int max) {
        int random = (int) (Math.random() * (max + 1));
        if (random <= chance) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean randomChance(int chance) {
        int random = (int) (Math.random() * 100);
        if (random <= chance) {
            return true;
        } else {
            return false;
        }
    }

}