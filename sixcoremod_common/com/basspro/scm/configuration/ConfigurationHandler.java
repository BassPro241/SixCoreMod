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

            BlockIds.ONYX_ORE = configuration.getBlock(Strings.ONYX_ORE_NAME, BlockIds.ONYX_ORE_DEFAULT).getInt(BlockIds.ONYX_ORE_DEFAULT);
            BlockIds.ONYX_BLOCK = configuration.getBlock(Strings.ONYX_BLOCK_NAME, BlockIds.ONYX_BLOCK_DEFAULT).getInt(BlockIds.ONYX_BLOCK_DEFAULT);
            
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

        } catch (Exception e)
        {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME
                    + " has had a problem loading its configuration");
        } finally
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
