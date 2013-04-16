package com.basspro.scm.creativetab;

import net.minecraft.creativetab.CreativeTabs;

import com.basspro.scm.item.SixCoreModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabSixCoreItem extends CreativeTabs{

    public TabSixCoreItem(int i, String str)
    {
        super(i, str);
    }
    
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex()
    {
        return SixCoreModItems.porkSandwich.itemID;
    }
    
    public String getTranslatedTabLabel()
    {
        return "Six Core Mod Items";
    }
    
}
