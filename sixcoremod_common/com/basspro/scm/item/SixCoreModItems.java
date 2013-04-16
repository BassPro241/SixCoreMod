package com.basspro.scm.item;

import net.minecraft.item.Item;

import com.basspro.scm.lib.ItemIds;
import com.basspro.scm.lib.Strings;

public class SixCoreModItems
{

    public static Item porkSandwich;
    public static Item fishSandwich;

    public static void init()
    {

        /* Initialize each mod item individually */
        porkSandwich = new ItemFoodSandwich(ItemIds.PORK_SANDWICH_DEFAULT, 8, 0.8F,
                false).setUnlocalizedName(Strings.PORK_SANDWICH_NAME);
        fishSandwich = new ItemFoodSandwich(ItemIds.FISH_SANDWICH_DEFAULT, 8, 0.8F,
                false).setUnlocalizedName(Strings.FISH_SANDWICH_NAME);
    }

}
