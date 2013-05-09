package com.basspro.scm.worldpandora.biome;

import com.basspro.scm.lib.BiomeIds;
import com.basspro.scm.lib.Strings;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBasePandora extends BiomeGenBase
{
    
    public static final BiomeGenBase highlands = (BiomeIds.HIGHLANDS_BIOME).setColor(5596740).setBiomeName(Strings.HIGHLANDS_BIOME_NAME);

    public BiomeGenBasePandora(int par1)
    {
        super(par1);
    }

}
