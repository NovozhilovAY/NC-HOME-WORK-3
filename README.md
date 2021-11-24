# Сравнение производительности коллекций Java
## Описание проведения эксперимента
На оси X отмечено количество элементов в коллекции. 

X1 = 1000,    X2 = 2000,    X3 = 3000,  . . .  , X100 = 100000 

* Для каждого X коллекция заполняется соответствующим колличеством элементов
* Выбранная опперация выполняется 1000 раз
* Вычисляется среднее время выполнения операции, и оно отмечается на оси Y

## 1. Сравнение производительности MyLinkedList и LinkedList 
![](https://github.com/NovozhilovAY/Pictures-and-Gifs-for-readme/blob/main/graphics/mylist/Добавление%20в%20начало.png)
![](https://github.com/NovozhilovAY/Pictures-and-Gifs-for-readme/blob/main/graphics/mylist/добавление%20в%20конец.png)
![](https://github.com/NovozhilovAY/Pictures-and-Gifs-for-readme/blob/main/graphics/mylist/добавление%20в%20середину.png)
![](https://github.com/NovozhilovAY/Pictures-and-Gifs-for-readme/blob/main/graphics/mylist/Доступ%20по%20индексу.png)
![](https://github.com/NovozhilovAY/Pictures-and-Gifs-for-readme/blob/main/graphics/mylist/удаление%20по%20индексу.png)
#### Вывод
На основании графиков, можно сделать вывод, что написанная мной реализация двусвязного списка не уступает по производительности Java реализации.

Наиболее быстро работают операции добавления элемента в начало или конец списка. Сложность O(1), не растет с увеличением количества элементов.

Время доступа\добавления\удаления по индексу линейно увеличивается с ростом количества элементов в коллекции. Сложность O(n).

## 2. Сравнительный анализ производительности основных Java коллекций
### a) Сравнение производительности ArrayList и LinkedList для основных операций
![](https://github.com/NovozhilovAY/Pictures-and-Gifs-for-readme/blob/main/graphics/list/Добавление%20в%20конец.png)
![](https://github.com/NovozhilovAY/Pictures-and-Gifs-for-readme/blob/main/graphics/list/Добавление%20в%20начало.png)
![](https://github.com/NovozhilovAY/Pictures-and-Gifs-for-readme/blob/main/graphics/list/Добавление%20по%20индексу.png)
![](https://github.com/NovozhilovAY/Pictures-and-Gifs-for-readme/blob/main/graphics/list/Удаление%20по%20индексу.png)
![](https://github.com/NovozhilovAY/Pictures-and-Gifs-for-readme/blob/main/graphics/list/Доступ%20по%20индексу.png)
#### Вывод
LinkedList показал значительно лучшую производительность только при добавлении в начало списка. Все остальные операции выполняются медленнее, чем в ArrayList.

Можно сказать, что LinkedList имеет смысл использовать, если преобладающей операцией будет - добавление в начало. Во всех остальных случаях предпочтительнее использовать ArrayList.







