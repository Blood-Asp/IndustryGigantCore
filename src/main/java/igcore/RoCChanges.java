package igcore;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import Reika.DragonAPI.Instantiable.Data.Maps.FluidHashMap;
import Reika.DragonAPI.Instantiable.Data.Maps.ItemHashMap;
import Reika.DragonAPI.Libraries.Registry.ReikaOreHelper;
import Reika.DragonAPI.ModRegistry.ModOreList;
import Reika.ReactorCraft.ReactorCraft;
import Reika.ReactorCraft.Auxiliary.ReactorStacks;
import Reika.ReactorCraft.Registry.CraftingItems;
import Reika.ReactorCraft.Registry.FluoriteTypes;
import Reika.ReactorCraft.Registry.ReactorBlocks;
import Reika.ReactorCraft.Registry.ReactorItems;
import Reika.RotaryCraft.Auxiliary.ItemStacks;
import Reika.RotaryCraft.Auxiliary.RecipeManagers.ExtractorModOres;
import Reika.RotaryCraft.Auxiliary.RecipeManagers.RecipesBlastFurnace;
import Reika.RotaryCraft.Auxiliary.RecipeManagers.RecipesDryingBed;
import Reika.RotaryCraft.Auxiliary.RecipeManagers.RecipesBlastFurnace.BlastFurnacePattern;
import Reika.RotaryCraft.Auxiliary.RecipeManagers.RecipesBlastFurnace.BlastRecipe;
import Reika.RotaryCraft.Auxiliary.RecipeManagers.RecipesExtractor;
import Reika.RotaryCraft.Auxiliary.RecipeManagers.RecipesFrictionHeater;
import Reika.RotaryCraft.Auxiliary.RecipeManagers.RecipesFrictionHeater.FrictionRecipe;
import Reika.RotaryCraft.Auxiliary.RecipeManagers.RecipesGrinder;
import Reika.RotaryCraft.Auxiliary.RecipeManagers.WorktableRecipes;
import Reika.RotaryCraft.Auxiliary.RecipeManagers.WorktableRecipes.WorktableRecipe;
import Reika.RotaryCraft.ModInterface.NEI.FrictionHandler.FrictionHeaterRecipe;
import Reika.RotaryCraft.Registry.EngineType;
import Reika.RotaryCraft.Registry.ItemRegistry;
import Reika.RotaryCraft.Registry.MachineRegistry;
import blusunrize.immersiveengineering.api.crafting.ArcFurnaceRecipe;
import blusunrize.immersiveengineering.api.crafting.BlastFurnaceRecipe;
import gregtech.GT_Mod;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OreDictNames;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_RecipeRegistrator;
import gregtech.api.util.GT_Utility;
import gregtech.common.GT_RecipeAdder;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class RoCChanges {
	public static void onPreLoad(){   
//		Add HSLA oredict tags, generate recipes with GT
    	GT_OreDictUnificator.set(OrePrefixes.ingot, Materials.HSLA, ItemStacks.steelingot);
    	GT_OreDictUnificator.set(OrePrefixes.block, Materials.HSLA, ItemStacks.steelblock);
    	GT_OreDictUnificator.set(OrePrefixes.gearGt, Materials.HSLA, ItemStacks.steelgear);
    	GT_OreDictUnificator.set(OrePrefixes.gear, Materials.HSLA, ItemStacks.steelgear);
    	GT_OreDictUnificator.set(OrePrefixes.stick, Materials.HSLA, ItemStacks.shaftitem);
    	GT_OreDictUnificator.set(OrePrefixes.round, Materials.HSLA, ItemStacks.ballbearing);
    	GT_OreDictUnificator.set(OrePrefixes.plate, Materials.HSLA, ItemStacks.basepanel);
    	GT_OreDictUnificator.set(OrePrefixes.dust, Materials.Wheat, ItemStacks.flour);
	}
	
	public static void onInit(){
//		remove default RoC recipes for items
    	GT_ModHandler.removeRecipeByOutput(ItemStacks.shaftitem);
    	GT_ModHandler.removeRecipeByOutput(ItemStacks.steelblock);
    	GT_ModHandler.removeRecipeByOutput(ItemStacks.steelgear);
    	GT_ModHandler.removeRecipeByOutput(ItemStacks.ballbearing);
    	GT_ModHandler.removeRecipeByOutput(ItemStacks.basepanel);
//    	Unify RoC flour with GT
    	GT_ModHandler.removeFurnaceSmelting(new ItemStack(Items.bread));
	}
	
	public static void load() {
		List<BlastFurnacePattern> bRecipes = (List<BlastFurnacePattern>) RecipesBlastFurnace.getRecipes().getAllRecipes();
	for (int i = 0; i < bRecipes.size(); i++) {
//		Remove HSLA Ingots/CoalCoke/SiliconDust from RoC Blast Furnace
		if (GT_Utility.areStacksEqual(bRecipes.get(i).outputItem(), ItemStacks.steelingot) ||
			GT_Utility.areStacksEqual(bRecipes.get(i).outputItem(), ItemStacks.coke)	||
			GT_Utility.areStacksEqual(bRecipes.get(i).outputItem(), ItemStacks.silicondust)) {
			try {
				Method tMethod = RecipesBlastFurnace.class.getDeclaredMethod("removeRecipe",
						BlastFurnacePattern.class.getInterfaces());
				tMethod.setAccessible(true);
				tMethod.invoke(RecipesBlastFurnace.getRecipes(), bRecipes.get(i));
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
//	Add GT HSLA Recipes
	GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSLA, 7), new Object[]{OrePrefixes.dust.get(Materials.Iron),OrePrefixes.dust.get(Materials.Iron),OrePrefixes.dust.get(Materials.Iron),OrePrefixes.dust.get(Materials.Iron),OrePrefixes.dust.get(Materials.Iron),OrePrefixes.dust.get(Materials.Iron),OrePrefixes.dust.get(Materials.Coal),OrePrefixes.dustTiny.get(Materials.Manganese),OrePrefixes.dustSmall.get(Materials.Vanadium)});
	GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSLA, 6), new Object[]{OrePrefixes.dust.get(Materials.Iron),OrePrefixes.dust.get(Materials.Iron),OrePrefixes.dust.get(Materials.Iron),OrePrefixes.dust.get(Materials.Iron),OrePrefixes.dustSmall.get(Materials.Carbon),OrePrefixes.dustSmall.get(Materials.Silicon), OrePrefixes.dustTiny.get(Materials.Manganese),OrePrefixes.dustSmall.get(Materials.Vanadium),OrePrefixes.dustTiny.get(Materials.Niobium)});
//	Add ImmEng Arc Furnace HSLA Recipe
	GT_ModHandler.addShapelessCraftingRecipe(ItemListIG.HSLABlent.get(7, null), new Object[]{OrePrefixes.dust.get(Materials.Coal),OrePrefixes.dustSmall.get(Materials.Silicon),OrePrefixes.dustSmall.get(Materials.Manganese),OrePrefixes.dustSmall.get(Materials.Vanadium)});
	GT_ModHandler.addShapelessCraftingRecipe(ItemListIG.HSLABlent.get(9, null), new Object[]{OrePrefixes.dustSmall.get(Materials.Carbon),OrePrefixes.dustSmall.get(Materials.Silicon),OrePrefixes.dustTiny.get(Materials.Manganese),OrePrefixes.dustSmall.get(Materials.Vanadium),OrePrefixes.dustTiny.get(Materials.Niobium)});
	GT_ModHandler.addShapelessCraftingRecipe(ItemListIG.HSLABlent.get(14, null), new Object[]{OrePrefixes.dustSmall.get(Materials.Carbon),OrePrefixes.dustSmall.get(Materials.Carbon),OrePrefixes.dustSmall.get(Materials.Silicon),OrePrefixes.dustTiny.get(Materials.Manganese),OrePrefixes.dustSmall.get(Materials.Vanadium),OrePrefixes.dustTiny.get(Materials.Niobium),OrePrefixes.dustTiny.get(Materials.Titanium)});
	GT_ModHandler.addShapelessCraftingRecipe(ItemListIG.HSLABlent.get(20, null), new Object[]{OrePrefixes.dustSmall.get(Materials.Carbon),OrePrefixes.dustSmall.get(Materials.Carbon),OrePrefixes.dustSmall.get(Materials.Silicon),OrePrefixes.dustSmall.get(Materials.Carbon),OrePrefixes.dustTiny.get(Materials.Manganese),OrePrefixes.dustSmall.get(Materials.Vanadium),OrePrefixes.dustTiny.get(Materials.Chrome),OrePrefixes.dustTiny.get(Materials.Molybdenum),OrePrefixes.dustTiny.get(Materials.Titanium)});
	ArcFurnaceRecipe.addRecipe(ItemStacks.steelingot, "ingotIron",null, 200, 2048, ItemListIG.HSLABlent.get(1, null) );
	ArcFurnaceRecipe.addRecipe(ItemStacks.steelblock, "blockIron",null, 1400, 2048, ItemListIG.HSLABlent.get(7, null) );
	
//	Add GT -> RoC SiliconDust conversion
	GT_ModHandler.addShapelessCraftingRecipe(ItemStacks.silicondust, new Object[]{OrePrefixes.dust.get(Materials.Silicon)});
	
//	Fractionation unit recipe replace gold with stainless steel
	replaceRecipeRoC(MachineRegistry.FRACTIONATOR.getCraftedProduct(), new Object[]{"GFG", "GIG", "GPG", 'P', ItemStacks.basepanel, 'I', ItemStacks.mixer, 'G', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1), 'F', ItemStacks.fuelline});
		
//	Gasoline Engine recipe replace gold with annealed copper
	replaceRecipeRoC(MachineRegistry.ENGINE.getCraftedMetadataProduct(EngineType.GAS.ordinal()), new Object[] { "CgC", "SGs", "PIP", 'g', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1), 'S', ItemStacks.igniter, 'I', ItemStacks.impeller, 'P', ItemStacks.basepanel, 's', ItemStacks.shaftitem, 'G', ItemStacks.gearunit, 'C', ItemStacks.cylinder });

//	Add an Indium Source//Ammonium source//fluorite for void world option
	GT_Values.RA.addElectrolyzerRecipe(GT_OreDictUnificator.get(OrePrefixes.crushedCentrifuged, Materials.Sphalerite, 1), GT_Values.NI, GT_Values.NF, GT_Values.NF,
	GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sphalerite, 1), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 1), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cadmium, 1), 
	GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zinc, 1), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 1),new int[]{10000,2000,1500,1500,1500,1000}, 1400, 48);	
//	ReactorStacks.ammonium; //Can be traded
	GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Nugget.get(0,null), Materials.Fluorine.getGas(250), FluoriteTypes.WHITE.getItem(), 500, 48);//Is there a way to unify GT and ReC fluids? And to fully remove ReC worldgen?
	
//	Ore Flakes as Crushed ores register
	GT_OreDictUnificator.set(OrePrefixes.crushedPurified, Materials.Coal, getFlake(new ItemStack(Blocks.coal_ore)), false, false);
	GT_OreDictUnificator.set(OrePrefixes.crushedPurified, Materials.Iron, getFlake(new ItemStack(Blocks.iron_ore)), false, false);
	GT_OreDictUnificator.set(OrePrefixes.crushedPurified, Materials.Gold, getFlake(new ItemStack(Blocks.gold_ore)), false, false);
	GT_OreDictUnificator.set(OrePrefixes.crushedPurified, Materials.Redstone, getFlake(new ItemStack(Blocks.redstone_ore)), false, false);
	GT_OreDictUnificator.set(OrePrefixes.crushedPurified, Materials.Lapis, getFlake(new ItemStack(Blocks.lapis_ore)), false, false);
	GT_OreDictUnificator.set(OrePrefixes.crushedPurified, Materials.Diamond, getFlake(new ItemStack(Blocks.diamond_ore)), false, false);
	GT_OreDictUnificator.set(OrePrefixes.crushedPurified, Materials.Emerald, getFlake(new ItemStack(Blocks.emerald_ore)), false, false);
	GT_OreDictUnificator.set(OrePrefixes.crushedPurified, Materials.NetherQuartz, getFlake(new ItemStack(Blocks.quartz_ore)), false, false);
	for(Materials tMaterial : Util.tMats){
//		System.out.println("Materials: Flakes to add");
		if(ModOreList.isModOre(GT_OreDictUnificator.get(OrePrefixes.ore, tMaterial, 1))){
//			System.out.println("Is Flake: "+tMaterial.name());
		GT_OreDictUnificator.set(OrePrefixes.crushedPurified, tMaterial, ExtractorModOres.getFlakeProduct(ModOreList.getModOreFromOre(GT_OreDictUnificator.get(OrePrefixes.ore, tMaterial, 1))), false, false);}
	}
//	Adding oredict to custom added extractor materials.
	List<Materials> mats = new ArrayList<>(Arrays.asList(Materials.VanadiumMagnetite, Materials.Malachite, Materials.Stibnite, Materials.Sphalerite, Materials.Chalcopyrite, Materials.Ilmenite, Materials.RockSalt, Materials.Salt, Materials.Lepidolite,
			Materials.Spodumene, Materials.Soapstone, Materials.Talc, Materials.Glauconite, Materials.Garnierite, Materials.Cobaltite, Materials.Palladium, Materials.Bastnasite, Materials.Monazite, Materials.Neodymium, Materials.Wulfenite,
			Materials.Molybdenite, Materials.Molybdenum, Materials.Powellite, Materials.Scheelite, Materials.Lithium, Materials.Almandine, Materials.Pyrope, Materials.GreenSapphire, Materials.Grossular, Materials.Spessartine,
			Materials.Pyrolusite, Materials.Tantalite, Materials.Quartzite, Materials.Barite, Materials.Graphite, Materials.Bentonite, Materials.Magnesite, Materials.Phosphorus, Materials.Phosphate, Materials.Lazurite, Materials.Beryllium));
	int i = 3;
	for(Materials tM : mats){		
	GT_OreDictUnificator.set(OrePrefixes.crushedPurified, tM, GT_ModHandler.getModItem("RotaryCraft", "rotarycraft_item_customextract", 1, i));
	i +=4;
	}
	
//	Bedrock Breaker with GT Tungsten Grinding Head
	replaceRecipeRoC(MachineRegistry.BEDROCKBREAKER.getCraftedProduct(), new Object[]{"BDt", "BSO", "BDt", 't', ItemStacks.tungsteningot, 'S', ItemStacks.steelingot, 'D', Items.diamond, 'O', ItemList.Component_Grinder_Tungsten.get(1, null), 'B', ItemStacks.basepanel});
	
//	saw item upgrade with GT item
	GT_ModHandler.removeRecipeByOutput(ItemStacks.saw);
	GT_ModHandler.addCraftingRecipe(ItemStacks.saw, new Object[]{"S S"," B ","S S",'S',GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlueSteel, 1),'B',ItemList.Component_Sawblade_Diamond.get(1,null)});
	
//	tungsten changes(friction heater tungstenflake->GT tungsten ingot into sintered tungsten
//	removing silicon item from friction heater because of conflict with GT
	try {
		Method tMethod = RecipesFrictionHeater.class.getDeclaredMethod("removeRecipe", FrictionRecipe.class.getInterfaces());
		tMethod.setAccessible(true);
		tMethod.invoke(RecipesFrictionHeater.getRecipes(), RecipesFrictionHeater.getRecipes().getRecipeByInput(ItemStacks.tungstenflakes));
		tMethod.invoke(RecipesFrictionHeater.getRecipes(), RecipesFrictionHeater.getRecipes().getRecipeByInput(ItemStacks.silicondust));
	} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
		e.printStackTrace();
	}
	RecipesFrictionHeater.getRecipes().addCoreRecipe( ItemStacks.tungstenflakes, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungstate, 4), 1350, 60);//Recipe to prevent handbook crash
	RecipesFrictionHeater.getRecipes().addCoreRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tungsten, 1), ItemStacks.tungsteningot, 1350, 600);
	RecipesFrictionHeater.getRecipes().addCoreRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1), CraftingItems.GRAPHITE.getItem(), 400, 200);
	RecipesFrictionHeater.getRecipes().addCoreRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 1), CraftingItems.GRAPHITE.getItem(), 400, 200);
	GT_ModHandler.addShapelessCraftingRecipe(ItemStacks.silicon, new Object[]{OrePrefixes.ingot.get(Materials.Silicon)});
	
//	pulse jet change
	replaceRecipeRoC(MachineRegistry.PULSEJET.getCraftedProduct(), new Object[]{"OCD", "PcO", "BBB", 'B', ItemStacks.basepanel, 'O', Blocks.obsidian, 'C', ItemStacks.compressor, 'D', GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1), 'c', ItemStacks.combustor, 'P', ItemStacks.pipe});
	
//	compactor with HSS-G steel
	replaceRecipeRoC(MachineRegistry.COMPACTOR.getCraftedProduct(), new Object[]{"SPS", "PGP", "SPS", 'S', GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.HSSE, 1), 'P', ItemStacks.presshead, 'G', ItemStacks.gearunit16});
	
//	Drewpoint aggregator later. no infinite water until this point
	replaceRecipeRoC(MachineRegistry.AGGREGATOR.getCraftedProduct(), new Object[]{"SPS", "GCG", "SsS", 's', ItemStacks.shaftitem, 'G', Blocks.glass_pane, 'S', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1), 'P', ItemStacks.basepanel, 'C', ItemStacks.compressor});
	
//	Disable steel purifier
	replaceRecipeRoC(MachineRegistry.PURIFIER.getCraftedProduct(), null);
	
//	Disable flour direct smelting into bread
	GT_ModHandler.removeFurnaceSmelting(ItemStacks.flour);
	
//	Make Fluorite ores spawn as stone
	ReactorCraft.blocks[ReactorBlocks.FLUORITEORE.ordinal()] = Blocks.stone;
	
//	Make Diamond Shafts the GT way
	Util.removeRecipeByOutput(ItemStacks.diamondshaft);
	GT_ModHandler.addShapelessCraftingRecipe(ItemStacks.diamondshaft, new Object[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Diamond, 1)});
	
//  Make Diamond Gears the GT way
	Util.removeRecipeByOutput(ItemStacks.diamondgear);
	GT_ModHandler.addShapelessCraftingRecipe(ItemStacks.diamondgear, new Object[]{GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Diamond, 1)});
	
//	drying bed remove all drying recipes, readd salt
		try {
			Field tField = RecipesDryingBed.class.getDeclaredField("recipeList");
			tField.setAccessible(true);
			tField.set(RecipesDryingBed.getRecipes(), new FluidHashMap());
		} catch (SecurityException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
			e.printStackTrace();
		}
		RecipesDryingBed.getRecipes().addAPIRecipe(FluidRegistry.WATER, 1000, GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Salt, 1));
				
//	Use pulse jet product for GT
		GT_ModHandler.addCraftingRecipe(ItemListIG.PlatinumInductiveFoil.get(4,null), new Object[]{"I", "B", "h", Character.valueOf('I'), OrePrefixes.ingot.get(Materials.Platinum), Character.valueOf('B'), ItemStacks.redgoldingot});
		for(ItemStack tItemStack : OreDictionary.getOres(OreDictNames.craftingLensRed.toString()))
        GT_Values.RA.addLaserEngraverRecipe(ItemListIG.PlatinumInductiveFoil.get(1,null), tItemStack, ItemList.Circuit_Parts_Wiring_Elite.get(1L, new Object[0]), 63, 480);

//	Use compactor for GT
		Util.removeRecipeByOutput(ItemList.Electric_Motor_IV.get(1, null));
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Motor_IV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', ReactorItems.MAGNET.getCraftedMetadataProduct(1, 5), 'R', OrePrefixes.stick.get(Materials.TungstenSteel), 'W', OrePrefixes.wireGt16.get(Materials.AnnealedCopper), 'C', OrePrefixes.cableGt01.get(Materials.Tungsten)});
//	Use FrictionHeater/RoC Blast Furnace recipe in GT
		addBlastRecipe(ItemList.IC2_EnergyCrystal.get(1,null), 800, 4, "SSS", "SSS", "SSS", 'S', ItemList.IC2_Energium_Dust.get(1, null));
		addBlastRecipe(ItemList.IC2_LapotronCrystal.get(1,null), 800, 4, "SCS", "SES", "SCS", 'S', GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1),'C',GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),'E',ItemList.IC2_EnergyCrystal.getWildcard(1, null));
		addBlastRecipe(ItemList.IC2_LapotronCrystal.get(1,null), 800, 4, "SCS", "SES", "SCS", 'S', GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lazurite, 1),'C',GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),'E',ItemList.IC2_EnergyCrystal.getWildcard(1, null));
	
		
//Fix RoC + IC2 blaze loop
		GT_Utility.removeSimpleIC2MachineRecipe(new ItemStack(Items.blaze_powder,5), GT_ModHandler.getCompressorRecipeList(), new ItemStack(Items.blaze_rod,1));
		GT_ModHandler.addCompressionRecipe(new ItemStack(Items.blaze_powder,6), new ItemStack(Items.blaze_rod,1));
		
//	TODO Reactorcraft recipes
//	Heatray/lens/components integrate with GT 
	}
	
	public static void loadcomplete(){
//	Use liquid nitrogen/refrigeration unit
		Util.removeRecipeByOutput(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 3));        
		GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "HPT",  'H', OrePrefixes.cell.get(Materials.Helium),  'N', ItemRegistry.BUCKET.getStackOfMetadata(3),  'T', OrePrefixes.pipeTiny.get(Materials.TungstenSteel),  'P', ItemList.Electric_Pump_LV,  'C', OrePrefixes.wireGt01.get(Materials.NiobiumTitanium)});
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "HPT",  'H', OrePrefixes.cell.get(Materials.Helium),  'N', ItemRegistry.BUCKET.getStackOfMetadata(3),  'T', OrePrefixes.pipeTiny.get(Materials.TungstenSteel),  'P', ItemList.Electric_Pump_LV,  'C', OrePrefixes.wireGt01.get(Materials.VanadiumGallium)});
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "NPT",  'N', ItemRegistry.BUCKET.getStackOfMetadata(3),  'T', OrePrefixes.pipeTiny.get(Materials.TungstenSteel),  'P', ItemList.Electric_Pump_LV,  'C', OrePrefixes.wireGt01.get(Materials.YttriumBariumCuprate)});
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "NPT",  'N', ItemRegistry.BUCKET.getStackOfMetadata(3),  'T', OrePrefixes.pipeTiny.get(Materials.TungstenSteel),  'P', ItemList.Electric_Pump_LV,  'C', OrePrefixes.wireGt01.get(Materials.HSSG)});

		Util.removeRecipeByOutput(ItemList.IC2_LapotronCrystal.getWildcard(1, null)); 
}
	
	public static void addBlastRecipe(ItemStack is, int temperature, int speed, Object... params) {
			RecipesBlastFurnace.getRecipes().add3x3Crafting(is, temperature, speed, .0f, params);
}

	public static List<WorktableRecipe> wRecipes;

	public static void replaceRecipeRoC(ItemStack aOutput, Object[] aRecipe) {
		if (GT_ModHandler.removeRecipeByOutput(aOutput)&&aRecipe!=null)
			GT_ModHandler.addCraftingRecipe(aOutput, aRecipe);
		if (wRecipes == null)
			wRecipes = WorktableRecipes.getInstance().getRecipeListCopy();
		for (int i = 0; i < wRecipes.size(); i++) {
			if (GT_Utility.areStacksEqual(wRecipes.get(i).getOutput(), aOutput)) {
				removeWTRecipe(wRecipes.get(i));
				if(aRecipe!=null)
				WorktableRecipes.getInstance().addAPIRecipe(aOutput, aRecipe);
				break;
			}
		}
	}

	public static void removeWTRecipe(WorktableRecipe tRecipe) {
		try {
			Method tMethod = WorktableRecipes.class.getDeclaredMethod("removeRecipe",
					WorktableRecipe.class.getInterfaces());
			tMethod.setAccessible(true);
			tMethod.invoke(WorktableRecipes.getInstance(), tRecipe);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	public static ItemStack getFlake(ItemStack aStack){
		return RecipesExtractor.getRecipes().getExtractionResult(RecipesExtractor.getRecipes().getExtractionResult(RecipesExtractor.getRecipes().getExtractionResult(RecipesExtractor.getRecipes().getExtractionResult(aStack))));
	}
}
