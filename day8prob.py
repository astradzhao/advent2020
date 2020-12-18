import copy
instructions = []

#read the file
f = open("day8input.txt", "r")
for line in f:
    current = line.split(" ")
    cAction = current[0]
    cNumber = int(current[1])
    #0 = not yet checked, 1 = checked
    instructions.append([cAction, cNumber, 0])

#algorithm to calculate accCount
def returnAcc(instruction):
    i = 0
    accCount = 0
    while(instruction[i][2] == 0):
        instruction[i][2] = 1
        if instruction[i][0] == "acc":
            accCount += instruction[i][1]
            i += 1
        elif instruction[i][0] == "jmp":
            jumpAmount = instruction[i][1]
            i += jumpAmount
        else:
            i += 1
    return accCount

#part 1
print(returnAcc(copy.deepcopy(instructions)))


#checks if the instructions are an infinite loop
def checkifLoop(instruction):
    i = 0
    while(instruction[i][2] == 0) and (i != len(instruction) - 1):
        instruction[i][2] = 1
        if instruction[i][0] == "acc":
            i += 1
        elif instruction[i][0] == "jmp":
            jumpAmount = instruction[i][1]
            i += jumpAmount
        else:
            i += 1
    returnVal = True
    if i == (len(instruction) - 1):
        returnVal = False
    return returnVal

#return accumulator number
def returnAcc2(instruction):
    i = 0
    accCount = 0
    while(i < len(instruction)):
        instruction[i][2] = 1
        if instruction[i][0] == "acc":
            accCount += instruction[i][1]
            i += 1
        elif instruction[i][0] == "jmp":
            jumpAmount = instruction[i][1]
            i += jumpAmount
        else:
            i += 1
    return accCount

#part 2, cycling through each possibility
def partTwo(instruction, i):
    if instruction[i][0] == "jmp":
        instruction[i][0] = "nop"
        if not (checkifLoop(instruction)):
            print(returnAcc2(instruction))
    elif instruction[i][0] == "nop":
        instruction[i][0] = "jmp"
        if not (checkifLoop(instruction)):
            print(returnAcc2(instruction))

#part 2 answer            
for i in range(len(instructions)):
    partTwo(copy.deepcopy(instructions), i)
