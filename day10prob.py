numList = []

#making the list of numbers
f = open("day10input.txt", "r")
for line in f:
    numList.append(int(line))

numList.append(0)
end = max(numList) + 3
numList.append(end)

numList.sort()

oneCount = 0
threeCount = 0

#part 1: finding differences
for i in range(len(numList)-1):
    diff = numList[i+1] - numList[i]
    print
    if diff == 3:
        threeCount += 1
    if diff == 1:
        oneCount += 1

print(oneCount * threeCount)

#part 2: calculating possibilties
numList.remove(0)

calc = {0:1}

for i in numList:
  calc[i] = calc.get(i-3,0) + calc.get(i-2,0) + calc.get(i-1,0)

print(calc[numList[-1]])