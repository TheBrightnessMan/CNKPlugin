package dragonproject;

import items.Items;
import me.Bright.main.Main;
import me.Bright.main.Methods;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.EndPortalFrame;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Random;

public class Fight implements Listener {

    private Plugin plugin = Main.getPlugin(Main.class);
    private org.bukkit.World world1 = Bukkit.getWorld("spawn");
    private org.bukkit.World world2 = Bukkit.getWorld("spawn_the_end");

    public static BukkitTask runnable;

    @EventHandler
    public void placeEye(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && player.getInventory().getItemInMainHand().equals(Items.spawndrag())) {
            Block block = event.getClickedBlock();
            Location blockLocation = block.getLocation();
            Location alterLocation = new Location(world1, -540, 153, 296);
            if (block.getType().equals(Material.END_PORTAL_FRAME)) {
                if (blockLocation.equals(alterLocation)) {
                    EndPortalFrame frame = (EndPortalFrame) block.getBlockData();
                    if (!frame.hasEye()) {
                        player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                        new BukkitRunnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                i++;
                                if (i >= 5) {

                                    Location fight = new Location(world2, -27, 61, 6, 270, 0);
                                    player.teleport(fight);

                                    net.minecraft.server.v1_15_R1.World nmsWorld = ((CraftWorld) world2).getHandle();
                                    AetherDragon dragon = new AetherDragon(nmsWorld);
                                    nmsWorld.addEntity(dragon);
                                    dragon.setPosition(28, 98, -2);
                                    start(player);
                                    this.cancel();
                                } else {
                                    player.sendMessage(ChatColor.AQUA + "You will be teleported in " + ChatColor.GOLD + (5 - i) + ChatColor.AQUA + " seconds.");
                                }
                            }
                        }.runTaskTimer(plugin, 0, 20);
                    }
                }
            }
        }
    } // To Do: Add a location of the alter and arena

    public void start(Player player) {
        DragonMethods dragonMethods = new DragonMethods();
        net.minecraft.server.v1_15_R1.World nmsWorld = ((CraftWorld) world2).getHandle();
        AetherDragon dragon = new AetherDragon(nmsWorld);
        nmsWorld.addEntity(dragon);

        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                dragon.setNoAI(false);
                if (Methods.randomChance(1, 2)) {
                    player.getWorld().strikeLightning(player.getLocation());
                } else {
                    World world = player.getWorld();
                    double x = player.getLocation().getX();
                    double y = player.getLocation().getY();
                    double z = player.getLocation().getZ();

                    dragonMethods.spawnEnderman(player, x + 3, y, z + 3);
                    dragonMethods.spawnEnderman(player, x + 3, y, z - 3);
                    dragonMethods.spawnEnderman(player, x - 3, y, z + 3);
                    dragonMethods.spawnEnderman(player, x - 3, y, z - 3);
                    player.sendMessage("" + ChatColor.WHITE + ChatColor.BOLD + "Aether Dragon" + ChatColor.AQUA + ": Rise, my loyal servants");
                }
            }
        }.runTaskTimer(plugin, 0, 20 * 5);
    }
}