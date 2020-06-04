# foxy/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2020 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Foxy Fitzroy"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-focal"

require conf/ros-distro/include/foxy/generated/superflore-datetime.inc
require conf/ros-distro/include/foxy/generated/superflore-ros-distro.inc
require conf/ros-distro/include/foxy/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/foxy/ros-distro-preferred-versions.inc
require conf/ros-distro/include/foxy/ros-distro-preferred-providers.inc

# Override settings from generated/superflore-ros-distro.inc here.

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
    ament-lint-native \
    domain-coordinator-native \
    foonathan-memory-vendor-native \
    rcpputils-native \
    rmw-native \
    rosidl-adapter-native \
    rosidl-parser-native \
    rpyutils-native \
    uncrustify-vendor-native \
"

# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "connext"
# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "opensplice"
# Can't build these until we figure out how to build clang-format, clang-tidy without building all of clang.
ROS_WORLD_SKIP_GROUPS += "clang"
# recipes depending on turtlebot3 specific recipes which weren't ported to eloquent yet
ROS_WORLD_SKIP_GROUPS += "turtlebot3"
# recipes depending on coinor-libipopt
ROS_WORLD_SKIP_GROUPS += "coinor-libipopt"
# Needs work to launch qemu to run tests on image on build machine.
ROS_WORLD_SKIP_GROUPS += "launch"
# recipes depending on ROS_UNRESOLVED_PLATFORM_PKG_python3-babeltrace which cannot be just
# set to babeltrace, because python bindings in babeltrace are not enabled as shown in log.do_configure:
# configure: You may configure with --enable-python-bindings if you want Python bindings.
ROS_WORLD_SKIP_GROUPS += "babeltrace-python"

# recipes depending on 'x11' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'x11', d)}"
# recipes depending on 'opengl' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', 'opengl', d)}"
# There is recipe for glfw in meta-oe in dunfell, but it still needs x11 in DISTRO_FEATURES
# use that in dunfell and blacklist explicitly in older releases
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'glfw', d)}"

# recipes depending on gazebo, for which there is no OE recipe
ROS_WORLD_SKIP_GROUPS += "gazebo"

# recipes depending on something from meta-qt5 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'qt5', d)}"

# do_compile failures
ROS_WORLD_SKIP_GROUPS += " \
    qt-gui-cpp \
"

# recipes depending on something from meta-qt4 layer
# XXX Temp until superflore fixed.
# Must use a _pn- override in this file to override the ROS_BUILD_TYPE of a generated recipe,
# because we need to set this variable before the "inherit" line in the recipe is parsed,
# and having it in a .bbappend sets it too late.
ROS_BUILD_TYPE_pn-fmilibrary-vendor = "ament_cmake"
ROS_BUILD_TYPE_pn-ros-workspace = "ament_cmake"
# was changed from ament_cmake to catkin between eloquent and foxy
ROS_BUILD_TYPE_pn-behaviortree-cpp-v3 = "ament_cmake"
# superflore doesn't resolve the build_type conditions correctly:
# https://github.com/lgsvl/lgsvl_msgs-release/blob/release/foxy/lgsvl_msgs/package.xml#L32
#   <build_type condition="$ROS_VERSION == 1">catkin</build_type>
#   <build_type condition="$ROS_VERSION == 2">ament_cmake</build_type>
ROS_BUILD_TYPE_pn-lgsvl-msgs = "ament_cmake"

# Used by:
# generated-recipes/spdlog-vendor/spdlog-vendor_1.1.1-1.bb
# generated-recipes/rcl-logging/rcl-logging-spdlog_0.4.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_spdlog = "spdlog"

# Used by:
# generated-recipes/sros2/sros2_0.9.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-cryptography = "python3-cryptography"

# Used by:
# generated-recipes/ament-lint/ament-mypy_0.9.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-mypy = "python3-mypy"

# Used by:
# generated-recipes/ament-lint/ament-pycodestyle_0.9.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-pycodestyle = "python3-pycodestyle"

# Used by:
# /generated-recipes/joystick-drivers/sdl2-vendor_2.4.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_sdl2 = "libsdl2"

# Used by:
# generated-recipes/python-qt-binding/python-qt-binding_1.0.4-1.bb
# generated-recipes/qt-gui-core/qt-gui_1.0.8-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-qt5-bindings = "python3-pyqt5"

# Used by:
# generated-recipes/filters/filters_2.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-dev = "boost"

# Used by:
# generated-recipes/cartographer/cartographer_1.0.9001-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-iostreams-dev = "boost"

# Used by:
# generated-recipes/cartographer/cartographer_1.0.9001-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-sphinx = "python3-sphinx"

# Used by:
# generated-recipes/vision-opencv/cv-bridge_2.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-python-dev = "boost"

# Used by:
# generated-recipes/vision-opencv/cv-bridge_2.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-python = "boost"

# Used by:
# generated-recipes/behaviortree-cpp/behaviortree-cpp-v3_3.5.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libncurses-dev = "ncurses"

# Used by:
# generated-recipes/cyclonedds/cyclonedds_0.5.1-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_maven-native = ""
ROS_UNRESOLVED_PLATFORM_PKG_java-native = ""

# Used by:
# generated-recipes/rosbag2/zstd-vendor_0.2.7-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libzstd-dev = "zstd"

# tango-icon-theme isn't available, but adwaita-icon-theme should be compatible
# Used by:
# generated-recipes/qt-gui-core/qt-gui_1.0.8-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_tango-icon-theme = "adwaita-icon-theme"

# Used by:
# generated-recipes/ros2cli/ros2doctor_0.9.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-ifcfg = ""

# Used by:
# generated-recipes/ros2cli/ros2cli_0.9.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-netifaces = ""

# python3 bindings are provided by lttng-tools when python PACKAGECONFIG is enabled there
# Used by:
# generated-recipes/ros2-tracing/tracetools-trace_1.0.0-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-lttng = "lttng-tools"