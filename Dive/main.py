# Day 2: Dive!
# Commands - Forward, Down, Up
# Horizontal * Depth
import csv
import numpy as np

navlist = []
horizontal = 0
vertical = 0
depth = 0

with open('navigation.csv','r') as file:
    reader = csv.reader(file)
    for row in reader:
        navlist.append(row)


for command in navlist:
    if command[0].split(' ')[0] == "forward":
        horizontal += int(command[0].split(' ')[1])
    elif command[0].split(' ')[0] == "up":
        vertical -= int(command[0].split(' ')[1])
    elif command[0].split(' ')[0] == "down":
        vertical += int(command[0].split(' ')[1])


print(horizontal*vertical)



