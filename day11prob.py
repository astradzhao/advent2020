#putting file into grid
import copy
with open('day11input.txt') as f:
    oldData = [i.split() for i in f.readlines()]

for i in range(len(oldData)):
    oldData[i] = list(oldData[i][0])

changeData = [[1] * (len(oldData) + 3) for _ in range(len(oldData) + 2)]

data = [["."] * (len(oldData) + 3) for _ in range(len(oldData) + 2)]


for i in range(len(oldData)):
    for j in range(len(oldData[0])):
        data[i+1][j+1] = oldData[i][j]

for i in range(len(changeData)):
    for j in range(len(changeData[0])):
        if i == 0 or i == len(changeData) - 1:
            changeData[i][j] = 0
        if j == 0 or j == len(changeData[0]) - 1:
            changeData[i][j] = 0

def printData():
    print("Changes:")
    for i in range(len(data)):
        for j in range(len(data[0])):
            print(changeData[i][j], end = "")
        print("")
    print("Data:")
    for i in range(len(data)):
        for j in range(len(data[0])):
            print(data[i][j], end = "")
        print("")

def checkNone(i, j):
    returnVal = True
    for x in range(-1, 2):
        for y in range(-1, 2):
            if firstdata[i+x][j+y] == "#":
                returnVal = False
    return returnVal

def checkFour(i, j):
    count = 0
    for x in range(-1, 2):
        for y in range(-1, 2):
            if firstdata[i+x][j+y] == "#":
                count += 1
    return (count >= 4)

count = 0

firstdata = copy.deepcopy(data)

while max(max(changeData)) == 1:
    for i in range(1, len(data) - 1):
        for j in range(1, len(data[0]) - 1):
            if data[i][j] == "L":
                if checkNone(i, j):
                    data[i][j] = "#"
                    changeData[i][j] = 1
                else:
                    changeData[i][j] = 0
            elif data[i][j] == "#":
                if checkFour(i, j):
                    data[i][j] = "L"
                    changeData[i][j] = 1
                else:
                    changeData[i][j] = 0
            elif data[i][j] == ".":
                changeData[i][j] = 0
    firstdata = copy.deepcopy(data)

finalCount = 0

for i in data:
    for j in i:
        if j == "#":
            finalCount += 1
print(finalCount)