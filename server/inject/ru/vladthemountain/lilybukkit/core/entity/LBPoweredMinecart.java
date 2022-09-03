package ru.vladthemountain.lilybukkit.core.entity;

import net.minecraft.src.EntityMinecart;
import org.bukkit.entity.PoweredMinecart;
import ru.vladthemountain.lilybukkit.core.LBWorld;

public class LBPoweredMinecart extends LBMinecart implements PoweredMinecart {
    public LBPoweredMinecart(LBWorld w, EntityMinecart e) {
        super(w, e);
    }
}
