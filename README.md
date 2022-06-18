# String Calculator Kata

Implemented in Java, using TDD.

## Incremental kata

It’s an incremental kata to simulate a real business situation: start of by reading the section 1 and completing it,
then go onto section 2, and when you have finished that, look at section 3, etc.

## Step 1

Create a simple String calculator with a method signature:

    int Add(string numbers)

The method can take up to two numbers, separated by commas, and will return their sum.

For example ` ` or `1` or `1,2` as inputs.

For an empty string it will return 0.

## Step 2

Allow the Add method to handle an unknown amount of numbers.

## Step 3

Allow the Add method to handle new lines between numbers (instead of commas):

The following input is ok : `1\n2,3` (will equal 6)

The following input is NOT ok : `1,\n` (not need to prove it - just clarifying)

## Step 4

Support different delimiters:

To change a delimiter, the beginning of the string will contain a separate line that looks like
this: `//[delimiter]\n[numbers…]` for example `//;\n1;2` should return three where the default delimiter is `;`.

The first line is optional. All existing scenarios should still be supported.

## Step 5

Calling Add with a negative number will throw an exception `negatives not allowed` - and the negative that was passed.

If there are multiple negatives, show all of them in the exception message.

## Credits

Inspired by Roy Osherove [https://osherove.com/]
