#!/usr/bin/python

"""Compiles and executes a submission.

TO USE:
* Edit the bottom line to include the desired "target name" of the .java file.

For each submission:
./compilerun.py [file name]

this will attempt to execute it. IT should work on plain .java, .txt, and
.htm files.
"""

#~ import errno
#~ import shutil
import os
import re
import shutil
import subprocess
import sys
import tempfile


FILE_NAME_PARSE = re.compile("(.*)\.\d+(\..*)?")

# NOTE: Currently unused. I left it here in case we want to improve it and use it.
def compileAll(directory):
    users = {}

    for file in os.listdir("."):
        match = FILE_NAME_PARSE.match(file)
        if match is None:
            sys.stderr.write("%s did not parse?\n")
            continue

        user, extension = match.groups()
        if extension is not None:
            # Skip files with extensions, which are probably comments or something
            continue

        #~ f = tempfile.NamedTemporaryFile(suffix = 
        print file, user, extension


def compileRun(file, rename_to, main_class=None):
    if os.path.exists(rename_to):
        raise Exception("File %s exists: delete it if it is safe to overwrite." % (rename_to))

    base, extension = os.path.splitext(file)
    if extension == ".htm":
        # Unescape HTML to produce plain text
        input = open(file)
        data = input.read()
        input.close()

        replacements = (
                ("<div>", ""),
                ("</div>", ""),
                ("<p>", ""),
                ("</p>", ""),
                ("<br />", ""),
                ("&#160;", " "),
                ("&quot;", "\""),
        )
        for replacement in replacements:
            data = data.replace(replacement[0], replacement[1])

        output = open(rename_to, "w")
        output.write(data)
        output.close()
    else:
        shutil.copy(file, rename_to)

    # try/finally to delete rename_to
    try:
        subprocess.call(("javac", rename_to))
        if main_class is None:
            main_class = os.path.splitext(rename_to)[0]
        subprocess.call(("java", main_class))
    finally:
        os.unlink(rename_to)
        class_version = os.path.splitext(rename_to)[0] + ".class"
        if os.path.exists(class_version):
            os.unlink(class_version)

if __name__ == "__main__":
    #~ compileAll(".")
    compileRun(sys.argv[1], "DrawGraphics.java", "SimpleDraw")
