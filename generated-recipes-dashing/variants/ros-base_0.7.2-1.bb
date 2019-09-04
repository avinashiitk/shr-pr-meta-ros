# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A package which extends 'ros_core' and includes other basic functionalities like tf2 and urdf."
AUTHOR = "Steven! Ragnarök <steven@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "variants"
ROS_BPN = "ros_base"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    kdl-parser \
    robot-state-publisher \
    ros-core \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-kdl \
    tf2-ros \
    urdf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/variants-release/archive/release/dashing/ros_base/0.7.2-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "98c4809ec0122639f929111458680904"
SRC_URI[sha256sum] = "ca4226763e8db5a53ade8eb691ba401c5695e9014b6de3f3db0d762408f0e2d4"
S = "${WORKDIR}/variants-release-release-dashing-ros_base-0.7.2-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('variants', d)}"
ROS_BUILD_TYPE = "ament_cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('variants', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/variants/variants_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/variants/variants-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/variants/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/variants/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
