package com.basspro.scm.worldpandora.gen.layer;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import com.basspro.scm.worldpandora.biome.BiomeGenBasePandora;

public class GenLayerPandoraStabilizeBiomes extends GenLayer
{
    private static final int RAD = 1;
    private static final int DIAM = 2;
    protected GenLayer biomeLayer;
    protected GenLayer featureLayer;

    public GenLayerPandoraStabilizeBiomes(int par1, GenLayer biomes,
            GenLayer features)
    {
        super(par1);
        this.biomeLayer = biomes;
        this.featureLayer = features;
    }

    public void initWorldGenSeed(long par1)
    {
        this.biomeLayer.initWorldGenSeed(par1);
        this.featureLayer.initWorldGenSeed(par1);
        super.initWorldGenSeed(par1);
    }

    public int[] getInts(int x, int z, int width, int depth)
    {
        int nwidth = width + 2;

        int[] biomes = this.biomeLayer.getInts(x - 1, z - 1, nwidth, depth + 2);
        int[] features = this.featureLayer.getInts(x - 1, z - 1, nwidth,
                depth + 2);
        int[] out = IntCache.getIntCache(width * depth);

        for (int dz = 0; dz < depth; dz++)
        {
            for (int dx = 0; dx < width; dx++)
            {
                initChunkSeed(dx + x, dz + z);

                boolean nearFeature = false;
                int underFeature = 0;

                for (int sx = -1; sx <= 1; sx++)
                {
                    for (int sz = -1; sz <= 1; sz++)
                    {
                        int featureAt = features[(dx + sx + 1 + (dz + sz + 1)
                                * nwidth)];
                        int inputBiome = biomes[(dx + sx + 1 + (dz + sz + 1)
                                * nwidth)];

                        if (BiomeGenBasePandora.isFeature(featureAt))
                        {
                            nearFeature = true;
                            underFeature = inputBiome;
                            break;
                        }
                    }

                }

                if (nearFeature)
                {
                    out[(dx + dz * width)] = underFeature;
                }
                else
                {
                    out[(dx + dz * width)] = biomes[(dx + 1 + (dz + 1) * nwidth)];
                }
            }
        }

        return out;
    }

}
