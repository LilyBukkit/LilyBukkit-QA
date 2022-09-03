package ru.vladthemountain.lilybukkit.core.block;

import net.minecraft.src.IInventory;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntityFurnace;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.inventory.Inventory;
import ru.vladthemountain.lilybukkit.core.LBWorld;
import ru.vladthemountain.lilybukkit.core.inventory.LBInventory;

public class LBFurnace extends LBBlockState implements Furnace {

    TileEntityFurnace entity;

    public LBFurnace(LBWorld w, Block b) {
        super(w, b);
        this.entity = (TileEntityFurnace) w.getWorldServer().getBlockTileEntity(b.getX(), b.getY(), b.getZ());
    }

    /**
     * Get burn time.
     *
     * @return
     */
    @Override
    public short getBurnTime() {
        return (short) this.entity.getBurnTimeRemainingScaled(1);
    }

    /**
     * Set burn time.
     */
    @Override
    public void setBurnTime(short burnTime) {
        NBTTagCompound furnaceContents = new NBTTagCompound();
        this.entity.writeToNBT(furnaceContents);
        furnaceContents.setShort("BurnTime", burnTime);
        this.entity.onInventoryChanged();
        this.entity.updateEntity();
    }

    /**
     * Get cook time.
     */
    @Override
    public short getCookTime() {
        return (short) this.entity.getCookProgressScaled(1);
    }

    /**
     * Set cook time.
     */
    @Override
    public void setCookTime(short cookTime) {
        NBTTagCompound furnaceContents = new NBTTagCompound();
        this.entity.writeToNBT(furnaceContents);
        furnaceContents.setShort("CookTime", cookTime);
        this.entity.onInventoryChanged();
        this.entity.updateEntity();
    }

    /**
     * Get the block's inventory.
     */
    @Override
    public Inventory getInventory() {
        return new LBInventory((IInventory) world.getWorldServer().getBlockTileEntity(this.getX(), this.getY(), this.getZ()));
    }
}
