package com.github.glhez.eclipse.plugins.staticimport;

import static java.util.stream.Collectors.joining;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;

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
    copy.add(newTypeImport(String.class));
    copy.add(newTypeImport(Character.class));
    copy.add(newTypeImport(Boolean.class));
    copy.add(newTypeImport(Byte.class));
    copy.add(newTypeImport(Short.class));
    copy.add(newTypeImport(Integer.class));
    copy.add(newTypeImport(Long.class));
    copy.add(newTypeImport(Float.class));
    copy.add(newTypeImport(Double.class));
    copy.add(newTypeImport(Optional.class));

    // jdk [util]
    copy.add(newTypeImport(Objects.class));
    copy.add(newTypeImport(Math.class));

    // jdk [lambda]
    copy.add(newTypeImport(Comparator.class));
    copy.add(newTypeImport(Function.class));
    copy.add(newTypeImport(Predicate.class));

    // jdk [collection and stream]
    copy.add(newTypeImport(EnumSet.class));
    copy.add(newTypeImport(Collections.class));
    copy.add(newTypeImport(Arrays.class));
    copy.add(newTypeImport(Stream.class));
    copy.add(newTypeImport(Collectors.class));

    // jdk 9++ [collection and stream]
    copy.add(newTypeImport("java.util.List"));
    copy.add(newTypeImport("java.util.Map"));

    // jdk [nio2]
    copy.add(newTypeImport(Files.class));

    // jdk [awt/swing]
    copy.add(newTypeImport(SwingUtilities.class));
    copy.add(newTypeImport(BorderFactory.class));

    // Test API
    copy.add(newTypeImport("org.mockito.Mockito"));
    copy.add(newTypeImport("org.mockito.ArgumentMatchers"));
    copy.add(newTypeImport("org.assertj.core.api.Assertions"));
    copy.add(newTypeImport("org.assertj.core.api.AssertionsForClassTypes"));
    copy.add(newTypeImport("org.assertj.core.api.AssertionsForInterfaceTypes"));
    copy.add(newTypeImport("org.junit.jupiter.api.Assertions"));

    // apache
    copy.add(newTypeImport("org.apache.commons.lang3.StringUtils"));

    if (!copy.equals(initial)) {
      setStaticImports(copy);
    }
  }

  private String newTypeImport(final Class<?> type) {
    return newTypeImport(type.getName());
  }

  private String newTypeImport(final String name) {
    return name + ".*";
  }

  private Set<String> getStaticImports() {
    return new LinkedHashSet<>(Arrays.asList(javaPreferenceStore
        .getString(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS).trim().split("\\s*;\\s*")));
  }

  private void setStaticImports(final Set<String> imports) {
    final String value = imports.stream().collect(joining(";"));
    javaPreferenceStore.setValue(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, value);
  }
}
