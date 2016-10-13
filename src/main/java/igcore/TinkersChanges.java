package igcore;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Reika.DragonAPI.ModInteract.ItemHandlers.TinkerToolHandler;
import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import scala.tools.nsc.symtab.SymbolLoadersStats;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.FluidType;
import tconstruct.library.crafting.Smeltery;
import tconstruct.smeltery.TinkerSmeltery;
import tconstruct.world.blocks.TMetalBlock;

public class TinkersChanges {
	public static Map<Materials,Fluid> mMetals = new HashMap();
	public static Map<ItemStack,ItemStack> mFurnace = new HashMap();
	public static void load(){
		  Smeltery.addMelting(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Aluminium, 1), Materials.Aluminium.mMeltingPoint, new FluidStack(FluidRegistry.getFluid("aluminum.molten"),144*9));
		  Smeltery.addMelting(FluidType.getFluidType(FluidRegistry.getFluid("aluminum.molten")), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1), 300, 144);
        TConstructRegistry.getTableCasting().addCastingRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1), new FluidStack(FluidRegistry.getFluid("aluminum.molten"),144), TinkerToolHandler.getInstance().getIngotCast(), 20);
        TConstructRegistry.getBasinCasting().addCastingRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Aluminium, 1), new FluidStack(FluidRegistry.getFluid("aluminum.molten"),144*9), 180);
        addMolten(Materials.Iron, TinkerSmeltery.moltenIronFluid);
        addMolten(Materials.Gold, TinkerSmeltery.moltenGoldFluid);
        addMolten(Materials.Copper, TinkerSmeltery.moltenCopperFluid);
        addMolten(Materials.Tin, TinkerSmeltery.moltenTinFluid);
        addMolten(Materials.Cobalt, TinkerSmeltery.moltenCobaltFluid);
        addMolten(Materials.Bronze, TinkerSmeltery.moltenBronzeFluid);
        addMolten(Materials.Steel, TinkerSmeltery.moltenSteelFluid);
        FluidType.registerFluidType("Nickel", GregTech_API.sBlockMetal5 , 4, 1000, FluidRegistry.getFluid("nickel.molten"), false);
        FluidType.registerFluidType("Lead", GregTech_API.sBlockMetal4 , 2, Materials.Lead.mMeltingPoint, FluidRegistry.getFluid("lead.molten"), false);
        FluidType.registerFluidType("Silver", GregTech_API.sBlockMetal6 , 10, Materials.Silver.mMeltingPoint, FluidRegistry.getFluid("silver.molten"), false);
        FluidType.registerFluidType("Platinum", GregTech_API.sBlockMetal5 , 11, Materials.Platinum.mMeltingPoint, FluidRegistry.getFluid("platinum.molten"), false);
        FluidType.registerFluidType("Invar", GregTech_API.sBlockMetal3 , 11, 1000, FluidRegistry.getFluid("invar.molten"), false);
        FluidType.registerFluidType("Electrum", GregTech_API.sBlockMetal2 , 15, Materials.Electrum.mMeltingPoint, FluidRegistry.getFluid("electrum.molten"), false);
        addMolten(Materials.Nickel, TinkerSmeltery.moltenNickelFluid);
        addMolten(Materials.Lead, TinkerSmeltery.moltenLeadFluid);
        addMolten(Materials.Silver, TinkerSmeltery.moltenSilverFluid);
        addMolten(Materials.Platinum, TinkerSmeltery.moltenShinyFluid);
        addMolten(Materials.Invar, TinkerSmeltery.moltenInvarFluid);
        addMolten(Materials.Electrum, TinkerSmeltery.moltenElectrumFluid);
        addMat(Materials.Indium,GregTech_API.sBlockMetal3,9);
        addMat(Materials.Zinc,GregTech_API.sBlockMetal8,6);
        addMat(Materials.Magnesium,GregTech_API.sBlockMetal4,5);
        addMat(Materials.Thorium,GregTech_API.sBlockMetal7,5);
        addMat(Materials.Molybdenum,GregTech_API.sBlockMetal4,11);
        addMat(Materials.Manganese,GregTech_API.sBlockMetal4,6);
        addMat(Materials.Bismuth,GregTech_API.sBlockMetal1,9);
        addMat(Materials.Uranium,GregTech_API.sBlockMetal7,14);
        addMat(Materials.Antimony,GregTech_API.sBlockMetal1,4);
        addMat(Materials.Redstone,Blocks.redstone_block,0);

        addMat(Materials.Brass,GregTech_API.sBlockMetal1,15);
        addMat(Materials.Cupronickel,GregTech_API.sBlockMetal2,8);
        addMat(Materials.SolderingAlloy,GregTech_API.sBlockMetal6,11);
        addMat(Materials.RedAlloy,GregTech_API.sBlockMetal6,1);
        addMat(Materials.CobaltBrass,GregTech_API.sBlockMetal2,6);
        addMat(Materials.BatteryAlloy,GregTech_API.sBlockMetal1,7);
        addMat(Materials.TinAlloy,GregTech_API.sBlockMetal1,7);
        
        Smeltery.addAlloyMixing(Materials.Brass.getMolten(576), new FluidStack(mMetals.get(Materials.Copper), 432),Materials.Zinc.getMolten(144));
        Smeltery.addAlloyMixing(Materials.Cupronickel.getMolten(288), new FluidStack(mMetals.get(Materials.Copper),144),new FluidStack(mMetals.get(Materials.Nickel),144));
        Smeltery.addAlloyMixing(new FluidStack(mMetals.get(Materials.Invar), 432), new FluidStack(mMetals.get(Materials.Iron),288), new FluidStack(mMetals.get(Materials.Nickel),144));
        Smeltery.addAlloyMixing(Materials.SolderingAlloy.getMolten(1440), new FluidStack(mMetals.get(Materials.Tin), 1296),Materials.Antimony.getMolten(144));
        Smeltery.addAlloyMixing(Materials.RedAlloy.getMolten(144), new FluidStack(mMetals.get(Materials.Copper), 144),Materials.Redstone.getMolten(576));
        Smeltery.addAlloyMixing(Materials.CobaltBrass.getMolten(1296), Materials.Brass.getMolten(1008), new FluidStack(FluidRegistry.getFluid("aluminum.molten"), 144), new FluidStack(mMetals.get(Materials.Cobalt), 144));
        Smeltery.addAlloyMixing(Materials.BatteryAlloy.getMolten(720), new FluidStack(mMetals.get(Materials.Lead), 576),Materials.Antimony.getMolten(144));
        Smeltery.addAlloyMixing(new FluidStack(mMetals.get(Materials.Electrum), 288), new FluidStack(mMetals.get(Materials.Gold), 144),new FluidStack(mMetals.get(Materials.Silver), 144));
        Smeltery.addAlloyMixing(Materials.TinAlloy.getMolten(288), new FluidStack(mMetals.get(Materials.Tin), 144),new FluidStack(mMetals.get(Materials.Iron), 144));
        
	}
	
	public static void addMat(Materials tMat, Block tBlock, int meta){
		FluidType.registerFluidType(tMat.name(), tBlock, meta, tMat.mMeltingPoint<1000 ? tMat.mMeltingPoint: 1000, tMat.getMolten(144).getFluid(), false);
		mMetals.put(tMat, tMat.getMolten(144).getFluid());
	}
	
	public static void addMolten(Materials tMat, Fluid tFluid){
		mMetals.put(tMat, tFluid);
	}
	
	public static void loadComplete(){
		Set tSet = FurnaceRecipes.smelting().getSmeltingList().keySet();
		List<ItemStack> tItemList = new ArrayList();
        for (Object tInput : tSet) {
            if (GT_Utility.isStackValid(tInput)) {
            	ItemData tData = GT_OreDictUnificator.getItemData((ItemStack) tInput);
            	if(tData!=null&&tData.mMaterial.mMaterial.contains(SubTag.METAL)){
            	tItemList.add((ItemStack) tInput);
            	if(!mFurnace.containsKey(tInput)){
            		mFurnace.put((ItemStack) tInput, FurnaceRecipes.smelting().getSmeltingResult((ItemStack) tInput));
            	}
            	}
            }
        }
        for(ItemStack tItem : tItemList)
                FurnaceRecipes.smelting().getSmeltingList().remove(tItem);
        tItemList.clear();
        tSet = FurnaceRecipes.smelting().getSmeltingList().keySet();
        for (Object tInput : tSet) {
        	ItemStack tResult = FurnaceRecipes.smelting().getSmeltingResult((ItemStack) tInput);
            if (GT_Utility.isStackValid(tResult)) {
            	ItemData tData = GT_OreDictUnificator.getItemData((ItemStack) tResult);
            	if(tData!=null&&(tData.mMaterial.mMaterial.contains(SubTag.METAL)/**|| tData.mPrefix == OrePrefixes.ingot || tData.mPrefix == OrePrefixes.nugget**/)){
            	tItemList.add((ItemStack) tInput);
            	if(!mFurnace.containsKey(tInput)){
            		mFurnace.put((ItemStack) tInput, tResult);
            	}
            	}
            }
        }
        for(ItemStack tItem : tItemList)
            FurnaceRecipes.smelting().getSmeltingList().remove(tItem);
        tItemList.clear();
//        List<Materials> tMats = new ArrayList<Materials>();
        for(ItemStack tInput : mFurnace.keySet()){
        	ItemStack tOutput = mFurnace.get(tInput);
        	ItemData tData = GT_OreDictUnificator.getItemData(tOutput);
        	if(tData!=null&& mMetals.containsKey(tData.mMaterial.mMaterial)){
        		int amount = 0;
        		if(tData.mPrefix==OrePrefixes.nugget)amount=16;
        		if(tData.mPrefix==OrePrefixes.ingot)amount=144;
        		if(amount!=0&&FluidType.fluidTypes.containsKey(tData.mMaterial.mMaterial.name())){
        			Smeltery.addMelting(FluidType.getFluidType(tData.mMaterial.mMaterial.name()), tInput, 50, amount*tOutput.stackSize);
        		}      		
        	}
//        	else if(tData!=null&&!tData.mMaterial.mMaterial.mBlastFurnaceRequired&&!tMats.contains(tData.mMaterial.mMaterial)){
//        		tMats.add(tData.mMaterial.mMaterial);
//        		System.out.println("TinkersMetalMissing: "+tData.mMaterial.mMaterial.name());
//        	}
        }
      } 
}
