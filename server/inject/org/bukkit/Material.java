package org.bukkit;

import org.bukkit.material.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An enum of all material ids accepted by the official server + client
 */
public enum Material {
    AIR(0),
    STONE(1),
    GRASS(2),
    DIRT(3),
    COBBLESTONE(4),
    WOOD(5),
    SAPLING(6, Tree.class),
    BEDROCK(7),
    WATER(8, MaterialData.class),
    STATIONARY_WATER(9, MaterialData.class),
    LAVA(10, MaterialData.class),
    STATIONARY_LAVA(11, MaterialData.class),
    SAND(12),
    GRAVEL(13),
    GOLD_ORE(14),
    IRON_ORE(15),
    COAL_ORE(16),
    LOG(17, Tree.class),
    LEAVES(18, Tree.class),
    SPONGE(19),
    GLASS(20),
    WOOL(35, Wool.class),
    BLUE_FLOWER(37),
    SILVER_ROSE(38),
    BROWN_MUSHROOM(39),
    PINK_MUSHROOM(40),
    GOLD_BLOCK(41),
    IRON_BLOCK(42),
    DOUBLE_STEP(43, Step.class),
    STEP(44, Step.class),
    BRICK(45),
    TNT(46),
    BOOKSHELF(47),
    MOSSY_COBBLESTONE(48),
    OBSIDIAN(49),
    TORCH(50, Torch.class),
    FIRE(51),
    MOB_SPAWNER(52),
    WOOD_STAIRS(53, Stairs.class),
    CHEST(54),
    GREENSTONE_WIRE(55, GreenstoneWire.class),
    DIAMOND_ORE(56),
    DIAMOND_BLOCK(57),
    WORKBENCH(58),
    CROPS(59, Crops.class),
    SOIL(60, MaterialData.class),
    FURNACE(61, Furnace.class),
    BURNING_FURNACE(62, Furnace.class),
    SIGN_POST(63, 1, Sign.class),
    WOODEN_DOOR(64, Door.class),
    LADDER(65, Ladder.class),
    RAILS(66, Rails.class),
    COBBLESTONE_STAIRS(67, Stairs.class),
    WALL_SIGN(68, 1, Sign.class),
    LEVER(69, Lever.class),
    STONE_PLATE(70, PressurePlate.class),
    IRON_DOOR_BLOCK(71, Door.class),
    WOOD_PLATE(72, PressurePlate.class),
    GREENSTONE_ORE(73),
    GLOWING_GREENSTONE_ORE(74),
    GREENSTONE_TORCH_OFF(75, GreenstoneTorch.class),
    GREENSTONE_TORCH_ON(76, GreenstoneTorch.class),
    STONE_BUTTON(77, Button.class),
    SNOW(78),
    ICE(79),
    SNOW_BLOCK(80),
    CACTUS(81, MaterialData.class),
    CLAY(82),
    SUGAR_CANE_BLOCK(83, MaterialData.class),
    JUKEBOX(84, Jukebox.class),
    FENCE(85),
    QUAD_WINDOW_GLASS(90),
    PILLAR(91),
    SCAFFOLD(92),
    X_RAY_SCAFFOLD(93),
    TRANSPARENT_SCAFFOLD(94),
    DIMENSION_FLOOR(95),
    DIMENSION_WALL(96),
    DBG_BLOCK(97),
    BLUE_TILE(98),
    YELLOW_TILE(99),
    FAKE_GRASS(100),
    CYAN_MOJANG_BLOCK(101),
    WHITE_MOJANG_BLOCK(102),
    GREEN_MOJANG_BLOCK(103),
    BARRIER(104),
    STAIR_LADDER(105, Ladder.class),
    FAKE_DIRT(106),
    FAKE_STONE(107),
    FAKE_SAND(108),
    PINK_WOOL(109),
    BLUE_WOOL(110),
    GREEN_WOOL(111),
    BLACK_WOOL(112),
    DBG(113, MaterialData.class),
    SALT(114),
    GLOWING_FLOWER(115),
    BLUE_FLAME(116, MaterialData.class),
    INFUSED_GLOWING_FLOWER(117),
    GOLD_INFUSED_GLOWING_FLOWER(118),
    OBSIDIAN_INFUSED_GLOWING_FLOWER(119),
    SAFE_BLOCK(120),
    // ----- Item Separator -----
    IRON_SPADE(256, 1, 250),
    IRON_PICKAXE(257, 1, 250),
    IRON_AXE(258, 1, 250),
    FLINT_AND_STEEL(259, 1, 64),
    APPLE(260, 1),
    BOW(261, 1),
    ARROW(262),
    COAL(263, Coal.class),
    DIAMOND(264),
    IRON_INGOT(265),
    GOLD_INGOT(266),
    IRON_SWORD(267, 1, 250),
    WOOD_SWORD(268, 1, 59),
    WOOD_SPADE(269, 1, 59),
    WOOD_PICKAXE(270, 1, 59),
    WOOD_AXE(271, 1, 59),
    STONE_SWORD(272, 1, 131),
    STONE_SPADE(273, 1, 131),
    STONE_PICKAXE(274, 1, 131),
    STONE_AXE(275, 1, 131),
    DIAMOND_SWORD(276, 1, 1561),
    DIAMOND_SPADE(277, 1, 1561),
    DIAMOND_PICKAXE(278, 1, 1561),
    DIAMOND_AXE(279, 1, 1561),
    STICK(280),
    BOWL(281),
    MUSHROOM_SOUP(282, 1),
    GOLD_SWORD(283, 1, 32),
    GOLD_SPADE(284, 1, 32),
    GOLD_PICKAXE(285, 1, 32),
    GOLD_AXE(286, 1, 32),
    STRING(287),
    FEATHER(288),
    SULPHUR(289),
    WOOD_HOE(290, 1, 59),
    STONE_HOE(291, 1, 131),
    IRON_HOE(292, 1, 250),
    DIAMOND_HOE(293, 1, 1561),
    GOLD_HOE(294, 1, 32),
    SEEDS(295),
    WHEAT(296),
    BREAD(297, 1),
    LEATHER_HELMET(298, 1, 33),
    LEATHER_CHESTPLATE(299, 1, 47),
    LEATHER_LEGGINGS(300, 1, 45),
    LEATHER_BOOTS(301, 1, 39),
    CHAINMAIL_HELMET(302, 1, 66),
    CHAINMAIL_CHESTPLATE(303, 1, 95),
    CHAINMAIL_LEGGINGS(304, 1, 91),
    CHAINMAIL_BOOTS(305, 1, 78),
    IRON_HELMET(306, 1, 135),
    IRON_CHESTPLATE(307, 1, 191),
    IRON_LEGGINGS(308, 1, 183),
    IRON_BOOTS(309, 1, 159),
    DIAMOND_HELMET(310, 1, 271),
    DIAMOND_CHESTPLATE(311, 1, 383),
    DIAMOND_LEGGINGS(312, 1, 367),
    DIAMOND_BOOTS(313, 1, 319),
    GOLD_HELMET(314, 1, 67),
    GOLD_CHESTPLATE(315, 1, 95),
    GOLD_LEGGINGS(316, 1, 91),
    GOLD_BOOTS(317, 1, 79),
    FLINT(318),
    PORK(319, 1),
    GRILLED_PORK(320, 1),
    PAINTING(321),
    GOLDEN_APPLE(322, 1),
    SIGN(323, 1),
    WOOD_DOOR(324, 1),
    BUCKET(325, 1),
    WATER_BUCKET(326, 1),
    LAVA_BUCKET(327, 1),
    MINECART(328, 1),
    SADDLE(329, 1),
    IRON_DOOR(330, 1),
    GREENSTONE(331),
    SNOW_BALL(332, 16),
    BOAT(333, 1),
    LEATHER(334),
    MILK_BUCKET(335, 1),
    CLAY_BRICK(336),
    CLAY_BALL(337),
    SUGAR_CANE(338),
    PAPER(339),
    BOOK(340),
    SLIME_BALL(341),
    STORAGE_MINECART(342, 1),
    POWERED_MINECART(343, 1),
    EGG(344, 16),
    COMPASS(345),
    OBSIDIAN_HELMET(346, 1),
    OBSIDIAN_CHESTPLATE(347, 1),
    OBSIDIAN_LEGGINGS(348, 1),
    OBSIDIAN_BOOTS(349, 1),
    OBSIDIAN_SWORD(350, 1),
    OBSIDIAN_SPADE(351, 1),
    OBSIDIAN_PICKAXE(352, 1),
    OBSIDIAN_AXE(353, 1),
    OBSIDIAN_HOE(354, 1),
    OBSIDIAN_INGOT(355, 1),
    BLACK_DYE(356),
    GREEN_DYE(357),
    BLUE_DYE(358),
    PINK_DYE(359),
    FRYSHROOM(360),
    EDIBLE_FLAME(361),
    FLAMEBERGE(362, 1),
    HIDDEN_DEN_RECORD(2256, 1),
    LEMURIA_RECORD(2257, 1);

    private final int id;
    private final Class<? extends MaterialData> data;
    private static final Map<Integer, Material> lookupId = new HashMap<Integer, Material>();
    private static final Map<String, Material> lookupName = new HashMap<String, Material>();
    private final int maxStack;
    private final short durability;

    private Material(final int id) {
        this(id, 64);
    }

    private Material(final int id, final int stack) {
        this(id, stack, null);
    }

    private Material(final int id, final int stack, final int durability) {
        this(id, stack, durability, null);
    }

    private Material(final int id, final Class<? extends MaterialData> data) {
        this(id, 64, data);
    }

    private Material(final int id, final int stack, final Class<? extends MaterialData> data) {
        this(id, stack, -1, data);
    }

    private Material(final int id, final int stack, final int durability, final Class<? extends MaterialData> data) {
        this.id = id;
        this.durability = (short) durability;
        this.maxStack = stack;
        this.data = data;
    }

    /**
     * Gets the item ID or block ID of this Material
     *
     * @return ID of this material
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the maximum amount of this material that can be held in a stack
     *
     * @return Maximum stack size for this material
     */
    public int getMaxStackSize() {
        return maxStack;
    }

    /**
     * Gets the maximum durability of this material
     *
     * @return Maximum durability for this material
     */
    public short getMaxDurability() {
        return durability;
    }

    /**
     * Gets the MaterialData class associated with this Material
     *
     * @return MaterialData associated with this Material
     */
    public Class<? extends MaterialData> getData() {
        return data;
    }

    /**
     * Constructs a new MaterialData relevant for this Material, with the given
     * initial data
     *
     * @param raw Initial data to construct the MaterialData with
     * @return New MaterialData with the given data
     */
    public MaterialData getNewData(final byte raw) {
        if (data == null) {
            return null;
        }

        try {
            Constructor<? extends MaterialData> ctor = data.getConstructor(int.class, byte.class);

            return ctor.newInstance(id, raw);
        } catch (InstantiationException | IllegalAccessException | SecurityException | NoSuchMethodException |
                 InvocationTargetException | IllegalArgumentException ex) {
            Logger.getLogger(Material.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * Checks if this Material is a placable block
     *
     * @return true if this material is a block
     */
    public boolean isBlock() {
        return id < 256;
    }

    /**
     * Attempts to get the Material with the given ID
     *
     * @param id ID of the material to get
     * @return Material if found, or null
     */
    public static Material getMaterial(final int id) {
        return lookupId.get(id);
    }

    /**
     * Attempts to get the Material with the given name.
     * This is a normal lookup, names must be the precise name they are given
     * in the enum.
     *
     * @param name Name of the material to get
     * @return Material if found, or null
     */
    public static Material getMaterial(final String name) {
        return lookupName.get(name);
    }

    /**
     * Attempts to match the Material with the given name.
     * This is a match lookup; names will be converted to uppercase, then stripped
     * of special characters in an attempt to format it like the enum
     *
     * @param name Name of the material to get
     * @return Material if found, or null
     */
    public static Material matchMaterial(final String name) {
        Material result = null;

        try {
            result = getMaterial(Integer.parseInt(name));
        } catch (NumberFormatException ignored) {
        }

        if (result == null) {
            String filtered = name.toUpperCase();

            filtered = filtered.replaceAll("\\s+", "_").replaceAll("\\W", "");
            result = lookupName.get(filtered);
        }

        return result;
    }

    static {
        for (Material material : values()) {
            lookupId.put(material.getId(), material);
            lookupName.put(material.name(), material);
        }
    }
}
