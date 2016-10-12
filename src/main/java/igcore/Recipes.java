package igcore;

import Reika.ReactorCraft.Auxiliary.ReactorStacks;
import gregtech.api.enums.Dyes;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class Recipes {
	public static void init(){
//		Craft Machines
		GT_ModHandler.addCraftingRecipe(ItemListIG.Machine_LV_Trader.get(1, null), new Object[]{"SWS", "WMW", "WWW", 'M', new ItemStack(Blocks.crafting_table), 'W', new ItemStack(Blocks.planks,1,GT_Values.W),'S',new ItemStack(Blocks.chest)});
    	GT_ModHandler.addCraftingRecipe(ItemListIG.Machine_MV_Trader.get(1, null),  new Object[]{"ABA","BCB","ABA",'A',ItemList.Hull_MV,'B',ItemList.Credit_Greg_Silver,'C',ItemListIG.Machine_LV_Trader});
    	GT_ModHandler.addCraftingRecipe(ItemListIG.Machine_HV_Trader.get(1, null),  new Object[]{"ABA","BCB","ABA",'A',ItemList.Hull_HV,'B',ItemList.Credit_Greg_Gold,'C',ItemListIG.Machine_MV_Trader});
    	GT_ModHandler.addCraftingRecipe(ItemListIG.Machine_EV_Trader.get(1, null),  new Object[]{"ABA","BCB","ABA",'A',ItemList.Hull_EV,'B',ItemList.Credit_Greg_Platinum,'C',ItemListIG.Machine_HV_Trader});
    	GT_ModHandler.addCraftingRecipe(ItemListIG.Machine_IV_Trader.get(1, null),  new Object[]{"ABA","BCB","ABA",'A',ItemList.Hull_IV,'B',ItemList.Credit_Greg_Osmium,'C',ItemListIG.Machine_EV_Trader});
    	GT_ModHandler.addCraftingRecipe(ItemListIG.Machine_LuV_Trader.get(1, null), new Object[]{"ABA","BCB","ABA",'A',ItemList.Hull_LuV,'B',ItemList.Credit_Greg_Naquadah,'C',ItemListIG.Machine_IV_Trader});
    	GT_ModHandler.addCraftingRecipe(ItemListIG.Machine_ZPMV_Trader.get(1, null),new Object[]{"ABA","BCB","ABA",'A',ItemList.Hull_ZPM,'B',ItemList.Credit_Greg_Neutronium,'C',ItemListIG.Machine_LuV_Trader});
    	GT_ModHandler.addCraftingRecipe(ItemListIG.Machine_UV_Trader.get(1, null),  new Object[]{"ABA","BCB","ABA",'A',ItemList.Hull_UV,'B',ItemList.Credit_Greg_Neutronium,'C',ItemListIG.Machine_ZPMV_Trader});
    	
//		Craft Energy Generators
    	GT_ModHandler.addCraftingRecipe(ItemListIG.Generator_EnergyTrade_LV.get(1, null),  new Object[]{"ABA","BCB","ABA",'A',ItemList.Credit_Greg_Copper,'B',ItemList.Credit_Greg_Cupronickel,'C',ItemList.Hull_LV});
    	GT_ModHandler.addCraftingRecipe(ItemListIG.Generator_EnergyTrade_MV.get(1, null),  new Object[]{"ABA","BCB","ABA",'A',ItemList.Hull_MV,'B',ItemList.Credit_Greg_Silver,'C',ItemListIG.Generator_EnergyTrade_LV});
    	GT_ModHandler.addCraftingRecipe(ItemListIG.Generator_EnergyTrade_HV.get(1, null),  new Object[]{"ABA","BCB","ABA",'A',ItemList.Hull_HV,'B',ItemList.Credit_Greg_Gold,'C',ItemListIG.Generator_EnergyTrade_MV});
    	GT_ModHandler.addCraftingRecipe(ItemListIG.Generator_EnergyTrade_EV.get(1, null),  new Object[]{"ABA","BCB","ABA",'A',ItemList.Hull_EV,'B',ItemList.Credit_Greg_Platinum,'C',ItemListIG.Generator_EnergyTrade_HV});
    	GT_ModHandler.addCraftingRecipe(ItemListIG.Generator_EnergyTrade_IV.get(1, null),  new Object[]{"ABA","BCB","ABA",'A',ItemList.Hull_IV,'B',ItemList.Credit_Greg_Osmium,'C',ItemListIG.Generator_EnergyTrade_EV});
    	GT_ModHandler.addCraftingRecipe(ItemListIG.Generator_EnergyTrade_LuV.get(1, null), new Object[]{"ABA","BCB","ABA",'A',ItemList.Hull_LuV,'B',ItemList.Credit_Greg_Naquadah,'C',ItemListIG.Generator_EnergyTrade_IV});
    	GT_ModHandler.addCraftingRecipe(ItemListIG.Generator_EnergyTrade_ZPMV.get(1, null),new Object[]{"ABA","BCB","ABA",'A',ItemList.Hull_ZPM,'B',ItemList.Credit_Greg_Neutronium,'C',ItemListIG.Generator_EnergyTrade_LuV});
    	GT_ModHandler.addCraftingRecipe(ItemListIG.Generator_EnergyTrade_UV.get(1, null),  new Object[]{"ABA","BCB","ABA",'A',ItemList.Hull_UV,'B',ItemList.Credit_Greg_Neutronium,'C',ItemListIG.Generator_EnergyTrade_ZPMV});		
		
//		Buy Ingots/Materials
		addMaterialTrade(ZB(Blocks.cobblestone), ItemListIG.Trade_Materials1.get(0, null), c0001(1), get(OrePrefixes.ingot, Materials.Iron, 16), 1200, 0);
		addMaterialTrade(ZB(Blocks.stone), ItemListIG.Trade_Materials1.get(0, null), c0001(2), get(OrePrefixes.ingot, Materials.Tin, 16), 2000, 0);
		addMaterialTrade(ZB(Blocks.glass), ItemListIG.Trade_Materials1.get(0, null), c0001(1), get(OrePrefixes.ingot, Materials.Copper, 16), 1200, 0);
		addMaterialTrade(ZB(Blocks.dirt), ItemListIG.Trade_Materials1.get(0, null), c0001(2), get(OrePrefixes.dust, Materials.Sulfur, 16), 2400, 0);
		addMaterialTrade(ZB(Blocks.sand), ItemListIG.Trade_Materials1.get(0, null), c0001(1), get(OrePrefixes.dust, Materials.Redstone, 16), 800, 0);
		addMaterialTrade(ZB(Blocks.planks), ItemListIG.Trade_Materials1.get(0, null), c0008(1), get(OrePrefixes.ingot, Materials.Lead, 16), 2400, 0);
		addMaterialTrade(ZB(Blocks.wool), ItemListIG.Trade_Materials1.get(0, null), c0008(2), get(OrePrefixes.ingot, Materials.Zinc, 16), 2400, 0);
		addMaterialTrade(ZB(Blocks.brick_block), ItemListIG.Trade_Materials1.get(0, null), c0001(1), get(OrePrefixes.gem, Materials.Apatite, 16), 800, 0);
		addMaterialTrade(ZB(Blocks.gravel), ItemListIG.Trade_Materials1.get(0, null), c0000(4), get(OrePrefixes.gem, Materials.Coal, 16), 200, 0);
		addMaterialTrade(ZI(Items.flint), ItemListIG.Trade_Materials1.get(0, null), c0000(2), get(OrePrefixes.gem, Materials.Lignite, 16), 100, 0);
		addMaterialTrade(ZI(Items.clay_ball), ItemListIG.Trade_Materials1.get(0, null), c0008(4), get(OrePrefixes.gem, Materials.Lapis, 16), 4400, 0);
		addMaterialTrade(ZI(Items.apple), ItemListIG.Trade_Materials1.get(0, null), c0008(1), new ItemStack(Blocks.netherrack,16), 2000, 0);
		addTraderRecipe(new ItemStack[]{ZI(Items.carrot), ItemListIG.Trade_Materials1.get(0, null), c0008(2)}, null, Materials.Lava.getFluid(16000), null, 4400, 0);		
		addTraderRecipe(new ItemStack[]{ZI(Items.potato), ItemListIG.Trade_Materials1.get(0, null), c0000(2)}, null, Materials.Water.getFluid(16000), null, 200, 0);		
		addMaterialTrade(ZB(Blocks.log), ItemListIG.Trade_Materials1.get(0, null), c0000(4), new ItemStack(Items.bone,16), 400, 0);
		addMaterialTrade(ZI(Items.coal), ItemListIG.Trade_Materials1.get(0, null), c0000(2), new ItemStack(Items.rotten_flesh,16), 400, 0);
		addMaterialTrade(ZI(Items.egg), ItemListIG.Trade_Materials1.get(0, null), c0008(1), new ItemStack(Items.slime_ball,16), 1400, 0);
		addMaterialTrade(new ItemStack(Items.wheat_seeds, 0), ItemListIG.Trade_Materials1.get(0, null), c0008(1), get(OrePrefixes.plate, Materials.Rubber, 16), 1400, 0);
		
		addMaterialTrade( 1, ItemListIG.Trade_Materials2.get(0, null), c0008(1), get(OrePrefixes.ingot, Materials.Cobalt, 16), 3200, 1);
		addMaterialTrade( 2, ItemListIG.Trade_Materials2.get(0, null), c0008(1), get(OrePrefixes.dust, Materials.Sodium, 16), 2400, 1);
		addMaterialTrade( 3, ItemListIG.Trade_Materials2.get(0, null), c0008(1), get(OrePrefixes.dust, Materials.Potassium, 16), 2400, 1);
		addMaterialTrade( 4, ItemListIG.Trade_Materials2.get(0, null), c0008(2), get(OrePrefixes.dust, Materials.Lithium, 16), 4400, 1);
		addMaterialTrade( 5, ItemListIG.Trade_Materials2.get(0, null), c0008(1), get(OrePrefixes.gem, Materials.NetherQuartz, 16), 2400, 1);
		addMaterialTrade( 6, ItemListIG.Trade_Materials2.get(0, null), c0008(2), get(OrePrefixes.ingot, Materials.Antimony, 16), 2400, 1);
		addMaterialTrade( 7, ItemListIG.Trade_Materials2.get(0, null), c0008(2), get(OrePrefixes.ingot, Materials.Magnesium, 16), 2400, 1);
		addMaterialTrade( 8, ItemListIG.Trade_Materials2.get(0, null), c0008(1), get(OrePrefixes.ingot, Materials.Nickel, 16), 2400, 1);
		addMaterialTrade( 9, ItemListIG.Trade_Materials2.get(0, null), c0008(4), get(OrePrefixes.gem, Materials.Quartzite, 16), 4000, 1);
		addMaterialTrade(10, ItemListIG.Trade_Materials2.get(0, null), c0008(4), get(OrePrefixes.ingot, Materials.Gold, 16), 4000, 1);
		addMaterialTrade(11, ItemListIG.Trade_Materials2.get(0, null), c0008(3), get(OrePrefixes.ingot, Materials.Silver, 16), 3000, 1);
		addMaterialTrade(12, ItemListIG.Trade_Materials2.get(0, null), c0064(2), get(OrePrefixes.ingot, Materials.Molybdenum, 16), 7000, 1);
		addMaterialTrade(13, ItemListIG.Trade_Materials2.get(0, null), c0064(1), get(OrePrefixes.ingot, Materials.Manganese, 16), 7000, 1);
		addMaterialTrade(14, ItemListIG.Trade_Materials2.get(0, null), c0008(2), get(OrePrefixes.dust, Materials.Graphite, 16), 2400, 1);
		addMaterialTrade(15, ItemListIG.Trade_Materials2.get(0, null), c0064(4), get(OrePrefixes.gem, Materials.Diamond, 16), 18200, 1);
		addMaterialTrade(16, ItemListIG.Trade_Materials2.get(0, null), c0064(4), get(OrePrefixes.gem, Materials.Emerald, 16), 18200, 1);
		addMaterialTrade(17, ItemListIG.Trade_Materials2.get(0, null), c0008(2), get(OrePrefixes.ingot, Materials.Vanadium, 16), 4000, 1);
		addMaterialTrade(18, ItemListIG.Trade_Materials2.get(0, null), c0064(1), new ItemStack(Items.spider_eye,16), 4000, 1);
		addMaterialTrade(19, ItemListIG.Trade_Materials2.get(0, null), c0001(1), new ItemStack(Items.experience_bottle,1), 200, 1);
		addTraderRecipe(new ItemStack[]{circ(20), ItemListIG.Trade_Materials2.get(0, null), c0008(4)}, null, Materials.OilLight.getFluid(16000), null, 4400, 0);		
		addTraderRecipe(new ItemStack[]{circ(21), ItemListIG.Trade_Materials2.get(0, null), c0008(4)}, null, Materials.OilMedium.getFluid(16000), null, 4400, 0);		
		addTraderRecipe(new ItemStack[]{circ(22), ItemListIG.Trade_Materials2.get(0, null), c0008(4)}, null, Materials.OilHeavy.getFluid(16000), null, 4400, 0);		
		
		addMaterialTrade( 1, ItemListIG.Trade_Materials3.get(0, null), c0064(1), get(OrePrefixes.ingot, Materials.Silicon, 16), 7200, 4);
		addMaterialTrade( 2, ItemListIG.Trade_Materials3.get(0, null), c0064(1), get(OrePrefixes.ingot, Materials.Aluminium, 16), 7200, 4);
		addMaterialTrade( 3, ItemListIG.Trade_Materials3.get(0, null), c0064(1), get(OrePrefixes.gem, Materials.Lazurite, 16), 7200, 4);
		addMaterialTrade( 4, ItemListIG.Trade_Materials3.get(0, null), c0064(1), get(OrePrefixes.ingot, Materials.Beryllium, 16), 7200, 4);
		addMaterialTrade( 5, ItemListIG.Trade_Materials3.get(0, null), c0064(3), get(OrePrefixes.gem, Materials.Olivine, 16), 22200, 4);
		addMaterialTrade( 6, ItemListIG.Trade_Materials3.get(0, null), c0064(3), get(OrePrefixes.gem, Materials.Sapphire, 16), 22200, 4);
		addMaterialTrade( 7, ItemListIG.Trade_Materials3.get(0, null), c0064(2), get(OrePrefixes.dust, Materials.Chrome, 16), 15200, 4);
		addMaterialTrade( 8, ItemListIG.Trade_Materials3.get(0, null), c0064(3), get(OrePrefixes.dust, Materials.Glowstone, 16), 22200, 4);
		addMaterialTrade( 9, ItemListIG.Trade_Materials3.get(0, null), c0064(2), new ItemStack(Blocks.end_stone,16), 15200, 4);
		addMaterialTrade(10, ItemListIG.Trade_Materials3.get(0, null), c0064(2), get(OrePrefixes.gem, Materials.EnderPearl, 16), 15200, 4);
		addMaterialTrade(11, ItemListIG.Trade_Materials3.get(0, null), c0064(4), new ItemStack(Items.blaze_powder,16), 30000, 4);
		addMaterialTrade(12, ItemListIG.Trade_Materials3.get(0, null), c0064(2), new ItemStack(Blocks.soul_sand,16), 15200, 4);
		addMaterialTrade(13, ItemListIG.Trade_Materials3.get(0, null), c0064(2), GT_ModHandler.getModItem("TConstruct", "strangeFood", 16), 15200, 4);

		addMaterialTrade( 1, ItemListIG.Trade_Materials4.get(0, null), c0064(4), get(OrePrefixes.ingot, Materials.Titanium, 16), 25200, 8);
		addMaterialTrade( 2, ItemListIG.Trade_Materials4.get(0, null), c0064(4), get(OrePrefixes.ingot, Materials.Neodymium, 16), 25200, 8);
		addMaterialTrade( 3, ItemListIG.Trade_Materials4.get(0, null), c0064(4), get(OrePrefixes.dust, Materials.Uraninite, 16), 25200, 8);
		addMaterialTrade( 4, ItemListIG.Trade_Materials4.get(0, null), c0512(1), get(OrePrefixes.gem, Materials.CertusQuartz, 16), 35000, 8);
		addMaterialTrade( 5, ItemListIG.Trade_Materials4.get(0, null), c0512(4), new ItemStack(Items.nether_wart,16), 70200, 4);
		addMaterialTrade( 6, ItemListIG.Trade_Materials4.get(0, null), c032k(1), new ItemStack(Items.ghast_tear,16), 192000, 4);
		addMaterialTrade( 7, ItemListIG.Trade_Materials4.get(0, null), c0064(3), GT_Utility.copyAmount(16, ReactorStacks.ammonium), 22000, 4);
		
		addMaterialTrade( 1, ItemListIG.Trade_Materials5.get(0, null), c0512(1), get(OrePrefixes.ingot, Materials.Tungsten, 16), 25200, 16);
		addMaterialTrade( 2, ItemListIG.Trade_Materials5.get(0, null), c0512(1), get(OrePrefixes.ingot, Materials.Platinum, 16), 25200, 16);
		addMaterialTrade( 3, ItemListIG.Trade_Materials5.get(0, null), c0512(1), get(OrePrefixes.ingot, Materials.Palladium, 16), 25200, 16);
		addMaterialTrade( 4, ItemListIG.Trade_Materials5.get(0, null),c0064(12), get(OrePrefixes.ingot, Materials.Iridium, 16), 40000, 16);
		addMaterialTrade( 5, ItemListIG.Trade_Materials5.get(0, null), c0512(2), get(OrePrefixes.ingot, Materials.Osmium, 16), 30200, 16);
		addMaterialTrade( 6, ItemListIG.Trade_Materials5.get(0, null), c0512(3), get(OrePrefixes.ingot, Materials.Naquadah, 16), 40000, 32);
		addMaterialTrade( 7, ItemListIG.Trade_Materials5.get(0, null), c4096(1), new ItemStack(Items.skull,1,1), 70200, 4);
		addMaterialTrade( 8, ItemListIG.Trade_Materials5.get(0, null), c032k(1), new ItemStack(Items.nether_star,1), 192000, 4);
		
		for(int i = 0;i<16;i++){
			addTraderRecipe(new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0, i, null), new ItemStack(Blocks.fence), c0000(1)}, null, null, new ItemStack[]{ItemList.DYE_ONLY_ITEMS[i].get(16, null)}, 200, 0);}
//		addTraderRecipe(new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0, i, null), new ItemStack(Blocks.fence), c0000(1)}, null, null, new ItemStack[]{new ItemStack(Items.dye, 16, i)}, 200, 0);}
		
//		Buy Ores
		addOreTrade(ItemListIG.Naquadah.get(0, null), c0512(7), Materials.Naquadah, 	Materials.Naquadah, 	Materials.Naquadah, 	Materials.NaquadahEnriched, 573440);
		addOreTrade(ItemListIG.Lignite.get(0, null), c0000(5), Materials.Lignite,		Materials.Lignite,		Materials.Lignite,		Materials.Coal, 100); //
		addOreTrade(ItemListIG.Coal.get(0, null), c0001(1), Materials.Coal,			Materials.Coal,			Materials.Coal,			Materials.Lignite, 160); //
		addOreTrade(ItemListIG.Magnetite.get(0, null), c0008(1), Materials.Magnetite,	Materials.Magnetite,	Materials.Iron,			Materials.VanadiumMagnetite, 1280); //
		addOreTrade(ItemListIG.Gold.get(0, null), c0008(3), Materials.Magnetite,	Materials.Magnetite,	Materials.VanadiumMagnetite,Materials.Gold, 3840);
		addOreTrade(ItemListIG.Iron.get(0, null), c0001(2), Materials.BrownLimonite,Materials.YellowLimonite,Materials.BandedIron,	Materials.Malachite, 320); //
		addOreTrade(ItemListIG.Cassiterite.get(0, null), c0001(4), Materials.Tin,			Materials.Tin,			Materials.Cassiterite,	Materials.Tin, 640); //
		addOreTrade(ItemListIG.Tetrahedrite.get(0, null), c0008(1), Materials.Tetrahedrite,	Materials.Tetrahedrite,	Materials.Copper,		Materials.Stibnite, 1280);
		addOreTrade(ItemListIG.NetherQuartz.get(0, null), c0008(2), Materials.NetherQuartz,	Materials.NetherQuartz,	Materials.NetherQuartz,	Materials.NetherQuartz, 2560);
		addOreTrade(ItemListIG.Sulfur.get(0, null), c0008(1), Materials.Sulfur,		Materials.Sulfur,		Materials.Pyrite,		Materials.Sphalerite, 1280);
		addOreTrade(ItemListIG.Copper.get(0, null), c0001(2), Materials.Chalcopyrite,	Materials.Iron,			Materials.Pyrite,		Materials.Copper, 320);//
		addOreTrade(ItemListIG.Bauxite.get(0, null), c0064(2), Materials.Bauxite,		Materials.Bauxite,		Materials.Bauxite,		Materials.Ilmenite, 20480);
		addOreTrade(ItemListIG.Salts.get(0, null), c0008(3), Materials.RockSalt,		Materials.Salt,			Materials.Lepidolite,	Materials.Spodumene, 3840);
		addOreTrade(ItemListIG.Redstone.get(0, null), c0008(3), Materials.Redstone,		Materials.Redstone,		Materials.Ruby,			Materials.Cinnabar, 3840);
		addOreTrade(ItemListIG.Soapstone.get(0, null), c0008(1), Materials.Soapstone,	Materials.Talc,			Materials.Glauconite,	Materials.Pentlandite, 1280);
		addOreTrade(ItemListIG.Nickel.get(0, null), c0008(2), Materials.Garnierite,	Materials.Nickel,		Materials.Cobaltite,	Materials.Pentlandite, 2560);
		addOreTrade(ItemListIG.Platinum.get(0, null), c0512(4), Materials.Cooperite,	Materials.Palladium,	Materials.Platinum,		Materials.Iridium, 327680);
		addOreTrade(ItemListIG.Pitchblende.get(0, null), c0064(4), Materials.Pitchblende,	Materials.Pitchblende,	Materials.Uraninite,	Materials.Uraninite, 40960);
		addOreTrade(ItemListIG.Plutonium.get(0, null), c0064(7), Materials.Uraninite,	Materials.Uraninite,	Materials.Uranium,		Materials.Uranium, 71680);
		addOreTrade(ItemListIG.Monazite.get(0, null), c0064(5), Materials.Bastnasite,	Materials.Bastnasite,	Materials.Monazite,		Materials.Neodymium, 51200);
		addOreTrade(ItemListIG.Molybdenum.get(0, null), c0064(1), Materials.Wulfenite,	Materials.Molybdenite,	Materials.Molybdenum,	Materials.Powellite, 10240);
		addOreTrade(ItemListIG.Tungstate.get(0, null), c0064(3), Materials.Scheelite,	Materials.Scheelite,	Materials.Tungstate,	Materials.Lithium, 30720);
		addOreTrade(ItemListIG.Sapphire.get(0, null), c0064(5), Materials.Almandine,	Materials.Pyrope,		Materials.Sapphire,		Materials.GreenSapphire, 51200);
		addOreTrade(ItemListIG.Manganese.get(0, null), c0064(1), Materials.Grossular,	Materials.Spessartine,	Materials.Pyrolusite,	Materials.Tantalite, 10240);
		addOreTrade(ItemListIG.Quartz.get(0, null), c0512(1), Materials.Quartzite,	Materials.Barite,		Materials.CertusQuartz,	Materials.CertusQuartz, 81920);
		addOreTrade(ItemListIG.Diamond.get(0, null), c0064(3), Materials.Graphite,		Materials.Graphite,		Materials.Diamond,		Materials.Coal, 30720);
		addOreTrade(ItemListIG.Olivine.get(0, null), c0064(2), Materials.Bentonite,	Materials.Magnesite,	Materials.Olivine,		Materials.Glauconite, 20480);
		addOreTrade(ItemListIG.Apatite.get(0, null), c0000(6), Materials.Apatite,		Materials.Apatite,		Materials.Phosphorus,	Materials.Phosphate, 120);
		addOreTrade(ItemListIG.Galena.get(0, null), c0008(2), Materials.Galena,		Materials.Galena,		Materials.Silver,		Materials.Lead, 2560);
		addOreTrade(ItemListIG.Lapis.get(0, null), c0008(3), Materials.Lazurite,		Materials.Sodalite,		Materials.Lapis,		Materials.Calcite, 3840);
		addOreTrade(ItemListIG.Beryllium.get(0, null), c0064(2), Materials.Beryllium,	Materials.Beryllium,	Materials.Emerald,		Materials.Thorium, 20480);
		
//		Buy Animals
		addMaterialTrade(ZB(Blocks.cobblestone), ItemListIG.Trade_Animals.get(0, null), c0008(1), new ItemStack(Items.egg,16), 192, 0);
		addMaterialTrade(ZB(Blocks.stone), ItemListIG.Trade_Animals.get(0, null), c0008(3), new ItemStack(Items.spawn_egg,1,92), 192, 0);
		addMaterialTrade(ZB(Blocks.gravel), ItemListIG.Trade_Animals.get(0, null), c0008(2), new ItemStack(Items.spawn_egg,1,90), 192, 0);
		addMaterialTrade(ZB(Blocks.sand), ItemListIG.Trade_Animals.get(0, null), c0008(2), new ItemStack(Items.spawn_egg,1,91), 192, 0);
		
//		Buy Energy		
        IGCore.sEnergyTradeFuels.addRecipe(true, new ItemStack[]{ItemList.Credit_Greg_Copper.get(1, null)}, null, null, null, null, 0, 0, 15);
        IGCore.sEnergyTradeFuels.addRecipe(true, new ItemStack[]{ItemList.Credit_Greg_Cupronickel.get(1, null)}, null, null, null, null, 0, 0, 100);
        IGCore.sEnergyTradeFuels.addRecipe(true, new ItemStack[]{ItemList.Credit_Greg_Silver.get(1, null)}, null, null, null, null, 0, 0, 750);
        IGCore.sEnergyTradeFuels.addRecipe(true, new ItemStack[]{ItemList.Credit_Greg_Gold.get(1, null)}, null, null, null, null, 0, 0, 5000);
        IGCore.sEnergyTradeFuels.addRecipe(true, new ItemStack[]{ItemList.Credit_Greg_Platinum.get(1, null)}, null, null, null, null, 0, 0, 32000);
        IGCore.sEnergyTradeFuels.addRecipe(true, new ItemStack[]{ItemList.Credit_Greg_Osmium.get(1, null)}, null, null, null, null, 0, 0, 200000);
        IGCore.sEnergyTradeFuels.addRecipe(true, new ItemStack[]{ItemList.Credit_Greg_Naquadah.get(1, null)}, null, null, null, null, 0, 0, 1200000);
        
//      Sell Energy
        
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp1.get(0, null),ItemListIG.Trade_EnergyVolt1.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Copper.get(1, null)}, 900, 16);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp2.get(0, null),ItemListIG.Trade_EnergyVolt1.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Copper.get(1, null)}, 600, 24);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp3.get(0, null),ItemListIG.Trade_EnergyVolt1.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Copper.get(1, null)}, 510, 28);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp4.get(0, null),ItemListIG.Trade_EnergyVolt1.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Copper.get(1, null)}, 450, 32);
		
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp1.get(0, null),ItemListIG.Trade_EnergyVolt2.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Cupronickel.get(1, null)}, 2250, 64);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp2.get(0, null),ItemListIG.Trade_EnergyVolt2.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Cupronickel.get(1, null)}, 1500, 96);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp3.get(0, null),ItemListIG.Trade_EnergyVolt2.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Cupronickel.get(1, null)}, 1275, 112);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp4.get(0, null),ItemListIG.Trade_EnergyVolt2.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Cupronickel.get(1, null)}, 1125, 128);

		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp1.get(0, null),ItemListIG.Trade_EnergyVolt3.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Silver.get(1, null)}, 5625, 256);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp2.get(0, null),ItemListIG.Trade_EnergyVolt3.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Silver.get(1, null)}, 3750, 384);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp3.get(0, null),ItemListIG.Trade_EnergyVolt3.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Silver.get(1, null)}, 3200, 448);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp4.get(0, null),ItemListIG.Trade_EnergyVolt3.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Silver.get(1, null)}, 2800, 512);

		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp1.get(0, null),ItemListIG.Trade_EnergyVolt4.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Gold.get(1, null)}, 14062, 1024);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp2.get(0, null),ItemListIG.Trade_EnergyVolt4.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Gold.get(1, null)}, 9400, 1536);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp3.get(0, null),ItemListIG.Trade_EnergyVolt4.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Gold.get(1, null)}, 8000, 1792);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp4.get(0, null),ItemListIG.Trade_EnergyVolt4.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Gold.get(1, null)}, 7000, 2048);

		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp1.get(0, null),ItemListIG.Trade_EnergyVolt5.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Platinum.get(1, null)}, 35200, 4096);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp2.get(0, null),ItemListIG.Trade_EnergyVolt5.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Platinum.get(1, null)}, 23500, 6144);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp3.get(0, null),ItemListIG.Trade_EnergyVolt5.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Platinum.get(1, null)}, 20000, 7168);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp4.get(0, null),ItemListIG.Trade_EnergyVolt5.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Platinum.get(1, null)}, 17500, 8192);

		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp1.get(0, null),ItemListIG.Trade_EnergyVolt6.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Osmium.get(1, null)}, 88000, 16384);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp2.get(0, null),ItemListIG.Trade_EnergyVolt6.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Osmium.get(1, null)}, 60000, 24576);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp3.get(0, null),ItemListIG.Trade_EnergyVolt6.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Osmium.get(1, null)}, 50000, 28672);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp4.get(0, null),ItemListIG.Trade_EnergyVolt6.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Osmium.get(1, null)}, 44000, 32768);

		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp1.get(0, null),ItemListIG.Trade_EnergyVolt7.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Naquadah.get(1, null)}, 220000, 65536);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp2.get(0, null),ItemListIG.Trade_EnergyVolt7.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Naquadah.get(1, null)}, 150000, 98304);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp3.get(0, null),ItemListIG.Trade_EnergyVolt7.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Naquadah.get(1, null)}, 125000, 114688);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp4.get(0, null),ItemListIG.Trade_EnergyVolt7.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Naquadah.get(1, null)}, 110000, 131072);

		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp1.get(0, null),ItemListIG.Trade_EnergyVolt8.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Neutronium.get(1, null)}, 550000, 262144);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp2.get(0, null),ItemListIG.Trade_EnergyVolt8.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Neutronium.get(1, null)}, 375000, 393216);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp3.get(0, null),ItemListIG.Trade_EnergyVolt8.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Neutronium.get(1, null)}, 312000, 458752);
		addTraderRecipe(new ItemStack[]{ItemListIG.Trade_EnergyAmp4.get(0, null),ItemListIG.Trade_EnergyVolt8.get(0, null)}, null, null, new ItemStack[]{ItemList.Credit_Greg_Neutronium.get(1, null)}, 275000, 524288);
		
//      Sell building materials
        addSTrade(c0000(1), 600, 0,new ItemStack[]{ItemListIG.Trade_Building.get(0, null), new ItemStack(Blocks.stonebrick, 16)});								//		Stone Bricks 0,25/min
        addSTrade(c0000(2), 800, 0,new ItemStack[]{ItemListIG.Trade_Building.get(0, null), new ItemStack(Blocks.gravel, 16), new ItemStack(Blocks.sand, 16)});	//		gravel/sand 0,38/min
        addSTrade(c0000(4),1200, 0,new ItemStack[]{ItemListIG.Trade_Building.get(0, null), new ItemStack(Blocks.planks, 16, GT_Values.W), new ItemStack(Blocks.planks, 16, GT_Values.W)});	//		planks multiple types 0,5/min
        addSTrade(c0000(3), 900, 0,new ItemStack[]{ItemListIG.Trade_Building.get(0, null), new ItemStack(Blocks.glass_pane, 16)});								//		glass planes 0,5/min
        addSTrade(c0000(4), 600, 0,new ItemStack[]{ItemListIG.Trade_Building.get(0, null), new ItemStack(Blocks.brick_block, 16)});								//		Bricks 1/min
        addSTrade(c0000(6), 600, 0,new ItemStack[]{ItemListIG.Trade_Building.get(0, null), GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 16)});//		carpentersblock(2,5 wood) 1,5/min
        addSTrade(c0001(2), 1200, 0,new ItemStack[]{ItemListIG.Trade_Building.get(0, null), GT_ModHandler.getModItem("ImmersiveEngineering", "stoneDecoration", 16,4)});//		immersive concrete 2/min
        addSTrade(c0000(12),1200, 0,new ItemStack[]{ItemListIG.Trade_Building.get(0, null), GT_ModHandler.getModItem("chisel", "factoryblock", 16)});//		factory block 1,5/min
        addSTrade(c0001(4), 1200, 0,new ItemStack[]{ItemListIG.Trade_Building.get(0, null), GT_ModHandler.getModItem("chisel", "laboratoryblock", 16)});//		laboratory 3/min
//		Reinforced stone/glass
//		GT concrete
//		railcraft concrete
//		plascrete
//		steel scraffolding
		
//		Trade_Furniture
        addSTrade(c0001(8), 2400, 0,new ItemStack[]{ItemListIG.Trade_Furniture.get(0, null), GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersBed", 16)});//      bed 4/min
        addSTrade(c0001(5), 2400, 0,new ItemStack[]{ItemListIG.Trade_Furniture.get(0, null), GT_ModHandler.getModItem("BiblioCraft", "BiblioTable", 16,GT_Values.W), GT_ModHandler.getModItem("BiblioCraft", "BiblioShelf", 16,GT_Values.W)});//      shelf + table 2,5/min
        addSTrade(c0001(2), 1200, 0,new ItemStack[]{ItemListIG.Trade_Furniture.get(0, null), GT_ModHandler.getModItem("BiblioCraft", "BiblioSeats", 16,GT_Values.W)});//      seat 2/min
        addSTrade(c0000(12),3600, 0,new ItemStack[]{ItemListIG.Trade_Furniture.get(0, null), GT_ModHandler.getModItem("BiblioCraft", "BiblioDesk", 16,GT_Values.W)});//      desk 4/min
        addSTrade(c0001(3), 1200, 0,new ItemStack[]{ItemListIG.Trade_Furniture.get(0, null), new ItemStack(Items.item_frame,16)});									//      bronze boiler  3/min 
        
//		Trade_Food
        addSTrade(c0000(12), 1800, 0,new ItemStack[]{ItemListIG.Trade_Food.get(0, null), new ItemStack(Items.apple, 16)});										//      apple 1,5/min
        addSTrade(c0001(2), 1200, 0,new ItemStack[]{ItemListIG.Trade_Food.get(0, null), new ItemStack(Items.porkchop, 16)});									//      porkchop 2/min
        addSTrade(c0001(3),1200, 0,new ItemStack[]{ItemListIG.Trade_Food.get(0, null), new ItemStack(Items.beef, 16)});											//      steak  3/min
        addSTrade(c0000(12), 1200, 0,new ItemStack[]{ItemListIG.Trade_Food.get(0, null), new ItemStack(Items.cooked_chicken, 16)});								//      chicken 1,5/min
        addSTrade(c0001(6), 1200, 0,new ItemStack[]{ItemListIG.Trade_Food.get(0, null), GT_ModHandler.getModItem("TConstruct", "jerky", 16, GT_Values.W)});		//      jerky 6/min
        addSTrade(c0001(3), 900, 0,new ItemStack[]{ItemListIG.Trade_Food.get(0, null), GT_OreDictUnificator.get(OrePrefixes.dust,Materials.Wheat,64)});			//      flour 4/min
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Food.get(0, null), new ItemStack(Items.bread, 16)});										//      bread 6/min
        addSTrade(c0001(2), 1800, 0,new ItemStack[]{ItemListIG.Trade_Food.get(0, null), new ItemStack(Items.carrot, 16), new ItemStack(Items.potato, 16)});		//      carrot + potato 1,5/min
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Food.get(0, null), new ItemStack(Items.melon, 16), new ItemStack(Blocks.pumpkin, 4)});		//      melon + pump 2/min
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Food.get(0, null), new ItemStack(Items.cake, 16)});										//      cake
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Food.get(0, null), new ItemStack(Items.pumpkin_pie, 16)});									//      pumpkin cake
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Food.get(0, null), new ItemStack(Items.cookie, 16)});										//      cooky
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Food.get(0, null), ItemList.ThermosCan_Chocolate_Milk.get(16, null)});						//      chocolate milk
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Food.get(0, null), ItemList.Food_Packaged_Fries.get(16, null), ItemList.Bottle_Lemonade.get(16, null), ItemList.Food_Burger_Meat.get(16, null)});//fries, limonade hamburger
                
//		Trade_Chemical     
        addTraderRecipe(new ItemStack[]{ItemListIG.Trade_Chemical.get(0,null)}, Materials.Fuel.getFluid(16000), null, new ItemStack[]{c0001(1)}, 10000, 1);				//      fuel
        addTraderRecipe(new ItemStack[]{ItemListIG.Trade_Chemical.get(0,null)}, Materials.NitroFuel.getFluid(16000), null, new ItemStack[]{c0001(1)}, 10000, 1);		//		nitrofuel
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Chemical.get(0, null), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 16)});		//      plastics
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Chemical.get(0, null), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polycaprolactam, 16)});//		nylon
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Chemical.get(0, null), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 16)});		//		silicone
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Chemical.get(0, null), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polytetrafluoroethylene, 16)});//teflon
        addTraderRecipe(new ItemStack[]{ItemListIG.Trade_Chemical.get(0,null)}, Materials.Gas.getGas(16000), null, new ItemStack[]{c0001(1)}, 10000, 1);				//      gas
        addTraderRecipe(new ItemStack[]{ItemListIG.Trade_Chemical.get(0,null)}, Materials.SodiumPersulfate.getFluid(16000), null, new ItemStack[]{c0001(1)}, 10000, 1);	//      sodium persulfate
        addTraderRecipe(new ItemStack[]{ItemListIG.Trade_Chemical.get(0,null)}, Materials.SulfuricAcid.getFluid(16000), null, new ItemStack[]{c0001(1)}, 10000, 1);		//      acids
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Chemical.get(0, null), new ItemStack(Blocks.tnt, 16)});											//      tnt
        addTraderRecipe(new ItemStack[]{ItemListIG.Trade_Chemical.get(0,null)}, new FluidStack(FluidRegistry.getFluid("bioethanol"),16000), null, new ItemStack[]{c0001(1)}, 10000, 1);	//ethanol
        addTraderRecipe(new ItemStack[]{ItemListIG.Trade_Chemical.get(0,null)}, new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"),16000), null, new ItemStack[]{c0001(1)}, 10000, 1);		//      acids
        
//		Trade_Electronics
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "keyboard", 16)});//      keyboard
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "screen1", 16)});//      monitor
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "screen2", 16)});//      monitor 2
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "screen3", 16)});//      monitor 3
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "case1", 16)});//      case1
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "case2", 16)});//      case2
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "case3", 16)});//      case3
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "hologram1", 16)});//      hologram1
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "hologram2", 16)});//      hologram2
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "item", 16,8)});//      grafics1
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "item", 16,9)});//      grafics2
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "item", 16,10)});//      grafics3
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "item", 16,5)});//      hdd1
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "item", 16,6)});//      hdd2
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "item", 16,7)});//      hdd3
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "item", 16,95)});//      ink
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "item", 16,1)});//      memory1
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "item", 16,50)});//      memory15
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "item", 16,2)});//      memory2
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "item", 16,3)});//      memory25
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "item", 16,38)});//      memory3
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "item", 16,39)});//      memory35
        addSTrade(c0001(9), 1800, 0,new ItemStack[]{ItemListIG.Trade_Electronics.get(0, null), GT_ModHandler.getModItem("OpenComputers", "item", 16,107)});//     nano
      
        
//		Trade_Nuclear
//      radioactive produts
//      nuclear fuels
//      nuke
        
//		Trade_Drug
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Drug.get(0, null), new ItemStack(Items.potionitem, 1,8193)});										//      regen1        
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Drug.get(0, null), new ItemStack(Items.potionitem, 1,8194)});										//      speed1      										
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Drug.get(0, null), new ItemStack(Items.potionitem, 1,8195)});										//      fireres1       										
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Drug.get(0, null), new ItemStack(Items.potionitem, 1,8197)});										//      healing										
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Drug.get(0, null), new ItemStack(Items.potionitem, 1,8198)});										//      nightvision        										
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Drug.get(0, null), new ItemStack(Items.potionitem, 1,8201)});										//      strenght     										
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Drug.get(0, null), new ItemStack(Items.potionitem, 1,8225)});										//      regen2    										
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Drug.get(0, null), new ItemStack(Items.potionitem, 1,8226)});										//      speed2 										
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Drug.get(0, null), new ItemStack(Items.potionitem, 1,8229)});										//      heal2   									
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Drug.get(0, null), new ItemStack(Items.potionitem, 1,8233)});										//      strengh2  									
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Drug.get(0, null), new ItemStack(Items.potionitem, 1,8257)});										//      regenlong  									
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Drug.get(0, null), new ItemStack(Items.potionitem, 1,8258)});										//      speedlong    									
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Drug.get(0, null), new ItemStack(Items.potionitem, 1,8259)});										//      firereslong  									
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Drug.get(0, null), new ItemStack(Items.potionitem, 1,8262)});										//      nightlong  									
        addSTrade(c0001(3), 1800, 0,new ItemStack[]{ItemListIG.Trade_Drug.get(0, null), new ItemStack(Items.potionitem, 1,8265)});										//      strenghtlong   										
        
//		Trade_Engineering 									
        addSTrade(c0001(10),2400, 0,new ItemStack[]{ItemListIG.Trade_Engineering.get(0, null), GT_ModHandler.getModItem("Railcraft", "machine.beta", 24),GT_ModHandler.getModItem("Railcraft", "machine.beta", 8,1),GT_ModHandler.getModItem("Railcraft", "machine.beta", 2,2)});//railcraft tanks 3/min
        addSTrade(c0008(4), 4800, 0,new ItemStack[]{ItemListIG.Trade_Engineering.get(0, null), GT_ModHandler.getModItem("Railcraft", "machine.beta", 24,13),GT_ModHandler.getModItem("Railcraft", "machine.beta", 8,14),GT_ModHandler.getModItem("Railcraft", "machine.beta", 2,14)});//railcraft tanks 6/min							
        addSTrade(c0008(3), 2400, 0,new ItemStack[]{ItemListIG.Trade_Engineering.get(0, null), ItemList.Machine_Bronze_Boiler.get(16,null)});										//      bronze boiler  4/min 	
        addSTrade(c0008(6), 3600, 0,new ItemStack[]{ItemListIG.Trade_Engineering.get(0, null), ItemList.Machine_Steel_Boiler.get(16,null)});										//      bronze boiler  8/min     
//      production machines	
        addSTrade(c0008(4), 3600, 0,new ItemStack[]{ItemListIG.Trade_Engineering.get(0, null), GT_ModHandler.getModItem("ProjRed:Transmission", "projectred.transmission.wire", 16)});	//      project red stuff 3/min
        addSTrade(c0008(10), 7200, 0,new ItemStack[]{ItemListIG.Trade_Engineering.get(0, null), GT_ModHandler.getModItem("ProjRed:Transmission", "projectred.transmission.wire", 3,17)});	//      project red stuff 4/min
//      circuits
        
//		Trade_Metal
//      screws, motors, punps, robot arms ect.	
        addSTrade(c0001(7), 1800, 0,new ItemStack[]{ItemListIG.Trade_Metal.get(0, null), GT_ModHandler.getModItem("ImmersiveEngineering", "metalDevice", 16 ,11)});//conveyor  2/min 
        addSTrade(c0001(4), 1200, 0,new ItemStack[]{ItemListIG.Trade_Metal.get(0, null), new ItemStack(Blocks.piston,16)});									//      bronze boiler  2/min 
        addSTrade(c0001(4), 1200, 0,new ItemStack[]{ItemListIG.Trade_Metal.get(0, null), GT_OreDictUnificator.get(OrePrefixes.screw, Material.iron, 16)});	//      bronze boiler  2/min  
        addSTrade(c0001(32), 1400, 0,new ItemStack[]{ItemListIG.Trade_Metal.get(0, null), ItemList.Electric_Motor_LV.get(16,null)});						//      bronze boiler  2/min  
        
//		Trade_Weaponary
//      Mining laser
//      swords
//      armors
//      immeng weapons
        
//		Trade_Misc
//      GT tape
        
		
		

		

	}
	
	public static void addSTrade(ItemStack aOut, int time, int eu, ItemStack[] aIn){
		if(aIn==null||aOut==null)return;
		if(aIn.length<1)return;
		for(ItemStack tS : aIn){
			if(tS==null)return;
		}
		addTraderRecipe(aIn,null,null,new ItemStack[]{aOut},time,eu);
	}
	
	public static void postLoad(){
		GT_ModHandler.removeRecipeByOutput(new ItemStack(Items.brewing_stand));
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","blockCrop", 2));
		Util.removeRecipeByOutput(ItemList.Machine_HV_Macerator.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_EV_Macerator.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_IV_Macerator.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_LuV_Macerator.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_ZPM_Macerator.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_UV_Macerator.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_LV_Sifter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_MV_Sifter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_HV_Sifter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_EV_Sifter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_IV_Sifter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_LuV_Sifter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_ZPM_Sifter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_UV_Sifter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_LV_AlloySmelter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_MV_AlloySmelter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_HV_AlloySmelter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_EV_AlloySmelter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_IV_AlloySmelter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_LuV_AlloySmelter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_ZPM_AlloySmelter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_UV_AlloySmelter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_Bronze_AlloySmelter.get(1, null));
		Util.removeRecipeByOutput(ItemList.Machine_Steel_AlloySmelter.get(1, null));
		Util.removeRecipeByOutput(ItemList.OilDrill.get(1, null));
		Util.removeRecipeByOutput(new ItemStack(Items.cake));
		Util.removeRecipeByOutput(new ItemStack(Items.book));
		GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("chisel","smashingrock",8), new Object[]{new ItemStack(Items.stone_pickaxe),new ItemStack(Items.stone_shovel),new ItemStack(Blocks.glass)});
		Util.removeRecipeByOutput(ItemList.Charcoal_Pile.get(1, null));
		GT_ModHandler.addCraftingRecipe(ItemList.Charcoal_Pile.get(1, null),  new Object[]{"EME", "CCC", 'M', ItemList.Hull_Bronze_Bricks, 'E', OrePrefixes.nugget.get(Materials.Iron), 'C', new ItemStack(Items.flint, 1)});
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("TConstruct", "Armor.DryingRack", 1), new Object[]{"EEE", 'E', new ItemStack(Blocks.wooden_slab,1,GT_Values.W)});
		Util.removeRecipeByOutput(ItemList.OilDrill.get(1, null));
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("questbook", "questBook", 1), new Object[]{"EA", 'E', GT_ModHandler.getModItem("TConstruct", "blankPattern", 1),'A',new ItemStack(Items.stick,1)});
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("progressiveautomation","Planter", 1));
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("progressiveautomation","Killer", 1));
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Magneticraft","crafter", 1));
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Magneticraft","crafter", 1),  new Object[]{"EME", "CCC", 'M', ItemList.Hull_LV, 'E', GT_ModHandler.getModItem("BuildCraft|Factory","autoWorkbenchBlock", 1), 'C', OrePrefixes.block.get(Materials.Iron)});
		
		
	}
	
	public static ItemStack ZB(Block tBlock){
		return GT_Utility.copyAmount(0, new ItemStack(tBlock));
	}
	
	public static ItemStack ZI(Item tItem){
		return GT_Utility.copyAmount(0, new ItemStack(tItem));
	}
	
	public static ItemStack circ(int aValue){
		return ItemList.Circuit_Integrated.getWithDamage(0, aValue, null);
	}
	
	public static ItemStack c0000(int aAmount){
		return ItemList.Credit_Greg_Copper.get(aAmount, null);
	}
	
	public static ItemStack c0001(int aAmount){
		return ItemList.Credit_Greg_Cupronickel.get(aAmount, null);
	}
	
	public static ItemStack c0008(int aAmount){
		return ItemList.Credit_Greg_Silver.get(aAmount, null);
	}
	
	public static ItemStack c0064(int aAmount){
		return ItemList.Credit_Greg_Gold.get(aAmount, null);
	}
	
	public static ItemStack c0512(int aAmount){
		return ItemList.Credit_Greg_Platinum.get(aAmount, null);
	}
	
	public static ItemStack c4096(int aAmount){
		return ItemList.Credit_Greg_Osmium.get(aAmount, null);
	}
	
	public static ItemStack c032k(int aAmount){
		return ItemList.Credit_Greg_Naquadah.get(aAmount, null);
	}
	
	public static ItemStack c262k(int aAmount){
		return ItemList.Credit_Greg_Neutronium.get(aAmount, null);
	}
	
	public static boolean addOreTrade(ItemStack card, ItemStack coin, Materials aMaterial1, Materials aMaterial2, Materials aMaterial3, Materials aMaterial4, int aDuration){
		addTraderRecipe(new ItemStack[]{card, coin}, null, null, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ore, aMaterial1, 6),GT_OreDictUnificator.get(OrePrefixes.ore, aMaterial2, 5),GT_OreDictUnificator.get(OrePrefixes.ore, aMaterial3, 3),GT_OreDictUnificator.get(OrePrefixes.ore, aMaterial4, 2)}, aDuration, 1);		
		return true;
	}
	
	public static boolean addMaterialTrade(ItemStack aIn, ItemStack card, ItemStack coin, ItemStack aOutput, int aDuration, int aEUt ){
		addTraderRecipe(new ItemStack[]{aIn,card,coin}, null, null, new ItemStack[]{aOutput}, aDuration, aEUt);
		return true;
	}
	
	public static boolean addMaterialTrade(int circuit, ItemStack card, ItemStack coin, ItemStack aOutput, int aDuration, int aEUt ){
		addTraderRecipe(new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0, circuit, null),card,coin}, null, null, new ItemStack[]{aOutput}, aDuration, aEUt);
		return true;
	}
    
    public static boolean addTraderRecipe(ItemStack[] aInput, FluidStack aFluidInput, FluidStack aFluidOutput, ItemStack[] aOutput, int aDuration, int aEUt) {
        if (((aInput == null) && (aFluidInput == null)) || ((aOutput == null) && (aFluidOutput == null)) || ((aInput.length == 1) && (aFluidInput == null))) {return false;}        
        IGCore.sTraderRecipes.addRecipe(false, aInput, aOutput, null, null, new FluidStack[]{aFluidInput}, new FluidStack[]{aFluidOutput}, aDuration, aEUt, 0);
        return true;
    }
    
    public static ItemStack get(OrePrefixes aPrefix, Materials aMaterial, int aAmount){
    	return GT_OreDictUnificator.get(aPrefix, aMaterial, aAmount);
    }
}
