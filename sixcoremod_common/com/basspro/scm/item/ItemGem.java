package com.basspro.scm.item;

import com.basspro.scm.SixCoreMod;

public class ItemGem extends ItemSCM
{
    public ItemGem(int id)
    {
        super(id);
        this.setCreativeTab(SixCoreMod.tabSixCoreMaterial);
        maxStackSize = 64;
    }
}
