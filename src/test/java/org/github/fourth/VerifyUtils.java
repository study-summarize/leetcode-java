package org.github.fourth;


import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;

public class VerifyUtils {

    public static boolean assertListEquals(Collection<?> a, Collection<?> b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }

        return CollectionUtils.isEqualCollection(a, b);
    }

}
