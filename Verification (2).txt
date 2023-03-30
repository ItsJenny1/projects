import hashlib
import numpy as np

text1 = np.loadtxt("Salt.txt", dtype="str")

text2 = np.loadtxt("password.txt", dtype="str")

text3 = np.loadtxt("hash.txt", dtype="str")

merged_strings = []

for element1, element2 in zip(text2, text1):
    merged_strings.append(element1 + element2)


def computeMD5hash(my_string):
    m = hashlib.md5()
    m.update(my_string.encode('utf-8'))
    return m.hexdigest()


hashed = []
for i in range(len(merged_strings)):
    hash_result = computeMD5hash(merged_strings[i])
    hashed.append(hash_result)

print(hashed)

for i in range(len(hashed)):
    if text3[i] == hashed[i]:
        print(" The input password matches with hash value in the database.")
    else:
        print("not the same")



