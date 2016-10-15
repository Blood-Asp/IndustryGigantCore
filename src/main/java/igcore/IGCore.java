package igcore;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.command.server.CommandBlockLogic;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;
import tconstruct.library.crafting.FluidType;
import tconstruct.world.TinkerWorld;

import java.io.File;
import java.util.HashSet;

import Reika.DragonAPI.Auxiliary.Trackers.PlayerHandler;
import Reika.RotaryCraft.Auxiliary.ItemStacks;
import Reika.RotaryCraft.Auxiliary.RecipeManagers.WorktableRecipes;
import Reika.RotaryCraft.Registry.ConfigRegistry;
import Reika.RotaryCraft.Registry.ItemRegistry;
import Reika.RotaryCraft.Registry.RotaryAchievements;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.TickEvent.WorldTickEvent;
import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicMachine_GT_Recipe;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Recipe.GT_Recipe_Map;
import gregtech.api.util.GT_Recipe.GT_Recipe_Map_Fuel;
import gregtech.api.util.GT_Utility;
import igcore.world.WorldProviderDefaultVoid;
import igcore.world.WorldProviderEndVoid;
import igcore.world.WorldProviderHellVoid;
import info.loenwind.waterhooks.WaterFormEvent;
import io.netty.buffer.ByteBuf;

import static gregtech.api.enums.GT_Values.*;


@Mod(modid = IGCore.MODID, version = IGCore.VERSION, dependencies="required-after:IC2; required-after:gregtech; required-after:Magneticraft; required-after:ImmersiveEngineering; required-after:ReactorCraft; required-after:waterhooks; required-after:TConstruct")
public class IGCore
{
    public static final String MODID = "IGCore";
    public static final String VERSION = "0.2.1";
    
    public static final GT_Recipe_Map sTraderRecipes = new GT_Recipe_Map(new HashSet<GT_Recipe>(1000), "gt.recipe.trader", "Trader", null, RES_PATH_GUI + "basicmachines/Default", 6, 6, 0, 0, 1, E, 1, E, true, true);
    public static final GT_Recipe_Map_Fuel sEnergyTradeFuels = new GT_Recipe_Map_Fuel(new HashSet<GT_Recipe>(10), "gt.recipe.energytrade", "Energy Trade", null, RES_PATH_GUI + "basicmachines/Default", 1, 1, 0, 0, 1, "Fuel Value: ", 1000, " EU", true, true);
    public static Configuration tConfig;
    public static boolean voidOverworld = false;
    public static boolean autoUpdateQuest = true;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	File tFile = new File(new File(event.getModConfigurationDirectory(), "GregTech"), "IGCore.cfg");
    	tConfig = new Configuration(tFile);
    	tConfig.load();
    	voidOverworld = tConfig.get("general", "GenerateVoidOverworld", false).getBoolean(false);
    	autoUpdateQuest = tConfig.get("general", "AutoUpdateQuest", true).getBoolean(true);
    	if(voidOverworld){
    		ForgeModContainer.defaultHasSpawnFuzz = false;
    	}
    	
    	Util.init();
    	new GT_MetaGenerated_Item_04();
    	
    	MinecraftForge.TERRAIN_GEN_BUS.register(this);
    	MinecraftForge.EVENT_BUS.register(this);
    	FMLCommonHandler.instance().bus().register(this);
    	
    	ItemListIG.Machine_LV_Trader.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(8000, "basicmachine.trader.tier.01", "Basic Trader", 1, "Buy and Sell stuff", sTraderRecipes, 6, 6, 64000, 0, 1, "Default.png", (String) GregTech_API.sSoundList.get(Integer.valueOf(212)), false, false, 0, "ASSEMBLER", null).getStackForm(1L));
    	ItemListIG.Machine_MV_Trader.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(8001, "basicmachine.trader.tier.02", "Good Trader", 2, "Buy and Sell stuff", sTraderRecipes, 6, 6, 64000, 0, 1, "Default.png", (String) GregTech_API.sSoundList.get(Integer.valueOf(212)), false, false, 0, "ASSEMBLER", null).getStackForm(1L));
    	ItemListIG.Machine_HV_Trader.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(8002, "basicmachine.trader.tier.03", "Good Trader II", 3, "Buy and Sell stuff", sTraderRecipes, 6, 6, 64000, 0, 1, "Default.png", (String) GregTech_API.sSoundList.get(Integer.valueOf(212)), false, false, 0, "ASSEMBLER", null).getStackForm(1L));
    	ItemListIG.Machine_EV_Trader.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(8003, "basicmachine.trader.tier.04", "Advanced Trader", 4, "Buy and Sell stuff", sTraderRecipes, 6, 6, 64000, 0, 1, "Default.png", (String) GregTech_API.sSoundList.get(Integer.valueOf(212)), false, false, 0, "ASSEMBLER", null).getStackForm(1L));
    	ItemListIG.Machine_IV_Trader.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(8004, "basicmachine.trader.tier.05", "Advanced Trader II", 5, "Buy and Sell stuff", sTraderRecipes, 6, 6, 64000, 0, 1, "Default.png", (String) GregTech_API.sSoundList.get(Integer.valueOf(212)), false, false, 0, "ASSEMBLER", null).getStackForm(1L));
    	ItemListIG.Machine_LuV_Trader.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(8005, "basicmachine.trader.tier.06", "Extreme Trader", 6, "Buy and Sell stuff", sTraderRecipes, 6, 6, 64000, 0, 1, "Default.png", (String) GregTech_API.sSoundList.get(Integer.valueOf(212)), false, false, 0, "ASSEMBLER", null).getStackForm(1L));
    	ItemListIG.Machine_ZPMV_Trader.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(8006,"basicmachine.trader.tier.07", "Extreme Trader II", 7, "Buy and Sell stuff", sTraderRecipes, 6, 6, 64000, 0, 1, "Default.png", (String) GregTech_API.sSoundList.get(Integer.valueOf(212)), false, false, 0, "ASSEMBLER", null).getStackForm(1L));
    	ItemListIG.Machine_UV_Trader.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(8007, "basicmachine.trader.tier.08", "Ultimate Trader", 8, "Buy and Sell stuff", sTraderRecipes, 6, 6, 64000, 0, 1, "Default.png", (String) GregTech_API.sSoundList.get(Integer.valueOf(212)), false, false, 0, "ASSEMBLER", null).getStackForm(1L));

    	ItemListIG.Generator_EnergyTrade_LV.set(new GT_Energy_Trader(8010, "basicgenerator.trade.tier.01", "Basic Energy Trader", 1).getStackForm(1L));
    	ItemListIG.Generator_EnergyTrade_MV.set(new GT_Energy_Trader(8011, "basicgenerator.trade.tier.02", "Good Energy Trader", 2).getStackForm(1L));
    	ItemListIG.Generator_EnergyTrade_HV.set(new GT_Energy_Trader(8012, "basicgenerator.trade.tier.03", "Good Energy Trader II", 3).getStackForm(1L));
    	ItemListIG.Generator_EnergyTrade_EV.set(new GT_Energy_Trader(8013, "basicgenerator.trade.tier.04", "Advanced Energy Trader", 4).getStackForm(1L));
    	ItemListIG.Generator_EnergyTrade_IV.set(new GT_Energy_Trader(8014, "basicgenerator.trade.tier.05", "Advanced Energy Trader II", 5).getStackForm(1L));
    	ItemListIG.Generator_EnergyTrade_LuV.set(new GT_Energy_Trader(8015, "basicgenerator.trade.tier.06", "Extreme Energy Trader", 6).getStackForm(1L));
    	ItemListIG.Generator_EnergyTrade_ZPMV.set(new GT_Energy_Trader(8016,"basicgenerator.trade.tier.07", "Extreme Energy Trader II", 7).getStackForm(1L));
    	ItemListIG.Generator_EnergyTrade_UV.set(new GT_Energy_Trader(8017, "basicgenerator.trade.tier.08", "Ultimate Energy Trader", 8).getStackForm(1L));    

    	GT_OreDictUnificator.set(OrePrefixes.block, Materials.Steel, GT_ModHandler.getModItem("ImmersiveEngineering", "storage", 1, 7));
    	RoCChanges.onPreLoad();
    	TinkersChanges.load();
    	tConfig.save();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {   RoCChanges.onInit();
    	if (voidOverworld){
			DimensionManager.unregisterProviderType(0);
			DimensionManager.registerProviderType(0, WorldProviderDefaultVoid.class, true);}
			DimensionManager.unregisterProviderType(-1);
			DimensionManager.registerProviderType(-1, WorldProviderHellVoid.class, true);	
			DimensionManager.unregisterProviderType(1);
			DimensionManager.registerProviderType(1, WorldProviderEndVoid.class, true);  

     }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	Recipes.init();
    	MagneticraftChanges.load();
    	ImmEngChanges.load();
    	RoCChanges.load();
//        ArrayList<ItemStack> stacks = new ArrayList();
//        Item i = GameRegistry.findItem("ForgeMicroblock", "microblock");
//        for (ItemStack s : buildStackList(new ItemStack(i), new int[]{1, 2, 4, 257, 258, 260, 513, 514, 516, 769, 770, 772})) {
//          try
//          {
//            stacks.add((ItemStack)i.getClass().getDeclaredMethod("create", new Class[] { Integer.TYPE, String.class }).invoke(null, new Object[] { s.getItemDamage(), MicroMaterialRegistry.materialName(new Random().nextInt(20)) }));
//          }
//          catch (Throwable t)
//          {
//            t.printStackTrace();
//          }
//        }
//        API.setItemListEntries(i, stacks);
    } 
    
//    public static ArrayList<ItemStack> buildStackList(ItemStack stack, int[] metas)
//    {
//      ArrayList<ItemStack> stacks = new ArrayList();
//      for (int i : metas) {
//        stacks.add(new ItemStack(stack.getItem(), 1, i));
//      }
//      return stacks;
//    }
    
    @EventHandler
    public void loadComplete(FMLLoadCompleteEvent event)
    {
    	RoCChanges.loadcomplete();
    	Recipes.postLoad();
    	TinkersChanges.loadComplete();
    	GT_ModHandler.removeRecipeByOutput(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 4));
    	GT_ModHandler.removeRecipeByOutput(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4));
    	GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("progressiveautomation", "CobbleUpgrade", 1));
    } 
    
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void caveControl(InitMapGenEvent ev) {
		switch(ev.type) {
			case STRONGHOLD:
				ev.setResult(Result.DENY);
				break;
			default:
				break;
		}
	}
	
	@SubscribeEvent
	public void loadLoot (LivingDropsEvent event) {
		if(event.entity instanceof EntitySpider || 
				event.entity instanceof EntityCreeper || 
				event.entity instanceof EntityEnderman || 
				event.entity instanceof EntityGhast ||  
				event.entity instanceof EntityBlaze || 
				event.entity instanceof EntityMagmaCube || 
				event.entity instanceof EntitySlime || 
				event.entity instanceof EntityWitch ||
				event.entity instanceof EntityZombie ||
				event.entity instanceof EntityPigZombie ||
				event.entity instanceof EntitySkeleton ||
				event.entity instanceof EntityIronGolem){
			event.drops.clear();
		}
	}
	
    @SubscribeEvent
    public void onWaterForming(WaterFormEvent event)
    {
    	BiomeGenBase tBiome = event.world.getBiomeGenForCoords(event.x, event.z);
        if (tBiome == BiomeGenBase.beach || 
        	tBiome == BiomeGenBase.coldBeach || 
        	tBiome == BiomeGenBase.deepOcean || 
        	tBiome == BiomeGenBase.frozenOcean || 
        	tBiome == BiomeGenBase.frozenRiver || 
        	tBiome == BiomeGenBase.ocean || 
        	tBiome == BiomeGenBase.river || 
        	tBiome == BiomeGenBase.swampland) {            
          }else{event.setCanceled(true);}
}
    
    @SubscribeEvent
    public void onItemPickup(EntityItemPickupEvent event){
    	if(event==null||event.entityPlayer==null||event.item.getEntityItem()==null){return;}
    	if(GT_Utility.areStacksEqual(event.item.getEntityItem(),ItemStacks.steelingot)){
    		RotaryAchievements.MAKESTEEL.triggerAchievement(event.entityPlayer);
    	}
    }
    
    @SubscribeEvent
    public void onOreRegisterEvent(OreRegisterEvent event){
    	if((event.Name.equals("dustAluminium")||event.Name.equals("dustAluminum"))&&event.Ore.getUnlocalizedName().equals("TConstruct:materials"))
    	event.setCanceled(true);
    }
    
    boolean firstTick = true;
    @SubscribeEvent
    public void onWorldTickEvent(WorldTickEvent event){
    	if(firstTick){
    		firstTick = false;
    		if(!event.world.isRemote && autoUpdateQuest){
    			BQCommandSender cmdSender = new BQCommandSender(event.world, 0, 100, 0);    			
    			MinecraftServer.getServer().getCommandManager().executeCommand(cmdSender, "/bq_admin default load");
    		}
    		
    	}
    }
    
    @SubscribeEvent
	public void firstJoin(PlayerLoggedInEvent event) {
	      EntityPlayer player = event.player;
	      NBTTagCompound entityData = player.getEntityData();
	      if(voidOverworld && !entityData.getBoolean("joinedBefore")) {
	         entityData.setBoolean("joinedBefore", true);
	         player.inventory.addItemStackToInventory(new ItemStack(Blocks.cobblestone,64));
	         player.inventory.addItemStackToInventory(new ItemStack(Blocks.dirt,1));
	         player.inventory.addItemStackToInventory(new ItemStack(Blocks.sapling,1));
	         player.inventory.addItemStackToInventory(new ItemStack(Items.bone,16));
	         player.inventory.addItemStackToInventory(new ItemStack(Blocks.torch,64));
	         player.inventory.addItemStackToInventory(new ItemStack(Items.bread,16));
	         player.inventory.addItemStackToInventory(ItemList.Credit_Greg_Silver.get(4, null));
	         event.player.setPositionAndUpdate(8.0, 65.0, 8.0);
	      }
	   }
    
	public static class BQCommandSender extends CommandBlockLogic
	{
		World world;
		ChunkCoordinates blockLoc;
		
		public BQCommandSender(World world, int x, int y, int z)
	    {
	    	blockLoc = new ChunkCoordinates(x, y, z);
	    	this.world = world;
	    }
		
		@Override
		public ChunkCoordinates getPlayerCoordinates()
		{
			return blockLoc;
		}
		
		@Override
		public World getEntityWorld()
		{
			return world;
		}
		
		@Override
		public void func_145756_e(){}
		
		@Override
		public int func_145751_f()
		{
			return 0;
		}
		
		@Override
		public void func_145757_a(ByteBuf p_145757_1_){}
	    
	    @Override
	    public String getCommandSenderName()
	    {
	        return "IGCore";
	    }
}
    
}
