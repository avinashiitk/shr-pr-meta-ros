# Copyright (c) 2020 LG Electronics, Inc.

# Uses dpkg on build system to check the target architecture :/.
# Restrict this recipe with COMPATIBLE_MACHINE and then just force
# MYARCH with EXTRA_OECMAKE to ignore this non-sense

# find_program(CMAKE_DPKG dpkg /bin /usr/bin /usr/local/bin)
# if(CMAKE_DPKG)
#   exec_program(dpkg ARGS --print-architecture OUTPUT_VARIABLE CMAKE_DPKG_ARCH)
#   if(CMAKE_DPKG_ARCH MATCHES "amd64")
#     message(STATUS "++++++++++++++++++++++++++ DETECTED 64 bit +++++++++++++++++++++++++++++++++++")
#     set(MYARCH "x86_64")
#   else()
#     message(STATUS "++++++++++++++++++++++++++ DETECTED 32 bit +++++++++++++++++++++++++++++++++++")
#     set(MYARCH "i686")
#   endif()
# endif()

COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE_x86-64 = "(.*)"
COMPATIBLE_MACHINE_x86 = "(.*)"
EXTRA_OECMAKE_append_x86-64 = "-DMYARCH=x86_64"
EXTRA_OECMAKE_append_x86 = "-DMYARCH=i686"

# ERROR: QA Issue: libntcan: Files/directories were installed but not shipped in any package:
#  /usr/opt/ros/melodic/lib/libntcan.so.3
#  /usr/opt/ros/melodic/lib/libntcan.so.3.1.7
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# libntcan: 2 installed and not shipped files. [installed-vs-shipped]
FILES_${PN} += "${ros_libdir}/*${SOLIBS}"