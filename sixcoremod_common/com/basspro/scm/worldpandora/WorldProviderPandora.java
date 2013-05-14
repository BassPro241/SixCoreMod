package com.basspro.scm.worldpandora;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

import com.basspro.scm.SixCoreMod;
import com.basspro.scm.lib.Strings;
import com.basspro.scm.worldpandora.biome.BiomeGenBasePandora;
import com.basspro.scm.worldpandora.biome.WorldChunkManagerPandora;
import com.basspro.scm.worldpandora.gen.ChunkProviderPandora;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderPandora extends WorldProviderSurface
{
    public final String saveFolder;

    public WorldProviderPandora()
    {
        setDimension(SixCoreMod.dimension);
        this.saveFolder = ("DIM" + SixCoreMod.dimension);
    }

    public float[] calcSunriseSunsetColors(float celestialAngle, float f1)
    {
        return null;
    }

    public Vec3 getFogColor(float f, float f1)
    {
        float bright = MathHelper.cos(1.570797F) * 2.0F + 0.5F;
        if (bright < 0.0F)
        {
            bright = 0.0F;
        }
        if (bright > 1.0F)
        {
            bright = 1.0F;
        }
        float red = 0.7529412F;
        float green = 1.0F;
        float blue = 0.8470588F;
        red *= (bright * 0.94F + 0.06F);
        green *= (bright * 0.94F + 0.06F);
        blue *= (bright * 0.91F + 0.09F);
        return this.worldObj.getWorldVec3Pool()
                .getVecFromPool(red, green, blue);
    }

    public float calculateCelestialAngle(long par1, float par3)
    {
        return 0.225F;
    }

    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerPandora(this.worldObj);
        this.dimensionId = SixCoreMod.dimension;
    }

    public IChunkProvider createChunkGenerator()
    {
        return new ChunkProviderPandora(this.worldObj,
                this.worldObj.getSeed(), this.worldObj.getWorldInfo()
                        .isMapFeaturesEnabled());
    }

    public boolean isSkyColored()
    {
        return false;
    }

    public int getAverageGroundLevel()
    {
        return 33;
    }

    public boolean canRespawnHere()
    {
        return true;
    }

    public String getSaveFolder()
    {
        return this.saveFolder;
    }

    public String getWelcomeMessage()
    {
        return "Welcome to Pandora kiddos!";
    }

    public String getDepartMessage()
    {
        return "Leaving Pandora";
    }

    public String getDimensionName()
    {
        return "Pandora";
    }

    public boolean isDaytime()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
    {
        return this.worldObj.getWorldVec3Pool().getVecFromPool(0.16796875D,
                0.1796875D, 0.38671875D);
    }

    @SideOnly(Side.CLIENT)
    public float getStarBrightness(float par1)
    {
        return 1.0F;
    }

    public double getHorizon()
    {
        return 32.0D;
    }

    public BiomeGenBase getBiomeGenForCoords(int x, int z)
    {
        BiomeGenBase biome = super.getBiomeGenForCoords(x, z);
        if (biome == null)
        {
            biome = BiomeGenBasePandora.pandora;
        }
        return biome;
    }

    public long getSeed()
    {
        if ((Strings.PANDORA_SEED == null)
                || (Strings.PANDORA_SEED.length() == 0))
        {
            return super.getSeed();
        }

        return Strings.PANDORA_SEED.hashCode();
    }
}
