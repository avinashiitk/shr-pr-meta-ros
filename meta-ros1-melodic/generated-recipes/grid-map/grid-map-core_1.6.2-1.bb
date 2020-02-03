# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Universal grid map library to manage two-dimensional grid maps with multiple data layers."
AUTHOR = "Péter Fankhauser <pfankhauser@anybotics.com>"
ROS_AUTHOR = "Péter Fankhauser <pfankhauser@anybotics.com>"
HOMEPAGE = "http://github.com/anybotics/grid_map"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "grid_map"
ROS_BPN = "grid_map_core"

ROS_BUILD_DEPENDS = " \
    libeigen \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    libeigen \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libeigen \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/anybotics/grid_map-release/archive/release/melodic/grid_map_core/1.6.2-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/grid_map_core"
SRC_URI = "git://github.com/anybotics/grid_map-release;${ROS_BRANCH};protocol=https"
SRCREV = "ab02d42ece8d84ae6023577f8e0c35712475622a"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
