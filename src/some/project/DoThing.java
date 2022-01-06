package some.project;

import org.apache.commons.text.CaseUtils;

public final class DoThing {
    public static void main(String[] args) {
        System.out.println(
                CaseUtils.toCamelCase("abc_def", false, '_') // abcDef
        );
    }
}
