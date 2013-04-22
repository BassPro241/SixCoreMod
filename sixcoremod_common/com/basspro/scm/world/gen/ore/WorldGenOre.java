package com.basspro.scm.world.gen.ore;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.basspro.scm.lib.BlockIds;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenOre implements IWorldGenerator
{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    private void generateSurface(World world, Random random, int BlockX,
            int BlockZ)
    {
        if (world.getBiomeGenForCoords(BlockX, BlockZ) == BiomeGenBase.desert)
        {

            for (int i = 0; i < 2; i++)
            {
                int X = BlockX + random.nextInt(16);
                int Z = BlockZ + random.nextInt(16);
                int Y = random.nextInt(17);

                new WorldGenMinable(BlockIds.ONYX_ORE, 6).generate(world,
                        random, X, Y, Z);
            }
        }

        if (world.getBiomeGenForCoords(BlockX, BlockZ) == BiomeGenBase.mushroomIsland)
        {
            for (int i = 0; i < 3; i++)
            {
                int X = BlockX + random.nextInt(16);
                int Z = BlockZ + random.nextInt(16);
                int Y = random.nextInt(33);

                new WorldGenMinable(BlockIds.ERIDIUM_ORE, 4).generate(world,
                        random, X, Y, Z);
            }
        }
    }

    private void generateNether(World world, Random random, int i, int j)
    {

    }

}
