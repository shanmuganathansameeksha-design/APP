products = [500, 1200, 2000, 800, 1500]

# a) Pure function to calculate discounted price
def discount(price):
    if price > 1000:
        return price * 0.80
    return price

# b) Apply discount using map()
discounted_prices = list(map(discount, products))
print("Discounted prices:", discounted_prices)

# c) Identify products costing more than 1000
eligible = list(filter(lambda p: p > 1000, products))
print("Eligible products:", eligible)

d) How does a pure function avoid modifying the original list?

A pure function returns a result based on its input without changing the original data. Here, discount() calculates a new price, and map() creates a new list containing the results.
Therefore, products remains unchanged.
