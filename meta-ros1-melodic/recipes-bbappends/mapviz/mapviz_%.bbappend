# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[mapviz] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'x11'], 'Requires libqt-rosdev which depends on qtbase which requires meta-qt5 to be included and freeglut, libxmu, libxi which require x11', '', d)}"
