package fr.glhez.eclipse.plugins.staticimport;

import static java.util.stream.Collectors.joining;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    // JDK
    copy.add(newTypeImport(Objects.class));
    copy.add(newTypeImport(Math.class));
    copy.add(newTypeImport(Collections.class));
    copy.add(newTypeImport(Arrays.class));
    copy.add(newTypeImport(Files.class));
    copy.add(newTypeImport(Stream.class));
    copy.add(newTypeImport(Optional.class));
    copy.add(newTypeImport(Collectors.class));
    copy.add(newTypeImport(SwingUtilities.class));

    // Test API
    copy.add(newTypeImport("org.mockito.Mockito"));
    copy.add(newTypeImport("org.assertj.core.api.Assertions"));
    copy.add(newTypeImport("org.assertj.core.api.AssertionsForClassTypes"));
    copy.add(newTypeImport("org.assertj.core.api.AssertionsForInterfaceTypes"));
    copy.add(newTypeImport("org.junit.jupiter.api.Assertions"));
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
