package com.basspro.scm.worldpandora.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

public class WorldChunkManagerPandora extends WorldChunkManager
{
    /* The biome generator object. */
    private BiomeGenBase biomeGenerator;
    private float pandoraTemperature;

    /* The rainfall in the world */
    private float rainfall;

    public WorldChunkManagerPandora(BiomeGenBase par1BiomeGenBase, float par2,
            float par3)
    {
        this.biomeGenerator = par1BiomeGenBase;
        this.pandoraTemperature = par2;
        this.rainfall = par3;
    }

}
