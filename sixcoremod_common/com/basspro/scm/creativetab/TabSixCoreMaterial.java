package com.basspro.scm.creativetab;

import net.minecraft.creativetab.CreativeTabs;

import com.basspro.scm.lib.ItemIds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabSixCoreMaterial extends CreativeTabs
{
    public TabSixCoreMaterial(int i, String str)
    {
        super(i, str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex()
    {
        return ItemIds.CARAMEL;
    }

}
