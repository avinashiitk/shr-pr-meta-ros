# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "PlotJuggler: juggle with data"
AUTHOR = "Davide Faconti <davide.faconti@gmail.com>"
ROS_AUTHOR = "Davide Faconti <davide.faconti@gmail.com>"
HOMEPAGE = "https://github.com/facontidavide/PlotJuggler"
SECTION = "devel"
LICENSE = "LGPL-2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=a9a72c186797ff98a79f90205c589abf"

ROS_CN = "plotjuggler"
ROS_BPN = "plotjuggler"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_binutils} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libqt5-svg-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libqt5multimedia5-plugins} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_qtdeclarative5-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_qtmultimedia5-dev} \
    diagnostic-msgs \
    nav-msgs \
    qtbase \
    ros-type-introspection \
    rosbag \
    rosbag-storage \
    roscpp \
    roscpp-serialization \
    rostime \
    tf \
    topic-tools \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_binutils} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libqt5-svg-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libqt5multimedia5-plugins} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_qtdeclarative5-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_qtmultimedia5-dev} \
    diagnostic-msgs \
    nav-msgs \
    qtbase \
    ros-type-introspection \
    rosbag \
    rosbag-storage \
    roscpp \
    roscpp-serialization \
    rostime \
    tf \
    topic-tools \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_binutils} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libqt5-svg-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libqt5multimedia5-plugins} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_qtdeclarative5-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_qtmultimedia5-dev} \
    diagnostic-msgs \
    nav-msgs \
    qtbase \
    ros-type-introspection \
    rosbag \
    rosbag-storage \
    roscpp \
    roscpp-serialization \
    rostime \
    tf \
    topic-tools \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/facontidavide/plotjuggler-release/archive/release/melodic/plotjuggler/2.4.3-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/plotjuggler"
SRC_URI = "git://github.com/facontidavide/plotjuggler-release;${ROS_BRANCH};protocol=https"
SRCREV = "1619bd02211baa1c8b13b02344881da04b67311c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
