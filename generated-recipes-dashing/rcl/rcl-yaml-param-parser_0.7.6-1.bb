# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Package containing various utility types and functions for C"
AUTHOR = "Anup Pemmaiah <anup.pemmaiah@apex.ai>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rcl"
ROS_BPN = "rcl_yaml_param_parser"

ROS_BUILD_DEPENDS = " \
    libyaml \
    libyaml-vendor \
    rcl \
    rcutils \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = " \
    libyaml \
    libyaml-vendor \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libyaml \
    libyaml-vendor \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/rcl-release/archive/release/dashing/rcl_yaml_param_parser/0.7.6-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7b9cdc8344eb95df3ce5e8e16f2de726"
SRC_URI[sha256sum] = "bb632a819624f8b073a951d3416b792fd48c0ef45b1c81e86da9cd3c6b960220"
S = "${WORKDIR}/rcl-release-release-dashing-rcl_yaml_param_parser-0.7.6-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rcl', d)}"
ROS_BUILD_TYPE = "ament_cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rcl', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rcl/rcl_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rcl/rcl-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rcl/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rcl/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
