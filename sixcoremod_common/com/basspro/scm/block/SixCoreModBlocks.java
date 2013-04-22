package com.basspro.scm.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

import com.basspro.scm.lib.BlockIds;
import com.basspro.scm.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class SixCoreModBlocks
{

    // Ores
    public static Block oreSilver;
    public static Block oreRuby;
    public static Block oreSapphire;
    public static Block oreOnyx;
    public static Block oreBronze;
    public static Block orePlatinum;
    public static Block oreEridium;

    public static Block onyxBlock;

    // Nether Ores
    public static Block oreOnyxNether;

    public static void init()
    {
        oreOnyx = new OreOnyx(BlockIds.ONYX_ORE);
        oreEridium = new OreEridium(BlockIds.ERIDIUM_ORE);
        onyxBlock = new BlockOreMetal(BlockIds.ONYX_BLOCK, Material.iron)
                .setUnlocalizedName("onyxBlock");

        GameRegistry.registerBlock(oreOnyx, Strings.ONYX_ORE_NAME);
        GameRegistry.registerBlock(onyxBlock, Strings.ONYX_BLOCK_NAME);
        GameRegistry.registerBlock(oreEridium, Strings.ERIDIUM_ORE_NAME);

        MinecraftForge.setBlockHarvestLevel(oreOnyx, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(onyxBlock, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(oreEridium, "pickaxe", 2);

    }

}
