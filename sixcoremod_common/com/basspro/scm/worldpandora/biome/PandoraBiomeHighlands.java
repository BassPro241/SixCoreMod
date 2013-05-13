package com.basspro.scm.worldpandora.biome;

import java.util.Random;

import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;

public class PandoraBiomeHighlands extends BiomeGenBasePandora
{

    public PandoraBiomeHighlands(int par1)
    {
        super(par1);
        this.minHeight = 2.5F;
        this.maxHeight = 0.4F;

        this.temperature = 0.5F;
        this.rainfall = 0.3F;
    }

    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
        if (random.nextInt(4) == 0)
        {
            return new WorldGenBigTree(false);
        }
        if (random.nextInt(10) == 0)
        {
            return new WorldGenTaiga2(true);
        }

        return this.worldGeneratorForest;
    }
}
