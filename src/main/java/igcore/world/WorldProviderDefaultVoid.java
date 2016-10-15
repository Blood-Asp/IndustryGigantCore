package igcore.world;

import igcore.IGCore;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderDefaultVoid
  extends WorldProvider
{
	@Override
  public String getDimensionName()
  {
    return "Overworld";
  }
  @Override
  public IChunkProvider createChunkGenerator()
  {
    return new ChunkProviderDefaultVoid(this.worldObj, this.worldObj.getSeed(), false);
  }  
  
  @Override
  public ChunkCoordinates getRandomizedSpawnPoint()
  {
      ChunkCoordinates chunkcoordinates = new ChunkCoordinates(this.worldObj.getSpawnPoint());

      boolean isAdventure = worldObj.getWorldInfo().getGameType() == GameType.ADVENTURE;
      int spawnFuzz = terrainType.getSpawnFuzz();
      int spawnFuzzHalf = spawnFuzz / 2;

      if (!hasNoSky && !isAdventure && net.minecraftforge.common.ForgeModContainer.defaultHasSpawnFuzz)
      {
          chunkcoordinates.posX += this.worldObj.rand.nextInt(spawnFuzz) - spawnFuzzHalf;
          chunkcoordinates.posZ += this.worldObj.rand.nextInt(spawnFuzz) - spawnFuzzHalf;
          chunkcoordinates.posY = this.worldObj.getTopSolidOrLiquidBlock(chunkcoordinates.posX, chunkcoordinates.posZ);
      }
      
      if(IGCore.voidOverworld){
    	  chunkcoordinates.posX = 8;
    	  chunkcoordinates.posZ = 8;
    	  chunkcoordinates.posY = this.worldObj.getTopSolidOrLiquidBlock(chunkcoordinates.posX, chunkcoordinates.posZ);
      }

      return chunkcoordinates;
  }
  
}
