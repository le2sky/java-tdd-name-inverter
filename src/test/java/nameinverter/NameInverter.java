package nameinverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NameInverter {

    public String invert(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }
        return formatName(removeHonorific(splitNames(name)));
    }

    private String formatName(List<String> names) {
        if (names.size() == 1) {
            return names.get(0);
        }
        return formatMultiElementName(names);
    }

    private List<String> removeHonorific(List<String> names) {
        if (names.size() > 1 && isHonorific(names)) {
            names.remove(0);
        }

        return names;
    }

    private List<String> splitNames(String name) {
        return new ArrayList<>(Arrays.asList(name.trim().split("\\s+")));
    }

    private String formatMultiElementName(List<String> names) {
        String postNominal = "";
        if (names.size() > 2) {
            postNominal = getPostNominal(names);
        }
        return String.format("%s, %s %s", names.get(1), names.get(0), postNominal).trim();
    }

    private String getPostNominal(List<String> names) {
        return String.join(" ", names.subList(2, names.size()));
    }

    private boolean isHonorific(List<String> names) {
        return names.get(0).matches("Mr\\.|Mrs\\.");
    }
}
