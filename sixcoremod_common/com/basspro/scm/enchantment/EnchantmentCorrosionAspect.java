package com.basspro.scm.enchantment;

import com.basspro.scm.lib.Strings;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentCorrosionAspect extends Enchantment
{
    protected EnchantmentCorrosionAspect(int par1, int par2)
    {
        super(par1, par2, EnumEnchantmentType.weapon);
        this.setName(Strings.CORROSION_ASPECT_NAME);
    }

    /*
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int par1)
    {
        return 10 + 20 * (par1 - 1);
    }

    /*
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int par1)
    {
        return super.getMinEnchantability(par1) + 50;
    }

    /*
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel()
    {
        return 2;
    }

}
