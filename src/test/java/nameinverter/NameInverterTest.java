package nameinverter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class NameInverterTest {

    @Test
    void name() {
        assertThat(invert(null)).isEqualTo("");
        assertThat(invert("")).isEqualTo("");
        assertThat(invert("name")).isEqualTo("name");
        assertThat(invert("first last")).isEqualTo("last, first");
        assertThat(invert("   name    ")).isEqualTo("name");
        assertThat(invert("first     last")).isEqualTo("last, first");
        assertThat(invert("Mr. first last")).isEqualTo("last, first");
        assertThat(invert("Mrs. first last")).isEqualTo("last, first");
        assertThat(invert("first last SR.")).isEqualTo("last, first SR.");
        assertThat(invert("first last BS. Phd")).isEqualTo("last, first BS. Phd");
    }

    private String invert(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        } else {
            List<String> names = splitNames(name);
            removeHonorific(names);
            if (names.size() == 1) {
                return names.get(0);
            }
            String postNominal = "";
            List<String> postNominals = new ArrayList<>();
            if (names.size() > 2) {
                postNominals = names.subList(2, names.size());
            }
            postNominal = String.join(" ", postNominals);

            return String.format("%s, %s %s", names.get(1), names.get(0), postNominal).trim();
        }
    }

    private void removeHonorific(List<String> names) {
        if (names.size() > 1 && isHonorific(names)) {
            names.remove(0);
        }
    }

    private ArrayList<String> splitNames(String name) {
        return new ArrayList<>(Arrays.asList(name.trim().split("\\s+")));
    }

    private boolean isHonorific(List<String> names) {
        return names.get(0).matches("Mr\\.|Mrs\\.");
    }
}