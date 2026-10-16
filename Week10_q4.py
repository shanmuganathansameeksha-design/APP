from functools import reduce

consumption = [8, 12, 9, 15, 6, 11]

# a) Days with consumption exceeding 10 units
high_consumption = list(
    filter(lambda x: x > 10, consumption)
)
print("Consumption above 10 units:", high_consumption)

# b) Calculate daily electricity cost at Rs. 6 per unit
cost = list(map(lambda x: x * 6, consumption))
print("Daily electricity cost:", cost)

# c) Calculate total electricity consumption
total = reduce(lambda x, y: x + y, consumption)
print("Total consumption:", total, "units")

# d) Pure function to calculate electricity bill
def electricity_bill(units):
    return units * 6

bill = electricity_bill(total)
print("Total electricity bill: Rs.", bill)