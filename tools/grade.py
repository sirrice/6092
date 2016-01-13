# cheapo grading script to 6.092
#
# sorts and executes the assignments in
# in same order as in the gradebook (for easy grade entering)
#
# Setup:
# 1) download and extract assignment zip from stellar
# 2) cd into the extracted directory
# 3) mkdir reference/
# 4) download roster.csv from stellar into this folder
#    stellar->gradebook->dashboard-> --download-- -> roster.csv
# 5) copy this script into current folder
# 6) modify this script to do the right thing
#
# Running:
# 1) open up the assignment in gradebook
# 2) run script
# 3) profit
#
#
#
# eugenewu

import os, sys


f = file("roster.csv", 'r')

# skip the first two lines, which are headings
f.readline()
f.readline()

pairs = []
for l in f:
    l = l.strip()[1:]
    name = l[:l.find('"')]
    l = l[l.find('"') + 3:]
    email = l[:l.find('"')]
    pairs.append((name, email))


pairs.sort(key=lambda x: x[0])
f.close()

# now pairs should be sorted in the same order as
# the entries in Stellar->gradebook->[assignment]




# iterate through each student, check if they submitted something
# if they did,
# 1) blow away contents of reference/
# 2) copy their files into reference
# 3) compile
# 4) cat their file(s)
# 5) run their file(s)
os.system("rm skipped")
for name, email in pairs:
    if not os.path.exists("%s.1.java"):
        print "skipping %s" % name
        os.system("echo '%s\t%s' >> skipped" % (name, email))
        continue

    os.system("rm reference/*")

    # the assignments zip only contain the latest versions
    # of their submissions. e.g., assignment 4 should only have 2 files
    # you will need to do some fancy copying here so that the file
    # names match the classes
    os.system("cp %s.?.java reference/Runner.java" % email)
    os.system("cp %s.?.java reference/Race.java" % email)

    os.system("javac reference/Runner.java")
    os.system("javac reference/Race.java")

    os.system("cat reference/Runner.java")
    os.system("java -cp reference/ Runner")
    print "enter for next file"
    os.system("cat reference/Race.java")
    os.system("java -cp reference/ Race")

    print "\t".join((name, email))
    print "press <enter> for next student"


print "Huzzah!  Done!"
