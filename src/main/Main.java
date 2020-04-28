package me.Bright.main;

import armorsets.AetherArmor;
import armorsets.DiscoArmor;
import command.Commands;
import command.TabComplete;
import dragonproject.Fight;
import items.Reg;
import items.Tier;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.Random;

public class Main extends JavaPlugin {

    public void onEnable() {
        regEvent();
        regCommands();
        reg();
    }

    private void regEvent() {
        Reg itemReg = new Reg();
        Recipes recipes = new Recipes();
        Fight fight = new Fight();

        getServer().getPluginManager().registerEvents(itemReg, this);
        getServer().getPluginManager().registerEvents(recipes, this);
        getServer().getPluginManager().registerEvents(fight, this);

    }

    private void regCommands() {
        Commands commands = new Commands();
        TabComplete tabComplete = new TabComplete();

        getCommand("getitem").setExecutor(commands);
        getCommand("getitem").setTabCompleter(tabComplete);

        getCommand("push").setExecutor(commands);
    }

    private void reg() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            private Random r = new Random();

            public void run() {
                Color c = Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255));
                try {
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        if (Methods.fullDiscoSet(p)) {
                            p.getInventory().setHelmet(DiscoArmor.discohel(c));
                            p.getInventory().setChestplate(DiscoArmor.discochest(c));
                            p.getInventory().setLeggings(DiscoArmor.discoleg(c));
                            p.getInventory().setBoots(DiscoArmor.discoboots(c));
                        } else if (p.getInventory().getChestplate() != null) {
                            if (p.getInventory().getChestplate().getType().equals(Material.ELYTRA)) {
                                if (p.getInventory().getChestplate().getItemMeta().getLore().contains(Reg.rarity(Tier.LEGENDARY))) {
                                    if (p.getVelocity().getX() == 0 || p.getVelocity().getZ() == 0) {
                                        p.getInventory().setChestplate(AetherArmor.chestplate());
                                    }
                                }
                            }
                        }
                    }
                } catch (NullPointerException exception) {
                    
                }
            }
        }, 0, 10);
    }
}
