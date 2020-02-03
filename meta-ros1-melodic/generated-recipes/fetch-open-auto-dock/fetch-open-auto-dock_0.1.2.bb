# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "An open-source version of the Fetch charge docking system."
AUTHOR = "Russell Toris <rtoris@fetchrobotics.com>"
ROS_AUTHOR = "Michael Ferguson"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "LGPL-2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=b691248d2f70cdaeeaf13696ada5d47c"

ROS_CN = "fetch_open_auto_dock"
ROS_BPN = "fetch_open_auto_dock"

ROS_BUILD_DEPENDS = " \
    actionlib \
    angles \
    fetch-auto-dock-msgs \
    fetch-driver-msgs \
    geometry-msgs \
    libeigen \
    nav-msgs \
    roscpp \
    roslib \
    rospy \
    sensor-msgs \
    std-msgs \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    fetch-auto-dock-msgs \
    fetch-driver-msgs \
    geometry-msgs \
    libeigen \
    nav-msgs \
    roscpp \
    roslib \
    rospy \
    sensor-msgs \
    std-msgs \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    fetch-auto-dock-msgs \
    fetch-driver-msgs \
    geometry-msgs \
    libeigen \
    nav-msgs \
    roscpp \
    roslib \
    rospy \
    sensor-msgs \
    std-msgs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/fetchrobotics-gbp/fetch_open_auto_dock-gbp/archive/release/melodic/fetch_open_auto_dock/0.1.2-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/fetch_open_auto_dock"
SRC_URI = "git://github.com/fetchrobotics-gbp/fetch_open_auto_dock-gbp;${ROS_BRANCH};protocol=https"
SRCREV = "ab928ccab9c5c60f35cb29bbc8e828c7fe6e82e5"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
