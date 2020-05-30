# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "The ROS client library in C."
AUTHOR = "Jan Staschulat <jan.staschulat@de.bosch.com>"
ROS_AUTHOR = "Jan Staschulat <jan.staschulat@de.bosch.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rclc"
ROS_BPN = "rclc"

ROS_BUILD_DEPENDS = " \
    rcl \
    rcutils \
    rosidl-generator-c \
    rosidl-typesupport-c \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rcl \
    rcutils \
    rosidl-generator-c \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-cmake-pytest \
    ament-lint-auto \
    ament-lint-common \
    launch-testing \
    osrf-testing-tools-cpp \
    std-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/micro-ROS/rclc-release/archive/release/dashing/rclc/0.1.2-2.tar.gz
ROS_BRANCH ?= "branch=release/dashing/rclc"
SRC_URI = "git://github.com/micro-ROS/rclc-release;${ROS_BRANCH};protocol=https"
SRCREV = "ffe0cefef7eaec1fb861eba77325fc30743acb61"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
