import re
import math
from itertools import cycle

#part 1 algorithm
ewVal = 0
nsVal = 0
#0 = N, 90 = E, 180 = S, 270 = W
cDir = 90

dList = []
f = open("day12input.txt", "r")
for line in f:
    lLine = re.split('(\d+)', line)
    dList.append([lLine[0], lLine[1]])

for i in dList:
    c = i[0]
    a = int(i[1])
    if c == "N":
        nsVal += a
    elif c == "S":
        nsVal -= a
    elif c == "E":
        ewVal += a
    elif c == "W":
        ewVal -= a
    elif c == "L":
        cDir = (cDir - a) % 360
    elif c == "R":
        cDir = (cDir + a) % 360
    elif c == "F":
        if cDir == 0:
            nsVal += a
        elif cDir == 90:
            ewVal += a
        elif cDir == 180:
            nsVal -= a
        elif cDir == 270:
            ewVal -= a

#part 1 answer
print(abs(nsVal) + abs(ewVal))

#part 2
ewVal = 0
nsVal = 0
wayEW = 10
wayNS = 1
cQ = 0

#rotation matrix to determine waypoint position
def detDir(degree):
    degree = degree * math.pi / 180
    x = round(wayEW * math.cos(degree) - wayNS * math.sin(degree))
    y = round(wayEW * math.sin(degree) + wayNS * math.cos(degree))
    return([x, y])

#part 2 algorithm
for i in dList:
    c = i[0]
    a = int(i[1])
    if c == "N":
        wayNS += a
    elif c == "S":
        wayNS -= a
    elif c == "E":
        wayEW += a
    elif c == "W":
        wayEW -= a
    elif c == "L":
        wayC = detDir(a)
        wayNS = wayC[1]
        wayEW = wayC[0]
    elif c == "R":
        wayC = detDir(-a)
        wayNS = wayC[1]
        wayEW = wayC[0]
    elif c == "F":
        ewVal += a * wayEW
        nsVal += a * wayNS

#part 2 answer
print(abs(nsVal) + abs(ewVal))