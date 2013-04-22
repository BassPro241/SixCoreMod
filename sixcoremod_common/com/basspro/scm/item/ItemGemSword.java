package com.basspro.scm.item;

import com.basspro.scm.SixCoreMod;

import net.minecraft.item.EnumToolMaterial;

public class ItemGemSword extends ItemSwordSCM
{
    public ItemGemSword(int id, EnumToolMaterial material)
    {
        super(id, material);
        this.setCreativeTab(SixCoreMod.tabSixCoreCombat);
        
    }
}
