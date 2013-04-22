package com.basspro.scm.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import com.basspro.scm.item.SixCoreModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesSixCoreMod
{

    static ItemStack dyeStack = new ItemStack(Item.dyePowder, 1, 3);
    static ItemStack wheatStack = new ItemStack(Item.wheat);
    static ItemStack sugarStack = new ItemStack(Item.sugar);
    static ItemStack redappleStack = new ItemStack(Item.appleRed);
    static ItemStack cookedporkStack = new ItemStack(Item.porkCooked);
    static ItemStack cookedfishStack = new ItemStack(Item.fishCooked);
    static ItemStack breadStack = new ItemStack(Item.bread);
    static ItemStack glowdustStack = new ItemStack(Item.lightStoneDust);
    static ItemStack caramelStack = new ItemStack(SixCoreModItems.caramel);
    // ItemStack silverStack = new ItemStack(ingotSilver);
    static ItemStack emeraldStack = new ItemStack(Item.emerald);
    static ItemStack stickStack = new ItemStack(Item.stick);

    // ItemStack sapphireStack = new ItemStack(sapphire);
    // ItemStack rubyStack = new ItemStack(ruby);
    static ItemStack onyxStack = new ItemStack(SixCoreModItems.onyx);
    // ItemStack bronzeStack = new ItemStack(ingotBronze);

    public static void init()
    {

        /* Food recipes */
        GameRegistry.addRecipe(new ItemStack(SixCoreModItems.porkSandwich),
                "B", "P", "B", 'B', breadStack, 'P', cookedporkStack);
        GameRegistry.addRecipe(new ItemStack(SixCoreModItems.fishSandwich),
                "B", "F", "B", 'B', breadStack, 'F', cookedfishStack);
        GameRegistry.addRecipe(new ItemStack(SixCoreModItems.candy), "CCC",
                'C', dyeStack);
        GameRegistry.addRecipe(new ItemStack(SixCoreModItems.candy), "C", "C",
                "C", 'C', dyeStack);
        GameRegistry.addRecipe(new ItemStack(SixCoreModItems.caramelApple),
                " C ", "CAC", 'C', caramelStack, 'A', redappleStack);
        GameRegistry.addRecipe(new ItemStack(SixCoreModItems.applePie), "SAS",
                "WAW", "WWW", 'S', sugarStack, 'A', redappleStack, 'W',
                wheatStack);
        FurnaceRecipes.smelting().addSmelting(Item.bread.itemID,
                new ItemStack(SixCoreModItems.breadToast, 1), 0.5F);
        FurnaceRecipes.smelting().addSmelting(Item.sugar.itemID,
                new ItemStack(SixCoreModItems.caramel, 1), 0.1F);
        
        /* Tool Recipes */
        GameRegistry.addRecipe(new ItemStack(SixCoreModItems.onyxSword, 1), "O",
                "O", "S", 'O', onyxStack, 'S', stickStack);

    }

}
