# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "ROS integration for the Catch unit test framework"
AUTHOR = "Max Schwarz <max.schwarz@ais.uni-bonn.de>"
ROS_AUTHOR = "Max Schwarz <max.schwarz@ais.uni-bonn.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=5;endline=5;md5=75730354549103aaba72b66caf53717b"

ROS_CN = "catch_ros"
ROS_BPN = "catch_ros"

ROS_BUILD_DEPENDS = " \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/AIS-Bonn/catch_ros-release/archive/release/melodic/catch_ros/0.3.0-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/catch_ros"
SRC_URI = "git://github.com/AIS-Bonn/catch_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "0cd2301b455d642dff5c5396698d0f0793002d79"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
