package mcjty.hotspots.manager;

import mcjty.hotspots.api.IHotSpotType;
import mcjty.hotspots.api.IRadiatingHotSpot;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class RadiatingHotSpot implements IRadiatingHotSpot {

    private final IHotSpotType type;
    private float strength;

    public RadiatingHotSpot(IHotSpotType type) {
        this.type = type;
    }

    @Override
    public float getStrength(World world, BlockPos pos) {
        return strength;
    }

    @Override
    public IHotSpotType getType() {
        return type;
    }
}
