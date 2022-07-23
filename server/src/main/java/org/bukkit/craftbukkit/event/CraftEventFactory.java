package org.bukkit.craftbukkit.event;

import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityCow;
import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityGiantZombie;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPig;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.EntitySlime;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.Item;
import net.minecraft.src.World;
import net.minecraft.src.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Type;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import ru.vladthemountain.lilybukkit.LBWorld;
import ru.vladthemountain.lilybukkit.LilyBukkit;
import ru.vladthemountain.lilybukkit.block.LBBlock;
import ru.vladthemountain.lilybukkit.entity.LBEntity;
import ru.vladthemountain.lilybukkit.entity.LBLivingEntity;
import ru.vladthemountain.lilybukkit.entity.LBPlayer;

/**
 * CraftEventFactory used by CraftBukkit.
 * Code edited to suit LiLyBukkit.
 */
public class CraftEventFactory {
    private static boolean canBuild(LBWorld world, Player player, int x, int z) {
        int spawnSize = Bukkit.getServer().getSpawnRadius();

        if (spawnSize <= 0) return true;
        if (player.isOp()) return true;

        Location spawnLocation = world.getSpawnLocation();
        return Math.max(Math.abs(x - spawnLocation.getBlockX()), Math.abs(z - spawnLocation.getBlockZ())) > spawnSize;
    }

    /**
     * Block place methods
     */
    public static BlockPlaceEvent callBlockPlaceEvent(World world, EntityPlayerMP who, BlockState replacedBlockState, int clickedX, int clickedY, int clickedZ, int type) {
        return callBlockPlaceEvent(world, who, replacedBlockState, clickedX, clickedY, clickedZ, net.minecraft.src.Block.blocksList[type]);
    }

    public static BlockPlaceEvent callBlockPlaceEvent(World world, EntityPlayerMP who, BlockState replacedBlockState, int clickedX, int clickedY, int clickedZ, net.minecraft.src.Block block) {
        return callBlockPlaceEvent(world, who, replacedBlockState, clickedX, clickedY, clickedZ, new net.minecraft.src.ItemStack(block));
    }

    public static BlockPlaceEvent callBlockPlaceEvent(World world, EntityPlayerMP who, BlockState replacedBlockState, int clickedX, int clickedY, int clickedZ, net.minecraft.src.ItemStack itemstack) {
        LBWorld craftWorld = (LBWorld) Bukkit.getServer().getWorld(world.levelName);
        LilyBukkit craftServer = (LilyBukkit) Bukkit.getServer();

        Player player = who == null ? null : craftServer.getPlayer(who.username);
        ItemStack itemInHand = new ItemStack(itemstack.itemID, itemstack.stackSize, (short) itemstack.itemDmg);

        Block blockClicked = craftWorld.getBlockAt(clickedX, clickedY, clickedZ);
        Block placedBlock = replacedBlockState.getBlock();

        boolean canBuild = canBuild(craftWorld, player, placedBlock.getX(), placedBlock.getZ());

        BlockPlaceEvent event = new BlockPlaceEvent(placedBlock, replacedBlockState, blockClicked, itemInHand, player, canBuild);
        craftServer.getPluginManager().callEvent(event);

        return event;
    }

    /**
     * Bucket methods
     */
    public static PlayerBucketEmptyEvent callPlayerBucketEmptyEvent(EntityPlayerMP who, int clickedX, int clickedY, int clickedZ, int clickedFace, net.minecraft.src.ItemStack itemInHand) {
        return (PlayerBucketEmptyEvent) getPlayerBucketEvent(Type.PLAYER_BUCKET_EMPTY, who, clickedX, clickedY, clickedZ, clickedFace, itemInHand, Item.bucketEmpty);
    }

    public static PlayerBucketFillEvent callPlayerBucketFillEvent(EntityPlayerMP who, int clickedX, int clickedY, int clickedZ, int clickedFace, net.minecraft.src.ItemStack itemInHand, net.minecraft.src.Item bucket) {
        return (PlayerBucketFillEvent) getPlayerBucketEvent(Type.PLAYER_BUCKET_FILL, who, clickedX, clickedY, clickedZ, clickedFace, itemInHand, bucket);
    }

    private static PlayerEvent getPlayerBucketEvent(Type type, EntityPlayerMP who, int clickedX, int clickedY, int clickedZ, int clickedFace, net.minecraft.src.ItemStack itemStack, net.minecraft.src.Item item) {
        Player player = who == null ? null : new LBPlayer((LBWorld) Bukkit.getServer().getWorld(who.mcServer.worldMngr.levelName), who);
        net.minecraft.src.ItemStack vanillaItemInHand = new net.minecraft.src.ItemStack(item);
        ItemStack itemInHand = new ItemStack(vanillaItemInHand.itemID, vanillaItemInHand.stackSize, (short) vanillaItemInHand.itemDmg);
        Material bucket = Material.getMaterial(itemStack.itemID);

        LBWorld world = (LBWorld) player.getWorld();
        LilyBukkit server = (LilyBukkit) player.getServer();

        Block blockClicked = world.getBlockAt(clickedX, clickedY, clickedZ);
        BlockFace blockFace = LBBlock.convertNotchToBlockFace(clickedFace);

        PlayerEvent event = null;
        if (type == Type.PLAYER_BUCKET_EMPTY) {
            event = new PlayerBucketEmptyEvent(player, blockClicked, blockFace, bucket, itemInHand);
            ((PlayerBucketEmptyEvent) event).setCancelled(!canBuild(world, player, clickedX, clickedZ));
        } else if (type == Type.PLAYER_BUCKET_FILL) {
            event = new PlayerBucketFillEvent(player, blockClicked, blockFace, bucket, itemInHand);
            ((PlayerBucketFillEvent) event).setCancelled(!canBuild(world, player, clickedX, clickedZ));
        }

        server.getPluginManager().callEvent(event);

        return event;
    }

    /**
     * Player Interact event
     */

    public static PlayerInteractEvent callPlayerInteractEvent(EntityPlayerMP who, Action action, net.minecraft.src.ItemStack itemstack) {
        if (action != Action.LEFT_CLICK_AIR && action != Action.RIGHT_CLICK_AIR) {
            throw new IllegalArgumentException();
        }
        return callPlayerInteractEvent(who, action, 0, 255, 0, 0, itemstack);
    }

    public static PlayerInteractEvent callPlayerInteractEvent(EntityPlayerMP who, Action action, int clickedX, int clickedY, int clickedZ, int clickedFace, net.minecraft.src.ItemStack itemStack) {
        Player player = who == null ? null : new LBPlayer((LBWorld) Bukkit.getServer().getWorld(who.mcServer.worldMngr.levelName), who);
        ItemStack itemInHand = itemStack == null ? new ItemStack(0, 0, (short) 0) : new ItemStack(itemStack.itemID, itemStack.stackSize, (short) itemStack.itemDmg);

        LBWorld craftWorld = (LBWorld) player.getWorld();
        LilyBukkit server = (LilyBukkit) player.getServer();

        Block blockClicked = craftWorld.getBlockAt(clickedX, clickedY, clickedZ);
        BlockFace blockFace = LBBlock.convertNotchToBlockFace(clickedFace);

        if (clickedY == 255) {
            blockClicked = null;
            switch (action) {
                case LEFT_CLICK_BLOCK:
                    action = Action.LEFT_CLICK_AIR;
                    break;
                case RIGHT_CLICK_BLOCK:
                    action = Action.RIGHT_CLICK_AIR;
                    break;
            }
        }

        if (itemInHand.getType() == Material.AIR || itemInHand.getAmount() == 0) {
            itemInHand = null;
        }

        PlayerInteractEvent event = new PlayerInteractEvent(player, action, itemInHand, blockClicked, blockFace);
        server.getPluginManager().callEvent(event);

        return event;
    }

    /**
     * BlockDamageEvent
     */
    public static BlockDamageEvent callBlockDamageEvent(EntityPlayerMP who, int x, int y, int z, net.minecraft.src.ItemStack itemStack, boolean instaBreak) {
        Player player = who == null ? null : new LBPlayer((LBWorld) Bukkit.getServer().getWorld(who.mcServer.worldMngr.levelName), who);
        ItemStack itemInHand = new ItemStack(itemStack.itemID, itemStack.stackSize, (short) itemStack.itemDmg);

        LBWorld world = (LBWorld) player.getWorld();
        LilyBukkit server = (LilyBukkit) player.getServer();

        Block blockClicked = world.getBlockAt(x, y, z);

        BlockDamageEvent event = new BlockDamageEvent(player, blockClicked, itemInHand, instaBreak);
        server.getPluginManager().callEvent(event);

        return event;
    }

    /**
     * CreatureSpawnEvent
     */
    public static CreatureSpawnEvent callCreatureSpawnEvent(WorldServer world, EntityLiving entityliving, SpawnReason spawnReason) {
        LivingEntity entity = new LBLivingEntity((LBWorld) Bukkit.getServer().getWorld(world.levelName), entityliving);
        LilyBukkit server = (LilyBukkit) entity.getServer();

        CreatureType type = null;

        if (entityliving instanceof EntityChicken) {
            type = CreatureType.CHICKEN;
        } else if (entityliving instanceof EntityCow) {
            type = CreatureType.COW;
        } else if (entityliving instanceof EntityCreeper) {
            type = CreatureType.CREEPER;
        } else if (entityliving instanceof EntityGiantZombie) {
            type = CreatureType.GIANT;
        } else if (entityliving instanceof EntityPig) {
            type = CreatureType.PIG;
        } else if (entityliving instanceof EntitySheep) {
            type = CreatureType.SHEEP;
        } else if (entityliving instanceof EntitySkeleton) {
            type = CreatureType.SKELETON;
        } else if (entityliving instanceof EntitySlime) {
            type = CreatureType.SLIME;
        } else if (entityliving instanceof EntitySpider) {
            type = CreatureType.SPIDER;
        } else if (entityliving instanceof EntityZombie) {
            type = CreatureType.ZOMBIE;
            // Supertype of many, last!
        } else if (entityliving instanceof EntityMob) {
            type = CreatureType.MONSTER;
        }

        CreatureSpawnEvent event = new CreatureSpawnEvent(entity, type, entity.getLocation(), spawnReason);
        server.getPluginManager().callEvent(event);
        return event;
    }

    /**
     * ItemSpawnEvent
     */
    public static ItemSpawnEvent callItemSpawnEvent(WorldServer world, EntityItem entityitem) {
        Entity entity = new LBEntity((LBWorld) Bukkit.getServer().getWorld(world.levelName), entityitem);
        LilyBukkit server = (LilyBukkit) entity.getServer();

        ItemSpawnEvent event = new ItemSpawnEvent(entity, entity.getLocation());

        server.getPluginManager().callEvent(event);
        return event;
    }

    /**
     * BlockFadeEvent
     */
    public static BlockFadeEvent callBlockFadeEvent(Block block, int type) {
        BlockState state = block.getState();
        state.setTypeId(type);

        BlockFadeEvent event = new BlockFadeEvent(block, state);
        Bukkit.getServer().getPluginManager().callEvent(event);
        return event;
    }
}
