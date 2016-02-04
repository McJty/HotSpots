package mcjty.hotspots.varia;

import net.minecraft.util.BlockPos;

public class GlobalCoordinate {
    private final BlockPos coordinate;
    private final int dimension;

    public GlobalCoordinate(BlockPos coordinate, int dimension) {
        this.coordinate = coordinate;
        this.dimension = dimension;
    }

    public BlockPos getCoordinate() {
        return this.coordinate;
    }

    public int getDimension() {
        return this.dimension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GlobalCoordinate that = (GlobalCoordinate) o;

        if (dimension != that.dimension) {
            return false;
        }
        if (!coordinate.equals(that.coordinate)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = coordinate.hashCode();
        result = 31 * result + dimension;
        return result;
    }
}
