package com.basspro.scm.worldpandora.biome;

import static net.minecraft.world.biome.BiomeGenBase.forest;
import static net.minecraft.world.biome.BiomeGenBase.forestHills;
import static net.minecraft.world.biome.BiomeGenBase.jungle;
import static net.minecraft.world.biome.BiomeGenBase.plains;
import static net.minecraft.world.biome.BiomeGenBase.taiga;
import static net.minecraft.world.biome.BiomeGenBase.taigaHills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;

public class WorldChunkManagerPandora extends WorldChunkManager
{
    private GenLayer genBiomes;

    /** A GenLayer containing the indices into BiomeGenBase.biomeList[] */
    private GenLayer biomeIndexLayer;

    /** The BiomeCache object for this world. */
    private BiomeCache biomeCache;

    /** A list of biomes that the player can spawn in. */
    private List biomesToSpawnIn;

    public WorldChunkManagerPandora()
    {
        this.biomeCache = new BiomeCache(this);
    }

    public WorldChunkManagerPandora(long par1, WorldType par3WorldType)
    {
        this();
        GenLayer[] agenlayer = GenLayer.initializeAllBiomeGenerators(par1, par3WorldType);
        agenlayer = getModdedBiomeGenerators(par3WorldType, par1, agenlayer);
        this.genBiomes = agenlayer[0];
        this.biomeIndexLayer = agenlayer[1];
    }

    public WorldChunkManagerPandora(World par1World)
    {
        this(par1World.getSeed(), par1World.getWorldInfo().getTerrainType());
    }
}
