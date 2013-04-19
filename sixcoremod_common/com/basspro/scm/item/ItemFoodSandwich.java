package com.basspro.scm.item;

import com.basspro.scm.SixCoreMod;

public class ItemFoodSandwich extends ItemFoodSCM
{

    public ItemFoodSandwich(int par1, int par2, float par3, boolean par4)
    {
        super(par1, par2, par3, par4);

        this.setCreativeTab(SixCoreMod.tabSixCoreFood);
        maxStackSize = 64;
    }

}
