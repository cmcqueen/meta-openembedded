SUMMARY = "A GObject library for Facebook Graph API"
SECTION = "x11/gnome"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=5804fe91d3294da4ac47c02b454bbc8a"

DEPENDS = " \
    glib-2.0 \
    json-glib \
    rest \
    gnome-online-accounts \
"

inherit gnomebase gtk-doc gobject-introspection pkgconfig features_check

# for gnome-online-accounts
REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI += " file://0001-Update-rest-requirement-to-rest-1.0.patch"
SRC_URI[archive.md5sum] = "c38af63e49f8fe8baad99537956b69ba"
SRC_URI[archive.sha256sum] = "6065391f35e7335588cc6b0cc4c1abbce7341488573a654551264cb9793b9379"

do_install:append() {
    # they install all the autotools files (NEWS AUTHORS..) to /usr/doc which
    # is not a standard path exactly
    rm -rf ${D}${prefix}/doc
}
