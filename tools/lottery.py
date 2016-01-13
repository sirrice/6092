# Author: Olivier Koch, koch@csail.mit.edu
# Date: January 2009
#
# This program takes as input a text file containing a list of students
# and an integer number n, and outputs a random subset of students of size n
#
# the format of the text file is one line per student, where each line must 
# start with the last name and the first name of the student, separated
# by one or more spaces.
#
import os
import sys
import string
import random

class Application:
    def __init__ (self):
        if len(sys.argv) is not 3:
            self.usage ()
            sys.exit(1)
        # read list of students from file
        f = open (sys.argv[1], 'r')
        if f is None:
            print ("failed to open file %s" % sys.argv[2])
            sys.exit(1)
        self.students = []
        for line in f.readlines():
            line = string.replace (line, ",", "")
            words = line.split()
            self.students.append ("%s %s" % (words[0],words[1]))
        f.close ()
        # initialize random machine
        random.seed()
        self.max_students = string.atoi(sys.argv[2])

    def usage (self):
        print "python lottery.py <filename> <number of students>"

    def run (self):
        # shuffle the list of students
        random.shuffle(self.students)
        count=0
        selected = []
        # make the list of selected students
        for student in self.students:
            selected.append (student)
            count = count + 1
            if count >= self.max_students:
                break
        # sort before printing
        selected.sort()
        # print
        for student in selected:
            print student

Application ().run ()
