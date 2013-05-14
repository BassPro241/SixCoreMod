package com.basspro.scm.configuration;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import com.basspro.scm.lib.BlockIds;
import com.basspro.scm.lib.ItemIds;
import com.basspro.scm.lib.Reference;
import com.basspro.scm.lib.Strings;

import cpw.mods.fml.common.FMLLog;

public class ConfigurationHandler
{

    public static Configuration configuration;

    public static void init(File configFile)
    {

        configuration = new Configuration(configFile);

        try
        {
            configuration.load();

            /* Block configs */

            BlockIds.ONYX_ORE = configuration.getBlock(Strings.ONYX_ORE_NAME,
                    BlockIds.ONYX_ORE_DEFAULT)
                    .getInt(BlockIds.ONYX_ORE_DEFAULT);
            BlockIds.ERIDIUM_ORE = configuration.getBlock(
                    Strings.ERIDIUM_ORE_NAME, BlockIds.ERIDIUM_ORE_DEFAULT)
                    .getInt(BlockIds.ERIDIUM_ORE_DEFAULT);
            BlockIds.SAPPHIRE_ORE = configuration.getBlock(
                    Strings.SAPPHIRE_ORE_NAME, BlockIds.SAPPHIRE_ORE_DEFAULT)
                    .getInt(BlockIds.SAPPHIRE_ORE_DEFAULT);
            BlockIds.RUBY_ORE = configuration.getBlock(Strings.RUBY_ORE_NAME,
                    BlockIds.RUBY_ORE_DEFAULT)
                    .getInt(BlockIds.RUBY_ORE_DEFAULT);
            BlockIds.SILVER_ORE = configuration.getBlock(
                    Strings.SILVER_ORE_NAME, BlockIds.SILVER_ORE_DEFAULT)
                    .getInt(BlockIds.SILVER_ORE_DEFAULT);
            BlockIds.PLATINUM_ORE = configuration.getBlock(
                    Strings.PLATINUM_ORE_NAME, BlockIds.PLATINUM_ORE_DEFAULT)
                    .getInt(BlockIds.PLATINUM_ORE_DEFAULT);

            BlockIds.ONYX_BLOCK = configuration.getBlock(
                    Strings.ONYX_BLOCK_NAME, BlockIds.ONYX_BLOCK_DEFAULT)
                    .getInt(BlockIds.ONYX_BLOCK_DEFAULT);
            BlockIds.SAPPHIRE_BLOCK = configuration.getBlock(
                    Strings.SAPPHIRE_BLOCK_NAME,
                    BlockIds.SAPPHIRE_BLOCK_DEFAULT).getInt(
                    BlockIds.SAPPHIRE_BLOCK_DEFAULT);
            BlockIds.RUBY_BLOCK = configuration.getBlock(
                    Strings.RUBY_BLOCK_NAME, BlockIds.RUBY_BLOCK_DEFAULT)
                    .getInt(BlockIds.RUBY_BLOCK_DEFAULT);
            BlockIds.BRONZE_BLOCK = configuration.getBlock(
                    Strings.BRONZE_BLOCK_NAME, BlockIds.BRONZE_BLOCK_DEFAULT)
                    .getInt(BlockIds.BRONZE_BLOCK_DEFAULT);
            BlockIds.SILVER_BLOCK = configuration.getBlock(
                    Strings.SILVER_BLOCK_NAME, BlockIds.SILVER_BLOCK_DEFAULT)
                    .getInt(BlockIds.SILVER_BLOCK_DEFAULT);
            BlockIds.PLATINUM_BLOCK = configuration.getBlock(
                    Strings.PLATINUM_BLOCK_NAME,
                    BlockIds.PLATINUM_BLOCK_DEFAULT).getInt(
                    BlockIds.PLATINUM_BLOCK_DEFAULT);

            BlockIds.DUST_BLOCK = configuration.getBlock(
                    Strings.DUST_BLOCK_NAME, BlockIds.DUST_BLOCK_DEFAULT)
                    .getInt(BlockIds.DUST_BLOCK_DEFAULT);

            BlockIds.PANDORAPORTAL_BLOCK = configuration.getBlock(
                    Strings.PANDORAPORTAL_NAME,
                    BlockIds.PANDORAPORTAL_BLOCK_DEFAULT).getInt(
                    BlockIds.PANDORAPORTAL_BLOCK_DEFAULT);

            /* Item configs */
            ItemIds.PORK_SANDWICH = configuration.getItem(
                    Strings.PORK_SANDWICH_NAME, ItemIds.PORK_SANDWICH_DEFAULT)
                    .getInt(ItemIds.PORK_SANDWICH_DEFAULT);
            ItemIds.FISH_SANDWICH = configuration.getItem(
                    Strings.FISH_SANDWICH_NAME, ItemIds.FISH_SANDWICH_DEFAULT)
                    .getInt(ItemIds.FISH_SANDWICH_DEFAULT);
            ItemIds.CANDY = configuration.getItem(Strings.CANDY_NAME,
                    ItemIds.CANDY_DEFAULT).getInt(ItemIds.CANDY_DEFAULT);
            ItemIds.BREAD_TOAST = configuration.getItem(
                    Strings.BREAD_TOAST_NAME, ItemIds.BREAD_TOAST_DEFAULT)
                    .getInt(ItemIds.BREAD_TOAST_DEFAULT);
            ItemIds.CARAMEL = configuration.getItem(Strings.CARAMEL_NAME,
                    ItemIds.CARAMEL_DEFAULT).getInt(ItemIds.CARAMEL_DEFAULT);
            ItemIds.CARAMEL_APPLE = configuration.getItem(
                    Strings.CARAMEL_APPLE_NAME, ItemIds.CARAMEL_APPLE_DEFAULT)
                    .getInt(ItemIds.CARAMEL_APPLE_DEFAULT);
            ItemIds.APPLE_PIE = configuration.getItem(Strings.APPLE_PIE_NAME,
                    ItemIds.APPLE_PIE_DEFAULT)
                    .getInt(ItemIds.APPLE_PIE_DEFAULT);

            ItemIds.ONYX = configuration.getItem(Strings.ONYX_NAME,
                    ItemIds.ONYX_DEFAULT).getInt(ItemIds.ONYX_DEFAULT);
            ItemIds.SILVER_INGOT = configuration.getItem(
                    Strings.SILVER_INGOT_NAME, ItemIds.SILVER_INGOT_DEFAULT)
                    .getInt(ItemIds.SILVER_INGOT_DEFAULT);
            ItemIds.RUBY = configuration.getItem(Strings.RUBY_NAME,
                    ItemIds.RUBY_DEFAULT).getInt(ItemIds.RUBY_DEFAULT);
            ItemIds.SAPPHIRE = configuration.getItem(Strings.SAPPHIRE_NAME,
                    ItemIds.SAPPHIRE_DEFAULT).getInt(ItemIds.SAPPHIRE_DEFAULT);
            ItemIds.BRONZE_INGOT = configuration.getItem(
                    Strings.BRONZE_INGOT_NAME, ItemIds.BRONZE_INGOT_DEFAULT)
                    .getInt(ItemIds.BRONZE_INGOT_DEFAULT);
            ItemIds.PLATINUM_INGOT = configuration
                    .getItem(Strings.PLATINUM_INGOT_NAME,
                            ItemIds.PLATINUM_INGOT_DEFAULT).getInt(
                            ItemIds.PLATINUM_INGOT_DEFAULT);
            ItemIds.ERIDIUM_INGOT = configuration.getItem(
                    Strings.ERIDIUM_INGOT_NAME, ItemIds.ERIDIUM_INGOT_DEFAULT)
                    .getInt(ItemIds.ERIDIUM_INGOT_DEFAULT);

            ItemIds.ONYX_SWORD = configuration.getItem(Strings.ONYX_SWORD_NAME,
                    ItemIds.ONYX_SWORD_DEFAULT).getInt(
                    ItemIds.ONYX_SWORD_DEFAULT);
            
            Strings.PANDORA_SEED = configuration.get("general", Strings.PANDORA_SEED_DEFAULT, "").getString();

        }
        catch (Exception e)
        {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME
                    + " has had a problem loading its configuration");
        }
        finally
        {
            configuration.save();
        }
    }

    public static void set(String categoryName, String propertyName,
            String newValue)
    {

        configuration.load();
        if (configuration.getCategoryNames().contains(categoryName))
        {
            if (configuration.getCategory(categoryName).containsKey(
                    propertyName))
            {
                configuration.getCategory(categoryName).get(propertyName)
                        .set(newValue);
            }
        }
        configuration.save();
    }
}
