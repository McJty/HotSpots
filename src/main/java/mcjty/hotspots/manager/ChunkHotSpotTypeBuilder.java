package mcjty.hotspots.manager;

import mcjty.hotspots.api.HotSpotAttenuation;
import mcjty.hotspots.api.IChunkHotSpotTypeBuilder;

public class ChunkHotSpotTypeBuilder extends HotSpotTypeBuilder<ChunkHotSpotTypeBuilder> implements IChunkHotSpotTypeBuilder<ChunkHotSpotTypeBuilder> {
    @Override
    public HotSpotAttenuation getAttenuation() {
        return HotSpotAttenuation.CHUNK;
    }
}
