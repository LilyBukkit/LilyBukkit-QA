package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityMinecart;
import org.bukkit.entity.PoweredMinecart;
import ru.vladthemountain.lilybukkit.LBWorld;

public class LBPoweredMinecart extends LBMinecart implements PoweredMinecart {
    public LBPoweredMinecart(LBWorld w, EntityMinecart e) {
        super(w, e);
    }
}
