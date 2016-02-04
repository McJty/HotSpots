package mcjty.hotspots.api;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 * A hotspot.
 */
public interface IHotSpot {

    /**
     * Get the type of this hotspot
     * @return
     */
    IHotSpotType getType();

    /**
     * Get the strength of the hotspotield at a certain point in the world
     * @param world
     * @param pos
     * @return
     */
    float getStrength(World world, BlockPos pos);
}
