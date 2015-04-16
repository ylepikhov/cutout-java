package cutout.java.util;

import cutout.java.Renderer;
import cutout.java.TextTemplate;
import cutout.java.util.Template.Part;
import cutout.java.util.Template.Cut;
import cutout.java.util.Template.Mark;

/**
* Created by YLepikhov on 10.04.2015.
*/
public class TemplateView {

    public static Renderer templateClass(
        String _packageName,
        cutout.java.util.Template template,
        boolean isRoot,
        $$.Template_templateClass templateClass) {

        return templateClass.apply(new $$.Template_templateClass.Params() {

            @Override
            public String packageName(TextTemplate packageName) {

                return _packageName;
            }

            @Override
            public Renderer templateClass($$.$.templateClass.Template_templateClass templateClass) {

                return templateClass.apply(new $$.$.templateClass.Template_templateClass.Params() {

                    @Override
                    public String className(TextTemplate className) {

                        return "Template_" + template.className;
                    }

                    @Override
                    public Renderer partsClass($$.$.templateClass.templateClass.Template_partsClass partsClass) {

                        return partsClass.apply(new $$.$.templateClass.templateClass.Template_partsClass.Params() {

                            @Override
                            public Renderer fields($$.$.templateClass.templateClass.partsClass.Template_fields fields) {

                                Renderer renderer = Renderer.EMPTY;
                                for (Cut cut : template.cuts.values()) {

                                    renderer = renderer.append(
                                        fields.apply(new $$.$.templateClass.templateClass.partsClass.Template_fields.Params() {

                                            @Override
                                            public String type(TextTemplate type) {

                                                return getCutClassName(cut, getPackageName(_packageName, isRoot, template));
                                            }

                                            @Override
                                            public String name(TextTemplate name) {

                                                return cut.name;
                                            }
                                        }));
                                }

                                for (Mark mark : template.marks.values()) {

                                    renderer = renderer.append(
                                        fields.apply(new $$.$.templateClass.templateClass.partsClass.Template_fields.Params() {

                                            @Override
                                            public String type(TextTemplate type) {

                                                return "TextTemplate";
                                            }

                                            @Override
                                            public String name(TextTemplate name) {

                                                return mark.name;
                                            }
                                        }));
                                }

                                return renderer;
                            }

                            @Override
                            public Renderer constructor($$.$.templateClass.templateClass.partsClass.Template_constructor constructor) {

                                return constructor.apply(new $$.$.templateClass.templateClass.partsClass.Template_constructor.Params() {

                                    @Override
                                    public Renderer params($$.$.templateClass.templateClass.partsClass.constructor.Template_params params) {

                                        Renderer renderer = Renderer.EMPTY;

                                        boolean first = true;

                                        for (Cut cut : template.cuts.values()) {

                                            final boolean isFirst = first;

                                            renderer = renderer.append(
                                                params.apply(new $$.$.templateClass.templateClass.partsClass.constructor.Template_params.Params() {

                                                    @Override
                                                    public String type(TextTemplate type) {
                                                        return getCutClassName(cut, getPackageName(_packageName, isRoot, template));
                                                    }

                                                    @Override
                                                    public String name(TextTemplate name) {
                                                        return cut.name;
                                                    }

                                                    @Override
                                                    public String delimiter(TextTemplate delimiter) {
                                                        return isFirst ? "" : delimiter.value;
                                                    }
                                                }));

                                            first = false;
                                        }

                                        for (Mark mark : template.marks.values()) {

                                            final boolean isFirst = first;

                                            renderer = renderer.append(
                                                params.apply(new $$.$.templateClass.templateClass.partsClass.constructor.Template_params.Params() {

                                                    @Override
                                                    public String type(TextTemplate type) {
                                                        return "TextTemplate";
                                                    }

                                                    @Override
                                                    public String name(TextTemplate name) {
                                                        return mark.name;
                                                    }

                                                    @Override
                                                    public String delimiter(TextTemplate delimiter) {
                                                        return isFirst ? "" : delimiter.value;
                                                    }
                                                }));

                                            first = false;
                                        }

                                        return renderer;
                                    }

                                    @Override
                                    public Renderer fieldAssignments($$.$.templateClass.templateClass.partsClass.constructor.Template_fieldAssignments fieldAssignments) {

                                        Renderer renderer = Renderer.EMPTY;

                                        for (Cut cut : template.cuts.values()) {

                                            renderer = renderer.append(
                                                fieldAssignments.apply(new $$.$.templateClass.templateClass.partsClass.constructor.Template_fieldAssignments.Params() {

                                                    @Override
                                                    public String name(TextTemplate name) {
                                                        return cut.name;
                                                    }
                                                }));
                                        }

                                        for (Mark mark : template.marks.values()) {

                                            renderer = renderer.append(
                                                fieldAssignments.apply(new $$.$.templateClass.templateClass.partsClass.constructor.Template_fieldAssignments.Params() {

                                                    @Override
                                                    public String name(TextTemplate name) {
                                                        return mark.name;
                                                    }
                                                }));
                                        }

                                        return renderer;
                                    }
                                });
                            }
                        });
                    }

                    @Override
                    public Renderer paramsInterface($$.$.templateClass.templateClass.Template_paramsInterface paramsInterface) {

                        return paramsInterface.apply(new $$.$.templateClass.templateClass.Template_paramsInterface.Params() {

                            @Override
                            public Renderer members($$.$.templateClass.templateClass.paramsInterface.Template_members members) {

                                Renderer renderer = Renderer.EMPTY;

                                boolean first = true;

                                for (Cut cut : template.cuts.values()) {

                                    final boolean isFirst = first;

                                    renderer = renderer.append(
                                        members.apply(new $$.$.templateClass.templateClass.paramsInterface.Template_members.Params() {
                                            @Override
                                            public String returnType(TextTemplate returnType) {
                                                return "Renderer";
                                            }

                                            @Override
                                            public String name(TextTemplate name) {
                                                return cut.name;
                                            }

                                            @Override
                                            public String paramType(TextTemplate paramType) {
                                                return getCutClassName(cut, getPackageName(_packageName, isRoot, template));
                                            }
                                        }));

                                    first = false;
                                }

                                for (Mark mark : template.marks.values()) {

                                    final boolean isFirst = first;

                                    renderer = renderer.append(
                                        members.apply(new $$.$.templateClass.templateClass.paramsInterface.Template_members.Params() {
                                            @Override
                                            public String returnType(TextTemplate returnType) {
                                                return "String";
                                            }

                                            @Override
                                            public String name(TextTemplate name) {
                                                return mark.name;
                                            }

                                            @Override
                                            public String paramType(TextTemplate paramType) {
                                                return "TextTemplate";
                                            }
                                        }));

                                    first = false;
                                }

                                return renderer;
                            }
                        });
                    }
                });
            }
        });
    }

    public static Renderer templateImplClass(
        String _packageName,
        cutout.java.util.Template template,
        boolean isRoot,
        $$.Template_templateImplClass templateImplClass) {

        return templateImplClass.apply(new $$.Template_templateImplClass.Params() {

            @Override
            public String packageName(TextTemplate packageName) {
                return _packageName;
            }

            @Override
            public Renderer templateImplClass( $$.$.templateImplClass.Template_templateImplClass templateImplClass) {
                return templateImplClass.apply(new $$.$.templateImplClass.Template_templateImplClass.Params() {

                    @Override
                    public String className(TextTemplate className) {
                        return "TemplateImpl_" + template.className;
                    }

                    @Override
                    public String baseClassName(TextTemplate baseClassName) {
                        return "Template_" + template.className;
                    }

                    @Override
                    public Renderer constructor($$.$.templateImplClass.templateImplClass.Template_constructor constructor) {
                        return constructor.apply(new $$.$.templateImplClass.templateImplClass.Template_constructor.Params() {

                            @Override
                            public String className(TextTemplate className) {
                                return "TemplateImpl_" + template.className;
                            }

                            @Override
                            public Renderer partsConstructorArgs($$.$.templateImplClass.templateImplClass.constructor.Template_partsConstructorArgs partsConstructorArgs) {

                                Renderer renderer = Renderer.EMPTY;

                                boolean first = true;

                                for (Cut cut : template.cuts.values()) {

                                    final boolean isFirst = first;

                                    renderer = renderer.append(
                                        partsConstructorArgs.apply(new $$.$.templateImplClass.templateImplClass.constructor.Template_partsConstructorArgs.Params() {

                                            @Override
                                            public String delimiter(TextTemplate delimiter) {
                                                return isFirst ? "" : delimiter.value;
                                            }

                                            @Override
                                            public Renderer arg($$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.Template_arg arg) {

                                                if (cut.template.className.equals("TextTemplate")) {

                                                    if (cut.template.parts[0].value.length() > 0) {

                                                        return arg.parts.value.apply(new $$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.arg.Template_value.Params() {
                                                            @Override
                                                            public String stringValue(TextTemplate stringValue) {
                                                                return "\"" + JavaStringLiteralUtil.escape(cut.template.parts[0].value) + "\"";
                                                            }
                                                        });
                                                    }
                                                    else {

                                                        return arg.parts.empty.apply();
                                                    }
                                                }
                                                else {

                                                    return arg.parts.part.apply(new $$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.arg.Template_part.Params() {

                                                        @Override
                                                        public String className(TextTemplate className) {
                                                            return getPackageName(_packageName, isRoot, template) + ".TemplateImpl_" + cut.name;
                                                        }
                                                    });
                                                }
                                            }
                                        }));

                                    first = false;
                                }

                                for (Mark mark : template.marks.values()) {

                                    final boolean isFirst = first;

                                    renderer = renderer.append(
                                        partsConstructorArgs.apply(new $$.$.templateImplClass.templateImplClass.constructor.Template_partsConstructorArgs.Params() {

                                            @Override
                                            public String delimiter(TextTemplate delimiter) {
                                                return isFirst ? "" : delimiter.value;
                                            }

                                            @Override
                                            public Renderer arg($$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.Template_arg arg) {

                                               if (mark.defaultValue.length() > 0) {
                                                    return arg.parts.value.apply(new $$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.arg.Template_value.Params() {
                                                        @Override
                                                        public String stringValue(TextTemplate stringValue) {
                                                            return "\"" + JavaStringLiteralUtil.escape(mark.defaultValue) + "\"";
                                                        }
                                                    });
                                                }
                                                else {
                                                    return arg.parts.empty.apply();
                                                }
                                            }
                                        }));

                                    first = false;
                                }

                                return renderer;
                            }
                        });
                    }

                    @Override
                    public Renderer rendererClass($$.$.templateImplClass.templateImplClass.Template_rendererClass rendererClass) {
                        return rendererClass.apply(new $$.$.templateImplClass.templateImplClass.Template_rendererClass.Params() {

                            @Override
                            public Renderer renderParts($$.$.templateImplClass.templateImplClass.rendererClass.Template_renderParts renderParts) {

                                Renderer renderer = Renderer.EMPTY;

                                for (Cut cut : template.cuts.values()) {

                                    renderer = renderer.append(renderParts.apply(new $$.$.templateImplClass.templateImplClass.rendererClass.Template_renderParts.Params() {
                                        @Override
                                        public Renderer type($$.$.templateImplClass.templateImplClass.rendererClass.renderParts.Template_type type) {

                                            return type.parts.renderer.apply();
                                        }

                                        @Override
                                        public String name(TextTemplate name) {
                                            return cut.name;
                                        }
                                    }));
                                }

                                for (Mark mark : template.marks.values()) {

                                    renderer = renderer.append(renderParts.apply(new $$.$.templateImplClass.templateImplClass.rendererClass.Template_renderParts.Params() {
                                        @Override
                                        public Renderer type($$.$.templateImplClass.templateImplClass.rendererClass.renderParts.Template_type type) {

                                            return type.parts.string.apply();
                                        }

                                        @Override
                                        public String name(TextTemplate name) {
                                            return mark.name;
                                        }
                                    }));
                                }

                                return renderer;
                            }

                            @Override
                            public Renderer renderStatements($$.$.templateImplClass.templateImplClass.rendererClass.Template_renderStatements renderStatements) {

                                Renderer renderer = Renderer.EMPTY;

                                for (int i = 0; i < template.parts.length; i++) {

                                    Part part = template.parts[i];

                                    switch (part.type) {

                                        case CUT:

                                            renderer = renderer.append(renderStatements.parts.renderTemplate.apply(new $$.$.templateImplClass.templateImplClass.rendererClass.renderStatements.Template_renderTemplate.Params() {
                                                @Override
                                                public String name(TextTemplate name) {
                                                    return part.value;
                                                }
                                            }));

                                            break;

                                        case MARK:

                                            renderer = renderer.append(renderStatements.parts.renderValue.apply(new $$.$.templateImplClass.templateImplClass.rendererClass.renderStatements.Template_renderValue.Params() {
                                                @Override
                                                public String name(TextTemplate name) {
                                                    return part.value;
                                                }
                                            }));

                                            break;

                                        case CONTENT:

                                            renderer = renderer.append(renderStatements.parts.renderContent.apply(new $$.$.templateImplClass.templateImplClass.rendererClass.renderStatements.Template_renderContent.Params() {
                                                @Override
                                                public String stringValue(TextTemplate stringValue) {
                                                    return "\"" + JavaStringLiteralUtil.escape(part.value) + "\"";
                                                }
                                            }));

                                            break;
                                    }
                                }

                                return renderer;
                            }
                        });
                    }
                });
            }
        });
    }

    private static String getPackageName(String packageName, boolean isRoot, Template template) {
        return packageName + (isRoot ? ".$." : ".") + template.className;
    }

    private static String getCutClassName(Cut cut, String packageName) {
        return cut.template.cuts.size() > 0 || cut.template.marks.size() > 0
                ? packageName + "." + "Template_" + cut.template.className
                : "TextTemplate";
    }
}
