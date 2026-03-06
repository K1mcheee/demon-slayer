## Task 2

Before you begin, copy over your files from Task 1 to the Task 2 folder.

As an expert OOP coder, you may have noticed that things can go badly if a user tries to use a unknown form (e.g, Tanjiro tries to use _Obscuring Clouds_ from mist breathing.) You want to avoid this during battle to avoid getting killed by a demon!

## WrongFormException

Create a *checked exception* called `WrongFormException`. This should be thrown when a Slayer tries to use a form that does not exist in their breathing style. To avoid being killed by a demon, you should handle this by performing a basic attack that does
5 damage.

Sample output:

```java
jshell> WaterBreathing water = new WaterBreathing(3)
water ==> Water Breathing

jshell> water.add(0, new Form("Water Surface Slash", 10));

jshell> water.add(1, new Form("Water Wheel", 12));

jshell> water.add(2, new Form("Flowing Dance", 15));

jshell> Slayer tanjiro = new Slayer("Tanjiro", water);
tanjiro ==> Tanjiro: Water Breathing

jshell> water.perform("Water Surface Slash");
$26 ==> 10

jshell> water.perform("Obscuring Clouds");
|  Exception REPL.$JShell$38$WrongFormException: Mismatched form
|        at BreathingStyle.perform (#1:21)
|        at (#27:1)

jshell> tanjiro.attack("water surface");
Mismatched form, performing basic attack
$28 ==> 5
```

You can test your implementation with:
```
java -cp ../demonslayer-test.jar:. Test3
```

---

## Battle

Of course, what is the point of creating these without an actual battle simulation? Create a class `Battle.java` to conduct this simulation. 

Implement the method `String simpleBattle(Demon d, Slayer s)`. The battle would continue while both the demon and slayer's health is greater than 0. Once it ends, return the winner.

### Random

To make things fair, the damage dealt by each form of the breathing style is now randomized, with the `int` field representing the maximum damage (rather than actual damage).

As a reference for `Random` class usage:

```java
import java.util.Random;

// make new instance
Random r = new Random();
int maxDamage = 30;
// call random 
int actual = r.nextInt(maxDamage);
```
You should set `Random r` as a field.

The flow of the battle begins with the slayer attacking. Utilizing the `Random` class, the slayer will launch an attack with any of the forms of their breathing style. If the demon is still alive after this, the demon will launch an attack on the slayer. This continues until either of their health reaches or is below 0.

**Sample simulation**
```java
  public static void main(String[] args) {
      Demon d = new UpperMoon("Doma", 3);
      WaterBreathing water = new WaterBreathing(3);
      water.add(0, new Form("Water Surface Slash", 50)); // max 50 damage
      water.add(1, new Form("Water Wheel", 25));
      water.add(2, new Form("Flowing Dance", 10));
      Slayer s = new Slayer("Tanjiro", water);
      String result = Battle.simpleBattle(d, s);
      System.out.println(result);
  }

Output:
Tanjiro attacked with 7 damage!
Doma attacked with 13 damage!
Tanjiro attacked with 28 damage!
Doma attacked with 13 damage!
Tanjiro attacked with 28 damage!
Doma attacked with 13 damage!
Tanjiro attacked with 28 damage!
Doma attacked with 13 damage!
Tanjiro attacked with 28 damage!
Doma attacked with 13 damage!
Tanjiro attacked with 7 damage!
Doma attacked with 13 damage!
Tanjiro attacked with 28 damage!
Winner: Tanjiro: Water Breathing
```

You can make use of the `Main` class to test out your implementation (i.e., run `javac Main.java` then `java Main`). The damage dealt and winner each time you run should vary.

**Hints**
* You should have a new method in `Slayer` to carry out the random attack.
* When randomly deciding which form to execute, the maximum index should be `size - 1` where size is the number of forms the breathing style has.
* Please let me know if this logic is too difficult

**Further hints**
* For battle, I added 2 methods to `Slayer`, 1 to `Demon`, `Form` and `BreathingStyle`
