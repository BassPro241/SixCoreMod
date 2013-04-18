package com.basspro.scm.configuration;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

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

            /* Item configs */
            ItemIds.PORK_SANDWICH = configuration.getItem(
                    Strings.PORK_SANDWICH_NAME, ItemIds.PORK_SANDWICH_DEFAULT)
                    .getInt(ItemIds.PORK_SANDWICH_DEFAULT);
            ItemIds.FISH_SANDWICH = configuration.getItem(
                    Strings.FISH_SANDWICH_NAME, ItemIds.FISH_SANDWICH_DEFAULT)
                    .getInt(ItemIds.FISH_SANDWICH_DEFAULT);
            ItemIds.CANDY = configuration.getItem(
                    Strings.CANDY_NAME, ItemIds.CANDY_DEFAULT)
                    .getInt(ItemIds.CANDY_DEFAULT);

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
