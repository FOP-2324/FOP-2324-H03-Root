package h03;

import org.tudalgo.algoutils.tutor.general.reflections.PackageLink;
import org.tudalgo.algoutils.tutor.general.reflections.TypeLink;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CombinedPackageLink implements PackageLink {

    private final List<? extends TypeLink> typeLinks;

    public CombinedPackageLink(PackageLink... packageLinks) {
        typeLinks = Arrays.stream(packageLinks).flatMap(pl -> pl.getTypes().stream()).toList();
    }

    @Override
    public Collection<? extends TypeLink> getTypes() {
        return typeLinks;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public Object reflection() {
        return null;
    }
}
