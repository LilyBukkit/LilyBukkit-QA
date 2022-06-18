package ru.vtm.lilybukkit.stubs.entity;

import net.minecraft.src.World;
import org.bukkit.entity.LightningStrike;

/**
 * A stub class for a non-existent entity
 */
public class EntityLightning extends EntityWeather implements LightningStrike {
    public EntityLightning(World world) {
        super(world);
    }

    /**
     * Returns whether the strike is an effect that does no damage.
     *
     * @return whether the strike is an effect
     */
    @Override
    public boolean isEffect() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
