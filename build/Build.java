import dev.mccue.jproject.BuildTools;
import dev.mccue.jproject.UberOptions;
import java.util.List;

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
