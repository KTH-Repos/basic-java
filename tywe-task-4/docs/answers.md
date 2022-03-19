# Answers to Task 4

### Exercise 3.9

Answer: The statements that return true are

! false

(34 != 33) && ! false

### Exercise 3.10

Answer:

(a == true  &&  b == true) || (a == false && b == false)

### Exercise 3.11

Answer:

(a == true && b == false) || (a == false && b == true)


### Exercise 3.12

Answer:

!(!a || !b)

### Exercise 3.21

Answer:
```java

public void increment ()

{
    value = value + 1;
    if(value >= limit) {
         value = 0;
       }
}

```
### Exercise 3.26

Answer:
```java
public Editor (String filename, int number)
```

### Answer 3.27

Answer:
```java
Rectangle window = new Rectangle (2,5);

```


### Answer 3.30

Answer:
```java
p1.print("file34", true);

p1.print("file56", true);

int status;

status = p1.getStatus (10);

status = p1.getStatus (20);
```
