# What about this collection ? [![Build Status](https://travis-ci.org/glhez/eclipse-plugins.svg?branch=master)](https://travis-ci.org/glhez/eclipse-plugins)

The update site will contains some plugins:

-   **Static   Import   plugin**:   contribute   to  the  _Favorites_  and  add  some  static  import,  such  as
`java.util.Collections`.  This  plugin  will add a default set of [imports][1]. **Note:** this plugin will not
scan for static methods in your project, it will only add a fixed set of static import.

# Installation

To install the plugin(s), simply follow theses step:

1. Open Help > Install New Softwares
2. Add https://glhez.github.io/eclipse-plugins (simply paste the URL and press enter, it should work)
3. Select the plugin you want to install

[1]: fr.glhez.eclipse.plugins.staticimport/src/main/java/fr/glhez/eclipse/plugins/staticimport/PreferenceInitializer.java