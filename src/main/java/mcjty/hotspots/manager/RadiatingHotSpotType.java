package mcjty.hotspots.manager;

import com.google.common.collect.Maps;
import mcjty.hotspots.api.IRadiatingHotSpot;
import mcjty.hotspots.varia.GlobalCoordinate;
import net.minecraft.nbt.NBTTagCompound;

import java.util.Map;

public class RadiatingHotSpotType extends AbstractHotSpotType {

    private final Map<GlobalCoordinate, IRadiatingHotSpot> sources = Maps.newHashMap();

    public RadiatingHotSpotType(String id, RadiatingHotSpotTypeBuilder builder) {
        super(id, builder);
    }

    @Override
    public void clear() {
        sources.clear();
    }

    @Override
    public void createFromNBT(NBTTagCompound tag) {

    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {

    }
}
