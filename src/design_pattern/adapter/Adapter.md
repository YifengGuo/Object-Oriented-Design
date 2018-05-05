####Adapter Design Pattern
![Adapter in practice](https://github.com/YifengGuo/Object-Oriented-Design/blob/master/src/design_pattern/adapter/Adapter_metaphor.jpg?raw=true)

In the vending machine system, we have Stock class to record the 
mapping between String name and the list of this item. Here item
is an interface, and all the other concrete items implement this
interface

![before applying adapter](https://github.com/YifengGuo/Object-Oriented-Design/blob/master/src/design_pattern/adapter/before_adapter.jpg?raw=true)

However, what if we want to use the Stock to store the coins which
the vending machine get from selling the items, we do not need to 
create another CoinStock class but create a CoinAdapter to make sure
coins can also be stored in the Stock.

![after applying adapter](https://github.com/YifengGuo/Object-Oriented-Design/blob/master/src/design_pattern/adapter/after_adapter.jpg?raw=true)

The CoinAdapter has field of coin and it implements Interface Item,
which has function getItemName(). So in this way, by CoinAdapter, from
stock we can get the list of coins in this vending machine