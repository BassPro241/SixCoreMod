package com.basspro.scm.item;

import com.basspro.scm.SixCoreMod;

public class ItemMetalIngot extends ItemSCM
{
    public ItemMetalIngot(int id)
    {
        super(id);
        maxStackSize = 64;
        setCreativeTab(SixCoreMod.tabSixCoreMaterial);
    }
}
