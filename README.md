

## 📘 Java Lesson: Arrays, Binary Search, and Real-World Applications

### 🧑‍🏫 Topics Covered

1. **Arrays in Java**
2. **Binary Search Algorithm**
3. **Binary Search in Real Life (Games, Healthcare)**
4. **Debugging in IntelliJ IDEA**
5. **Code Refactoring: Clean Methods**
6. **Finding Multiple Matches with Binary Search**

---

### 🔹 1. Arrays in Java

- Arrays are used to **store multiple values of the same type**.
- Fixed in size, indexed from `0`.
- Example:

```java
int[] numbers = {5, 12, 17, 23, 38};
System.out.println(numbers[2]); // prints 17
```

---

### 🔹 2. Binary Search: Fast Search in Sorted Arrays

#### ✅ Key Idea:
Eliminate half the search space each time.

#### Time Complexity:
- **Binary Search** = `O(log n)`
- **Linear Search** = `O(n)` ← slow for big data

#### Code Example:

```java
int binarySearch(int[] arr, int key) {
    int low = 0, high = arr.length - 1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (arr[mid] == key) return mid;
        else if (arr[mid] < key) low = mid + 1;
        else high = mid - 1;
    }
    return -1;
}
```

---

### 🔹 3. Real-World Themes

#### 🎮 "Guess the Number" Game
- User guesses a number; computer says "Too High", "Too Low", or "Correct".
- Classic Binary Search strategy.

#### 🏥 Health Diagnosis Simulator
- User enters **symptom severity**.
- System finds **all diseases with that severity** using binary search + expansion.

---

### 🔹 4. Debugging with IntelliJ IDEA 🐞

- Use **breakpoints** to pause and inspect variables.
- Use **Step Into (F7)** and **Step Over (F8)** to walk through code.
- Use **Evaluate Expression** to test logic live.

**Watch Variables:**
- `low`, `high`, `mid`
- `arr[mid]`
- `severity`, `matches`

---

### 🔹 5. Refactored Code for Reusability

- Binary search logic extracted into standalone method:

```java
public static Disease findDiseaseBySeverity(Disease[] diseases, int severity) {
    // returns one match
}
```

- Later upgraded to return **multiple matches** with:

```java
public static List<Disease> findAllDiseasesBySeverity(...)
```

---

### 🔹 6. Multiple Matches with Binary Search

- After finding **one match**, we expand **left** and **right** to gather all diseases of the same severity.
- Fast + reliable.

---

### 💡 Key Takeaways

- Always **sort** your data before using binary search.
- Binary Search is **fast**, but works only on **sorted arrays**.
- Real-world themes make algorithms easier to understand.
- Refactor long logic into **clean, testable methods**.
- **Debugging is a skill** every good developer uses it early!

---

