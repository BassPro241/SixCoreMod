package com.basspro.scm.worldpandora.biome;

import twilightforest.biomes.TFBiomeDecorator;

import com.basspro.scm.lib.BiomeIds;
import com.basspro.scm.lib.Strings;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBasePandora extends BiomeGenBase
{

    public static final BiomeGenBase highlands = new PandoraBiomeHighlands(
            BiomeIds.HIGHLANDS_BIOME).setColor(5596740).setBiomeName(
            Strings.HIGHLANDS_BIOME_NAME);

    public BiomeGenBasePandora(int par1)
    {
        super(par1);

        this.worldGeneratorBigTree = null;

        this.spawnableMonsterList.clear();

        this.spawnableWaterCreatureList.clear();
    }

    public BiomeGenBasePandora setColor(int par1)
    {
        return (BiomeGenBasePandora) super.setColor(par1);
    }

    public float getSpawningChance()
    {
        return 0.12F;
    }

    public BiomeDecorator createBiomeDecorator()
    {
        return new BiomePandoraDecorator(this);
    }

    protected BiomePandoraDecorator getTFBiomeDecorator()
    {
        return (BiomePandoraDecorator) this.theBiomeDecorator;
    }
}
