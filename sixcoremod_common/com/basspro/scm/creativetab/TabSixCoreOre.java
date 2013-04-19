package com.basspro.scm.creativetab;

import net.minecraft.creativetab.CreativeTabs;

import com.basspro.scm.lib.BlockIds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabSixCoreOre extends CreativeTabs
{
    public TabSixCoreOre(int i, String str)
    {
        super(i, str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex()
    {
        return BlockIds.ONYX_ORE;
    }

}
