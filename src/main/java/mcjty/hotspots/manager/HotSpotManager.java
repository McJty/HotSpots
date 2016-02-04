package mcjty.hotspots.manager;

import mcjty.hotspots.api.*;

import java.util.HashMap;
import java.util.Map;

public class HotSpotManager implements IHotSpotManager {

    private Map<String, IHotSpotType> hotSpotTypes = new HashMap<>();

    public void clear() {
        hotSpotTypes.clear();
    }

    public void clearHotSpots() {
        for (IHotSpotType type : hotSpotTypes.values()) {
            type.clear();
        }
    }

    public Map<String, IHotSpotType> getHotSpotTypes() {
        return hotSpotTypes;
    }

    @Override
    public IChunkHotSpotTypeBuilder createChunkHotSpotTypeBuilder() {
        return new ChunkHotSpotTypeBuilder();
    }

    @Override
    public IRadiatingHotSpotTypeBuilder createRadiatingHotSpotTypeBuilder() {
        return new RadiatingHotSpotTypeBuilder();
    }

    @Override
    public IHotSpotType registerHotSpotType(String id, IHotSpotTypeBuilder builder) {
        IHotSpotType type;
        switch (((HotSpotTypeBuilder) builder).getAttenuation()) {
            case RADIATE:
                type = new RadiatingHotSpotType(id, (RadiatingHotSpotTypeBuilder) builder);
                break;
            case RADIATE_BLOCKER:
                type = new RadiatingHotSpotType(id, (RadiatingHotSpotTypeBuilder) builder);
                break;
            case CHUNK:
                type = new ChunkHotSpotType(id, (ChunkHotSpotTypeBuilder) builder);
                break;
            default:
                return null;
        }
        hotSpotTypes.put(id, type);
        return type;
    }

    @Override
    public IHotSpotType getHotSpotType(String id) {
        return hotSpotTypes.get(id);
    }
}
