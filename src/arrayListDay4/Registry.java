package arrayListDay4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Registry {
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Integer> codes = new ArrayList<>();

    void store(String name, int code) {
        if (name != null && code >= 0) {
            if (!names.contains(name)) {
                names.add(name);
                codes.add(code);
            } else {
                codes.set(names.indexOf(name), code);
            }
        }
    }

    int recall(String name) {
        if (names.indexOf(name) == -1) {
            return -1;
        } else {
            return codes.get(names.indexOf(name));
        }
    }

    void delete(String name) {
        if (names.contains(name)) {
            int index = names.indexOf(name);
            names.remove(index);
            codes.remove(index);
        }
    }

    List<String> names() {
        return Collections.unmodifiableList(names);
    }
}
