package mcjty.hotspots.world;

import mcjty.hotspots.api.IHotSpotType;
import mcjty.hotspots.manager.HotSpotManager;
import mcjty.hotspots.manager.AbstractHotSpotType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraftforge.common.util.Constants;

public class HotSpotStorage extends WorldSavedData {

    public static final String HOTSPOT_STORAGE_NAME = "HotSpotStorage";
    private static HotSpotStorage instance = null;

    private final HotSpotManager hotSpotManager = new HotSpotManager();
//    private final Map<GlobalCoordinate, RadiationSource> sources = Maps.newHashMap();

    public HotSpotStorage(String identifier) {
        super(identifier);
    }

    public void save(World world) {
        world.setItemData(HOTSPOT_STORAGE_NAME, this);
        markDirty();
    }

    public static void clearInstance() {
        if (instance != null) {
            instance.hotSpotManager.clear();
            instance = null;
        }
    }

    public void removeAllHotSpots() {
        hotSpotManager.clear();
    }

    public static HotSpotStorage getStorage() {
        return instance;
    }

    public static HotSpotStorage getStorage(World world) {
        if (world.isRemote) {
            return null;
        }
        if (instance != null) {
            return instance;
        }
        instance = (HotSpotStorage) world.loadItemData(HotSpotStorage.class, HOTSPOT_STORAGE_NAME);
        if (instance == null) {
            instance = new HotSpotStorage(HOTSPOT_STORAGE_NAME);
        }
        return instance;
    }

    public HotSpotManager getHotSpotManager() {
        return hotSpotManager;
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        hotSpotManager.clearHotSpots();
        NBTTagList lst = tagCompound.getTagList("hotspots", Constants.NBT.TAG_COMPOUND);
        for (int i = 0; i < lst.tagCount(); i++) {
            NBTTagCompound tc = lst.getCompoundTagAt(i);
            String id = tc.getString("id");
            IHotSpotType type = hotSpotManager.getHotSpotType(id);
            ((AbstractHotSpotType) type).createFromNBT(tc);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        NBTTagList lst = new NBTTagList();
        for (IHotSpotType type : hotSpotManager.getHotSpotTypes().values()) {
            NBTTagCompound tc = new NBTTagCompound();
            tc.setString("id", type.getID());
            ((AbstractHotSpotType) type).writeToNBT(tc);
            lst.appendTag(tc);
        }
        tagCompound.setTag("hotspots", lst);
    }
}