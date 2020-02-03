# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This package contains adapters for using `nav_core` plugins as `nav_core2` plugins and vice versa (more or less).       See README.md for more information."
AUTHOR = "David V. Lu!! <davidvlu@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "robot_navigation"
ROS_BPN = "nav_core_adapter"

ROS_BUILD_DEPENDS = " \
    costmap-2d \
    geometry-msgs \
    nav-2d-msgs \
    nav-2d-utils \
    nav-core \
    nav-core2 \
    nav-grid \
    nav-msgs \
    pluginlib \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    costmap-2d \
    geometry-msgs \
    nav-2d-msgs \
    nav-2d-utils \
    nav-core \
    nav-core2 \
    nav-grid \
    nav-msgs \
    pluginlib \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    costmap-2d \
    geometry-msgs \
    nav-2d-msgs \
    nav-2d-utils \
    nav-core \
    nav-core2 \
    nav-grid \
    nav-msgs \
    pluginlib \
    tf \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    dwb-critics \
    dwb-local-planner \
    dwb-plugins \
    roslint \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/DLu/robot_navigation-release/archive/release/melodic/nav_core_adapter/0.2.5-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/nav_core_adapter"
SRC_URI = "git://github.com/DLu/robot_navigation-release;${ROS_BRANCH};protocol=https"
SRCREV = "791ac958b4eaacf425ee73861624460339b9d77e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
