package com.basspro.scm.worldpandora.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import com.basspro.scm.worldpandora.biome.BiomeGenBasePandora;

public class GenLayerPandoraBiomes extends GenLayer
{
    protected BiomeGenBase[] commonBiomes = { BiomeGenBasePandora.pandora,
            BiomeGenBasePandora.pandora2, BiomeGenBasePandora.highlands };

    protected BiomeGenBase[] rareBiomes = { BiomeGenBasePandora.theDust };

    public GenLayerPandoraBiomes(long l, GenLayer genlayer)
    {
        super(l);
        this.parent = genlayer;
    }

    public GenLayerPandoraBiomes(long l)
    {
        super(l);
    }

    public int[] getInts(int x, int z, int width, int depth)
    {
        int[] dest = IntCache.getIntCache(width * depth);
        for (int dz = 0; dz < depth; dz++)
        {
            for (int dx = 0; dx < width; dx++)
            {
                initChunkSeed(dx + x, dz + z);
                if (nextInt(15) == 0)
                {
                    dest[(dx + dz * width)] = this.rareBiomes[nextInt(this.rareBiomes.length)].biomeID;
                }
                else
                {
                    dest[(dx + dz * width)] = this.commonBiomes[nextInt(this.commonBiomes.length)].biomeID;
                }

            }

        }

        return dest;
    }
}
