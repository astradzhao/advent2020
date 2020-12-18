#putting file into grid
with open('day11input.txt') as f:
    data = [i.split() for i in f.readlines()]

for i in range(len(data)):
    data[i] = list(data[i][0])

changeData = [[1] * len(data) for _ in range(len(data))]

while max(max(changeData) == 1):
    
