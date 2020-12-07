bagList = []

#reading the file/organizing/parsing strings
f = open("day7input.txt", "r")
for line in f:
    current = line.split(" bags contain ")
    currentBag = current[0]
    if "no other" in current[1]:
        bagsInside = []
    else:
        bagsInside = current[1].replace("\n", "").replace(".", "").replace(" bags", "").replace(" bag","").split(", ")
    bagList.append([currentBag, bagsInside])

allParents = []
totalChildren = 0

#recursive function to find all parent bags
def findParents(bags):
    parents = []
    #algorithm to put parent bags of current in list and return that list recursively
    if not (len(bags) == 0):
        for i in bags:
            for j in bagList:
                for k in j[1]:
                    if i in k:
                        parents.append(j[0])
    if len(parents) == 0:
        return bags;
    #appends current parents to list of full parents
    for i in parents:
        allParents.append(i);
    return findParents(parents)

#recursive function to find number of bags in gold bag
def findChildren(bags):
    children = []
    #algorithm to find/return list of child and its multiple
    if not (len(bags) == 0):
        for i in bags:
            for j in bagList:
                if i[0] in j[0]:
                    for k in j[1]:
                        currentChild = k.split(" ", 1)
                        #currentMultiple is the multiplier we have to multiply by to find the number of bags
                        currentMultiple = int(currentChild[0]) * i[1]
                        children.append([currentChild[1], currentMultiple])
                        global totalChildren
                        totalChildren += currentMultiple
    else:
        return bags
    return findChildren(children)

findParents(["shiny gold"])

findChildren([["shiny gold", 1]])

print(totalChildren)

#finds the number of unique parents in all parents
print(len(set(allParents)))




