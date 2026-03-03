# Demon Slayer Simulation

You recently watched *Demon Slayer: Infinity Castle* and got inspired to create a mini **simulation of battles** between Demon Slayers and Demons. Your task is to implement a set of classes that model and simulate their interactions.

---
# Task 1

## Refactoring

You decided to take over a simulation written by someone else who gave up because it got too messy. You notice that the code has
bad OOP principles which resulted in this mess and made extensibility difficult. **Rewrite the code with better OOP principles you have learnt in class**. The next part would involve developing the existing simulation, so good design would make your life easier.

Make the necessary changes in the `Part1` directory. You can test your implementation with the command:
```
java -cp ../demonslayer-test:. Test1
```

Hint: you should NOT be using the DemonSlayer class anymore. Do not copy this file over to the next parts.

---

## Core Logic

After you are finally done refactoring, you decided it is time to make the simulation more interesting by adding more details. *Copy your files from Part1 over to the Task1 directory.* 

Remember to make changes to your earlier implementation where needed. In particular, note any changes in output that may not
be explicitly mentioned.

## Executable

First, create an interface `Executable` with a single method `int execute()`. It should not take any parameters.

## Breathing Styles

As a demon slayer, one should ideally master a **breathing style** to fight effectively. Each breathing style has multiple **forms**, which you can think of as special techniques.

* Each `BreathingStyle` stores its forms with **Seq** we have learnt in class.
  - You can modify the **Seq** template given if needed such that it works with your implementation.
  - Seq should take in elements that are **executable**. (I.e., we can call `execute()` on them). 
* A `Form` has a **name** (`String`) and a **damage value** (`int`). Two forms are considered equal if they have the **same name**.
  - Forms should be executable.
* Forms can be added with `add(int idx, Form form)`.
* Slayers can use a form with `perform(String name)`, which returns its damage.

**Hints:**

* `BreathingStyle` has a constructor that takes in an `int` which creates a **Seq** containing forms.
* `perform(String name)` should search for a form by name and return its damage. Tracking the number of forms for a breathing style may thus be useful.

### Water Breathing

Water breathing is a specific breathing style, popularly used by Giyuu Tomioka. In this simulation however, there are only 3 possible forms.

Create a `WaterBreathing` class that contains 3 forms:
* Form 1: "Water Surface Slash", deals 10 damage.
* Form 2: "Water Wheel", deals 12 damage.
* From 3: "Flowing Dance", deals 15 damage.

Sample output:

```java
jshell> BreathingStyle water = new WaterBreathing(3);
water ==> Water Breathing

jshell> water.add(0, new Form("Water Surface Slash", 10));

```

---

## Slayer

A **Slayer** now can master a **breathing style**:
* The slayers can still **attack** which takes in the name of a form (a `String`) and use the form from their breathing style to deal damage.

To make things more realistic, you also want an effect when a slayer gets wounded. A sample output is given below.

**Hints:**

* Each Slayer holds a reference to a `BreathingStyle`.
* You can directly call `perform` on their breathing style when using a form.

Sample output:

```java
jshell> BreathingStyle water = new WaterBreathing(3);
water ==> Water Breathing

jshell> water.add(0, new Form("Water Surface Slash", 10));

jshell> Slayer tanjiro = new Slayer("Tanjiro", water);
tanjiro ==> Tanjiro: Water breathing

jshell> tanjiro.attack("Water Surface Slash");
Tanjiro attacked with 10 damage!
$10 ==> 10

jshell> tanjiro.wound(13);
Tanjiro was wounded! Current health: 87
```

---

## Upper Moon Demons

* As in the series, upper moon demons have a **rank** represented by an `int` which corresponds to their power.
* To simulate this, their attack now deals an addition of `10 / rank` to the base damage of normal demons.

Sample output:

```java
jshell> Demon akaza = new UpperMoon("Akaza", 3);
akaza ==> Demon Akaza: upper 3

jshell> akaza.wound(dmg);
Demon Akaza: upper 3 was wounded! Current health: 140

jshell> int counter = akaza.attack();
Akaza attacked with 13 damage!
counter ==> 13
```

---

## Simulation / Example Flow

Here is an example output for reference.

**Example:**

```java
jshell> BreathingStyle water = new WaterBreathing(3);
water ==> Water Breathing

jshell> water.add(0, new Form("Water Surface Slash", 10))

jshell> Slayer tanjiro = new Slayer("Tanjiro", water);
tanjiro ==> Tanjiro: Water Breathing

jshell> Demon akaza = new UpperMoon("Akaza", 3);
akaza ==> Demon Akaza: upper 3

jshell> int dmg = tanjiro.attack("Water Surface Slash");
Tanjiro attacked with 10 damage!
dmg ==> 10

jshell> akaza.wound(dmg);
Demon Akaza: upper 3 was wounded! Current health: 140

jshell> int counter = akaza.attack();
Akaza attacked with 13 damage!
counter ==> 13

jshell> tanjiro.wound(counter);
Tanjiro was wounded! Current health: 87
```

---

You can test your implementation with the command:
```
java -cp ../demonslayer-test:. Test2
```
Good job! Now, you can move on to task 2.

