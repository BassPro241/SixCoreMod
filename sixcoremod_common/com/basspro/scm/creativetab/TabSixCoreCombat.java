package com.basspro.scm.creativetab;

import net.minecraft.creativetab.CreativeTabs;

import com.basspro.scm.lib.ItemIds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabSixCoreCombat extends CreativeTabs
{
    public TabSixCoreCombat(int i, String str)
    {
        super(i, str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex()
    {
        return ItemIds.ONYX_SWORD;
    }

}
