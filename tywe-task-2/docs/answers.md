#Exercise 2.45

Answer: Since this method does not need to take in extra information from outside, no parameters are necessary to be put in the header of the empty method.

The empty method is a mutator because it changes the value of the field total in the ticket machine object. The value 0 is used to overwrite whatever value there is is in the field total.


# Exercise 2.58
 Answer: The reason that the code returns 0 instead of the sum of money in the ticket machine is because the balance is set to be 0 inside the method. So when the refundBalance method is called the return value is 0. If I were to call this method in the original code the return value will be whatever the amount of money there is in the balance of the ticket machine.

 Inorder to test this, I run both the original code and this modified code in the exercise separately. In the beginning the balance in both cases was 500. When I called the method in the original code the return value was 500. Hence the balance became 0. When i called the method in the modified code both the return value and the balance became 0.

 # Exercise 2.59
 Answer: The source code does not compile and an error message is shown in the source code. The reason for this problem is the fact that the return statement is not in the last line of the block of the method. Return statement are always the final statement of that specific method to be executed.

 # Exercise 2.60
 Answer: Yes the source code compiles after I have modified the constructor. But the price is not the one I assigned in the initialization of the object. It becomes 0. The reason can be because the data type of the field price is declared inside the constructor, which is not a correct syntax.
