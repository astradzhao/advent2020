EMP = 'L'
OCC = '#'
FLR = '.'


def seating_system(seats, rule, model):
    grid = seats
    while True:
        new = []
        for r in range(len(grid)):
            new_line = []
            for c in range(len(grid[r])):
                seat = grid[r][c]
                near = [i for i in model(r, c, grid)]
                if seat == EMP and near.count(OCC) == 0:
                    new_line.append(OCC)
                elif seat == OCC and near.count(OCC) >= rule:
                    new_line.append(EMP)
                else:
                    new_line.append(seat)
            new.append(new_line)
        if grid == new:
            return sum(i.count(OCC) for i in new)
        grid = new


def adjacent(row, column, grid):
    for x in range(row - 1, row + 2):
        for y in range(column - 1, column + 2):
            if 0 <= x < len(grid) and 0 <= y < len(grid[0]) and (x, y) != (row, column):
                yield grid[x][y]


def visible(row, column, grid):
    for x in range(-1, 2):
        for y in range(-1, 2):
            i = 1
            while 0 <= row + i * x < len(grid) and 0 <= column + i * y < len(grid[0]) and not x == y == 0:
                if grid[row + i * x][column + i * y] != '.':
                    yield grid[row + i * x][column + i * y]
                    break
                i += 1


def main():
    seats = open('day11input.txt').read().splitlines()
    part_1 = seating_system(seats, 4, adjacent)
    part_2 = seating_system(seats, 5, visible)
    print(part_1)
    print(part_2)


if __name__ == '__main__':
    main()