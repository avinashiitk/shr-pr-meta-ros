# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Examples for composing multiple nodes in a single process."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "demos"
ROS_BPN = "composition"

ROS_BUILD_DEPENDS = " \
    example-interfaces \
    rclcpp \
    rclcpp-components \
    rcutils \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    example-interfaces \
    launch-ros \
    rclcpp \
    rclcpp-components \
    rcutils \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-pytest \
    ament-lint-auto \
    ament-lint-common \
    launch \
    launch-testing \
    launch-testing-ament-cmake \
    launch-testing-ros \
    rmw-implementation-cmake \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/demos-release/archive/release/dashing/composition/0.7.8-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "878a7cc645b239775adebf69f269175e"
SRC_URI[sha256sum] = "0219ae0aa14de453f99a41d5d92b752f96606d7234ee638a54d27d5b52510e37"
S = "${WORKDIR}/demos-release-release-dashing-composition-0.7.8-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('demos', d)}"
ROS_BUILD_TYPE = "ament_cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('demos', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/demos/demos_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/demos/demos-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/demos/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/demos/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
