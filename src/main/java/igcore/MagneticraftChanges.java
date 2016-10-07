package igcore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.cout970.magneticraft.api.access.MgRecipeRegister;
import com.cout970.magneticraft.api.access.RecipeGrinder;

import Reika.ReactorCraft.Auxiliary.ReactorStacks;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OreDictNames;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class MagneticraftChanges {

	public static void load(){
		MgRecipeRegister.crusher.clear();
		MgRecipeRegister.grinder.clear();
		MgRecipeRegister.sifter.clear();
		MgRecipeRegister.polymerizer.clear();
		MgRecipeRegister.registerPolymerizerRecipe(Materials.Naphtha.getFluid(144), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Coal, 1), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Plastic, 1), 240);
		MgRecipeRegister.registerPolymerizerRecipe(Materials.Naphtha.getFluid(574), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 1), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Polycaprolactam, 9), 240);
		MgRecipeRegister.registerPolymerizerRecipe(new FluidStack(ItemList.sEpichlorhydrin,144), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Silicone, 1), 240);
		
//		TODO
		MgRecipeRegister.refinery.clear();
		MgRecipeRegister.oilDistillery.clear();
		
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
			    
			MgRecipeRegister.registerCrusherRecipe(aOreStack, GT_Utility.mul(2L, new Object[] { tCrushed }), tMaterial.contains(SubTag.PULVERIZING_CINNABAR) ? GT_OreDictUnificator.get(OrePrefixes.crystal, Materials.Cinnabar, GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, new Object[] { tPrimaryByProduct }), 1L), 1L) : GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, new Object[] { tPrimaryByProduct }), 1L), tPrimaryByProduct == null ? 0 : tPrimaryByProduct.stackSize * 0.10f * aMultiplier * tMaterial.mByProductMultiplier, GT_OreDictUnificator.getDust(OrePrefixes.ore.mSecondaryMaterial), 0.50f);
			MgRecipeRegister.registerGrinderRecipe(tCrushed, GT_OreDictUnificator.get(OrePrefixes.dustImpure, tMaterial, 1), tMaterial.contains(SubTag.PULVERIZING_CINNABAR) ? GT_OreDictUnificator.get(OrePrefixes.crystal, Materials.Cinnabar, GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, new Object[] { tPrimaryByProduct }), 1L), 1L) : GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, new Object[] { tPrimaryByProduct }), 1L), 0.1f, null, 0);
			MgRecipeRegister.registerGrinderRecipe(GT_OreDictUnificator.get(OrePrefixes.crushedCentrifuged, tMaterial, 1), GT_OreDictUnificator.get(OrePrefixes.dust, tMaterial.mMacerateInto, 1), GT_OreDictUnificator.get(OrePrefixes.dust, GT_Utility.selectItemInList(2, tMaterial.mMacerateInto, tMaterial.mOreByProducts), 1L), 0.1f, null, 0);
			MgRecipeRegister.registerGrinderRecipe(GT_OreDictUnificator.get(OrePrefixes.crushedPurified, tMaterial, 1), GT_OreDictUnificator.get(OrePrefixes.dustPure, tMaterial.mMacerateInto, 1), GT_OreDictUnificator.get(OrePrefixes.dust, tSecondaryByMaterial, 1L), 0.1f, null, 0);
			}
		
		List<Materials> tGems = new ArrayList<>(Arrays.asList(Materials.Olivine, Materials.GarnetRed, Materials.Diamond, Materials.Emerald, Materials.Sapphire, Materials.Ruby, Materials.GarnetYellow, Materials.GreenSapphire));
		for(Materials tGem : tGems)
		MgRecipeRegister.registerSifterRecipe(GT_OreDictUnificator.get(OrePrefixes.crushedPurified, tGem, 1), GT_OreDictUnificator.get(OrePrefixes.gem, tGem, 1), GT_OreDictUnificator.get(OrePrefixes.gemExquisite, tGem, 1), 0.05f);
		tGems = new ArrayList<>(Arrays.asList(Materials.Lazurite,Materials.Lignite, Materials.Phosphorus, Materials.Sodalite, Materials.Quartzite, Materials.NetherQuartz, Materials.Apatite, Materials.CertusQuartz, Materials.Lapis, Materials.Coal, Materials.Monazite));
		for(Materials tGem : tGems)
		MgRecipeRegister.registerSifterRecipe(GT_OreDictUnificator.get(OrePrefixes.crushedPurified, tGem, 1), GT_OreDictUnificator.get(OrePrefixes.gem, tGem, 1), GT_OreDictUnificator.get(OrePrefixes.dust, tGem, 1), 0.2f);
		MgRecipeRegister.registerSifterRecipe(GT_OreDictUnificator.get(OrePrefixes.crushedPurified, Materials.Magnetite, 1), ReactorStacks.lodestone, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnetite, 1), 0.6f);
		
	
	
		
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Magneticraft", "item.motor", 1));
		GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("Magneticraft", "item.motor", 1), new Object[]{ItemList.Electric_Motor_LV.get(1, null)});
		
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Magneticraft", "item.alternator", 1));
		GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("Magneticraft", "item.alternator", 1), new Object[]{ItemList.Electric_Motor_MV.get(1, null)});
		
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Magneticraft", "item.ingotCarbide", 1));
		GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("Magneticraft", "item.ingotCarbide", 1), new Object[]{OrePrefixes.ingot.get(Materials.VanadiumSteel),OrePrefixes.dust.get(Materials.Carbon)});

		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Magneticraft", "item.battery_small", 1,GT_Values.W));
		GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("Magneticraft", "item.battery_small", 1), new Object[]{ItemList.Battery_SU_LV_SulfuricAcid});
		
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Magneticraft", "item.battery", 1,GT_Values.W));
		GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("Magneticraft", "item.battery", 1), new Object[]{ItemList.Battery_SU_MV_SulfuricAcid});		

		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Magneticraft", "InfiniteWater", 1));
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Magneticraft", "item.iron_pipe", 1));
		GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("Magneticraft", "item.iron_pipe", 1), new Object[]{GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Steel, 1)});
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Magneticraft", "item.copper_pipe", 1));
		GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("Magneticraft", "item.copper_pipe", 1), new Object[]{GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Bronze, 1)});
		
		GT_ModHandler.addExtractionRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 4), GT_ModHandler.getModItem("Magneticraft", "item.dustQuartz", 1));
		}	
	}
