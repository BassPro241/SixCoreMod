package com.basspro.scm.worldpandora.gen.layer;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import com.basspro.scm.worldpandora.biome.BiomeGenBasePandora;

public class GenLayerPandoraMajorFeatures extends GenLayer
{
    public GenLayerPandoraMajorFeatures(long par1)
    {
        super(par1);
    }

    public int[] getInts(int x, int z, int width, int depth)
    {
        int[] out = IntCache.getIntCache(width * depth);
        for (int i = 0; i < out.length; i++)
        {
            out[i] = BiomeGenBasePandora.majorFeature.biomeID;
        }
        return out;
    }

}
