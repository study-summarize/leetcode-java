package org.github.fourth;


import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class VerifyUtils {

    public static boolean assertListIntegerEquals(List<Integer> a, List<Integer> b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }

        return CollectionUtils.isEqualCollection(a, b);
    }

}
