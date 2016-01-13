#!/usr/bin/python

"""
Script for including files inside HTML source. Used for assignments.

Looks for lines matching:
<!--STARTINCLUDE [path]-->
<!--ENDINCLUDE-->

And fills the space between them with the contents of [path]
"""

import os.path

INCLUDESTART = "<!--STARTINCLUDE"
COMMENTEND = "-->"
INCLUDEEND = "<!--ENDINCLUDE-->"


if __name__ == "__main__":
    import sys
    
    if len(sys.argv) != 3:
        sys.stderr.write("stupidinclude.py [in file] [out file]\n")
        sys.exit(1)

    in_stream = open(sys.argv[1])
    base_path = os.path.dirname(sys.argv[1])

    outlines = []
    in_include = False
    for line in in_stream:
        
        if line.startswith(INCLUDESTART):
            stripped = line.strip()
            if stripped.endswith(COMMENTEND):
                if in_include:
                    raise Exception("Start include inside an include section")
                in_include = True

                outlines.append(line)

                path = stripped[len(INCLUDESTART):-len(COMMENTEND)].strip()
                path = os.path.normpath(os.path.join(base_path, path))
                print "Including", path
                data = open(path)
                for l in data:
                    l = l.replace("&", "&amp;")
                    l = l.replace(" ", "&nbsp;")
                    l = l.replace("<", "&lt;")
                    l = l.replace("\n", "<br />\n")
                    
                    outlines.append(l)
                data.close()
        elif line.startswith(INCLUDEEND):
            if not in_include:
                raise Exception("End include outside an include section")
            in_include = False

        if not in_include:
            outlines.append(line)

    if in_include:
        raise Exception("Include section did not end")

    out_stream = open(sys.argv[2], "w")
    out_stream.write("".join(outlines))
    out_stream.close()
