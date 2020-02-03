# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "rqt_tf_tree provides a GUI plugin for visualizing the ROS TF frame tree."
AUTHOR = "Isaac I.Y. Saito <gm130s@gmail.com>"
ROS_AUTHOR = "Thibault Kruse"
HOMEPAGE = "http://wiki.ros.org/rqt_tf_tree"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rqt_tf_tree"
ROS_BPN = "rqt_tf_tree"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    python-qt-binding \
    python-rospkg \
    qt-dotgraph \
    rospy \
    rqt-graph \
    rqt-gui \
    rqt-gui-py \
    tf2 \
    tf2-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    python-qt-binding \
    python-rospkg \
    qt-dotgraph \
    rospy \
    rqt-graph \
    rqt-gui \
    rqt-gui-py \
    tf2 \
    tf2-msgs \
    tf2-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    python-mock \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/rqt_tf_tree-release/archive/release/melodic/rqt_tf_tree/0.6.0-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rqt_tf_tree"
SRC_URI = "git://github.com/ros-gbp/rqt_tf_tree-release;${ROS_BRANCH};protocol=https"
SRCREV = "d55a649629c5d44b82a43fe76ce0451c0c612822"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
