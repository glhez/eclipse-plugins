package com.github.glhez.eclipse.plugins.staticimport;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IStartup;

/**
 * This was inspired from SWTBOT PreferenceInitializer.
 *
 * @author gael.lhez
 */
public class PreferenceInitializer implements IStartup {
  private static final String PREFERENCE_DELIMITER = ";";

  @Override
  public void earlyStartup() {
    IPreferenceStore store = PreferenceConstants.getPreferenceStore();
    var key = PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS;

    var list = Pattern.compile(Pattern.quote(PREFERENCE_DELIMITER))
                      .splitAsStream(store.getString(key))
                      .map(String::trim)
                      .filter(s -> !s.isEmpty())
                      .collect(toList());

    var logger = org.eclipse.core.runtime.Platform.getLog(PreferenceInitializer.class);

    logger.log(Status.info("starting Static Import plugin"));

    final LinkedHashSet<String> imports = new LinkedHashSet<>();
    imports.addAll(list);

    if (imports.addAll(getDefaultImports())) {
      final String value = imports.stream().collect(joining(PREFERENCE_DELIMITER));
      store.setValue(key, value);
      logger.log(Status.info("updating " + key + " of plugin " + JavaUI.ID_PLUGIN));
    } else {
      logger.log(Status.info("preference seems to be good, nothing to update"));
    }
  }

  private static SortedSet<String> getDefaultImports() {
    final ImportList copy = new ImportList();

    // jdk [basic types]
    copy.addTypeImport("java.lang.String");
    copy.addTypeImport("java.lang.Character");
    copy.addTypeImport("java.lang.Boolean");
    copy.addTypeImport("java.lang.Byte");
    copy.addTypeImport("java.lang.Short");
    copy.addTypeImport("java.lang.Integer");
    copy.addTypeImport("java.lang.Long");
    copy.addTypeImport("java.lang.Float");
    copy.addTypeImport("java.lang.Double");

    // jdk [util]
    copy.addTypeImport("java.lang.Math");

    copy.addTypeImport("java.util.Objects");
    copy.addTypeImport("java.util.Optional");
    copy.addTypeImport("java.util.OptionalInt");
    copy.addTypeImport("java.util.OptionalLong");
    copy.addTypeImport("java.util.OptionalDouble");
    copy.addTypeImport("java.util.regex.Pattern");

    copy.addTypeImport("java.util.concurrent.Executors");

    // jdk [lambda]
    copy.addTypeImport("java.util.Comparator");
    copy.addTypeImport("java.util.function.Function");
    copy.addTypeImport("java.util.function.Predicate");
    copy.addTypeImport("java.util.function.BinaryOperator");
    copy.addTypeImport("java.util.function.UnaryOperator");
    copy.addTypeImport("java.util.function.DoubleUnaryOperator");
    copy.addTypeImport("java.util.function.IntUnaryOperator");
    copy.addTypeImport("java.util.function.LongBinaryOperator");

    // jdk [collection and stream]
    copy.addTypeImport("java.util.EnumSet");
    copy.addTypeImport("java.util.Collections");
    copy.addTypeImport("java.util.Arrays");
    copy.addTypeImport("java.util.stream.Stream");
    copy.addTypeImport("java.util.stream.IntStream");
    copy.addTypeImport("java.util.stream.LongStream");
    copy.addTypeImport("java.util.stream.DoubleStream");
    copy.addTypeImport("java.util.stream.Collectors");

    // jdk 9++ [collection and stream]
    copy.addTypeImport("java.util.List");
    copy.addTypeImport("java.util.Map");

    // time based api
    copy.addTypeImport("java.time.Duration");
    copy.addTypeImport("java.util.concurrent.TimeUnit");

    // jdk [nio2]
    copy.addTypeImport("java.nio.file.Files");
    copy.addTypeImport("java.nio.channels.FileChannel");

    // jdk [awt/swing]
    copy.addTypeImport("java.awt.Toolkit");

    copy.addTypeImport("javax.imageio.ImageIO");

    copy.addTypeImport("javax.swing.SwingUtilities");
    copy.addTypeImport("javax.swing.BorderFactory");
    copy.addTypeImport("javax.swing.UIManager");

    // Test API
    copy.addTypeImport("org.mockito.Mockito");
    copy.addTypeImport("org.mockito.ArgumentMatchers");
    copy.addTypeImport("org.mockito.AdditionalMatchers");
    copy.addTypeImport("org.mockito.AdditionalAnswers");

    copy.addTypeImport("org.assertj.core.api.Assertions");
    copy.addTypeImport("org.assertj.core.api.AssertionsForClassTypes");
    copy.addTypeImport("org.assertj.core.api.AssertionsForInterfaceTypes");
    copy.addTypeImport("org.assertj.core.api.InstanceOfAssertFactories");

    copy.addTypeImport("org.junit.jupiter.api.Assertions");
    copy.addTypeImport("org.junit.jupiter.api.Assumptions");
    copy.addTypeImport("org.junit.Assert");
    copy.addTypeImport("org.junit.Assume");

    copy.addTypeImport("org.hamcrest.Matchers");

    copy.addTypeImport("org.awaitility.Awaitility");

    // apache
    copy.addTypeImport("org.apache.commons.lang3.StringUtils");
    copy.addTypeImport("org.apache.commons.lang3.ObjectUtils");
    copy.addTypeImport("org.apache.commons.text.StringEscapeUtils");

    return copy.toUnmodifiableSortedSet();
  }

  static class ImportList {
    private final TreeSet<String> imports;

    public ImportList() {
      this.imports = new TreeSet<>();
    }

    public SortedSet<String> toUnmodifiableSortedSet() {
      return Collections.unmodifiableSortedSet(new TreeSet<>(imports));
    }

    public ImportList addTypeImport(final String packageName) {
      imports.add(packageName + ".*");
      return this;
    }

  }
}
