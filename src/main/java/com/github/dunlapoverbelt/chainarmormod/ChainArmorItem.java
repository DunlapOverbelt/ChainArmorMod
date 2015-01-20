package com.github.dunlapoverbelt.chainarmormod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ChainArmorItem extends Item {
	
	public ChainArmorItem() {
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("chainArmorItem");
	}
}