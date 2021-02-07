# GeekBrains_Course_JavaCoreForAndroid_HW_Lesson_3   
---
### Домашняя работа к занятию №3
Студента GeekBrains ***Веремеенко Дмитрия***    
Факультет: ***Android-разработки***    
Курс: ***Java Core для Android***    
### Задание:
---
- [X] ***Задача №1.***	Полностью разобраться с кодом.    
- [X] ***Задача №2.***	Переделать проверку победы, чтобы она не была реализована просто набором условий.    
- [X] ***Задача №3.***	Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и 
  количества фишек 4 в линию.    
- [X] ***Задача №4.***	Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока,
  и пытаться выиграть сам.    
- [ ] ***Задача №5.***	По желанию! Написать метод, который принимает на вход 2 целых числа, например, x и y.
Внутри метода создаётся целочисленный двумерный массив со сторонами х и у.
Потом этот массив заполняется последовательно инкрементируемыми числами по спирали (или змейкой).
То есть, в позиции [0,0] будет 1, в [0,1] 2 и так далее. Потом по достижении правой границы направление заполнения 
  меняется на вертикальное и так далее. Так что последний заполненный элемент будет посередине массива.    
     
### Отчет о выполнении:
---    
:heavy_check_mark: ***Задача №1.*** Задание выполнено. Разбираясь с кодом, перенес переменные отвечающие за 
размер поля вверх программы, для удобства редактирования и сразу инициализировал.
Изменил сообщения, теперь игра общается с пользователем по русски.    
:heavy_check_mark: ***Задача №2.*** Задание выполнено. Код пока получился длинный и много очень похожих фрагментов,
однако задачу свою он выполняет, количество итераций сокращено до необходимого минимума (алгоритм проверяет,
где находится стартовая точка выигрышной комбинации и инициирует дальнейшую проверку тогда, когда это нужно,
в случае "обрыва" комбинации переходит к другой возможной стартовой точке.    
:heavy_check_mark: ***Задача №3.*** Задание выполнено. Разработанный метод с успехом применим теперь для поля любого
размера, и для выигрышной комбинации любой длины не превышающей размер поля (массива).    
:heavy_check_mark: ***Задача №4.***	Задание выполнено. Добавлен искусственный интеллект, частично блокирующий ходы игрока,
и даже предпринимающий попытки нападения. Для реализации данной задачи разработаны следующие алгоритмы:    
Алгоритм "Шах и мат" - обнаруживает комбинацию из символов AI расположенных в ряд друг за другом в количестве 
достаточном для выигрыша в один ход и выполняет победный ход.    
Алгоритм "Палка о двух концах" обнаруживает опасность поражения в 2 хода и пытается блокировать ее.    
Алгоритм "Прилипала" навязывает свою игру, выполняя очередной ход в непосредственной близости от хода противника, 
выбирая наиболее выгодную позицию.    
Дополнительно реализован механизм подсчета потенциала или баланса сил в клетке хода, для принятия решения о ходе при
наличии нескольких вариантов.    
:clock2: ***Задача №5.***	 - выполняется -       

---   

*StDimensiy 05.02.2021* 
