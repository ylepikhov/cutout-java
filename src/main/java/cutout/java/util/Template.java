package cutout.java.util;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
* Created by YLepikhov on 10.04.2015.
*/
public class Template {

    public final String className;
    public final Map<String, Cut> cuts;
    public final Map<String, Mark> marks;
    public final Part[] parts;

    public Template(String className, Map<String, Cut> cuts, Map<String, Mark> marks, Part[] parts) {

        this.className = className;
        this.cuts = cuts;
        this.marks = marks;
        this.parts = parts;
    }

    public Template addCut(String name, Template template) {

        if (cuts.containsKey(name)) throw new RuntimeException();

        Part[] newParts = Arrays.copyOf(parts, parts.length + 1);
        newParts[newParts.length - 1] = new Part(Part.PART_TYPE.CUT, name);

        Map<String, Cut> newCuts = new HashMap<String, Cut>(cuts);
        newCuts.put(name, new Cut(name, template));

        return new Template(className, newCuts, marks, newParts);
    }

    public Template addMark(String name, String defaultValue) {

        Part[] newParts = Arrays.copyOf(parts, parts.length + 1);
        newParts[newParts.length - 1] = new Part(Part.PART_TYPE.MARK, name);

        Map<String, Mark> newMarks = new HashMap<String, Mark>(marks);
        if (defaultValue.length() > 0 || !marks.containsKey(name)) {

            if (marks.containsKey(name) && marks.get(name).defaultValue.length() > 0) throw new RuntimeException();

            newMarks.put(name, new Mark(name, defaultValue));
        }

        return new Template(className, cuts, newMarks, newParts);
    }

    public Template addContent(String content) {

        Part[] newParts = Arrays.copyOf(parts, parts.length + 1);
        newParts[newParts.length - 1] = new Part(Part.PART_TYPE.CONTENT, content);

        return new Template(className, cuts, marks, newParts);
    }

    static public class Cut {

        public final String name;
        public final Template template;

        public Cut(String name, Template template) {
            this.name = name;
            this.template = template;
        }
    }

    static public class Mark {

        public final String name;
        public final String defaultValue;

        public Mark(String name, String defaultValue) {
            this.name = name;
            this.defaultValue = defaultValue;
        }
    }

    static public class Part {

        static enum PART_TYPE { CUT, MARK, CONTENT }

        public final PART_TYPE type;
        public final String value;

        public Part(PART_TYPE type, String value) {

            this.type = type;
            this.value = value;
        }
    }
}
