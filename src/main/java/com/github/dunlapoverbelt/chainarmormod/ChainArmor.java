package com.github.dunlapoverbelt.chainarmormod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = ChainArmor.MODID, version = "@VERSION@", useMetadata = true,
                name                      = ChainArmor.NAME,
                acceptableRemoteVersions = "@CHANGE_VERSION@",
                acceptedMinecraftVersions = "@MC_VERSION@",
                acceptableSaveVersions = "@CHANGE_VERSION@",
                dependencies              = "required-after:Forge@[10.13.2.1230,)"
	)

public class ChainArmor
{
        public static final String MODID = "chainarmormod";
        public static final String NAME = "Chain Armor Mod";

	@SidedProxy(clientSide="com.github.dunlapoverbelt.chainarmormod.client.ClientProxy", serverSide="com.github.dunlapoverbelt.chainarmormod.CommonProxy")
		public static CommonProxy proxy;

	@Instance(value = MODID)
	public static ChainArmor instance;

	// setup ChainArmor Creative Inventory Tabs
	// Add ChainArmor Items Creative Tab
	public static CreativeTabs tabChainArmorItems = new CreativeTabs("tabChainArmorItems") {
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return Items.chainmail_chestplate; // Creative Tab Icon
	    	}
		};
	
	// Declare all mod item/block variables
	//Add chainArmorChainmail
	public static Item chainmail;
	// Add chainArmorIron_Nugget
	public static Item iron_nugget;
	//Add chainArmorIron_Ring
	public static Item iron_ring;
	

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	      	
	    	//Define Items
	        chainmail = new ChainArmorItem()
	        .setTextureName("chainarmormod:chainmail")
	        .setCreativeTab(ChainArmor.tabChainArmorItems)
	        .setUnlocalizedName("chainmail");

			iron_nugget = new ChainArmorItem()
			.setUnlocalizedName("iron_nugget")
			.setTextureName("chainarmormod:iron_nugget")
			.setCreativeTab(ChainArmor.tabChainArmorItems);
	        
	        iron_ring = new ChainArmorItem()
	        	.setUnlocalizedName("iron_ring")
	        	.setTextureName("chainarmormod:iron_ring")
	        	.setCreativeTab(ChainArmor.tabChainArmorItems);
	        
	        // Register Items
	        GameRegistry.registerItem(chainmail, "chainmail");
	        GameRegistry.registerItem(iron_nugget, "iron_nugget");
	        GameRegistry.registerItem(iron_ring, "iron_ring");
		}
	       
	@EventHandler
	public void load(FMLInitializationEvent event) {
	    	proxy.registerRenderers();
	                
	        //Define and Register Recipes
	        
	    	//Define Crafting Stacks
	    	ItemStack chainmailStack = new ItemStack(ChainArmor.chainmail);
	    	ItemStack iron_nuggetStack = new ItemStack(ChainArmor.iron_nugget);
	        ItemStack iron_ringStack = new ItemStack(ChainArmor.iron_ring);
	        
	        //Craft 9 Iron Nuggets from Iron Ingot
	        GameRegistry.addShapelessRecipe(new ItemStack(ChainArmor.iron_nugget, 9), new ItemStack(Items.iron_ingot));
	        //Craft 8 Iron rings from 4 Iron Nugget
	        GameRegistry.addShapedRecipe(new ItemStack(ChainArmor.iron_ring, 8), " x ", "x x", " x ",
	        		"x", iron_nuggetStack);
	        //Craft Iron Ingot from 9 Iron Nuggets
	        GameRegistry.addRecipe(new ItemStack(Items.iron_ingot), "xxx", "xxx", "xxx",
                    'x', iron_nuggetStack);
	        //Craft Chainmail from 9 Iron Rings
	        GameRegistry.addRecipe(new ItemStack(ChainArmor.chainmail), "xxx", "xxx", "xxx",
	        		'x', iron_ringStack);
	        //Craft 9 Iron Rings from Chainmail
	        GameRegistry.addShapelessRecipe(new ItemStack(ChainArmor.iron_ring, 9), new ItemStack(ChainArmor.chainmail));
	        //Craft Iron Nugget from 2 Iron Rings
	        GameRegistry.addRecipe(new ItemStack(ChainArmor.iron_nugget), "xx",
	        		'x', iron_ringStack);
	        //Craft Chainmail helmet
	        GameRegistry.addShapedRecipe(new ItemStack(Items.chainmail_helmet), "xxx", "x x",
	        		'x', chainmailStack);
	        //Craft Chainmail from Chainmail helmet
	        GameRegistry.addShapelessRecipe(new ItemStack(ChainArmor.chainmail, 5), new ItemStack(Items.chainmail_helmet));
	        //Craft Chainmail boots
	        GameRegistry.addShapedRecipe(new ItemStack(Items.chainmail_boots), "x x", "x x",
	        		'x', chainmailStack);
	        //Craft Chainmail from Chainmail boots
	        GameRegistry.addShapelessRecipe(new ItemStack(ChainArmor.chainmail, 4), new ItemStack(Items.chainmail_boots));
	        //Craft Chainmail chestplate
	        GameRegistry.addShapedRecipe(new ItemStack(Items.chainmail_chestplate), "x x", "xxx", "xxx",
	        		'x', chainmailStack);
	        //Craft Chainmail from Chainmail chestplate
	        GameRegistry.addShapelessRecipe(new ItemStack(ChainArmor.chainmail, 8), new ItemStack(Items.chainmail_chestplate));
	        //Craft Chainmail leggings
	        GameRegistry.addShapedRecipe(new ItemStack(Items.chainmail_leggings), "xxx", "x x", "x x",
	        		'x', chainmailStack);
	        //Craft Chainmail from Chainmail leggings
	        GameRegistry.addShapelessRecipe(new ItemStack(ChainArmor.chainmail, 7), new ItemStack(Items.chainmail_leggings));
	        }
	       
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
		}
}