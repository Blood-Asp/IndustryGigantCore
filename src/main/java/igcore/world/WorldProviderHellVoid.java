package igcore.world;

import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderHellVoid extends WorldProviderHell{

	@Override
    public IChunkProvider createChunkGenerator()
    {
        return new ChunkProviderHellVoid(worldObj, worldObj.getSeed());
    }
}