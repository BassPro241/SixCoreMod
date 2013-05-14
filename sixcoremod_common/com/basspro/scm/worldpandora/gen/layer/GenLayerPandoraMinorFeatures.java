package com.basspro.scm.worldpandora.gen.layer;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import com.basspro.scm.worldpandora.biome.BiomeGenBasePandora;

public class GenLayerPandoraMinorFeatures extends GenLayer
{
    protected GenLayer featureLayer;
    protected GenLayer biomeLayer;

    public GenLayerPandoraMinorFeatures(int par1, GenLayer biomes,
            GenLayer features)
    {
        super(par1);
        this.featureLayer = features;
        this.biomeLayer = biomes;
    }

    public void initWorldGenSeed(long par1)
    {
        this.featureLayer.initWorldGenSeed(par1);
        this.biomeLayer.initWorldGenSeed(par1);
        super.initWorldGenSeed(par1);
    }

    public int[] getInts(int x, int z, int width, int depth)
    {
        int nwidth = width + 2;

        int[] biomes = this.biomeLayer.getInts(x - 1, z - 1, nwidth, depth + 2);
        int[] features = this.featureLayer.getInts(x, z, width, depth);
        int[] out = IntCache.getIntCache(width * depth);

        for (int dz = 0; dz < depth; dz++)
        {
            for (int dx = 0; dx < width; dx++)
            {
                initChunkSeed(dx + x, dz + z);

                int featureAt = features[(dx + dz * width)];
                int inputBiome = biomes[(dx + 1 + (dz + 1) * nwidth)];

                if (BiomeGenBasePandora.isFeature(featureAt))
                {
                    out[(dx + dz * width)] = featureAt;
                }
                else if (nextInt(2) == 0)
                {
                    int up = biomes[(dx + 1 + (dz + 0) * nwidth)];
                    int right = biomes[(dx + 2 + (dz + 1) * nwidth)];
                    int left = biomes[(dx + 0 + (dz + 1) * nwidth)];
                    int down = biomes[(dx + 1 + (dz + 2) * nwidth)];
                    int ul = biomes[(dx + 0 + (dz + 0) * nwidth)];
                    int dr = biomes[(dx + 2 + (dz + 2) * nwidth)];
                    int ur = biomes[(dx + 2 + (dz + 0) * nwidth)];
                    int dl = biomes[(dx + 0 + (dz + 2) * nwidth)];

                    if ((ul == inputBiome) && (dr == inputBiome)
                            && (ur == inputBiome) && (dl == inputBiome)
                            && (up == inputBiome) && (right == inputBiome)
                            && (left == inputBiome) && (down == inputBiome))
                    {
                        out[(dx + dz * width)] = nextInt(BiomeGenBasePandora.majorFeature.biomeID);
                    }
                    else
                    {
                        out[(dx + dz * width)] = 0;
                    }
                }
                else
                {
                    out[(dx + dz * width)] = 0;
                }
            }

        }

        return out;
    }

}
