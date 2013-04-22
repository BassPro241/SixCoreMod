package com.basspro.scm.item;

import net.minecraft.item.Item;

import com.basspro.scm.lib.ItemIds;
import com.basspro.scm.lib.Material;
import com.basspro.scm.lib.Strings;

public class SixCoreModItems
{

    // Food/Food related stuff initialization
    public static Item porkSandwich;
    public static Item fishSandwich;
    public static Item candy;
    public static Item breadToast;
    public static Item caramel;
    public static Item caramelApple;
    public static Item applePie;

    // Mineral Initialization
    public static Item onyx;
    public static Item sapphire;
    public static Item ruby;
    public static Item ingotBronze;
    public static Item ingotSilver;
    public static Item ingotPlatinum;
    
    // Tool Initialization
    public static Item onyxSword;

    public static void init()
    {

        /* Initialize each mod item individually */
        porkSandwich = new ItemFoodSandwich(ItemIds.PORK_SANDWICH, 8, 0.8F,
                false).setUnlocalizedName(Strings.PORK_SANDWICH_NAME);
        fishSandwich = new ItemFoodSandwich(ItemIds.FISH_SANDWICH, 8, 0.8F,
                false).setUnlocalizedName(Strings.FISH_SANDWICH_NAME);
        candy = new ItemFoodCandy(ItemIds.CANDY, 4, 0.6F, false);
        breadToast = new ItemFoodBreadToast(ItemIds.BREAD_TOAST, 6, 0.6F, false);
        caramel = new ItemCaramel(ItemIds.CARAMEL);
        caramelApple = new ItemFoodCaramelApple(ItemIds.CARAMEL_APPLE, 7, 0.4F,
                false);
        applePie = new ItemFoodApplePie(ItemIds.APPLE_PIE, 10, 1.0F, false);

        onyx = new ItemGem(ItemIds.ONYX).setUnlocalizedName(Strings.ONYX_NAME);
        
        onyxSword = new ItemGemSword(ItemIds.ONYX_SWORD, Material.ONYX_TOOL_MATERIAL).setUnlocalizedName("onyxSword");

    }

}
