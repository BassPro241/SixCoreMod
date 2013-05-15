package com.basspro.scm.worldpandora.biome;

import com.basspro.scm.block.SixCoreModBlocks;

public class PandoraBiomeTheDust extends BiomeGenBasePandora
{
    public PandoraBiomeTheDust(int par1)
    {
        super(par1);

        this.temperature = 2.0F;
        this.rainfall = 0.0F;

        this.minHeight = -0.2F;
        this.maxHeight = 0.4F;
        
        this.topBlock = (byte)SixCoreModBlocks.blockDust.blockID;
        this.fillerBlock = (byte)SixCoreModBlocks.blockDust.blockID;
    }
}
