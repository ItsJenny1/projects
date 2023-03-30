import hashlib
import numpy as np

text1 = np.loadtxt("Salt.txt", dtype="str")

text2 = np.loadtxt("password.txt", dtype="str")

text3 = np.loadtxt("hash.txt", dtype="str")

text4 = np.loadtxt("UID.txt", dtype="str")

merged_strings = []

for element1, element2 in zip(text2, text1):
    merged_strings.append("password: " + element1 +" Salt: "+ element2)


hash_dict = {}

for i, merged_strings in enumerate(merged_strings):
    key = text4[i]
    hash_dict[key] = merged_strings

print(hash_dict)
find = "006"

string_array = hash_dict.get(find)
print("ID: " + find)
print("String array: " + str(string_array))


