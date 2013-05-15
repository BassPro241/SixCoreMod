package com.basspro.scm.worldpandora.gen.layer;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import com.basspro.scm.worldpandora.biome.BiomeGenBasePandora;

public class GenLayerPandoraReinsertFeatures extends GenLayer
{
    private GenLayer withoutLayer;
    private GenLayer withLayer;

    public GenLayerPandoraReinsertFeatures(long par1, GenLayer par3GenLayer,
            GenLayer par4GenLayer)
    {
        super(par1);
        this.withoutLayer = par3GenLayer;
        this.withLayer = par4GenLayer;
    }

    public void initWorldGenSeed(long par1)
    {
        this.withoutLayer.initWorldGenSeed(par1);
        this.withLayer.initWorldGenSeed(par1);
        super.initWorldGenSeed(par1);
    }

    public int[] getInts(int mapX, int mapZ, int mapWidth, int mapDepth)
    {
        int[] without = this.withoutLayer.getInts(mapX, mapZ, mapWidth,
                mapDepth);
        int[] with = this.withLayer.getInts(mapX, mapZ, mapWidth, mapDepth);
        int[] dest = IntCache.getIntCache(mapWidth * mapDepth);

        for (int i = 0; i < mapWidth * mapDepth; i++)
        {
            if (with[i] > 0)
            {
                dest[i] = (with[i] == BiomeGenBasePandora.majorFeature.biomeID ? with[i]
                        : BiomeGenBasePandora.minorFeature.biomeID);
            }
            else
            {
                if (without[i] < 0)
                {
                    without[i] = BiomeGenBasePandora.pandora.biomeID;
                }

                dest[i] = without[i];
            }
        }

        return dest;
    }

}
