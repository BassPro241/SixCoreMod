package com.basspro.scm.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.basspro.scm.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSCM extends Item
{

    public ItemSCM(int id)
    {

        super(id - Reference.SHIFTED_ID_RANGE_CORRECTION);
        maxStackSize = 1;
        setNoRepair();

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {

        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
                + ":"
                + this.getUnlocalizedName().substring(
                        this.getUnlocalizedName().indexOf(".") + 1));
    }

}
