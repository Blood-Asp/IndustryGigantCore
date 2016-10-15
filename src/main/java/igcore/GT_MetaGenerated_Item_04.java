package igcore;

import com.google.common.collect.ImmutableMap;

import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.items.GT_MetaGenerated_Item_X32;
import gregtech.api.objects.GT_CopiedBlockTexture;
import gregtech.api.objects.ItemData;
import gregtech.api.objects.MaterialStack;
import gregtech.api.util.*;
import gregtech.common.items.behaviors.Behaviour_Arrow;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class GT_MetaGenerated_Item_04
        extends GT_MetaGenerated_Item_X32 {
    public static GT_MetaGenerated_Item_04 INSTANCE;

    public GT_MetaGenerated_Item_04() {
        super("metaitem.04", new OrePrefixes[]{});
        INSTANCE = this;

        int tLastID = 0;

        ItemListIG.Trade_EnergyAmp1.set(addItem(tLastID = 0, "Energy Trade Licence(AMP)", "0.5 Amp", new Object(){}));//1
        ItemListIG.Trade_EnergyAmp2.set(addItem(tLastID = 1, "Energy Trade Licence(AMP)", "0.75 Amp", new Object(){}));//1
        ItemListIG.Trade_EnergyAmp3.set(addItem(tLastID = 2, "Energy Trade Licence(AMP)", "0.85 Amp", new Object(){}));//1
        ItemListIG.Trade_EnergyAmp4.set(addItem(tLastID = 3, "Energy Trade Licence(AMP)", "1 Amp", new Object(){}));//1
        ItemListIG.Trade_EnergyVolt1.set(addItem(tLastID = 4, "Energy Trade Licence(Volt)", "Low Voltage", new Object(){}));//1
        ItemListIG.Trade_EnergyVolt2.set(addItem(tLastID = 5, "Energy Trade Licence(Volt)", "Medium Voltage", new Object(){}));//1
        ItemListIG.Trade_EnergyVolt3.set(addItem(tLastID = 6, "Energy Trade Licence(Volt)", "High Voltage", new Object(){}));//1
        ItemListIG.Trade_EnergyVolt4.set(addItem(tLastID = 7, "Energy Trade Licence(Volt)", "Extreme Voltage", new Object(){}));//1
        ItemListIG.Trade_EnergyVolt5.set(addItem(tLastID = 8, "Energy Trade Licence(Volt)", "Insane Voltage", new Object(){}));//1
        ItemListIG.Trade_EnergyVolt6.set(addItem(tLastID = 9, "Energy Trade Licence(Volt)", "LuV", new Object(){}));//1
        ItemListIG.Trade_EnergyVolt7.set(addItem(tLastID = 15, "Energy Trade Licence(Volt)", "ZPM", new Object(){}));//1
        ItemListIG.Trade_EnergyVolt8.set(addItem(tLastID = 16, "Energy Trade Licence(Volt)", "Ultimate Voltage", new Object(){}));//1

        ItemListIG.Trade_Materials1.set(addItem(tLastID = 10, "Material Trade Licence", "Tier 1", new Object(){}));//1
        ItemListIG.Trade_Materials2.set(addItem(tLastID = 11, "Material Trade Licence", "Tier 2", new Object(){}));//1
        ItemListIG.Trade_Materials3.set(addItem(tLastID = 12, "Material Trade Licence", "Tier 3", new Object(){}));//1
        ItemListIG.Trade_Materials4.set(addItem(tLastID = 13, "Material Trade Licence", "Tier 4", new Object(){}));
        ItemListIG.Trade_Materials5.set(addItem(tLastID = 14, "Material Trade Licence", "Tier 5", new Object(){}));

        ItemListIG.Naquadah		.set(addItem(tLastID = 20, "Ore Trade Licence", "Naquadah, Enriched Naquadah", new Object(){}));
        ItemListIG.Lignite		.set(addItem(tLastID = 21, "Ore Trade Licence", "Lignite, Coal", new Object(){}));											//1
        ItemListIG.Coal			.set(addItem(tLastID = 22, "Ore Trade Licence", "Coal, Lignite", new Object(){}));											//1
        ItemListIG.Magnetite	.set(addItem(tLastID = 23, "Ore Trade Licence", "Magnetite, Iron, Vanadium Magnetite", new Object(){}));					//1 
        ItemListIG.Gold			.set(addItem(tLastID = 24, "Ore Trade Licence", "Magnetite, Vanadium Magnetite, Gold", new Object(){})); 	
        ItemListIG.Iron			.set(addItem(tLastID = 25, "Ore Trade Licence", "Brown Limonite, Yellow Limonite, Banded Iron, Malachite", new Object(){}));//2
        ItemListIG.Cassiterite	.set(addItem(tLastID = 26, "Ore Trade Licence", "Tin, Cassiterite", new Object(){}));										//1
        ItemListIG.Tetrahedrite	.set(addItem(tLastID = 27, "Ore Trade Licence", "Tetrahedrite, Copper, Stibnite", new Object(){}));							//1
        ItemListIG.NetherQuartz	.set(addItem(tLastID = 28, "Ore Trade Licence", "Nether Quartz", new Object(){}));											//1
        ItemListIG.Sulfur		.set(addItem(tLastID = 29, "Ore Trade Licence", "Sulfur, Pyrite, Sphalerite", new Object(){}));								//1
        ItemListIG.Copper		.set(addItem(tLastID = 30, "Ore Trade Licence", "Chalcopyrite, Iron, Pyrite, Copper", new Object(){}));						//1
        ItemListIG.Bauxite		.set(addItem(tLastID = 31, "Ore Trade Licence", "Bauxite, Ilmenite", new Object(){}));										//1
        ItemListIG.Salts		.set(addItem(tLastID = 32, "Ore Trade Licence", "Rock Salt, Salt Lepidolite, Spodumene", new Object(){}));					//1
        ItemListIG.Redstone		.set(addItem(tLastID = 33, "Ore Trade Licence", "Redstone, Ruby, Cinnabar", new Object(){})); 								//1
        ItemListIG.Soapstone	.set(addItem(tLastID = 34, "Ore Trade Licence", "Soapstone, Talc, Glauconite, Pentlandite", new Object(){}));				//1
        ItemListIG.Nickel		.set(addItem(tLastID = 35, "Ore Trade Licence", "Garnierite, Nickel, Cobaltite, Pentlandite", new Object(){}));
        ItemListIG.Platinum		.set(addItem(tLastID = 36, "Ore Trade Licence", "Sheldonite, Palladium, Platinum, Iridium", new Object(){}));				//
        ItemListIG.Pitchblende	.set(addItem(tLastID = 37, "Ore Trade Licence", "Pitchblende, Uranium Uranite", new Object(){}));							//
        ItemListIG.Plutonium	.set(addItem(tLastID = 38, "Ore Trade Licence", "Uranite, Uranium", new Object(){}));										//
        ItemListIG.Monazite		.set(addItem(tLastID = 39, "Ore Trade Licence", "Bastnasite, Monazite, Neodymium", new Object(){}));
        ItemListIG.Molybdenum	.set(addItem(tLastID = 40, "Ore Trade Licence", "Wulfenite, Molybdenite, Molybdenum, Powellite", new Object(){}));			//1
        ItemListIG.Tungstate	.set(addItem(tLastID = 41, "Ore Trade Licence", "Scheelite, Tungstate, Lithium", new Object(){}));							//1
        ItemListIG.Sapphire		.set(addItem(tLastID = 42, "Ore Trade Licence", "Almandine, Pyrope, Sapphire, Green Sapphire", new Object(){}));
        ItemListIG.Manganese	.set(addItem(tLastID = 43, "Ore Trade Licence", "Grossular, Spessartine, Pyrolusite, Tantalite", new Object(){}));			//1
        ItemListIG.Quartz		.set(addItem(tLastID = 44, "Ore Trade Licence", "Quartzite, Barite, Certus Quartz", new Object(){}));						//
        ItemListIG.Diamond		.set(addItem(tLastID = 45, "Ore Trade Licence", "Graphite, Diamond, Coal", new Object(){}));								//1
        ItemListIG.Olivine		.set(addItem(tLastID = 46, "Ore Trade Licence", "Bentonite, Magnesite, Olivine, Glauconite", new Object(){}));
        ItemListIG.Apatite		.set(addItem(tLastID = 47, "Ore Trade Licence", "Apatite, Phosphorus, Phosphate", new Object(){}));							//1
        ItemListIG.Galena		.set(addItem(tLastID = 48, "Ore Trade Licence", "Galena, Silver, Lead", new Object(){}));									//1
        ItemListIG.Lapis		.set(addItem(tLastID = 49, "Ore Trade Licence", "Lazurite, Sodalite, Lapis, Calcite", new Object(){}));						//1
        ItemListIG.Beryllium	.set(addItem(tLastID = 50, "Ore Trade Licence", "Beryllium, Emerald, Thorium", new Object(){}));							//1
        
        ItemListIG.HSLABlent	.set(addItem(tLastID = 51, "HSLA Blent","Alloy metals for HSLA", new Object(){}));
        ItemListIG.PlatinumInductiveFoil.set(addItem(tLastID=52, "Inductive Platinum Foil","",new Object[]{}));
        ItemListIG.Trade_Animals.set(addItem(tLastID = 53, "Animal Trade Licence","Too lazy to catch animals", new Object()));
        
        ItemListIG.Trade_Furniture.set(addItem(tLastID = 60, "Furniture Trade Licence","Everyone needs some", new Object()));				//1
        ItemListIG.Trade_Building.set( addItem(tLastID = 61, "Construction Materials Trade Licence","Help building cities", new Object()));	//2
        ItemListIG.Trade_Food.set(addItem(tLastID = 62, "Food Trade Licence","Feed the masses", new Object()));								//1
        ItemListIG.Trade_Chemical.set(addItem(tLastID = 63, "Chemicals Trade Licence","Liquid Gold and more", new Object()));				//1
        ItemListIG.Trade_Electronics.set(addItem(tLastID = 64, "Electronics Trade Licence","Soo small, so expensive", new Object()));		//1
        ItemListIG.Trade_Nuclear.set(addItem(tLastID = 65, "Nuclear Trade Licence","A difficult trade", new Object()));
        ItemListIG.Trade_Drug.set(addItem(tLastID = 66, "Drug Trade Licence","Fight diseases", new Object()));								//1
        ItemListIG.Trade_Metal.set(addItem(tLastID = 67, "Basic Mechanical Parts Trade Licence","For other factories", new Object()));			//2
        ItemListIG.Trade_Engineering.set(addItem(tLastID = 68, "Engineering Trade Licence","Sell instead of use", new Object()));			//1
        ItemListIG.Trade_Weaponary.set(addItem(tLastID = 69,"Weaponary Trade Licence","Lord of War",new Object()));
        ItemListIG.Trade_Misc.set(addItem(tLastID = 70,"Misc Trade Licence","Random Stuff",new Object()));
        ItemListIG.Trade_Metal2.set(addItem(tLastID = 71, "Good Mechanical Parts Trade Licence","For other factories", new Object()));			//2
        ItemListIG.Trade_Metal3.set(addItem(tLastID = 72, "Advanced Mechanical Parts Trade Licence","For other factories", new Object()));			//2
        ItemListIG.Trade_Metal4.set(addItem(tLastID = 73, "Highly Advanced Mechanical Parts Trade Licence","For other factories", new Object()));			//2
        ItemListIG.Trade_Metal5.set(addItem(tLastID = 74, "Superior Mechanical Parts Trade Licence","For other factories", new Object()));			//2
        ItemListIG.Trade_Metal6.set(addItem(tLastID = 75, "Ultimate Mechanical Parts Trade Licence","For other factories", new Object()));			//2
        
        
        
        
    }
}
