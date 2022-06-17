package ru.vtm.lilybukkit.entity;

import net.minecraft.src.EntityZombie;
import net.minecraft.src.World;
import org.bukkit.entity.PigZombie;

/**
 * A stub class for a non-existent entity
 */
public class EntityPigZombie extends EntityZombie implements PigZombie {
    public EntityPigZombie(World world) {
        super(world);
    }

    /**
     * Get the pig zombie's current anger level.
     *
     * @return The anger level.
     */
    @Override
    public int getAnger() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set the pig zombie's current anger level.
     *
     * @param level The anger level. Higher levels of anger take longer to wear off.
     */
    @Override
    public void setAnger(int level) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Shorthand; sets to either 0 or the default level.
     *
     * @param angry Whether the zombie should be angry.
     */
    @Override
    public void setAngry(boolean angry) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Shorthand; gets whether the zombie is angry.
     *
     * @return True if the zombie is angry, otherwise false.
     */
    @Override
    public boolean isAngry() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
