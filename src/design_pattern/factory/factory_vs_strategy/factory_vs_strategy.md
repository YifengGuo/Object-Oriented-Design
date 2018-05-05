#### Factory vs Strategy:
![difference between factory and strategy](https://github.com/YifengGuo/Object-Oriented-Design/blob/master/src/design_pattern/factory/factory_vs_strategy/factory_vs_strategy.jpg?raw=true)

Assume we in the Hotel Reservation System, we have a module for user to
make payment. And the system accepts both debit card and credit card. So
for this case, we could apply Strategy Design Pattern and based on user's
payment choice, the system will do corresponding job

![](https://github.com/YifengGuo/Object-Oriented-Design/blob/master/src/design_pattern/factory/factory_vs_strategy/strategy.jpg?raw=true)

So strategy focus more on the behavior. The system would have an interface
Strategy with some functions (use cases) for the issues this Strategy designed 
for. Given different issues, system will create corresponding strategy for the
issue. And this creation process could be optimized by Factory Design Pattern.

![](https://github.com/YifengGuo/Object-Oriented-Design/blob/master/src/design_pattern/factory/factory_vs_strategy/factory_with_strategy.jpg?raw=true)

We could have a factory especially designed for creating new Strategy for
the specific incoming issue