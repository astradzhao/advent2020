numList = []

#puts all numbers in a list
f = open("day9input.txt", "r")
for line in f:
    numList.append(int(line))

#checks if the number is the sum of 2 of the last 25 numbers
def findIfSum(cIndex):
    returnVal = False
    for i in range(cIndex-25, cIndex):
        for j in range(i, cIndex):
            if numList[i] + numList[j] == numList[cIndex]:
                returnVal = True
                break
    return returnVal

#cycles through the numbers, part 1
for i in range(len(numList)):
    if i > 24:
        if not findIfSum(i):
            invalid = numList[i]
            print(invalid)
            break

answerList = []
shouldBreak = False

#cycles through to find contiguous set of numbers that equal invalid, part 2
for i in range(len(numList)):
    currentSum = 0
    for j in range(i, len(numList)):
        currentSum += numList[j]
        if currentSum == invalid:
            for x in range(i, j+1):
                answerList.append(numList[x])
            print(min(answerList) + max(answerList))
            shouldBreak = True
            break
    if shouldBreak:
        break