package com.basspro.scm.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.basspro.scm.item.SixCoreModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesSixCoreMod {

    static ItemStack dyeStack = new ItemStack(Item.dyePowder, 1, 3);
    static ItemStack wheatStack = new ItemStack(Item.wheat);
    static ItemStack sugarStack = new ItemStack(Item.sugar);
    static ItemStack redappleStack = new ItemStack(Item.appleRed);
    static ItemStack cookedporkStack = new ItemStack(Item.porkCooked);
    static ItemStack cookedfishStack = new ItemStack(Item.fishCooked);
    static ItemStack breadStack = new ItemStack(Item.bread);
    static ItemStack glowdustStack = new ItemStack(Item.lightStoneDust);
    // ItemStack caramelStack = new ItemStack(caramel);
    // ItemStack silverStack = new ItemStack(ingotSilver);
    static ItemStack emeraldStack = new ItemStack(Item.emerald);
    static ItemStack stickStack = new ItemStack(Item.stick);

    // ItemStack sapphireStack = new ItemStack(sapphire);
    // ItemStack rubyStack = new ItemStack(ruby);
    // ItemStack onyxStack = new ItemStack(ingotOnyx);
    // ItemStack bronzeStack = new ItemStack(ingotBronze);

    public static void init() {

        GameRegistry.addRecipe(new ItemStack(SixCoreModItems.porkSandwich), "B", "P", "B", 'B',
                breadStack, 'P', cookedporkStack);
        GameRegistry.addRecipe(new ItemStack(SixCoreModItems.fishSandwich), "B", "F", "B", 'B',
                breadStack, 'F', cookedfishStack);

    }

}
