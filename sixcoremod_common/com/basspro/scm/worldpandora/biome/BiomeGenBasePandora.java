package com.basspro.scm.worldpandora.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.basspro.scm.lib.BiomeIds;
import com.basspro.scm.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeGenBasePandora extends BiomeGenBase
{

    public static final BiomeGenBase pandora = new PandoraBiomePandora(
            BiomeIds.PANDORA_BIOME).setColor(21760).setBiomeName(
            Strings.PANDORA_BIOME_NAME);
    public static final BiomeGenBase pandora2 = new PandoraBiomePandoraVariant(
            BiomeIds.PANDORA_BIOME_2).setColor(21760).setBiomeName(
            Strings.PANDORA_BIOME_2_NAME);
    public static final BiomeGenBase highlands = new PandoraBiomeHighlands(
            BiomeIds.HIGHLANDS_BIOME).setColor(5596740).setBiomeName(
            Strings.HIGHLANDS_BIOME_NAME);
    public static final BiomeGenBase theDust = new PandoraBiomeTheDust(
            BiomeIds.THEDUST_BIOME).setColor(4382397).setBiomeName(
            Strings.THEDUST_BIOME_NAME);
    public static final BiomeGenBase majorFeature = new PandoraBiomeCenter(
            BiomeIds.MAJOR_FEATURE).setColor(16711680).setBiomeName(
            Strings.MAJOR_FEATURE_NAME);
    public static final BiomeGenBase minorFeature = new PandoraBiomeCenter2(
            BiomeIds.MINOR_FEATURE).setColor(11184640).setBiomeName(
            Strings.MINOR_FEATURE_NAME);

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

    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
        if (random.nextInt(5) == 0)
        {
            return this.worldGeneratorForest;
        }
        if (random.nextInt(10) == 0)
        {
            return new WorldGenBigTree(false);
        }

        return this.worldGeneratorTrees;
    }

    public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
    {
        if (par1Random.nextInt(4) == 0)
        {
            return new WorldGenTallGrass(Block.tallGrass.blockID, 2);
        }

        return new WorldGenTallGrass(Block.tallGrass.blockID, 1);
    }

    public static boolean isFeature(int idToCheck)
    {
        return (idToCheck == majorFeature.biomeID)
                || (idToCheck == minorFeature.biomeID);
    }

    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor()
    {
        double d0 = MathHelper.clamp_float(getFloatTemperature(), 0.0F, 1.0F);
        double d1 = MathHelper.clamp_float(getFloatRainfall(), 0.0F, 1.0F);
        return ColorizerGrass.getGrassColor(d0, d1);
    }

    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor()
    {
        double d0 = MathHelper.clamp_float(getFloatTemperature(), 0.0F, 1.0F);
        double d1 = MathHelper.clamp_float(getFloatRainfall(), 0.0F, 1.0F);
        return ColorizerFoliage.getFoliageColor(d0, d1);
    }

    @SideOnly(Side.CLIENT)
    public int getWaterColorMultiplier()
    {
        return this.waterColorMultiplier;
    }
}
