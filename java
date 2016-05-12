#!/usr/bin/env sh

#set -ex

# This script wraps and modifies the behaviour of *java*
# it sets the LD_LIBRARY_PATH before execution

fullpathself=$(readlink -f $0)

next_executable() {
    # Returns the location of the next executable in the path with a matching
    # *basename*. This can be used to transparently proxy and modify shell
    # executables
    #
    # Arguments:
    # $1: Full path to the wrapping script
    local scriptname=$(basename $1)
    local result=""
    local found=0
    for path in $(which -a "$scriptname"); do
        if [ "$path" = "${fullpathself}" ]; then
            found=1
        elif [ "$found" -eq "1" ]; then
            result="$path"
            break
        fi
    done
    if [ -z $result ] # self not in PATH
    then
       result=$(which "$scriptname")
    fi
    printf %s "$result"
}

JAVA=$(next_executable "$fullpathself")
#printf %s\\n "$JAVA"

export LD_LIBRARY_PATH="/usr/lib/jni"

$JAVA $@
