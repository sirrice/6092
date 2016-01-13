#!/bin/bash
#
# The "real" post commit hook for 6.092

set -e

REPOS=$1
REV=$2

SCRIPT_PATH=`dirname $0`

# Email the changes to all the members of the 6.092 AFS group
# discard the first line: it contains a garbage message
# append @csail.mit.edu to each line
USERS=(`pts membership 6.092 | tail --lines=+2 | sed 's/$/@csail.mit.edu/;'`)

#$SCRIPT_PATH/commit-email.pl -s "6.092:" --summary "$REPOS" "$REV" ${USERS[@]}
