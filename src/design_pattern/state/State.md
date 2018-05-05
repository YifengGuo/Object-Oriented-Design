#### State Design Pattern
State design pattern is used when all states of a system can
build a closed loop

unlike Strategy design pattern, which we can design as many
different and proper strategies as we like. State of system will
change immediately when some action has been taken like inserting
a coin into a Vending Machine

![state design pattern](https://github.com/YifengGuo/Object-Oriented-Design/blob/master/src/design_pattern/state/state.png?raw=true)

State change will happen automatically


Example of State:
```
    1. How many different states are there?
    
    2. Which functions will be affected by the change of state?
    
    3. State class and all of its child classes
    
    4. Append necessary fields and functions into the system
```
In the Vending Machine:
```
    1. We have an Interface State to claify all the necessary
       functions (use cases) for the system
       
    2. An abstract class AbstractState as super class for all
       concrete State of the system which implements the State
       interface
       
    3. Write down all the child class of AbstractState class and
       override all the functions of the interface to explicitly
       require the system to do the jobs corresponding to its current
       state
       
    4. In the certain function, for example, if current state is
       NoItemSelectedState, and after invoke() selectItem(), inside 
       the function, we should change the state into HasItemSelectedState
```

