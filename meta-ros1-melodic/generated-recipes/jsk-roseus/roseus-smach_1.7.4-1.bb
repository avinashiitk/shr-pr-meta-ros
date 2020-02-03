# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "roseus_smach       * Euslisp state machine class. it will be moved.      * Message publisher for visualizing current state by smach_viewer.      * Simple pickle dump script for debugging state machine.      * Execute state machine as a action server."
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Manabu Saito"
HOMEPAGE = "http://ros.org/wiki/roseus_smach"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "jsk_roseus"
ROS_BPN = "roseus_smach"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-tutorials \
    message-generation \
    roseus \
    rostest \
    smach \
    smach-msgs \
    smach-ros \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-tutorials \
    message-runtime \
    roseus \
    rostest \
    smach \
    smach-msgs \
    smach-ros \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-tutorials \
    message-runtime \
    roseus \
    rostest \
    smach \
    smach-msgs \
    smach-ros \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/jsk_roseus-release/archive/release/melodic/roseus_smach/1.7.4-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/roseus_smach"
SRC_URI = "git://github.com/tork-a/jsk_roseus-release;${ROS_BRANCH};protocol=https"
SRCREV = "2b422b096d9b710cc13dc9399e386dc4c248c3b1"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
