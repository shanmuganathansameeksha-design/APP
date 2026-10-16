from functools import reduce

salaries = [35000, 45000, 28000, 50000, 39000]

# Identify employees eligible for increment
eligible = list(filter(lambda s: s < 40000, salaries))
print("Eligible salaries:", eligible)

# Give 10% increment only to eligible employees
revised = list(map(
    lambda s: s * 1.10 if s < 40000 else s,
    salaries
))
print("Revised salaries:", revised)

# Calculate total salary expenditure
total = reduce(lambda x, y: x + y, revised)
print("Total salary expenditure:", total)

d) Why is functional programming suitable?
* It processes salary records efficiently using map() and filter().
* Lambda functions reduce the need for lengthy function definitions.
* It makes salary calculations concise and readable.
*  It allows operations to be performed on a new list without modifying the original salary list.