package com.basspro.scm.item;

import com.basspro.scm.SixCoreMod;
import com.basspro.scm.lib.Strings;

public class ItemCaramel extends ItemSCM
{
    public ItemCaramel(int id)
    {
        super(id);
        this.setUnlocalizedName(Strings.CARAMEL_NAME);
        this.setCreativeTab(SixCoreMod.tabSixCoreMaterial);
        this.maxStackSize = 64;
    }
}
