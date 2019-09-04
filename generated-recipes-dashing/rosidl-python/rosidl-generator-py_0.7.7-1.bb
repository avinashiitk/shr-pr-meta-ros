# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Generate the ROS interfaces in Python."
AUTHOR = "Scott K Logan <scott@openrobotics.org>"
ROS_AUTHOR = "Esteve Fernandez"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rosidl_python"
ROS_BPN = "rosidl_generator_py"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    rmw \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    ament-cmake-native \
    ament-index-python-native \
    python-cmake-module-native \
    rosidl-cmake-native \
    rosidl-typesupport-c-native \
    rosidl-typesupport-interface-native \
"

ROS_EXEC_DEPENDS = " \
    python3-numpy \
    rmw-implementation \
    rmw-implementation-cmake \
    rosidl-generator-c \
    rosidl-parser \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-pytest \
    ament-index-python \
    ament-lint-auto \
    ament-lint-common \
    python-cmake-module \
    python3-numpy \
    python3-pytest \
    rmw \
    rmw-implementation \
    rmw-implementation-cmake \
    rosidl-cmake \
    rosidl-generator-c \
    rosidl-parser \
    rosidl-typesupport-c \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/rosidl_python-release/archive/release/dashing/rosidl_generator_py/0.7.7-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "921efee12a0b78debac336dc1f80e0f2"
SRC_URI[sha256sum] = "00f78ac88e78bad7db449ffdeb4be8e2cffea088940c84945718288e3e0dc259"
S = "${WORKDIR}/rosidl_python-release-release-dashing-rosidl_generator_py-0.7.7-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rosidl-python', d)}"
ROS_BUILD_TYPE = "ament_cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rosidl-python', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosidl-python/rosidl-python_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosidl-python/rosidl-python-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosidl-python/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rosidl-python/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
