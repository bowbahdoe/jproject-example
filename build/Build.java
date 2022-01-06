import dev.mccue.jproject.BuildTools;
import dev.mccue.jproject.UberOptions;
import java.util.List;

// To compile
// 1. Have Java 17 set to your JAVA_HOME
// 2. Have the clojure command line tools installed
// 3. java -cp $(clj -A:build -Spath) --enable-preview --source 17 build/Build.java
public final class Build {
    public static void main(String[] args) {
        var buildTools = BuildTools.getInstance();
        var basis = buildTools.createBasis();
        buildTools.delete("target");
        buildTools.javac(
            List.of("src"),
                "target",
                List.of("--release", "11"),
                basis
        );
        buildTools.uber(
                UberOptions.builder()
                        .main("some.project.DoThing")
                        .classDir("target")
                        .uberFile("target/program-0.0." + buildTools.gitCountRevs() + ".jar")
                        .basis(basis)
                        .build()
        );
    }
}
