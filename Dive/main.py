# Day 2: Dive!
# Commands - Forward, Down, Up
# Horizontal * Depth
import csv

navlist = []
horizontal = 0
vertical = 0
depth = 0
aim = 0

with open('navigation.csv', 'r') as file:
    reader = csv.reader(file)
    for row in reader:
        navlist.append(row)


for command in navlist:
    if command[0].split(' ')[0] == "forward":
        horizontal += int(command[0].split(' ')[1])
        if aim != 0:
            depth += aim*int(command[0].split(' ')[1])
    elif command[0].split(' ')[0] == "up":
        aim -= int(command[0].split(' ')[1])
    elif command[0].split(' ')[0] == "down":
        aim += int(command[0].split(' ')[1])


print("Depth is: " + str(depth*horizontal))





