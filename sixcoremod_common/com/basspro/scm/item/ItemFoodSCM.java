package com.basspro.scm.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

import com.basspro.scm.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFoodSCM extends ItemFood {

    public ItemFoodSCM(int id, int par2, float par3, boolean par4) {

        super(id - Reference.SHIFTED_ID_RANGE_CORRECTION, par2, par3, par4);
        maxStackSize = 1;
        setNoRepair();

    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {

        iconIndex = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
                + ":"
                + this.getUnlocalizedName().substring(
                        this.getUnlocalizedName().indexOf(".") + 1));
    }
}
