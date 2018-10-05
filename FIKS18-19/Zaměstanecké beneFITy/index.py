""" Variables """
widthArr = []
heightArr = []
pathArr = []
watch = int

""" Helpers """
def input_valid(phrase, num1, num2):
    while True:
        read = int(input(phrase))
        if read < num1 or read > num2: print("Neplatný Input")
        else: return read

""" Inputs """
watch = input_valid("Zadej počet dozorců: ", 1, 1000)
for x in range(0, watch):
    widthArr.append(input_valid("Zadej X: ", 1, 75))
    heightArr.append(input_valid("Zadej Y: ", 1, 75))
    pathArr.append(input_valid("Zadej nejkratší cestu: ", 1, widthArr[x]*heightArr[x]))
    print("\n")

print(watch)
for x in range(0, watch):
    print(widthArr[x], heightArr[x], pathArr[x])
"""    for y in range(0, heightArr[x]):
        print"""
input()