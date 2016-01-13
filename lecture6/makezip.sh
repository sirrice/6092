#!/bin/sh

set -e

mkdir -p t/assignment6/src
cp ../lecture5/SimpleDraw.java assignment6/*.java t/assignment6/src
cd t
zip -r9 assignment6.zip assignment6
mv assignment6.zip ..
cd ..
rm -r t
