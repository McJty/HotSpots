package mcjty.hotspots.worldgen;


import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class HotSpotGenerator implements IWorldGenerator {
    public static HotSpotGenerator instance = new HotSpotGenerator();

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        generateWorld(random, chunkX, chunkZ, world);
    }

    public void generateWorld(Random random, int chunkX, int chunkZ, World world) {
    }
}
