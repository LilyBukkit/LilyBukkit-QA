package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityPainting;
import net.minecraft.src.EnumArt;
import org.bukkit.Art;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Painting;
import ru.vladthemountain.lilybukkit.block.LBBlock;

/**
 * @author VladTheMountain
 */
public class LBPainting extends LBEntity implements Painting {

    final EntityPainting entity;

    public LBPainting(World w, EntityPainting e) {
        super(w, e);
        this.entity = e;
    }

    @Override
    public Art getArt() {
        return Art.getByName(entity.art.title);
    }

    @Override
    public boolean setArt(Art art) {
        return this.setArt(art, false);
    }

    @Override
    public boolean setArt(Art art, boolean b) {
        // Doing the `switch` thingy as I cannot be sure if
        // `this.entity.art = EnumArt.valueOf(art.name());`
        // will do the trick. Especially with the new alternative titles.
        switch (art) {
            case KEBAB:
            case SOLDIER_TF2:
                this.entity.art = EnumArt.Kebab;
                break;
            case AZTEC:
            case SMOKE:
                this.entity.art = EnumArt.Aztec;
                break;
            case ALBAN:
            case CRAB_NEBULA:
                this.entity.art = EnumArt.Alban;
                break;
            case AZTEC2:
            case CITY_LANDSCAPE:
                this.entity.art = EnumArt.Aztec2;
                break;
            case BOMB:
            case BLACK_AND_WHITE:
                this.entity.art = EnumArt.Bomb;
                break;
            case PLANT:
            case BLURRED:
                this.entity.art = EnumArt.Plant;
                break;
            case WASTELAND:
            case DIM_POT:
                this.entity.art = EnumArt.Wasteland;
                break;
            case POOL:
            case DEMO_SIGN:
                this.entity.art = EnumArt.Pool;
                break;
            case COURBET:
            case CORRUPTED_STEVE:
                this.entity.art = EnumArt.Courbet;
                break;
            case SEA:
            case CHANGED_SEA:
                this.entity.art = EnumArt.Sea;
                break;
            case SUNSET:
            case NOISE:
                this.entity.art = EnumArt.Sunset;
                break;
            case WANDERER:
            case LERMONTOV:
                this.entity.art = EnumArt.Wanderer;
                break;
            case MATCH:
            case HUT:
                this.entity.art = EnumArt.Match;
                break;
            case BUST:
            case CAVE:
                this.entity.art = EnumArt.Bust;
                break;
            case STAGE:
            case RAVINE_ENTRANCE:
                this.entity.art = EnumArt.Stage;
                break;
            case VOID:
            case BLOCK:
                this.entity.art = EnumArt.Void;
                break;
            case ANGEL:
            case WASTELAND_LANDSCAPE:
                this.entity.art = EnumArt.SkullAndRoses;
                break;
            case SKULL_AND_ROSES:
            case COLORED_SQUARES:
                this.entity.art = EnumArt.Fighters;
                break;
            case POINTER:
            case HUB_DOORS:
                this.entity.art = EnumArt.Pointer;
                break;
            default:
                //Exiting is art is invalid
                throw new IllegalArgumentException("Wrong art " + art.name() + " specified for entity " + this.entity.entityID);
        }
        this.world.getWorldServer().markBlockNeedsUpdate((int) this.entity.posX, (int) this.entity.posY, (int) this.entity.posZ);
        return true;
    }

    @Override
    public boolean setFacingDirection(BlockFace blockFace, boolean b) {
        this.setFacingDirection(blockFace);
        return this.entity.onValidSurface() && b;
    }

    @Override
    public BlockFace getAttachedFace() {
        return this.getFacing().getOppositeFace();
    }

    @Override
    public void setFacingDirection(BlockFace blockFace) {
        this.entity.setDirection(LBBlock.convertBlockFaceToNotch(blockFace));
        this.world.getWorldServer().markBlockNeedsUpdate((int) this.entity.posX, (int) this.entity.posY, (int) this.entity.posZ);
    }

    @Override
    public BlockFace getFacing() {
        return LBBlock.convertNotchToBlockFace(this.entity.direction);
    }
}
