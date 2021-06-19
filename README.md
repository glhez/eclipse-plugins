# What about this collection ? [![Java CI and Publish with Maven](https://github.com/glhez/eclipse-plugins/actions/workflows/build.yml/badge.svg)](https://github.com/glhez/eclipse-plugins/actions/workflows/build.yml)

The update site will contains some plugins:

-   **Static   Import   plugin**:   contribute   to  the  _Favorites_  and  add  some  static  import,  such  as
`java.util.Collections`.  This  plugin  will add a default set of [imports][1]. **Note:** this plugin will not
scan for static methods in your project, it will only add a fixed set of static import.

# Installation

To install the plugin(s), simply follow theses step:

1. Open Help > Install New Softwares
2. Add https://glhez.github.io/eclipse-plugins (simply paste the URL and press enter, it should work)
3. Select the plugin you want to install

# Old plugin

For various reasons, I began to rename my project package from `fr.glhez` to `com.github.glhez`.
I did not find a simple way to say to Eclipse that the new plugin/feature are superseding the previous one.

TL/DR: **old plugin `fr.glhez.eclipse.plugins.staticimport` / feature `fr.glhez.eclipse.features.all` must be removed**.

If you forget to clean your Eclipse, then the `PreferenceInitializer` will get called twice which is unneeded.



[1]: com.github.glhez.eclipse.plugins.staticimport/src/main/java/com/github/glhez/eclipse/plugins/staticimport/PreferenceInitializer.java
