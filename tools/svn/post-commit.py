#!/usr/bin/python

# post-commit hook for 6.092
# Checks out the SUBVERSION_TOOLS directory, executes REAL_POST_COMMIT
# This automatically updates itself, so it only needs to be installed once
# (and again if this script gets broken due to a change ... it happens)

import shutil
import subprocess
import sys
import tempfile

# Relative path to the subversion tools in the repository
SUBVERSION_TOOLS = "tools/svn"
# Relative path to the real post commit script, within SUBVERSION_TOOLS
REAL_POST_COMMIT = "real-post-commit.sh"
# Relative path to this script, within SUBVERSION_TOOLS
SELF_NAME = "post-commit.py"

SUBVERSION = "svn"
POST_COMMIT_HOOK_PATH = "hooks/post-commit"

def checkoutToolsAndRunScript(repository, revision):
    # Check out the latest tools to a temporary directory
    tempdir = tempfile.mkdtemp()
    try:
        checkout_command = (SUBVERSION, "co", "file://" + repository + "/trunk/" + SUBVERSION_TOOLS, tempdir + "/temp")
        #~ sys.stderr.write("checkout: " + str(checkout_command) + "\n")
        result = subprocess.call(checkout_command)
        assert result == 0

        # Execute the *real* post commit script
        real_post_commit = (tempdir + "/temp/" + REAL_POST_COMMIT, repository, revision)
        #~ sys.stderr.write("real post commit: " + str(real_post_commit) + "\n")
        result = subprocess.call(real_post_commit)
        assert result == 0

        # Replace the post commit script with ourselves (permits updates)
        shutil.copy(tempdir + "/temp/" + SELF_NAME, repository + "/" + POST_COMMIT_HOOK_PATH)
        #~ sys.exit(1)  # Needed to force subversion to return stderr to the user
    finally:
        # Clean up the temporary directory, no matter what
        shutil.rmtree(tempdir)

if __name__ == "__main__":
    checkoutToolsAndRunScript(sys.argv[1], sys.argv[2])
