package items;

import armorsets.AetherArmor;
import dragonproject.AetherDragon;
import dragonproject.Fight;
import me.Bright.main.Main;
import me.Bright.main.Methods;
import net.minecraft.server.v1_15_R1.World;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.data.type.EndPortalFrame;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class Reg implements Listener {

    public HashMap<Player, ItemStack[]> items = new HashMap<Player, ItemStack[]>();
    private Plugin plugin = Main.getPlugin(Main.class);
    private Fight fightClass = new Fight();

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
                if (Methods.withSlimeBoots(player)) {
                    int distance = (int) player.getFallDistance() + 1;
                    player.setVelocity(Methods.initialvelocity(distance));
                    event.setCancelled(true);
                } else if (player.getInventory().getBoots().equals(AetherArmor.boots())) {
                    event.setCancelled(true);
                }
            }
            if (Methods.withAetherSet(player)) {
                event.setDamage(event.getDamage() * 0.1);
            }
        }
    }

    @EventHandler
    public void entitySpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof Phantom || event.getEntity() instanceof Bat) {
            event.setCancelled(true);
        }
    }

    @EventHandler()
    public void onRespawn(PlayerRespawnEvent event) {
        if (items.containsKey(event.getPlayer())) {
            event.getPlayer().getInventory().clear();
            for (ItemStack stack : items.get(event.getPlayer())) {
                if (stack != null) {
                    event.getPlayer().getInventory().addItem(stack);
                }
            }

            items.remove(event.getPlayer());
        }
    }

    @EventHandler()
    public void onDeath(PlayerDeathEvent event) {
        Inventory inv = event.getEntity().getInventory();
        if (inv.contains(Items.stickystick())) {
            inv.remove(Items.stickystick());
            ItemStack[] content = event.getEntity().getInventory().getContents();
            items.put(event.getEntity(), content);
            inv.clear();
            event.getEntity().sendMessage(ChatColor.RED + "You died, but your " + ChatColor.GREEN + "Sticky Stick"
                    + ChatColor.RED + " saved your inventory!");
        }
    }

    @EventHandler
    public void onFishingRodUse(PlayerFishEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand().equals(Items.grapple())) {
            Methods.setVelocity(player, player, 2);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand() != null) {
            ItemStack item = player.getInventory().getItemInMainHand();
            String handName = item.getItemMeta().getDisplayName();
            Collection<ItemStack> items = event.getBlock().getDrops(player.getInventory().getItemInMainHand());
            try {
                Location location = Methods.getLocofNearestBlock(player.getLocation(), Material.CHEST, 50);
                if (location != null) {
                    if (handName.equals(ChatColor.DARK_GRAY + "Ender Pickaxe") || handName.equals(ChatColor.DARK_GRAY + "Ender Axe") || handName.equals(ChatColor.DARK_GRAY + "Ender Shovel")) {
                        Chest chest = (Chest) player.getLocation().getWorld().getBlockAt(location).getState();
                        ArrayList<ItemStack> theitems = new ArrayList<>(items);
                        if (Methods.hasAvaliableSlot(chest.getBlockInventory())) {
                            for (ItemStack itemStack : theitems) {
                                chest.getBlockInventory().addItem(itemStack);
                            }
                            event.setDropItems(false);
                        } else {
                            event.setDropItems(true);
                            player.sendMessage(ChatColor.AQUA + "The nearest chest is " + ChatColor.RED + "full" + ChatColor.AQUA + "!");
                            player.sendMessage(ChatColor.AQUA + "The items are dropped on the " + ChatColor.GOLD + "ground" + ChatColor.AQUA + "!");
                        }
                    } else if (handName.equals(Items.oldperalpickaxe())) {
                        Chest chest = (Chest) player.getLocation().getWorld().getBlockAt(location).getState();
                        ArrayList<ItemStack> theitems = new ArrayList<>(items);
                        int random = (int) (Math.random() * 100);
                        if (Methods.hasAvaliableSlot(chest.getBlockInventory())) {
                            if (random <= 95) {
                                for (ItemStack itemStack : theitems) {
                                    chest.getBlockInventory().addItem(itemStack);
                                    chest.getBlockInventory().addItem(itemStack);
                                }
                                event.setDropItems(false);
                            } else {
                                for (ItemStack itemStack : theitems) {
                                    chest.getBlockInventory().addItem(itemStack);
                                    chest.getBlockInventory().addItem(itemStack);
                                    chest.getBlockInventory().addItem(itemStack);
                                    player.sendMessage(ChatColor.LIGHT_PURPLE + "Your legendary ender pickaxe tripled your drops!!!");
                                }
                                event.setDropItems(false);
                            }
                        } else {
                            event.setDropItems(true);
                            player.sendMessage(ChatColor.AQUA + "The nearest chest is " + ChatColor.RED + "full" + ChatColor.AQUA + "!");
                            player.sendMessage(ChatColor.AQUA + "The items are dropped on the " + ChatColor.GOLD + "ground" + ChatColor.AQUA + "!");
                        }
                    }
                }
            } catch (NoSuchElementException | NullPointerException exception) {

            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        if (block.getState() instanceof CreatureSpawner) {
            CreatureSpawner spawner = (CreatureSpawner) block.getState();
            spawner.setMaxSpawnDelay(10);
            spawner.setMinSpawnDelay(1);
            spawner.setSpawnCount(5);
        }

    }

    @EventHandler
    public void entityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        List<ItemStack> drops = event.getDrops();
        org.bukkit.World world = Bukkit.getWorld("spawn_the_end");
        org.bukkit.World world1 = Bukkit.getWorld("spawn");
        for (Player player : world.getPlayers()) {
            if (entity instanceof Slime && !(entity instanceof MagmaCube)) {
                if (drops != null) {
                    if (Methods.randomChance(1, 100)) {
                        drops.clear();
                        entity.getLocation().getWorld().dropItem(entity.getLocation(), Items.slimecore());
                    }
                }
            } else if (entity instanceof EnderDragon) {
                Fight fight = new Fight();
                fight.runnable.cancel();
                player.sendMessage(ChatColor.GOLD + "You have defeated the Aether Dragon!");
                Location alterLocation = new Location(world1, -540, 153, 296);
                new BukkitRunnable() {
                    int i = 0;

                    @Override
                    public void run() {
                        i++;
                        if (i >= 5) {
                            player.teleport(alterLocation);
                            this.cancel();
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You will be teleported in " + ChatColor.GOLD + (5 - i) + ChatColor.AQUA + " seconds.");
                        }
                    }
                }.runTaskTimer(plugin, 0, 20);

                for (Entity a : world.getEntities()) {
                    if (a instanceof Enderman) {
                        if (!a.isDead()) {
                            LivingEntity entity1 = (LivingEntity) a;
                            entity1.damage(100000);
                        }
                    }
                }
            } else if (entity instanceof Enderman) {
                if (Methods.randomChance(1, 1000)) {
                    drops.clear();
                    entity.getLocation().getWorld().dropItem(entity.getLocation(), Items.spawndrag());
                }
            }
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location from = event.getFrom();
        Location to = event.getTo();

        if (player.getInventory().getChestplate() != null) {
            if (player.getInventory().getChestplate().equals(AetherArmor.chestplate())) {
                if (player.getVelocity().getY() != 0) {
                    player.getInventory().setChestplate(AetherArmor.elytra());
                }
            }
        }
    }

    @EventHandler
    public void onShift(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        if (event.isSneaking()) {
            if (player.getInventory().getChestplate().equals(AetherArmor.elytra())) {
                Methods.setVelocity(player, 2);
            }
        }
    }

    @EventHandler
    public void ownInvClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        PlayerInventory inventory = player.getInventory();
        if (inventory.getHelmet() != null && inventory.getHelmet().equals(AetherArmor.helemt())) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100000, 1));
        } else {
            for (PotionEffect potionEffect : player.getActivePotionEffects()) {
                if (potionEffect.getType().equals(PotionEffectType.NIGHT_VISION)) {
                    player.removePotionEffect(potionEffect.getType());
                }
            }
        }
        if (inventory.getLeggings() != null && inventory.getHelmet().equals(AetherArmor.leggings())) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 1));
        } else {
            for (PotionEffect potionEffect : player.getActivePotionEffects()) {
                if (potionEffect.getType().equals(PotionEffectType.SPEED)) {
                    player.removePotionEffect(potionEffect.getType());
                }
            }
        }
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        Entity attacker = event.getDamager();
        Entity defender = event.getEntity();

        if (attacker instanceof Player) {
            Player player = (Player) attacker;
            if (player.getInventory().getItemInMainHand().equals(AetherArmor.sword())) {
                event.setDamage(5000);
            }
        }
    }

    public static String rarity(Tier tier) {
        switch (tier) {
            case COMMON:
                return "" + ChatColor.WHITE + ChatColor.BOLD + "COMMON";
            case UNCOMMON:
                return "" + ChatColor.GREEN + ChatColor.BOLD + "UNCOMMON";
            case RARE:
                return "" + ChatColor.GOLD + ChatColor.BOLD + "RARE";
            case EPIC:
                return "" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "EPIC";
            case LEGENDARY:
                return "" + ChatColor.GOLD + ChatColor.BOLD + "L" + ChatColor.YELLOW + ChatColor.BOLD + "E"
                        + ChatColor.GOLD + ChatColor.BOLD + "G" + ChatColor.YELLOW + ChatColor.BOLD + "E"
                        + ChatColor.GOLD + ChatColor.BOLD + "N" + ChatColor.YELLOW + ChatColor.BOLD + "D"
                        + ChatColor.GOLD + ChatColor.BOLD + "A" + ChatColor.YELLOW + ChatColor.BOLD + "R"
                        + ChatColor.GOLD + ChatColor.BOLD + "Y";
            case MYTHICAL:
                return "" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "M" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Y"
                        + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "T" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "H"
                        + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "I" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "C"
                        + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "A" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "L";
            case EVENT:
                return "" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "EVENT";
            case EXOTIC:
                return "" + ChatColor.AQUA + ChatColor.BOLD + "E" + ChatColor.DARK_AQUA + ChatColor.BOLD + "X"
                        + ChatColor.AQUA + ChatColor.BOLD + "O" + ChatColor.DARK_AQUA + ChatColor.BOLD + "T"
                        + ChatColor.AQUA + ChatColor.BOLD + "I" + ChatColor.DARK_AQUA + ChatColor.BOLD + "C";
            case SUPERSTITIOUS:
                return "" + ChatColor.DARK_RED + ChatColor.BOLD + "S" + ChatColor.BLACK + ChatColor.BOLD + "U"
                        + ChatColor.DARK_RED + ChatColor.BOLD + "P" + ChatColor.BLACK + ChatColor.BOLD + "E"
                        + ChatColor.DARK_RED + ChatColor.BOLD + "R" + ChatColor.BLACK + ChatColor.BOLD + "S"
                        + ChatColor.DARK_RED + ChatColor.BOLD + "T" + ChatColor.BLACK + ChatColor.BOLD + "I"
                        + ChatColor.DARK_RED + ChatColor.BOLD + "T" + ChatColor.BLACK + ChatColor.BOLD + "I"
                        + ChatColor.DARK_RED + ChatColor.BOLD + "O" + ChatColor.BLACK + ChatColor.BOLD + "U"
                        + ChatColor.DARK_RED + ChatColor.BOLD + "S";
            default:
                return null;
        }
    }
}