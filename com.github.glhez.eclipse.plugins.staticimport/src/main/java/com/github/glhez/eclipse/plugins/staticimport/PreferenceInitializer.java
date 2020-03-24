package com.github.glhez.eclipse.plugins.staticimport;

import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IStartup;

/**
 * This was inspired from SWTBOT PreferenceInitializer.
 *
 * @author gael.lhez
 */
public class PreferenceInitializer implements IStartup {
  private final IPreferenceStore javaPreferenceStore;

  public PreferenceInitializer() {
    this.javaPreferenceStore = PreferenceConstants.getPreferenceStore();
  }

  @Override
  public void earlyStartup() {
    final Set<String> initial = getStaticImports();

    final Set<String> copy = new LinkedHashSet<>(initial);

    // jdk [basic types]
    copy.add(newTypeImport("java.lang.String"));
    copy.add(newTypeImport("java.lang.Character"));
    copy.add(newTypeImport("java.lang.Boolean"));
    copy.add(newTypeImport("java.lang.Byte"));
    copy.add(newTypeImport("java.lang.Short"));
    copy.add(newTypeImport("java.lang.Integer"));
    copy.add(newTypeImport("java.lang.Long"));
    copy.add(newTypeImport("java.lang.Float"));
    copy.add(newTypeImport("java.lang.Double"));

    // jdk [util]
    copy.add(newTypeImport("java.lang.Math"));

    copy.add(newTypeImport("java.util.Objects"));
    copy.add(newTypeImport("java.util.Optional"));
    copy.add(newTypeImport("java.util.OptionalInt"));
    copy.add(newTypeImport("java.util.OptionalLong"));
    copy.add(newTypeImport("java.util.OptionalDouble"));
    copy.add(newTypeImport("java.util.regex.Pattern"));

    copy.add(newTypeImport("java.util.concurrent.Executors"));

    // jdk [lambda]
    copy.add(newTypeImport("java.util.Comparator"));
    copy.add(newTypeImport("java.util.function.Function"));
    copy.add(newTypeImport("java.util.function.Predicate"));
    copy.add(newTypeImport("java.util.function.BinaryOperator"));
    copy.add(newTypeImport("java.util.function.UnaryOperator"));
    copy.add(newTypeImport("java.util.function.DoubleUnaryOperator"));
    copy.add(newTypeImport("java.util.function.IntUnaryOperator"));
    copy.add(newTypeImport("java.util.function.LongBinaryOperator"));

    // jdk [collection and stream]
    copy.add(newTypeImport("java.util.EnumSet"));
    copy.add(newTypeImport("java.util.Collections"));
    copy.add(newTypeImport("java.util.Arrays"));
    copy.add(newTypeImport("java.util.stream.Stream"));
    copy.add(newTypeImport("java.util.stream.IntStream"));
    copy.add(newTypeImport("java.util.stream.LongStream"));
    copy.add(newTypeImport("java.util.stream.DoubleStream"));
    copy.add(newTypeImport("java.util.stream.Collectors"));

    // jdk 9++ [collection and stream]
    copy.add(newTypeImport("java.util.List"));
    copy.add(newTypeImport("java.util.Map"));

    // jdk [nio2]
    copy.add(newTypeImport("java.nio.file.Files"));
    copy.add(newTypeImport("java.nio.channels.FileChannel"));

    // jdk [awt/swing]
    copy.add(newTypeImport("java.awt.Toolkit"));

    copy.add(newTypeImport("javax.imageio.ImageIO"));

    copy.add(newTypeImport("javax.swing.SwingUtilities"));
    copy.add(newTypeImport("javax.swing.BorderFactory"));
    copy.add(newTypeImport("javax.swing.UIManager"));

    // Test API
    copy.add(newTypeImport("org.mockito.Mockito"));
    copy.add(newTypeImport("org.mockito.ArgumentMatchers"));

    copy.add(newTypeImport("org.assertj.core.api.Assertions"));
    copy.add(newTypeImport("org.assertj.core.api.AssertionsForClassTypes"));
    copy.add(newTypeImport("org.assertj.core.api.AssertionsForInterfaceTypes"));

    copy.add(newTypeImport("org.junit.jupiter.api.Assertions"));
    copy.add(newTypeImport("org.junit.jupiter.api.Assumptions"));
    copy.add(newTypeImport("org.junit.Assert"));
    copy.add(newTypeImport("org.junit.Assume"));

    // apache
    copy.add(newTypeImport("org.apache.commons.lang3.StringUtils"));
    copy.add(newTypeImport("org.apache.commons.text.StringEscapeUtils"));

    if (!copy.equals(initial)) {
      setStaticImports(copy);
    }
  }

  private String newTypeImport(final String name) {
    return name + ".*";
  }

  private Set<String> getStaticImports() {
    return new LinkedHashSet<>(
        Arrays.asList(javaPreferenceStore.getString(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS)
                                         .trim()
                                         .split("\\s*;\\s*")));
  }

  private void setStaticImports(final Set<String> imports) {
    final String value = imports.stream().collect(joining(";"));
    javaPreferenceStore.setValue(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, value);
  }
}
