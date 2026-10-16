from functools import reduce

marks = [45, 67, 32, 89, 50, 76, 95]

# a) Identify students scoring 50 or above
passed = list(filter(lambda x: x >= 50, marks))
print("Students scoring 50 or above:", passed)

# b) Award 5 grace marks, maximum 100
grace_marks = list(map(lambda x: min(x + 5, 100), marks))
print("Marks after grace marks:", grace_marks)

# c) Calculate total marks
total = reduce(lambda x, y: x + y, grace_marks)
print("Total marks:", total)