package com.generic;

// This Import list will grow longer with each additional tutorial.
// It's not pruned between full class postings, unlike other tutorial code.
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="Generic", name="Minekawaii", version="1.2.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Generic {
        
        
        @Instance("Generic")
        public static Generic instance;
        public static CreativeTabs tabCustom = new CreativeTabs("tabCustom") {
            public ItemStack getIconItemStack() {
                    return new ItemStack(sushiRoll, 1, 0);
            }
    };
       //public final static Item genericIngot = new ItemHookShotCartridge(5001).setCreativeTab(CreativeTabs.tabMisc).setMaxStackSize(16).setUnlocalizedName("Strawbery Pocky");
       //Generate POCKY.  This gives you ONE HEART
        public final static Item eatPockStraw = new ramune(5002, 2, 0.6F, false, "generic:pockyz").setCreativeTab(tabCustom).setMaxStackSize(8).setUnlocalizedName("Strawberry Pocky");
        public final static Item eatPockStrawChoc = new ramune(5003, 2, 0.6F, false, "generic:chocpocky").setCreativeTab(tabCustom).setMaxStackSize(8).setUnlocalizedName("Chocolate Pocky");
       public final static Item eatPockStrawTea = new ramune(5007, 2, 0.6F, false, "generic:pocky_tea").setCreativeTab(tabCustom).setMaxStackSize(8).setUnlocalizedName("Green Tea Pocky");
       public final static Item eatPockStrawRedstone = new ramune(5008, 2, 0.6F, false, "generic:pocky_redstone").setCreativeTab(tabCustom).setMaxStackSize(8).setUnlocalizedName("Redstone Pocky!");
       public final static Item eatPockStrawAlm = new ramune(5009, 2, 0.6F, false, "generic:almpocky").setCreativeTab(tabCustom).setMaxStackSize(8).setUnlocalizedName("Almond Pocky");
       //Magic Japan Glass
        public final static Block magicJapanBlock = new ModzBlock(501, Material.glass, false).setLightValue(1.0F).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("Magic Japan Glass");
      //Tabs
    
       @SidedProxy(clientSide="com.generic.client.ClientProxy",
                        serverSide="com.generic.CommonProxy")
        public static CommonProxy proxy;
        //Ramune.  One Heart
        public final static Item ramunePlain = new ramune(5012, 2, 0.6F, false, "generic:ramune_plain").setCreativeTab(tabCustom).setUnlocalizedName("Original Ramune");
       //Rice Bowl, Two Hearts.
        public final static Item riceBowl = new ramune(5010, 4, 0.6F, false, "generic:ricebowl").setUnlocalizedName("Rice Bowl").setCreativeTab(tabCustom);
        //Sushi Roll, fairly expensive, 3 hearts.
 
       public final static Item sushiRoll =  new ramune(5011, 6, 0.6F, false,"generic:sushiroll").setUnlocalizedName("Sushi Roll").setCreativeTab(tabCustom);
     
 
        //Hot Water Bottle
        public final static Item hotWater = new ramune(5013, 0, 0.6F, false, "generic:water_hot").setUnlocalizedName("Hot Water Bottle");
       //Dry Noodles.  Does one half heart
        public final static Item dryNoodles = new ramune(5014, 1, 0.6F, false, "generic:drynoodles").setUnlocalizedName("Dry Ramen Noodles").setCreativeTab(tabCustom);
        //Cooked Noodles. Does 2.5 hearts
        public final static Item cookedNoodles = new ramune(5015, 5, 0.6F, false, "generic:cookednoodles").setUnlocalizedName("Cooked Ramen Noodles").setCreativeTab(tabCustom);
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Methodh
        }
        
        @Init
       
        public void load(FMLInitializationEvent event) {
       
        	LanguageRegistry.instance().addStringLocalization("itemGroup.tabCustom", "en_US", "Japanese Food");
                //LanguageRegistry.addName(genericIngot, "Strawberry Pocky");
                LanguageRegistry.addName(eatPockStraw, "Strawberry Pocky");
                LanguageRegistry.addName(eatPockStrawChoc, "Chocolate Pocky");
                LanguageRegistry.addName(ramunePlain, "Original Ramune");
                LanguageRegistry.addName(eatPockStrawTea, "Green Tea Pocky");
                LanguageRegistry.addName(eatPockStrawRedstone, "Redstone Pocky!");
                LanguageRegistry.addName(riceBowl, "Rice Bowl");
                LanguageRegistry.addName(magicJapanBlock, "Magic Japan Glass");
                LanguageRegistry.addName(sushiRoll, "Sushi Roll");
                LanguageRegistry.addName(eatPockStrawAlm, "Almond Pocky");
                LanguageRegistry.addName(hotWater, "Hot Water Bottle");
                LanguageRegistry.addName(dryNoodles, "Dry Ramen Noodles");
                LanguageRegistry.addName(cookedNoodles, "Cooked Ramen Noodles");
                MinecraftForge.setBlockHarvestLevel(magicJapanBlock, "pickaxe", 3);
                GameRegistry.registerBlock(magicJapanBlock, "Magic Japan Glass");
                
                // End Basic Blocks
                
                //Tab
                
                //CRAFTING
                //Ramune Crafting
                ItemStack spS = new ItemStack(ramunePlain, 1);
//Stacks
               ItemStack sugarStack = new ItemStack(353, 3, 0);
               ItemStack beanStack = new ItemStack(Item.dyePowder, 1, 3);
               ItemStack bottleStack  = new ItemStack(373, 3, 0);
               ItemStack cookieStack  = new ItemStack(357, 3, 0);
               ItemStack redstoneStacki  = new ItemStack(331, 3, 0);
               ItemStack redstoneStack = new ItemStack(eatPockStrawRedstone, 8);
               ItemStack rbStack = new ItemStack(riceBowl, 1);
               ItemStack sushiStack = new ItemStack(sushiRoll, 2);
               
               ItemStack fishStack = new ItemStack(349, 3, 0);
               ItemStack hotwaterStack = new ItemStack(hotWater, 1);
               ItemStack dryNoodleStack = new ItemStack(dryNoodles, 1);
               ItemStack cookedNoodleStack = new ItemStack(cookedNoodles, 1);
               //Noodle Recipe
               GameRegistry.addRecipe(dryNoodleStack, "xxx", "xmx", "mmm", 'm', Item.wheat);
               GameRegistry.addRecipe(cookedNoodleStack, "xxx", "xix", "xmx", 'i', hotwaterStack, 'm', dryNoodleStack);
               
               
               GameRegistry.addRecipe(redstoneStack, "inx", "xmx","xmx", 'n', sugarStack, 'm', cookieStack, 'i', redstoneStacki);
               //Recipe
                GameRegistry.addRecipe(spS, "xax", "xbx", "xcx",
                        'b', sugarStack, 'c', bottleStack);
                
                //Strawberry Pocky
                ItemStack strawPock = new ItemStack(eatPockStraw, 8);
                GameRegistry.addRecipe(strawPock, "xnx", "xmx","xmx", 'n', sugarStack, 'm', cookieStack);
                //Chocolate Pocky
                ItemStack chocPock = new ItemStack(eatPockStrawChoc, 8);
                GameRegistry.addRecipe(chocPock, "inx", "xmx","xmx", 'n', sugarStack, 'm', cookieStack, 'i', beanStack);
                ItemStack teaPock = new ItemStack(eatPockStrawTea, 8);
                ItemStack leaves = new ItemStack(Block.leaves, 1);
                ItemStack almPock = new ItemStack(eatPockStrawAlm, 8);
                GameRegistry.addRecipe(almPock, "inx", "xmx", "xmx", 'n', sugarStack, 'm', cookieStack, 'i', sugarStack);
                //Sushi Rolls
                GameRegistry.addRecipe(teaPock, "inx", "xmx", "xmx", 'n', sugarStack, 'm', cookieStack, 'i', leaves);
                GameRegistry.addRecipe(sushiStack, "xxx", "xfx", "rrr", 'f', fishStack, 'r', rbStack);
                proxy.registerRenderers();
                
                //Cooking/Smelting
                GameRegistry.addSmelting(Item.wheat.itemID, rbStack, 0.1f);
             GameRegistry.addSmelting(bottleStack.itemID, hotwaterStack, 0.1f);

        }
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}