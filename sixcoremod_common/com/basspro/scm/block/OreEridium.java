package com.basspro.scm.block;

import net.minecraft.block.Block;

import com.basspro.scm.SixCoreMod;
import com.basspro.scm.lib.Strings;

public class OreEridium extends BlockOreSCM
{
    public OreEridium(int id)
    {
        super(id);
        setStepSound(Block.soundStoneFootstep);
        setCreativeTab(SixCoreMod.tabSixCoreModOre);
        setHardness(3.0F);
        setUnlocalizedName(Strings.ERIDIUM_ORE_NAME);
    }
    
}
