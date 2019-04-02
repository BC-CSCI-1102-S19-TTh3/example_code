# instantiating a dictionary
mydictionary = {}

# adding key-value pairs to a dictionary
mydictionary["dog"] = 2
mydictionary["cat"] = 17
mydictionary["hamster"] = 1
mydictionary["houseplant"] = 5

# getting a value using a key
mycatcount = mydictionary["cat"]


# looping through keys in a dictionary
for k in mydictionary.keys():
  print(k, mydictionary[k])

# looping through keys and values
for k,v in mydictionary.items():
  print(k,v)

if "cat" in mydictionary:
    print("cat is in the dictionary!")
