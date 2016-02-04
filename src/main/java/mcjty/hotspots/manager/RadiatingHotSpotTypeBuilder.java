package mcjty.hotspots.manager;

import mcjty.hotspots.api.HotSpotAttenuation;
import mcjty.hotspots.api.IRadiatingHotSpotTypeBuilder;

public class RadiatingHotSpotTypeBuilder extends HotSpotTypeBuilder<RadiatingHotSpotTypeBuilder> implements IRadiatingHotSpotTypeBuilder<RadiatingHotSpotTypeBuilder> {
    @Override
    public HotSpotAttenuation getAttenuation() {
        return HotSpotAttenuation.RADIATE;
    }
}
