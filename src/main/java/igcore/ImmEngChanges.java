package igcore;

import java.util.ArrayList;

import com.cout970.magneticraft.api.access.MgRecipeRegister;

import Reika.ReactorCraft.Registry.CraftingItems;
import Reika.RotaryCraft.Auxiliary.ItemStacks;
import blusunrize.immersiveengineering.api.crafting.ArcFurnaceRecipe;
import blusunrize.immersiveengineering.api.crafting.BlastFurnaceRecipe;
import blusunrize.immersiveengineering.api.crafting.CrusherRecipe;
import blusunrize.immersiveengineering.api.crafting.MetalPressRecipe;
import blusunrize.immersiveengineering.api.energy.DieselHandler;
import blusunrize.immersiveengineering.api.energy.DieselHandler.RefineryRecipe;
import blusunrize.immersiveengineering.api.tool.ExcavatorHandler;
import blusunrize.immersiveengineering.common.IEContent;
import blusunrize.immersiveengineering.common.IERecipes;
import blusunrize.immersiveengineering.common.blocks.metal.BlockMetalDecoration;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ImmEngChanges {
	
	public static void load(){
//		Fix Structual Arm recycling exploid
		Util.removeRecipeByOutput(new ItemStack(IEContent.blockMetalDecoration, 4,BlockMetalDecoration.META_aluminiumStructuralArm));
		IERecipes.addOredictRecipe(new ItemStack(IEContent.blockMetalDecoration, 1,BlockMetalDecoration.META_aluminiumStructuralArm), "B  ","BB ","BBB", 'B',new ItemStack(IEContent.blockMetalDecoration,1,BlockMetalDecoration.META_aluminiumScaffolding)).setMirrored(true);
		Util.removeRecipeByOutput(new ItemStack(IEContent.blockMetalDecoration, 4,BlockMetalDecoration.META_structuralArm));
		IERecipes.addOredictRecipe(new ItemStack(IEContent.blockMetalDecoration, 1,BlockMetalDecoration.META_structuralArm), "B  ","BB ","BBB", 'B',new ItemStack(IEContent.blockMetalDecoration,1,1)).setMirrored(true);

		
		CrusherRecipe.recipeList.clear();
		
//		TODO
		ArcFurnaceRecipe.recipeList.clear();		
		BlastFurnaceRecipe.recipeList.clear();
//		DieselHandler.fermenterList.clear();
//		DieselHandler.refineryList.clear();
//		DieselHandler.squeezerList.clear();
//		MetalPressRecipe.recipeList.clear();
		
		for(Materials mMaterial : Util.tMats){
			  Materials tMaterial = mMaterial.mOreReplacement;Materials tPrimaryByMaterial = null;Materials tSecondaryByMaterial = null;
			    int aMultiplier = 1;
			    ItemStack aOreStack = GT_OreDictUnificator.get(OrePrefixes.ore, tMaterial, 1);
			    ItemStack tGem = GT_OreDictUnificator.get(OrePrefixes.gem, tMaterial, 1L);
			    ItemStack tDust = GT_OreDictUnificator.get(OrePrefixes.dust, tMaterial, tGem, 1L);
			    ItemStack tCleaned = GT_OreDictUnificator.get(OrePrefixes.crushedPurified, tMaterial, tDust, 1L);
			    ItemStack tCrushed = GT_OreDictUnificator.get(OrePrefixes.crushed, tMaterial, tMaterial.mOreMultiplier * aMultiplier);
			    ItemStack tPrimaryByProduct = null;ItemStack tSecondaryByProduct = null;			    
			    if (tCrushed == null) {tCrushed = GT_OreDictUnificator.get(OrePrefixes.dustImpure, tMaterial, GT_Utility.copyAmount(tMaterial.mOreMultiplier * aMultiplier, new Object[] { tCleaned, tDust, tGem }), tMaterial.mOreMultiplier * aMultiplier);
			    }			    
			    ArrayList<ItemStack> tByProductStacks = new ArrayList();			    
			    for (Materials tMat : tMaterial.mOreByProducts) {
			      ItemStack tByProduct = GT_OreDictUnificator.get(OrePrefixes.dust, tMat, 1L);
			      if (tByProduct != null) tByProductStacks.add(tByProduct);
			      if (tPrimaryByProduct == null) {
			        tPrimaryByMaterial = tMat;
			        tPrimaryByProduct = GT_OreDictUnificator.get(OrePrefixes.dust, tMat, 1L);			      }
			      if ((tSecondaryByProduct == null) || (tSecondaryByMaterial == tPrimaryByMaterial)) {
			        tSecondaryByMaterial = tMat;
			        tSecondaryByProduct = GT_OreDictUnificator.get(OrePrefixes.dust, tMat, 1L);			      }
			    }			    
			    if (tPrimaryByMaterial == null) tPrimaryByMaterial = tMaterial;
			    if (tPrimaryByProduct == null) tPrimaryByProduct = tDust;
			    if (tSecondaryByMaterial == null) tSecondaryByMaterial = tPrimaryByMaterial;
			    if (tSecondaryByProduct == null) tSecondaryByProduct = tPrimaryByProduct;
			    
			    IERecipes.addCrusherRecipe(GT_Utility.mul(3L, new Object[] { tCrushed }), "ore"+tMaterial.name(), 6000, tMaterial.contains(SubTag.PULVERIZING_CINNABAR) ? GT_OreDictUnificator.get(OrePrefixes.crystal, Materials.Cinnabar, GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, new Object[] { tPrimaryByProduct }), 1L), 1L) : GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, new Object[] { tPrimaryByProduct }), 1L) ,tPrimaryByProduct == null ? 0 : tPrimaryByProduct.stackSize * 0.15f * aMultiplier * tMaterial.mByProductMultiplier, "dustStone", 0.5f);
			    IERecipes.addCrusherRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, tMaterial.mMacerateInto, 1), GT_OreDictUnificator.get(OrePrefixes.crushedCentrifuged, tMaterial, 1), 6000, GT_OreDictUnificator.get(OrePrefixes.dust, GT_Utility.selectItemInList(2, tMaterial.mMacerateInto, tMaterial.mOreByProducts), 1L),0.15f);	
		}	    
			    
			    Util.removeRecipeByOutput(new ItemStack(IEContent.blockStoneDecoration,2,2));
			    Util.removeRecipeByOutput(new ItemStack(IEContent.blockStoneDecoration,1,6));			    
				IERecipes.addOredictRecipe(new ItemStack(IEContent.blockStoneDecoration,4,6), "NBN","BDB","NBN", 'B',new ItemStack(IEContent.blockStoneDecoration,1,1),'N',"ingotSteel",'D',"stoneBrickNether");

			    BlastFurnaceRecipe.addRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1), "ingotIron", 600, new ItemStack(IEContent.itemMaterial,1,13));			    
			    ArcFurnaceRecipe.addRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.AnnealedCopper, 1), "ingotCopper",null, 200, 512, null);
			    ArcFurnaceRecipe.addRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1), "ingotWroughtIron",null, 200, 512, null);
				
			    GT_ModHandler.addCompressionRecipe(GT_Utility.copyAmount(4, CraftingItems.GRAPHITE.getItem()), GT_ModHandler.getModItem("ImmersiveEngineering", "graphiteElectrode", 1));			    
			    GT_ModHandler.addPulverisationRecipe(OreDictionary.getOres("fuelCoke").get(0), GT_ModHandler.getModItem("ImmersiveEngineering", "metal", 1,17));
			    
//			    ExcavatorHandler.mineralList.clear();
			    ExcavatorHandler.addMineral("Coal", 800, .2f, new String[]{"oreCoal","oreLignite"}, new float[]{.8f,.2f});
			    ExcavatorHandler.addMineral("Magnetite", 1600, .2f, new String[]{"oreMagnetite","oreIron","oreVanadiumMagnetite"}, new float[]{.7f,0.25f,.05f});
			    ExcavatorHandler.addMineral("Iron", 1200, .2f, new String[]{"oreBrownLimonite","oreYellowLimonite","oreBandedIron","oreMalachite"}, new float[]{.4f,.4f,.15f,.05f});
			    ExcavatorHandler.addMineral("Cassiterite", 500, .2f, new String[]{"oreTin","oreCassiterite"}, new float[]{.8f,.2f});
			    ExcavatorHandler.addMineral("Tetrahedrite", 700, .2f, new String[]{"oreTetrahedrite","oreCopper","oreStibnite"}, new float[]{.8f,.15f,.05f});
			    ExcavatorHandler.addMineral("Sulfur", 1000, .2f, new String[]{"oreSulfur","orePyrite","oreSphalerite"}, new float[]{.8f,.15f,.05f});
			    ExcavatorHandler.addMineral("Copper", 800, .2f, new String[]{"oreChalcopyrite","oreIron","orePyrite","oreCopper"}, new float[]{.4f,.4f,.15f,.05f});
			    ExcavatorHandler.addMineral("Bauxite", 800, .2f, new String[]{"oreBauxite","oreIlmenite"}, new float[]{.95f,.05f});
			    ExcavatorHandler.addMineral("Salts", 500, .2f, new String[]{"oreRockSalt","oreSalt","oreLepidolite","oreSpodumene"}, new float[]{.4f,.4f,.15f,.05f});
			    ExcavatorHandler.addMineral("Redstone", 600, .2f, new String[]{"oreRedstone","oreRuby","oreCinnabar"}, new float[]{.8f,.15f,.05f});
			    ExcavatorHandler.recalculateChances(true);
		

				GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("ImmersiveEngineering", "metalDecoration", 2, 5));
				GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ImmersiveEngineering", "metalDecoration", 2, 5), new Object[]{"ABA","CDC","ABA",'A',GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),'B',GT_ModHandler.getModItem("ImmersiveEngineering", "material", 1, 12),'C',ItemList.Electric_Piston_HV,'D',GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Electrum, 1)});
			    
				GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("ImmersiveEngineering", "metalDecoration", 2, 7));
				GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ImmersiveEngineering", "metalDecoration", 2, 7), new Object[]{"ABA","CDC","ABA",'A',GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1),'B',GT_ModHandler.getModItem("ImmersiveEngineering", "material", 1, 11),'C',ItemList.Electric_Piston_LV,'D',GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Bronze, 1)});
			    
				GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("ImmersiveEngineering", "coil", 4, 0));
				GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ImmersiveEngineering", "coil", 1, 0), new Object[]{"AAA","ABA","AAA",'A',GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 1),'B', new ItemStack(Items.stick)});
				
				GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("ImmersiveEngineering", "coil", 4, 1));
				GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ImmersiveEngineering", "coil", 1, 1), new Object[]{"AAA","ABA","AAA",'A',GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Electrum, 1),'B', new ItemStack(Items.stick)});
				
				GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("ImmersiveEngineering", "coil", 4, 2));
				GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ImmersiveEngineering", "coil", 1, 2), new Object[]{"ACA","CBC","ACA",'A',GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Steel, 1),'B', new ItemStack(Items.stick),'C',GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Aluminium, 1)});
				
				GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("ImmersiveEngineering", "tool", 1, 3));
				GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("ImmersiveEngineering", "tool", 1, 3), new Object[]{GT_ModHandler.getModItem("TConstruct", "blankPattern", 1), new ItemStack(Blocks.lever)});
			  
	}
}
