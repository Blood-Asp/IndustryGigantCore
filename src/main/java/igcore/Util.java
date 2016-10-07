package igcore;

import java.util.ArrayList;
import java.util.List;

import gregtech.api.enums.Materials;
import gregtech.api.interfaces.internal.IGT_CraftingRecipe;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Util {
 public static List<Materials> tMats = new ArrayList<Materials>();
 
public static void init(){
	 tMats.add(Materials.Naquadah);
	 tMats.add(Materials.Coal);				//
	 tMats.add(Materials.Magnetite);		//
	 tMats.add(Materials.Iron);				//
	 tMats.add(Materials.VanadiumMagnetite);//++
	 tMats.add(Materials.Gold);				//
	 tMats.add(Materials.BrownLimonite);	//**
	 tMats.add(Materials.YellowLimonite);	//**
	 tMats.add(Materials.BandedIron);		//**
	 tMats.add(Materials.Malachite);		//++
	 tMats.add(Materials.Tin);				//
	 tMats.add(Materials.Cassiterite);		//
	 tMats.add(Materials.Tetrahedrite);		//
	 tMats.add(Materials.Copper);			//
	 tMats.add(Materials.Stibnite);
	 tMats.add(Materials.NetherQuartz);		//
	 tMats.add(Materials.Sulfur);			//
	 tMats.add(Materials.Pyrite);			//
	 tMats.add(Materials.Sphalerite);
	 tMats.add(Materials.Chalcopyrite);
	 tMats.add(Materials.Bauxite);			//
	 tMats.add(Materials.Aluminium);		//
	 tMats.add(Materials.Ilmenite);
	 tMats.add(Materials.RockSalt);
	 tMats.add(Materials.Salt);
	 tMats.add(Materials.Lepidolite);
	 tMats.add(Materials.Spodumene);
	 tMats.add(Materials.Redstone);			//
	 tMats.add(Materials.Ruby);				//
	 tMats.add(Materials.Cinnabar);			//
	 tMats.add(Materials.Soapstone);
	 tMats.add(Materials.Talc);
	 tMats.add(Materials.Glauconite);
	 tMats.add(Materials.Pentlandite);		//**
	 tMats.add(Materials.Garnierite);
	 tMats.add(Materials.Nickel);			//
	 tMats.add(Materials.Cobaltite);
	 tMats.add(Materials.Palladium);
	 tMats.add(Materials.Platinum);			//**
	 tMats.add(Materials.Iridium);			//
	 tMats.add(Materials.Pitchblende);		//
	 tMats.add(Materials.Uranium);			//
	 tMats.add(Materials.Uraninite);		//**
	 tMats.add(Materials.Bastnasite);
	 tMats.add(Materials.Monazite);
	 tMats.add(Materials.Neodymium);
	 tMats.add(Materials.Wulfenite);
	 tMats.add(Materials.Molybdenite);
	 tMats.add(Materials.Molybdenum);
	 tMats.add(Materials.Powellite);
	 tMats.add(Materials.Scheelite);
	 tMats.add(Materials.Tungstate);		//**
	 tMats.add(Materials.Lithium);
	 tMats.add(Materials.Almandine);
	 tMats.add(Materials.Pyrope);
	 tMats.add(Materials.Sapphire);			//
	 tMats.add(Materials.GreenSapphire);
	 tMats.add(Materials.Grossular);
	 tMats.add(Materials.Spessartine);
	 tMats.add(Materials.Pyrolusite);
	 tMats.add(Materials.Tantalite);
	 tMats.add(Materials.Quartzite);
	 tMats.add(Materials.Barite);
	 tMats.add(Materials.CertusQuartz);		//
	 tMats.add(Materials.Graphite);
	 tMats.add(Materials.Diamond);			//
	 tMats.add(Materials.Bentonite);
	 tMats.add(Materials.Magnesite);
	 tMats.add(Materials.Olivine);			//
	 tMats.add(Materials.Apatite);			//
	 tMats.add(Materials.Phosphorus);
	 tMats.add(Materials.Phosphate);
	 tMats.add(Materials.Galena);			//
	 tMats.add(Materials.Silver);			//
	 tMats.add(Materials.Lead);				//
	 tMats.add(Materials.Lazurite);
	 tMats.add(Materials.Sodalite);			//
	 tMats.add(Materials.Lapis);			//
	 tMats.add(Materials.Calcite);			//
	 tMats.add(Materials.Beryllium);
	 tMats.add(Materials.Emerald);			//
	 tMats.add(Materials.Thorium);	 		//
 } 

public static boolean removeRecipeByOutput(ItemStack aOutput) {
    if (aOutput == null) return false;
    boolean rReturn = false;
    ArrayList<IRecipe> tList = (ArrayList<IRecipe>) CraftingManager.getInstance().getRecipeList();
    aOutput = GT_OreDictUnificator.get(aOutput);
    for (int i = 0; i < tList.size(); i++) {
        IRecipe tRecipe = tList.get(i);
        ItemStack tStack = tRecipe.getRecipeOutput();
        if (GT_Utility.areStacksEqual(GT_OreDictUnificator.get(tStack), aOutput, true)) {
            tList.remove(i--);
            rReturn = true;
        }
    }
    return rReturn;
}
}
