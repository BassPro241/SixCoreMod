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
    public static Block silverBlock;
    public static Block rubyBlock;
    public static Block sapphireBlock;
    public static Block bronzeBlock;
    public static Block platinumBlock;

    // Nether Ores
    public static Block oreOnyxNether;
    
    // Terrain Blocks
    public static Block blockDust;
    public static Block blockStoneMossy;

    public static void init()
    {
        oreOnyx = new OreOnyx(BlockIds.ONYX_ORE);
        oreEridium = new OreEridium(BlockIds.ERIDIUM_ORE);
        oreRuby = new OreRuby(BlockIds.RUBY_ORE);
        oreSapphire = new OreSapphire(BlockIds.SAPPHIRE_ORE);
        
        onyxBlock = new BlockOreMetal(BlockIds.ONYX_BLOCK, Material.iron)
                .setUnlocalizedName("onyxBlock");
        silverBlock = new BlockOreMetal(BlockIds.SILVER_BLOCK, Material.iron)
                .setUnlocalizedName("silverBlock");
        rubyBlock = new BlockOreMetal(BlockIds.RUBY_BLOCK, Material.iron).setUnlocalizedName("rubyBlock");
        sapphireBlock = new BlockOreMetal(BlockIds.SAPPHIRE_BLOCK, Material.iron).setUnlocalizedName("sapphireBlock");
        bronzeBlock = new BlockOreMetal(BlockIds.BRONZE_BLOCK, Material.iron).setUnlocalizedName("bronzeBlock");
        platinumBlock = new BlockOreMetal(BlockIds.PLATINUM_BLOCK, Material.iron).setUnlocalizedName("platinumBlock");
        
        blockDust = new BlockDust(BlockIds.DUST_BLOCK, Material.sand).setUnlocalizedName("dustBlock");

        GameRegistry.registerBlock(oreOnyx, Strings.ONYX_ORE_NAME);
        GameRegistry.registerBlock(oreEridium, Strings.ERIDIUM_ORE_NAME);
        GameRegistry.registerBlock(oreRuby, Strings.RUBY_ORE_NAME);
        GameRegistry.registerBlock(oreSapphire, Strings.SAPPHIRE_ORE_NAME);
        
        GameRegistry.registerBlock(onyxBlock, Strings.ONYX_BLOCK_NAME);
        GameRegistry.registerBlock(silverBlock, Strings.SILVER_BLOCK_NAME);
        GameRegistry.registerBlock(sapphireBlock, Strings.SAPPHIRE_BLOCK_NAME);
        GameRegistry.registerBlock(rubyBlock, Strings.RUBY_BLOCK_NAME);
        GameRegistry.registerBlock(bronzeBlock, Strings.BRONZE_BLOCK_NAME);
        GameRegistry.registerBlock(platinumBlock, Strings.PLATINUM_BLOCK_NAME);
        
        GameRegistry.registerBlock(blockDust, Strings.DUST_BLOCK_NAME);

        MinecraftForge.setBlockHarvestLevel(oreOnyx, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(oreEridium, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(oreRuby, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(oreSapphire, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(onyxBlock, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(silverBlock, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(rubyBlock, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(sapphireBlock, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(bronzeBlock, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(platinumBlock, "pickaxe", 2);

    }

}
